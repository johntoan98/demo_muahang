package com.demomuahang.controller;

import com.demomuahang.models.HoaDon;
import com.demomuahang.models.HoaDonChiTiet;
import com.demomuahang.models.SanPham;
import com.demomuahang.service.impl.HoaDonChiTietServiceImpl;
import com.demomuahang.service.impl.HoaDonServiceImpl;
import com.demomuahang.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    HttpSession httpSession;

    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    HoaDonServiceImpl hoaDonService;

    @Autowired
    HoaDonChiTietServiceImpl hoaDonChiTietService;

    @GetMapping("/addCart")
    public String addCart(@RequestParam int id) {
        SanPham sanPham = sanPhamService.findById(id);
        sanPham.setQuantity(1);
        List<SanPham> sanPhams = (List<SanPham>) httpSession.getAttribute("sanPhams");
        if (sanPhams == null) {
            sanPhams = new ArrayList<>();
        }
        boolean check = false;
        double total = 0;
        for (SanPham sp : sanPhams) {
            if (sp.getId() == id) {
                sp.setQuantity(sp.getQuantity() + 1);
                check = true;
            }
            total += (sp.getPrice() * sp.getQuantity());
        }

        if (!check) {
            sanPhams.add(sanPham);
            total += (sanPham.getPrice() * sanPham.getQuantity());
        }
        httpSession.setAttribute("sanPhams", sanPhams);
        httpSession.setAttribute("total", total);
        return "redirect:/cart/cart";
    }

    @GetMapping("/cart")
    public ModelAndView showCart() {
        ModelAndView modelAndView = new ModelAndView("cart");
        List<SanPham> sanPhams = (List<SanPham>) httpSession.getAttribute("sanPhams");
        modelAndView.addObject("sanphams", sanPhams);
        modelAndView.addObject("total", httpSession.getAttribute("total"));
        return modelAndView;
    }


    @GetMapping("/thanhtoan")
    public String thanhtoan() {
        List<SanPham> sanPhams = (List<SanPham>) httpSession.getAttribute("sanPhams");
        if (sanPhams != null) {
            double total = (double) httpSession.getAttribute("total");
            HoaDon hoaDon = new HoaDon(0, new Date(System.currentTimeMillis()), total);
            hoaDonService.save(hoaDon);
            for (SanPham sp : sanPhams) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(0, sp.getQuantity(), sp, hoaDon);
                hoaDonChiTietService.save(hoaDonChiTiet);

                SanPham sanPham = sanPhamService.findById(sp.getId());
                sanPham.setQuantity(sanPham.getQuantity() - sp.getQuantity());
                sanPhamService.edit(sanPham);
            }
            httpSession.setAttribute("sanPhams", null);
        }
        return "redirect:/sanpham";
    }
}

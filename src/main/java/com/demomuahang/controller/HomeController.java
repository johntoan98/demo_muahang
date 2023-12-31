package com.demomuahang.controller;

import com.demomuahang.models.Account;
import com.demomuahang.models.SanPham;
import com.demomuahang.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/sanpham")
public class HomeController {
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    HttpSession httpSession;

    @GetMapping
    public ModelAndView show(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<SanPham> phams = sanPhamService.getAll(PageRequest.of(page, 2));
        modelAndView.addObject("sanphams", phams);
        Account account = (Account) httpSession.getAttribute("account");
        modelAndView.addObject("account", account);
        return modelAndView;
    }


}

package com.demomuahang.controller;

import com.demomuahang.models.SanPham;
import com.demomuahang.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sanpham")
public class HomeController {
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @GetMapping
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("sanphams", sanPhamService.getAll());
        return modelAndView;
    }


}

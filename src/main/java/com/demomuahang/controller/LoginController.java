package com.demomuahang.controller;

import com.demomuahang.models.Account;
import com.demomuahang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    IAccountService iAccountService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/login")
    public String showLogin(@RequestParam(defaultValue = "no") String error, Model model){
        if (!error.equals("no")){
            model.addAttribute("mess","Account không tồn tại");
        }
        return "account/login";
    }

    @PostMapping("/login")
    public String login(Account account, @CookieValue(defaultValue = "0") int a){
        Account account1 = iAccountService.getAccountLogin(account);
        if (account1 != null){
            httpSession.setAttribute("account",account1);
            if (account1.getRole().getName().equals("ADMIN")){
                return "redirect:/admin";
            }else {
                return "redirect:/sanpham";
            }
        }
        return "redirect:/login?error=true";
    }
}

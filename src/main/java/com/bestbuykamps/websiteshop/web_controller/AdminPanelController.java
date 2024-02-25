package com.bestbuykamps.websiteshop.web_controller;
import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.data_model.CartItem;
import com.bestbuykamps.websiteshop.util.SessionUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    @GetMapping("/panel")
    public String moveToAdminPanel(){
        return "ADMIN_PANEL";
    }

    @GetMapping("/logout")
    public String logoutFromAdminPanel(){
        return "redirect:forward:/";
    }
}

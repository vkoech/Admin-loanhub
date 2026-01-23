package com.loanhubkenya.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalFundings", 12);
        model.addAttribute("totalProposals", 5);
        model.addAttribute("totalLoans", 3);
        model.addAttribute("activePage", "dashboard");
        return "admin/admin-dashboard";
    }


}

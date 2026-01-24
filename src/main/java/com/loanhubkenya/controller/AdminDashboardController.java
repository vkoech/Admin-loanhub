package com.loanhubkenya.controller;


import com.loanhubkenya.service.FundingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    private final FundingService fundingService;

    public AdminDashboardController(FundingService fundingService) {
        this.fundingService = fundingService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalFundings", fundingService.getTotalFundings());
        model.addAttribute("totalProposals", 5);
        model.addAttribute("totalLoans", 3);
        model.addAttribute("activePage", "dashboard");
        return "admin/admin-dashboard";
    }


}

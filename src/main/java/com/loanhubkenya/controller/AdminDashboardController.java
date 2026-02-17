package com.loanhubkenya.controller;


import com.loanhubkenya.enums.RequestStatus;
import com.loanhubkenya.model.Requester;
import com.loanhubkenya.service.FundingService;
import com.loanhubkenya.service.RequesterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    private final FundingService fundingService;
    private final RequesterService requesterService;


    public AdminDashboardController(FundingService fundingService, RequesterService requesterService) {
        this.fundingService = fundingService;
        this.requesterService = requesterService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalFundings", fundingService.getTotalFundings());
        model.addAttribute("totalProposals", requesterService.getTotalProposalsRequests() );
        model.addAttribute("totalLoans", 3);
        model.addAttribute("activePage", "dashboard");
        return "admin/admin-dashboard";
    }

    @GetMapping("/proposal-request")
    public String proposalRequestsLists(Model model) {
        model.addAttribute("proposals", requesterService.getAllProposalRequest());
        model.addAttribute("activePage", "proposal-request");
        return "admin/proposal-list";
    }

    @PostMapping("/{id}/status")
    public String updateStatus(@PathVariable UUID id,
                               @RequestParam("status") RequestStatus status) {
        requesterService.updateStatus(id, status);
        return "redirect:/admin/proposal-request";
    }




}

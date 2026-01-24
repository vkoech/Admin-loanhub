package com.loanhubkenya.controller;

import com.loanhubkenya.model.Funding;
import com.loanhubkenya.service.FundingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/funding")
public class FundingController {

    private final FundingService fundingService;

    public FundingController(FundingService fundingService) {
        this.fundingService = fundingService;
    }

    @GetMapping
    public String listFundings(Model model) {
        model.addAttribute("fundings", fundingService.getAllFundings());
        model.addAttribute("activePage", "funding");
        return "admin/funding-list";
    }

    @GetMapping("/add")
    public String addFundingForm(Model model) {
        model.addAttribute("funding", new Funding());
        model.addAttribute("activePage", "funding");
        return "admin/funding-add";
    }

    @PostMapping("/add")
    public String addFunding(@ModelAttribute Funding funding) {
        if (funding.getId() == null) {
            funding.setId(UUID.randomUUID());
        }
        fundingService.save(funding);
        return "redirect:/admin/funding";
    }

    @GetMapping("/edit/{id}")
    public String editFundingForm(@PathVariable UUID id, Model model) {
        Funding funding = fundingService.getFundingById(id);
        model.addAttribute("funding", funding);
        model.addAttribute("activePage", "funding");
        return "admin/funding-add";
    }

    @GetMapping("/delete/{id}")
    public String deleteFunding(@PathVariable UUID id) {
        fundingService.deleteFunding(id);
        return "redirect:/admin/funding";
    }
}

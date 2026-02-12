package com.loanhubkenya.controller;


import com.loanhubkenya.service.FundingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    private final FundingService fundingService;

    public PublicController(FundingService fundingService) {
        this.fundingService = fundingService;
    }

    @GetMapping("/loan-hub-kenya")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/proposal")
    public String proposal() {
        return "proposal";
    }

    @GetMapping("/inquiry")
    public String inquiry() {
        return "inquiry";
    }

    @GetMapping("/funding")
    public String listFundings(Model model) {
        model.addAttribute("fundings", fundingService.getAllActiveFundings());
        model.addAttribute("activePage", "funding");
        return "funding";
    }

}

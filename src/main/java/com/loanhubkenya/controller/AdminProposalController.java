package com.loanhubkenya.controller;

import com.loanhubkenya.model.Proposal;
import com.loanhubkenya.model.ProposalType;
import com.loanhubkenya.service.ProposalService;
import com.loanhubkenya.service.ProposalTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminProposalController {

    private final ProposalTypeService proposalTypeService;
    private final ProposalService proposalService;

    @GetMapping("/proposal-management")
    public String proposalManagementPage(Model model) {

        model.addAttribute("proposalType", new ProposalType());
        model.addAttribute("proposalTypes", proposalTypeService.getAllProposalTypes());

        model.addAttribute("proposal", new Proposal());
        model.addAttribute("proposals", proposalService.getAllProposals());
        model.addAttribute("allProposalTypes", proposalTypeService.getAllProposalTypes());

        model.addAttribute("activePage", "proposal-management");

        return "admin/admin-proposal-management";
    }

    @PostMapping("/proposal-types/save")
    public String saveProposalType(@ModelAttribute ProposalType proposalType) {
        proposalTypeService.save(proposalType);
        return "redirect:/admin/proposal-management";
    }

    @GetMapping("/proposal-types/delete/{id}")
    public String deleteProposalType(@PathVariable UUID id) {
        proposalTypeService.deleteProposalType(id);
        return "redirect:/admin/proposal-management";
    }

    @PostMapping("/proposals/save")
    public String saveProposal(@ModelAttribute Proposal proposal,
                               @RequestParam UUID proposalTypeId) {

        proposal.setProposalType(proposalTypeService.getProposalTypeById(proposalTypeId));
        proposalService.save(proposal);

        return "redirect:/admin/proposal-management";
    }

    @GetMapping("/proposals/delete/{id}")
    public String deleteProposal(@PathVariable UUID id) {
        proposalService.deleteProposal(id);
        return "redirect:/admin/proposal-management";
    }
}

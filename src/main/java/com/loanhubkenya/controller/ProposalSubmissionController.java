package com.loanhubkenya.controller;


import com.loanhubkenya.model.Requester;
import com.loanhubkenya.service.ProposalService;
import com.loanhubkenya.service.RequesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/proposals")
public class ProposalSubmissionController {

    private final ProposalService proposalService;
    private final RequesterService requesterService;

    @GetMapping("/apply")
    public String showProposalForm(Model model) {
        model.addAttribute("requester", new Requester());
        model.addAttribute("proposals", proposalService.getAllProposals());
        return "apply";
    }

    @PostMapping("/apply")
    public String submitProposal(@ModelAttribute Requester requester,
                                 @RequestParam UUID proposalId) {

        requester.setProposal(proposalService.getProposalById(proposalId));
        requesterService.save(requester);

        return "redirect:/thank-you";
    }

    @GetMapping("/thank-you")
    public String thankYouPage() {
        return "thank-you";
    }
}

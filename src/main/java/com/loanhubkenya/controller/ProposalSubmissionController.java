package com.loanhubkenya.controller;

import com.loanhubkenya.model.Funding;
import com.loanhubkenya.model.Requester;
import com.loanhubkenya.service.ProposalService;
import com.loanhubkenya.service.RequesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/proposals")
public class ProposalSubmissionController {

    private final ProposalService proposalService;
    private final RequesterService requesterService;

    @GetMapping("/request")
    public String showApplyPage(
            @RequestParam(required = false) String filterEmail,
            @RequestParam(required = false, defaultValue = "apply") String activeTab,
            Model model
    ) {
        model.addAttribute("requester", new Requester());
        model.addAttribute("proposals", proposalService.getAllProposals());

        List<Requester> requesters = List.of();
        if (filterEmail != null && !filterEmail.isBlank()) {
            requesters = requesterService.findByEmail(filterEmail);
        }

        model.addAttribute("requesters", requesters);
        model.addAttribute("filterEmail", filterEmail);
        model.addAttribute("activeTab", activeTab);
        return "apply";
    }

    @PostMapping("/request")
    public String submitApplication(
            @ModelAttribute Requester requester,
            @RequestParam UUID proposalId,
            Model model
    ) {
        requester.setProposal(proposalService.getProposalById(proposalId));
        requesterService.save(requester);

        List<Requester> requesters = requesterService.findByEmail(requester.getEmail());
        model.addAttribute("requesters", requesters);
        model.addAttribute("filterEmail", requester.getEmail());
        model.addAttribute("requester", new Requester());
        model.addAttribute("proposals", proposalService.getAllProposals());
        model.addAttribute("activeTab", "track");

        return "apply";
    }

}

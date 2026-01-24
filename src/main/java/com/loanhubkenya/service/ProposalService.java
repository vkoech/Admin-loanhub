package com.loanhubkenya.service;

import com.loanhubkenya.model.Proposal;

import java.util.List;
import java.util.UUID;

public interface ProposalService {

    Proposal save(Proposal proposal);

    List<Proposal> getAllProposals();

    Proposal getProposalById(UUID id);

    void deleteProposal(UUID id);

    long getTotalProposals();
}

package com.loanhubkenya.service;

import com.loanhubkenya.model.ProposalType;

import java.util.List;
import java.util.UUID;

public interface ProposalTypeService {
    ProposalType save(ProposalType proposalType);

    List<ProposalType> getAllProposalTypes();

    ProposalType getProposalTypeById(UUID id);

    void deleteProposalType(UUID id);

    long getTotalProposalTypes();
}

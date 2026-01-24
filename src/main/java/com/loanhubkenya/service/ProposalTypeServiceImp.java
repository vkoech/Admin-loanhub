package com.loanhubkenya.service;

import com.loanhubkenya.model.ProposalType;
import com.loanhubkenya.repository.ProposalTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProposalTypeServiceImp implements ProposalTypeService {

    private final ProposalTypeRepository proposalTypeRepository;


    @Override
    public ProposalType save(ProposalType proposalType) {
        return proposalTypeRepository.save(proposalType);
    }

    @Override
    public List<ProposalType> getAllProposalTypes() {
        return proposalTypeRepository.findAll();
    }

    @Override
    public ProposalType getProposalTypeById(UUID id) {
        return proposalTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposal type not found"));
    }

    @Override
    public void deleteProposalType(UUID id) {
        proposalTypeRepository.deleteById(id);
    }

    @Override
    public long getTotalProposalTypes() {
        return proposalTypeRepository.count();
    }
}

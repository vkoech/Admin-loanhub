package com.loanhubkenya.service;

import com.loanhubkenya.model.Proposal;
import com.loanhubkenya.repository.ProposalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor

public class ProposalServiceImp implements ProposalService{

    private final ProposalRepository proposalRepository;

    @Override
    public Proposal save(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    @Override
    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    @Override
    public Proposal getProposalById(UUID id) {
        return proposalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposal not found"));
    }

    @Override
    public void deleteProposal(UUID id) {
        proposalRepository.deleteById(id);
    }

    @Override
    public long getTotalProposals() {
        return 0;
    }
}

package com.loanhubkenya.repository;

import com.loanhubkenya.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, UUID> {
    long countByProposalType_Name(String name);
}

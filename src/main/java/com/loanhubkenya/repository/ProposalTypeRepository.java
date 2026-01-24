package com.loanhubkenya.repository;

import com.loanhubkenya.model.ProposalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProposalTypeRepository extends JpaRepository<ProposalType, UUID> {
    boolean existsByName(String name);
}

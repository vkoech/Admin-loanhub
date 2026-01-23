package com.loanhubkenya.repository;

import com.loanhubkenya.model.Funding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FundingRepository extends JpaRepository<Funding, UUID> {

}

package com.loanhubkenya.repository;

import com.loanhubkenya.model.Funding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface FundingRepository extends JpaRepository<Funding, UUID> {
    boolean existsByTitle(String title);
    List<Funding> findByActiveTrue();
}

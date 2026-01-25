package com.loanhubkenya.repository;

import com.loanhubkenya.model.Requester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequesterRepository extends JpaRepository<Requester, UUID> {

}

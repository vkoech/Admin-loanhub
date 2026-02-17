package com.loanhubkenya.repository;

import com.loanhubkenya.enums.RequestStatus;
import com.loanhubkenya.model.Requester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RequesterRepository extends JpaRepository<Requester, UUID> {
    List<Requester> findByEmailIgnoreCase(String email);
    List<Requester> findByStatus(RequestStatus status);
}

package com.loanhubkenya.service;

import com.loanhubkenya.enums.RequestStatus;
import com.loanhubkenya.model.Requester;

import java.util.List;
import java.util.UUID;

public interface RequesterService {
    Requester save(Requester requester);
    List<Requester> findByEmail(String email);
    List<Requester> getAllProposalRequest();
    long getTotalProposalsRequests();
    List<Requester> getRequestsByStatus(RequestStatus status);
    void updateStatus(UUID id, RequestStatus status);
}

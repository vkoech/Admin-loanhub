package com.loanhubkenya.service;


import com.loanhubkenya.enums.RequestStatus;
import com.loanhubkenya.model.Requester;
import com.loanhubkenya.repository.RequesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequesterServiceImpl implements RequesterService {

    private final RequesterRepository requesterRepository;

    @Override
    public Requester save(Requester requester) {
        if (requester.getStatus() == null) {
            requester.setStatus(RequestStatus.PENDING);
        }
        return requesterRepository.save(requester);
    }

    @Override
    public List<Requester> findByEmail(String email) {
        return requesterRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public List<Requester> getAllProposalRequest() {
        return requesterRepository.findAll();
    }

    @Override
    public long getTotalProposalsRequests() {
        return requesterRepository.count();
    }

    @Override
    public List<Requester> getRequestsByStatus(RequestStatus status) {
        return requesterRepository.findByStatus(status);
    }

    @Override
    public void updateStatus(UUID id, RequestStatus status) {
        Requester requester = requesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requester not found"));
        requester.setStatus(status);
        requesterRepository.save(requester);
    }


}

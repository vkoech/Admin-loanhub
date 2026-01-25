package com.loanhubkenya.service;


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
        return requesterRepository.save(requester);
    }

    @Override
    public List<Requester> getAllRequesters() {
        return requesterRepository.findAll();
    }

    @Override
    public Requester getRequesterById(UUID id) {
        return requesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requester not found"));
    }

}

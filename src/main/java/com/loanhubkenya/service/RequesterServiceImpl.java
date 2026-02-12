package com.loanhubkenya.service;


import com.loanhubkenya.model.Requester;
import com.loanhubkenya.repository.RequesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequesterServiceImpl implements RequesterService {

    private final RequesterRepository requesterRepository;

    @Override
    public Requester save(Requester requester) {
        requesterRepository.save(requester);
        return requester;
    }

    @Override
    public List<Requester> findByEmail(String email) {
        return requesterRepository.findByEmailIgnoreCase(email);
    }

}

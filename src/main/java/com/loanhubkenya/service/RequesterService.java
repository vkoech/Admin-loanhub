package com.loanhubkenya.service;

import com.loanhubkenya.model.Requester;

import java.util.List;
import java.util.UUID;

public interface RequesterService {
    Requester save(Requester requester);
    List<Requester> getAllRequesters();
    Requester getRequesterById(UUID id);
}

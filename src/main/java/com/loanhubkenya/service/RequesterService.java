package com.loanhubkenya.service;

import com.loanhubkenya.model.Requester;

import java.util.List;

public interface RequesterService {
    Requester save(Requester requester);
    List<Requester> findByEmail(String email);
}

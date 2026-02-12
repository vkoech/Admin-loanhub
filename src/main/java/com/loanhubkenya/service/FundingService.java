package com.loanhubkenya.service;

import com.loanhubkenya.model.Funding;

import java.util.List;
import java.util.UUID;

public interface FundingService {
    Funding save(Funding funding);
    List<Funding> getAllFundings();
    Funding getFundingById(UUID id);
    void deleteFunding(UUID id);
    long getTotalFundings();
    List<Funding> getAllActiveFundings();
}

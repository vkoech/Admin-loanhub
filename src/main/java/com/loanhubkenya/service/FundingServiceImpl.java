package com.loanhubkenya.service;

import com.loanhubkenya.model.Funding;
import com.loanhubkenya.repository.FundingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FundingServiceImpl implements FundingService {

    private final FundingRepository fundingRepository;

    public FundingServiceImpl(FundingRepository fundingRepository) {
        this.fundingRepository = fundingRepository;
    }

    @Override
    public Funding save(Funding funding) {
        return fundingRepository.save(funding);
    }

    @Override
    public List<Funding> getAllFundings() {
        return fundingRepository.findAll();
    }

    @Override
    public Funding getFundingById(UUID id) {
        return fundingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funding not found"));
    }

    @Override
    public void deleteFunding(UUID id) {
        fundingRepository.deleteById(id);
    }

    @Override
    public long getTotalFundings() {
        return fundingRepository.count();
    }

    @Override
    public List<Funding> getAllActiveFundings() {
        return fundingRepository.findByActiveTrue();
    }
}


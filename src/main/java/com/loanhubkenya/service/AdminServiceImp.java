package com.loanhubkenya.service;

import com.loanhubkenya.model.Admin;
import com.loanhubkenya.repository.AdminRepository;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImp implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImp(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username).orElse(null);
    }
}

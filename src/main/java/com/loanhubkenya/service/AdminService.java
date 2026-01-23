package com.loanhubkenya.service;

import com.loanhubkenya.model.Admin;

public interface AdminService {

    Admin findByUsername(String username);
}

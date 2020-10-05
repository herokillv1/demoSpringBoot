package com.example.demo.services;

import com.example.demo.models.Role;

public interface RoleService {
    Iterable<Role> findAll();

    Role getRoleUser();
}

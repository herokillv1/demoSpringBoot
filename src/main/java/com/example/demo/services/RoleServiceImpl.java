package com.example.demo.services;

import com.example.demo.models.Role;
import com.example.demo.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService{
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Iterable<Role> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Role getRoleUser() {
        return iRoleRepository.findById(1L).orElse(null);
    }
}

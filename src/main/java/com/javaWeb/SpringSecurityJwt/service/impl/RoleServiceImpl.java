package com.javaWeb.SpringSecurityJwt.service.impl;

import com.javaWeb.SpringSecurityJwt.entity.ERole;
import com.javaWeb.SpringSecurityJwt.entity.Role;
import com.javaWeb.SpringSecurityJwt.repository.RoleRepository;
import com.javaWeb.SpringSecurityJwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}

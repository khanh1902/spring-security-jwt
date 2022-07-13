package com.javaWeb.SpringSecurityJwt.service;

import com.javaWeb.SpringSecurityJwt.entity.ERole;
import com.javaWeb.SpringSecurityJwt.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleService {
    Optional<Role> findByName(ERole name);
}

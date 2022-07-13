package com.javaWeb.SpringSecurityJwt.repository;

import com.javaWeb.SpringSecurityJwt.entity.ERole;
import com.javaWeb.SpringSecurityJwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

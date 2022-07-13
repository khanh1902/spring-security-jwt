package com.javaWeb.SpringSecurityJwt.service;

import com.javaWeb.SpringSecurityJwt.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User findByUserName(String userName);
    Optional<User> findUserName(String userName);
    List<User> findALlByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
    User save(User user);
}

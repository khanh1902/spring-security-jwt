package com.javaWeb.SpringSecurityJwt.dto.request;

import com.javaWeb.SpringSecurityJwt.entity.Role;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String fullName;

    private Set<String> roles;

    // getter and setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}

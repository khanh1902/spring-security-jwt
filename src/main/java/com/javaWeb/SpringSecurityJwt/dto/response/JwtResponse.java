package com.javaWeb.SpringSecurityJwt.dto.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String userName;
    private String fullName;
    private String email;
    private List<String> roles;

    // constructor
    public JwtResponse(String token, Long id, String userName, String fullName, String email, List<String> roles) {
        this.token = token;
        this.type = type;
        this.email = email;
        this.fullName = fullName;
        this.id = id;
        this.userName = userName;
        this.roles = roles;
    }

    // getter and setter

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

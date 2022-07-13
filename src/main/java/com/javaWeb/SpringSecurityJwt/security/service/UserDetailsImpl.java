package com.javaWeb.SpringSecurityJwt.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaWeb.SpringSecurityJwt.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
* Mặc định Spring Security sử dụng một đối tượng UserDetails để chứa toàn bộ thông tin về người dùng.
* Vì vậy, chúng ta cần tạo ra một class mới giúp chuyển các thông tin của User thành UserDetails
*/
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String userName;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    // constructor
    public UserDetailsImpl(Long id, String userName, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    // Build user for userDetail
    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList()); // collect thực hiện -> map mới được thực hiện
        return new UserDetailsImpl(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                authorities);
    }

    // getter and setter
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}

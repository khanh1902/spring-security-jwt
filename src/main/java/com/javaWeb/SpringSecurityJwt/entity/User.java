package com.javaWeb.SpringSecurityJwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // quan hệ n-n với đối tượng ở dưới (Role) (1 user có nhiều quyền)
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "userid"), // khóa ngoại chính là userid trỏ tới class hiện tại (User)
                inverseJoinColumns = @JoinColumn(name = "roleid")) // Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Role)
    private Set<Role> roles = new HashSet<>();

    // constructor
    public User() {
    }

    public User(String userName, String password, String fullName, String email) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    // getter and setter
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

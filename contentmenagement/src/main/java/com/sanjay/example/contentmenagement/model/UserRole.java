/*
 * Author Name:
 * Date: 11/28/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.sanjay.example.contentmenagement.model;



import javax.persistence.*;

@Entity

public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;

    //user
@ManyToOne(fetch = FetchType.EAGER)
    private User user;

@ManyToOne
    private Role role;

    public UserRole() {
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public UserRole setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserRole setUser(User user) {
        this.user = user;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }
}

package com.existmaster.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by existmaster on 2015. 6. 18..
 */
@Entity
public class User {
    @Id
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column
    private String sex;

    @Column
    private String nickname;

    @Column
    private String email;

    public User() {
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User(String userid, String password, String sex, String nickname, String email) {
        this.userId = userid;
        this.password = password;
        this.sex = sex;
        this.nickname = nickname;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

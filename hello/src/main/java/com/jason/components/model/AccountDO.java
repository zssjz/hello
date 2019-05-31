package com.jason.components.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by BNC on 2019/4/30.
 */
@Entity
@Table(name = "basic_account")
@org.hibernate.annotations.Table(appliesTo = "basic_account", comment = "账号基础信息表")
@NamedEntityGraph(name = "AccountDO.detail", attributeNodes = @NamedAttributeNode("userDO"))
public class AccountDO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "userDO"))
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "USER_ID")
    private String userId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @PrimaryKeyJoinColumn
    private UserDO userDO;

    @Column(name = "USERNAME", nullable = true)
    private String username;

    @Column(name = "PASSWORD", nullable = true)
    private String password;

    public AccountDO() {
    }

    public AccountDO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccountDO(UserDO userDO, String username, String password) {
        this.userDO = userDO;
        this.username = username;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

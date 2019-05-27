package com.jason.components.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by BNC on 2019/4/30.
 */
@Entity
@javax.persistence.Table(name = "basic_user")
@org.hibernate.annotations.Table(appliesTo = "basic_user", comment = "用户基础信息")
public class UserDO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "USER_ID", length = 32)
    private String userId;

    @JsonIgnoreProperties(value = {"password"})
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDO", optional = false)
//    @JoinColumn(name = "USER_ID")
    @PrimaryKeyJoinColumn
    private AccountDO accountDO;

    @Column(name = "NICKNAME", unique = true, length = 32)
    private String nickname;

    public UserDO(String nickname) {
        this.nickname = nickname;
    }

    public UserDO(String userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }

    public UserDO(AccountDO accountDO, String nickname) {
        this.accountDO = accountDO;
        this.nickname = nickname;
    }

    public UserDO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public AccountDO getAccountDO() {
        return accountDO;
    }

    public void setAccountDO(AccountDO accountDO) {
        this.accountDO = accountDO;
    }
}

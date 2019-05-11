package com.jason.components.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by BNC on 2019/4/30.
 */
@ApiModel(value = "账号基础信息")
@Validated
@Entity
@Table(name = "basic_account")
@org.hibernate.annotations.Table(appliesTo = "basic_account", comment = "账号基础信息表")
public class AccountDO {

    public interface AccountSimpleView {};

    public interface AccountDetailView extends AccountSimpleView {};

    public interface accountCreateValidate {};

    public interface accountModifyValidate {};

    @ApiModelProperty(name = "accountId", value = "账号Id", hidden = true)
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "ACCOUNT_ID", length = 32)
    private String accountId;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "accountDO", fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserDO userDO;

    @NotEmpty(message = "用户名不能为空", groups = accountCreateValidate.class)
    @Size(min = 6, max = 30, message = "用户名长度不小于6位，不大于30位")
    @ApiModelProperty(name = "username", value = "账号", dataType = "String", required = true)
    private String username;

    @NotEmpty(message = "密码不能为空", groups = {accountModifyValidate.class, accountCreateValidate.class})
    @Size(min = 6, max = 128, message = "密码加密失败")
    @ApiModelProperty(name = "password", value = "密码", dataType = "String", required = true)
    private String password;

    @Column(name = "IS_ACCOUNT_EXPIRED", columnDefinition = "CHAR(1) NOT NULL DEFAULT '1' COMMENT '账号 0：过期；1：未过期'")
    @ApiModelProperty(name = "isAccountNonExpired", value = "账号是否过期", hidden = true)
    private Integer isAccountNonExpired;

    @Column(name = "IS_ACCOUNT_LOCKED", columnDefinition = "CHAR(1) NOT NULL DEFAULT '1' COMMENT '账号 0：锁定；1：未锁定'")
    @ApiModelProperty(name = "isAccountNonLocked", value = "账号是否锁定", hidden = true)
    private Integer isAccountNonLocked;

    @Column(name = "IS_CREDENTIALS_EXPIRED", columnDefinition = "CHAR(1) NOT NULL DEFAULT '1' COMMENT '密码 0：已过期；1：未过期'")
    @ApiModelProperty(name = "isCredentialsNonExpired", value = "密码是否过期", hidden = true)
    private Integer isCredentialsNonExpired;

    @Column(name = "IS_ENABLE", columnDefinition = "CHAR(1) NOT NULL DEFAULT '1' COMMENT '账号 0：不可用；1：可用'")
    @ApiModelProperty(name = "isEnabled", value = "账号是否可用", hidden = true)
    private Integer isEnabled;

    @Column(name = "IS_DELETE", columnDefinition = "CHAR(1) NOT NULL DEFAULT '1' COMMENT '账号 0：已删除；1：未删除'")
    @ApiModelProperty(name = "isDelete", value = "账号是否删除", hidden = true)
    private Integer isDelete;

    @ApiModelProperty(name = "createTimestamp", value = "创建时间")
    @Column(name = "CREATE_TIMESTAMP", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Long createTimestamp;

    public AccountDO() {
    }

    public AccountDO(@NotEmpty(message = "用户名不能为空", groups = accountCreateValidate.class) @Size(min = 6, max = 30, message = "用户名长度不小于6位，不大于30位") String username, @NotEmpty(message = "密码不能为空", groups = {accountModifyValidate.class, accountCreateValidate.class}) String password) {
        this.username = username;
        this.password = password;
    }

    public AccountDO(@NotEmpty(message = "用户名不能为空", groups = accountCreateValidate.class) @Size(min = 6, max = 30, message = "用户名长度不小于6位，不大于30位") String username, @NotEmpty(message = "密码不能为空", groups = {accountModifyValidate.class, accountCreateValidate.class}) String password, Long createTimestamp) {
        this.username = username;
        this.password = password;
        this.createTimestamp = createTimestamp;
    }

    public AccountDO(@NotEmpty(groups = accountModifyValidate.class) String accountId, @NotEmpty(message = "用户名不能为空", groups = accountCreateValidate.class) @Size(min = 6, max = 30, message = "账号长度不小于6位，不大于30位") String username, @NotEmpty(message = "密码不能为空", groups = {accountModifyValidate.class, accountCreateValidate.class}) @Size(min = 6, max = 30, message = "密码长度不少于6位，不大于30位") String password) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

    public AccountDO(@NotEmpty(groups = accountModifyValidate.class) String accountId, @NotEmpty(message = "用户名不能为空", groups = accountCreateValidate.class) @Size(min = 6, max = 30, message = "账号长度不小于6位，不大于30位") String username, @NotEmpty(message = "密码不能为空", groups = {accountModifyValidate.class, accountCreateValidate.class}) @Size(min = 6, max = 30, message = "密码长度不少于6位，不大于30位") String password, Integer isAccountNonExpired, Integer isAccountNonLocked, Integer isCredentialsNonExpired, Integer isEnabled, Integer isDelete, Long createTimestamp) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.isDelete = isDelete;
        this.createTimestamp = createTimestamp;
    }

    @JsonView(AccountDetailView.class)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonView(AccountSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // 密码禁止纳入到JsonView中
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(AccountDetailView.class)
    public Integer getIsAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setIsAccountNonExpired(Integer isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    @JsonView(AccountDetailView.class)
    public Integer getIsAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setIsAccountNonLocked(Integer isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    @JsonView(AccountDetailView.class)
    public Integer getIsCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setIsCredentialsNonExpired(Integer isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    @JsonView(AccountDetailView.class)
    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    @JsonView(AccountDetailView.class)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @JsonView(AccountDetailView.class)
    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    @Override
    public String toString() {
        return "AccountDO{" +
                "accountId='" + accountId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                ", isDelete=" + isDelete +
                ", createTimestamp=" + createTimestamp +
                ", userDO=" + userDO +
                '}';
    }
}

package com.jason.components.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by BNC on 2019/4/30.
 */
//@ApiModel(value = "账号基础信息")
//@Validated
//@Entity
//@Table(name = "base_account")
//@org.hibernate.annotations.Table(appliesTo = "base_account", comment = "账号基础信息表")
public class AccountDO {

    public interface accountSimpleView {};

    public interface accountDetailView extends accountSimpleView {};

    public interface accountCreateValidate {};

    public interface accountModifyValidate {};

//    @NotEmpty(groups = accountModifyValidate.class)
//    @ApiModelProperty(name = "accountId", value = "账号Id", hidden = true)
//    @Id
//    @GenericGenerator(name = "accountId", strategy = "uuid")
//    @GeneratedValue(generator = "accountId")
//    @OneToOne(mappedBy = "accountDO")
//    @Column(name = "ACCOUNT_ID", length = 32)
    private String accountId;

//    @NotEmpty(message = "用户名不能为空", groups = accountCreateValidate.class)
//    @Size(min = 6, max = 30, message = "用户名长度不小于6位，不大于30位")
//    @ApiModelProperty(name = "username", value = "账号", dataType = "String", required = true)
    private String username;

//    @NotEmpty(message = "密码不能为空", groups = {accountModifyValidate.class, accountCreateValidate.class})
//    @Size(min = 6, max = 30, message = "密码长度不少于6位，不大于30位")
//    @ApiModelProperty(name = "password", value = "密码", dataType = "String", required = true)
    private String password;

//    @Column(name = "IS_ACCOUNT_EXPRIED")
//    @ApiModelProperty(name = "isAccountNonExpired", value = "账号是否过期", hidden = true)
    private Integer isAccountNonExpired;

//    @Column(name = "IS_ACCOUNT_LOCKED")
//    @ApiModelProperty(name = "isAccountNonLocked", value = "账号是否锁定", hidden = true)
    private Integer isAccountNonLocked;

//    @Column(name = "IS_CREDENTIALS_EXPRIED")
//    @ApiModelProperty(name = "isCredentialsNonExpired", value = "密码是否过期", hidden = true)
    private Integer isCredentialsNonExpired;

//    @Column(name = "IS_ENABLE")
//    @ApiModelProperty(name = "isEnabled", value = "账号是否可用", hidden = true)
    private Integer isEnabled;

//    @Column(name = "IS_DELETE")
//    @ApiModelProperty(name = "isDelete", value = "账号是否删除", hidden = true)
    private Integer isDelete;

//    @Column(name = "CREATE_TIMESTAMP")
//    @ApiModelProperty(name = "createTimestamp", value = "创建时间")
    private Long createTimestamp;

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

    @JsonView(accountDetailView.class)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonView(accountSimpleView.class)
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

    @JsonView(accountDetailView.class)
    public Integer getIsAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setIsAccountNonExpired(Integer isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    @JsonView(accountDetailView.class)
    public Integer getIsAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setIsAccountNonLocked(Integer isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    @JsonView(accountDetailView.class)
    public Integer getIsCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setIsCredentialsNonExpired(Integer isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    @JsonView(accountDetailView.class)
    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    @JsonView(accountDetailView.class)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @JsonView(accountDetailView.class)
    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
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
                '}';
    }
}

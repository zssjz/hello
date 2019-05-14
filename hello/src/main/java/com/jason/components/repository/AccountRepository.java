package com.jason.components.repository;

import com.jason.components.model.AccountDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by BNC on 2019/5/6.
 */
public interface AccountRepository extends JpaRepository<AccountDO, String> {

    /**
     * 设置账号过期
     * @param accountId
     * @return
     */
    @Modifying
    @Query("UPDATE AccountDO SET isAccountNonExpired = '0' WHERE accountId = ?1")
    int setAccountExpired(String accountId);

    /**
     * 设置账号锁定
     * @param accountId
     * @return
     */
    @Modifying
    @Query("UPDATE AccountDO SET isAccountNonLocked = '0' WHERE accountId = :accountId")
    int setAccountLocked(String accountId);

    /**
     * 设置密码过期
     * @param accountId
     * @return
     */
    @Modifying
    @Query("UPDATE AccountDO SET isCredentialsNonExpired = '0' WHERE accountId = ?1")
    int setCredemtialEXPIRED(String accountId);

    /**
     * 账号不可用
     * @param accountId
     * @return
     */
    @Modifying
    @Query("UPDATE AccountDO SET isEnabled = '0' WHERE accountId = :accountId")
    int setAccountEnable(String accountId);

    /**
     * 删除账号
     * @param accountId
     * @return
     */
    @Modifying
    @Query("UPDATE AccountDO SET isDelete = '0' WHERE accountId = ?1")
    int deleteAccount(String accountId);
}

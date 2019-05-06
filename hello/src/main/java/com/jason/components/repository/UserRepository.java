package com.jason.components.repository;

import com.jason.components.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by BNC on 2019/5/6.
 */
public interface UserRepository extends JpaRepository<UserDO, String> {
}

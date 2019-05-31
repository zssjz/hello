package com.jason.components.repository;

import com.jason.components.model.PersonDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by BNC on 2019/5/31.
 */
public interface PersonRepo extends JpaRepository<PersonDO, String> {
}

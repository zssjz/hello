package com.jason.components.repository;

import com.jason.components.model.NationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by BNC on 2019/4/16.
 */
public interface NationRepository extends JpaRepository<NationDO, String>, JpaSpecificationExecutor {
}

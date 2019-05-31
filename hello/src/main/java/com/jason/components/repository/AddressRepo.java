package com.jason.components.repository;

import com.jason.components.model.AddressDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by BNC on 2019/5/31.
 */
public interface AddressRepo extends JpaRepository<AddressDO, String> {
}

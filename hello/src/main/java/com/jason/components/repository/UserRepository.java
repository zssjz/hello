package com.jason.components.repository;

import com.jason.components.model.UserDO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by BNC on 2019/5/6.
 */
public interface UserRepository extends JpaRepository<UserDO, String> {

//    @EntityGraph(value = "UserDO.detail", type = EntityGraph.EntityGraphType.LOAD)
    @EntityGraph(attributePaths = {"accountDO"})
    UserDO findUserDOByUserId(String userId);

    @EntityGraph(value = "UserDO.detail", type = EntityGraph.EntityGraphType.LOAD)
    UserDO getUserDOByUserId(String userId);

    @EntityGraph(value = "UserDO.detail", type = EntityGraph.EntityGraphType.LOAD)
    UserDO getByUserId(String userd);

}

package com.bo.cabmvc.repo;


import com.bo.cabmvc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    @Query(
            nativeQuery = true,
            value ="select * from role where name = ?1"
    )
    Role findByName(String name);


}

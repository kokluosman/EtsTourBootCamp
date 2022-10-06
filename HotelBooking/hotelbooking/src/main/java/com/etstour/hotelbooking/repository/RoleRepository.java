package com.etstour.hotelbooking.repository;

import com.etstour.hotelbooking.entitiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String roleName);
}

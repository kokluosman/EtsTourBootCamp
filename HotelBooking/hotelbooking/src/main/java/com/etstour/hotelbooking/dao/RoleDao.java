package com.etstour.hotelbooking.dao;

import com.etstour.hotelbooking.entitiy.Role;

//DAO Pattern for Role
public interface RoleDao {

    public Role findRoleByName(String roleName);
}

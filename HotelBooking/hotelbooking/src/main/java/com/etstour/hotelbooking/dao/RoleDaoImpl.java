package com.etstour.hotelbooking.dao;


import com.etstour.hotelbooking.entitiy.Role;
import com.etstour.hotelbooking.entitiy.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RoleDaoImpl implements RoleDao{

    private static EntityManager entityManager;

    private Session currentSession(){
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Role findRoleByName(String roleName) {
        //create query with HQL to get user
        Query<Role> query = currentSession().createQuery(" FROM Role Where name = :roleName", Role.class);
        query.setParameter("roleName",roleName);

        //check if valid user and is exist or null

        Role role =null;
        try {
            role = query.getSingleResult();
        }catch (Exception e){
            role = null;
        }

        return role;
    }


}

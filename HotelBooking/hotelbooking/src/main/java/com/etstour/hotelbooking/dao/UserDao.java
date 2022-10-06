package com.etstour.hotelbooking.dao;

import com.etstour.hotelbooking.entitiy.User;

//DAO Pattern for User
public interface UserDao {
    public User findUserByEmail(String email);

    public User findUserByUsername(String username);

    public void saveUser(User user);
}

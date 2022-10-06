package com.etstour.hotelbooking.services;

import com.etstour.hotelbooking.entitiy.User;
import com.etstour.hotelbooking.temp.CurrentUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findUserByEmail(String email);

    public void saveUser(CurrentUser currentUser);

    public int getLoggedUserId();

}

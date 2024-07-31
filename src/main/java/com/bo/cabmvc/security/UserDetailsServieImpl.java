package com.bo.cabmvc.security;

import com.bo.cabmvc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Ozads
 * @version v1.0
 * @project cab demo
 * @since 2024-07-18
 **/
@Component
public class UserDetailsServieImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.getUserByUserName(username);
    }
}

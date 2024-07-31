package com.bo.cabmvc.config;

import com.bo.cabmvc.entity.Role;
import com.bo.cabmvc.entity.User;
import com.bo.cabmvc.repo.RoleRepo;
import com.bo.cabmvc.repo.UserRepo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
@Slf4j
public class InitDBConfig {
    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void insert(){
        if(roleRepo.findAll().size()==0) {
            Role admin = Role.builder()
                    .name("ADMIN")
                    .description("administrator")
                    .build();
            roleRepo.save(admin);
            log.info("ADMIN role saved");

            Role user = Role.builder()
                    .name("USER")
                    .description("app user")
                    .build();
            roleRepo.save(user);
            log.info("USER role saved");
        }
        else log.info("Roles already created");

        if(userRepo.findAll().size()==0) {
            User dbUser = User.builder()
                    .fullName("App Admin")
                    .password(new BCryptPasswordEncoder().encode("admin"))
                    .username("admin")
                    .roles(Arrays.asList(roleRepo.findByName("ADMIN")))
                    .build();
            userRepo.save(dbUser);
            log.info("Admin user created");

            User user = User.builder()
                .fullName("App Admin")
                .password(new BCryptPasswordEncoder().encode("user"))
                .username("user")
                .roles(Arrays.asList(roleRepo.findByName("USER")))
                .build();
            userRepo.save(user);
            log.info("User user created");
        }
        else log.info("Admin user already exists");
    }
}

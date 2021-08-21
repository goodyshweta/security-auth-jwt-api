package com.preet.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityAuthJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityAuthJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new RoleEntity(null, "ROLE_USER"));
            userService.saveRole(new RoleEntity(null, "ROLE_MANAGER"));
            userService.saveRole(new RoleEntity(null, "ROLE_ADMIN"));
            userService.saveRole(new RoleEntity(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new UserEntity(null, "John Travolta", "john", "1234", true, new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "Will Smith", "will", "1234", true, new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "Jim Carry", "jim", "1234", true, new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "Arnold Schwarzenegger", "arnold", "1234", true, new ArrayList<>()));

            userService.addRoleToUser("john","ROLE_USER");
            userService.addRoleToUser("john","ROLE_MANAGER");
            userService.addRoleToUser("will","ROLE_MANAGER");
            userService.addRoleToUser("jim","ROLE_ADMIN");
            userService.addRoleToUser("arnold","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("arnold","ROLE_ADMIN");
            userService.addRoleToUser("arnold","ROLE_USER");
        };
    }*/

}

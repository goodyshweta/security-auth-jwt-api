package com.preet.security.service.impl;

import com.preet.security.domain.entity.RoleEntity;
import com.preet.security.domain.entity.UserEntity;
import com.preet.security.repository.RoleRepo;
import com.preet.security.repository.UserRepo;
import com.preet.security.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUserName(userName);
        if (user == null) {
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in database");
        } else {
            log.info("User found in database : {}", userName);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new User(user.getUserName(), user.getPassword(), authorities);
        }
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        log.info("Saving new user : {} to the database", userEntity.getUserName());
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepo.save(userEntity);
    }

    @Override
    public RoleEntity saveRole(RoleEntity roleEntity) {
        log.info("Saving new role : {} to the database", roleEntity.getName());
        return roleRepo.save(roleEntity);
    }

    @Override
    public boolean addRoleToUser(String userName, String roleName) {
        log.info("Adding new role : {} to the user : {}", roleName, userName);
        UserEntity user = userRepo.findByUserName(userName);
        RoleEntity role = roleRepo.findByName(roleName);
        return user.getRoles().add(role);
    }

    @Override
    public UserEntity getUser(String userName) {
        log.info("Fetching user : {}", userName);
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<UserEntity> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}

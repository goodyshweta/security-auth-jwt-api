package com.preet.security.service;

import com.preet.security.domain.entity.RoleEntity;
import com.preet.security.domain.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    RoleEntity saveRole(RoleEntity roleEntity);

    void addRoleToUser(String userName, String roleName);

    UserEntity getUser(String userName);

    List<UserEntity> getUsers();
}

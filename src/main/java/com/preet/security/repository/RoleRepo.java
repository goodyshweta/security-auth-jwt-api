package com.preet.security.repository;

import com.preet.security.domain.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);
}

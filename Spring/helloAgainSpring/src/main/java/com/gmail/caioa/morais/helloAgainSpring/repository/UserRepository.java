package com.gmail.caioa.morais.helloAgainSpring.repository;

import com.gmail.caioa.morais.helloAgainSpring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findFirstByUserName(String username);
}

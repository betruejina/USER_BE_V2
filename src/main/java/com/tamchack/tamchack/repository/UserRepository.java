package com.tamchack.tamchack.repository;

import com.tamchack.tamchack.domain.member.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {

    User findByIdAndPassword(String id, String password);

    User findByPassword(String password);

}

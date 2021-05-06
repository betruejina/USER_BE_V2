package com.tamchack.tamchack.repository;

import com.tamchack.tamchack.domain.member.Storeuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreuserRepository extends JpaRepository<Storeuser, String> {

    Storeuser findByIdAndPassword(String id, String password);

    Storeuser findByPassword(String password);

}

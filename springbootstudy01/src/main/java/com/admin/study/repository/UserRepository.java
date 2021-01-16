package com.admin.study.repository;


import com.admin.study.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//
//    // select * from user where accoount = ? << test 03 test04
//    Optional<User> findByAccount(String account);
//    Optional<User> findByEmail(String email);
//
//    // select * from user where accoount = ? annd email = ?<< test 03 test04
//    Optional<User> findByAccountAndEmail(String account, String email);
}

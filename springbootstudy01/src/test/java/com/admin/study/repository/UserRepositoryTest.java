package com.admin.study.repository;


import com.admin.study.StudyApplication;
import com.admin.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplication {


    //Dependency Injection (DI) 객체를 스프링이 관리
    //싱글톤 패턴,
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        //과거 jsp. String sql = insert into user (%s,%s,%d) value (account, email, age);
        User user = new User();
        user.setAccount("Testuser01");
        user.setEmail("testuser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreateAt(LocalDateTime.now());
        user.setCreateBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);


        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
        });
    }

    @Test
    public void update(){
        //과거 set, updateuser 등등 불편
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {

            selectUser.setAccount("PPPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);

        });
    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(2L);
        //Assert.assertTrue(user.isPresent()); 확인하는 테스트 코드
        user.ifPresent(selectUser ->{

            userRepository.delete(selectUser);
        });

        Optional<User> deleteuser = userRepository.findById(2L);

        if(deleteuser.isPresent()){

            System.out.println("데이터 존재 :" +deleteuser.get());
        }else{
            System.out.println("데이터 삭제 데이터 없음");
        }

        //Assert.assertFalse(deleteuser.isPresent()); //false 가 나와얗마
    }

}

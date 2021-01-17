package com.admin.study.service;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.entity.User;
import com.admin.study.model.enumclass.UserStatus;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.UserApiRequest;
import com.admin.study.model.newtwork.response.UserApiResopnse;
import com.admin.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.admin.study.model.newtwork.Header.Ok;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResopnse> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Header<UserApiResopnse> create(Header<UserApiRequest> requset) {

        //1. requset data 가져오기
        UserApiRequest userApiRequest = requset.getData();

        //2. user 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);
        //3. 생성된 데이터 -> UserApiResponse return



        return response(newUser);
    }

    @Override
    public Header<UserApiResopnse> read(Long id) {

// 방법 1.        // id -> repository getone, getbyid
//        Optional<User> optional = userRepository.findById(id);
//
//
//        // user -> userApiTrsponse return
//
//        return optional
//                .map(
//                        user ->  response(user)
//                )
//                .orElseGet(
//                        () ->Header.ERROR("데이터 없음")
//                );
//
//
//        // user-> user api Responser ruturn


        // 람다로 깔끔하게 정리 방법 2.
        return  userRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(
                        ()-> Header.ERROR("데이터 없음")
                );


    }

    @Override
    public Header<UserApiResopnse> update(Header<UserApiRequest> requset) {
        //  1.data
        UserApiRequest userApiRequest = requset.getData();
        // 2. id -> user 데이터를 찾고
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional
                .map(user -> {

                 //3. update
                    user
                            .setAccount(userApiRequest.getAccount())
                            .setPassword(userApiRequest.getPassword())
                            .setStatus(userApiRequest.getStatus())
                            .setPhoneNumber(userApiRequest.getPhoneNumber())
                            .setEmail(userApiRequest.getEmail())
                            .setRegisteredAt(userApiRequest.getRegisteredAt())
                            .setUnregisteredAt(userApiRequest.getUnregisteredAt())
                            ;

                    return user;
                    // 4. userApiResponse


                 })
                .map(user -> userRepository.save(user)) // update 데이터 베이스 반영 _> newUser 반환
                .map(updateuser -> response(updateuser))            // user api response 만들기
                .orElseGet(()->Header.ERROR("데이터 없음"));




    }

    @Override
    public Header delete(Long id) {
        // id -> repository - > user

        Optional<User> optional = userRepository.findById(id);

        // . reposiory - > deltede

        return optional
                .map(user-> {
                  userRepository.delete(user);
                    return Header.Ok();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"))
                ;
    }

    private Header<UserApiResopnse> response(User user){
        //user -> userapiResopnse 만들기
        UserApiResopnse userApiResopnse = UserApiResopnse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // todo 암호화 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        //Header + data return
        return Header.Ok(userApiResopnse);

    }
}

package com.admin.study.service;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.entity.User;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.UserApiRequest;
import com.admin.study.model.newtwork.response.UserApiResopnse;
import com.admin.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
                .status("REGISTERED")
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
        return null;
    }

    @Override
    public Header<UserApiResopnse> update(Header<UserApiRequest> requset) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
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

package com.admin.study.service;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.entity.OrderGroup;
import com.admin.study.model.entity.User;
import com.admin.study.model.enumclass.UserStatus;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.Pagination;
import com.admin.study.model.newtwork.request.UserApiRequest;
import com.admin.study.model.newtwork.response.ItemApiResponse;
import com.admin.study.model.newtwork.response.OrderGroupApiResponse;
import com.admin.study.model.newtwork.response.UserApiResopnse;
import com.admin.study.model.newtwork.response.UserOrderInfoApiResponse;
import com.admin.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.admin.study.model.newtwork.Header.Ok;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResopnse> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Autowired
    private  ItemApiLogicService itemApiLogicService;


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



        return Header.Ok(response(newUser));
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
              //  .map(userApiResopnse -> Header.Ok(userApiResopnse))
                .map(Header::Ok)
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
                .map(Header::Ok)
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

//    private Header<UserApiResopnse> response(User user){
//        //user -> userapiResopnse 만들기
//        UserApiResopnse userApiResopnse = UserApiResopnse.builder()
//                .id(user.getId())
//                .account(user.getAccount())
//                .password(user.getPassword()) // todo 암호화 길이
//                .email(user.getEmail())
//                .phoneNumber(user.getPhoneNumber())
//                .status(user.getStatus())
//                .registeredAt(user.getRegisteredAt())
//                .unregisteredAt(user.getUnregisteredAt())
//                .build();
//
//        //Header + data return
//        return Header.Ok(userApiResopnse);
//
//    }

    //페이지용 리스폰
    private UserApiResopnse response(User user){
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
        return userApiResopnse;

    }
    //페이저블 만들기
    public Header<List<UserApiResopnse>> search(Pageable pageable) {

        Page<User> users = userRepository.findAll(pageable);

        List<UserApiResopnse> userApiResopnseList = users.stream()
              .map(user -> response(user))
              .collect(Collectors.toList());

        // List<UserApiResponse>현재
        // Header<List<UserA[oResponse>>반환해야하는값

        //총페이지 정보 넘겨주기 페이지 만들기
        Pagination pagination = Pagination.builder()
                .totalPages(users.getTotalPages())
                .totalElements(users.getTotalElements())
                .currentPage(users.getTotalPages())
                .currentElements(users.getNumberOfElements())
                .build();


        return Header.Ok(userApiResopnseList, pagination);

    }

    public Header<UserOrderInfoApiResponse> orderInfo(Long id) {

        //user
        User user = userRepository.getOne(id);
        UserApiResopnse userApiResopnse = response(user);

        //orderGroup 유저에 묶어 버리기
        List<OrderGroup> orderGroupList = user.getOrderGroupList();
        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroupList.stream()
                .map(orderGroup -> {

                   OrderGroupApiResponse orderGroupApiResponse = orderGroupApiLogicService.response(orderGroup).getData();

                   //item api response 오더 그룹에 묶어버리기
                    List<ItemApiResponse> itemApiResponseList = orderGroup.getOrderDetailList().stream()
                            .map(detail -> detail.getItem())
                            .map(item -> itemApiLogicService.response(item).getData())
                            .collect(Collectors.toList());
                    orderGroupApiResponse.setItemApiResponseList(itemApiResponseList);
                    return orderGroupApiResponse;
                })
                .collect(Collectors.toList());

        userApiResopnse.setOrderGroupApiResponsesList(orderGroupApiResponseList);
        UserOrderInfoApiResponse userOrderInfoApiResponse = UserOrderInfoApiResponse.builder().
                userApiResopnse(userApiResopnse)
                .build();

        return Header.Ok(userOrderInfoApiResponse);
    }
}

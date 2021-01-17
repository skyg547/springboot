package com.admin.study.service;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.entity.OrderGroup;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.OrderGroupApiRequest;
import com.admin.study.model.newtwork.response.OrderGroupApiResponse;
import com.admin.study.repository.OrderGroupRepository;
import com.admin.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> requset) {

        OrderGroupApiRequest body = requset.getData();

        OrderGroup orderGroup = OrderGroup.builder()
                .status(body.getStatus())
                .orderType(body.getOrderType())
                .revAddress(body.getRevAddress())
                .revName(body.getRevName())
                .paymentType(body.getPaymentType())
                .totalPrice(body.getTotalPrice())
                .totalQuantity(body.getTotalQuantity())
                .orderAt(LocalDateTime.now())
                .user(userRepository.getOne(body.getUserId()))
                .build();

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);


        return response(newOrderGroup);
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {

        return orderGroupRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터없음"));

    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> reqest) {

        OrderGroupApiRequest body = reqest.getData();

        return orderGroupRepository.findById(body.getId())
                .map(orderGroup -> {

                    orderGroup
                            .setStatus(body.getStatus())
                            .setOrderType(body.getOrderType())
                            .setRevAddress(body.getRevAddress())
                            .setRevName(body.getRevName())
                            .setPaymentType(body.getPaymentType())
                            .setTotalPrice(body.getTotalPrice())
                            .setTotalQuantity(body.getTotalQuantity())
                            .setOrderAt(body.getOrderAt())
                            .setArrivalDate(body.getArrivalDate())
                            .setUser(userRepository.getOne(body.getUserId()));
                    return orderGroup;
                })
                .map(ChangeOrderGroup-> orderGroupRepository.save(ChangeOrderGroup))
                .map(newOrderGroup -> response(newOrderGroup))
                .orElseGet(() -> Header.ERROR("데이터없어"));

    }

    @Override
    public Header delete(Long id) {
        return orderGroupRepository.findById(id)
                .map(orderGroup ->{

                    orderGroupRepository.delete(orderGroup);
                    return Header.Ok();
                        })
                .orElseGet(()->Header.ERROR("데이터없음"));
    }

    private  Header<OrderGroupApiResponse> response(OrderGroup orderGroup){

        OrderGroupApiResponse body = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getId())
                .build();

        return Header.Ok(body);
    }
}

package com.admin.study.repository;

import com.admin.study.StudyApplication;
import com.admin.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositotyTest extends StudyApplication {

    @Autowired
    private OrderDetailRepository orderDtailRepository;

    @Test
    public void create(){

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());
        //어떤사람?
        //orderDetail.setUser();
        //어떤상품품
       // orderDetail.setItem();


    }}

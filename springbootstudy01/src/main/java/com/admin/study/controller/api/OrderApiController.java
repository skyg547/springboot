package com.admin.study.controller.api;

import com.admin.study.controller.CrudController;
import com.admin.study.model.entity.OrderGroup;
import com.admin.study.model.newtwork.request.OrderGroupApiRequest;
import com.admin.study.model.newtwork.response.OrderGroupApiResponse;
import com.admin.study.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/order")
public class OrderApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    /*@Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = orderGroupApiLogicService;

    }*/

}

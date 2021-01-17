package com.admin.study.controller.api;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.entity.OrderGroup;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.OrderGroupApiRequest;
import com.admin.study.model.newtwork.response.OrderGroupApiResponse;
import com.admin.study.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Override
    @PostMapping("")
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> requset) {
        return orderGroupApiLogicService.create(requset);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
        return orderGroupApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> reqest) {
        return orderGroupApiLogicService.update(reqest);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return orderGroupApiLogicService.delete(id);
    }
}

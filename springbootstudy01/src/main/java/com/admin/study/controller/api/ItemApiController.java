package com.admin.study.controller.api;

import com.admin.study.controller.CrudController;
import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.entity.Item;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.ItemApiRequest;
import com.admin.study.model.newtwork.response.ItemApiResponse;
import com.admin.study.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@RestController
@Slf4j
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

/*    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = itemApiLogicService;
    }*/


}

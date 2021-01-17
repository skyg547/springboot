package com.admin.study.controller.api;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.ItemApiRequest;
import com.admin.study.model.newtwork.response.ItemApiResponse;
import com.admin.study.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping("") // api/item
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> requset) {

        return itemApiLogicService.create(requset);

    }

    @Override
    @GetMapping("{id}") //api/item/1..100
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return itemApiLogicService.read(id);
    }

    @Override
    @PutMapping("") //api/item
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> reqest) {
        return itemApiLogicService.update(reqest);
    }

    @Override
    @DeleteMapping("{id}")  //api/item/1...100
    public Header delete(@PathVariable Long id) {
        return itemApiLogicService.delete(id);
    }
}

package com.admin.study.controller.api;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.UserApiRequest;
import com.admin.study.model.newtwork.response.UserApiResopnse;
import com.admin.study.model.newtwork.response.UserOrderInfoApiResponse;
import com.admin.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // 로그
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResopnse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public  Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){

        return  userApiLogicService.orderInfo(id);
    }

    @GetMapping("") //페이지 만들기
    public  Header<List<UserApiResopnse>> search(@PageableDefault(sort = "id", direction =  Sort.Direction.ASC, size = 15) Pageable pageable){
        log.info("{}",pageable);
        return  userApiLogicService.search(pageable);
    }


    @Override
    @PostMapping("") // api/user
    public Header<UserApiResopnse> create(@RequestBody Header<UserApiRequest> userApiRequest) {
        log.info("{}",userApiRequest);
        return userApiLogicService.create(userApiRequest);
    }

    @Override
    @GetMapping("{ids}") // /api/user/{id}
    public Header<UserApiResopnse> read(@PathVariable(name="ids") Long id) {
        log.info("read : {}", id);
        return userApiLogicService.read(id) ;
    }
    @Override
    @PutMapping("") // api/user
    public Header<UserApiResopnse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
        return userApiLogicService.update(userApiRequest);
    }

    @Override
    @DeleteMapping("{id}") // api/user/{id}
    public Header delete(Long id) {
        log.info("del : {}", id);
        return userApiLogicService.delete(id);
    }
}

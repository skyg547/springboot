package com.admin.study.controller.api;

import com.admin.study.ifs.CrudInterface;
import com.admin.study.model.newtwork.Header;
import com.admin.study.model.newtwork.request.UserApiRequest;
import com.admin.study.model.newtwork.response.UserApiResopnse;
import com.admin.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j // 로그
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResopnse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("") // api/user
    public Header<UserApiResopnse> create(@RequestBody Header<UserApiRequest> userApiRequest) {
        log.info("{}",userApiRequest);
        return userApiLogicService.create(userApiRequest);
    }

    @Override
    @GetMapping("{ids}") // /api/user/{id}
    public Header<UserApiResopnse> read(@PathVariable(name="ids") Long id) {
        return null;
    }

    @Override
    @PutMapping("") // api/user
    public Header<UserApiResopnse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // api/user/{id}
    public Header delete(Long id) {
        return null;
    }
}

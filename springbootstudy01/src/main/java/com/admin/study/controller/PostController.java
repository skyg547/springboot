package com.admin.study.controller;

import com.admin.study.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    //주소가 노출 되지 않습니다.
    //Html <From>
    //ajax 검색
    // http post body에서 -> data 받기
    // 여러 가지 형태 json, xml ,mutilpart -form / text-plain -> produce={} 사용

   // @RequestMapping(method = RequestMethod.POST, path = "/postMethod") 아래와 같다
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){



        return searchParam;


    }
}

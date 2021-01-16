package com.admin.study.controller;

import com.admin.study.model.SearchParam;
import com.admin.study.model.newtwork.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    // 주소창 파라미터 노출 , 주소에대한 캐시, 정보를 얻을때 사용

    @RequestMapping(method =  RequestMethod.GET, path = "/getMethod") // localHost:8080/api/getMethod
    public String getRequst(){

        return "Hi getMethod";

    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=1234&password=abcd
    public String getStirngParmeter(@RequestParam String id, @RequestParam(name = "password") String pwd){

        String password = "bbbb";

        System.out.println("id : "+ id);
        System.out.println("pwd : "+ pwd);

        return id+password;

    }

    // localhos:8080/api/MutiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParamerter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getPage());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getClass());

        //{"account" : "", "email" : "", "page" : 0}
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){
        // {"resultCode" : Ok, "description" : "OK"}
        return Header.builder().resultCode("OK").description("Ok").build();

    }
}

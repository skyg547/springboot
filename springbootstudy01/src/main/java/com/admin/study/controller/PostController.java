package com.admin.study.controller;

import com.admin.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

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

    // HTTP - put/patch methoㅇ 바디에 데이터, 업데이트 사용
    @PutMapping("/putMethod")
    public void put(){



    }
    @PatchMapping("/patchMethod")
    public void patch(){


    }

    //delete 주소에 파라미터 데이터 삭제,
}

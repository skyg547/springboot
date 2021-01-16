package com.admin.study.model.newtwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// @JsonInclude 특정값만 표함
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    // api 통신 시간
    @JsonProperty("transaction_time")// 카멜 -> 스네이크  직접 바꿔주기
    private LocalDateTime transactionTime; // 다 가능 ISO, YYYY-MM-DD HH:MM:SS


    // api 응답 코드
    private String resultCode;



    // api 부가 설명
    private String description;

    private T data;

    // OK
    public static <T> Header<T> Ok(){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }


    // Error

    public static <T> Header<T> ERROR(String description){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }

    //DATA Ok

    public static <T> Header<T> Ok(T data){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

}

package com.admin.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {

    REGISTERED(0,"등록","삼풍등록상태"),
    UNREGISTERED(1,"해지","상품해지상태"),
    WAITING(2,"검수","상품검수상태");


    private Integer id;
    private String title;
    private String description;
}

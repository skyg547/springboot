package com.admin.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  Integer price;
    private  String content;

    //1:N
    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}

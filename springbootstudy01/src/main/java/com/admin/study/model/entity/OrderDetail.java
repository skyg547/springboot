package com.admin.study.model.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Accessors(chain = true)
@Builder
@EntityListeners(AuditingEntityListener.class)//감지
@ToString(exclude = {"orderGroupId","item"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // order_detail
//@ToString(exclude =  {"user","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate // 자동 채워주기
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // OrderDetail N : 1 Item
    @ManyToOne
    private Item item;

    //Ordergrop N : 1 orderGroup
    @ManyToOne
    private OrderGroup orderGroup;


//    @ManyToOne
//    private User user;//user
//    @ManyToOne
//    private Item item;

}

package com.admin.study.model.entity;

import com.admin.study.model.enumclass.OrderType;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Accessors(chain = true)
@Builder
@EntityListeners(AuditingEntityListener.class)//감지
@ToString(exclude ={"user","orderDetailList"})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @Enumerated(EnumType.STRING)
    private OrderType orderType; // 일괄 개별

    private String revAddress;

    private String revName;

    private String paymentType; // 카드/ 혀금

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    @CreatedDate // 자동 채워주기
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // OrderGrouo N : 1 User
    @ManyToOne
    private User user;

    // OrderGrup 1:N orderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;


}

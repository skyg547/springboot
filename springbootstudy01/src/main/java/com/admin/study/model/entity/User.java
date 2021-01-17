package com.admin.study.model.entity;

import com.admin.study.model.enumclass.UserStatus;
import jdk.vm.ci.meta.Local;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)//감지
@ToString(exclude = {"orderGroup"})
@Accessors(chain = true)
@Builder
@Entity // == table
@Data // 게터 세터 생성자 설정
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 생성자
// @Table(name = "user") 클래스와 테이블 이름이 동일하면 생략 가능
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    //@Column(name = "account") 변수와 이름이 같다면 생략 가능
//    private String account;
//
//    private Stirng
//
//    private String email;
//
//    private String phoneNumber;
//
//    private LocalDateTime createAt;
//
//    private String createBy;
//
//    private LocalDateTime updatedAt;
//
//    private String updatedBy;
//
//    // 1:N 추천 ->  //LAZY = SELEct * From item where id =?
//    //EAGER = 모든 테이블 조인 1:1 추천
//    //item _ id = order_detail.item_id
//    //user_id = order_detail.user_id
//    // JOIN ite
//    //Lazy = ㅣㅈ연 로딩 , EAGER 즉시로딩
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private List<OrderDetail> orderDetailList;

    private String account;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status; // REGISTERED/ UNREGUSTERED/ WATIING/

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate // 자동 채워주기
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // User 1:N OrderGroup

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
}

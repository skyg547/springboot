package com.admin.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // == table
@Data // 게터 세터 생성자 설정
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 생성자
// @Table(name = "user") 클래스와 테이블 이름이 동일하면 생략 가능
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "account") 변수와 이름이 같다면 생략 가능
    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createAt;

    private String createBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

}

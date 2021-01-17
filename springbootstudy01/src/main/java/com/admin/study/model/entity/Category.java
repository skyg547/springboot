package com.admin.study.model.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Accessors(chain = true)
@Builder
@EntityListeners(AuditingEntityListener.class)//감지
@ToString(exclude = {"partnerList"})
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String title;

    @CreatedDate // 자동 채워주기
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    //Category 1 L N partner
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category")
    private List<Partner> partnerList;
}

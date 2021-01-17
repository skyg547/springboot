package com.admin.study.model.newtwork.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupApiResponse {

    private Long id;

    private String status;

    private String orderType;

    private String revAddress;

    private String paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private Long userId;

}

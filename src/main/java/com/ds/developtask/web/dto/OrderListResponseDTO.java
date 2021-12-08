package com.ds.developtask.web.dto;

import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.order.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class OrderListResponseDTO {

    private UUID orderNo;
    private String productName;
    private Date paymentDate;
    private Member member;

    @Builder
    public OrderListResponseDTO(Orders orders) {
        this.orderNo = orders.getOrderNo();
        this.productName = orders.getProductName();
        this.paymentDate = orders.getPaymentDate();
        this.member = orders.getMember();
    }
}

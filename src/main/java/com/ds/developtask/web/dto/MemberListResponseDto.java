package com.ds.developtask.web.dto;

import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.order.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberListResponseDto {
    private String name;
    private String nickName;
    private String password;
    private String phoneNumber;
    private String email;
    private String gender;
    private Orders order;

    @Builder
    public MemberListResponseDto(Member member) {
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.password = member.getPassword();
        this.phoneNumber = member.getPhoneNumber();
        this.email = member.getEmail();
        this.gender = member.getGender();
        this.order = member.getOrders().get(member.getOrders().size() - 1);
    }
}

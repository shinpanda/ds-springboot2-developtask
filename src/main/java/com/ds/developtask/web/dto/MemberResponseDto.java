package com.ds.developtask.web.dto;

import com.ds.developtask.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberResponseDto {
    private String name;
    private String nickName;
    private String phoneNumber;
    private String email;
    private String gender;

    @Builder
    public MemberResponseDto(Member member) {
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.phoneNumber = member.getPhoneNumber();
        this.email = member.getEmail();
        this.gender = member.getGender();
    }
}

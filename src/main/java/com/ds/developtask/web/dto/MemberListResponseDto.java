package com.ds.developtask.web.dto;

import com.ds.developtask.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberListResponseDto {
    private Long id;
    private String name;
    private String nickName;
    private String password;
    private String phoneNumber;
    private String email;
    private String gender;


    @Builder
    public MemberListResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.password = member.getPassword();
        this.phoneNumber = member.getPhoneNumber();
        this.email = member.getEmail();
        this.gender = member.getGender();
    }
}

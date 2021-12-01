package com.ds.developtask.web.dto;

import com.ds.developtask.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberSaveRequestDto {

    private String name;
    private String nickName;
    private String password;
    private String phoneNumber;
    private String email;
    private String gender;

    @Builder
    public MemberSaveRequestDto(String name, String nickName, String password, String phoneNumber, String email, String gender) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .nickName(nickName)
                .password(password)
                .phoneNumber(phoneNumber)
                .email(email)
                .gender(gender).build();
    }
}

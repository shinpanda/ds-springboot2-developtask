package com.ds.developtask.web.dto;

import com.ds.developtask.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@RequiredArgsConstructor
public class MemberSaveRequestDto {

    @Pattern(regexp = "[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|A-Z]", message = "한글, 대문자만 입력 가능합니다.")
    private String name;
    @Pattern(regexp = "[a-z]", message = "소문자만 입력 가능합니다.")
    private String nickName;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?=\\S+$).{10,}", message = "영문 대문자, 영문 소문자, 특수 문자, 숫자 각 1개 이상씩 포함되어 최소 10자 이상 작성해주셔야 합니다.")
    private String password;
    @Pattern(regexp = "[0,9]{10,11}", message = "숫자만 입력 가능합니다.")
    private String phoneNumber;
    @Email(message = "이메일 형식을 맞춰주세요.")
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

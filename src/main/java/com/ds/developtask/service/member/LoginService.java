package com.ds.developtask.service.member;

import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String name, String password){
        return null;
    }

}

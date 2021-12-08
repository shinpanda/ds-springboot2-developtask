package com.ds.developtask.web;

import com.ds.developtask.config.security.JwtTokenProvider;
import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.member.MemberRepository;
import com.ds.developtask.service.member.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final LoginService loginService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @ApiOperation(value = "로그인", notes = "로그인을 진행하며, 정상 진행 시 token이 발행됩니다")
    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password){
        Member member = memberRepository.findByName(name);

        if(member == null)
            throw new IllegalArgumentException("이름과 패스워드를 다시 확인해주세요");

        if(!passwordEncoder.matches(password, member.getPassword()))
            throw new IllegalArgumentException("이름과 패스워드를 다시 확인해주세요");

        return jwtTokenProvider.createToken(String.valueOf(member.getUsername()), "ROLE_USER");
    }

}

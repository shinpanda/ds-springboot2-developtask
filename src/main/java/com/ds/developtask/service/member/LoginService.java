package com.ds.developtask.service.member;

import com.ds.developtask.config.security.JwtTokenProvider;
import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.member.MemberDetails;
import com.ds.developtask.domain.member.MemberDetailsRepository;
import com.ds.developtask.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private MemberDetailsRepository memberDetailsRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByName(username);

        if(member == null)
            throw new UsernameNotFoundException("해당하는 사용자가 없습니다.");

        return new MemberDetails(member.getName(), member.getPassword(), true, true, true, true, null);
    }

    public String login (String name, String password) throws IllegalArgumentException{
        MemberDetails memberDetails = memberDetailsRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("이름과 패스워드를 다시 확인해주세요"));

        if(!passwordEncoder.matches(password, memberDetails.getPassword()))
            throw new IllegalArgumentException("이름과 패스워드를 다시 확인해주세요");

        return jwtTokenProvider.createToken(String.valueOf(memberDetails.getUsername()), "ROLE_USER");
    }
}

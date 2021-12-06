package com.ds.developtask.service.member;

import com.ds.developtask.domain.member.Member;
import com.ds.developtask.service.security.MemberDetails;
import com.ds.developtask.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByName(username);

        if(member == null)
            throw new UsernameNotFoundException("해당하는 사용자가 없습니다.");

        MemberDetails memberDetails = new MemberDetails(member.getName(), member.getPassword(), true, true, true, true, null);
        return memberDetails;
    }
}

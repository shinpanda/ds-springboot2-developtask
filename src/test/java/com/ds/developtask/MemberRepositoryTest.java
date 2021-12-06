package com.ds.developtask;

import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MemberRepositoryTest.class)
public class MemberRepositoryTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testSignup() throws Exception{
        String name = "TEST";
        String nickName = "testNick";
        String password = "Passw0rd";
        String phoneNumber = "01000000000";
        String email = "test@test.com";
        String gender = "여";

        Long id = memberRepository.save(Member.builder()
        .name(name).nickName(nickName).password(password)
        .phoneNumber(phoneNumber).email(email).gender(gender).build()).getId();

        Optional<Member> member = memberRepository.findById(id);
        assertThat(member.get().getName()).isEqualTo(name);
    }

}

package com.ds.developtask;

import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.member.MemberRepository;
import com.ds.developtask.web.dto.MemberSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void signup() {
        String name = "Tester1";
        String nickName = "Tester";
        String password = "P@ssw0rd";
        String phoneNumber = "01000000000";
        String email = "test@test.com";

        MemberSaveRequestDto memberSaveRequestDto = MemberSaveRequestDto.builder()
                .name(name)
                .nickName(nickName)
                .password(password)
                .phoneNumber(phoneNumber)
                .email(email).build();

        String url = "http://localhost:" + port +  "/member/signup";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, memberSaveRequestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Member> members = memberRepository.findAll();
        assertThat(members.get(0).getName()).isEqualTo(name);
    }

}

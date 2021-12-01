package com.ds.developtask.service.member;

import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.member.MemberRepository;
import com.ds.developtask.web.dto.MemberResponseDto;
import com.ds.developtask.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberSaveRequestDto memberDto){
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    @Transactional
    public MemberResponseDto get(Long id){
        Optional<Member> member = Optional.ofNullable(memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")));
        return new MemberResponseDto(member.get());
    }

    public List<MemberResponseDto> list() {
        return null;
    }
}

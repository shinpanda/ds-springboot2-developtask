package com.ds.developtask.service.member;

import com.ds.developtask.domain.member.Member;
import com.ds.developtask.domain.member.MemberRepository;
import com.ds.developtask.web.dto.MemberListResponseDto;
import com.ds.developtask.web.dto.MemberResponseDto;
import com.ds.developtask.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberSaveRequestDto memberDto){
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    public MemberResponseDto get(Long id){
        Optional<Member> member = Optional.ofNullable(memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")));
        return new MemberResponseDto(member.get());
    }

    public List<MemberListResponseDto> list(String name, String email, PageRequest pageRequest) {
        Page<Member> result = memberRepository.findByNameAndEmail(name,email, pageRequest);
        List<Member> members = result.getContent();
        return members.stream().map(MemberListResponseDto::new).collect(Collectors.toList());
    }
}

package com.ds.developtask.web;

import com.ds.developtask.service.member.MemberService;
import com.ds.developtask.web.dto.MemberResponseDto;
import com.ds.developtask.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public Long signup(@RequestBody MemberSaveRequestDto memberDto){
        return memberService.save(memberDto);
    }

    @GetMapping("/{id}")
    public MemberResponseDto get(@PathVariable Long id){
        return memberService.get(id);
    }

    @GetMapping("/list")
    public List<MemberResponseDto> list(){
        return memberService.list();
    }
}

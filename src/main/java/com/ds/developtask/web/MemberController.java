package com.ds.developtask.web;

import com.ds.developtask.service.member.MemberService;
import com.ds.developtask.web.dto.MemberListResponseDto;
import com.ds.developtask.web.dto.MemberResponseDto;
import com.ds.developtask.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public Long signup(@RequestBody MemberSaveRequestDto memberDto){
        return memberService.save(memberDto);
    }

    @GetMapping("/{id}")
    public MemberResponseDto get(@PathVariable Long id){
        return memberService.get(id);
    }

    @GetMapping("/list")
    public List<MemberListResponseDto> list(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("page") int page,
            @RequestParam("size") int size){
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC, "paymentDate"));

        return memberService.list(name, email,pageRequest);
    }
}

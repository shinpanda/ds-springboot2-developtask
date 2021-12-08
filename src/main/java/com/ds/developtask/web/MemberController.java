package com.ds.developtask.web;

import com.ds.developtask.domain.order.Orders;
import com.ds.developtask.service.member.MemberService;
import com.ds.developtask.service.member.OrdersService;
import com.ds.developtask.web.dto.MemberListResponseDto;
import com.ds.developtask.web.dto.MemberResponseDto;
import com.ds.developtask.web.dto.MemberSaveRequestDto;
import com.ds.developtask.web.dto.OrderListResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    private final OrdersService ordersService;

    @ApiOperation(value = "회원 가입", notes = "회원 정보를 입력한다.")
    @PostMapping("/signup")
    public Long signup(@RequestBody MemberSaveRequestDto memberDto){
        return memberService.save(memberDto);
    }

    @ApiOperation(value = "단일 회원 상세 정보 조회", notes = "단일 회원 정보를 조회한다.")
    @GetMapping("/{id}")
    public MemberResponseDto get(@ApiParam(value = "회원 id") @PathVariable Long id){
        return memberService.get(id);
    }

    @ApiOperation(value = "여러 회원 목록 조회", notes = "page, size의 정보로 페이징이 가능하며, 이름, 이메일을 이용하여 검색이 가능합니다. 또한, 목록 조회 시 각 회원의 마지막 주문 정보를 가져옵니다")
    @GetMapping("/list")
    public List<MemberListResponseDto> list(
            @ApiParam(value = "회원이름") @RequestParam(value = "name", required = false) String name,
            @ApiParam(value = "이메일") @RequestParam(value = "email", required = false) String email,
            @ApiParam(value = "페이지 번호") @RequestParam("page") int page,
            @ApiParam(value = "페이지 사이즈") @RequestParam("size") int size){
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by(Sort.Direction.DESC, "paymentDate"));

        return memberService.list(name, email,pageRequest);
    }

    @ApiOperation(value = "회원의 주문 목록 조회", notes = "회원의 주문 목록을 조회한다.")
    @GetMapping("/orders/{id}")
    public List<OrderListResponseDTO> orderList(@ApiParam(value = "회원 id") @PathVariable Long id){
        return ordersService.findByMemberIDWithMemberUsingJoin(id);
    }
}

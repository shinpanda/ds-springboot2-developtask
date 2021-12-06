package com.ds.developtask.web;

import com.ds.developtask.service.member.OrdersService;
import com.ds.developtask.web.dto.MemberResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrdersService ordersService;

    @ApiOperation(value = "단일 회원 상세 정보 조회", notes = "단일 회원 정보를 조회한다.")
    @GetMapping("/{id}")
    public MemberResponseDto get(@PathVariable Long id){
        //return ordersService.findByMemberID(id);
        return null;
    }

}

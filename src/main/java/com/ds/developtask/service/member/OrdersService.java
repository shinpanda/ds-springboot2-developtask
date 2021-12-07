package com.ds.developtask.service.member;

import com.ds.developtask.domain.order.Orders;
import com.ds.developtask.domain.order.OrdersRepository;
import com.ds.developtask.web.dto.OrderListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public List<OrderListResponseDTO> findByMemberIDWithMemberUsingJoin(Long id){
        List<Orders> orders = ordersRepository.findByMemberIDWithMemberUsingJoin(id);

        return orders.stream().map(OrderListResponseDTO::new).collect(Collectors.toList());
    }


}

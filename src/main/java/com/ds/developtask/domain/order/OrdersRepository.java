package com.ds.developtask.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, String> {

    List<Orders> findByMemberIDWithMember(Long id);
}

package com.ds.developtask.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, String> {

    @Query("SELECT * FROM Orders o join o.member m where m.id = :id")
    List<Orders> findByMemberIDWithMemberUsingJoin(Long id);
}

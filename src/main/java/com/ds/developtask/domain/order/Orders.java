package com.ds.developtask.domain.order;

import com.ds.developtask.domain.member.Member;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @NotNull
    @Column(length = 12)
    private String orderNo;

    @NotNull
    @Column(length = 100)
    private String productName;

    @NotNull
    private LocalDateTime paymentDate;

    @ManyToOne(optional = false)
    private Member member;

}

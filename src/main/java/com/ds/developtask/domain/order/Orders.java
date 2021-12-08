package com.ds.developtask.domain.order;

import com.ds.developtask.domain.member.Member;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @NotNull
    //@Column(length = 12)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    //UNHEX(UUID_SHORT())
    private UUID orderNo;

    @NotNull
    @Column(length = 100)
    private String productName;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @ManyToOne(optional = false)
    private Member member;

    @Builder
    public Orders(String orderNo, String productName, Date paymentDate, Member member) {
        this.productName = productName;
        this.paymentDate = paymentDate;
        this.member = member;
    }
}

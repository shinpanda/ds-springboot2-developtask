package com.ds.developtask.domain.member;

import com.ds.developtask.domain.order.Order;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20)
    private String name;

    @NotNull
    @Column(length = 30)
    private String nickName;

    @NotNull
    private String password;

    @NotNull
    @Column(length = 20)
    private String phoneNumber;

    @NotNull
    @Column(length = 100)
    private String email;

    private String gender;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

    @Builder
    public Member(String name, String nickName, String password, String phoneNumber, String email, String gender) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }
}

package com.ds.developtask.domain.member;

import com.ds.developtask.domain.order.Orders;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 20, nullable = false)
    private String name;

    @NotNull
    @Column(length = 30, nullable = false)
    private String nickName;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(length = 100, nullable = false)
    private String email;

    private String gender;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Orders> orders = new ArrayList<Orders>();

    @Builder
    public Member(String name, String nickName, String password, String phoneNumber, String email, String gender) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

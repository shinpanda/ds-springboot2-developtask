package com.ds.developtask.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberDetailsRepository extends JpaRepository<Member, Long> {
    Optional<MemberDetails> findByName(String name);
}

package com.ds.developtask.domain.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);
    Page<Member> findByNameAndEmail(String name, String email, Pageable pageable);
}

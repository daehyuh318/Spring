package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    /**
     * JpaRepository의 NoRepositoryBean은 Jpa 관련 인터페이스를 빈으로 등록해줌
     */
    @Override
    Optional<Member> findByName(String name);
}

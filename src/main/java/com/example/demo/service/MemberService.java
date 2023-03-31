package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원X
//        long start = System.currentTimeMillis();
//
//        try {
        validateDuplicateMember(member);
        memberRepository.save(member);
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join "+ timeMs + "ms");
//        }

        return member.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findAll(){
//        long start = System.currentTimeMillis();
//
//        try {
        return memberRepository.findAll();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join "+ timeMs + "ms");
//        }
    }

    public Optional<Member> findOne(Long memberID){
        return memberRepository.findById(memberID);
    }

    /**
     * 회원 id 조회
     */
    private void validateDuplicateMember(Member member) { // 중복 회원 이름 확인
        memberRepository.findByName(member.getName()).ifPresent(member1 ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


}

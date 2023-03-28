package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void clear()
    {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복테스트(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }

    @Test
    void 전체조회() {
        //given
        Member member = new Member();
        member.setName("hello");
        Member member2 = new Member();
        member2.setName("hello1");
        Member member3 = new Member();
        member3.setName("hello2");
        //when
        memberService.join(member);
        memberService.join(member2);
        memberService.join(member3);
        //then
        System.out.println(memberService.findAll());
    }

    @Test
    void 아이디조회() {
        //given
        Member member1 = new Member();
        member1.setName("hello1");
        Member member2 = new Member();
        member2.setName("hello2");
        Member member3 = new Member();
        member3.setName("hello3");
        //when
        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);
        //then
        System.out.println(memberService.findOne(member2.getId()));

    }
}
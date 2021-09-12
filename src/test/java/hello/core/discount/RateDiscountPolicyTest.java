package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//class RateDiscountPolicyTest {
//
//    private MemberService memberService;
//    private DiscountPolicy discountPolicy;
//
//
//
//    @Test
//    @DisplayName("VIP는 10% 할인해줘라")
//    void vip_o(){
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);
//        Assertions.assertThat(discountPolicy.discount(member,10000)).isEqualTo(1000);
//
//    }
//}
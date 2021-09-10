package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // memberRepository 에서 멤버를 찾고
        int discountPrice = discountPolicy.discount(member, itemPrice); // 그 멤버가 vip인지 확인하면서 할인금액 측정
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 값이 무조건 있어야 한다고 지정 - final = 생성자에서만 값을 세팅할 수 잇음 또는 초기값을 넣은 경우만
    // 생성자주입 쓰면 final 키워드 사용 가능 -> 개발자가 생성자 까먹은 경우에, final이 선언되어 있으면 초기에 값이 들어와야 하는데
//    값이 없다고 컴파일 오류를 내줌

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // memberRepository 에서 멤버를 찾고
        int discountPrice = discountPolicy.discount(member, itemPrice); // 그 멤버가 vip인지 확인하면서 할인금액 측정
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션에 대한 모든 환경설정[구성]은 AppConfig가 처리한다
// '공연기획자'의 역할 - 구현체(배역에 맞는 담당배우)를 선택한다
// 객체의 생성과 연결을 담당
// AppConfig을 통해 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리됐다(관심사 분리)

// 스프링으로 전환해보자 @Configuration 붙이고 각 메소드에 @Bean을 붙인다
// @Bean을 붙이면 스프링 컨테이너(ApplicationContext)에 담긴다
@Configuration
public class AppConfig {

    // 리팩토링을 통해 중복제거하고, 역할과 구현 클래스가 명확하게 보인다
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    // 생성자에 의한 의존관계 주입 방식 - DIP원칙 준수 성공
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}

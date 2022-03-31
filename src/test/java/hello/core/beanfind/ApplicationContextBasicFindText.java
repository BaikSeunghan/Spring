package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindText {

    // ctrl + e 로하면 리스트 나온다
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회") // ac.getBean(빈이름, 타입)
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // memberService가 memberSerivceImpl의 instance면 테스트 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        System.out.println("memberService = " + memberService);
        System.out.println("MemberService.class = " + memberService.getClass());
    }
    @Test
    @DisplayName("이름없이 타입으로만 조회") // ac.getBean(타입)
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        // 역할에 의존한 코드이기때문에 좋은 코드는 아니다. 그치만 살다보면 사용할 일이 있을 수 있다.
        // 구체 타입으로 조회하면 변경시 유연성이 떨어진다
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회X") //
    void findByNameX() {
        // ac.getBean("xxxxx",MemberService.class)); 실행했을때, NoSuchBeanDefinitionException 예외가 터지면 테스트 성공
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxxx",MemberService.class));
    }
}

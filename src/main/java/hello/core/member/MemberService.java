package hello.core.member;

public interface MemberService {

    // 클라이언트 회원가입
    void join(Member member);

    // 클라이언트 회원조회
    Member findMember(Long memberId);
}

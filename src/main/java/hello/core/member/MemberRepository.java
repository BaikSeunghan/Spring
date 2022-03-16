package hello.core.member;

public interface MemberRepository {

    //저장소에 회원정보 저장
    void save(Member member);

    //저장소에서 회원정보 찾기
    Member findById(Long memberId);
}

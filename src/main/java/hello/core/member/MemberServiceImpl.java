package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 회원가입을 하고 저장할 저장소
                                                        // 구현체
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

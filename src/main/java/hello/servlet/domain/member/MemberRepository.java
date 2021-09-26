package hello.servlet.domain.member;

import java.util.*;

/*
* 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
* */
public class MemberRepository {
    //Java에서는 key와 value가 한쌍을 이루는 자료구조가 Map, Dictionary 있는데
    // Dictionary -> 구식
    // Map -> 신식, 사용권장
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        Member member = store.get(id);
        return member;
    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
    public void clear(){
        store.clear();
    }
}

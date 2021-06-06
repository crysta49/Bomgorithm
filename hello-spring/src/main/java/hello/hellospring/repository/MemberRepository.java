package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;



import hello.hellospring.domain.Member;

public interface MemberRepository {
	
	Member save (Member member);
	Optional<Member>optional(Long id);
	Optional<Member> optional(String name);
	
	List<Member>list();

}

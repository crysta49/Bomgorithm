package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import hello.hellospring.domain.Member;

public class MemoryMemberRepository implements MemberRepository {
	
	private static Map<Long, Member> store = new HashMap<>();
	private static long Sequence =0L;
	
	@Override
	public Member save(Member member) {		
		 member.setId(++Sequence);
		 store.put(member.getId(), member);
		 return member;
	}
	
	@Override
	public Optional<Member> optional(Long id) {
		
		return Optional.ofNullable(store.get(id)); 
		// null 허용 
	}
	
	@Override
	public Optional<Member> optional(String name) {
		
		return store.values().stream()
					.filter(member -> member.getName().equals(name) )
					.findAny();
		
	}
	
	@Override
	public List<Member> list() {
		
		
		return  new ArrayList<>(store.values());
	}

}

package com.korea.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;






public interface MemberRepository extends 
       JpaRepository<Member,Long>,
       QuerydslPredicateExecutor<Member>{
	
//idx 내림차순 정렬을 위한 제작된 메소드	
	List<Member> findAllByOrderByIdxDesc();
	List<Member> findAllByNameContainingOrderByIdxDesc(String name);
	List<Member> findAllByRoadAddressContainingOrderByIdxDesc(String name);
	Member findByUsername(String username);	
	//	db에 받아온 아이디가 존재하지 확인 유무를 리턴하는 매소드 
    boolean existsByUsername(String username);

	//     member findByUserid(String userid); == member를 반환함 위의 boolean은 아이디의 존재 유무만을 반환 . 
    
    
    
    
    @Query(value = "select max(idx) + 1 from Member" ,nativeQuery = true) Long findMaxidx();


}



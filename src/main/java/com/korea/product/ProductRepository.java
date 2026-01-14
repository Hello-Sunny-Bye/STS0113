package com.korea.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.korea.member.Member;


public interface ProductRepository extends 
JpaRepository<Product,Long>,
QuerydslPredicateExecutor<Product>{
	List<Product> findAllByOrderByIdxDesc();

    @Query(value = "SELECT IFNULL (MAX(idx),10000 )+ 1 from product" ,nativeQuery = true) Long findMaxIdx();

	
	
}

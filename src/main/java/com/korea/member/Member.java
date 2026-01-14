package com.korea.member;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name="member")
public class Member {
//회원번호 유저아이디 패스워드 이름  나이 번호 주소 etc
	//idx userid password name age tel addr etc
	
	@Id //기본 키 
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 자동증가
	private Long idx; // pk사용
	
	@Column(length =20 ,unique = true, nullable = false)
	private String username;
	

	@Column(length =100,nullable = false)
	private String password;
	
	@Column(length =20,nullable = false)
	private String role;
	@Column(length =20)
	private String name;
	@Column(length =3)
	private int age;
	@Column(length =14)
	private String tel;
	
	//private String addr;
	
	@Column(length =500)
	private String etc;

	@Column(length =6)
	private String postcode;
	@Column(length =100)

	private String roadAddress;	
	@Column(length =50)
	private String jibunAddress;	
	@Column(length =100)
	private String detailAddress;	
	@Column(length =100)
	private String extraAddress;
	
	@Transient
	private  String ch1;
	
	@Transient
	private  String ch2;
	
	
	
	
	
}

package com.korea.product;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
	 @Id //기본 키 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)// 자동증가
	 private  Long  idx;
	
	 @Column(length =2, nullable = false )
	  private String  categoty;
	 
	  @Column(length =10 ,unique = true, nullable = false)
	  private String  pid;
	  @Column(length =30 , nullable = false)
	  private String  pnam;
	
	  private int pprice;
	  private  String pdesc;
	  private  int quantity;
	  @Transient
	  private  MultipartFile    pfile;
	  private  String pimgname;

	  private  String padmin;
	  private  String today ;

		@Transient
		private  String ch1;
		
		@Transient
		private  String ch2;
		
	  
}


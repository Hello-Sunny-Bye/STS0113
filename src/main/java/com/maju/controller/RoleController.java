package com.maju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
	
	
	@GetMapping("/admin/main.do") 
	public String  admin(){
		return "admin/main";		
	}
	
	@GetMapping("/maneger/main.do") 
	public String  maneger(){
		return "maneger/main";		
	}
	
	@GetMapping("/product/main.do") 
	public String  product(){
		return "product/main";		
	}
	
	
	
	
}
package com.maju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//타임리프는 기본적으로 templates 파일로 가게되있음 리턴이 없을시 메소드와 동일한 파일로 가게설정되어있음 
@Controller
public class IndexController {
	
	@GetMapping("main")
	void main() {
		System.out.println("==>");
		
	
	}
}

package com.maju.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.korea.member.Member;
import com.korea.member.MemberRepository;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/member/")
@Controller
public class MemberController {
		
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder ;
	
	@GetMapping("main.do")
	String main() {
		System.out.println("==>");
		return "member/form";
	
	}
	
	@GetMapping("form.do")
	String form() {
		System.out.println("==>");
		return "member/form";
	
	}
	
	
	@PostMapping("formOK.do")
	String formOK(Member member ) {
		System.out.println("==>formOK");
	
		String password = passwordEncoder.encode(member.getPassword());
		member.setPassword(password);
		memberRepo.save(member);
	
		return "redirect:/member/list.do";
				
				
	}
    // 패스워드 평문과 암호값 확인 메소드 
	public boolean login(String rawPassword, String encodedPassword) {
	    return passwordEncoder.matches(rawPassword, encodedPassword);
	}

	
	@ResponseBody
	@GetMapping(value = "idCheck.do")
	public String idCheck( @RequestParam String username ) {

		 return memberRepo.existsByUsername(username)?"T" : "F";	// 삼각연산자
	}
	
	
	@GetMapping("list.do")  //목록가기 
	public String list(Model model,Member member) {
		
		
	if("name".equals(member.getCh1())){
		model.addAttribute("li", memberRepo.findAllByNameContainingOrderByIdxDesc(member.getCh2()));

	}else if("roadAddress".equals(member.getCh1())){
		model.addAttribute("li", memberRepo.findAllByRoadAddressContainingOrderByIdxDesc(member.getCh2()));

	}else
	{
		model.addAttribute("li", memberRepo.findAllByOrderByIdxDesc());
	}
	
	
		return "member/list";
	}
	
	@GetMapping("edit.do") //상세보기로 가기위한 구문
	String  edit(Model model, Member vo){
		System.out.println("==> edit.do ");
		Member m = memberRepo.findById(vo.getIdx())
		        .orElseThrow(() -> new IllegalArgumentException("잘못된 접근"));
		model.addAttribute("m", m );
		return "member/edit";		
	}
	
	
	
	@GetMapping("delete.do") 
	String  delete(Model model, Member vo) {
		memberRepo.deleteById(vo.getIdx());
		
		return "redirect:/member/list.do";		
	}
	
	
	@PostMapping("update.do")
	String update(Member member ) {
		System.out.println("==>formOK");
		
		
		String password = passwordEncoder.encode(member.getPassword());
		member.setPassword(password);
		
		memberRepo.save(member);
		
				return "redirect:/member/list.do";
				
				
	}
	
//	로그인 창으로 향하는 거 
	@GetMapping(value="/login.do") 
	public String  login(){
		return "member/login";		
	}
	@GetMapping(value="/loginSuccess.do") 
	public String  loginSuccess(){
		return "member/success";		
	}
	
	
	@GetMapping(value="/accessDenied.do") 
	public String  accessDenied(){
		return "member/accessDenied";		
	}
	
	//로그인 폼전송 @{loginOK.do}


	@PostMapping("loginOK.do")
	String loginOK(Model  model , Member member, HttpSession session) {
	   Member  m = memberRepo.findByUsername(member.getUsername());
	   System.out.println("===> m:" + m);
	   if(m == null) {
		   return "member/false";
	   }else {
		   String rawPassword = member.getPassword();
		   String encodedPassword = m.getPassword();
		   boolean sw = login(rawPassword,encodedPassword );
		   if(sw) {
			    session.setAttribute("Member", m);
		        session.setAttribute("Userid", m.getUsername());
		        session.setAttribute("Name", m.getName());
			   return "member/success";
		   }else {
			   return "member/false";
		   }		   
	   }

	}
	

	@GetMapping(value="/logout.do") 
	public String  logout(HttpSession  session){
		System.out.println("==> logout.do 확인 ");	
		
		// 세션 전체 삭제 
		session.invalidate();
		return "redirect:/member/login.do";		
	}



}


				
	


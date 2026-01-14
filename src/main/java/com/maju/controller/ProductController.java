package com.maju.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.korea.product.Product;
import com.korea.product.ProductRepository;
import com.korea.product.S3UploadService;
@RequestMapping("/product/")
@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private S3UploadService s3UploadService;
	
	@GetMapping("form.do")
	String form() {
		System.out.println("==>");
		return "product/form";
	
	}
	
	@PostMapping("formOK.do")
	String formOK(Product vo ) {
		System.out.println("==>formOK");
		Long maxidx = productRepo.findMaxIdx();
		vo.setPid(vo.getCategoty()+ maxidx);
		
		
		//s3파일업로드
		String filename = s3UploadService.uploadFile(vo.getPfile());
		vo.setPimgname(filename);
		productRepo.save(vo);
		return "redirect:/product/list.do";
				
		}
	
	@GetMapping("list.do")
	String list(Model model , Product vo) {
		System.out.println("==>");
		
		model.addAttribute("li",productRepo.findAllByOrderByIdxDesc());
		
		return "product/list";
	
	}
}

package com.pool.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.pool.model.User;
import com.pool.util.InfinityUtils;
import com.pool.util.Literals;

@Controller
@RequestMapping("/upload")
public class UserWebController {
	/*@Autowired
	private CommonsMultipartResolver  multipartResolver;*/
	@GetMapping("/test")
	public String Login(HttpServletRequest request) {
	return "Welcome";	
	}
	@GetMapping("/userprofile")
	public String getUserProfile() {
		return "UserProfile";
	}
	
	@PostMapping("/uploadprofilepic")
	public String uploadProfilePic(HttpServletRequest request,@RequestParam("file") MultipartFile file) throws IOException {
		User user=(User) request.getSession().getAttribute("user");
		String path=Literals.filePath+user.getUserId()+"/";
		System.out.println(path);
		System.out.println("File NAme:"+file.getOriginalFilename());
		if(file.getOriginalFilename().contains(".jpeg")|| file.getOriginalFilename().contains(".png")|| file.getOriginalFilename().contains(".jpg")) {
			System.out.println("1."+file.getOriginalFilename());
			System.out.println("2."+file.getContentType());
			System.out.println("3."+file.getBytes());
			System.out.println("4."+StringUtils.cleanPath(file.getOriginalFilename()));
			System.out.println("5."+file.toString());
			//String base64=Base64.encodeBase64String(file.getBytes());
			String base64=Base64.encodeBase64String(file.getBytes());
			System.out.println("6."+base64);	
		}
		
		if (!file.isEmpty()) {
		java.io.File fileDir = new java.io.File(path);
		if (!fileDir.exists()) {
		fileDir.mkdirs();
		}
		FileCopyUtils.copy(file.getBytes(), new java.io.File(path +file.getOriginalFilename()));
		
		}
		
		
		return "redirect:/upload/userprofile";
	}
}

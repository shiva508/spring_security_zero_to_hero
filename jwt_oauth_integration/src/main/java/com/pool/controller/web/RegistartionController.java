package com.security.controller.web;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.security.forms.Feedback;
import com.security.forms.RegistrationForm;
import com.security.forms.RoleForm;
import com.security.service.mail.MailService;
import com.security.service.registration.RegistrationService;

@Controller
@RequestMapping("/registraion")
public class RegistartionController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private MailService mailService; 
	
	private static final Logger logger = LogManager.getLogger(RegistartionController.class);

	@GetMapping(value = "/")
	public String welcomePage(Model model) {
		RegistrationForm registration = new RegistrationForm();
		model.addAttribute("registration", registration);
		return "welcome";
	}

	@GetMapping("/users")
	public String usersList(Model model) {
		model.addAttribute("users",registrationService.usersList());
		return "usersList";
	}
	@GetMapping("/user/{userid}")
	public String getUser(@PathVariable("userid")Integer userid,Model model) {
		model.addAttribute("registration",registrationService.getUserByUserId(userid));
		return "updateuser";
	}
	@GetMapping("/deleteuser/{userid}")
	public String deleteUser(@PathVariable("userid")Integer userid,Model model) {
		registrationService.deleteUser(userid);
		return "redirect:/users";	
	}
	@GetMapping("/viewuser/{userid}")
	public String viewUser(@PathVariable("userid")Integer userid,Model model) {
		model.addAttribute("user",registrationService.getUserByUserId(userid));
		return "viewUser";	
	}
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("registration") RegistrationForm registration, Model model ) {
		registrationService.updateUser(registration);
		return "redirect:/users";
	}
	@PostMapping("/formregistration")
	public String registration(@Valid @ModelAttribute("registration") RegistrationForm registration, Model model,
			BindingResult result) {
		String view = "";
		model.addAttribute("registration", registration);
	
		if (result.hasErrors()) {
			view = "welcome";
		} else {
			System.out.println(registration.getUserName());
			Long userid=registrationService.isUserExist(registration.getUserName());
			if(userid>0) {
				view="UserExist";
			}else {
				if(registration.getDummyRoles().size()>0) {
					for (String role :registration.getDummyRoles() ) {
						registration.getRoles().add(new RoleForm("ROLE_"+role.trim()));	
					}
				}
				//registration.setRoles(Arrays.asList(new RoleForm("ROLE_USER"),new RoleForm("ROLE_ADMIN")));
				registrationService.saveUser(registration);	
				view = "registrationConform";
			}
		}
		return view;
	}

	@GetMapping("/customlogin")
	public String loginpage() {
		return "login";
	}

	@GetMapping("/myform")
	public String myform() {
		return "MyForm";
	}

	@GetMapping("/fromexp")
	public String fromexp(HttpServletRequest request, Model model, @RequestParam("myname") String myName) {
		String name1 = request.getParameter("myname");
		model.addAttribute("name1", name1);
		model.addAttribute("myName", myName);
		return "ParamExe";
	}
}

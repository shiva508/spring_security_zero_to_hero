package com.pool.controller;/*package com.infinity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infinity.form.FeedbackViewModel;
import com.infinity.service.feedback.FeedbackSender;

@Controller
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackController {
	@Autowired
	private FeedbackSender feedbackSender;

@PostMapping
	public void sendFeedback( @RequestBody FeedbackViewModel feedbackViewModel, BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		System.out.println("Errordx");
	}else {
		System.out.println(feedbackViewModel);
		feedbackSender.sendFeedback(feedbackViewModel.getEmail(), feedbackViewModel.getName(), feedbackViewModel.getFeedback());
	
	}
	}
}
*/
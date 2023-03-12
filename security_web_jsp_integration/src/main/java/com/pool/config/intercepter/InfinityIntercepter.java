package com.pool.config.intercepter;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.pool.controller.MoneyManagerController;
import com.pool.dao.UserRepository;
import com.pool.model.User;

@Component
public class InfinityIntercepter extends HandlerInterceptorAdapter {
	private static final Logger logger = LogManager.getLogger(MoneyManagerController.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof UserDetails) {
				String username = ((UserDetails) principal).getUsername();
				String password = ((UserDetails) principal).getPassword();
				logger.info("User name->{}", username);
				logger.info("password->{}", password);
				if (username != null && password != null) {
					Optional<User> optionalUser = userRepository.findByUserNameAndPassword(username, password);
					if (optionalUser.isPresent()) {
						session.setAttribute("user", optionalUser.get());
					}
				}
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse v, Object handler, ModelAndView modelAndView)
			throws Exception {
		if (modelAndView != null) {
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				modelAndView.addObject("user", user);
			} else {
				modelAndView.setViewName("login");
			}
		}
	}
}

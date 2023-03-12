package com.pool.utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.security.dress.model.DressImages;
import com.security.dress.model.DressModel;
import com.security.dress.poll.domine.Poll;
import com.security.forms.ValidationResponse;
import com.security.oauth.forms.UserPrinicipal;
import com.security.oauth.model.UserModel;

@Component
public class DressUtil {

	public String dressCodeGenerator(DressModel dressModel) {
		String tokenizer = dressModel.getName();
		return "";
	}

	public List<ValidationResponse> validationResponseExtractor(BindingResult result) {
		List<FieldError> errorList = result.getFieldErrors();
		List<ValidationResponse> validationResponse = new ArrayList<>();
		validationResponse = errorList.stream()
				.map(error -> new ValidationResponse(error.getField(), error.getDefaultMessage()))
				.collect(Collectors.toList());
		return validationResponse;
	}

	public ResponseEntity<?> validationResponseExtractorResult(BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> errorList = result.getFieldErrors();
			List<ValidationResponse> validationResponse = new ArrayList<>();
			validationResponse = errorList.stream()
					.map(error -> new ValidationResponse(error.getField(), error.getDefaultMessage()))
					.collect(Collectors.toList());
			return new ResponseEntity<List<ValidationResponse>>(validationResponse, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	public boolean userNameChecker(String usernameSource, String usernameDestination) {
		return usernameSource.trim().equalsIgnoreCase(usernameDestination.trim());
	}

	public boolean emailChecker(String emailSource, String emailDestination) {
		return emailSource.trim().equals(emailDestination.trim());
	}

	public String generateUniqueUserName(UserModel userModel) {
		StringBuffer uniqueUserName = new StringBuffer();
		String firstName = userModel.getFirstName().substring(0, 1).toUpperCase();
		String lastName = userModel.getLastName().substring(0, 1).toUpperCase();
		String uniqueNumber = RandomStringUtils.randomNumeric(6);

		uniqueUserName.append(firstName);
		uniqueUserName.append(lastName);
		uniqueUserName.append(uniqueNumber);

		return uniqueUserName.toString();
	}

	public UserPrinicipal generateUserPriincipal(UserModel userModel) {

		return new UserPrinicipal(userModel);
	}

	public void dressImageProcessor(DressModel dressModel) {
		if (null != dressModel.getDressImages() && dressModel.getDressImages().size() > 0) {
			List<DressImages> images = dressModel.getDressImages();
			for (DressImages dressImage : images) {
				dressModel.addImages(dressImage);
			}
		}
	}

	public HttpHeaders urlGenerator(String urlData, Object object) {
		String data = "";
		if (object instanceof Poll) {
			Poll pollObject = (Poll) object;
			data = Long.toString(pollObject.getPollId());
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(urlData).buildAndExpand(data).toUri();
		return httpHeaders;
	}

	public Cookie cookieSetter(String cookieName, String cookieValue) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(24 * 60 * 60);
		return cookie;
	}

}

package com.pool.oauth.service;

import java.util.List;
import java.util.Map;

import com.security.forms.UserModelResponse;
import com.security.oauth.model.UserModel;

public interface UserModelService {
	
	public UserModel userRegistartion(UserModel userModel);

	public List<UserModel> allUserModels();

	public UserModel getUserModelByUserName(String username);

	public UserModel findByEmail(String email);
	
	public boolean validateUser(UserModel userModel);

	public Map<String, String> getUserNamePassword();
	
	public UserModel updateUser(UserModel userModel);
	
	public UserModelResponse deleteUserModel(Long userId);
}

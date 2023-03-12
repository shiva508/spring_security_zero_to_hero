package com.pool.oauth.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.forms.UserModelResponse;
import com.security.oauth.constants.RoleEnum;
import com.security.oauth.exception.UserNotFoundException;
import com.security.oauth.exception.UsernameExistException;
import com.security.oauth.model.UserModel;
import com.security.oauth.repository.UserModelRepository;
import com.security.service.email.EmailService;
import com.security.utils.DressUtil;


@Service
public class UserModelServiceImpl implements UserModelService {

	@Autowired
	private UserModelRepository userModelRepository;
	
	@Autowired
	private DressUtil dressUtil;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	@Transactional
	public UserModel userRegistartion(UserModel userModel) {
		String uniqueUserName=dressUtil.generateUniqueUserName(userModel);
		userModel.setUsername(uniqueUserName);
		emailService.emailSender(userModel);
		userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		userModel.setRoles(RoleEnum.ROLE_USER.name());
		userModel.setAuthorities(RoleEnum.ROLE_USER.getAuthorities());
		return userModelRepository.save(userModel);
	}

	@Override
	@Transactional
	public List<UserModel> allUserModels() {
		List<UserModel> userModels=userModelRepository.findAll();
		if(null ==userModels || userModels.size()==0) {
			throw new UserNotFoundException("Sorry no users are found");
		}
		return userModels;
	}

	@Override
	@Transactional
	public UserModel getUserModelByUserName(String username) {
		UserModel userModel=userModelRepository.findByUsername(username);
		if(null==userModel) {
			throw new UserNotFoundException("No User Found With Name:"+username);
		}
		return userModel;
	}

	@Override
	@Transactional
	public UserModel findByEmail(String email) {
		UserModel userModel=userModelRepository.findByEmail(email);
		
		  if(null==userModel) { 
			  throw new UserNotFoundException("No User Found With Email:"+email); 
			}
		 
		return userModel;
	}
	
	@Override
	@Transactional
	public boolean validateUser(UserModel userModel) {
		boolean userExist=false;
		UserModel model=userModelRepository.findByUsernameOrEmail(userModel.getUsername(), userModel.getEmail());
		if(model==null) {
			userExist=true;
		} else {
		boolean	userNameExist=dressUtil.userNameChecker(userModel.getUsername(),model.getUsername());
		boolean	emailExist=dressUtil.emailChecker(userModel.getEmail(),model.getEmail());
		
		if(userNameExist && emailExist) {
			throw new UsernameExistException("User Is Exist With The User Name and Email,Please try with other User Name,Email");
		}
		if(userNameExist) {
			throw new UsernameExistException("User Is Exist With The User Name ,Please try with other User Name,");
		}
		if( emailExist) {
			throw new UsernameExistException("User Is Exist With The Email,Please try with other Email");
		}
		userExist=userNameExist && emailExist;
		}
		
		return userExist;
	}

	@Override
	@Transactional
	public Map<String, String> getUserNamePassword() {
		List<UserModel>  userModelList=userModelRepository.findAll();
		
		return userModelList
				.stream()
				.collect(Collectors.toMap(userMode->userMode.getUsername(), userMode->userMode.getPassword()));
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		String uniqueUserName=dressUtil.generateUniqueUserName(userModel);
		userModel.setUsername(uniqueUserName);
		emailService.emailSender(userModel);
		//userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		userModel.setRoles(RoleEnum.ROLE_USER.name());
		userModel.setAuthorities(RoleEnum.ROLE_USER.getAuthorities());
		return userModelRepository.save(userModel);
	}

	@Override
	public UserModelResponse deleteUserModel(Long userId) {
		userModelRepository.deleteById(userId);
		UserModelResponse modelResponse=new UserModelResponse(); 
		modelResponse.setMessage("User Is deleted");
		return modelResponse;
	}

}

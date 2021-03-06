package com.accounting.service;

import java.util.List;
import java.util.Map;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.accounting.bo.Banner;
import com.accounting.bo.FacebookProfile;
import com.accounting.repository.BannerRepository;
import com.accounting.repository.UserDeviceRepository;
import com.accounting.repository.UserRepository;
import com.accounting.user.bo.User;
import com.accounting.user.bo.UserDevice;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDeviceRepository userDeviceRepository;
	
	@Autowired
	BannerRepository bannerRepository;
	
	/***********  USER BLOCK STARTS *****************/
	public User findUserById(Long userId) {
		return userRepository.findOne(userId);
	}
	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	/***********  USER BLOCK ENDS *****************/
	
	public UserDevice saveUserDeviceInfo(UserDevice userDevice) {
		return userDeviceRepository.save(userDevice);
	}
	
	public List<UserDevice> findUserDevicesByUserId(Long userId) {
		return userDeviceRepository.findByUserId(userId);
	}
	
	public List<User> findUsersByMainCourseIdsAndSecondryCourseIds(String mainCourseIds,String secondryCourseIds) {
		return userRepository.findByMainCourseIdsAndSecondryCourseIds(mainCourseIds, secondryCourseIds);
	}
	
	public User findUserByFacebookId(String facebookId) {
		return userRepository.findUserByFacebookID(facebookId);
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	public User findUserByUserId(Long userId) {
		return userRepository.findUserByUserId(userId);
	}
	public User findUserByResetToken(String resetToken) {
		return userRepository.findByResetTokenAndResetTokenCreatedAt(resetToken);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUserFromFacebookProfile(User user) {
		FacebookService facebookService = new FacebookService();
		FacebookProfile facebookProfile = facebookService.facebookProfile(user.getFacebookAuthToken());
		if ( StringUtils.isEmpty(user.getFirstName()) && !StringUtils.isEmpty(facebookProfile.getName())) {
			user.setFirstName(facebookProfile.getName());
		}
		if ( StringUtils.isEmpty(user.getEmail()) && !StringUtils.isEmpty(facebookProfile.getEmail())) {
			user.setEmail(facebookProfile.getEmail());
		}
		if (user.getUserId() == null && facebookProfile.getPicture() != null) {
			Map<String,Object> pictureMap = facebookProfile.getPicture();
			Map<String,String> dataMap = (Map<String,String>)pictureMap.get("data");
			user.setPhoto(dataMap.get("url"));
		}
		if (StringUtils.isEmpty(user.getUsername()) ) {
			user.setUsername(user.getFirstName().toLowerCase().replaceAll(" ",".")+System.currentTimeMillis());
		}

		return user;
	}
	
	public User updateUserFromGoogleProfile(User user) {
		GoogleService googleService = new GoogleService();
		JSONObject userJson = googleService.getUserInfo(user.getGoogleAuthToken());
		try {
			if ( StringUtils.isEmpty(user.getFirstName()) && userJson.has("name") && !StringUtils.isEmpty(userJson.getString("name")) ) {
				user.setFirstName(userJson.getString("name"));
			}
			if ( StringUtils.isEmpty(user.getEmail()) && (userJson.has("email") && !StringUtils.isEmpty(userJson.getString("email")))) {
				user.setEmail(userJson.getString("email"));
			}
			if (userJson.has("id") && userJson.get("id") != null) {
				user.setGoogleId(userJson.getString("id"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User findUserByGoogleAccessToken(String googleAccessToken) {
		GoogleService googleService = new GoogleService();
		JSONObject userJson = googleService.getUserInfo(googleAccessToken);
		String userEmail = null;
		try {
			userEmail = userJson.getString("email");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User googleUser = this.findUserByEmail(userEmail);
		return googleUser;
	}
	
	public Banner saveBanner(Banner banner) {
		return bannerRepository.save(banner);
	}
}

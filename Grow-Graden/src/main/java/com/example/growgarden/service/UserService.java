package com.example.growgarden.service;

import org.apache.catalina.User;

import com.example.growgarden.exception.UserException;
import com.example.growgarden.request.LoginRequest;
import com.example.growgarden.responce.AuthResponse;

public interface UserService {
	
	/**
	 * This method for create new user 
	 * @param user
	 * @return response of AuthResponse class 
	 * @throws UserException
	 */
	public AuthResponse createUser(User user) throws UserException;
	
	
	public AuthResponse userLogin(LoginRequest loginRequest);
	
	
	/**
	 * This method for find user using user id 
	 * @param userId
	 * @return User 
	 */
	public User findUseById(Long userId) throws UserException;
	
	/**
	 * This method find user profile using jwt 
	 * @param jwt
	 * @return User 
	 * @throws UserException
	 */
	public User findUserProfileByJwt(String jwt) throws UserException;

}

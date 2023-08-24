package com.example.growgarden.service;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.growgarden.config.JwtProvider;
import com.example.growgarden.exception.UserException;
import com.example.growgarden.repository.UserRepository;
import com.example.growgarden.request.LoginRequest;
import com.example.growgarden.responce.AuthResponse;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	private PasswordEncoder passwordEncoder;
	private CustomeUserServiceImpl customeUserServiceImpl;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder,
			CustomeUserServiceImpl customeUserServiceImpl) {
		super();
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
		this.passwordEncoder = passwordEncoder;
		this.customeUserServiceImpl = customeUserServiceImpl;
	}

	@Override
	public AuthResponse createUser(User user) throws UserException {
		// TODO Auto-generated method stub

		Optional<User> optional = userRepository.findByEmail(user.getEmail());
		
		if(optional.isPresent()) throw  new UserException("Email is already used try with another email");
	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	
		userRepository.save(user);

		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.genrateTokan(authentication);

		return new AuthResponse(token, "Signup Success");
	}

	@Override
	public AuthResponse userLogin(LoginRequest loginRequest) {
		// TODO Auto-generated method stub

		Authentication authentication = authenticate(loginRequest.getEmail(), loginRequest.getPassword());

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.genrateTokan(authentication);

		return new AuthResponse(token, "Signin Success");
	}

	@Override
	public User findUseById(Long userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Authentication authenticate(String username, String password) {
		// TODO Auto-generated method stub
		UserDetails userDetails = customeUserServiceImpl.loadUserByUsername(username);
		if (userDetails == null)
			throw new BadCredentialsException("Invalid Username");
		if (!passwordEncoder.matches(password, userDetails.getPassword()))
			throw new BadCredentialsException("Invalid Password");
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

}

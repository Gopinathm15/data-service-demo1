package com.datalayer.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.datalayer.repository.UserRepository;
import com.datalayer.request.User;
import com.datalayer.response.CommonResponse;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity storeUserDetails(User user) throws ParseException {
		com.datalayer.domains.User userToSave = new com.datalayer.domains.User();
		userToSave.setName(user.getName());
		userToSave.setAccountNumber(user.getAccountNumber());
		userToSave.setDob(new SimpleDateFormat("dd-MMM-yyyy").parse(user.getDob()));
		userRepository.save(userToSave);
		return ResponseEntity.ok(new CommonResponse(null));
	}

	public ResponseEntity getUserDetails() {
		List userFromDB = userRepository.findAll();
		return ResponseEntity.ok(new CommonResponse(userFromDB));
	}
}

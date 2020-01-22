package com.datalayer.controllers;

import java.io.IOException;
import java.text.ParseException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datalayer.request.RequestValidation;
import com.datalayer.request.User;
import com.datalayer.services.UserService;

@RestController
@RequestMapping("/user-service")
public class UserController {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RequestValidation requestValidation;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity addUserDetails(@Valid @RequestBody User user, BindingResult bindingResult)
			throws IOException, ParseException {

		if (bindingResult.hasErrors()) {
			return requestValidation.getErrorDetails(bindingResult);
		}
		return userService.storeUserDetails(user);
	}

	@RequestMapping(value = "/get-all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity getUserDetails() throws IOException {
		return userService.getUserDetails();
	}
}

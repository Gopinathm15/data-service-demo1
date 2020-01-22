package com.datalayer.request;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.datalayer.response.CommonResponse;
import com.datalayer.response.ErrorMessage;

@Component
public class RequestValidation {

	public static final Logger LOGGER = LoggerFactory.getLogger(RequestValidation.class);

	public ResponseEntity getErrorDetails(BindingResult bindingResult) {
		List<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
		LOGGER.info("Inside getErrorDetails()");

		CommonResponse commonResponse = new CommonResponse<>("FAILURE", 400);
		ErrorMessage error = null;

		for (int i = 0; i < bindingResult.getErrorCount(); i++) {
			error = new ErrorMessage();
			error.setMessage(bindingResult.getFieldErrors().get(i).getDefaultMessage());
			error.setField(bindingResult.getFieldErrors().get(i).getField());
			error.setCode(bindingResult.getFieldErrors().get(i).getDefaultMessage());
			errorList.add(error);
		}
		commonResponse.setErrorMessages(errorList);

		return ResponseEntity.status(HttpStatus.OK).body(commonResponse);
	}

}

package com.datalayer.controllers;

import java.io.IOException;

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

import com.datalayer.domains.FileData;
import com.datalayer.request.RequestValidation;
import com.datalayer.services.FileService;

@RestController
@RequestMapping("/file-service")
public class FileController {

	public static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileService fileService;

	@Autowired
	private RequestValidation requestValidation;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity addUserDetails(@Valid @RequestBody FileData fileData, BindingResult bindingResult)
			throws IOException {

		if (bindingResult.hasErrors()) {
			return requestValidation.getErrorDetails(bindingResult);
		}

		return fileService.storeFileData(fileData);
	}

	@RequestMapping(value = "/get-all",method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity getFileDetails() throws IOException {
		return fileService.getFileData();
	}
}

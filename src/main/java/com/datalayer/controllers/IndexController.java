package com.datalayer.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	ModelAndView root(ModelAndView modelAndView) {
		modelAndView.setViewName("User");
		return modelAndView;
	}

	@RequestMapping("/index")
	ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("User");
		return modelAndView;
	}

	@RequestMapping("/chart")
	ModelAndView chart(ModelAndView modelAndView) {
		modelAndView.setViewName("Chart");
		return modelAndView;
	}

	@RequestMapping("/upload-file")
	ModelAndView basicDetails(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("UploadFile");
		return modelAndView;
	}

}

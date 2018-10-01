package com.capgemini.bankappspring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.bankappspring.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public String handleException(UserNotFoundException ex,HttpServletRequest request) {
		request.setAttribute("success", ex.toString());
		return "success";
	}
	

}

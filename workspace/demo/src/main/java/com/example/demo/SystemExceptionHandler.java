package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.exception.SystemException;

@ControllerAdvice
public class SystemExceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SystemException.class)
	public String handleSystemError(Model model) {
		model.addAttribute("message", "システムエラーが発生しました");
		return "/Error";
	}
}

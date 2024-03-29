package co.com.godxvincent.ninjabackend.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	
	public static final String ISE_VIEW = "error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return this.ISE_VIEW;
	}
}

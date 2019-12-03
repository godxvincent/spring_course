package co.com.godxvincent.ninjabackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	private static final String VIEW_404 = "404";
	private static final String VIEW_500 = "500";
	
	@GetMapping("/page404")
	public String error404() {
		return this.VIEW_404;
	}
	
	@GetMapping("/page500")
	public String error500() {
		return this.VIEW_500;
	}
}

package co.com.godxvincent.ninjabackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {
	
	
	private static final String EXAMPLE_VIEW = "example2"; 
	
	
	// Primer forma de pasar un parametro por GET.
	// localhost:8080/example2/request1?nm=Ricardo
	// localhost:8080/example2/request1?nm=Andrés
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm", required = false, defaultValue = "NULL") String name) {
		ModelAndView mav = new ModelAndView(this.EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		return mav; 
	}
	
	
	// Segunda forma de pasar un parametro por GET.
	// localhost:8080/example2/request1/Ricardo
	// localhost:8080/example2/request1/Andrés
	// El nombre del parametro en @getmapping tiene que llamarse igual al del @pathvariable
	@GetMapping("/request2/{nm2}")
	public ModelAndView request2(@PathVariable("nm2") String name) {
		ModelAndView mav = new ModelAndView(this.EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		return mav; 
	}
}

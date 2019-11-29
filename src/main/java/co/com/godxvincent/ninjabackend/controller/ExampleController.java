package co.com.godxvincent.ninjabackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
//Aquí empiezo a especificar la ruta de la aplicación 
@RequestMapping("/example")
public class ExampleController {

	
	public static final String EXAMPLE_VIEW = "example";
	// Primera forma de llamar un template
	// @GetMapping("/exampleString") Esta forma estan apartir de las versiones 4.3 
	@RequestMapping(value="/exampleString", method = RequestMethod.GET)
	public String exampleString( ) {
		// Nombre del template sin adicionar al final .html
		return this.EXAMPLE_VIEW;
	}
	
	// Segunda forma de llamar un template.
	@RequestMapping(value="/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() {
		// Nombre del template sin adicionar al final .html
		return new ModelAndView(this.EXAMPLE_VIEW);
	}
}

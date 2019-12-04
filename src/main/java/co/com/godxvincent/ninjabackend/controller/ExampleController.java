package co.com.godxvincent.ninjabackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.com.godxvincent.ninjabackend.component.ExampleComponent;
import co.com.godxvincent.ninjabackend.model.Person;
import co.com.godxvincent.ninjabackend.service.ExampleService;


@Controller
//Aquí empiezo a especificar la ruta de la aplicación 
@RequestMapping("/example")
public class ExampleController {

	
	public static final String EXAMPLE_VIEW = "example";
	
	// Inyectar el componente exampleComponent - Indica a spring que se va a inyectar un componente cargado en memoria.
	@Autowired
	// usa el calificador o nombre que le pusimos en @Component("exampleComponent")
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	

	// Inyectar el servicio exampleService - Indica a spring que se va a inyectar un componente cargado en memoria.
	@Autowired
	// usa el calificador o nombre que le pusimos en @Services("exampleService")
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	
	// Primera forma de llamar un template
	// @GetMapping("/exampleString") Esta forma estan apartir de las versiones 4.3 
	@RequestMapping(value="/exampleString", method = RequestMethod.GET)
	public String exampleString(Model model ) {
		
		// Nombre del template sin adicionar al final .html
		model.addAttribute("people", exampleService.getListPeople());
		exampleComponent.sayHello();
		return this.EXAMPLE_VIEW;
	}
	
	// Segunda forma de llamar un template.
	@RequestMapping(value="/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() {
		
		// Nombre del template sin adicionar al final .html
		ModelAndView mav = new ModelAndView(this.EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		return  mav;
	}
	
	
	
}

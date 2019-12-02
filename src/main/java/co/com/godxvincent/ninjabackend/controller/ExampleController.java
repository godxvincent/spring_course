package co.com.godxvincent.ninjabackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.com.godxvincent.ninjabackend.model.Person;


@Controller
//Aquí empiezo a especificar la ruta de la aplicación 
@RequestMapping("/example")
public class ExampleController {

	
	public static final String EXAMPLE_VIEW = "example";
	// Primera forma de llamar un template
	// @GetMapping("/exampleString") Esta forma estan apartir de las versiones 4.3 
	@RequestMapping(value="/exampleString", method = RequestMethod.GET)
	public String exampleString(Model model ) {
		
		// Nombre del template sin adicionar al final .html
		model.addAttribute("people", this.getPeople());
		return this.EXAMPLE_VIEW;
	}
	
	// Segunda forma de llamar un template.
	@RequestMapping(value="/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() {
		
		// Nombre del template sin adicionar al final .html
		ModelAndView mav = new ModelAndView(this.EXAMPLE_VIEW);
		mav.addObject("people", this.getPeople());
		return  mav;
	}
	
	private List<Person> getPeople() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Ricardo", 32));
		people.add(new Person("Paula", 23));
		people.add(new Person("Paula", 23));
		people.add(new Person("Alguien Más", 99));
		return people;
		
	}
}

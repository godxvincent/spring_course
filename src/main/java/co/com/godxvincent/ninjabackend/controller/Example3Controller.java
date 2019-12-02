package co.com.godxvincent.ninjabackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.com.godxvincent.ninjabackend.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		// Estamos enviandole al form un objeto de tipo person para usarlo como base para usar en la creación del formulario.
		model.addAttribute("person" , new Person());
		// Nombre del template en los recursos que va a mostrar.
		return this.FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute(name = "person") Person person) {
		ModelAndView mav = new ModelAndView(this.RESULT_VIEW);
		mav.addObject("person", person);
		return mav;
	}
}

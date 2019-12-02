package co.com.godxvincent.ninjabackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import co.com.godxvincent.ninjabackend.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	// Para redirigir a otro recurso en caso de que quieran acceder a /example3
	/*
	 * @GetMapping("") public String redirect2() { return
	 * "redirect:/example3/showForm"; }
	 */ 
	
	@GetMapping({"/",""})
	public RedirectView redirect() {
		// Normalmente el parametro recibe la URL
		return new RedirectView("/example3/showForm");
	}
	
	
	
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

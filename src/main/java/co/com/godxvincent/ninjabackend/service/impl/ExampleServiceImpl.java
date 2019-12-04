package co.com.godxvincent.ninjabackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import co.com.godxvincent.ninjabackend.controller.Example3Controller;
import co.com.godxvincent.ninjabackend.model.Person;
import co.com.godxvincent.ninjabackend.service.ExampleService;

// Estas anotaciones le dicen al servidor que las precargue para ser usadas.
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private final static Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {
		
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Ricardo", 32));
		people.add(new Person("Paula", 23));
		people.add(new Person("Paula", 23));
		people.add(new Person("Alguien Más", 99));
		LOGGER.info("Hello From Service ");
		return people;
	}

}

package co.com.nxs.service;

import java.util.List;
import java.util.Optional;

import co.com.nxs.dto.PersonDTO;
import co.com.nxs.model.Person;

public interface PersonService {

	public List<Person> getAllPersons();

	public Person create(Person person);	
	
	public Optional<Person> getPersonById(Long id);
	
	public void deletePerson(Person person);	
	
	public void createPerson(PersonDTO person);
		
}

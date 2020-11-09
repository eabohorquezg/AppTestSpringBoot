package co.com.nxs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nxs.dto.PersonDTO;
import co.com.nxs.model.Family;
import co.com.nxs.model.Person;
import co.com.nxs.repository.PersonRepository;
import co.com.nxs.service.FamilyService;
import co.com.nxs.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	FamilyService familyService;
	
	@Override
	public List<Person> getAllPersons() {
		Iterable<Person> persons = personRepository.findAll();
        List<Person> list = new ArrayList<>();
        persons.forEach(list::add);
        return list;
	}

	@Override 
	public Person create(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Optional<Person> getPersonById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public void deletePerson(Person person) {
		 personRepository.delete(person);
	}

	@Override
	public void createPerson(PersonDTO persondto) {
		Family family = familyService.create(persondto.getFamilyNucleus().getFamily());
		Person person = persondto.getPerson();			 
		person.setFamily(family);  
		create(person); 
		for (Person parent : persondto.getFamilyNucleus().getPersons()) {
			parent.setFamily(family); 
			create(parent);   
		} 		  
	}

}

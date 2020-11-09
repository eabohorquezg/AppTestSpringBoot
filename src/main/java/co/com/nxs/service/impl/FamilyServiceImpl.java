package co.com.nxs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nxs.dto.FamilyDTO;
import co.com.nxs.model.Family;
import co.com.nxs.model.Person;
import co.com.nxs.repository.FamilyRepository;
import co.com.nxs.service.FamilyService;
import co.com.nxs.service.PersonService;

@Service
public class FamilyServiceImpl implements FamilyService{ 

	@Autowired
	FamilyRepository familyRepository;
	
	@Autowired
	PersonService personService;
	
	@Override
	public List<Family> getAllFamilies() {
		Iterable<Family> families = familyRepository.findAll();		
        List<Family> list = new ArrayList<>();
        families.forEach(list::add);
        return list;		
	}
	
	@Override
	public Family create(Family family) { 
		return familyRepository.save(family);
	}

	@Override
	public Optional<Family> getFamilyById(Long id) {
		return familyRepository.findById(id);
	}

	@Override
	public Family updateFamily(Family fromFamily) {			
		return familyRepository.save(fromFamily);		
	}

	@Override
	public void deleteFamily(Family family) {		
		familyRepository.delete(family);
	}

	@Override
	public void createFamily(FamilyDTO familydto) {
		Family family = create(familydto.getFamily());
		for (Person person : familydto.getPersons()) {			
			person.setFamily(family);
			personService.create(person);   
		}  
		
	}

	@Override
	public List<Person> getFamily(Long familyId) {
		List<Person> persons = new ArrayList<>();		
		for (Person person : personService.getAllPersons()) {
			if( familyId == person.getFamily().getFamilyId() ) {
				persons.add(person); 
			}
		} 
		return persons;
	}

	@Override
	public Family updatefamily(FamilyDTO familydto) {
		Family fam = getFamilyById(familydto.getFamily().getFamilyId()).get();
		fam.setFamilyName(familydto.getFamily().getFamilyName());
		fam.setResidenceAddress(familydto.getFamily().getResidenceAddress());
		return updateFamily(fam);
	}

	@Override
	public void deleteFamily(Long familyId) {
		Optional<Family> family = getFamilyById(familyId);		
		for (Person person : personService.getAllPersons()) {
			if( familyId == person.getFamily().getFamilyId() ) {
				personService.deletePerson(person);
			}
		}
		deleteFamily(family.get());
	}	
	
}

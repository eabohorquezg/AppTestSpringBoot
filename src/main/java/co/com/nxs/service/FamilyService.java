package co.com.nxs.service;

import java.util.List;
import java.util.Optional;

import co.com.nxs.dto.FamilyDTO;
import co.com.nxs.model.Family;
import co.com.nxs.model.Person;

public interface FamilyService {

	public List<Family> getAllFamilies();

	public Family create(Family family);	
	
	public void deleteFamily(Family family);	
	
	public Optional<Family> getFamilyById(Long id);
	
	public Family updateFamily(Family family);	 
	
	public void createFamily(FamilyDTO familydto);
	
	public List<Person> getFamily(Long familyId);
	
	public Family updatefamily(FamilyDTO familydto);
	
	public void deleteFamily(Long familyId);
}

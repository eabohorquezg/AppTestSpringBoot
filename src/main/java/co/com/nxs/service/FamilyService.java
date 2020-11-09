package co.com.nxs.service;

import java.util.List;
import java.util.Optional;

import co.com.nxs.model.Family;

public interface FamilyService {

	public List<Family> getAllFamilies();

	public Family createFamily(Family family);	
	
	public void deleteFamily(Family family);	
	
	public Optional<Family> getFamilyById(Long id);
	
	public Family updateFamily(Family family);	 
	
}

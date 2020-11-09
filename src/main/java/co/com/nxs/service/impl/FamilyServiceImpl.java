package co.com.nxs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.com.nxs.model.Family;
import co.com.nxs.repository.FamilyRepository;
import co.com.nxs.service.FamilyService;

@Service
public class FamilyServiceImpl implements FamilyService{

	@Autowired
	FamilyRepository familyRepository;
	
	@Override
	public List<Family> getAllFamilies() {
		Iterable<Family> families = familyRepository.findAll();		
        List<Family> list = new ArrayList<>();
        families.forEach(list::add);
        return list;		
	}
	
	@Override
	public Family createFamily(Family family) { 
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
	
}

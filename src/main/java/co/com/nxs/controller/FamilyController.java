package co.com.nxs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.nxs.dto.FamilyDTO;
import co.com.nxs.model.Audit;
import co.com.nxs.model.Family;
import co.com.nxs.model.Person;
import co.com.nxs.service.AuditService;
import co.com.nxs.service.FamilyService;
import co.com.nxs.service.PersonService;

@RestController
public class FamilyController {

	@Autowired
	FamilyService familyService;	
	
	@Autowired
	PersonService personService;
	
	@Autowired
	AuditService auditService; 
	
	@RequestMapping(value = "/createFamily", method = RequestMethod.POST)
    public ResponseEntity<Object> createFamily(@RequestBody FamilyDTO request) {	
		Audit audit = new Audit();
		audit.setHttpMethod("POST"); 
		audit.setInput(request.toString());   
		audit.setStartDate(new Date());
		auditService.create(audit); 
		try {
		Family family = familyService.createFamily(request.getFamily());
		for (Person person : request.getPersons()) {			
			person.setFamily(family);
			personService.create(person);   
		}  
		audit.setEndDate(new Date());  
		audit.setHttpResponse("200");
		audit.setOutput(family.toString());		
		auditService.create(audit);
		}catch(Exception e) {
			audit.setException(e.getMessage());
			auditService.create(audit);
		}
		return new ResponseEntity<Object>(request, HttpStatus.OK);	   	
    } 
	 	 
	@RequestMapping(value = "/family/{familyId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFamily(@PathVariable Long familyId) {
		Audit audit = new Audit();
		audit.setHttpMethod("GET"); 
		audit.setInput(familyId.toString());   
		audit.setStartDate(new Date());
		auditService.create(audit); 
		List<Person> persons = new ArrayList<>();		
		for (Person person : personService.getAllPersons()) {
			if( familyId == person.getFamily().getFamilyId() ) {
				persons.add(person);
			}
		} 
		audit.setEndDate(new Date());  
		audit.setHttpResponse("200");
		audit.setOutput(persons.toString());		
		auditService.create(audit);
		return new ResponseEntity<Object>(persons, HttpStatus.OK);			
    }  	
	
	@RequestMapping(value = "/updatefamily", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatefamily(@RequestBody FamilyDTO request ) {
		Family fam = familyService.getFamilyById(request.getFamily().getFamilyId()).get();
		fam.setFamilyName(request.getFamily().getFamilyName());
		fam.setResidenceAddress(request.getFamily().getResidenceAddress());		
		return new ResponseEntity<Object>(familyService.updateFamily(fam), HttpStatus.OK);			
    }   
	
	@RequestMapping(value = "/deletefamily/{familyId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteFamily(@PathVariable Long familyId) {			
		Optional<Family> family = familyService.getFamilyById(familyId);		
		for (Person person : personService.getAllPersons()) {
			if( familyId == person.getFamily().getFamilyId() ) {
				personService.deletePerson(person);
			}
		}
		familyService.deleteFamily(family.get());
		return new ResponseEntity<Object>("Borrado Satisfactorio", HttpStatus.OK);			
    }  		
	
}






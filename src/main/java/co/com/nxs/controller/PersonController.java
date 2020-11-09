package co.com.nxs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.nxs.dto.PersonDTO;
import co.com.nxs.model.Audit;
import co.com.nxs.model.Person;
import co.com.nxs.service.AuditService;
import co.com.nxs.service.FamilyService;
import co.com.nxs.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;	
	@Autowired
	FamilyService familyService; 
	@Autowired
	AuditService auditService; 
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllPersons() {	
		Audit audit = new Audit();
		List<Person> list = null;
		try {	
			auditService.startRecord(audit, "");
			list = personService.getAllPersons();
			auditService.endRecord(audit,list.toString());
		}catch(Exception e) {
			auditService.exceptionRecord(audit, e.getMessage());
		}
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	} 
	
	@RequestMapping(value = "/createPerson", method = RequestMethod.POST)
	public ResponseEntity<Object> createPerson(@RequestBody PersonDTO persondto) {
		Audit audit = new Audit();
		try {	
			auditService.startRecord(audit, persondto.toString());
			personService.createPerson(persondto); 
			auditService.endRecord(audit,persondto.toString());
		}catch(Exception e) {
			auditService.exceptionRecord(audit, e.getMessage());
		}
		return new ResponseEntity<Object>(persondto, HttpStatus.OK);			
	}  
	
	@RequestMapping(value = "/deletePerson/{personId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePerson(@PathVariable Long personId){	
		Audit audit = new Audit();
		try {
			auditService.startRecord(audit, personId.toString());
			personService.deletePerson(personService.getPersonById(personId).get());
			auditService.endRecord(audit, "Borrado Satisfactorio");
		}catch(Exception e) {
			auditService.exceptionRecord(audit, e.getMessage());
		}
		return new ResponseEntity<Object>("Borrado Satisfactorio", HttpStatus.OK);				
	}   
	
}

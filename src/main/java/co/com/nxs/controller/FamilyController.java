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
	public ResponseEntity<Object> createFamily(@RequestBody FamilyDTO familydto) {
		Audit audit = new Audit();
		try {	 
			auditService.startRecord(audit, familydto.toString());
			familyService.createFamily(familydto);
			auditService.endRecord(audit, familydto.toString());
		}catch(Exception e) {
			auditService.exceptionRecord(audit, e.getMessage());
		}
		return new ResponseEntity<Object>(familydto, HttpStatus.OK);	   	
	} 
	 	 
	@RequestMapping(value = "/family/{familyId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFamily(@PathVariable Long familyId) {		
		List<Person> persons = null;
		Audit audit = new Audit();
		try {
			auditService.startRecord(audit, familyId.toString());
			persons = familyService.getFamily(familyId);
			auditService.endRecord(audit, persons.toString());
		}catch(Exception e) {
			auditService.exceptionRecord(audit, e.getMessage());
		}	
		return new ResponseEntity<Object>(persons, HttpStatus.OK);			
    }  	
	
	@RequestMapping(value = "/updatefamily", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatefamily(@RequestBody FamilyDTO familydto ) {
		Audit audit = new Audit();
		Family fam = null;
		try {
			auditService.startRecord(audit, familydto.toString());
			fam = familyService.updatefamily(familydto);	
			auditService.endRecord(audit, familydto.toString());
		}catch(Exception e) {
			auditService.exceptionRecord(audit, e.getMessage());
		}	
		return new ResponseEntity<Object>(fam, HttpStatus.OK);			
	}   

	@RequestMapping(value = "/deletefamily/{familyId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteFamily(@PathVariable Long familyId) {			
		Audit audit = new Audit(); 
		try {
			auditService.startRecord(audit, familyId.toString());
			familyService.deleteFamily(familyId);
			auditService.endRecord(audit, "Borrado Satisfactorio");
		}catch(Exception e) {
			auditService.exceptionRecord(audit, e.getMessage());
		}
		return new ResponseEntity<Object>("Borrado Satisfactorio", HttpStatus.OK);			
    }  		
	 
}






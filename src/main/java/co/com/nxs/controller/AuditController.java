package co.com.nxs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.nxs.service.AuditService;

@RestController
public class AuditController {

	@Autowired
	AuditService auditService; 
	
	@RequestMapping(value = "/audits", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAudits() {					
		return new ResponseEntity<Object>(auditService.getAllAudits(), HttpStatus.OK);			
	} 
}

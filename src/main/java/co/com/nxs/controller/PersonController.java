package co.com.nxs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.nxs.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllPersons() {					
		return new ResponseEntity<Object>(personService.getAllPersons(), HttpStatus.OK);			
	} 
	
}

package co.com.nxs.dto;

import java.util.Arrays;

import co.com.nxs.model.Family;
import co.com.nxs.model.Person;
 
public class FamilyDTO {	

	private Family family;		
	private Person[] persons;
	
	public FamilyDTO() {
		super();  
	}
	
	public FamilyDTO(Family family) { 
		super();
		this.family = family;
	}
	
	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}
	public Person[] getPersons() {
		return persons;
	}

	public void setPersons(Person[] persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "FamilyDTO [family=" + family + ", persons=" + Arrays.toString(persons) + "]";
	}		
	
}

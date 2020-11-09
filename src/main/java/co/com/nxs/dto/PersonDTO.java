package co.com.nxs.dto;

import co.com.nxs.model.Person;

public class PersonDTO {

	private Person person;
	private FamilyNucleusDTO familyNucleus;
	
	public PersonDTO() { 
		super();
	}

	public Person getPerson() { 
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public FamilyNucleusDTO getFamilyNucleus() {
		return familyNucleus;
	}

	public void setFamilyNucleus(FamilyNucleusDTO familyNucleus) {
		this.familyNucleus = familyNucleus;
	}

	@Override
	public String toString() {
		return "PersonDTO [person=" + person + ", familyNucleus=" + familyNucleus + "]";
	}
	
}

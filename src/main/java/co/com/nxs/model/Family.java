package co.com.nxs.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Family implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long familyId;		

	private String familyName;		

	private String residenceAddress;  
	
	public Long getFamilyId() {
		return familyId;
	}
 
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	@Override
	public String toString() {
		return "Family [familyId=" + familyId + ", familyName=" + familyName + ", residenceAddress=" + residenceAddress
				+ "]";
	}		
	
}

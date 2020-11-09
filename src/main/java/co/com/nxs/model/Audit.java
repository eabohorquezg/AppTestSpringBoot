package co.com.nxs.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Audit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long auditId;	 	
	private Date startDate;	
	private Date endDate;	 
	private String input;	
	private String output;	
	private String responseCodeHttp;	
	private String exception;		

	public Audit() {
		super();
	}

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getResponseCodeHttp() {
		return responseCodeHttp;
	}

	public void setResponseCodeHttp(String responseCodeHttp) {
		this.responseCodeHttp = responseCodeHttp;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "Audit [auditId=" + auditId 
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", input=" + input + ", output=" + output
				+ ", responseCodeHttp=" + responseCodeHttp + ", exception=" + exception + "]";
	}		

}

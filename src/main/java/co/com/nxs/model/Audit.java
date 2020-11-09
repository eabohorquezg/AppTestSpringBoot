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
	 
	private String httpMethod;
	
	private Date startDate;
	
	private Date endDate;
	 
	private String input;
	
	private String output;
	
	private String httpResponse;
	
	private String exception;
	
	private String urlParameters;

	public Audit() {
		super();
	}

	public Audit(String httpMethod, Date startDate, Date endDate, String input, String output, String httpResponse,
			String exception, String urlParameters) {
		super();
		this.httpMethod = httpMethod;
		this.startDate = startDate;
		this.endDate = endDate;
		this.input = input;
		this.output = output;
		this.httpResponse = httpResponse;
		this.exception = exception;
		this.urlParameters = urlParameters;
	}

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
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

	public String getHttpResponse() {
		return httpResponse;
	}

	public void setHttpResponse(String httpResponse) {
		this.httpResponse = httpResponse;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getUrlParameters() {
		return urlParameters;
	}

	public void setUrlParameters(String urlParameters) {
		this.urlParameters = urlParameters;
	}

	@Override
	public String toString() {
		return "Audit [auditId=" + auditId + ", httpMethod=" + httpMethod + ", startDate=" + startDate + ", endDate="
				+ endDate + ", input=" + input + ", output=" + output + ", httpResponse=" + httpResponse
				+ ", exception=" + exception + ", urlParameters=" + urlParameters + "]";
	}
	
	

}

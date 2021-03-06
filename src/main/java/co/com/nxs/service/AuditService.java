package co.com.nxs.service;

import java.util.List;
import java.util.Optional;

import co.com.nxs.model.Audit;


public interface AuditService {
	
		
	public List<Audit> getAllAudits();

	public Audit create(Audit audit);	
	
	public Optional<Audit> getAuditById(Long id); 
	
	public void startRecord(Audit audit, String message);
	
	public void endRecord(Audit audit, String message);
	
	public void exceptionRecord(Audit audit, String message);
	
}

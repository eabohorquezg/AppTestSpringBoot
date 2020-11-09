package co.com.nxs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.com.nxs.model.Audit;
import co.com.nxs.repository.AuditRepository;
import co.com.nxs.service.AuditService;
 
@Service
public class AuditServiceImpl implements AuditService{
 
	@Autowired
	private AuditRepository auditRepository;

	@Override
	public List<Audit> getAllAudits() {
		Iterable<Audit> audits = auditRepository.findAll();
        List<Audit> list = new ArrayList<>();
        audits.forEach(list::add);
        return list;
	}

	@Async
	@Override
	public Audit create(Audit audit) {		
		return auditRepository.save(audit);
	}

	@Async
	@Override
	public Optional<Audit> getAuditById(Long id) {
		return auditRepository.findById(id);
	}	
	
}

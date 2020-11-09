package co.com.nxs.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.nxs.model.Audit;


public interface AuditRepository extends CrudRepository<Audit, Long> {

}

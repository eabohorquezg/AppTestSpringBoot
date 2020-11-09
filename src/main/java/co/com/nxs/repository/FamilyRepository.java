package co.com.nxs.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.nxs.model.Family;

public interface FamilyRepository extends CrudRepository<Family, Long> {
	

}

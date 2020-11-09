package co.com.nxs.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.nxs.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	

}

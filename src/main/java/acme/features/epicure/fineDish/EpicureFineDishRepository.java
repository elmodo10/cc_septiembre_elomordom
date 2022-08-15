package acme.features.epicure.fineDish;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.fineDish.FineDish;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface EpicureFineDishRepository extends AbstractRepository {

	
	@Query("select p from FineDish p where p.id = :id")
	FineDish findFineDishById(int id);

	
	@Query("select p from FineDish p where p.epicure.id = :patronId")
	Collection<FineDish> findAllFineDishByEpicureId(int patronId);
	
	
}

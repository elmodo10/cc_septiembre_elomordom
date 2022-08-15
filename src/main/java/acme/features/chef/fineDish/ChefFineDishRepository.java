package acme.features.chef.fineDish;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.fineDish.FineDish;

import acme.framework.repositories.AbstractRepository;
import acme.roles.Chef;


@Repository
public interface ChefFineDishRepository extends AbstractRepository{

	@Query("select p from FineDish p where p.chef.id = :id")
	List<FineDish> findFineDishByChefId(int id);
	
	@Query("select p from FineDish p where p.id = :id")
	FineDish findById(int id);
	
	@Query("select i from Chef i where i.userAccount.id = :id")
	Chef findChefByUserAccountId(int id);
	
	@Query("select p from FineDish p where p.id = :id")
	FineDish findFineDishById(int id);
}

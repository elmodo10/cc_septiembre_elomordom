package acme.features.chef.pimpam;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.pimpam.Pimpam;
import acme.framework.repositories.AbstractRepository;


@Repository
public interface ChefPimpamRepository extends AbstractRepository {
	
	@Query("select t from Pimpam t where t.cookingItem.id = :id")
	Collection<Pimpam> findOwnPimpams(int id);
	
	@Query("select q from Pimpam q where q.id = :id")
	Pimpam findOnePimpamById(int id);
	
	@Query("select distinct(q) from Pimpam q where q.cookingItem.id = :masterId")
	Collection<Pimpam> findPimpamByCookingItemId(int masterId);
	
//	
//	@Query("select i from Chef i where i.userAccount.id = :id")
//	Chef findChefByUserAccountId(int id);
//	
//	@Query("select i from CookingItem i")
//	List<CookingItem> findManyCookingItem();
//	
//	@Query("select t from Recipe t WHERE t.code = :code")
//	Recipe findRecipeByCode(String code);


}

package acme.features.chef.recipe;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.recipe.Recipe;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ChefRecipeRepository extends AbstractRepository{
	
	@Query("select t from Recipe t where t.chef.id = :id")
	Collection<Recipe> findOwnRecipes(int id);
	
	@Query("select t from Recipe t where t.id = :id")
	Recipe findRecipeById(int id);

}

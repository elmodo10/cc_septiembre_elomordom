package acme.features.chef.recipe;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.recipe.Recipe;
import acme.framework.controllers.AbstractController;
import acme.roles.Chef;

@Controller
@RequestMapping("chef/recipe/")
public class ChefRecipeController extends AbstractController<Chef, Recipe> {
	
	@Autowired
	protected ChefRecipeListOwnService listService;
	
	@Autowired
	protected ChefRecipeShowService showService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list-mine", "list", this.listService);
		super.addCommand("show", this.showService);

		}
	

	

}

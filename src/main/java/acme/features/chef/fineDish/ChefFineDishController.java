package acme.features.chef.fineDish;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.fineDish.FineDish;

import acme.framework.controllers.AbstractController;
import acme.roles.Chef;


@Controller
public class ChefFineDishController extends AbstractController<Chef, FineDish>{

	@Autowired
	protected ChefFineDishListOwnService listService;

	@Autowired
	protected ChefFineDishShowService showService;
	

	
	@PostConstruct
	protected void initialize() {
		super.addCommand("list-mine","list", this.listService);
		super.addCommand("show", this.showService);
	}
	
}

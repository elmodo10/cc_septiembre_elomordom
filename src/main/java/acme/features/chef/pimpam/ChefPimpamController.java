package acme.features.chef.pimpam;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.pimpam.Pimpam;
import acme.framework.controllers.AbstractController;
import acme.roles.Chef;


@Controller
public class ChefPimpamController extends AbstractController<Chef, Pimpam> {
	
	@Autowired
	protected ChefPimpamListService listPimpamService;
	
	@Autowired
	protected ChefPimpamShowService showPimpamService;
	

	@PostConstruct
	protected void initialize() {
		super.addCommand("list-pimpam", "list", this.listPimpamService);
		super.addCommand("show", this.showPimpamService);


	}

}

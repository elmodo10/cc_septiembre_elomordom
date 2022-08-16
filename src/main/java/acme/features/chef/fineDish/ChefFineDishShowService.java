package acme.features.chef.fineDish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.fineDish.FineDish;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Chef;

@Service
public class ChefFineDishShowService implements AbstractShowService<Chef, FineDish>{

	
	@Autowired
	protected ChefFineDishRepository repository;
	
	@Override
	public boolean authorise(final Request<FineDish> request) {
		assert request != null;
		
		final int inventorId = request.getPrincipal().getActiveRoleId();
		final int patronageId = request.getModel().getInteger("id");
		
		final List<FineDish> patronages = this.repository.findFineDishByChefId(inventorId);
		final FineDish requested = this.repository.findById(patronageId);

		return patronages.contains(requested);
	}
	
	@Override
	public FineDish findOne(final Request<FineDish> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		
		final FineDish res = this.repository.findById(id);

		return res;
	}

	@Override
	public void unbind(final Request<FineDish> request, final FineDish entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "status", "code", "request", "budget", "startsAt", "finishesAt", "link", "epicure.organisation", "epicure.assertion","epicure.link");
		
		
		
	}
	
}

package acme.features.chef.delor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.cookingItem.Status;
import acme.entities.delor.Delor;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Chef;

@Service
public class ChefDelorShowService implements AbstractShowService<Chef, Delor> {
	@Autowired
	protected ChefDelorRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Delor> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public Delor findOne(final Request<Delor> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		final Delor res = this.repository.findOnePimpamById(id);
		
		return res;
	}
	
//	@Override
//	public void unbind(final Request<Pimpam> request, final Collection<Pimpam> entities, final Model model) {
//		assert request != null;
//		assert !CollectionHelper.someNull(entities);
//		assert model != null;
//		
//		int masterId;
//		CookingItem ci;
//
//		
//		masterId = request.getModel().getInteger("id");
//		ci = this.repository.findOneCookingItemById(masterId);
//		
//		final Status me = ci.getStatus();
//		
//		model.setAttribute("statusci", me.toString());
//
//	}

	@Override
	public void unbind(final Request<Delor> request, final Delor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		final Status me = entity.getCookingItem().getStatus();
		model.setAttribute("statusci", me.toString());
		
		request.unbind(entity, model, "keylet", "instantionMoment", "subjet", "explanation", "startsAt", "finishesAt", "income", "moreInfo");
		

	}

}

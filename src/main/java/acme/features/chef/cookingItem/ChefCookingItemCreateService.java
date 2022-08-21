package acme.features.chef.cookingItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.cookingItem.CookingItem;
import acme.entities.cookingItem.CookingItemType;
import acme.entities.cookingItem.Status;
import acme.features.administrator.configurations.AdministratorConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Chef;

@Service
public class ChefCookingItemCreateService implements AbstractCreateService<Chef, CookingItem> {
	
	@Autowired 
	protected ChefCookingItemRepository repository;
	
	@Autowired
	protected AdministratorConfigurationRepository	configurationRepository;
	
	@Override
	public boolean authorise(final Request<CookingItem> request) {
		assert request != null;
		
		return true;
	}
	
	@Override
	public void bind(final Request<CookingItem> request, final CookingItem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
			
		request.bind(entity, errors, "name", "code", "description", "retailPrice","link","type");

	}
	
	@Override
	public void unbind(final Request<CookingItem> request, final CookingItem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
			
		request.unbind(entity, model, "name", "code", "description","retailPrice", "link","type");
			
	}
	
	@Override
	public CookingItem instantiate(final Request<CookingItem> request) {
		assert request != null;
			
		final CookingItem result = new CookingItem();
		final Chef chef = this.repository.findChefByUserAccountId(request.getPrincipal().getAccountId());
		
		final Money money = new Money();
		money.setCurrency("EUR");
		money.setAmount(0.00);
			
		result.setName("");
		result.setCode("");
		result.setDescription("");
		result.setRetailPrice(money);
		result.setLink("");
		result.setStatus(Status.NONE_PUBLISHED);
		result.setType(CookingItemType.INGREDIENT);	
		result.setChef(chef);
			
		return result;
	}
	
//	private String generateCode() {
//	}
	
	@Override
	public void validate(final Request<CookingItem> request, final CookingItem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		
	}
	
	@Override
	public void create(final Request<CookingItem> request, final CookingItem entity) {
		assert request != null;
		assert entity != null;
			 
		entity.setChef(this.repository.findChefByUserAccountId(request.getPrincipal().getAccountId()));
		
		entity.setStatus(Status.NONE_PUBLISHED);
		this.repository.save(entity);
	}

}

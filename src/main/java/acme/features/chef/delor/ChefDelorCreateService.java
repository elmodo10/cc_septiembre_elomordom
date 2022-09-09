
package acme.features.chef.delor;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.cookingItem.CookingItem;
import acme.entities.delor.Delor;
import acme.features.administrator.configurations.AdministratorConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Chef;

@Service
public class ChefDelorCreateService implements AbstractCreateService<Chef, Delor> {

	@Autowired
	protected ChefDelorRepository repository;

	@Autowired
	protected AdministratorConfigurationRepository	configurationRepository;


	@Override
	public boolean authorise(final Request<Delor> request) {
		assert request != null;

		final int id = request.getModel().getInteger("id");
		final CookingItem cookingItem = this.repository.findOneCookingItemById(id);
		final Chef chef = this.repository.findChefByUserId(request.getPrincipal().getAccountId());

		return cookingItem.getChef().getId() == chef.getId();
	}

	@Override
	public void bind(final Request<Delor> request, final Delor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		
		request.bind(entity, errors, "keylet", "instantionMoment", "subjet", "explanation", "startsAt", "finishesAt", "income", "moreInfo");
	}

	@Override
	public void unbind(final Request<Delor> request, final Delor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "keylet", "instantionMoment", "subjet", "explanation", "startsAt", "finishesAt", "income", "moreInfo");

	}

	@Override
	public Delor instantiate(final Request<Delor> request) {
		assert request != null;

		final Delor result;
		Date creationTime;
		Date startTime;
		Date finishedTime;
		Date date;
		
		date = new Date();
		creationTime = new Date(System.currentTimeMillis());
		startTime = DateUtils.addMonths(creationTime, 1);
		startTime = DateUtils.addMinutes(creationTime, 1);
		finishedTime = DateUtils.addWeeks(startTime, 1);
		finishedTime = DateUtils.addMinutes(startTime, 1);

		final Money money = new Money();
		money.setAmount(0.0);
		money.setCurrency("EUR");

		result = new Delor();
		result.setKeylet(this.generateCode(creationTime));
		result.setInstantionMoment(date);
		result.setExplanation("");
		result.setSubjet("");
		result.setStartsAt(startTime);
		result.setFinishesAt(finishedTime);
		result.setIncome(money);
		result.setMoreInfo("");
		final int id = request.getModel().getInteger("id");
		final CookingItem ci = this.repository.findOneCookingItemById(id);
		result.setCookingItem(ci);
		

		return result;
	}

	private boolean validateAvailableCurrencyRetailPrice(final Money retailPrice) {

		final String currencies = this.repository.findAvailableCurrencies();
		final List<Object> listCurrencies = Arrays.asList((Object[]) currencies.split(","));

		return listCurrencies.contains(retailPrice.getCurrency());
	}

	private String generateCode(Date creationTime) {
		String code = "";
		final List<String> alphabet = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

		for (int i = 0; i < 6; i++) {
			code += Integer.toString(ThreadLocalRandom.current().nextInt(0, 9));
		}
		code += ":";
		
			final Calendar calendar2 = Calendar.getInstance();
       calendar2.setTime(creationTime);
    
        final String day= String.format("%02d" , calendar2.get(Calendar.DAY_OF_MONTH));
	        final String month= String.format("%02d" , calendar2.get(Calendar.MONTH)+1);
        final String year = String.valueOf(calendar2.get(Calendar.YEAR)).substring(2);
			code += year+month+day;
			
		
		return code;
	}

	@Override
	public void validate(final Request<Delor> request, final Delor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final Collection<Configuration> config = this.configurationRepository.findConfigurations();

		for (final Configuration c : config) {
			errors.state(request, !c.isSpam(entity.getSubjet()), "subjet", "detected.isSpam");
			errors.state(request, !c.isSpam(entity.getExplanation()), "explanation", "detected.isSpam");
			errors.state(request, !c.isSpam(entity.getMoreInfo()), "moreInfo", "detected.isSpam");

		}

		final Delor pimpam = this.repository.findPimpamByCode(entity.getKeylet());

		if (pimpam != null) {
			errors.state(request, pimpam.getId() == entity.getId(), "keylet", "epicure.item.title.codeNotUnique");
		}

		if (!errors.hasErrors("startsAt") && !errors.hasErrors("finishesAt")) {

			final Date minimumStartAt = DateUtils.addMonths(entity.getInstantionMoment(), 1);
			errors.state(request, entity.getStartsAt().after(minimumStartAt), "startsAt", "epicure.finedish.error.minimumStartAt");

			final Date minimumFinishesAt = DateUtils.addWeeks(entity.getStartsAt(), 1);
			final Date minimumStartAt2 = DateUtils.addDays(entity.getStartsAt(), 6);
			errors.state(request, (entity.getFinishesAt().before(minimumFinishesAt) && entity.getFinishesAt().after(minimumStartAt2)), "finishesAt", "epicure.finedish.error.minimumFinishesAt");

		}

		if (!errors.hasErrors("income")) {

			final Money budget = entity.getIncome();
			final boolean availableCurrency = this.validateAvailableCurrencyRetailPrice(budget);

			errors.state(request, availableCurrency, "income", "epicure.budgetNull");

			errors.state(request, entity.getIncome().getAmount() > 0.00, "income", "authenticated.epicure.finedish.list.label.priceGreatherZero");

		}
		
		if(entity.getInstantionMoment()!=null) {
	        final Calendar calendar2 = Calendar.getInstance();
	        calendar2.setTime(entity.getInstantionMoment());
	        final String day= String.format("%02d" , calendar2.get(Calendar.DAY_OF_MONTH));
	        final String month= String.format("%02d" , calendar2.get(Calendar.MONTH)+1);
	        final String year = String.valueOf(calendar2.get(Calendar.YEAR)).substring(2);
	        final String[] codesplit = entity.getKeylet().split(":");
	 
	        boolean bol2;
	 
	      
	        bol2 = codesplit[1].contains(year+month+day);
	      

	        errors.state(request,(bol2) , "keylet", "administrator.configuration.currency.notExist");
			}

	}

	@Override
	public void create(final Request<Delor> request, final Delor entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}

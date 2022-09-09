package acme.features.chef.delor;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Configuration;
import acme.entities.delor.Delor;
import acme.features.administrator.configurations.AdministratorConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Chef;


@Service
public class ChefDelorUpdateService implements AbstractUpdateService<Chef, Delor> {

	@Autowired
	protected ChefDelorRepository repository;
	
	@Autowired
	protected AdministratorConfigurationRepository confRepository;
	
	@Override
	public boolean authorise(final Request<Delor> request) {
		assert request != null;
		
		return true;
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
	public Delor findOne(final Request<Delor> request) {
		assert request != null;
		
		final int id = request.getModel().getInteger("id");
		final Delor res =  this.repository.findOnePimpamById(id);
		return res;
	}
	
	@Override
	public void validate(final Request<Delor> request, final Delor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		final Collection<Configuration> config = this.confRepository.findConfigurations();
		
		for(final Configuration c : config) {

			errors.state(request, !c.isSpam(entity.getExplanation()), "explanation", "detected.isSpam");
			errors.state(request, !c.isSpam(entity.getSubjet()), "subjet", "detected.isSpam");
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
      
		final Delor ci = this.repository.findPimpamByCode(entity.getKeylet());
		
		if(ci != null) {
			errors.state(request, ci.getId() == entity.getId(), "keylet", "inventor.item.title.codeNotUnique");
		}
		
		
		
		
	}
	
	@Override
	public void update(final Request<Delor> request, final Delor entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
		
	}
}

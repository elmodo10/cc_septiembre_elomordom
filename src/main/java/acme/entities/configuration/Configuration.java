package acme.entities.configuration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;

public class Configuration extends AbstractEntity  {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	protected String spamWords;
	
	@NotNull
	@Range(min = 0, max = 1)
	protected Double spamThreshold;
	
	@NotBlank
	@Pattern(regexp="[A-Z]{3}")
	protected String defaultCurr;
	
	@NotBlank
	@Pattern(regexp = "([A-Z]{3})(,\\s*[A-Z]{3})*")
	protected String acceptedCurr;

}

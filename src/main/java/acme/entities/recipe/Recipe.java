package acme.entities.recipe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Recipe extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
//	@OneToOne
//	@Valid
//	@NotNull
//	@Basic(optional = false)
//	protected Ingredient ingredient;
	
//	@OneToMany
//	@Valid
//	@NotNull
//	@Basic(optional = false)
//	protected KitchenUtensil kitchenUtensil;
	
	@Pattern(regexp = "“^([A-Z]{2}:)?[A-Z]{3}-[0-9]{3}$")
	@Column(unique=true)
	protected String code;
	
	@NotBlank
	@Length(min = 1,max = 100)
	protected String heading;
	
	@NotBlank
	@Length(max = 255)
	protected String description;
	
	@NotBlank
	@Length(max = 255)
	protected String preparationNotes;
	
	@URL
	protected String link;

}

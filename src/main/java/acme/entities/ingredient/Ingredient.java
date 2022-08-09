
package acme.entities.ingredient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingredient extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 100)
	protected String name;

	@Pattern(regexp = "“^([A-Z]{2}:)?[A-Z]{3}-[0-9]{3}$")
	@Column(unique = true)
	protected String code;

	@NotBlank
	@Length(max = 255)
	protected String description;

	@NotNull
	@Positive
	protected Money	retailPrice;

	@URL
	protected String link;
}

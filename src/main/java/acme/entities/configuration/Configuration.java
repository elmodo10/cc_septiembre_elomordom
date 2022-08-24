
package acme.entities.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.util.Pair;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Configuration extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	protected String			spamWords;

	@NotNull
	@Range(min = 0, max = 1)
	protected Double			spamThreshold;

	@NotBlank
	@Pattern(regexp = "[A-Z]{3}")
	protected String			defaultCurr;

	@NotBlank
	@Pattern(regexp = "([A-Z]{3})(,\\s*[A-Z]{3})*")
	protected String			acceptedCurr;


	public boolean isSpam(final String text) {
		final String[] lowerCaseText = text.toLowerCase().replaceAll("\\s+", " ").split(" ");
		double spamCount = 0;
		final List<Pair<String, Double>> ls = new ArrayList<Pair<String, Double>>();

		final String[] sp = this.spamWords.split(",");

		for (final String s : sp) {

			final String[] ss = s.split(";");
			ls.add(Pair.of(ss[0].replace("(", ""), Double.parseDouble(ss[1].replace(")", ""))));

		}

		for (final Pair<String, Double> s : ls) {
			for (final String t : lowerCaseText) {
				if (t.equals(s.getFirst())) {
					spamCount = spamCount + s.getSecond();
				}
			}
		}
		

		final Double umbral = spamCount / lowerCaseText.length;

		return umbral >= this.spamThreshold;

	}
}

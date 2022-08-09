package acme.entities.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.util.Pair;

import acme.framework.entities.AbstractEntity;
 

public class Configuration extends AbstractEntity  {

	private static final long serialVersionUID = 1L;
	//List<Pair<String, Double>>
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

	public boolean isSpam(final String text) {
		final String[] lowerCaseText = text.toLowerCase().replaceAll("\\s+", " ").split(" ");
		int spamCount = 0;
		this.spamWords.replace("(", "");
		this.spamWords.replace(")", "");
		List<Pair<String, Double>> ls = new ArrayList<Pair<String, Double>>();
		
		final String[] sp = this.spamWords.split(",");
		
		for (final String s : sp) {
			
			this.spamWords.replace("“", "");
			this.spamWords.replace("”", "");
			String[] ss = s.split(";");
			ls.add(Pair.of(ss[0], Double.parseDouble(ss[1])));
		
		}
		
		for (final Pair<String, Double> s : ls) {
			if (text.toLowerCase().trim().replaceAll("\\s+", " ").contains(s.getFirst())) {
				spamCount++;
			}
			for (int i = 0; i < lowerCaseText.length; i++) {
				if (lowerCaseText[i].contains(s.getFirst())) {
					spamCount++;
				}

			}
		}
		if (spamCount % 2 == 0) {
			spamCount = spamCount / 2;
		} else {
			spamCount = (spamCount / 2) + 1;
		}
		final Double umbral = (double) spamCount / lowerCaseText.length;

		return umbral > this.spamThreshold;

	}
}

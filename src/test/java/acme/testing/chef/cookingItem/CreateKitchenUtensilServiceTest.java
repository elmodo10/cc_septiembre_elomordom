
package acme.testing.chef.cookingItem;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class CreateKitchenUtensilServiceTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/chef/cooking-item/kitchenUtensilPositive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveCreateIngredientTest(final int recordIndex, final String name, final String code, final String description, final String retailPrice, final String link, final String type) {

		super.signIn("chef1", "chef1");

		super.clickOnMenu("Chef", "List Own Kitchen Utensils");
		super.checkListingExists();
		super.clickOnButton("Create Kitchen Utensil");
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create Kitchen Utensil");

		super.clickOnMenu("Chef", "List Own Kitchen Utensils");
		super.checkListingExists();

		super.signOut();

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/chef/cooking-item/kitchenUtensilNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeCreateIngredientTest(final int recordIndex, final String name, final String code, final String description, final String retailPrice, final String link, final String type) {

		super.signIn("chef1", "chef1");

		super.clickOnMenu("Chef", "List Own Kitchen Utensils");
		super.checkListingExists();
		super.clickOnButton("Create Kitchen Utensil");
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create Kitchen Utensil");

		super.checkErrorsExist();
		super.signOut();

	}

}

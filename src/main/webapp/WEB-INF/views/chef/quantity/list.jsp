<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="chef.quantity.list.label.number" path="number" width="20%"/>
	<acme:list-column code="chef.quantity.list.label.name" path="cookingitem.name" width="20%"/>			
	<acme:list-column code="chef.quantity.list.label.code" path="cookingitem.code" width="20%"/>		
	<acme:list-column code="chef.quantity.list.label.retailPrice" path="cookingitem.retailPrice" width="20%"/>	
	<acme:list-column code="chef.quantity.list.label.status" path="cookingitem.status" width="20%"/>
		
</acme:list>


<acme:button code="chef.recipe.form.button.quantity.ingredient" action="/chef/quantity/createIngredient?id=${param.id}"/>
<acme:button code="chef.recipe.form.button.quantity.utensil" action="/chef/quantity/createKitchenUtensil?id=${param.id}"/>
		
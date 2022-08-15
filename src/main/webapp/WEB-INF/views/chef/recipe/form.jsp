
  
<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<acme:input-textbox code="chef.recipe.form.label.code" path="code"/>
	<acme:input-textbox code="chef.recipe.form.label.heading" path="heading"/>
	<acme:input-textbox code="chef.recipe.form.label.description" path="description"/>
	<acme:input-textbox code="chef.recipe.form.label.preparationNotes" path="preparationNotes"/>
	<acme:input-url code="chef.recipe.form.label.link" path="link"/>

	<acme:button code="chef.recipe.form.buttom.items" action="/any/cooking-item/list-by-recipe?id=${id}"/>
	
	

	



</acme:form>
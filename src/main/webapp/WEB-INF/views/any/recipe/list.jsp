<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.recipe.list.label.code" path="code" width="20%"/>
	<acme:list-column code="any.recipe.list.label.heading" path="heading" width="20%"/>
	<acme:list-column code="any.recipe.list.label.description" path="description" width="20%"/>	
	<acme:list-column code="any.recipe.list.label.preparationNotes" path="preparationNotes" width="20%"/>				
	<acme:list-column code="any.recipe.list.label.link" path="link" width="20%"/>				
</acme:list>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.cookingItem.list.label.name" path="name" width="20%"/>
	<acme:list-column code="any.cookingItem.list.label.code" path="code" width="20%"/>
	<acme:list-column code="any.cookingItem.list.label.description" path="description" width="20%"/>
	<acme:list-column code="any.cookingItem.list.label.retailPrice" path="retailPrice" width="20%"/>		
	<acme:list-column code="any.cookingItem.list.label.link" path="link" width="20%"/>
	<acme:list-column code="any.cookingItem.list.label.type" path="type" width="20%"/>
</acme:list>

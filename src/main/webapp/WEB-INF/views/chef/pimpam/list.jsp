<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>

	<acme:list-column code="chef.pimpam.list.label.code" path="code" width="20%"/>
	<acme:list-column code="chef.pimpam.list.label.instationMoment" path="instationMoment" width="20%"/>
	<acme:list-column code="chef.pimpam.list.label.title" path="title" width="20%"/>
	<acme:list-column code="chef.pimpam.list.label.description" path="description" width="20%"/>
	<acme:list-column code="chef.pimpam.list.label.startsAt" path="startsAt" width="20%"/>
	<acme:list-column code="chef.pimpam.list.label.finishesAt" path="finishesAt" width="20%"/>
	<acme:list-column code="chef.pimpam.list.label.budget" path="budget" width="20%"/>		
	<acme:list-column code="chef.pimpam.list.label.link" path="link" width="20%"/>


</acme:list>



		

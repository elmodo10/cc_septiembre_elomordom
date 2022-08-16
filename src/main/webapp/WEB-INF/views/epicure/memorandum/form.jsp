
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>


<acme:form readonly="${readonly}">
	
	<h2> <acme:message code="chef.memorandum.list.label.fineDish.details"/> </h2>
    <acme:input-textbox code="epicure.memorandum.form.label.seqNumber" path="seqNumber"/>	
	<acme:input-textbox code="epicure.memorandum.form.label.instantiationMoment" path="instantiationMoment"/>	
	<acme:input-textbox code="epicure.memorandum.form.label.report" path="report"/>	
	<acme:input-url code="epicure.memorandum.form.label.link" path="link"/>	
	<br>
	<h2> <acme:message code="chef.memorandum.list.label.fineDish"/> </h2>
	<br>
	<acme:input-textbox code="chef.fineDish.list.label.fineDish.identify.status" path="fineDish.status"/>
	<acme:input-textbox code="chef.fineDish.list.label.fineDish.identify.code" path="fineDish.code"/>
	<acme:input-textbox code="chef.fineDish.list.label.fineDish.identify.request" path="fineDish.request"/>
	<acme:input-money code="chef.fineDish.list.label.fineDish.identify.budget" path="fineDish.budget"/>
	<acme:input-textbox code="chef.fineDish.list.label.fineDish.identify.startsAt" path="fineDish.startsAt"/>
	<acme:input-textbox code="chef.fineDish.list.label.fineDish.identify.finishesAt" path="fineDish.finishesAt"/>
	<acme:input-textbox code="chef.fineDish.list.label.fineDish.identify.link" path="fineDish.link"/>
</acme:form>
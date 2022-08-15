
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
 

<acme:form readonly="true">
    <acme:input-textbox code="authenticated.epicure.finedish.form.label.status" path="status"/>	
	<acme:input-textbox code="authenticated.epicure.finedish.form.label.code" path="code"/>	
	<acme:input-textbox code="authenticated.epicure.finedish.form.label.request" path="request"/>	
	<acme:input-money code="authenticated.epicure.finedish.form.label.budget" path="budget"/>	
	<acme:input-textbox code="authenticated.epicure.finedish.form.label.startsAt" path="startsAt"/>
	<acme:input-textarea code="authenticated.epicure.finedish.form.label.finishesAt" path="finishesAt"/>
	<acme:input-url code="authenticated.epicure.finedish.form.label.link" path="link"/>
	<acme:input-textarea code="authenticated.epicure.finedish.form.label.chef.organisation" path="chef.organisation"/>
	<acme:input-textarea code="authenticated.epicure.finedish.form.label.chef.assertion" path="chef.assertion"/>
	<acme:input-url code="authenticated.epicure.finedish.form.label.chef.link" path="chef.link"/>
	<acme:button code="epicure.finedish.form.buttom.finedish-reports" action="/epicure/finedish-report/list-by-finedish?id=${id}"/>
	

</acme:form>
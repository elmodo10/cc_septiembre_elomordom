<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@ page import="acme.entities.cookingItem.Status" %>

<acme:form>
	<jstl:choose>
		<jstl:when test="${command=='show'}">
				<acme:input-textbox code="chef.pimpam.form.label.code" path="keylet" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.instationMoment" path="instantionMoment" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.title" path="subjet" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.description" path="explanation" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.startsAt" path="startsAt" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.finishesAt" path="finishesAt" readonly="true" />
				<acme:input-money code="chef.pimpam.form.label.budget" path="income" readonly="true" />
				<acme:input-url code="chef.pimpam.form.label.link" path="moreInfo" readonly="true" />
				
			<jstl:if test="${statusci == 'NONE_PUBLISHED' }">
				<acme:submit code="chef.pimpam.form.button.delete" action="/chef/delor/delete?id=${param.id}"/>
				<acme:button code="chef.pimpam.form.button.update" action="/chef/delor/update?id=${param.id}"/>
			
			</jstl:if>
	
	</jstl:when>
	
		<jstl:when test="${command == 'create'}">
			<acme:input-textbox code="chef.pimpam.form.label.code" path="keylet"  />
			<acme:input-textbox code="chef.pimpam.form.label.instationMoment" path="instantionMoment" readonly="true"/>
			<acme:input-textbox code="chef.pimpam.form.label.title" path="subjet"/>
			<acme:input-textbox code="chef.pimpam.form.label.description" path="explanation"/>
			<acme:input-textbox code="chef.pimpam.form.label.startsAt" path="startsAt" />
			<acme:input-textbox code="chef.pimpam.form.label.finishesAt" path="finishesAt"/>
			<acme:input-money code="chef.pimpam.form.label.budget" path="income"/>
			<acme:input-textbox code="chef.pimpam.form.label.link" path="moreInfo"/>
			<acme:submit code="chef.pimpam.form.button.create" action="/chef/delor/create?id=${param.id}"/>
			
		</jstl:when>
		
		<jstl:when test = "${command == 'update' }">
				<acme:input-textbox code="chef.pimpam.form.label.code" path="keylet"  />
			<acme:input-textbox code="chef.pimpam.form.label.instationMoment" path="instantionMoment" readonly="true"/>
			<acme:input-textbox code="chef.pimpam.form.label.title" path="subjet"/>
			<acme:input-textbox code="chef.pimpam.form.label.description" path="explanation"/>
			<acme:input-textbox code="chef.pimpam.form.label.startsAt" path="startsAt" />
			<acme:input-textbox code="chef.pimpam.form.label.finishesAt" path="finishesAt"/>
			<acme:input-money code="chef.pimpam.form.label.budget" path="income"/>
			<acme:input-textbox code="chef.pimpam.form.label.link" path="moreInfo"/>
			<acme:submit code="chef.pimpam.form.button.update" action="/chef/delor/update?id=${param.id}"/>
	</jstl:when>
		


	</jstl:choose>

</acme:form>
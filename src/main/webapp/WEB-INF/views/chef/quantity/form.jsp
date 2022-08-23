<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
		
	<jstl:choose>
	
		<jstl:when test="${acme:anyOf(command, 'show, update')}">
			<acme:input-integer code="chef.quantity.form.label.number" path="number" readonly="${recipe.status == 'PUBLISHED'}" />
			
			<jstl:if test="${recipe.status == 'NONE_PUBLISHED'}" >
				<acme:submit code="chef.quantity.form.button.update" action="/chef/quantity/update"/>
			</jstl:if>
			
			<acme:input-textbox code="chef.quantity.form.label.name" path="cookingitem.name" readonly="true"/>
			<acme:input-textbox code="chef.quantity.form.label.code" path="cookingitem.code" readonly="true"/>
			<acme:input-textarea code="chef.quantity.form.label.description" path="cookingitem.description" readonly="true"/>
			<acme:input-money code="chef.quantity.form.label.retailPrice" path="cookingitem.retailPrice" readonly="true"/>
			<acme:input-url code="chef.quantity.form.label.link" path="cookingitem.link" readonly="true"/>
			<acme:input-textbox code="chef.quantity.form.label.status" path="cookingitem.status" readonly="true" />
			<acme:input-textbox code="chef.quantity.form.label.type" path="cookingitem.type" readonly="true"/>
		
			<jstl:if test="${cookingitem.status == 'NONE_PUBLISHED' && cookingitem.getChef().getId() == chefId}" >
				<acme:button code="chef.quantity.form.button.updateItem" action="/chef/cooking-item/update?id=${cookingitem.getId()}"/>
			</jstl:if>
			
		</jstl:when>	
		
		<jstl:when test="${command == 'create'}">
			<acme:input-integer code="chef.quantity.form.label.number" path="number"/>
			<acme:input-select code="chef.quantity.form.label.item" path="cookingitem">
				<jstl:forEach items="${cookingitems}" var = "i">
					<acme:input-option code="${i.getName()}" value="${i.getId()}" selected="${ i.getId() == cookingitem }"/>
				</jstl:forEach>
			</acme:input-select>
			<acme:submit code = "chef.quantity.form.button.create" action = "/chef/quantity/create?id=${param.id}"/>
			
		</jstl:when>
		
	</jstl:choose>
		
		
</acme:form>
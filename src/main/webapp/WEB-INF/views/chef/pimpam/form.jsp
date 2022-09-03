<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<jstl:choose>
		<jstl:when test="${command=='show'}">
				<acme:input-textbox code="chef.pimpam.form.label.code" path="code" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.instationMoment" path="instationMoment" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.title" path="title" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.description" path="description" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.startsAt" path="startsAt" readonly="true" />
				<acme:input-textbox code="chef.pimpam.form.label.finishesAt" path="finishesAt" readonly="true" />
				<acme:input-money code="chef.pimpam.form.label.budget" path="budget" readonly="true" />
				<acme:input-url code="chef.pimpam.form.label.link" path="link" readonly="true" />


			
	</jstl:when>


	</jstl:choose>

</acme:form>
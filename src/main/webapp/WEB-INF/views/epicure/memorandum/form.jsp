
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="true">
    <acme:input-textbox code="epicure.memorandum.form.label.seqNumber" path="seqNumber"/>	
	<acme:input-textbox code="epicure.memorandum.form.label.instantiationMoment" path="instantiationMoment"/>	
	<acme:input-textbox code="epicure.memorandum.form.label.report" path="report"/>	
	<acme:input-url code="epicure.memorandum.form.label.link" path="link"/>	
</acme:form>
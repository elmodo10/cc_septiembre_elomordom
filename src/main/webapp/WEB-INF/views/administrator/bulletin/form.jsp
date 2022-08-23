<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	<acme:input-textbox code="administrator.bulletin.form.label.heading" path="heading"/>
	<acme:input-textbox code="administrator.bulletin.form.label.pieceOfText" path="pieceOfText" />
	<acme:input-select code="administrator.bulletin.form.label.critic" path="critic">
				<acme:input-option code="administrator.bulletin.form.label.true" value="true"/>
				<acme:input-option code="administrator.bulletin.form.label.false" value="false"/>
	</acme:input-select>
				
	<acme:input-url code="administrator.bulletin.form.label.link" path="link"/>
	
	<jstl:if test="${command == 'create'}">
	
		<acme:input-checkbox code="administrator.bulletin.form.label.confirm" path="confirm"/>
		
		<acme:submit code="administrator.bulletin.form.button.create" action="/administrator/bulletin/create"/>
	</jstl:if>
</acme:form>
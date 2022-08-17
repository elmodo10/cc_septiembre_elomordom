<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.configuration.list.label.SpamWords" path="spamWords" />
	<acme:list-column code="administrator.configuration.list.label.SpamThreshold" path="spamThreshold" />
		<acme:list-column code="administrator.configuration.list.label.defaultCurr" path="defaultCurr" />
	<acme:list-column code="administrator.configuration.list.label.acceptedCurr" path="acceptedCurr" />


</acme:list>

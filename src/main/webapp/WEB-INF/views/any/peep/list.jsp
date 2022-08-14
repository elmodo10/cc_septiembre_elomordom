<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list readonly="true">

	<acme:list-column code="any.invention.list.label.writer" path="writer" width="20%" />
	<acme:list-column code="any.invention.list.label.pieceOfText" path="pieceOfText" width="20%"/>
	<acme:list-column code="any.invention.list.label.instantionMoment" path="instantionMoment" width="20%"/>
	<acme:list-column code="any.invention.list.label.email" path="email" width="20%"/>
	<acme:list-column code="any.invention.list.label.heading" path="heading" width="20%"/>

	
</acme:list>
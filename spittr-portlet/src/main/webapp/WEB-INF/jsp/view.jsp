<%@include file="init.jsp"%>
<%@ page session="false" %>

<h1><s:message code="text.mainView" text="Welcome to Spittr" /></h1>
<portlet:renderURL var="spittlesViewUrl">
    <portlet:param name="render" value="spittles-view" />
</portlet:renderURL>
<portlet:renderURL var="registrationViewUrl">
    <portlet:param name="render" value="registration-view" />
</portlet:renderURL>
<nav>
    <ul>
        <li> <a href="${spittlesViewUrl}"><s:message code="link.spittlesView"/></a></li>
        <li> <a href="${registrationViewUrl}"><s:message code="link.registration"/></a></li>
    </ul>
</nav>
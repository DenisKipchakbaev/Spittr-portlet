<%@include file="init.jsp"%>
<%@ page session="false" %>
<a href="<portlet:renderURL />"><s:message code="link.mainView" text="Main View"/></a>
<portlet:actionURL name="createSpittle" var="saveSpittleUrl">
	<portlet:param name="action" value="submit-spittle"></portlet:param>
</portlet:actionURL>
<div class="spittleForm">
	<h1>Spit it out...</h1>
	<sform:form action="${saveSpittleUrl}" method="POST" modelAttribute="spittle">
		<%-- <sform:input type="hidden" path="latitude" /> 
		<sform:input type="hidden" path="longitude" /> --%>
		<sform:input path="message" cols="80" rows="5"></sform:input>
		<br /> 
		<input type="submit" value="Add Spittle" />
	</sform:form>
</div>
<h1><s:message code="header.recentSpittles" text = "Recent Spittles"/></h1>
<ul class="spittleList">
	<c:forEach items="${spittleList}" var="spittle">
		<li id="spittle_<c:out value="spittle.id"/>">
			<div class="spittleMessage">
				<c:out value="${spittle.message}" />
			</div>
			<div>
				<span class="spittleTime"><c:out value="${spittle.time}" /></span>
				<span class="spittleLocation">(
					<c:out value="${spittle.latitude}" />, 
					<c:out value="${spittle.longitude}" />)
				</span>
			</div>
		</li>
	</c:forEach>
</ul>
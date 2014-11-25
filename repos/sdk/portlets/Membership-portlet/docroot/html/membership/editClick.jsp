
<%@ include file="/html/membership/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Membership membership= (Membership)rslt.getObject();

String prk=String.valueOf(membership.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editMemberships" name="editMembership">
<portlet:param name="membershipId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editMemberships.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>

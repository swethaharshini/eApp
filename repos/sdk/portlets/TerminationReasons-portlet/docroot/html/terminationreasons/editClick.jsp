<%@ include file="/html/terminationreasons/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

TerminationReasons terminationReasons= (TerminationReasons)rslt.getObject();

String prk=String.valueOf(terminationReasons.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editterminationreasons" name="editTerminationReasons">
<portlet:param name="terminationreasonsId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editterminationreasons.toString()%>'"><img
					width="18px" height="18px" alt="loading..." 
					src="<%=request.getContextPath() %>/images/pencil.jpg"></a> 
</liferay-ui:icon-menu>

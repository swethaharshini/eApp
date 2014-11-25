
<%@ include file="/html/educationaction/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Education education= (Education)rslt.getObject();

String prk=String.valueOf(education.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editEducations" name="editEducation">
<portlet:param name="educationId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editEducations.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>

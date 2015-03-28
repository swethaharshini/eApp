<%@ include file="/html/documents/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Documents document= (Documents)rslt.getObject();

String prk=String.valueOf(document.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editDocuments" name="editDocument">
<portlet:param name="documentId" value="<%=prk%>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editDocuments.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>
<%@page import="com.rknowsys.eapp.hrm.model.DocumentsAttachments"%>
<%@ include file="/html/documents/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

DocumentsAttachments document= (DocumentsAttachments)rslt.getObject();

String prk=String.valueOf(document.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editattachment" name="editAttachment">
<portlet:param name="attachmentId" value="<%=prk%>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editattachment.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>
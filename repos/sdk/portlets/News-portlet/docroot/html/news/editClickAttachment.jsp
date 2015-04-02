<%@page import="com.rknowsys.eapp.hrm.model.NewsAttachments"%>
<%@page import="com.rknowsys.eapp.hrm.model.DocumentsAttachments"%>
<%@ include file="/html/news/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

NewsAttachments newsAttachments = (NewsAttachments)rslt.getObject();

String prk=String.valueOf(newsAttachments.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editattachment" name="editAttachment">
<portlet:param name="newsattachmentId" value="<%=prk%>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editattachment.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>
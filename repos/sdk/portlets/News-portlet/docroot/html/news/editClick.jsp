<%@page import="com.rknowsys.eapp.hrm.model.News"%>
<%@ include file="/html/news/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

News news= (News)rslt.getObject();

String prk=String.valueOf(news.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editNews" name="editNews">
<portlet:param name="newsId" value="<%=prk%>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editNews.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>
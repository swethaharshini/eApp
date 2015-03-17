<%@ include file="/html/category/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

DocumentCategories categories= (DocumentCategories)rslt.getObject();

String prk=String.valueOf(categories.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editCategories" name="editCategory">
<portlet:param name="documentcategoryId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editCategories.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>
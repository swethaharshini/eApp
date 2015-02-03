<%@ include file="/html/jobcategory/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

JobCategory j = (JobCategory)rslt.getObject();

String prk=String.valueOf(j.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editjobcategory" name="editJobcategory">
<portlet:param name="jobCategoryId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editjobcategory.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>

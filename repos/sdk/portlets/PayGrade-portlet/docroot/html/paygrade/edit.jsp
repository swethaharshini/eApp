<%@ include file="/html/paygrade/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>button</title>
<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

PayGrade i = (PayGrade)rslt.getObject();

String prk=String.valueOf(i.getPrimaryKey());

%>

<liferay-ui:icon-menu>	

<portlet:actionURL var="editpaygrade" name="editPayGrade">
<portlet:param name="id" value="<%=prk %>"/>
</portlet:actionURL>
<a href="#" class="edit-icon" onclick="window.location='<%=editpaygrade.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>

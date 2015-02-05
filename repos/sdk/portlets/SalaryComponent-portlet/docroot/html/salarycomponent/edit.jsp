<%@page import="com.rknowsys.eapp.hrm.model.SalaryComponent"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
    <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
   <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

SalaryComponent j = (SalaryComponent)rslt.getObject();

String prk=String.valueOf(j.getPrimaryKey());

%>

<liferay-ui:icon-menu>

<portlet:actionURL var="editcomponent" name="editSalaryComponent">
<portlet:param name="id" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editcomponent.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>

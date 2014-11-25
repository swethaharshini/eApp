<%@page import="com.rknowsys.eapp.hrm.model.EmpDetails"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

EmpDetails ed = (EmpDetails)rslt.getObject();

String prk=String.valueOf(ed.getEmployeeNo());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="renderEmployeeDetails" name="renderEmployeeDetails">
<portlet:param name="prk" value="<%=prk %>"/></portlet:actionURL>


<a href="#" onclick="window.location='<%=renderEmployeeDetails%>'"><img
					width="18px" height="18px" alt="loading..." 
					src="<%=request.getContextPath() %>/images/pencil.jpg"></a> 
</liferay-ui:icon-menu>
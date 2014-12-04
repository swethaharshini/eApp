
<%@page import="com.rknowsys.eapp.hrm.model.PimReports"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/pimreports/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

PimReports pimReports= (PimReports)rslt.getObject();

String prk=String.valueOf(pimReports.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editPimReports" name="editPimReports">
<portlet:param name="pimReportsId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editPimReports.toString()%>'">Edit</a> 
</liferay-ui:icon-menu>

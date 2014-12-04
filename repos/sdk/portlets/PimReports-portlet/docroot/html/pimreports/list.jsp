<%@page import="com.rknowsys.eapp.hrm.service.PimReportsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.PimReports"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/html/pimreports/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>pimreports</title>
<portlet:resourceURL var="deletereport" id="deleteReport"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/pimreports/list.jsp" />
</portlet:renderURL>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#reportdelete');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[type=checkbox]:checked').each(function(object) {
      idArray.push(object.get("value"));
      });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected Reports ?");
		  if(d){
		   var url = '<%=deletereport%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />reportIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('deleted successfully');
                   window.location='<%=listview%>';
              },
               failure: function() {
                  
                 }
                }
                 }
                );
		  																		
		  console.log(idArray);
	  
      return true;
  }
  else
    return false;
}             
      }
    );
  }
);


</aui:script>
</head>
<portlet:renderURL var="addreport">
<portlet:param name="mvcPath" value="/html/pimreports/addreport.jsp"/>
</portlet:renderURL>
<body>
<div class="row-fluid">
	<div id="" class="span12">
		<div class="pull-left">
		<a class="btn btn-success" href="<%=addreport.toString()%>">Add</a>
		<a class="btn btn-danger" href="#" id="reportdelete">Delete</a>
	</div>
	</div>
	</div>
	
<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/pimreports/list.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

%>
	
	
	
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<PimReports> searchContainer;
%>

<liferay-ui:search-container rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for pimdisplayfields"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
            List<PimReports> reportingMethodsList = PimReportsLocalServiceUtil.getPimReportses(searchContainer.getStart(), searchContainer.getEnd());
		  
               results = reportingMethodsList;
               total = PimReportsLocalServiceUtil.getPimReportsesCount();
               System.out.println("list size = "+total);
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="PimReports"
		keyProperty="reportId" modelVar="PimReports" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="Report Name" property="reportName"
			orderableProperty="reportingmethodName" />
		<liferay-ui:search-container-column-jsp name="Run" path="/html/pimreports/run.jsp"/>
		<liferay-ui:search-container-column-jsp name="Edit" path="/html/pimreports/edit.jsp"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</body>
</html>
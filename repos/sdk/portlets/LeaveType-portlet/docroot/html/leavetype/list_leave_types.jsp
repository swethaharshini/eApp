<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@page import="com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.SetupLeaveTypesAction"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@ include file="/html/leavetype/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Types List</title>
<portlet:defineObjects/>

<portlet:actionURL var="addEditLeaveType" name="addEditLeaveType">
</portlet:actionURL>

<portlet:resourceURL var="deleteLeaveType" id="deleteLeaveType"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/leavetype/list_leave_types.jsp" />
</portlet:renderURL>

<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
</style>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delete');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[type=checkbox]:checked').each(function(object) {
      alert('1111 val = ' + object.get("value"));
      idArray.push(object.get("value"));
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected Leave Types ?");
		  if(d){
		   var url = '<%=deleteLeaveType%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />leaveTypeIds: idArray,  
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

<body>
<%
System.out.println("in list leave types jsp");
%>

<div>

	<div class="span12">
	    <div class="span3">
			<aui:form action="<%=addEditLeaveType.toString() %>" name="addForm">
				<aui:button type="submit" id="add" value="Add" />
			</aui:form>
		</div>
		<div class="span3">
			<aui:form action="<%=deleteLeaveType.toString() %>" name="deleteForm">
				<aui:button type="submit" id="delete" value="Delete" />
			</aui:form>
		</div>			
	</div>

</div>
<div>&nbsp;</div>


<%

	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/leavetype/list_leave_types.jsp");
	RowChecker rowChecker = new RowChecker(renderResponse);
	
	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
	String sortByCol = ParamUtil.getString(request, "orderByCol"); 
	String sortByType = ParamUtil.getString(request, "orderByType"); 
	System.out.println("sortByCol == " +sortByCol);
	System.out.println("sortByType == " +sortByType);
	if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
		System.out.println("if block...");
	 
	portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
	portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
	 
	} else { 
	 
		sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
	}
	
	System.out.println("after....");
	System.out.println("sortByCol == " +sortByCol);
	System.out.println("sortByType == " +sortByType);

%>
<jsp:useBean id="leaveTypeList" type="java.util.List<LeaveType>" scope="request" />
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<LeaveType> searchContainer;
%>

<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records available for Leave Types."
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	
	<liferay-ui:search-container-results>

		<%
		  results = leaveTypeList;
		
		  System.out.println("results == " +results);
		
		  total = leaveTypeList.size();
		  System.out.println("total == " +total);
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="LeaveType"
		keyProperty="leaveTypeId" modelVar="leaveType" rowVar="curRow"
		escapedModel="<%= true %>">
		
		  <% 
		  	System.out.println("leaveTypeName == " +leaveType.getLeaveTypeName());
		  %>

		<liferay-ui:search-container-column-text orderable="<%=false %>"
			name="Name" property="leaveTypeName" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Country"  property="countryName" />
			
		<liferay-ui:search-container-column-jsp name="Leave Rule"
			path="/html/leavetype/edit2.jsp" />	
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/leavetype/edit.jsp" />	

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>

</body>
</html>
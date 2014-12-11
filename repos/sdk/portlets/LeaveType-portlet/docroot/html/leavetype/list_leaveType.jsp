<%@ include file="/html/leavetype/init.jsp" %>
<portlet:resourceURL var="deleteLeaveType" id="deleteLeaveType"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/leavetype/list_leaveType.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addLeaveType">
<portlet:param name="mvcPath" value="/html/leavetype/add_edit_leaveType.jsp"/>
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
AUI().use('aui-node',function(A) {
    var node = A.one('#<portlet:namespace/>deleteLeaveType');
node.on('click',function() {
      var idArray = [];
	      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
	      idArray.push(object.get("value"));
	      });
       if(idArray==""){
			  alert("Please select records!");
	   }else{
		 var d = confirm("Are you sure you want to delete the selected Leave Types ?");
		 
		 if(d){
          A.io.request('<%=deleteLeaveType%>',
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
           });
             console.log(idArray);
           return true;
        }
          else
            return false;
      }
      });
  });
</aui:script>
<%!
public String getNationalityValue(long nationId) {
	if(nationId!=0)
	{
		Nationality nation = null;
		try {
		nation = NationalityLocalServiceUtil.getNationality(nationId);
		} catch (Exception p) {
		}
	return nation.getName();
	}
	return "";
}
%>
<div class="panel">
	<div class="panel-heading">
		<h4>Leave Type</h4>
	</div>
	<div class="panel-body">
		<div class="row-fluid">
			<div class="span1">
				<aui:button id="addLeaveType" value="Add"
					onClick="<%=addLeaveType.toString()%>" />
			</div>
			<div class="span1">
				<aui:button id="deleteLeaveType" name="deleteLeaveType"
					value="Delete" />
			</div>
			<div class="span10"></div>
		</div>
<%

	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/leavetype/list_leaveType.jsp.jsp");
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
<%
java.util.List<LeaveType> leaveTypeList=LeaveTypeLocalServiceUtil.getLeaveTypes(-1, -1);
		System.out.println("leave type list is"+leaveTypeList);
		%>
		
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
		
		  total = leaveTypeList!=null?leaveTypeList.size():0;
		  System.out.println("total == " +total);
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="com.rknowsys.eapp.hrm.model.LeaveType"
		keyProperty="leaveTypeId" modelVar="leaveType" rowVar="curRow"
		escapedModel="<%= true %>">
		
		  <% 
		  	System.out.println("leaveTypeName == " +leaveType.getLeaveTypeName());
		  %>

		<liferay-ui:search-container-column-text orderable="<%=false %>"
			name="Name" property="leaveTypeName" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Country"  value="<%=getNationalityValue(leaveType.getNationalityId()) %>" />
			
		<liferay-ui:search-container-column-jsp name="Leave Rule"
			path="/html/leavetype/editLeaveRule.jsp" />	
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/leavetype/editClick.jsp" />	

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>

</div>
</div>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/leavetype/init.jsp" %>
<portlet:resourceURL var="deleteLeaveType" id="deleteLeaveType"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/leavetype/list_leaveType.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addLeaveType">
<portlet:param name="mvcPath" value="/html/leavetype/add_edit_leaveType.jsp"/>
</portlet:renderURL>

<aui:script>
AUI().use('aui-node',function(A) {
    var node = A.one('#deleteLeaveType');
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
  AUI().ready('event', 'node','transition',function(A){
setTimeout(function(){
A.one('#addLeaveTypeMessage').transition('fadeOut');
A.one('#addLeaveTypeMessage').hide();
},2000)
});
  
</aui:script>
<%!
public String getNationalityValue(long nationId) {
	if(nationId!=0)
	{
		Nationality nation = null;
		try {
		nation = NationalityLocalServiceUtil.getNationality(nationId);
		return nation.getName();
		} catch (Exception p) {
		}
	}
	return "";
}
%>
<body>

<% if(SessionMessages.contains(renderRequest.getPortletSession(),"leaveTypeName-empty-error")){%>
<p id="addLeaveTypeMessage" class="alert alert-error"><liferay-ui:message key="Please Enter LeaveTypeName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"leaveTypeName-duplicate-error")){
%>
<p id="addLeaveTypeMessage" class="alert alert-error"><liferay-ui:message key="LeaveTypeName already Exits"/></p>
<%} 
%>
<div class="row-fluid">
   
		<div class="span12 text-right">
			<a href="<%=addLeaveType.toString()%>" class="btn btn-primary" id="addLeaveType"><i class="icon-plus"></i> Add</a>
			<a href="#" class="btn btn-danger" id="deleteLeaveType"><i class="icon-trash"></i> Delete</a>
		</div>
</div>
</body>
<%

	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/leavetype/list_leaveType.jsp");
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
long groupId = themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LeaveType.class,PortletClassLoaderUtil.getClassLoader());

dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));

List<LeaveType> leaveTypeList =  LeaveTypeLocalServiceUtil.dynamicQuery(dynamicQuery);


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
		  List<LeaveType> pageList = ListUtil.subList(leaveTypeList, searchContainer.getStart(), searchContainer.getEnd());
	
		
		  if(leaveTypeList.size()>5){
			  
			  results = ListUtil.subList(leaveTypeList, searchContainer.getStart(), searchContainer.getEnd());
		  }
		  else{
		  results = leaveTypeList;
		  }
		  System.out.println("results == " +results);
		
		  total = leaveTypeList.size();
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

	<liferay-ui:search-iterator paginate="<%=true%>" />

</liferay-ui:search-container>
</div>
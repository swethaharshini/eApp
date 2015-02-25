<%@page import="org.apache.log4j.Logger"%>
<%@ include file="/html/employmentstatus/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<portlet:actionURL var="saveemploymentstatus" name="saveEmploymentStatus">
</portlet:actionURL>
<portlet:resourceURL var="deleteemploymentstatus" id="deleteEmploymentstatus"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/employmentstatus/addemploymentstatus.jsp" />
</portlet:renderURL>
<aui:script>
 AUI().ready('event', 'node','transition',function(A){
  setTimeout(function(){
    A.one('#editEmploymentStatusMessage').transition('fadeOut');
    A.one('#editEmploymentStatusMessage').hide();
},2000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editemploymentstatuscancel');
    node.on(
      'click',
      function() {
        window.location='<%=listview%>';
      }
    );																																
  }
);

</aui:script>
<% Logger log=Logger.getLogger(this.getClass().getName());%>
<% 
 EmploymentStatus editemploymentstatus = (EmploymentStatus)portletSession.getAttribute("editemploymentstatus");
if(SessionMessages.contains(renderRequest.getPortletSession(),"employmentStatus-empty-error")){%>
<p id="editEmploymentStatusMessage" class="alert alert-error"><liferay-ui:message key="Please Enter EmploymentStatus"/></p>
<%}
%>
	
<div id="editEmploymentStatusForm" class="panel">
	<div class="panel-heading">
		<h4>Edit</h4>
	</div>
	<div class="panel-body">
		<aui:form name="myemploymentstatusForm" action="<%=saveemploymentstatus.toString()%>" >
		<aui:input name="employmentstatusId" type="hidden" id="employmentstatusId" value="<%=editemploymentstatus.getEmploymentStatusId()%>" />
			<div class="form-inline">
				<label>Employment Status: </label>
				<input name="<portlet:namespace/>employmentstatus" type="text" value="<%=editemploymentstatus.getEmploymentstatus() %>">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
				<button  type="reset" id ="editemploymentstatuscancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
			</div>
		</aui:form>
	</div>
</div>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/employmentstatus/editemploymentstatus.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	log.info("if block...");
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}
log.info("after....");
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery empStatusDynamicQuery = DynamicQueryFactoryUtil
.forClass(EmploymentStatus.class,
		PortletClassLoaderUtil.getClassLoader());
empStatusDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<EmploymentStatus> empDetails = EmploymentStatusLocalServiceUtil
.dynamicQuery(empStatusDynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<EmploymentStatus> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Employment Status"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
		System.out.println("addemployee jsp =========");
        List<EmploymentStatus> employmentstatusList =ListUtil.subList(empDetails, searchContainer.getStart(), searchContainer.getEnd());
        OrderByComparator orderByComparator = CustomComparatorUtil.getEmploymentStatusrOrderByComparator(sortByCol, sortByType);         

       Collections.sort(employmentstatusList,orderByComparator);
			if(empDetails.size()>5)
			{
      results = employmentstatusList;
			}
			else{
				results = empDetails;
			}
      log.info("results == " +results);
           total = empDetails.size();
           System.out.println("total == " +total);
           pageContext.setAttribute("results", results);
           pageContext.setAttribute("total", total);
           %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="EmploymentStatus" keyProperty="employmentStatusId" modelVar="EmploymentStatus"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Employment Status" property="employmentstatus" orderableProperty="employmentstatus"/>
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/employmentstatus/edit.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>

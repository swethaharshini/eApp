<%@page import="org.apache.log4j.Logger"%>
<%@ include file="/html/jobcategory/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jobcategory</title>
<portlet:actionURL var="savejobcategory" name="saveJobcategory">
</portlet:actionURL>
<portlet:resourceURL var="deletejobcategory" id="deleteJobcategory"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/jobcategory/add.jsp" />
</portlet:renderURL>
<aui:script>
AUI().ready('event', 'node','transition',function(A){
 A.one('#jobcategoryName').focus();
  setTimeout(function(){
    A.one('#editJobcategoryMessage').transition('fadeOut');
    A.one('#editJobcategoryMessage').hide();
},2000)
 });


AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editjobcategorycancel');
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
 JobCategory editjobcategory = (JobCategory)portletSession.getAttribute("editjobcategory");
%>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobcategoryName-empty-error")){%>
<p id="editJobcategoryMessage" class="alert alert-error"><liferay-ui:message key="Please Enter JobcategoryName"/></p>
<%} 
%>
<div class="row-fluid">
	<div id="editJobCategoryForm">
		<div class="panel">
			<div class="panel-heading"><h4>Edit</h4></div>
			<div class="panel-body">
				<aui:form name="myForm" action="<%=savejobcategory.toString()%>" >
					<aui:input name="jobcategoryId" type="hidden" id="jobcategoryId" value="<%=editjobcategory.getJobCategoryId()%>" />
					<div class="form-inline">
						<label>Job Category: </label>
						<input name="<portlet:namespace/>jobcategory" id="jobcategoryName" type="text" value="<%=editjobcategory.getJobcategory()%>">
						<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
						<button  type="reset" id ="editjobcategorycancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/jobcategory/edit.jsp");
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
long groupID=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(JobCategory.class,PortletClassLoaderUtil
		.getClassLoader());
dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupID));
List<JobCategory> jobCategoryList=JobCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<JobCategory> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
		  
		List<JobCategory> pageList = ListUtil.subList(jobCategoryList, searchContainer.getStart(), searchContainer.getEnd());
        OrderByComparator orderByComparator = CustomComparatorUtil.getJobcategoryrOrderByComparator(sortByCol, sortByType);         

       Collections.sort(pageList,orderByComparator);
			if(jobCategoryList.size()>5){
      results = ListUtil.subList(jobCategoryList, searchContainer.getStart(), searchContainer.getEnd());
			}
			else{
				results = jobCategoryList;
			}
        log.info("results == " +results);
       
 
           total = jobCategoryList.size();
           log.info("total == " +total);
           pageContext.setAttribute("results", results);
           pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="JobCategory" keyProperty="jobCategoryId" modelVar="JobCategory"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Job Category" property="jobcategory" orderableProperty="jobcategory"/>
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/jobcategory/editclick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>

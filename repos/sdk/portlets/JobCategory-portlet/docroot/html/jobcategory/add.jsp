<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="org.apache.log4j.Logger"%>
<%@ include file="/html/jobcategory/init.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<portlet:actionURL var="savejobcategory" name="saveJobcategory">
</portlet:actionURL>
<portlet:resourceURL var="deletejobcategory" id="deleteJobcategory"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/jobcategory/add.jsp" />
</portlet:renderURL>
<aui:script>
AUI().ready('event', 'node','transition',function(A){
  A.one('#addJobcategoryForm').hide();
  setTimeout(function(){
    A.one('#addJobcategoryMessage').transition('fadeOut');
    A.one('#addJobcategoryMessage').hide();
},2000)
 });
 </aui:script>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#jobcategorydelete');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
    
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected jobcategory ?");
		  if(d){
		   var url = '<%=deletejobcategory%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />jobcategoryIds: idArray,  
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
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#jobcategoryadd');
    node.on(
      'click',
      function() {
         A.one('#jobadddelete').hide();
         A.one('#addJobcategoryForm').show();
         A.one('#jobcategoryName').focus();           
      }
    );
  }
);

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#jobcategorycancel');
    node.on(
      'click',
      function() {
         A.one('#jobadddelete').show();
         A.one('#addJobcategoryForm').hide();
                     
      }
    );
  }
);

</aui:script>
<% Logger log=Logger.getLogger(this.getClass().getName());%>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobcategoryName-empty-error")){%>
<p id="addJobcategoryMessage" class="alert alert-error"><liferay-ui:message key="Please Enter JobcategoryName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"jobCategoryName-duplicate-error")){
%>
<p id="addJobcategoryMessage" class="alert alert-error"><liferay-ui:message key="JobcategoryName already Exits"/></p>
<%} 
%>

    <div class="row-fluid">
		<div id="jobadddelete" class="span12 text-right">
			<div class="control-group">
				<a href="#" class="btn btn-primary" id="jobcategoryadd"><i class="icon-plus"></i> Add</a>
				<a href="#" class="btn btn-danger" id="jobcategorydelete"><i class="icon-trash"></i> Delete</a>
			</div>
		</div>
		<div  id="addJobcategoryForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Add</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=savejobcategory.toString()%>" >
						<aui:input name="jobcategoryId" type="hidden" id="jobcategoryId" />
						<div class="form-inline">
							<label>Job Category: </label>
							<input name="<portlet:namespace/>jobcategory" id="jobcategoryName" type="text">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="jobcategorycancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>

	


<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/jobcategory/add.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
log.info("JobCategory jsp...");
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	System.out.println("if block...");
 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
 
	
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}

log.info("after....");
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
long groupID=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(JobCategory.class,PortletClassLoaderUtil
		.getClassLoader());
dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupID));
List<JobCategory> jobCategoryList=JobCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<JobCategory> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records is available for Jobcategory"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
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
	<liferay-ui:search-container-row className="JobCategory"
		keyProperty="jobCategoryId" modelVar="JobCategory" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="Job Category" property="jobcategory"
			orderableProperty="jobcategory" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/jobcategory/editclick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>


<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ include file="/html/jobtitle/init.jsp"%>
<portlet:actionURL var="savejobtitle" name="saveJobtitle">
</portlet:actionURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/jobtitle/add.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="deletejobtitle" id="deleteJobtitle"></portlet:resourceURL>
<html>
<head>
<title>Add Jobtitle</title>
 <aui:script>
 AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#jobtitledelete');
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
			  var d = confirm("Are you sure you want to delete the selected jobtitle ?");
		  if(d){
		   var url = '<%=deletejobtitle%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />jobtitleIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('Deleted Successfully');
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
    var node = A.one('#jobtitleadd');
    node.on(
      'click',
      function() {
         A.one('#jobAddDelete').hide();
         A.one('#addJobForm').show();
                     
      }
    );
  }
);



AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#jobtitlecancel');
    node.on(
      'click',
      function() {
         A.one('#jobAddDelete').show();
         A.one('#addJobForm').hide();
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
A.one('#addJobForm').hide();
setTimeout(function(){
A.one('#addJobMessage').transition('fadeOut');
},2000)
});

</aui:script>
</head>
<body>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobtitleName-empty-error")){%>
<p id="addJobMessage" class="alert alert-error"><liferay-ui:message key="Please Enter JobtitleName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"jobtitleName-duplicate-error")){
%>
<p id="addJobMessage" class="alert alert-error"><liferay-ui:message key="JobtitleName already Exits"/></p>
<%} 
%>
<div class="row-fluid">
	<div id="jobAddDelete" class="span12 text-right">
		<div class="control-group">
			<a href="#" class="btn btn-primary" id="jobtitleadd"><i class="icon-plus"></i> Add</a>
			<a href="#" class="btn btn-danger" id="jobtitledelete"><i class="icon-trash"></i> Delete</a>
		</div>
	</div>
	<div id="addJobForm">
		<div class="panel">
			<div class="panel-heading">
				<h4>Add</h4>
			</div>
			<div class="panel-body">
				<aui:form action="<%=savejobtitle%>">
					<div class="form-horizontal">
						<input type="hidden" id="jobtitleId" name='<portlet:namespace/>jobtitleId'>
						<label class="control-label">Job Title<em>*</em> </label>
						<aui:input type="text" label=""  name="title" maxlength="100"  id="jobtitlename"></aui:input>
						<aui:input type="textarea" label="Description" rows="4" cols="30" name="<portlet:namespace/>description" maxlength="400" id="description"></aui:input>
						<aui:input type="textarea" label="Note" rows="4" cols="30" name="<portlet:namespace/>notes" id="notes"></aui:input>
						<div class="control-group">	
							<div class="controls">	
								<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
								<button type="reset" id ="jobtitlecancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
							</div>
						</div>
					</div>
				</aui:form>
				<div><em>*</em> Required Field</div>
			</div>
		</div>
	</div>
</div>
</body>
 <%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/jobtitle/add.jsp");
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
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery jobTitleDynamicQuery = DynamicQueryFactoryUtil
.forClass(JobTitle.class,
		PortletClassLoaderUtil.getClassLoader());
jobTitleDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<JobTitle> jobTitleDetails = JobTitleLocalServiceUtil
.dynamicQuery(jobTitleDynamicQuery);

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<JobTitle> searchContainer;
%>

 <liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>"  delta="5" emptyResultsMessage="No records is available for Job Title" rowChecker="<%= new RowChecker(renderResponse) %>"  deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<JobTitle> jobtitleList = jobTitleDetails;
            OrderByComparator orderByComparator = CustomComparatorUtil.getJobtitleOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(jobtitleList,orderByComparator);
  
          results = ListUtil.subList(jobtitleList, searchContainer.getStart(), searchContainer.getEnd());
          
            System.out.println("results == " +results);
           
     
               total = jobtitleList!=null && jobtitleList.size()!=0?jobtitleList.size():0;
               System.out.println("total == " +total);
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
		
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="JobTitle" keyProperty="jobTitleId" modelVar="JobTitle"  rowVar="curRow" escapedModel="<%= true %>">
	     
	      <liferay-ui:search-container-column-text orderable="true" name="Job Title" property="title" orderableProperty="title"/>
		<liferay-ui:search-container-column-text orderable="true" name="Description" property="description" orderableProperty="description"/>
		<liferay-ui:search-container-column-text orderable="true" name="Notes" property="notes" orderableProperty="notes"/>
				<liferay-ui:search-container-column-jsp name="Edit"  path="/html/jobtitle/editclick.jsp"/>
		
	     
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container> 
</html>
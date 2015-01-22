<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/jobcategory/init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jobcategory</title>
<portlet:actionURL var="savejobcategory" name="saveJobcategory">
</portlet:actionURL>
<portlet:resourceURL var="deletejobcategory" id="deleteJobcategory"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/jobcategory/add.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
 #addJobcategoryMessage{
 color: red;
}
</style>
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
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
  A.one('#addJobcategoryForm').hide();
  setTimeout(function(){
    A.one('#addJobcategoryMessage').transition('fadeOut');
},1000)
 });


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
</head>

<body>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobcategoryName-empty-error")){%>
<p id="addJobcategoryMessage"><liferay-ui:message key="Please Enter JobcategoryName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"jobCategoryName-duplicate-error")){
%>
<p id="addJobcategoryMessage"><liferay-ui:message key="JobcategoryName already Exits"/></p>
<%} 
%>

    <div class="row-fluid">
		<div id="jobadddelete" class="span12 text-right">
			<a href="#" class="btn btn-primary" id="jobcategoryadd"><i class="icon-plus"></i></a>
			<a href="#" class="btn btn-danger" id="jobcategorydelete"><i class="icon-trash"></i></a>
		</div>
		<div  id="addJobcategoryForm">
		<aui:form name="myForm" action="<%=savejobcategory.toString()%>" >
			<aui:input name="jobcategoryId" type="hidden" id="jobcategoryId" />
			<div class="form-inline">
				<label>Job Category: </label>
				<input name="<portlet:namespace/>jobcategory" type="text">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i></button>
				<button  type="reset" id ="jobcategorycancel" class="btn btn-danger"><i class="icon-remove"></i></button>
			</div>
		</aui:form>
		</div>
	</div>

	
</body>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/jobcategory/add.jsp");
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
		
		   ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		   
		   DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JobCategory.class,PortletClassLoaderUtil.getClassLoader());
		  
		    dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId",new Long(themeDisplay.getCompanyId()) ));
		
		    List<JobCategory> jobcategoryList = JobCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
            System.out.println("list size == " +jobcategoryList.size());
            OrderByComparator orderByComparator = CustomComparatorUtil.getJobcategoryrOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(jobcategoryList,orderByComparator);
  
           if(jobcategoryList.size()>5){
				
       		results = ListUtil.subList(jobcategoryList, searchContainer.getStart(), searchContainer.getEnd());
       		}
       		else{
       			System.out.println("else block...");
       			results = jobcategoryList;
       		}
          
            System.out.println("results == " +results);
           
     
               total = jobcategoryList.size();
               System.out.println("total == " +total);
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

</html>
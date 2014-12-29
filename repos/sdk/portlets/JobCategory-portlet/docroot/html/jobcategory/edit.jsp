<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/jobcategory/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
em{
 color: red;
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
</aui:script><aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#editjobadddelete').hide();
         A.one('#editJobCategoryForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editjobadddelete').hide();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editcancel');
    node.on(
      'click',
      function() {
      	 window.location='<%=listview%>';
      	
          
      }
    );																																
  }
);
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#reset');
    node.on(
      'click',
      function() {
       alert("hii")
      
     });
     });
</aui:script>



</head>
<body>
<%
 JobCategory editjobcategory = (JobCategory)portletSession.getAttribute("editjobcategory");
%>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobcategoryName-empty-error")){%>
<liferay-ui:message key="Please Enter JobcategoryName"/>
<%} 
%>
	<br/><br/>
	<div id="editJobCategoryForm">
  <aui:form name="myForm" action="<%=savejobcategory.toString()%>">
		<aui:input name="jobcategoryId" type="hidden" id="jobcategoryId"  value="<%=editjobcategory.getJobCategoryId()%>"/>
		<div class="span12">
				<div class="span2">
						<label>Job Category<em>*</em></label>
			 </div>
			 <div class="span3">
			 <aui:input name="jobcategory" id="editjobcategory" class="jobcategory" type="text" label="" value="<%=editjobcategory.getJobcategory()%>"><aui:validator name="required"></aui:validator> </aui:input>
						</div>
					</div>
	<aui:button type="submit" value="Submit"/> <aui:button  type="reset" value="Cancel" id ="editcancel"></aui:button><input type="button" value="Delete" class="btn" id="delete">
	</aui:form>
	</div>
	 <div><em>*</em> Required Field</div>
</body>
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
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<JobCategory> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<JobCategory> jobcategoryList = JobCategoryLocalServiceUtil.getJobCategories(searchContainer.getStart(), searchContainer.getEnd());
            System.out.println("list size == " +jobcategoryList.size());
            OrderByComparator orderByComparator = CustomComparatorUtil.getJobcategoryrOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(jobcategoryList,orderByComparator);
  
          results = jobcategoryList;
          
            System.out.println("results == " +results);
           
     
               total = JobCategoryLocalServiceUtil.getJobCategoriesCount();
               System.out.println("total == " +total);
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
</html>
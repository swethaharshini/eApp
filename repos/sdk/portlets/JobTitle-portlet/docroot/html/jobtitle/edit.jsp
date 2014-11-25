<%@page import="com.rknowsys.eapp.hrm.model.JobTitle"%>
<%@page import="com.rknowsys.eapp.JobTitleAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ include file="/html/jobtitle/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<portlet:actionURL var="savejobtitle" name="saveJobtitle">
</portlet:actionURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/jobtitle/add.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="deletejobtitle" id="deleteJobtitle"></portlet:resourceURL>
<html>
<head>

<style type="text/css">

em {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#button-set {
	margin-left: 40px;
}
</style>
<title>Edit Jobtitle</title>
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
</head>


<%
 
JobTitle jobtitle = (JobTitle) portletSession.getAttribute("editjobtitle");


%> 

 

<body>
	
		<aui:form action="<%=savejobtitle%>">

		<div class="row-fluid">	<input class="jobtitleId" type="hidden" id="jobtitleId"	name='<portlet:namespace/>jobtitleId' value="<%=jobtitle.getJobTitleId() %>"></div>

		<div class="row-fluid">
		<div class="span2">	<label>Job Title</label></div>
			<div class="span2">	<input type="text" name="<portlet:namespace/>title" maxlength="100"
				id="jobtitlename" value="<%=jobtitle.getTitle()%>" required = "required"/></div><div class="span10"></div></div>
	<div class="row-fluid">
		<div class="span2">	<label for="jobTitle_jobDescription">Job Description</label></div><div class="span2"><textarea rows="4" cols="30"
					name="<portlet:namespace/>description" maxlength="400"
					id="description"><%=jobtitle.getDescription()%></textarea></div><div class="10"></div></div>



<div class="row-fluid">
	<div class="span2">		<label for="jobTitle_note">Note</label></div>
    <div class="span2">			<textarea rows="4" cols="30" name="<portlet:namespace/>notes"
					id="notes"><%=jobtitle.getNotes()%></textarea></div><div class="span10"></div>

		</div>
			
			
						
			<aui:button type="submit" name="submit" value="Submit" id="submit"></aui:button>
			   <aui:button type="reset" value="reset"></aui:button>
			   <input type="button" class="btn" value="Delete" id="delete">
			
		</aui:form>
	



</body>
<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/jobtitle/edit.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<JobTitle> searchContainer;
%>

 <liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>"  delta="5" emptyResultsMessage="No records is available for Job Title" rowChecker="<%= new RowChecker(renderResponse) %>"  deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<JobTitle> jobtitleList = JobTitleLocalServiceUtil.getJobTitles(searchContainer.getStart(), searchContainer.getEnd()); //UserLocalServiceUtil.getUser(-1,-1);
            System.out.println("list size == " +jobtitleList.size());
            OrderByComparator orderByComparator = CustomComparatorUtil.getJobtitleOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(jobtitleList,orderByComparator);
  
          results = jobtitleList;
          
            System.out.println("results == " +results);
           
     
               total = JobTitleLocalServiceUtil.getJobTitlesCount();
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
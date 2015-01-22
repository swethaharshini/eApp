<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
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
<title>Edit Jobtitle</title>
<aui:script>
 AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#jobtitledelete');
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
  <aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#jobtitleadd');
    node.on(
      'click',
      function() {
         A.one('#editJobAddDelete').hide();
         A.one('#editJobForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editJobAddDelete').hide();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editJobtitleCancel');
    node.on(
      'click',
      function() {
      
      	  window.location='<%=listview%>';
      	
          
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
  
  <% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobtitleName-empty-error")){%>
<liferay-ui:message key="Please Enter JobtitleName"/>
<%}
%>
<div class="row-fluid">
	<div id="editJobAddDelete" class="span12 text-right">
		<a href="#" class="btn btn-primary" id="jobtitleadd"><i class="icon-plus"></i></a>
		<a href="#" class="btn btn-danger" id="jobtitledelete"><i class="icon-trash"></i></a>
	</div>
	<div  id="editJobForm">
		<div class="panel">
			<div class="panel-heading">
				<h4>Edit</h4>
			</div>
			<div class="panel-body">
				<aui:form action="<%=savejobtitle%>">
					<div class="form-horizontal">
						<input class="jobtitleId" type="hidden" id="jobtitleId"	name='<portlet:namespace/>jobtitleId' value="<%=jobtitle.getJobTitleId() %>">
						<label class="control-label">Job Title<em>*</em></label>
						<aui:input type="text" label="" name="title" maxlength="100" id="jobtitlename" value="<%=jobtitle.getTitle()%>"/>
						<aui:input type="textarea" label="Job Description" rows="4" cols="30" name="<portlet:namespace/>description" maxlength="400" id="description"><%=jobtitle.getDescription()%></aui:input>
						<aui:input type="textarea" label="Note" rows="4" cols="30" name="<portlet:namespace/>notes" id="notes"><%=jobtitle.getNotes()%></aui:input>
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
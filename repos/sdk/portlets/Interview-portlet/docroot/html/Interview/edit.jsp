<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/Interview/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>interview</title>
<portlet:actionURL var="saveinterview" name="saveInterview">
</portlet:actionURL>
<portlet:resourceURL var="deleteinterview" id="deleteInterview"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/interview/add.jsp" />
</portlet:renderURL>
<style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
em {
	color: red;
}
</style>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editinterviewdelete');
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
			  var d = confirm("Are you sure you want to delete the selected records ?");
		  if(d){
		   var url = '<%=deleteinterview%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />interviewIds: idArray,  
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
         A.one('#editinterviewadddelete').hide();
         A.one('#editInterviewForm').show();
         A.one("#interviewId").set("value","");
         A.one("#editinterview").set("value","");
         
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editinterviewadddelete').hide();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editcancel');
    node.on(
      'click',
      function() {
      	 A.one('#editinterviewadddelete').show();
         A.	one('#editInterviewForm').hide();
         A.one("#editinterview").set("value","");
         A.one("#interviewId").set("value","");
      	
          
      }
    );																																
  }
);

</aui:script>



</head>
<body>
<%
Interview editinterview = (Interview) portletSession.getAttribute("editinterview");

%>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"interviewName-empty-error")){%>
<liferay-ui:message key="Please Enter InterviewName"/>
<%}
%>
<br/><br/>
<div id="editInterviewForm">
  <aui:form name="myForm" action="<%=saveinterview.toString()%>">
		<input name="<portlet:namespace/>interviewId" type="hidden" id="interviewId" value="<%=editinterview.getInterviewId()%>">
		<div class="span12">
				<div class="span2">
						<label>Interview Name<em>*</em> </label>
			 </div>
			 <div class="span3">
			 <aui:input name="name" id="editinterview" label="" class="interview" type="text" value="<%=editinterview.getName()%>"/>
						</div>
					</div>
	
	<div class="control-group">
			<div class="controls">
				<aui:button type="submit" value="Submit" />
				<aui:button  type="reset" value="Cancel" id ="editcancel"/>
				<input type="button" value="Delete" class="btn" id="editinterviewdelete">
			</div>
		</div>
	</aui:form>
	
	<em>*</em> Required field
	
	</div>
	<div><label style="color: white" >.</label></div>
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/Interview/edit.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<Interview> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Interview"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<Interview> interviewList = InterviewLocalServiceUtil.getInterviews(searchContainer.getStart(), searchContainer.getEnd());
            System.out.println("list size == " +interviewList.size());
            OrderByComparator orderByComparator = CustomComparatorUtil.getInterviewrOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(interviewList,orderByComparator);
  
          results = interviewList;
          
            System.out.println("results == " +results);
           
     
               total = InterviewLocalServiceUtil.getInterviewsCount();
               System.out.println("total == " +total);
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Interview" keyProperty="interviewId" modelVar="Interview"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Interview" property="name" orderableProperty="interview"/>
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/Interview/editclick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>
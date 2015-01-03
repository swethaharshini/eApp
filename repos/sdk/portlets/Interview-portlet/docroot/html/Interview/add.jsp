<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/Interview/init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interview</title>
<portlet:actionURL var="saveinterview" name="saveInterview">
</portlet:actionURL>
<portlet:resourceURL var="deleteinterview" id="deleteInterview"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/Interview/add.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
 #addInterviewMessage{
 color: red;
}
</style>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#interviewdelete');
    node.on(
      'click',
      function() {
     var idArray = [];
     
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      
      idArray.push(object.get("value"));
    
        });
         console.log(idArray);
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
</aui:script>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#interviewadd');
    node.on(
      'click',
      function() {
         A.one('#interviewadddelete').hide();
         A.one('#addInterviewForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
  A.one('#addInterviewForm').hide();
  setTimeout(function(){
    A.one('#addInterviewMessage').transition('fadeOut');
},1000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#interviewcancel');
    node.on(
      'click',
      function() {
         A.one('#interviewadddelete').show();
         A.one('#addInterviewForm').hide();
                     
      }
    );
  }
);

</aui:script>
</head>

<body>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"interviewName-empty-error")){%>
<p id="addInterviewMessage"><liferay-ui:message key="Please Enter InterviewName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"interviewName-duplicate-error")){
%>
<p id="addInterviewMessage"><liferay-ui:message key="InterviewName already Exits"/></p>
<%} 
%>

 <div class="row-fluid">
		<div id="interviewadddelete" class="span12 text-right">
			<a href="#" class="btn btn-primary" id="interviewadd"><i class="icon-plus"></i></a>
			<a href="#" class="btn btn-danger" id="interviewdelete"><i class="icon-trash"></i></a>
		</div>
		<div  id="addInterviewForm">
		<aui:form name="myForm" action="<%=saveinterview.toString()%>" >
			<aui:input name="interviewId" type="hidden" id="interviewId" />
			<div class="form-inline">
				<label>Interview Name: </label>
				<input name="<portlet:namespace/>name" type="text">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i></button>
				<button  type="reset" id ="interviewcancel" class="btn btn-danger"><i class="icon-remove"></i></button>
			</div>
		</aui:form>
		</div>
	</div>
 	
</body>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/Interview/add.jsp");
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
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" 
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records is available for Interview"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
	<%
			List<Interview> interviewList =  InterviewLocalServiceUtil.getInterviews(searchContainer.getStart(), searchContainer.getEnd());
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
	<liferay-ui:search-container-row className="Interview"  
		keyProperty="interviewId" modelVar="Interview" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="Interview" property="name"
			orderableProperty="interview" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/Interview/editclick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>

</html>
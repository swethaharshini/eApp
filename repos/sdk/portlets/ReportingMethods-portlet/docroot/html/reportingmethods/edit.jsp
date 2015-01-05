<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.rknowsys.eapp.hrm.service.ReportingMethodsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.ReportingMethods"%>
<%@ include file="/html/reportingmethods/init.jsp" %>
<portlet:actionURL var="updatereportingmethod" name="updateReportingMethod">
</portlet:actionURL>
<portlet:resourceURL var="deletereportingmethod" id="deleteReportingMethod"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/reportingmethods/add.jsp" />
</portlet:renderURL>
<style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
.aui input[type="text"]{
border-radius: 4px;
}
 #editReportingMethodMessage{
 color: red;
}
</style>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#reportingmethoddelete');
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
			  var d = confirm("Are you sure you want to delete the selected reportingmethods?");
		  if(d){
		   var url = '<%=deletereportingmethod%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />languageIds: idArray,  
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
    var node = A.one('#reportingmethodadd');
    node.on(
      'click',
      function() {
         A.one('#editReportingMethodAddDelete').hide();
         A.one('#editReportingMethodForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
  setTimeout(function(){
    A.one('#editReportingMethodMessage').transition('fadeOut');
},1000)
 });
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editreportingmethodcancel');
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
<body>
<% 
 ReportingMethods editReportingMethod =(ReportingMethods) portletSession.getAttribute("editReportingMethod");
if(SessionMessages.contains(renderRequest.getPortletSession(),"reportingmethodName-empty-error")){%>
<p id="editReportingMethodMessage"><liferay-ui:message key="Please Enter ReportingmethodName"/></p>
<%} 
%>
      <div class="row-fluid">
		<div id="editReportingMethodAddDelete" class="span12 text-right">
			<a href="#" class="btn btn-primary" id="reportingmethodadd"><i class="icon-plus"></i></a>
			<a href="#" class="btn btn-danger" id="reportingmethoddelete"><i class="icon-trash"></i></a>
		</div>
		<div  id="editReportingMethodForm">
		<aui:form name="myForm" action="<%=updatereportingmethod.toString()%>" >
			<aui:input name="reportingmethodId" type="hidden" id="reportingmethodId" value="<%=editReportingMethod.getReportingmethodId()%>" />
			<div class="form-inline">
				<label>ReportingMethod Name: </label>
				<input name="<portlet:namespace/>reportingmethodName" type="text" value="<%=editReportingMethod.getReportingmethodName() %>">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i></button>
				<button  type="reset" id ="reportingmethodcancel" class="btn btn-danger"><i class="icon-remove"></i></button>
			</div>
		</aui:form>
		</div>
	</div>
     
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/reportingmethods/edit.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<ReportingMethods> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for ReportingMethods"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<ReportingMethods> listOfReportingMethods = ReportingMethodsLocalServiceUtil.getReportingMethodses(searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getReportingMethodsOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(listOfReportingMethods,orderByComparator);
  
          results = listOfReportingMethods;
          
           
     
               total = ReportingMethodsLocalServiceUtil.getReportingMethodsesCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="ReportingMethods" keyProperty="reportingmethodId" modelVar="reportingmethodId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="ReportingMethod" property="reportingmethodName" orderableProperty="reportingmethodName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/reportingmethods/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>






<%@page import="com.rknowsys.eapp.hrm.service.TerminationReasonsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.TerminationReasons"%>
<%@ include file="/html/terminationreasons/init.jsp" %>
<portlet:actionURL var="updateterminationreasons" name="updateTerminationReasons">
</portlet:actionURL>
<portlet:resourceURL var="deleteterminationreasons" id="deleteTerminationReasons"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/terminationreasons/add.jsp" />
</portlet:renderURL>
<style type="text/css">	
.table-first-header{
width: 10%;
}
em{
 color: red;
}
.table-last-header{
width: 15%;
}
.aui input[type="text"]{
border-radius: 4px;
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
			  var d = confirm("Are you sure you want to delete the selected TerminationReasons?");
		  if(d){
		   var url = '<%=deleteterminationreasons%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />terminationreasonsIds: idArray,  
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
         A.one('#editterminationreasonsAddDelete').hide();
         A.one('#editterminationreasonsForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editterminationreasonsAddDelete').hide();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editCancel');
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
<jsp:useBean id="editTerminationReasons" type="com.rknowsys.eapp.hrm.model.TerminationReasons" scope="request" />

	<div id="editterminationreasonsForm">
  <aui:form name="myForm" action="<%=updateterminationreasons.toString()%>">
		<aui:input name="terminationreasonsId" type="hidden" id="terminationreasonsId"  value="<%=editTerminationReasons.getTerminationreasonsId()%>"/>
			 	<div class="span12">
			<div class="span2">
				<label>Name<em>*</em></label>
		</div>
		<div class="span3">		
		 <input name="<portlet:namespace/>terminationreasonsName" type="text" required = "required" value="<%=editTerminationReasons.getTerminationreasonsName() %>" >
			</div>
			</div>
	<aui:button type="submit" value="Submit"/> <aui:button  type="reset" value="Cancel" id ="editCancel"></aui:button><input type="button" class="btn" value="Delete" id ="delete"></input>
	</aui:form>
	</div>
	 <div><em>*</em> Required Field</div>
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/terminationreasons/edit.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<TerminationReasons> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for ReportingMethods"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<TerminationReasons> listOfTerminationReasons = TerminationReasonsLocalServiceUtil.getTerminationReasonses(searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getterminationreasonsOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(listOfTerminationReasons,orderByComparator);
  
          results = listOfTerminationReasons;
          
           
     
               total = TerminationReasonsLocalServiceUtil.getTerminationReasonsesCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="TerminationReasons" keyProperty="terminationreasonsId" modelVar="terminationreasonsId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="TerminationReason Name" property="terminationreasonsName" orderableProperty="terminationreasonsName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/terminationreasons/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>






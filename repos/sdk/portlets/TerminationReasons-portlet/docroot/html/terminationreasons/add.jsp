<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.rknowsys.eapp.hrm.service.TerminationReasonsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.TerminationReasons"%>
<%@ include file="/html/terminationreasons/init.jsp"%>

<portlet:actionURL var="saveterminationreasons" name="saveTerminationReasons">
</portlet:actionURL>
<portlet:resourceURL var="deleteterminationreasons" id="deleteTerminationReasons"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/terminationreasons/add.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
em{
color: red;
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
			  var d = confirm("Are you sure you want to delete the selected TerminationReasons ?");
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
</aui:script>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#terminationreasonsAddDelete').hide();
         A.one('#addterminationreasonsForm').show();
                     
      }
    );
  }
);



AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancel');
    node.on(
      'click',
      function() {
         A.one('#terminationreasonsAddDelete').show();
         A.one('#addterminationreasonsForm').hide();
                     
      }
    );
  }
);

</aui:script>
</head>

<body>
<div class="row-fluid">
 <% if(SessionMessages.contains(renderRequest.getPortletSession(),"termination-form-error")){%>
<liferay-ui:message key="Please Enter TerminationReason"/>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"termination-form-duplicate-error")){
%>
<liferay-ui:message key="TerminationName already Exits"/>
<%} 
%>
</div>

	<div  id="addterminationreasonsForm" class="row-fluid">
	<aui:form name="myForm" action="<%=saveterminationreasons.toString()%>" >
		<aui:input name="terminationreasonsId" type="hidden" id="terminationreasonsId" />
	
		<div class="span12">
			<div class="span2">
				<label>Name<em>*</em></label>
		</div>
		<div class="span3">		
		 <input name="<portlet:namespace/>terminationreasonsName" type="text" required = "required">
			</div>
		</div>
		<aui:button type="submit" value="Submit" />
		<aui:button  type="reset" value="Reset" id ="cancel"/>
		<input type="button" class="btn" value="Delete" id ="delete"></input>
	</aui:form>
	</div>
	
	 <div><em>*</em> Required Field</div>
	
</body>

 <%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/terminationreasons/add.jsp");
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
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for TerminationReasons"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
            List<TerminationReasons> terminationReasonsList = TerminationReasonsLocalServiceUtil.getTerminationReasonses(searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getterminationreasonsOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(terminationReasonsList,orderByComparator);
  
               results = terminationReasonsList;
               total = TerminationReasonsLocalServiceUtil.getTerminationReasonsesCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="TerminationReasons"
		keyProperty="terminationreasonsId" modelVar="terminationreasonsId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="TerminationReason Name" property="terminationreasonsName"
			orderableProperty="terminationreasonsName" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/terminationreasons/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container> 
</div>


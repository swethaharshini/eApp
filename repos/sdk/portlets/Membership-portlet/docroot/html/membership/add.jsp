<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/membership/init.jsp"%>

<portlet:actionURL var="saveMemberships" name="saveMembership">
</portlet:actionURL>
<portlet:resourceURL var="deleteMemberships" id="deleteMembership"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/membership/add.jsp" />
</portlet:renderURL>
<style type="text/css">
.aui input[type="text"]{
height: initial;
}
em{
color: red;
}
</style>
<aui:script>
YUI().use(
  'aui-form-validator',
  function(Y) {
    new Y.FormValidator(
      {
        boundingBox: '#myForm'
      }
    );
  }
);



AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delete');
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
			  var d = confirm("Are you sure you want to delete the selected membership ?");
		  if(d){
		   var url = '<%=deleteMemberships%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />membershipIds: idArray,  
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
</head>

<body>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"membershipName-empty-error")){%>
<liferay-ui:message key="Please Enter MembershipName"/>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"membershipName-duplicate-error")){
%>
<liferay-ui:message key="MembershipName already Exits"/>
<%} 
%>
 <br/><br/>
		<form id="myForm" action="<%=saveMemberships.toString()%>" method="post">
				<input name="<portlet:namespace/>membershipId" type="hidden" id="membershipId" />
				<div class="row-fluid">
  <div class="form-group">
   <div class="span2"> <label class="control-label" for="name">Membership Name:<em>*</em></label></div>
    <div class="span3">
    <div class="controls">
      <input name="<portlet:namespace/>membership_name" id="myAutoComplete" class="form-control field-required" type="text">
     </div>
    </div>
  </div>
</div>
<br/>
<div>
 <input class="btn btn-info" type="submit" value="Submit">
  <input class="btn btn-primary" type="reset" value="Reset">
  <aui:button name="" value="Delete" id="delete"/>
</div>
</form>
	
<div><em>*</em> Required Field</div>
	
</body>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/membership/add.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<Membership> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for Memberships"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
            List<Membership> membershipList = MembershipLocalServiceUtil.getMemberships(searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getMembershipOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(membershipList,orderByComparator);
  
               results = membershipList;
               total = MembershipLocalServiceUtil.getMembershipsCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Membership"
		keyProperty="membershipId" modelVar="membershipId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="name" property="membershipName"
			orderableProperty="membershipName" />
	
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/membership/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>


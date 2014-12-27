<%@ include file="/html/membership/init.jsp" %>
<portlet:actionURL var="updateMemberships" name="updateMembership">
</portlet:actionURL>
<portlet:resourceURL var="deleteMemberships" id="deleteMembership"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/membership/add.jsp" />
</portlet:renderURL>
<style>
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
			  var d = confirm("Are you sure you want to delete the selected membership?");
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
</aui:script><aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#editMembershipAddDelete').hide();
         A.one('#editMembershipForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editMembershipAddDelete').hide();
 
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
<%
Membership editMembership =(Membership) portletSession.getAttribute("editMembership");

%> 


<form id="myForm" action="<%=updateMemberships.toString()%>" method="post">
				<input name="<portlet:namespace/>membershipId" value="<%=editMembership.getMembershipId() %>" type="hidden"/>
				<div class="row-fluid">
  <div class="form-group">
   <div class="span2"> <label class="control-label" for="name">Membership Name:<em>*</em></label></div>
    <div class="span3">
    <div class="controls">
      <input name="<portlet:namespace/>membership_name" id="myAutoComplete" value="<%=editMembership.getMembershipName() %>" class="form-control field-required" type="text">
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
iteratorURL.setParameter("mvcPath", "/html/membership/edit.jsp");
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
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<Membership> listOfMemberships = MembershipLocalServiceUtil.getMemberships(searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getMembershipOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(listOfMemberships,orderByComparator);
  
          results = listOfMemberships;
          
           
     
               total = MembershipLocalServiceUtil.getMembershipsCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Membership" keyProperty="membershipId" modelVar="membershipId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="membershipName" orderableProperty="membershipName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/membership/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>






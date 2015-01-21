<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/license/init.jsp" %>
<portlet:actionURL var="updateLicenses" name="updateLicense">
</portlet:actionURL>
<portlet:resourceURL var="deleteLicenses" id="deleteLicense"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/license/add.jsp" />
</portlet:renderURL>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#licensedelete');
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
			  var d = confirm("Are you sure you want to delete the selected license?");
		  if(d){
		   var url = '<%=deleteLicenses%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />licenseIds: idArray,  
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
    var node = A.one('#licenseadd');
    node.on(
      'click',
      function() {
         A.one('#editLicenseAddDelete').hide();
         A.one('#editLicenseForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
  setTimeout(function(){
    A.one('#editLicenseMessage').transition('fadeOut');
},1000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editlicensecancel');
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
 License editLicense = (License)portletSession.getAttribute("editLicense");
if(SessionMessages.contains(renderRequest.getPortletSession(),"licenseName-empty-error")){%>
<p id="editLicenseMessage" class="alert alert-error"><liferay-ui:message key="Please Enter LicenseName"/></p>
<%}
%>
    
     <div class="row-fluid">
		<div  id="editLicenseForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Edit</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=updateLicenses.toString()%>" >
						<aui:input name="licenseId" type="hidden" id="licenseId"  value="<%=editLicense.getLicenseId()%>" />
						<div class="form-inline">
							<label>License Name: </label>
							<input name="<portlet:namespace/>license_name" type="text" value="<%=editLicense.getLicenseName() %>" >
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="licensecancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
  
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/license/edit.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<License> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<License> listOfLicenses = LicenseLocalServiceUtil.getLicenses(searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getLicensesOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(listOfLicenses,orderByComparator);
  
          results = listOfLicenses;
          
           
     
               total = LicenseLocalServiceUtil.getLicensesCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="License" keyProperty="licenseId" modelVar="licenseId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="licenseName" orderableProperty="licenseName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/license/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>






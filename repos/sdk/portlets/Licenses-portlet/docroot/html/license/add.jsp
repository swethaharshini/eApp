<%@ include file="/html/license/init.jsp"%>

<portlet:actionURL var="saveLicenses" name="saveLicense">
</portlet:actionURL>
<portlet:resourceURL var="deleteLicenses" id="deleteLicense"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/license/add.jsp" />
</portlet:renderURL>

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
    alert(idArray.length);
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected license ?");
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
</aui:script>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#licenseAddDelete').hide();
         A.one('#addLicenseForm').show();
                     
      }
    );
  }
);

 AUI().ready('event', 'node', function(A){

  A.one('#addLicenseForm').hide();
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancel');
    node.on(
      'click',
      function() {
         A.one('#licenseAddDelete').show();
         A.one('#addLicenseForm').hide();
                     
      }
    );
  }
);

</aui:script>
</head>

<body>
	<div class="row-fluid">
	<div id="licenseAddDelete" class="span12 text-right">
		<a href="#" id="add" class="btn btn-success"><i class="icon-plus"></i></a>
		<a href="#" id="delete" class="btn btn-danger"><i class="icon-trash"></i></a>
	</div>
	<div  id="addLicenseForm">
	<aui:form name="myForm" action="<%=saveLicenses.toString()%>" >
		<aui:input name="licenseId" type="hidden" id="licenseId" />
		<div class="row-fluid">
			<div class="span2 text-right">
				<label>Name</label>
			</div>
			<div class="span6">		
			 	<input name="<portlet:namespace/>license_name" type="text" required = "required">
			</div>
		</div>
		<div class="row-fluid">
			<div class="span6 offset2">
				<aui:button type="submit" value="Submit" />
				<aui:button  type="reset" value="Cancel" id ="cancel"/>
			</div>
		</div>
	</aui:form>
	</div>
	</div>
</body>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/license/add.jsp");
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
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for Licenses"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
            List<License> licenseList = LicenseLocalServiceUtil.getLicenses(searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getLicensesOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(licenseList,orderByComparator);
  
               results = licenseList;
               total = LicenseLocalServiceUtil.getLicensesCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="License"
		keyProperty="licenseId" modelVar="licenseId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="name" property="licenseName"
			orderableProperty="licenseName" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/license/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>


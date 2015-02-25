<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
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
    var node = A.one('#licenseadd');
    node.on(
      'click',
      function() {
         A.one('#licenseAddDelete').hide();
         A.one('#addLicenseForm').show();
         A.one('#licenseName').focus();
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
  A.one('#addLicenseForm').hide();
  setTimeout(function(){
    A.one('#addLicenseMessage').transition('fadeOut');
    A.one('#addLicenseMessage').hide();
},2000)
 });
 
 
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#licensecancel');
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

<% 

if(SessionMessages.contains(renderRequest.getPortletSession(),"licenseName-empty-error")){%>
<p id="addLicenseMessage" class="alert alert-error"><liferay-ui:message key="Please Enter LicenseName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"licenseName-duplicate-error")){
%>
<p id="addLicenseMessage" class="alert alert-error"><liferay-ui:message key="LicenseName already Exits"/></p>
<%} 
%>
    
    <div class="row-fluid">
		<div id="licenseAddDelete" class="span12 text-right">
			<div class="control-group">
				<a href="#" class="btn btn-primary" id="licenseadd"><i class="icon-plus"></i> Add</a>
				<a href="#" class="btn btn-danger" id="licensedelete"><i class="icon-trash"></i> Delete</a>
			</div>
		</div>
		<div  id="addLicenseForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Add</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=saveLicenses.toString()%>" >
						<aui:input name="licenseId" type="hidden" id="licenseId" />
						<div class="form-inline">
							<label>License Name: </label>
							<input name="<portlet:namespace/>license_name" id="licenseName" type="text">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="licensecancel" class="btn btn-danger"><i class="icon-remove"> Cancel</i></button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
    


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
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery licenseDynamicQuery = DynamicQueryFactoryUtil
.forClass(License.class,
		PortletClassLoaderUtil.getClassLoader());
licenseDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<License> licenseDetails = LicenseLocalServiceUtil
.dynamicQuery(licenseDynamicQuery);
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
            List<License> licenseList = ListUtil.subList(licenseDetails, searchContainer.getStart(),searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getLicensesOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(licenseList,orderByComparator);
  				if(licenseDetails.size()>5){
  					results = licenseList;
  				}
  				else{
               results =licenseDetails;
  				}
               total =licenseDetails.size();
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


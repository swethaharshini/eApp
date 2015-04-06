<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/license/init.jsp" %>
<portlet:actionURL var="updateLicenses" name="updateLicense">
</portlet:actionURL>
<portlet:resourceURL var="deleteLicenses" id="deleteLicense"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/license/add.jsp" />
</portlet:renderURL>
<aui:script>

</aui:script><aui:script>
AUI().ready('event', 'node','transition',function(A){
  A.one('#licenseName').focus();
  setTimeout(function(){
    A.one('#editLicenseMessage').transition('fadeOut');
    A.one('#editLicenseMessage').hide();
},2000)
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
							<input name="<portlet:namespace/>license_name" id="licenseName" type="text" value="<%=editLicense.getLicenseName() %>" >
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="editlicensecancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>

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
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
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
	<liferay-ui:search-container-row className="License" keyProperty="licenseId" modelVar="licenseId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="licenseName" orderableProperty="licenseName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/license/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>







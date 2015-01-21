<%@include file="/html/locations/init.jsp" %>
<portlet:renderURL var="addLocation">
	<portlet:param name="mvcPath" value="/html/locations/addLocation.jsp"/>
</portlet:renderURL>
<portlet:resourceURL var="deleteLocations"></portlet:resourceURL>
<portlet:renderURL var="viewJSP">
	<portlet:param name="mvcPath" value="/html/locations/view.jsp"/>
</portlet:renderURL>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delLocation');
    node.on(
      'click',
      function() {
     	var idArray = [];
      	A.all('input[name=<portlet:namespace />rowIds]:checked').each(function(object) {
      	idArray.push(object.get("value"));
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected location?");
		  if(d){
		   var url = '<%=deleteLocations%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />id9: idArray,  
                 },
          on: {
               success: function() { 
                   alert('deleted successfully');
                   window.location='<%=viewJSP%>';
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
    var node = A.one('#addLocation1');
    node.on(
      'click',
      function() {
        window.location='<%=addLocation %>';
      }
    );
  }
);

</aui:script>
	<div class="row-fluid">
		<div class="span12 text-right">
			<div class="control-group">
				<button id="addLocation1" class="btn btn-success" type="button" ><i class="icon-plus"></i> Add </button>
				<button id="delLocation" class="btn btn-danger" type="button"><i class="icon-trash"></i> Delete </button> 
			</div>
		</div>
	</div>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/locations/view.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);
PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);
String sortByCol = ParamUtil.getString(request, "orderByCol");
String sortByType = ParamUtil.getString(request, "orderByType");
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) {
} else {
sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");
}
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Location> searchContainer;
%>
<div id="displayLocations">
<liferay-ui:search-container emptyResultsMessage="norecordsfound" 
headerNames="name,city,country,phone,numberofemployees"
iteratorURL="<%=iteratorURL %>"
delta="9"
deltaConfigurable="true"
orderByCol="<%=sortByCol %>"   orderByType="<%=sortByType %>"
rowChecker="<%=new RowChecker(renderResponse) %>" > 
		<liferay-ui:search-container-results>
		<%List<Location> jt=LocationLocalServiceUtil.getLocations(-1, -1);
		  OrderByComparator orderByComparator=CustomComparatorUtil.getLocationsOrderByComparator(sortByCol, sortByType);
		  Collections.sort(jt,orderByComparator);
		  results=ListUtil.subList(jt, searchContainer.getStart(), searchContainer.getEnd());
		  total=LocationLocalServiceUtil.getLocationsCount();
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
		%>
		</liferay-ui:search-container-results>
				<liferay-ui:search-container-row className="com.rknowsys.eapp.hrm.model.Location" 
 				keyProperty="locationId" modelVar="id" >
						 <liferay-ui:search-container-column-text name="name" property="name" orderable="<%=true %>" orderableProperty="name"/>
						 <liferay-ui:search-container-column-text name="city" property="city" />
						 <liferay-ui:search-container-column-text name="country" property="country" />
						 <liferay-ui:search-container-column-text name="phone" property="phone" />
						 	 <liferay-ui:search-container-column-jsp path="/html/locations/edit.jsp" />
 				</liferay-ui:search-container-row>
	 <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>
</div>
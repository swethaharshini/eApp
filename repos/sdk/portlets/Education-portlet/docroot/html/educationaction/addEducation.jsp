<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/educationaction/init.jsp"%>

<portlet:actionURL var="saveEducations" name="saveEducation">
</portlet:actionURL>
<portlet:resourceURL var="deleteEducations" id="deleteEducation"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/educationaction/addEducation.jsp" />
</portlet:renderURL>

<aui:script>

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#deleteeducation');
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
			  var d = confirm("Are you sure you want to delete the selected education ?");
		  if(d){
		   var url = '<%=deleteEducations%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />educationIds: idArray,  
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
    var node = A.one('#addeducation');
    node.on(
      'click',
      function() {
         A.one('#educationAddDelete').hide();
         A.one('#addEducationForm').show();
         A.one('#educationName').focus();
                     
      }
    );
  }
);

 AUI().ready('event', 'node','transition',function(A){
 A.one('#addEducationForm').hide();
setTimeout(function(){
A.one('#addEducationMessage').transition('fadeOut');
A.one('#addEducationMessage').hide();
},2000)

});


AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#canceleducation');
    node.on(
      'click',
      function() {
         A.one('#educationAddDelete').show();
         A.one('#addEducationForm').hide();
                     
      }
    );
  }
);

</aui:script>

<% 
if(SessionMessages.contains(renderRequest.getPortletSession(),"educationName-empty-error")){%>
<p id="addEducationMessage" class="alert alert-error"><liferay-ui:message key="Please Enter Education Name"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"educationName-duplicate-error")){
%>
<p id="addEducationMessage" class="alert alert-error"><liferay-ui:message key="Education Name already Exits"/></p>
<%} 
%>
	<div class="row-fluid">
		<div id="educationAddDelete" class="span12 text-right">
			<div class="control-group">
			<a href="#" class="btn btn-primary" id="addeducation"><i class="icon-plus"></i> Add</a>
			<a href="#" class="btn btn-danger" id="deleteeducation"><i class="icon-trash"></i> Delete</a>
			</div>
		</div>
		<div id="addEducationForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Add</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=saveEducations.toString()%>" >
						<aui:input name="educationId" type="hidden" id="educationId" />
						<div class="form-inline">
							<label>Level: </label>
							<input name="<portlet:namespace/>education_level" id="educationName" type="text">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="canceleducation" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>


<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/educationaction/addEducation.jsp");
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
DynamicQuery educationDynamicQuery = DynamicQueryFactoryUtil
.forClass(Education.class,
		PortletClassLoaderUtil.getClassLoader());
educationDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<Education> educationDetails = EducationLocalServiceUtil
.dynamicQuery(educationDynamicQuery);

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Education> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for Educations"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
		  List<Education> educationList = ListUtil.subList(educationDetails, searchContainer.getStart(), searchContainer.getEnd());
		
				OrderByComparator orderByComparator =  CustomComparatorUtil.getEducationOrderByComparator(sortByCol, sortByType);
		   
		               Collections.sort(educationList,orderByComparator);
		     if(educationDetails.size()>5){
		    	 results = educationList;
		     }
		     else{
		           results = educationDetails;
		     }
		       total = educationDetails.size();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Education"
		keyProperty="educationId" modelVar="educationId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="name" property="eduLevel"
			orderableProperty="eduLevel" />
			<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/educationaction/edit.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>


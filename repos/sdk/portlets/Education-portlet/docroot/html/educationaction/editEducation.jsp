<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/educationaction/init.jsp" %>
<portlet:actionURL var="updateEducations" name="updateEducation">
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
			  var d = confirm("Are you sure you want to delete the selected education?");
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
</aui:script><aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#addeducation');
    node.on(
      'click',
      function() {
         A.one('#editEducationAddDelete').hide();
         A.one('#editEducationForm').show();
                     
      }
    );
  }
);

 AUI().ready('event', 'node','transition',function(A){
  setTimeout(function(){
    A.one('#editEducationMessage').transition('fadeOut');
},1000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editcanceleducation');
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
  Education editEducation = (Education) portletSession.getAttribute("editEducation");
if(SessionMessages.contains(renderRequest.getPortletSession(),"educationName-empty-error")){%>
<p id="editEducationMessage" class="alert alert-error"><liferay-ui:message key="Please Enter Education Name"/></p>
<%} 
 
%>



<div class="row-fluid">
	<div id="editEducationForm">
		<div class="panel">
			<div class="panel-heading">
				<h4>Edit</h4>
			</div>
			<div class="panel-body">
			  	<aui:form name="myForm" action="<%=updateEducations.toString()%>">
					<aui:input name="educationId" type="hidden" id="educationId"  value="<%=editEducation.getEducationId()%>"/>
					<div class="form-inline">
							<label>Level: </label>
					 		<input name="<portlet:namespace/>education_level" type="text" required = "required" value="<%=editEducation.getEduLevel() %>" >
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="editcanceleducation" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/educationaction/editEducation.jsp");
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
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
		  List<Education> educationList = educationDetails;
				OrderByComparator orderByComparator =  CustomComparatorUtil.getEducationOrderByComparator(sortByCol, sortByType);
		   
		               Collections.sort(educationList,orderByComparator);
		  
		               results = ListUtil.subList(educationList, searchContainer.getStart(), searchContainer.getEnd());
		               total = educationList!=null && educationList.size()!=0  ?educationList.size():0;
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Education" keyProperty="educationId" modelVar="educationId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="eduLevel" orderableProperty="eduLevel"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/educationaction/edit.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>






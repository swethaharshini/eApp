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
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#educationAddDelete').hide();
         A.one('#addEducationForm').show();
                     
      }
    );
  }
);

 AUI().ready('event', 'node', function(A){

  A.one('#addEducationForm').hide();
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancel');
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
</head>

<body>
	<div class="row-fluid">
		<div id="educationAddDelete" class="span12 text-right">
			<a href="#" class="btn btn-success" id="add"><i class="icon-plus"></i></a>
			<a href="#" class="btn btn-danger" id="delete"><i class="icon-trash"></i></a>
		</div>
		<div  id="addEducationForm">
		<aui:form name="myForm" action="<%=saveEducations.toString()%>" >
			<aui:input name="educationId" type="hidden" id="educationId" />
			<div class="row-fluid">
				<div class="span2 text-right">
					<label>Level</label>
				</div>
				<div class="span6">		
				 <input name="<portlet:namespace/>education_level" type="text" required = "required">
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
            List<Education> educationList = EducationLocalServiceUtil.getEducations(searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getEducationOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(educationList,orderByComparator);
  
               results = educationList;
               total = EducationLocalServiceUtil.getEducationsCount();
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


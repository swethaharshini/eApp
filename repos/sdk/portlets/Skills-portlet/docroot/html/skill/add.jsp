<%@ include file="/html/skill/init.jsp"%>

<portlet:actionURL var="saveSkills" name="saveSkill">
</portlet:actionURL>
<portlet:resourceURL var="deleteSkills" id="deleteSkill"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/skill/add.jsp" />
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
			  var d = confirm("Are you sure you want to delete the selected skill ?");
		  if(d){
		   var url = '<%=deleteSkills%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />skillIds: idArray,  
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
         A.one('#skillAddDelete').hide();
         A.one('#addSkillForm').show();
                     
      }
    );
  }
);

 AUI().ready('event', 'node', function(A){

  A.one('#addSkillForm').hide();
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancel');
    node.on(
      'click',
      function() {
         A.one('#skillAddDelete').show();
         A.one('#addSkillForm').hide();
                     
      }
    );
  }
);

</aui:script>
</head>

<body>
	<div class="row-fluid">
		<div id="skillAddDelete" class="span12 text-right">
			<a href="#" class="btn btn-primary" id="add"><i class="icon-plus"></i></a>
			<a href="#" class="btn btn-danger" id="delete"><i class="icon-trash"></i></a>
		</div>
		<div  id="addSkillForm">
			<aui:form name="myForm" action="<%=saveSkills.toString()%>" >
				<div class="form-horizontal">
				<aui:input name="skillId" type="hidden" id="skillId" />
				<aui:input name="<portlet:namespace/>skill_name" type="text" label="Name" required = "required" />	
				 <aui:input type="textarea" label="Description" name="<portlet:namespace/>skill_description" rows="5" cols="5"></aui:input>
				<div class="control-group">	
					<div class="controls">	
					<button type="submit" class="btn btn-primary"><i class="icon-ok"></i></button>
					<button  type="reset" id ="cancel" class="btn btn-danger"><i class="icon-remove"></i></button>
					</div>
				</div>
				</div>
			</aui:form>
		</div>
	</div>
</body>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/skill/add.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<Skill> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for Skills"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
            List<Skill> skillList = SkillLocalServiceUtil.getSkills(searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getSkillsrOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(skillList,orderByComparator);
  
               results = skillList;
               total = SkillLocalServiceUtil.getSkillsCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Skill"
		keyProperty="skillId" modelVar="skillId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="name" property="skillName"
			orderableProperty="skillName" />
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="description" property="description"
			orderableProperty="description" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/skill/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>


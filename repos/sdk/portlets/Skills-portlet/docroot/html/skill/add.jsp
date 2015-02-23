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
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
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
         A.one('#<portlet:namespace/>skillName').focus();
                     
      }
    );
  }
);

 AUI().ready('event', 'node', function(A){

  A.one('#addSkillForm').hide();
  setTimeout(function(){
  A.one('#addSkillErrorMessage').transition('fadeOut');
   A.one('#addSkillErrorMessage').hide();
  },2000)
 
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

<% 
if(SessionMessages.contains(renderRequest.getPortletSession(),"skillName-empty-error")){%>
<p id="addSkillErrorMessage" class="alert alert-error"><liferay-ui:message key="Please Enter Skill Name"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"skillName-duplicate-error")){
%>
<p id="addSkillErrorMessage" class="alert alert-error"><liferay-ui:message key="Skill Name already Exits"/></p>
<%} 
%>

		<div id="skillAddDelete" class="control-group text-right">
			<a href="#" class="btn btn-primary" id="add"><i class="icon-plus"></i> Add</a>
			<a href="#" class="btn btn-danger" id="delete"><i class="icon-trash"></i> Delete</a>
		</div>
		<div  id="addSkillForm" class="panel">
			<div class="panel-heading">
				<h4>Add</h4>
			</div>
			<div class="panel-body">
				<aui:form name="myForm" action="<%=saveSkills.toString()%>" >
					<div class="form-horizontal">
					<aui:input name="skillId" type="hidden" id="skillId" />
					<aui:input name="skill_name" type="text" label="Name" id="skillName" />	
					 <aui:input type="textarea" label="Description" name="skill_description" rows="5" cols="5"></aui:input>
					<div class="controls">	
					<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
					<button  type="reset" id ="cancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
					</div>
					</div>
				</aui:form>
			</div>
		</div>


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
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery skillDynamicQuery = DynamicQueryFactoryUtil
.forClass(Skill.class,
		PortletClassLoaderUtil.getClassLoader());
skillDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<Skill> skillDetails = SkillLocalServiceUtil
.dynamicQuery(skillDynamicQuery);
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
            List<Skill> skillList = ListUtil.subList(skillDetails, searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getSkillsrOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(skillList,orderByComparator);
               
               if(skillDetails.size()>5){
            	   results = ListUtil.subList(skillDetails, searchContainer.getStart(), searchContainer.getEnd());
               }
               else{
            	   results= skillDetails;
               }
               total = skillDetails.size();
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


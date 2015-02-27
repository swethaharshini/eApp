<%@ include file="/html/language/init.jsp"%>

<portlet:actionURL var="saveLanguages" name="saveLanguage">
</portlet:actionURL>
<portlet:resourceURL var="deleteLanguages" id="deleteLanguage"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/language/add.jsp" />
</portlet:renderURL>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#languagedelete');
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
			  var d = confirm("Are you sure you want to delete the selected languages ?");
		  if(d){
		   var url = '<%=deleteLanguages%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />languageIds: idArray,  
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
    var node = A.one('#languageadd');
    node.on(
      'click',
      function() {
         A.one('#languageAddDelete').hide();
         A.one('#addLanguageForm').show();
         A.one('#languageName').focus();
                     
      }
    );
  }
);

 AUI().ready('event', 'node','transition',function(A){
  A.one('#addLanguageForm').hide();
  setTimeout(function(){
    A.one('#addLanguageMessage').transition('fadeOut');
     A.one('#addLanguageMessage').hide();
},2000)
 });


AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#languagecancel');
    node.on(
      'click',
      function() {
         A.one('#languageAddDelete').show();
         A.one('#addLanguageForm').hide();
                     
      }
    );
  }
);

</aui:script>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"languageName-empty-error")){%>
<p id="addLanguageMessage" class="alert alert-error"><liferay-ui:message key="Please Enter LanguageName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"languageName-duplicate-error")){
%>
<p id="addLanguageMessage" class="alert alert-error"><liferay-ui:message key="LanguageName already Exits"/></p>
<%} 
%>

  <div class="row-fluid">
		<div id="languageAddDelete" class="span12 text-right">
			<div class="control-group">
				<a href="#" class="btn btn-primary" id="languageadd"><i class="icon-plus"></i> Add</a>
				<a href="#" class="btn btn-danger" id="languagedelete"><i class="icon-trash"></i> Delete</a>
			</div>
		</div>
		<div  id="addLanguageForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Add</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=saveLanguages.toString()%>" >
						<aui:input name="languageId" type="hidden" id="languageId" />
						<div class="form-inline">
							<label>Language Name: </label>
							<input name="<portlet:namespace/>language_name" id="languageName" type="text">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="languagecancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>


<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/language/add.jsp");
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
DynamicQuery languageDynamicQuery = DynamicQueryFactoryUtil
.forClass(Language.class,
		PortletClassLoaderUtil.getClassLoader());
languageDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<Language> languageDetails = LanguageLocalServiceUtil.dynamicQuery(languageDynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Language> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for Languages"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
            List<Language> languageList = ListUtil.subList(languageDetails, searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getLanguagesOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(languageList,orderByComparator);
  				if(languageDetails.size()>5){
  					results = languageList;
  				}
  				else{
               results = languageDetails;
  				}
               total = languageDetails.size();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Language"
		keyProperty="languageId" modelVar="languageId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="name" property="languageName"
			orderableProperty="languageName" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/language/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>


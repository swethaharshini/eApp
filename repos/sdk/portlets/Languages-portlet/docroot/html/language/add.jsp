<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/language/init.jsp"%>

<portlet:actionURL var="saveLanguages" name="saveLanguage">
</portlet:actionURL>
<portlet:resourceURL var="deleteLanguages" id="deleteLanguage"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/language/add.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
 #addLanguageMessage{
 color: red;
}
</style>
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
                     
      }
    );
  }
);

 AUI().ready('event', 'node','transition',function(A){
  A.one('#addLanguageForm').hide();
  setTimeout(function(){
    A.one('#addLanguageMessage').transition('fadeOut');
},1000)
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
</head>

<body>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"languageName-empty-error")){%>
<p id="addLanguageMessage"><liferay-ui:message key="Please Enter LanguageName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"languageName-duplicate-error")){
%>
<p id="addLanguageMessage"><liferay-ui:message key="LanguageName already Exits"/></p>
<%} 
%>

  <div class="row-fluid">
		<div id="languageAddDelete" class="span12 text-right">
			<a href="#" class="btn btn-primary" id="languageadd"><i class="icon-plus"></i></a>
			<a href="#" class="btn btn-danger" id="languagedelete"><i class="icon-trash"></i></a>
		</div>
		<div  id="addLanguageForm">
		<aui:form name="myForm" action="<%=saveLanguages.toString()%>" >
			<aui:input name="languageId" type="hidden" id="languageId" />
			<div class="form-inline">
				<label>Language Name: </label>
				<input name="<portlet:namespace/>language_name" type="text">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i></button>
				<button  type="reset" id ="languagecancel" class="btn btn-danger"><i class="icon-remove"></i></button>
			</div>
		</aui:form>
		</div>
	</div>
	
</body>

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
            List<Language> languageList = LanguageLocalServiceUtil.getLanguages(searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getLanguagesOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(languageList,orderByComparator);
  
               results = languageList;
               total = LanguageLocalServiceUtil.getLanguagesCount();
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


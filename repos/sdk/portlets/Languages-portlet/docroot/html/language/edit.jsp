<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/language/init.jsp" %>
<portlet:actionURL var="updateLanguages" name="updateLanguage">
</portlet:actionURL>
<portlet:resourceURL var="deleteLanguages" id="deleteLanguage"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/language/add.jsp" />
</portlet:renderURL>
<style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
</style>
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
</aui:script><aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#editLanguageAddDelete').hide();
         A.one('#editLanguageForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editLanguageAddDelete').hide();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editCancel');
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
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"languageName-empty-error")){%>
<liferay-ui:message key="Please Enter LanguageName"/>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"languageName-duplicate-error")){
%>
<liferay-ui:message key="LanguageName already Exits"/>
<%} 
%>
<% 
 Language editLanguage = (Language)portletSession.getAttribute("editLanguage");
%>
 <br/><br/>
	<div id="editLanguageForm">
  <aui:form name="myForm" action="<%=updateLanguages.toString()%>">
		<aui:input name="languageId" type="hidden" id="languageId"  value="<%=editLanguage.getLanguageId()%>"/>
			 	<div class="span12">
			<div class="span2">
				<label>Name</label>
		</div>
		<div class="span3">		
		 <aui:input name="language_name" label="" type="text" value="<%=editLanguage.getLanguageName() %>" />
			</div>
			</div>
	<br/>
	<aui:button type="submit" value="Submit"/> <aui:button  type="reset" value="Cancel" id ="editCancel"></aui:button><input type="button" value="Delete" class="btn" id="delete">
	</aui:form>
	</div>
	 <div><label style="color: white" >.</label></div>
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/language/edit.jsp");
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
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<Language> listOfLanguages = LanguageLocalServiceUtil.getLanguages(searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getLanguagesOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(listOfLanguages,orderByComparator);
  
          results = listOfLanguages;
          
           
     
               total = LanguageLocalServiceUtil.getLanguagesCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Language" keyProperty="languageId" modelVar="languageId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="languageName" orderableProperty="languageName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/language/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>






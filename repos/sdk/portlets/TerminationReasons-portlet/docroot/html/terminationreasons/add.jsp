<%@ include file="/html/terminationreasons/init.jsp"%>

<portlet:actionURL var="saveterminationreasons" name="saveTerminationReasons">
</portlet:actionURL>
<portlet:resourceURL var="deleteterminationreasons" id="deleteTerminationReasons"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/terminationreasons/add.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
 #addTerminationReasonMessage{
 color: red;
}
.aui input[type="text"]{
border-radius: 4px;
}
</style>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#terminationreasondelete');
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
			  var d = confirm("Are you sure you want to delete the selected TerminationReasons ?");
		  if(d){
		   var url = '<%=deleteterminationreasons%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />terminationreasonsIds: idArray,  
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
    var node = A.one('#terminationreasonadd');
    node.on(
      'click',
      function() {
         A.one('#terminationreasonsAddDelete').hide();
         A.one('#addterminationreasonsForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
  A.one('#addterminationreasonsForm').hide();
  setTimeout(function(){
    A.one('#addTerminationReasonMessage').transition('fadeOut');
},1000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#terminationreasoncancel');
    node.on(
      'click',
      function() {
         A.one('#terminationreasonsAddDelete').show();
         A.one('#addterminationreasonsForm').hide();
                     
      }
    );
  }
);

</aui:script>
</head>

<body>

 <% if(SessionMessages.contains(renderRequest.getPortletSession(),"termination-form-error")){%>
<p id="addTerminationReasonMessage"><liferay-ui:message key="Please Enter TerminationReason"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"termination-form-duplicate-error")){
%>
<p id="addTerminationReasonMessage"><liferay-ui:message key="TerminationName already Exits"/></p>
<%} 
%>
		<div class="row-fluid">
		<div id="terminationreasonsAddDelete" class="span12 text-right">
			<a href="#" class="btn btn-primary" id="terminationreasonadd"><i class="icon-plus"></i>Add</a>
			<a href="#" class="btn btn-danger" id="terminationreasondelete"><i class="icon-trash"></i>Delete</a>
		</div>
		<div  id="addterminationreasonsForm">
		<aui:form name="myForm" action="<%=saveterminationreasons.toString()%>" >
			<aui:input name="terminationreasonsId" type="hidden" id="terminationreasonsId" />
			<div class="form-inline">
				<label>TerminationReason Name: </label>
				<input name="<portlet:namespace/>terminationreasonsName" type="text">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i>Submit</button>
				<button  type="reset" id ="terminationreasoncancel" class="btn btn-danger"><i class="icon-remove"></i>Cancel</button>
			</div>
		</aui:form>
		</div>
	</div>
		
		
</body>

 <%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/terminationreasons/add.jsp");
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
long groupID=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.
forClass(TerminationReasons.class, PortletClassLoaderUtil.getClassLoader());
dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupID));
List<TerminationReasons> terminationReasonsList=TerminationReasonsLocalServiceUtil
.dynamicQuery(dynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<TerminationReasons> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for TerminationReasons"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
		OrderByComparator orderByComparator =  CustomComparatorUtil.getterminationreasonsOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(terminationReasonsList,orderByComparator);
  
               results = ListUtil.subList(terminationReasonsList, searchContainer.getStart(), 
            		   searchContainer.getEnd());
               total = terminationReasonsList!=null && terminationReasonsList.size()!=0?
            		   terminationReasonsList.size():0;
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="TerminationReasons"
		keyProperty="terminationreasonsId" modelVar="terminationreasonsId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="Name" property="terminationreasonsName"
			orderableProperty="terminationreasonsName" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/terminationreasons/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container> 
</div>


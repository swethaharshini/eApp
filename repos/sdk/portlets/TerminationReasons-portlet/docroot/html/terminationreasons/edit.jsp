<%@ include file="/html/terminationreasons/init.jsp" %>
<portlet:actionURL var="updateterminationreasons" name="updateTerminationReasons">
</portlet:actionURL>
<portlet:resourceURL var="deleteterminationreasons" id="deleteTerminationReasons"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/terminationreasons/add.jsp" />
</portlet:renderURL>
<style type="text/css">	
.table-first-header{
width: 10%;
}
 #editTerminationReasonMessage{
 color: red;
}
.table-last-header{
width: 15%;
}
.aui input[type="text"]{
border-radius: 4px;
}
</style>
<aui:script>

AUI().ready('event', 'node','transition',function(A){

  A.one('#terminationreasonsName').focus();
  setTimeout(function(){
    A.one('#editTerminationReasonMessage').transition('fadeOut');
    A.one('#editTerminationReasonMessage').hide();
},2000)

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editterminationreasoncancel');
    node.on(
      'click',
      function() {
      	 window.location='<%=listview%>';
          
      }
    );																																
  }
);
 });
</aui:script>

 <% 
   TerminationReasons editTerminationReasons = (TerminationReasons) portletSession.getAttribute("editTerminationReasons");
 if(SessionMessages.contains(renderRequest.getPortletSession(),"termination-form-error")){%>
<p id="editTerminationReasonMessage" class="alert alert-error"><liferay-ui:message key="Please Enter TerminationReason"/></p>
<%} 
 
%>

	<div class="row-fluid">
		
		<div  id="addterminationreasonsForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Edit</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=updateterminationreasons.toString()%>" >
						<aui:input name="terminationreasonsId" type="hidden" id="terminationreasonsId" value="<%=editTerminationReasons.getTerminationreasonsId()%>"/>
						<div class="form-inline">
							<label>TerminationReason Name: </label>
							<input name="<portlet:namespace/>terminationreasonsName" id="terminationreasonsName" type="text" value="<%=editTerminationReasons.getTerminationreasonsName() %>">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="editterminationreasoncancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
	
	
	
	

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/terminationreasons/edit.jsp");
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
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for ReportingMethods"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
		
		 List<TerminationReasons> pageList = ListUtil.subList(terminationReasonsList, searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getterminationreasonsOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(pageList,orderByComparator);
               
               if(terminationReasonsList.size()>5){
  
               results = ListUtil.subList(terminationReasonsList, searchContainer.getStart(), 
            		   searchContainer.getEnd());
               }
               else{
            	   results = terminationReasonsList;
               }
               total = terminationReasonsList.size();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
		
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="TerminationReasons" keyProperty="terminationreasonsId" modelVar="terminationreasonsId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Name" property="terminationreasonsName" orderableProperty="terminationreasonsName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/terminationreasons/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>






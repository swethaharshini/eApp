<%@page import="org.apache.log4j.Logger"%>
<%@ include file="/html/employmentstatus/init.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddEmploymentstatus</title>
<portlet:actionURL var="saveemploymentstatus" name="saveEmploymentStatus">
</portlet:actionURL>
<portlet:resourceURL var="deleteemploymentstatus" id="deleteEmploymentStatus"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/employmentstatus/addemploymentstatus.jsp" />
</portlet:renderURL>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#deleteemploymentstatus');
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
			  var d = confirm("Are you sure you want to delete the selected Employment Status ?");
		  if(d){
		   var url = '<%=deleteemploymentstatus%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />employmentstatusIds: idArray,  
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
    var node = A.one('#addemploymentstatus');
    node.on(
      'click',
      function() {
         A.one('#employmentstatusadddelete').hide();
         A.one('#addEmploymentstatusForm').show();
         A.one('#employmentstatus').focus();
                     
      }
    );
  }
);

  AUI().ready('event', 'node','transition',function(A){
  A.one('#addEmploymentstatusForm').hide();
  setTimeout(function(){
    A.one('#addEmploymentStatusMessage').transition('fadeOut');
    A.one('#addEmploymentStatusMessage').hide();
},2000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancelemploymentstatus');
    node.on(
      'click',
      function() {
         A.one('#employmentstatusadddelete').show();
         A.one('#addEmploymentstatusForm').hide();
                     
      }
    );
  }
);

</aui:script>
<% Logger log=Logger.getLogger(this.getClass().getName());%>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"employmentStatus-empty-error")){%>
<p id="addEmploymentStatusMessage" class="alert alert-error"><liferay-ui:message key="Please Enter EmploymentStatus"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"employmentStatus-duplicate-error")){
%>
<p id="addEmploymentStatusMessage" class="alert alert-error"><liferay-ui:message key="EmploymentStatus already Exits"/></p>
<%} 
%>

		<div id="employmentstatusadddelete" class="control-group text-right">
			<a href="#" class="btn btn-primary" id="addemploymentstatus"><i class="icon-plus"></i> Add</a>
			<a href="#" class="btn btn-danger" id="deleteemploymentstatus"><i class="icon-trash"></i> Delete</a>
		</div>
		<div  id="addEmploymentstatusForm" class="panel">
			<div class="panel-heading">
				<h4>Add</h4>
			</div>
			<div class="panel-body">
				<aui:form name="myemploymentstatusForm" action="<%=saveemploymentstatus.toString()%>" >
					<aui:input name="employmentstatusId" type="hidden" id="employmentstatusId" />
					<div class="form-inline">
						<label>Employment Status: </label>
						<input name="<portlet:namespace/>employmentstatus" id="employmentstatus" type="text">
						<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
						<button  type="reset" id ="cancelemploymentstatus" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
					</div>
				</aui:form>
			</div>
		</div>



<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/employmentstatus/addemploymentstatus.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	log.info("if block...");
 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}

log.info("after....");
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery empStatusDynamicQuery = DynamicQueryFactoryUtil
.forClass(EmploymentStatus.class,
		PortletClassLoaderUtil.getClassLoader());
empStatusDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<EmploymentStatus> empDetails = EmploymentStatusLocalServiceUtil
.dynamicQuery(empStatusDynamicQuery);

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<EmploymentStatus> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records is available for Employment Status."
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<% 
		 System.out.println("addemployee jsp =========");
            List<EmploymentStatus> employmentstatusList =ListUtil.subList(empDetails, searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getEmploymentStatusrOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(employmentstatusList,orderByComparator);
  			if(empDetails.size()>5)
  			{
          results = employmentstatusList;
  			}
  			else{
  				results = empDetails;
  			}
          log.info("results == " +results);
               total = empDetails.size();
               System.out.println("total == " +total);
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="EmploymentStatus"
		keyProperty="employmentStatusId" modelVar="EmploymentStatus" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="Employment Status" property="employmentstatus"
			orderableProperty="employmentstatus" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/employmentstatus/edit.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>

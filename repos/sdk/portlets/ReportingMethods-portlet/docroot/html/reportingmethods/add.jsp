<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.rknowsys.eapp.hrm.service.ReportingMethodsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.ReportingMethods"%>
<%@ include file="/html/reportingmethods/init.jsp"%>

<portlet:actionURL var="savereportingmethod" name="saveReportingMethod">
</portlet:actionURL>
<portlet:resourceURL var="deletereportingmethod" id="deleteReportingMethod"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/reportingmethods/add.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
.aui input[type="text"]{
border-radius: 4px;
}
 #addReportingMethodMessage{
 color: red;
}
</style>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#reportingmethoddelete');
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
			  var d = confirm("Are you sure you want to delete the selected ReportingMethod ?");
		  if(d){
		   var url = '<%=deletereportingmethod%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />reportingmethodIds: idArray,  
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
    var node = A.one('#reportingmethodadd');
    node.on(
      'click',
      function() {
         A.one('#reportingmethodAddDelete').hide();
         A.one('#addReportingMethodForm').show();
         A.one('#reportingmethodName').focus();
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
  A.one('#addReportingMethodForm').hide();
  setTimeout(function(){
    A.one('#addReportingMethodMessage').transition('fadeOut');
    A.one('#addReportingMethodMessage').hide();
},2000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#reportingmethodcancel');
    node.on(
      'click',
      function() {
         A.one('#reportingmethodAddDelete').show();
         A.one('#addReportingMethodForm').hide();
                     
      }
    );
  }
);

</aui:script>

 <% if(SessionMessages.contains(renderRequest.getPortletSession(),"reportingmethodName-empty-error")){%>
<p id="addReportingMethodMessage" class="alert alert-error"><liferay-ui:message key="Please Enter ReportingmethodName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"reportingmethodName-duplicate-error")){
%>
<p id="addReportingMethodMessage" class="alert alert-error"><liferay-ui:message key="ReportingmethodName already Exits"/></p>
<%} 
%>
   
	
	
	<div class="row-fluid">
		<div id="reportingmethodAddDelete" class="span12 text-right">
			<div class="control-group">
				<a href="#" class="btn btn-primary" id="reportingmethodadd"><i class="icon-plus"></i> Add</a>
				<a href="#" class="btn btn-danger" id="reportingmethoddelete"><i class="icon-trash"></i> Delete</a>
			</div>
		</div>
		<div  id="addReportingMethodForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Add</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=savereportingmethod.toString()%>" >
						<aui:input name="reportingmethodId" type="hidden" id="reportingmethodId" />
						<div class="form-inline">
							<label>ReportingMethod Name: </label>
							<input name="<portlet:namespace/>reportingmethodName" id="reportingmethodName" type="text">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="reportingmethodcancel" class="btn btn-danger"><i class="icon-remove"> Cancel</i></button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>


<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/reportingmethods/add.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<ReportingMethods> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for ReportingMethods"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
		  
		long groupId = themeDisplay.getLayout().getGroup().getGroupId();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ReportingMethods.class,PortletClassLoaderUtil.getClassLoader());

		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));  
		
            List<ReportingMethods> reportingMethodsList = ReportingMethodsLocalServiceUtil.dynamicQuery(dynamicQuery);
            
            List<ReportingMethods> pageList = ListUtil.subList(reportingMethodsList, searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getReportingMethodsOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(pageList,orderByComparator);
  				if(reportingMethodsList.size()>5){
  					results = ListUtil.subList(reportingMethodsList,searchContainer.getStart(), searchContainer.getEnd());
  				}
  				else{
               results = reportingMethodsList;
  				}
               total = reportingMethodsList.size();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="ReportingMethods"
		keyProperty="reportingmethodId" modelVar="reportingmethodId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="ReportingMethod" property="reportingmethodName"
			orderableProperty="reportingmethodName" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/reportingmethods/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>


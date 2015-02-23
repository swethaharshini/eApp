<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.rknowsys.eapp.hrm.service.ReportingMethodsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.ReportingMethods"%>
<%@ include file="/html/reportingmethods/init.jsp" %>
<portlet:actionURL var="updatereportingmethod" name="updateReportingMethod">
</portlet:actionURL>
<portlet:resourceURL var="deletereportingmethod" id="deleteReportingMethod"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/reportingmethods/add.jsp" />
</portlet:renderURL>
<style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
.aui input[type="text"]{
border-radius: 4px;
}
 #editReportingMethodMessage{
 color: red;
}
</style>
<aui:script>

AUI().ready('event', 'node','transition',function(A){
 A.one('#reportingmethodName').focus();
  setTimeout(function(){
    A.one('#editReportingMethodMessage').transition('fadeOut');
    A.one('#editReportingMethodMessage').hide();
},2000)
 });
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editreportingmethodcancel');
    node.on(
      'click',
      function() {
      	 window.location='<%=listview%>';
          
      }
    );																																
  }
);

</aui:script>

<% 
 ReportingMethods editReportingMethod =(ReportingMethods) portletSession.getAttribute("editReportingMethod");
if(SessionMessages.contains(renderRequest.getPortletSession(),"reportingmethodName-empty-error")){%>
<p id="editReportingMethodMessage" class="alert alert-error"><liferay-ui:message key="Please Enter ReportingmethodName"/></p>
<%} 
%>
	<div class="row-fluid">
		<div  id="editReportingMethodForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Edit</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=updatereportingmethod.toString()%>" >
						<aui:input name="reportingmethodId" type="hidden" id="reportingmethodId" value="<%=editReportingMethod.getReportingmethodId()%>"/>
						<div class="form-inline">
							<label>ReportingMethod Name: </label>
							<input name="<portlet:namespace/>reportingmethodName" id="reportingmethodName" type="text" value="<%=editReportingMethod.getReportingmethodName() %>">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="editreportingmethodcancel" class="btn btn-danger"><i class="icon-remove"> Cancel</i></button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/reportingmethods/edit.jsp");
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
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for ReportingMethods"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
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
	<liferay-ui:search-container-row className="ReportingMethods" keyProperty="reportingmethodId" modelVar="reportingmethodId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="ReportingMethod" property="reportingmethodName" orderableProperty="reportingmethodName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/reportingmethods/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>







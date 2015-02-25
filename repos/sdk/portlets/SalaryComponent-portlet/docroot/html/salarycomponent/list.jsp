<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.rknowsys.eapp.hrm.service.SalaryComponentLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.SalaryComponent"%>
<%@page import="com.rknowsys.eapp.CustomComparatorUtil"%>
<%@ include file="/html/salarycomponent/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salary Component</title>
<portlet:actionURL var="savesalarycomponent" name="saveSalaryComponent">
</portlet:actionURL>
<portlet:renderURL var="addcomponent">
	<portlet:param name="mvcPath" value="/html/salarycomponent/addsalarycomponent.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="deletesalarycomponent" id="deleteSalaryComponent"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/salarycomponent/list.jsp" />
</portlet:renderURL>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delete');
    node.on(
      'click',
      function() {
     var salidArray = [];
     A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      salidArray.push(object.get("value"));
    
        });
       if(salidArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected salary component ?");
		  if(d){
		   var url = '<%=deletesalarycomponent%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />salarycomponentIds: salidArray,  
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
		  																		
		  console.log(salidArray);
	  
      return true;
  }
  else
    return false;
}             
      }
    );
  }
);
AUI().ready('event', 'node','transition',function(A){
  setTimeout(function(){
    A.one('#addsalarycomponentMessage').transition('fadeOut');
    A.one('#addsalarycomponentMessage').hide();
},2000)
 });
</aui:script>
<% Logger log=Logger.getLogger(this.getClass().getName());%>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"salarycomponentName-empty-error")){%>
<p id="addsalarycomponentMessage" class="alert alert-error"><liferay-ui:message key="Please Enter SalarycomponentName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"salarycomponentName-duplicate-error")){
%>
<p id="addsalarycomponentMessage" class="alert alert-error"><liferay-ui:message key="SalarycomponentName already Exits"/></p>
<%} 
%>

<div class="control-group text-right">
	<a href="<%=addcomponent%>" class="btn btn-primary"><i class="icon-plus"></i> Add</a>
	<a href="#" id="delete" class="btn btn-danger"><i class="icon-trash"></i> Delete</a>
</div>
<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/salarycomponent/list.jsp");
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

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<SalaryComponent> searchContainer;
%>

<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records is available for SalaryComponent"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
	<%
	long groupId =  themeDisplay.getLayout().getGroup().getGroupId();
	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SalaryComponent.class,PortletClassLoaderUtil.getClassLoader());

	dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));

	List<SalaryComponent> salarycomponentlist = SalaryComponentLocalServiceUtil.dynamicQuery(dynamicQuery);
            log.info("list size == " +salarycomponentlist.size());
            List<SalaryComponent> pageList = ListUtil.subList(salarycomponentlist, searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getSalaryComponentOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(pageList,orderByComparator);
  		if(salarycomponentlist.size()>5){
  			
  			results =ListUtil.subList(salarycomponentlist,searchContainer.getStart(),searchContainer.getEnd());
  		}
  		else{
          results = salarycomponentlist;
  		}
            log.info("results == " +results);
           
     
               total = salarycomponentlist.size();
               log.info("total == " +total);
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="SalaryComponent"
		keyProperty="salaryComponentId" modelVar="SalaryComponent" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="Component Name" property="componentName"
			orderableProperty="componentName" /> 
		<liferay-ui:search-container-column-text orderable="<%=true %>" name="Type" property="type" orderableProperty="type"/>
		<liferay-ui:search-container-column-text orderable="<%=true %>" name="Total Payable" property="totalPayable" orderableProperty="totalPayable"/>
		<liferay-ui:search-container-column-text orderable="<%=true %>" name="Cost To Company" property="costToCompany" orderableProperty="costToCompany"/>
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/salarycomponent/edit.jsp" />
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
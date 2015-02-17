<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Nationality"%>
<%@ include file="/html/nationality/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<portlet:actionURL var="savenationality" name="saveNationality">
</portlet:actionURL>
<portlet:resourceURL var="deletenationality" id="deleteNationality"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/nationality/addnationality.jsp" />
</portlet:renderURL>
<aui:script>
AUI().ready('event', 'node','transition',function(A){
A.one('#nationalityName').focus();
  setTimeout(function(){
    A.one('#editNationalityMessage').transition('fadeOut');
},2000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editnationalitycancel');
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
 Nationality editnationality = (Nationality)portletSession.getAttribute("editnationality"); 

if(SessionMessages.contains(renderRequest.getPortletSession(),"nationalityName-empty-error")){%>
<p id="editNationalityMessage" class="alert alert-error"><liferay-ui:message key="Please Enter Nationality Name"/></p>
<%} 
%>

		<div  id="editNationalityForm" class="panel">
			<div class="panel-heading">
				<h4>Edit</h4>
			</div>
			<div class="panel-body">
				<aui:form name="myForm" action="<%=savenationality.toString()%>" >
					<aui:input name="nationalityId" type="hidden" id="nationalityId" value="<%=editnationality.getNationalityId()%>"/>
					<div class="form-inline">
						<label>Nationality: </label>
						<input name="<portlet:namespace/>nationalityName" id="nationalityName" type="text" value="<%=editnationality.getName()%>">
						<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
						<button  type="reset" id ="editnationalitycancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
					</div>
				</aui:form>
			</div>
		</div>


<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/nationality/editnationality.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
System.out.println("sortByCol == " +sortByCol);
System.out.println("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	System.out.println("if block...");
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}
System.out.println("after....");
System.out.println("sortByCol == " +sortByCol);
System.out.println("sortByType == " +sortByType);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Nationality> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Nationality"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
		 long groupId = themeDisplay.getLayout().getGroup().getGroupId();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Nationality.class,PortletClassLoaderUtil.getClassLoader());

		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));

		List<Nationality> nationalityList =  NationalityLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		List<Nationality> pageList = ListUtil.subList(nationalityList, searchContainer.getStart(), searchContainer.getEnd());
        OrderByComparator orderByComparator = CustomComparatorUtil.getNationalityOrderByComparator(sortByCol, sortByType);         

       Collections.sort(pageList,orderByComparator);
			if(nationalityList.size()>5)
			{
				results = ListUtil.subList(nationalityList, searchContainer.getStart(), searchContainer.getEnd());
			}
			else{
				
				 results = nationalityList;
				
			}
          
           total = nationalityList.size();
           
           pageContext.setAttribute("results", results);
           pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Nationality" keyProperty="nationalityId" modelVar="Nationality"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Nationality" property="name" orderableProperty="nationality"/>
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/nationality/edit.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>

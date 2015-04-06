<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/Interview/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>interview</title>
<portlet:actionURL var="saveinterview" name="saveInterview">
</portlet:actionURL>
<portlet:resourceURL var="deleteinterview" id="deleteInterview"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/Interview/add.jsp" />
</portlet:renderURL>
<aui:script>
AUI().ready('event', 'node',function(A){
A.one('#editinterview').focus();
});
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editinterviewcancel');
    node.on(
      'click',
      function() {
      	 window.location='<%=listview%>';
      	
          
      }
    );																																
  }
);

</aui:script>
<% Logger log=Logger.getLogger(this.getClass().getName());%>
<%
Interview editinterview = (Interview) portletSession.getAttribute("editinterview");

%>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"interviewName-empty-error")){%>
<p id="editInterviewMessage" class="alert alert-error"><liferay-ui:message key="Please Enter InterviewName"/></p>
<%}
%>
<div  id="editInterviewForm" class="panel">
	<div class="panel-heading">
		<h4>Edit</h4>
	</div>
	<div class="panel-body">
		<aui:form name="myForm" action="<%=saveinterview.toString()%>" >
			<aui:input name="interviewId" type="hidden" id="interviewId" value="<%=editinterview.getInterviewId()%>"/>
			<div class="form-inline">
				<label>Interview Name: </label>
				<input name="<portlet:namespace/>name" id="editinterview" type="text" value="<%=editinterview.getName()%>">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
				<button type="reset" id ="editinterviewcancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
			</div>
		</aui:form>
	</div>
</div>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/Interview/edit.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	log.info("if block...edit.jsp");
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}
log.info("after....");
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery interviewDynamicQuery = DynamicQueryFactoryUtil
.forClass(Interview.class,
		PortletClassLoaderUtil.getClassLoader());
interviewDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<Interview> interviewDetails = InterviewLocalServiceUtil
.dynamicQuery(interviewDynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Interview> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Interview"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%

		List<Interview> interviewList = ListUtil.subList(interviewDetails, searchContainer.getStart(), searchContainer.getEnd())  ;
        OrderByComparator orderByComparator = CustomComparatorUtil.getInterviewrOrderByComparator(sortByCol, sortByType);         

       Collections.sort(interviewList,orderByComparator);
				
       if(interviewDetails.size()>5){
       results = ListUtil.subList(interviewDetails, searchContainer.getStart(), searchContainer.getEnd());
       }
       else{
    	   results = interviewDetails;
       }
        System.out.println("results == " +results);
       
 
           total = interviewDetails.size();
           System.out.println("total == " +total);
           pageContext.setAttribute("results", results);
           pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Interview" keyProperty="interviewId" modelVar="Interview"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Interview" property="name" orderableProperty="interview"/>
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/Interview/editclick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>

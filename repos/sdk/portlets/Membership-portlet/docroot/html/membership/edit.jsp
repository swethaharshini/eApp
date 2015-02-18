<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ include file="/html/membership/init.jsp" %>
<portlet:actionURL var="updateMemberships" name="updateMembership">
</portlet:actionURL>
<portlet:resourceURL var="deleteMemberships" id="deleteMembership"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/membership/add.jsp" />
</portlet:renderURL>
<aui:script>

AUI().ready('event', 'node','transition',function(A){
 A.one('#membershipName').focus();
  setTimeout(function(){
  A.one('#membershipName').focus();
    A.one('#editMembershipMessage').transition('fadeOut');
    A.one('#editMembershipMessage').hide();
},2000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editmembershipcancel');
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
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"membershipName-empty-error")){%>
<p id="editMembershipMessage" class="alert error-alert"><liferay-ui:message key="Please Enter MembershipName"/></p>
<%}
%>
<%
Membership editMembership =(Membership) portletSession.getAttribute("editMembership");

%> 
		<div  id="editMembershipForm" class="panel">
			<div class="panel-heading">
				<h4>Edit</h4>
			</div>
			<div class="panel-body">
				<aui:form name="myForm" action="<%=updateMemberships.toString()%>" >
					<aui:input name="membershipId" type="hidden" id="membershipId" value="<%=editMembership.getMembershipId() %>"/>
					<div class="form-inline">
						<label>Membership Name: </label>
						<input name="<portlet:namespace/>membership_name" id="membershipName" type="text" value="<%=editMembership.getMembershipName() %>">
						<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
						<button  type="reset" id ="editmembershipcancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
					</div>
				</aui:form>
			</div>
		</div>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/membership/edit.jsp");
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
long groupId= themeDisplay.getLayout().getGroup().getGroupId();
log.info("groupId == "+groupId);
DynamicQuery membershipQuery = DynamicQueryFactoryUtil.forClass(Membership.class,PortletClassLoaderUtil.getClassLoader());

membershipQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Membership> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Memberships"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<Membership> membershipList = MembershipLocalServiceUtil.dynamicQuery(membershipQuery);
            List<Membership> pageList = ListUtil.subList(membershipList, searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getMembershipOrderByComparator(sortByCol, sortByType);
   
               Collections.sort(pageList,orderByComparator);
               
               if(membershipList.size()>5){
            	   
            	   results = ListUtil.subList(membershipList, searchContainer.getStart(), searchContainer.getEnd());
            	   
               }
               else{
            	   results = membershipList;
               }
               
               total = membershipList.size();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Membership" keyProperty="membershipId" modelVar="membershipId"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="membershipName" orderableProperty="membershipName"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/membership/editClick.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>







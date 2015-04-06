<%@page import="org.apache.log4j.Logger"%>
<%@ include file="/html/jobtitle/init.jsp"%>
<portlet:actionURL var="savejobtitle" name="saveJobtitle">
</portlet:actionURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/jobtitle/add.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="deletejobtitle" id="deleteJobtitle"></portlet:resourceURL>

<aui:script>

AUI().ready('event', 'node', function(A){

  A.one('#<portlet:namespace/>jobtitlename').focus();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#jobtitlecancel');
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
Logger log=Logger.getLogger(this.getClass().getName());
JobTitle jobtitle = (JobTitle) portletSession.getAttribute("editjobtitle");


%> 


  <% if(SessionMessages.contains(renderRequest.getPortletSession(),"jobtitleName-empty-error")){%>
<p id="addJobMessage" class="alert alert-error"><liferay-ui:message key="Please Enter JobtitleName"/></p>
<%}
%>
<div class="row-fluid">
	
	<div  id="editJobForm">
		<div class="panel">
			<div class="panel-heading">
				<h4>Edit</h4>
			</div>
			<div class="panel-body">
				<aui:form action="<%=savejobtitle%>">
					<div class="form-horizontal">
						<input class="jobtitleId" type="hidden" id="jobtitleId"	name='<portlet:namespace/>jobtitleId' value="<%=jobtitle.getJobTitleId() %>">
						<label class="control-label">Job Title<em>*</em></label>
						<aui:input type="text" label="" name="title" maxlength="100" id="jobtitlename" value="<%=jobtitle.getTitle()%>"/>
						<aui:input type="textarea" label="Job Description" rows="4" cols="30" name="description" maxlength="400" id="description" value="<%=jobtitle.getDescription()%>"></aui:input>
						<aui:input type="textarea" label="Note" rows="4" cols="30" name="notes" id="notes" value="<%=jobtitle.getNotes()%>"></aui:input>
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
								<button type="reset" id ="jobtitlecancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
							</div>
						</div>
					</div>	
				</aui:form>
				<div><em>*</em> Required Field</div>
			</div>
		</div>
	</div>
</div>	
<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/jobtitle/edit.jsp");
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
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery jobTitleDynamicQuery = DynamicQueryFactoryUtil
.forClass(JobTitle.class,
		PortletClassLoaderUtil.getClassLoader());
jobTitleDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<JobTitle> jobTitleDetails = JobTitleLocalServiceUtil
.dynamicQuery(jobTitleDynamicQuery);
log.info("after....");
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<JobTitle> searchContainer;
%>

 <liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>"  delta="5" emptyResultsMessage="No records is available for Job Title" rowChecker="<%= new RowChecker(renderResponse) %>"  deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
		  List<JobTitle> jobtitleList = ListUtil.subList(jobTitleDetails, searchContainer.getStart(), searchContainer.getEnd());
        OrderByComparator orderByComparator = CustomComparatorUtil.getJobtitleOrderByComparator(sortByCol, sortByType);         

       Collections.sort(jobtitleList,orderByComparator);
			if(jobTitleDetails.size()>5){
      results = ListUtil.subList(jobTitleDetails, searchContainer.getStart(), searchContainer.getEnd());
			}
			else{
				results = jobTitleDetails;
			}
        log.info("results == " +results);
       
 
           total = jobTitleDetails.size();
           log.info("total == " +total);
           pageContext.setAttribute("results", results);
           pageContext.setAttribute("total", total);
 %>
		
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="JobTitle" keyProperty="jobTitleId" modelVar="JobTitle"  rowVar="curRow" escapedModel="<%= true %>">
	     
	      <liferay-ui:search-container-column-text orderable="true" name="Job Title" property="title" orderableProperty="title"/>
		<liferay-ui:search-container-column-text orderable="true" name="Description" property="description" orderableProperty="description"/>
		<liferay-ui:search-container-column-text orderable="true" name="Notes" property="notes" orderableProperty="notes"/>
		<liferay-ui:search-container-column-jsp name="Edit"  path="/html/jobtitle/editclick.jsp"/>
		
	     
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container> 

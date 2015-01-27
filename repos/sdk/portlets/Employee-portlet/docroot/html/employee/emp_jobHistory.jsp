<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateEmpJobHistory" var="updateEmpJobHistory">
</portlet:actionURL>

<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	long empLocationId=EmployeeLocalServiceUtil.getEmployee(employeeId).getLocationId();
	String jsp = (String) empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
DynamicQuery jobDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpJob.class,
					PortletClassLoaderUtil.getClassLoader());
	jobDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpJob> empJob =EmpJobLocalServiceUtil
			.dynamicQuery(jobDynamicQuery);
%>
<%!
public String getJobTitleValue(long jobTId) {
	if(jobTId!=0)
	{
	JobTitle jobT = null;
	try {
		jobT = JobTitleLocalServiceUtil.getJobTitle(jobTId);
		return jobT.getTitle();
	} catch (Exception p) {
	}
	}
	return "";
}
public String getSubUnitValue(long suId)
{	
	if(suId!=0)
	{
	SubUnit subUt = null;
	try {
		subUt = SubUnitLocalServiceUtil.getSubUnit(suId);
	} catch (Exception p) {
	}
	return subUt.getName();
	}
	else
	{
		return "";
	}
}
public String getEmpStatusValue(long empStId)
{	if(empStId!=0)
	{
	EmploymentStatus empStatus = null;
	try {
		empStatus = EmploymentStatusLocalServiceUtil.getEmploymentStatus(empStId);
	} catch (Exception p) {
	}
	return empStatus.getEmploymentstatus();
	}
	else
	{
		return "";
	}
}
public String getShiftValue(long shId)
{	
	if(shId!=0)
	{
	Workshift ws = null;
	try {
		ws = WorkshiftLocalServiceUtil.getWorkshift(shId);
	} catch (Exception p) {
	}
	return ws.getWorkshiftName();
	}
	else
	{
		return "";
	}
}
public String getLocationValue(long lId)
{	
	if(lId!=0)
	{
	Region loc = null;
	try {
		loc = RegionServiceUtil.getRegion(lId);
	} catch (Exception p) {
	}
	if(loc==null)
		return "";
	return loc.getName();
	}
	else
	{
		return "";
	}
}
public String getCategoryValue(long jcId)
{	
	if(jcId!=0)
	{
	JobCategory jc = null;
	try {
		jc = JobCategoryLocalServiceUtil.getJobCategory(jcId);
	} catch (Exception p) {
	}
	if(jc==null)
		return "";
	return jc.getJobcategory();
	}
	else
	{
		return "";
	}
}

%>
<div class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_job"/></h3>
	</div>
	<div class="panel-body">
		<aui:form name="jobHistoryDetails" id="jobHistoryDetails"
			method="post" action="<%=updateEmpJobHistory %>">
			<div class="form-horizontal">
				<aui:input name="empJId" value="<%=employeeId %>" type="hidden"></aui:input>
				<aui:input name="jobFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:input name="joined_date" id="joined_date" label="01_joined-date"
					cssClass="dateEmployee" inlineLabel="left" type="date"></aui:input>
				<aui:input name="probation_date" label="01_probation-date"
					cssClass="dateEmployee" inlineLabel="left" placeholder="DD/MM/YYYY"></aui:input>
				<aui:input name="date_permanency" label="01_date-of-permanency"
					cssClass="dateEmployee" inlineLabel="left" placeholder="DD/MM/YYYY" ></aui:input>
				<aui:select name="emp_job_title" label="01_jobtitle">
				<%
				List<JobTitle> jobTitle = JobTitleLocalServiceUtil
								.getJobTitles(-1, -1);
						{
							Iterator<JobTitle> jobTitles = jobTitle.iterator();
							while (jobTitles.hasNext()) {
								JobTitle empjobTitle = jobTitles.next();
				%>
				<aui:option value="<%=empjobTitle.getJobTitleId()%>"
				label="<%=empjobTitle.getTitle()%>"></aui:option>
				<%
				}
						}
				%>
				</aui:select>
				<aui:select name="emp_status" label="01_emp-status">
				<%
				List<EmploymentStatus> empStatus = EmploymentStatusLocalServiceUtil
								.getEmploymentStatuses(-1, -1);
						{
							Iterator<EmploymentStatus> empStatuses = empStatus
									.iterator();
							while (empStatuses.hasNext()) {
								EmploymentStatus empStatus9 = empStatuses.next();
				%>
				<aui:option value="<%=empStatus9.getEmploymentStatusId()%>"
				label="<%=empStatus9.getEmploymentstatus()%>"></aui:option>
				<%
				}
						}
				%>
				</aui:select>
				<aui:select name="emp_job_category" label="01_job-category">
				<%
				List<JobCategory> jobCategories = JobCategoryLocalServiceUtil
								.getJobCategories(-1, -1);
						{
							Iterator<JobCategory> jobCategory = jobCategories
									.iterator();
							while (jobCategory.hasNext()) {
								JobCategory jobCategory9 = jobCategory.next();
				%>
				<aui:option value="<%=jobCategory9.getJobCategoryId()%>"
				label="<%=jobCategory9.getJobcategory()%>"></aui:option>
				<%
				}
						}
				%>
				</aui:select>
				<aui:select name="emp_sub_unit" label="01_sub-unit">
				<%
				List<SubUnit> subUnit = SubUnitLocalServiceUtil
								.getSubUnits(-1, -1);
						{
							Iterator<SubUnit> subUnits = subUnit.iterator();
							while (subUnits.hasNext()) {
								SubUnit subUnit9 = subUnits.next();
				%>
				<aui:option value="<%=subUnit9.getSubUnitId()%>"
				label="<%=subUnit9.getName()%>"></aui:option>
				<%
				}
						}
				%>
				</aui:select>
				<aui:select name="emp_location" label="01_location">
				<%
				List<Region> regionList = RegionServiceUtil.getRegions();
						{
							%>
							<aui:option selected="<%=empLocationId==0 %>">--Select--</aui:option>
							<%
							Iterator<Region> regions = regionList.iterator();
							while (regions.hasNext()) {
								Region region =regions.next();
				%>
				<aui:option value="<%=region.getRegionId()%>"
				label="<%=region.getName()%>" selected="<%= empLocationId==region.getRegionId()%>" ></aui:option>
				<%
				}
						}
				%>
				</aui:select>
				<aui:input name="effective_date" label="01_effective-date"
					cssClass="dateEmployee"></aui:input>
				<aui:select name="emp_workshift" label="01_work-shift">
				<%
				List<Workshift> workShift = WorkshiftLocalServiceUtil
								.getWorkshifts(-1, -1);
						{
							Iterator<Workshift> workShifts = workShift.iterator();
							while (workShifts.hasNext()) {
								Workshift workShift9 = workShifts.next();
				%>
				<aui:option value="<%=workShift9.getShiftId()%>"
				label="<%=workShift9.getWorkshiftName()%>"></aui:option>
				<%
				}
						}
				%>
				</aui:select>
				<aui:input name="job_comments" label="01_comments" type="textarea"></aui:input>
				<div class="control-group">
					<div class="controls">				
					<aui:button type="submit" id="submitJobHistory"
						cssClass="button btn-success"></aui:button>
					<aui:button id="terminateEmployment" value="01_terminate-employment"
						cssClass="button btn-danger"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<liferay-portlet:renderURL  varImpl="empJobURL">
		<portlet:param name="jsp" value="jsp9"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div class="panel">
	<div class="panel-heading">
		<h3>Job History</h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
		<aui:button name="deleteJobHistory" id="deleteJobHistory"
			cssClass="button btn-danger" value="Delete"></aui:button>
		</div>
		<liferay-ui:search-container  delta="5"
			emptyResultsMessage="No records are available for EmpWorkExp"
			deltaConfigurable="true"
			rowChecker="<%=new RowChecker(renderResponse)%>" iteratorURL="<%=empJobURL %>">
			<liferay-ui:search-container-results >
			<% if(empJob!=null && empJob.size()!=0)
			{
			}
			List<EmpJob> empJobHistory = empJob;
							results =ListUtil.subList(empJob,searchContainer.getStart(), searchContainer.getEnd());
							total = empJob.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
							%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpJob" modelVar="id">
				<liferay-ui:search-container-column-text name="01_effective-date" property="effectiveDate"/>
				<liferay-ui:search-container-column-text name="01_end-date" property="probationEndDate" />
				<liferay-ui:search-container-column-text name="01_jobtitle" value='<%= 
				getJobTitleValue(id.getJobTitleId())!=null?getJobTitleValue(id.getJobTitleId()):"" %>'/>
				<liferay-ui:search-container-column-text name="01_emp-status"
				value='<%= getEmpStatusValue(id.getEmploymentStatusId())!=null?getEmpStatusValue(id.getEmploymentStatusId()):"" %>' />
				<liferay-ui:search-container-column-text name="01_job-category" 
				value='<%= getCategoryValue(id.getJobCategoryId())!=null?getCategoryValue(id.getJobCategoryId()):"" %>'/>
				<liferay-ui:search-container-column-text name="01_sub-unit" 
				value='<%= getSubUnitValue(id.getSubUnitId())!=null?getSubUnitValue(id.getSubUnitId()):"" %>'/>
				<liferay-ui:search-container-column-text name="01_location" 
				value='<%= getLocationValue(id.getLocationId())!=null?getLocationValue(id.getLocationId()):""%>'/>
				<liferay-ui:search-container-column-text name="01_comment" property="comments"/>
				<liferay-ui:search-container-column-text name="01_contract-start-date" />
				<liferay-ui:search-container-column-text name="01_contract-end-date" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
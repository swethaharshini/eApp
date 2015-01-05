<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addReportToEmp" var="addSupervisorEmp">
<portlet:param name="<%=Constants.CMD%>" value="sup_add" /></portlet:actionURL>
<portlet:actionURL name="addReportToEmp" var="addSubordinateEmp">
<portlet:param name="<%=Constants.CMD%>" value="sub_add" />
</portlet:actionURL>
<portlet:resourceURL var="supervisorsAutoComplete" 
id="supervisorsAutoComplete" ></portlet:resourceURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
{
A.one('#assignedSupervisorAdd').hide();
A.one('#assignedSubordinateAdd').hide();
});
   var addSupButton=A.one('#<portlet:namespace />supervisorAdd');
   addSupButton.on('click',
   function()
   {
   A.one('#assignedSubordinateAdd').hide();
   A.one('#<portlet:namespace/>supervisorAdd').hide();
   A.one('#<portlet:namespace/>supervisorDelete').hide();
   A.one('#<portlet:namespace/>subordinateAdd').hide();
   A.one('#<portlet:namespace/>subordinateDelete').hide();
   A.one('#assignedSupervisorAdd').show();
   });
   var addSubButton=A.one('#<portlet:namespace />subordinateAdd');
   addSubButton.on('click',
   function()
   {
    A.one('#assignedSupervisorAdd').hide();
    A.one('#<portlet:namespace/>supervisorAdd').hide();
    A.one('#<portlet:namespace/>supervisorDelete').hide();
    A.one('#<portlet:namespace/>subordinateAdd').hide();
    A.one('#<portlet:namespace/>subordinateDelete').hide();
    A.one('#assignedSubordinateAdd').show();
   });
   var cancelButton=A.one('#<portlet:namespace/>cancelReportTo');
   cancelButton.on('click',function()
   {
   A.one('#assignedSupervisorAdd').hide();
   A.one('#assignedSubordinateAdd').hide();
   A.one('#supervisorAddDelete').show();
   A.one('#subordinateAddDelete').show();
   A.one('#<portlet:namespace/>supervisorAdd').show();
    A.one('#<portlet:namespace/>supervisorDelete').show();
    A.one('#<portlet:namespace/>subordinateAdd').show();
    A.one('#<portlet:namespace/>subordinateDelete').show();
   });
   var cancelButton2=A.one('#<portlet:namespace/>cancelSubordinate');
   cancelButton2.on('click',function()
   {
   A.one('#assignedSupervisorAdd').hide();
   A.one('#assignedSubordinateAdd').hide();
   A.one('#supervisorAddDelete').show();
   A.one('#subordinateAddDelete').show();
   A.one('#<portlet:namespace/>supervisorAdd').show();
    A.one('#<portlet:namespace/>supervisorDelete').show();
    A.one('#<portlet:namespace/>subordinateAdd').show();
    A.one('#<portlet:namespace/>subordinateDelete').show();
   });
    AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated',
    'autocomplete-filters','autocomplete-highlighters',function (A) {
	var testData;
	var node1=new A.AutoCompleteList({
		allowBrowserAutocomplete: 'true',
		activateFirstItem: 'true',
		inputNode: '#<portlet:namespace/>report_sup_name',
		render: 'true',
		resultHighlighter: 'phraseMatch',
		resultTextLocator:'firstName',
		resultFilters:['phraseMatch'],
		source:function(){
		var inputValue=A.one("#<portlet:namespace />report_sup_name").get('value');
		var myAjaxRequest=A.io.request('<%=supervisorsAutoComplete.toString()%>',{
		dataType: 'json',
		method:'POST',
		data:{
		<portlet:namespace />userEnteredText:inputValue,
		},
		autoLoad:false,
		sync:false,
		on: {
		success:function(){
		var data=this.get('responseData');
		testData=data;
		}}
		});
		myAjaxRequest.start();
		return testData;},
		});
		node1.on('select',function(e)
		{
		var selected_node = e.itemNode,
        selected_data = e.result;
        A.one("#<portlet:namespace />supervisorId").set("value",selected_data.raw.id);
		});
	});
</aui:script>
<%
	Map empId = (Map) request.getSession(false).getAttribute(
			"empId");
	long employeeId = (Long)empId.get("empId");
	String jsp=(String)empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
	DynamicQuery supervisorDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpSupervisor.class,
					PortletClassLoaderUtil.getClassLoader());
	supervisorDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpSupervisor> empSupervisorDetails = EmpSupervisorLocalServiceUtil
			.dynamicQuery(supervisorDynamicQuery);
	DynamicQuery subordinateDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpSubordinate.class,
					PortletClassLoaderUtil.getClassLoader());
	supervisorDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpSubordinate> empSubordinateDetails = EmpSubordinateLocalServiceUtil
			.dynamicQuery(subordinateDynamicQuery);
%>
<%!public String supervisorValue(long supId)
	{
		if (supId != 0) {
			DynamicQuery empPerDynamicQuery = DynamicQueryFactoryUtil.forClass(
					EmpPersonalDetails.class,
					PortletClassLoaderUtil.getClassLoader());
			empPerDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
					.eq(supId));
			List<EmpPersonalDetails> empPersDetails = null;
			try {
				empPersDetails = EmpPersonalDetailsLocalServiceUtil
						.dynamicQuery(empPerDynamicQuery);
			} catch (Exception e) {

			}
			EmpPersonalDetails empDetailss = empPersDetails.get(0);
			return empDetailss.getFirstName();
		}
		else
		{
			return "";
		}
	}%>
<div id="assignedSupervisorAdd" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-supervisor" /></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addSupervisor" id="addSupervisor"
			action="<%=addSupervisorEmp %>" method="post">
			<div class="form-horizontal">
				<aui:input name="empSupId" value="<%=employeeId %>"
				type="hidden"></aui:input>
				<aui:input name="reportFileId" value="<%=fileEntryId %>"
				type="hidden"></aui:input>
				<aui:input name="supervisorId" id="supervisorId"
				type="hidden"></aui:input>
				<aui:input name="report_sup_name" id="report_sup_name" 
				label="Name" inlineLabel="left" >
				</aui:input>
				<aui:select name="reporting_sup_method" label="01_reporting-method"
					inlineLabel="left" showRequiredLabel="false">
				<aui:option name="Direct" value="Direct">Direct</aui:option>
				<aui:option name="Indirect" value="Indirect">Indirect</aui:option>
				<aui:option name="Other" value="Other">Other</aui:option>
				</aui:select>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="save"
							id="submitReportingDetails"></aui:button>
						<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
						name="cancelReportTo" id="cancelReportTo"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<div id="assignedSubordinateAdd" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-subordinate" /></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addSubordinate" id="addSubordinate" action="<%=addSubordinateEmp %>" method="post">
			<div class="form-horizontal">
				<aui:input name="empSubId" value="<%=employeeId %>"
				type="hidden"></aui:input>
				<aui:input name="reportFileId" value="<%=fileEntryId %>"
				type="hidden"></aui:input>
				<aui:input name="report_sub_name" label="01_name" inlineLabel="left"
					showRequiredLabel="false">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:select name="reporting_sub_method" label="01_reporting-method"
					inlineLabel="left" showRequiredLabel="false">
				<aui:option name="Direct">Direct</aui:option>
				<aui:option name="Indirect">Indirect</aui:option>
				<aui:option name="Other">Other</aui:option>
				</aui:select>
				<div class="control-group">
					<div class="controls">
					<aui:button type="submit" cssClass="button btn-primary" value="save"
						id="subReportingDetails"></aui:button>
					<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
					name="cancelSubordinate" id="cancelSubordinate"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<liferay-portlet:renderURL  varImpl="reportToURL">
		<portlet:param name="jsp" value="jsp5"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div id="supervisorAddDelete" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_assigned-supervisors" /></h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="supervisorAdd" name="supervisorAdd" value="Add" cssClass="button btn-primary"></aui:button>
			<aui:button id="supervisorDelete" value="Delete" name="supervisorDelete" cssClass="button btn-danger" ></aui:button>
		</div>
			<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpSupervisor"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>" iteratorURL="<%=reportToURL %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpSupervisor> supervisorDetails = empSupervisorDetails;
							results = ListUtil.subList(supervisorDetails,searchContainer.getStart(),searchContainer.getEnd());
							total = supervisorDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpSupervisor"
				modelVar="id">
				<liferay-ui:search-container-column-text name="01_assigned-supervisor"
				value="<%=supervisorValue(id.getReporterEmployeeId()) %>" />
				<liferay-ui:search-container-column-text name="01_reporting-method"
					property="reportingMethod" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="subordinateAddDelete" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_assigned-subordinates" /></h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="subordinateAdd" name="subordinateAdd" value="Add" 
			cssClass="button btn-primary"></aui:button>
			<aui:button id="subordinateDelete" value="Delete"
				name="subordinateDelete" cssClass="button btn-danger"></aui:button>
		</div>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpSubordinate"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>" iteratorURL="<%=reportToURL %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpSubordinate> subordinateDetails = empSubordinateDetails;
							results =ListUtil.subList( subordinateDetails,searchContainer.getStart(),searchContainer.getEnd());
							total = subordinateDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpSubordinate"
				modelVar="id">
				<liferay-ui:search-container-column-text name="01_assigned-subordinate"  />
				<liferay-ui:search-container-column-text name="01_reporting-method"
					property="reportingMethod" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>


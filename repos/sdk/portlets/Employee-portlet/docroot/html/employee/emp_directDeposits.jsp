<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL var="updateEmpDirectDeposits"
	name="updateEmpDirectDeposits" />
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
%>
<aui:form name="empDirectDeposits" id="empDirectDeposits" method="post"
	action="<%=updateEmpDirectDeposits %>">
	<aui:input name="empDirId" value="<%=employeeId %>" type="hidden"></aui:input>
	<aui:input name="directFileId" value="<%=fileEntryId %>" type="hidden"></aui:input>
	<div id="empSalSummary" class="panel">
		<div class="panel-heading">
			<h3>Salary Summary</h3>
		</div>
		<div class="panel-body">
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="deposit_amount" label="01_amount"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="deposit_acnt_number" label="01_acnt-number"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="fin_institute"
						label="01_name-financial-institute"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:select name="acnt_type" label="01_acnt-type">
					<aui:option value="check" label="01_check"></aui:option>
					<aui:option value="saving" label="01_saving"></aui:option>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="branch_location" label="01_branch-location"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="routing_number" label="01_routing-number"></aui:input>
				</div>
			</div>
			<aui:button type="submit" value="Save" id="submitDirectDeposits"></aui:button>
		</div>
	</div>
</aui:form>
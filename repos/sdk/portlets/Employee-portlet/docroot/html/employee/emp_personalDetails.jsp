<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL var="updateEmpPersonalDetails"
	name="updateEmpPersonalDetails" />
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
	var node=A.one('#<portlet:namespace />editPersonalDetails');
	node.on('click',function()
	{
	A.one('#<portlet:namespace />editPersonalDetails').hide();
	A.one('#<portlet:namespace />savePersonalDetails').show();
	A.all('#<portlet:namespace />empPersonalDetailsSave input[type=text]').set('disabled',false);
	A.all('#<portlet:namespace />empPersonalDetailsSave select').set('disabled',false);
	A.all('#<portlet:namespace />empPersonalDetailsSave input[type=radio]').set('disabled',false);
	});
	
</aui:script>
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId = (Long) empId.get("fileId");
	String firstName, middleName, lastName, empNo, otherId, licenseNumber, gender, nationality, maritslStatus;
	Long personalDetailsId;
	String dateOfB, licenseExpDate;
	nationality = "";
	long nationalityId = 0;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
	//Date k = new Date();
	//long employeeId = Long.parseLong(empId);
	DynamicQuery personalDetailsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpPersonalDetails.class,
					PortletClassLoaderUtil.getClassLoader());
	personalDetailsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpPersonalDetails> l = EmpPersonalDetailsLocalServiceUtil
			.dynamicQuery(personalDetailsDynamicQuery);
	if (l.size() != 0) {
		EmpPersonalDetails empPersonalDetails = l.get(0);
		personalDetailsId = empPersonalDetails
				.getEmpPersonalDetailsId();
		firstName = empPersonalDetails.getFirstName();
		middleName = empPersonalDetails.getMiddleName() != null ? empPersonalDetails
				.getMiddleName() : "";
		lastName = empPersonalDetails.getLastName();
		empNo = empPersonalDetails.getEmployeeNo() != null ? empPersonalDetails
				.getEmployeeNo() : "";
		otherId = empPersonalDetails.getOtherId() != null ? empPersonalDetails
				.getOtherId() : "";
		licenseNumber = empPersonalDetails.getLicenseNo() != null ? empPersonalDetails
				.getLicenseNo() : "";
		licenseExpDate = empPersonalDetails.getLicenseExpDate() != null ? sdf.format(empPersonalDetails
				.getLicenseExpDate()) : "";
		gender = String.valueOf(empPersonalDetails.getGender()) != null ? String
				.valueOf(empPersonalDetails.getGender()) : "";
		Nationality empNationality2 = null;
		if ((Long) empPersonalDetails.getNationalityId() != null) {
			DynamicQuery nationalityDynamicQuery = DynamicQueryFactoryUtil
					.forClass(Nationality.class,
							PortletClassLoaderUtil.getClassLoader());
			nationalityDynamicQuery.add(PropertyFactoryUtil.forName(
					"nationalityId").eq(
					empPersonalDetails.getNationalityId()));
			List<Nationality> nationalities = NationalityLocalServiceUtil
					.dynamicQuery(nationalityDynamicQuery);
			if (nationalities.size() != 0) {
				empNationality2 = nationalities.get(0);
				nationality = empNationality2.getName() != null ? empNationality2
						.getName() : "";
				nationalityId = empNationality2.getNationalityId();
			}
		}
		maritslStatus = String.valueOf(empPersonalDetails
				.getMaritalStatus()) != null ? String
				.valueOf(empPersonalDetails.getMaritalStatus()) : "";
		dateOfB = empPersonalDetails.getDateOfBirth() != null ?sdf.format( empPersonalDetails
				.getDateOfBirth()) : "";
	} else {
		personalDetailsId = 0l;
		firstName = "";
		middleName = "";
		lastName = "";
		empNo = "";
		otherId = "";
		licenseNumber = "";
		licenseExpDate = "";
		gender = "";
		nationality = "";
		maritslStatus = "";
		dateOfB = "";
	}
%>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
{
A.one('#<portlet:namespace />savePersonalDetails').hide();
A.all('#<portlet:namespace />empPersonalDetailsSave input[type=text]').set('disabled',true);
	A.all('#<portlet:namespace />empPersonalDetailsSave select').set('disabled',true);
	A.all('#<portlet:namespace />empPersonalDetailsSave input[type=radio]').set('disabled',true);
	
var genderValue="<%=gender%>";
var maritalStatus="<%=maritslStatus%>";
if(genderValue=="male")
	{
	A.one("#<portlet:namespace />genderMale").set('checked',true);
	}
	if(genderValue=="female")
	{
	A.one("#<portlet:namespace />genderFemale").set('checked',true);
	}
	else
	{
	}
if(maritalStatus=="single")
	{
	A.one("#<portlet:namespace />marital_status> option[value="+maritalStatus+"]").set('selected', 'selected');
	}
	if(maritalStatus=="married")
	{
	A.one("#<portlet:namespace />marital_status> option[value="+maritalStatus+"]").set('selected', 'selected');
	}
	if(maritalStatus=="other")
	{
	A.one("#<portlet:namespace />marital_status> option[value="+maritalStatus+"]").set('selected', 'selected');
	}
	else
	{
	}
		});
</aui:script>
<div id="search_form" class="panel">
	<div class="panel-heading">
		<h3>
			<liferay-ui:message key="01_emp-personal-details" />
		</h3>
	</div>
	<div class="panel-body">
		<aui:form name="empPersonalDetailsSave" id="empPersonalDetailsSave"
			method="post" action="<%=updateEmpPersonalDetails%>">
			<div class="form-horizontal">
			<aui:input name="personalDetailsId" type="hidden"
				value="<%=personalDetailsId%>"></aui:input>
			<aui:input name="perEmpId" type="hidden" value="<%=employeeId%>"></aui:input>
			<aui:input name="fileIdemp" type="hidden" value="<%=fileEntryId%>"></aui:input>
					<aui:input name="firstName" label="01_firstName"
						showRequiredLabel="false" disabled="true" value="<%=firstName%>">
						<aui:validator name="required"></aui:validator>
					</aui:input>
						<aui:input name="middleName" label="01_middleName"
							showRequiredLabel="false" disabled="true" value="<%=middleName%>"></aui:input>
						<aui:input name="lastName" label="01_lastName"
							showRequiredLabel="false" disabled="true" value="<%=lastName%>">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					<aui:input name="employee_no" label="01_emp-no" disabled="true"
						inlineLabel="left" value="<%=empNo%>"></aui:input>
					<aui:input name="other_id" label="01_other-id" inlineLabel="left"
						disabled="true" value="<%=otherId%>">
					</aui:input>
					<aui:input name="driver_license_no" label="01_driver-license-no"
						inlineLabel="left" disabled="true" value="<%=licenseNumber%>"></aui:input>
					<aui:input name="expiry_date" label="01_expiry-date"
						inlineLabel="left" disabled="true" value='<%=licenseExpDate%>'
						cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
						 <div class="control-group form-inline">
							<label class="control-label"><liferay-ui:message key="01_gender" /></label>
							<aui:input inlineLabel="right" name="gender" type="radio"
								id="genderMale" value="male" label="01_male" disabled="true" />
							<aui:input inlineLabel="right" name="gender" id="genderFemale"
								type="radio" value="female" label="01_female" disabled="true" />
							</div>
					<aui:select name="marital_status" label="01_marital-status"
						inlineLabel="left" disabled="true">
						<aui:option selected="selected" value="" label="01_select"></aui:option>
						<aui:option id="maritalStatus_single" value="single" label="01_single"></aui:option>
						<aui:option id="maritalStatus_married" value="married" label="01_married"></aui:option>
						<aui:option id="maritalStatus_other" value="other" label="01_other"></aui:option>
					</aui:select>
					<aui:select name="emp_nationality" label="01_nationality"
						disabled="true">
						<%
							if (nationality.equals("")) {
						%>
						<aui:option selected="true" value="0">--Select--</aui:option>
						<%
							} else {
						%>
						<aui:option value="0">--Select--</aui:option>
						<aui:option selected="true" value="<%=nationalityId%>"><%=nationality%></aui:option>
						<%
							}
									List l2 = NationalityLocalServiceUtil.getNationalities(-1,
											-1);
									Iterator nationalities = l2.iterator();
									while (nationalities.hasNext()) {
										Nationality nationalities2 = (Nationality) nationalities
												.next();
						%>
						<%
							if (nationalityId != nationalities2.getNationalityId()) {
						%>
						<aui:option value="<%=nationalities2.getNationalityId()%>"><%=nationalities2.getName()%></aui:option>
						<%
							}
									}
						%>
					</aui:select>

					<aui:input name="date_of_birth" label="01_date-of-birth"
						inlineLabel="left" cssClass="dateEmployee" value='<%=dateOfB%>' placeholder="MM/DD/YYYY" >
					</aui:input>
					<div class="control-group">
						<div class="controls">
						<aui:button id="editPersonalDetails" name="editPersonalDetails"
							value="Edit" cssClass="button btn-success"></aui:button>
						<aui:button id="savePersonalDetails" name="savePersonalDetails"
							value="Save" type="submit" cssClass="button btn-primary"></aui:button>
						</div>
					</div>
			</div>
		</aui:form>
	</div>
</div>
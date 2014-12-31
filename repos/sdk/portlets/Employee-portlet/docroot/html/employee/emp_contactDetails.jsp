<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addOrUpdateEmpContactDetails"
	var="addOrUpdateEmpContactDetails">
</portlet:actionURL>
<aui:script use="aui-io-request-deprecated,aui-node">
var A=new AUI();
A.ready(function()
{
A.one('#<portlet:namespace />saveContactDetails').hide();
A.all('#<portlet:namespace/>empContactDetailsEdit input[type=text]').set('disabled',true);
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=select]').set('disabled',true);
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=radio]').set('disabled',true);
});
	var node=A.one('#<portlet:namespace />editContactDetails');
	node.on('click',function()
	{
	A.one('#<portlet:namespace />editContactDetails').hide();
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=text]').set('disabled',false);
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=select]').set('disabled',false);
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=radio]').set('disabled',false);
	A.one('#<portlet:namespace />saveContactDetails').show();
	});
var phoneValidation;
</aui:script>
<%
Map empId = (Map) request.getSession(false).getAttribute(
			"empId");
	long employeeId = (Long)empId.get("empId");
	String jsp=(String)empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
	String adressStreet1, addressStreet2, city, state, zip, country, homeTel, workTel, mobile, workEmail, otherEmail;
	Long contactDetailsId;
	DynamicQuery contactDetailsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpContactDetails.class,
					PortletClassLoaderUtil.getClassLoader());
	contactDetailsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpContactDetails> contactDetailsList = EmpContactDetailsLocalServiceUtil
			.dynamicQuery(contactDetailsDynamicQuery);
	if (contactDetailsList.size() != 0) {
		EmpContactDetails empContactDetails = contactDetailsList.get(0);
		contactDetailsId = empContactDetails.getEmpContactDetailsId();
		addressStreet2 = empContactDetails.getAddressStreet2() != null ? empContactDetails
				.getAddressStreet2() : "";
		adressStreet1 = empContactDetails.getAddressStreet1() != null ? empContactDetails
				.getAddressStreet1() : "";
		city = empContactDetails.getCity() != null ? empContactDetails
				.getCity() : "";
		state = empContactDetails.getState() != null ? empContactDetails
				.getState() : "";
		zip = empContactDetails.getPostalCode() != null ? empContactDetails
				.getPostalCode() : "";
		country = empContactDetails.getCountry() != null ? empContactDetails
				.getCountry() : "";
		homeTel = empContactDetails.getHomeTelephone() != null ? empContactDetails
				.getHomeTelephone() : "";
		workTel = empContactDetails.getWorkTelephone() != null ? empContactDetails
				.getWorkTelephone() : "";
		workEmail = empContactDetails.getWorkEmail() != null ? empContactDetails
				.getWorkEmail() : "";
		mobile = empContactDetails.getMobile() != null ? empContactDetails
				.getMobile() : "";
		otherEmail = empContactDetails.getOtherEmail() != null ? empContactDetails
				.getOtherEmail() : "";
	} else {
		contactDetailsId=0l;
		adressStreet1 = "";
		addressStreet2 = "";
		city = "";
		state = "";
		zip = "";
		country = "";
		homeTel = "";
		workTel = "";
		mobile = "";
		workEmail = "";
		otherEmail = "";
	}
%>

<div id="emp_contact_details" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="Contact Details"/></h3>
	</div>
	<div class="panel-body">
		<aui:form name="empContactDetailsEdit" id="empContactDetailsEdit"
			method="post" action="<%=addOrUpdateEmpContactDetails %>">
			<aui:input name="conEmpId" type="hidden" value="<%=employeeId%>"></aui:input>
			<div class="form-horizontal">
			<aui:input name="conDetailsId" type="hidden"
				value="<%=contactDetailsId %>"></aui:input>
				<aui:input name="conFileId" type="hidden"
				value="<%=fileEntryId %>"></aui:input>
					<aui:input name="address_street1" label="01_address-street1"
						inlineLabel="left" value="<%=adressStreet1%>"></aui:input>
					<aui:input name="address_street2" label="01_address-street2"
						inlineLabel="left" value="<%=addressStreet2%>"></aui:input>
					<aui:input name="city" label="01_city" inlineLabel="left"
						value="<%=city%>"></aui:input>
					<aui:input name="state" label="01_state" inlineLabel="left"
						value="<%=state%>"></aui:input>
					<aui:input name="zip" label="01_postal-code" value="<%=zip%>"
						inlineLabel="left"></aui:input>
					<aui:input name="country" label="01_country" inlineLabel="left"
						value="<%=country%>">
					</aui:input>
					<aui:input name="home_telephone" label="01_home-tele"
						inlineLabel="left" value="<%=homeTel%>" >
						<aui:validator name="custom" errorMessage="Please enter a valid telephone number">
						function(val,fieldNode,ruleValue)
						{
						var result=false;
						var mobileno = /^\d{10}$/;  
                        if(val.trim()==''||val.match(mobileno))  
                        {  
                         return true;  
                        }  
                       else  
                       {  
                         return false;  
  					   }  
						}
						</aui:validator>
						</aui:input>
					<aui:input name="work_telephone" label="01_work-tele"
						inlineLabel="left" value="<%=workTel%>">
							<aui:validator name="custom" errorMessage="Please enter a valid telephone number">
						function(val,fieldNode,ruleValue)
						{
						var result=false;
						var mobileno = /^\d{10}$/;  
                        if(val.trim()==''||val.match(mobileno))  
                        {  
                         return true;  
                        }  
                       else  
                       {  
                         return false;  
  					   }  
						}
						</aui:validator>
						</aui:input>
					<aui:input name="mobile" label="01_mobile" inlineLabel="left"
						value="<%=mobile%>" placeholder="Enter your 10 digit mobile number">
							<aui:validator name="custom" errorMessage="Please enter a valid mobile number">
						function(val,fieldNode,ruleValue)
						{
						var result=false;
						var mobileno = /^\d{10}$/;  
                        if(val.trim()==''||val.match(mobileno))  
                        {  
                         return true;  
                        }  
                       else  
                       {  
                         return false;  
  					   }  
						}
						</aui:validator>
						</aui:input>
					<aui:input name="work_email" label="01_work-mail" inlineLabel="left"
						value="<%=workEmail%>">
						<aui:validator name="email"></aui:validator></aui:input>

					<aui:input name="other_email" label="01_other-mail"
						inlineLabel="left" value="<%=otherEmail%>">
						<aui:validator name="email"></aui:validator></aui:input>
							<div class="control-group">
									<div class="controls">
									<aui:button name="editContactDetails" id="editContactDetails"
										value="Edit" cssClass="button btn-success" />
									<aui:button type="submit" id="saveContactDetails"
										name="saveContactDetails" value="Save"  cssClass="button btn-primary"/>
							</div>
						</div>
		</div>
		</aui:form>
	</div>
</div>

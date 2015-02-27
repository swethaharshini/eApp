<%@ include file="/html/employee/init.jsp"%>
<portlet:resourceURL var="dependencyDropdown" id="dependencyDropdown"></portlet:resourceURL>
<portlet:actionURL var="updateEmpSalaryDetails"
	name="updateEmpSalaryDetails" />
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId = (Long) empId.get("fileId");
%>
<aui:script>
var A=new AUI();
A.ready(function(){
A.one("#<portlet:namespace />annual_basic_pay").set('disabled',true);
    A.one("#<portlet:namespace />basic_pay_date").set('disabled',true);
    A.one("#<portlet:namespace />car_allowance").set('disabled',true);
    A.one("#<portlet:namespace />car_pay_date").set('disabled',true);
    A.one("#<portlet:namespace />living_allowance").set('disabled',true);
    A.one("#<portlet:namespace />cost_living_date").set('disabled',true);
    A.one("#<portlet:namespace />pension_fund").set('disabled',true);
	A.one("#<portlet:namespace />pension_date").set('disabled',true);
    A.one("#<portlet:namespace />epf_percentage").set('disabled',true);
	A.one("#<portlet:namespace />epf_date").set('disabled',true);
	 var annualpay_checkbox_obj= A.one('input[name=<portlet:namespace />check_annual_payCheckbox]');
	  var carAllowance_checkbox_obj= A.one('input[name=<portlet:namespace />check_car_alwnceCheckbox]');
	  var livAllowance_checkbox_obj= A.one('input[name=<portlet:namespace />check_living_alwnceCheckbox]');
	  var pensionFund_checkbox_obj= A.one('input[name=<portlet:namespace />check_pension_fundCheckbox]');
	  var epfPercentage_checkbox_obj= A.one('input[name=<portlet:namespace />check_epf_percentageCheckbox]');
	  annualpay_checkbox_obj.on('click',function()
	  {
	  if(A.one('input[name=<portlet:namespace />check_annual_payCheckbox]:checked'))
	   {
		  A.one("#<portlet:namespace />annual_basic_pay").set('disabled',false);
		  A.one("#<portlet:namespace />basic_pay_date").set('disabled',false);
	  }
	  else
	  {
		  A.one("#<portlet:namespace />annual_basic_pay").set('disabled',true);
		  A.one("#<portlet:namespace />basic_pay_date").set('disabled',true);
	  }
	  });
	  carAllowance_checkbox_obj.on('click',function()
	  {
	  if(A.one('input[name=<portlet:namespace />check_car_alwnceCheckbox]:checked'))
	   {
		  A.one("#<portlet:namespace />car_allowance").set('disabled',false);
		  A.one("#<portlet:namespace />car_pay_date").set('disabled',false);
	  }
	  else
	  {
		  A.one("#<portlet:namespace />car_allowance").set('disabled',true);
		  A.one("#<portlet:namespace />car_pay_date").set('disabled',true);
	  }
	  });
	 livAllowance_checkbox_obj.on('click',function()
	  {
	  if(A.one('input[name=<portlet:namespace />check_living_alwnceCheckbox]:checked'))
	   {
		  A.one("#<portlet:namespace />living_allowance").set('disabled',false);
		  A.one("#<portlet:namespace />cost_living_date").set('disabled',false);
	  }
	  else
	  {
		  A.one("#<portlet:namespace />living_allowance").set('disabled',true);
		  A.one("#<portlet:namespace />cost_living_date").set('disabled',true);
	  }
	  });
	   pensionFund_checkbox_obj.on('click',function()
	  {
	  if(A.one('input[name=<portlet:namespace />check_pension_fundCheckbox]:checked'))
	   {
		  A.one("#<portlet:namespace />pension_fund").set('disabled',false);
		  A.one("#<portlet:namespace />pension_date").set('disabled',false);
	  }
	  else
	  {
		  A.one("#<portlet:namespace />pension_fund").set('disabled',true);
		  A.one("#<portlet:namespace />pension_date").set('disabled',true);
	  }
	  });
	   epfPercentage_checkbox_obj.on('click',function()
	  {
	  if(A.one('input[name=<portlet:namespace />check_epf_percentageCheckbox]:checked'))
	   {
		  A.one("#<portlet:namespace />epf_percentage").set('disabled',false);
		  A.one("#<portlet:namespace />epf_date").set('disabled',false);
	  }
	  else
	  {
		  A.one("#<portlet:namespace />epf_percentage").set('disabled',true);
		  A.one("#<portlet:namespace />epf_date").set('disabled',true);
	  }
	  });
var basicPay=A.one("#<portlet:namespace />annual_basic_pay");
	var carAlnce=A.one("#<portlet:namespace />car_allowance");
	var livingAlnce=A.one("#<portlet:namespace />living_allowance");
	var pensionFund=A.one("#<portlet:namespace/>pension_fund");
	var epfPercentage=A.one("#<portlet:namespace />epf_percentage");
	var costToCompany=0;
	var totalDeductions=0;
	var totalPayable=0;
	basicPay.on('change',function()
	{
	costToCompany=Number(A.one("#<portlet:namespace />annual_basic_pay").get('value'))+
	         Number(A.one("#<portlet:namespace />car_allowance").get('value'))+
	         Number(A.one("#<portlet:namespace />living_allowance").get('value'));
	
	A.one("#<portlet:namespace/>cost_to_company").set("value",costToCompany);
	A.one("#<portlet:namespace/>tot_deductions").set("value",totalDeductions);
	 totalPayable=Number(costToCompany)-Number(totalDeductions);
	 A.one("#<portlet:namespace/>tot_payable").set("value",totalPayable);
	});
	carAlnce.on('change',function()
	{
    costToCompany=Number(A.one("#<portlet:namespace />annual_basic_pay").get('value'))+
	         Number(A.one("#<portlet:namespace />car_allowance").get('value'))+
	         Number(A.one("#<portlet:namespace />living_allowance").get('value'));
	totalPayable=Number(costToCompany)-Number(totalDeductions);
	A.one("#<portlet:namespace/>cost_to_company").set("value",costToCompany);
	A.one("#<portlet:namespace/>tot_deductions").set("value",totalDeductions);
	A.one("#<portlet:namespace/>tot_payable").set("value",totalPayable);
	});
	livingAlnce.on('change',function()
	{
	costToCompany=Number(A.one("#<portlet:namespace />annual_basic_pay").get('value'))+
	         Number(A.one("#<portlet:namespace />car_allowance").get('value'))+
	         Number(A.one("#<portlet:namespace />living_allowance").get('value'));
	 totalPayable=Number(costToCompany)-Number(totalDeductions);
	 A.one("#<portlet:namespace/>cost_to_company").set("value",costToCompany);
	A.one("#<portlet:namespace/>tot_deductions").set("value",totalDeductions);
	A.one("#<portlet:namespace/>tot_payable").set("value",totalPayable);
	});
	pensionFund.on('change',function()
	{
	totalDeductions=Number(A.one("#<portlet:namespace/>pension_fund").get('value'))+
                    (Number(A.one("#<portlet:namespace />epf_percentage").get('value'))/100)*
                    Number(A.one("#<portlet:namespace />annual_basic_pay").get('value'));
    totalPayable=Number(costToCompany)-Number(totalDeductions);
    A.one("#<portlet:namespace/>cost_to_company").set("value",costToCompany);
	A.one("#<portlet:namespace/>tot_deductions").set("value",totalDeductions);
	A.one("#<portlet:namespace/>tot_payable").set("value",totalPayable);
	});
	epfPercentage.on('change',function()
	{
	totalDeductions=Number(A.one("#<portlet:namespace/>pension_fund").get('value'))+
                    (Number(A.one("#<portlet:namespace />epf_percentage").get('value'))/100)*
                    Number(A.one("#<portlet:namespace />annual_basic_pay").get('value'));
    totalPayable=Number(costToCompany)-Number(totalDeductions);
    A.one("#<portlet:namespace/>cost_to_company").set("value",costToCompany);
	A.one("#<portlet:namespace/>tot_deductions").set("value",totalDeductions);
	A.one("#<portlet:namespace/>tot_payable").set("value",totalPayable);
	});
	
	window.dropdowns= function(nodeValue)
         {
		var currencyDropDown=nodeValue;
		var targetElement = A.one("#<portlet:namespace />emp_paygrade_currency");
		var url = '<%=dependencyDropdown%>';
         A.io.request(url,
        	 {
		 data: {  
		       <portlet:namespace />dropDownValue: currencyDropDown,  
		       },
		 dataType:'json',
		 on: {
		       success: function() { 
		          var currencyArray=this.get('responseData');
		          targetElement.html("");
		          for (var j=0; j < currencyArray.length; j++) {
		          targetElement.append("<option value='" + currencyArray[j] + "'>" + currencyArray[j] + "</option>");
		                    }
                           },
                      failure: function() {
                          }
               }
             });
           };
});
</aui:script>
<aui:form name="saveSalaryPaymentDetails" id="saveSalaryPaymentDetails"
	method="post" action="<%=updateEmpSalaryDetails%>">
	<aui:input name="empSalId" value="<%=employeeId%>" type="hidden"></aui:input>
	<aui:input name="SalFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
	<div id="salaryComponents" class="panel">
		<div class="panel-heading">
			<h3><liferay-ui:message key="01_salary-payment-details" /></h3>
		</div>
		<div class="panel-body">
			<div class="form-horizontal">
				<aui:select name="emp_paygrade" label="01_pay-grade"
				onChange="javascript:dropdowns(this.value);">
				<%
				List<PayGrade> payGrades = PayGradeLocalServiceUtil
								.getPayGrades(-1, -1);
						Iterator<PayGrade> payGrade = payGrades.iterator();
						while (payGrade.hasNext()) {
							PayGrade payGrade9 = payGrade.next();
				%>
				<aui:option value="<%=payGrade9.getPayGradeId()%>"
				label="<%=payGrade9.getPayGradeName()%>">
				</aui:option>
				<%
				}
				%>
				</aui:select>
				<aui:select name="emp_paygrade_currency" label="01_paygrade-currency">
				</aui:select>
				<aui:input name="sal_comments" label="01_comments" type="textarea"></aui:input>
			</div>
		</div>
	</div>
	<div id="empEarnings" class="panel">
		<div class="panel-heading">
			<h3><liferay-ui:message key="01_all-earnings"/></h3>
		</div>
		<div class="panel-body">
				<div class="form-horizontal">
					<div class="control-group">
						<label class="control-label">
						<aui:input name="check_annual_pay" type="checkbox" label=""></aui:input>
						</label>
						<div class="controls">
							<aui:input name="annual_basic_pay" label="01_annual-basic-payment"></aui:input>
							<aui:input name="basic_pay_date" label="01_effective-date"
								cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">
						<aui:input name="check_car_alwnce" type="checkbox" label=""></aui:input>
						</label>
						<div class="controls">
						<aui:input name="car_allowance" label="01_car-allowance"></aui:input>
						<aui:input name="car_pay_date" label="01_effective-date"
							cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">
						<aui:input name="check_living_alwnce" label="" type="checkbox"></aui:input>
						</label>
						<div class="controls">
						<aui:input name="living_allowance" label="01_cost-of-living-allowance"></aui:input>
						<aui:input name="cost_living_date" label="01_effective-date"
						cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
						</div>
					</div>
				</div>
		</div>
	</div>
	<div id="empDeductions" class="panel">
		<div class="panel-heading">
			<h3>All Deductions</h3>
		</div>
		<div class="panel-body">
			<div class="form-horizontal">
				<div class="control-group">
						<label class="control-label">
						<aui:input name="check_pension_fund" label="" type="checkbox"></aui:input>
						</label>
						<div class="controls">
						<aui:input name="pension_fund" label="01_pension-fund"></aui:input>
						<aui:input name="pension_date" label="01_effective-date"
							cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
						</div>
				</div>
				<div class="control-group">
						<label class="control-label">
						<aui:input name="check_epf_percentage" label="" type="checkbox"></aui:input>
						</label>
						<div class="controls">
						<aui:input name="epf_percentage" label="01_epf"></aui:input>
						<aui:input name="epf_date" label="01_effective-date"
							cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
						</div>
				</div>
			</div>
		</div>
	</div>
	<div id="empSalSummary" class="panel">
		<div class="panel-heading">
			<h3><liferay-ui:message key="01_salary-summary" /></h3>
		</div>
		<div class="panel-body">
			<div class="form-horizontal">
				<label class="control-label"><liferay-ui:message key="01_total-deductions" /></label>
				<aui:input name="tot_deductions" label="" disabled="true"></aui:input>
				<label class="control-label"><liferay-ui:message key="01_total-payable" /></label>
				<aui:input name="tot_payable" label="" disabled="true"></aui:input>
				<label class="control-label"><liferay-ui:message key="01_cost-to-company" /></label>
				<aui:input name="cost_to_company" label="" disabled="true"></aui:input>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" value="Save" id="submitSalaryDetails"></aui:button>
					</div>
				</div>
			</div>
		</div>
	</div>
</aui:form>

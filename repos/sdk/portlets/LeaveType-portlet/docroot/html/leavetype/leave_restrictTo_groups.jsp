<%@page import="com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"%>
<%@ include file="/html/leavetype/init.jsp"%>
<portlet:actionURL var="saveemployeegroup" name="saveEmployeeGroup"></portlet:actionURL>
<aui:script>
AUI().ready('event', 'node', function(A){
 A.one(".addinput").hide();
   if(A.one('input[name=<portlet:namespace/>grouprestrictToJobTitlesCheckbox]:checked'))
	   {
	  A.one("#groupJobTitlesDiv").show();
	  }
	  else
	  {
	   A.one("#groupJobTitlesDiv").hide();
	  }
     if(A.one('input[name=<portlet:namespace/>grouprestrictToJobCategoriesCheckbox]:checked'))
	   {
	  A.one("#groupJobCategoriesDiv").show();
	  }
	  else
	  {
	   A.one("#groupJobCategoriesDiv").hide();
	  }
     if(A.one('input[name=<portlet:namespace/>grouprestrictToEmploymentStatusCheckbox]:checked'))
	   {
	  A.one("#groupEmploymentStatusDiv").show();
	  }
	  else
	  {
	   A.one("#groupEmploymentStatusDiv").hide();
	  }
	  if(A.one('input[name=<portlet:namespace/>grouprestrictToGenderCheckbox]:checked'))
	   {
	  A.one("#groupGenderDiv").show();
	  }
	  else
	  {
	   A.one("#groupGenderDiv").hide();
	  }
	if(A.one('input[name=<portlet:namespace/>grouprestrictToYearsOfServiceCheckbox]:checked'))
	   {
	  A.one("#groupYearsOfStatusDiv").show();
	  }
	  else
	  {
	   A.one("#groupYearsOfStatusDiv").hide();
	  }

});
AUI().ready('event', 'node', function(A){
 
 var i =2;
  A.one('input[name=<portlet:namespace/>group'+i+'jobtitle]').hide();
 A.one('input[name=<portlet:namespace/>group'+i+'JobCategories]').hide();
 A.one('input[name=<portlet:namespace/>group'+i+'EmploymentStatus]').hide();
 A.one('#genderDiv'+i).hide();
  A.one('#yearsOfStatusDiv'+i).hide();
AUI().use(
  'aui-node',
  function(A) {
   var node = A.one('#addNew'); var groupArray = [];
    node.on(
      'click',
      function(e) {
      e.preventDefault();
     var newNodeObject = A.one('.addinput').get('innerHTML');
     groupArray.push(i);
     
     
       A.one('#addgroup').append('<div class="panel"><div class="panel-heading"><h5>Employee Group '+i+'</h5></div>'+newNodeObject+'</div>');
        i++;
       var groupName = A.one('#<portlet:namespace/>group2GroupName');
       groupName.attr('name','<portlet:namespace/>group'+i+'GroupName');
       
       var jobtitleCheckbox = A.one('#<portlet:namespace/>group2jobtitleCheckbox');
       jobtitleCheckbox.attr('name','<portlet:namespace/>group'+i+'jobtitleCheckbox');
       var jobtitleValue =  A.one('#<portlet:namespace/>group2jobtitleCheckboxCheckbox');
       jobtitleValue.attr('value',i);
     
       
       var jobtitleName = A.one('#<portlet:namespace/>group2jobtitle');
       jobtitleName.attr('name','<portlet:namespace/>group'+i+'jobtitle');
       
       var jobtitleId = A.one('#<portlet:namespace/>group2jobTitleId');
       jobtitleId.attr('name','<portlet:namespace/>group'+i+'jobTitleId');
       
       var jobCategoriesCheckbox = A.one('#<portlet:namespace/>group2JobCategoriesCheckbox');
       jobCategoriesCheckbox.attr('name','<portlet:namespace/>group'+i+'JobCategoriesCheckbox');
        var jobCategoriesValue = A.one('#<portlet:namespace/>group2JobCategoriesCheckboxCheckbox');
        jobCategoriesValue.attr('value',i);
             
        var jobCategoryName = A.one('#<portlet:namespace/>group2JobCategories');
       jobCategoryName.attr('name','<portlet:namespace/>group'+i+'JobCategories');
       
       var jobCategoryId = A.one('#<portlet:namespace/>group2jobCategoryId');
       jobCategoryId.attr('name','<portlet:namespace/>group'+i+'jobCategoryId');
       
     
       
       var employmentStatusCheckbox = A.one('#<portlet:namespace/>group2EmploymentStatusCheckbox');
       employmentStatusCheckbox.attr('name','<portlet:namespace/>group'+i+'EmploymentStatusCheckbox');
       var employmentStatusValue = A.one('#<portlet:namespace/>group2EmploymentStatusCheckboxCheckbox');
       employmentStatusValue.attr('value',i);
         
        var employmentStatusName = A.one('#<portlet:namespace/>group2EmploymentStatus');
       employmentStatusName.attr('name','<portlet:namespace/>group'+i+'EmploymentStatus');
       
       var employmentStatusId = A.one('#<portlet:namespace/>group2EmploymentStatusId');
       employmentStatusId.attr('name','<portlet:namespace/>group'+i+'EmploymentStatusId');
    
    
       var genderCheckbox = A.one('#<portlet:namespace/>group2GenderCheckbox');
       genderCheckbox.attr('name','<portlet:namespace/>group'+i+'GenderCheckbox');
      var genderValue = A.one('#<portlet:namespace/>group2GenderCheckboxCheckbox');
      genderValue.attr('value',i);
          
        var female = A.one('#<portlet:namespace/>group2Female');
       female.attr('name','<portlet:namespace/>group'+i+'Female');
       
       var male = A.one('#<portlet:namespace/>group2Male');
       male.attr('name','<portlet:namespace/>group'+i+'Male');
       
    
       
       var yearsOfServiceCheckbox = A.one('#<portlet:namespace/>group2YearsOfServiceCheckbox');
       yearsOfServiceCheckbox.attr('name','<portlet:namespace/>group'+i+'YearsOfServiceCheckbox');
      var yearsOfServiceValue = A.one('#<portlet:namespace/>group2YearsOfServiceCheckboxCheckbox');
      yearsOfServiceValue.attr('value',i);
           
        var fromYears = A.one('#<portlet:namespace/>group2FromYears');
       fromYears.attr('name','<portlet:namespace/>group'+i+'FromYears');
       
       var toYears = A.one('#<portlet:namespace/>group2ToYears');
       toYears.attr('name','<portlet:namespace/>group'+i+'ToYears');
       
       var genderdiv = A.one('div.genderDiv2');
       genderdiv.attr('id','genderDiv'+i);
       
       var yearsOfStatusDiv = A.one('div.yearsOfStatusDiv2');
       yearsOfStatusDiv.attr('id','yearsOfStatusDiv'+i);
       
       var removeButton = A.one('.remove-group');
       removeButton.attr('id','group'+i+'Remove');
       
   
       A.one('#<portlet:namespace/>groupCount').val(i);
       console.log(groupArray);
      }
    );
  }
);

AUI().use(
  'aui-node',
  function(A) {
   var node = A.one('#group'+i+'Remove'); 
    node.on(
      'click',
      function(e) {
       alert("heello" +i);
      });
      });
      

	 var checkbox_obj2= A.one('input[name=<portlet:namespace/>grouprestrictToJobTitlesCheckbox]')
	  checkbox_obj2.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>grouprestrictToJobTitlesCheckbox]:checked'))
	   {
	  A.one("#groupJobTitlesDiv").show();
	  }
	  else
	  {
	   A.one("#groupJobTitlesDiv").hide();
	  }
	  });
	  var checkbox_obj6= A.one('input[name=<portlet:namespace/>grouprestrictToJobCategoriesCheckbox]')
	  checkbox_obj6.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>grouprestrictToJobCategoriesCheckbox]:checked'))
	   {
	  A.one("#groupJobCategoriesDiv").show();
	  }
	  else
	  {
	   A.one("#groupJobCategoriesDiv").hide();
	  }
	  });
	  var checkbox_obj3= A.one('input[name=<portlet:namespace/>grouprestrictToEmploymentStatusCheckbox]')
	  checkbox_obj3.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>grouprestrictToEmploymentStatusCheckbox]:checked'))
	   {
	  A.one("#groupEmploymentStatusDiv").show();
	  }
	  else
	  {
	   A.one("#groupEmploymentStatusDiv").hide();
	  }
	  });
	  var checkbox_obj4= A.one('input[name=<portlet:namespace/>grouprestrictToGenderCheckbox]')
	  checkbox_obj4.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>grouprestrictToGenderCheckbox]:checked'))
	   {
	  A.one("#groupGenderDiv").show();
	  }
	  else
	  {
	   A.one("#groupGenderDiv").hide();
	  }
	  });
	  var checkbox_obj5= A.one('input[name=<portlet:namespace/>grouprestrictToYearsOfServiceCheckbox]')
	  checkbox_obj5.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>grouprestrictToYearsOfServiceCheckbox]:checked'))
	   {
	  A.one("#groupYearsOfStatusDiv").show();
	  }
	  else
	  {
	   A.one("#groupYearsOfStatusDiv").hide();
	  }
	  });
	  	
	 });
</aui:script>
<aui:script>
function hideJobTitle(j,i){
 if(j.checked == true)
	 {
	  A.one('input[name=<portlet:namespace/>group'+i+'jobtitle]').show();
	 }
	 else{
	 A.one('input[name=<portlet:namespace/>group'+i+'jobtitle]').hide();
	 }  
	}
function hideJobCategory(j,i){
 if(j.checked == true)
 {
  A.one('input[name=<portlet:namespace/>group'+i+'JobCategories]').show();
 }
 else{
    A.one('input[name=<portlet:namespace/>group'+i+'JobCategories]').hide();
 }

}
function hideEmploymentStatus(j,i){
 if(j.checked == true)
	 {
	  A.one('input[name=<portlet:namespace/>group'+i+'EmploymentStatus]').show();
	 }
	 else{
	 A.one('input[name=<portlet:namespace/>group'+i+'EmploymentStatus]').hide();
	 }  
	}
function hideGender(j,i){
 if(j.checked == true)
 {
  A.one('#genderDiv'+i).show();
 }
 else
 {
  A.one('#genderDiv'+i).hide();
 }

}
function hideYearsOfService(j,i)
{
 if(j.checked == true)
 {
  A.one('#yearsOfStatusDiv'+i).show();
 }
 else
 {
  A.one('#yearsOfStatusDiv'+i).hide();
 }
}
</aui:script>
<% Map leaveInfo=(Map)request.getSession(false).getAttribute(
		"leaveInfo");
		LeaveType editLeaveType=(LeaveType)leaveInfo.get("editLeaveType");
		LeaveRuleApplicable leaveRuleApplicable=(LeaveRuleApplicable)request.getSession().getAttribute("leaveRuleApplicable");%>
 
 <div class="panel">
	<div class="panel-heading">
		<h3>Employee Groups
			<a href="#" id="addNew" class="btn btn-primary add-group pull-right"><i class="icon-plus"></i> AddGroup</a>
		</h3>
	</div>
	
	<aui:form name="whoCanApplyForLeave" action="<%=saveemployeegroup.toString()%>"
			method="post" onSubmit="javascript:submitForm()">
	<div class="panel-body" id="addgroup">
		<div class="panel">
			<div class="panel-heading">
			<h5>Employee Group 1: Default</h5>
			</div>
			<div class="panel-body">
			<div class="addmore">
				<aui:input name="leaveTypeId" value="<%=editLeaveType.getLeaveTypeId() %>" type="hidden"></aui:input>
				<aui:input name="leaveApplicabilityId" value="" type="hidden"></aui:input>
				<aui:input name="groupName" label="Group Name" inlineLabel="left" value="Default"></aui:input>
				<hr/>
				<aui:input name="grouprestrictToJobTitles" type="checkbox" 
					label="Job Titles" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobTitles() %>"></aui:input>
				<div id="groupJobTitlesDiv">
					<aui:input name="applyToJobTitles" id="applyToJobTitles" value="" label=""></aui:input>
				<aui:input type="hidden" name="jobTitleId" id="jobTitleId" value="" ></aui:input>
				</div>
				<hr>
				<aui:input name="grouprestrictToJobCategories" type="checkbox"
					label="Job Categories" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobCategories() %>"></aui:input>
				<div id="groupJobCategoriesDiv">
					<aui:input name="applyToJobCategories" id="applyToJobCategories" label=""/>
				<aui:input type="hidden" name="jobCategoryId" id="jobCategoryId" value=""/>
				</div>
				<hr>
				<aui:input name="grouprestrictToEmploymentStatus" type="checkbox"
					label="Employment Status" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForEmploymentStatus() %>"></aui:input>
				<div id="groupEmploymentStatusDiv">
					<aui:input name="applyToEmploymentStatus" label=""></aui:input>
				<aui:input type="hidden" name="employmentStatusId" id="employmentStatusId" value=""></aui:input>
				</div>
				<hr>
				<aui:input name="grouprestrictToGender" type="checkbox" label="Gender" 
				checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForGender() %>"></aui:input>
				<div id="groupGenderDiv">
				<div class="row-fluid">
				<div class="span2">  <aui:input name="applyToFemale" label="Female" type="checkbox"></aui:input></div>
				<div class="span3">  <aui:input name="applyToMale" label="Male" type="checkbox"></aui:input></div>
					<div class="span7"></div>
					</div>
				</div>
				<hr>
				<aui:input name="grouprestrictToYearsOfService" type="checkbox"
					label="Years of Service" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForYearsOfService() %>"></aui:input>
				<div id="groupYearsOfStatusDiv">
					<p>Only employees with joined dates and corresponding years of
						service will be allowed to apply for this leave type.</p>
					<aui:input name="applyToFromYears" label="From"></aui:input>
				<aui:input name="applyToYears" label="To"></aui:input>
				</div>
				</div>
			</div>
		</div>
	   
		<div class="addinput" id="group2">
				<aui:input id="groupLeaveTypeId" name="groupLeaveTypeId" value="<%=editLeaveType.getLeaveTypeId() %>" type="hidden"></aui:input>
		
		<aui:input name="group2GroupName" id="group2GroupName" label="Group Name" inlineLabel="left"/>
		<hr/>
		<aui:input name="group2jobtitleCheckbox" type="checkbox" id="group2jobtitleCheckbox" onClick="hideJobTitle(this,this.value)" value="2"
			label="Job Titles" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobTitles() %>"></aui:input>
		<div id="group2JobTitlesDiv">
			<aui:input name="group2jobtitle" id="group2jobtitle" value="" label=""></aui:input>
		<aui:input type="hidden" name="group2jobTitleId" id="group2jobTitleId" value="" ></aui:input>
		</div>
		<hr>
		<aui:input name="group2JobCategoriesCheckbox" type="checkbox" id="group2JobCategoriesCheckbox" onClick="hideJobCategory(this,this.value)" value="2"
			label="Job Categories" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobCategories() %>"></aui:input>
		<div id="group2JobCategoriesDiv">
			<aui:input name="group2JobCategories" id="group2JobCategories" label=""/>
		<aui:input type="hidden" name="group2jobCategoryId" id="group2jobCategoryId" value=""/>
		</div>
		<hr>
		<aui:input name="group2EmploymentStatusCheckbox" type="checkbox" id="group2EmploymentStatusCheckbox" onClick="hideEmploymentStatus(this,this.value)" value="2"
			label="Employment Status" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForEmploymentStatus() %>"></aui:input>
		<div id="group2EmploymentStatusDiv">
			<aui:input name="group2EmploymentStatus" id="group2EmploymentStatus" label=""></aui:input>
		<aui:input type="hidden" name="group2EmploymentStatusId" id="group2EmploymentStatusId" value=""></aui:input>
		</div>
		<hr>
		<aui:input name="group2GenderCheckbox" type="checkbox" label="Gender" id="group2GenderCheckbox" onClick="hideGender(this,this.value)" value="2"
		checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForGender() %>"></aui:input>
		<div class="genderDiv2" id="genderDiv2">
		<div class="row-fluid">
		<div class="span2">  <aui:input name="group2Female" id="group2Female" label="Female" type="checkbox"></aui:input></div>
		<div class="span3">  <aui:input name="group2Male" id="group2Male" label="Male" type="checkbox"></aui:input></div>
			<div class="span7"></div>
			</div>
		</div>
		<hr>
		<aui:input name="group2YearsOfServiceCheckbox" type="checkbox" id="group2YearsOfServiceCheckbox" onClick="hideYearsOfService(this,this.value)" value="2"
			label="Years of Service" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForYearsOfService() %>"></aui:input>
		<div class="yearsOfStatusDiv2" id="yearsOfStatusDiv2">
			<p>Only employees with joined dates and corresponding years of
				service will be allowed to apply for this leave type.</p>
			<aui:input name="group2FromYears" id="group2FromYears" label="From"></aui:input>
		<aui:input name="group2ToYears" id="group2ToYears" label="To"></aui:input>
		</div>
		<a href="#" class="remove-group btn btn-danger" id="group2Remove"><i class="icon-trash"></i>RemoveGroup</a>
		
		</div>
		
		<aui:input name="groupCount" id="groupCount" value="" type="hidden"></aui:input>
			</div>
			<aui:button type="submit" value="Save"></aui:button>
		</aui:form>
	
</div>



 
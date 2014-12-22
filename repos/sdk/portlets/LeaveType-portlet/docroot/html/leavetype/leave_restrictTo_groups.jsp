<%@page import="com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"%>
<%@ include file="/html/leavetype/init.jsp"%>
<portlet:actionURL var="saveemployeegroup" name="saveEmployeeGroup"></portlet:actionURL>
<aui:script>
AUI().ready('event', 'node', function(A){
 A.one(".addinput").hide();
 A.one("#customgroupJobCategoriesDiv").hide();
  A.one("#groupJobTitlesDiv").hide();
    A.one("#groupJobCategoriesDiv").hide();
     A.one("#groupEmploymentStatusDiv").hide();
    A.one("#groupGenderDiv").hide();
    A.one("#groupYearsOfStatusDiv").hide();
});
AUI().ready('event', 'node', function(A){
 
 var i =2;
AUI().use(
  'aui-node',
  function(A) {
   var node = A.one('#addNew'); var groupArray = [];
   var removenode = A.one('button');
    node.on(
      'click',
      function(e) {
      e.preventDefault();
     var newNodeObject = A.one('.addinput').get('innerHTML');
     groupArray.push(i);
   
       A.one('#addgroup').append('<div class="panel"><div class="panel-heading"><h5>Employee Group '+i+'</h5></div>'+newNodeObject+'</div>');
       i = i+1;
       
      }
    );
   removenode.on('click',function(){
    alert("heee####");
    this.remove('div');
   });
  }
);



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
 
	function submitForm(){

console.log("submitted.....");
}
	
	
</aui:script>
<%Map leaveInfo=(Map)request.getSession(false).getAttribute(
		"leaveInfo");
		LeaveType editLeaveType=(LeaveType)leaveInfo.get("editLeaveType");
		LeaveRuleApplicable leaveRuleApplicable=(LeaveRuleApplicable)request.getSession().getAttribute("leaveRuleApplicable");%>
 <a href="#" id="addNew">AddGroup</a>
 <div class="panel">
	<div class="panel-heading">
		<h4>Employee Groups</h4>
	</div>
	
	<aui:form name="whoCanApplyForLeave" action="<%=saveemployeegroup.toString()%>"
			method="post" onSubmit="javascript:submitForm()">
	<div class="panel-body" id="addgroup">
		<div class="panel">
	<div class="panel-heading">
		<h5>Employee Group 1: Default</h5>
	</div>
	<div class="panel-body">
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
		</div></div>
	<div class="addinput">
			<aui:input name="ss" value="<%=editLeaveType.getLeaveTypeId() %>" type="hidden"></aui:input>
			<aui:input name="ss" value="" type="hidden"></aui:input>
			<aui:input name="<portletnamespace/>customGroupName" label="Group Name" inlineLabel="left"/>
			<hr/>
			<aui:input name="grouprestrictToJobTitles" type="checkbox" 
				label="Job Titles" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobTitles() %>"></aui:input>
			<div id="groupJobTitlesDiv">
				<aui:input name="<portletnamespace/>groupJobTitles" id="applyToJobTitles" value="" label=""></aui:input>
				<aui:input type="hidden" name="jobTitleId" id="jobTitleId" value="" ></aui:input>
			</div>
			<hr>
			<aui:input name="grouprestrictToJobCategories" type="checkbox"
				label="Job Categories" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobCategories() %>"></aui:input>
			<div id="customgroupJobCategoriesDiv">
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
			<a href="#" style="color: black" class="removegroup" >RemoveGroup</a>
			
			</div>
			</div>
		<hr>
			<aui:button type="submit" value="Save"></aui:button>
		</aui:form>
	
</div>



 
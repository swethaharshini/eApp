<%@page import="com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmploymentStatus"%>
<%@page import="com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.JobCategory"%>
<%@page import="com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.JobTitle"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"%>
<%@ include file="/html/leavetype/init.jsp" %>
<portlet:actionURL var="saveWhoCanApply" name="saveWhoCanApply"></portlet:actionURL>
<portlet:resourceURL var="getJobTitles" id="getJobTitles" ></portlet:resourceURL>
<portlet:resourceURL var="getjobcategories" id="getJobcategories">
</portlet:resourceURL>
<portlet:resourceURL var="getemploymentstatus" id="getEmploymentStatus" ></portlet:resourceURL>
<aui:script>

var A=new AUI();
var empstatusidArray = [];
var empstatusAndId={};
AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated',
    'autocomplete-filters','autocomplete-highlighters',function (A) {
	var empstatusData;
	var empstatusNode= A.one("#<portlet:namespace />employmentStatusId");
	var node3=new A.AutoCompleteList({
		allowBrowserAutocomplete: 'false',
		inputNode: '#<portlet:namespace/>applyToEmploymentStatus',
		render: 'true',
		maxResults: 0,
		resultTextLocator:'employmentstatus',
		queryDelimiter : ',',
		resultFilters:['startsWith'],
		source:function(){
			var empstatusidValue=A.one("#<portlet:namespace/>employmentStatusId").get('value');
			var empstatusinputValue=A.one("#<portlet:namespace />applyToEmploymentStatus").get('value');
			var empstatusAjaxRequest=A.io.request('<%=getemploymentstatus.toString()%>',{
			dataType: 'json',
			method:'POST',
			data:{
			<portlet:namespace />empstatusText:empstatusidValue,
			<portlet:namespace/>empstatusValue:empstatusinputValue,
			},
			autoLoad:false,
			sync:false,
			on: {
				success:function(){
				var data=this.get('responseData');
				
				empstatusData=data;
				}}
			});
		empstatusAjaxRequest.start();
		
		return empstatusData;},
		});
		
		node3.on('select',function(e)
		{
		var selected_node = e.itemNode,
        selected_data = e.result;
        var empstatusNode=A.one("<portlet:namespace/>applyToEmploymentStatus");
        var empstatusValue=A.one("#<portlet:namespace />applyToEmploymentStatus").get('value');
        if(empstatusValue.length<1)
        {
        empstatusidArray.empty();
        A.one("#<portlet:namespace />employmentStatusId").set("value","");
        }
        var s=0;
       for(var j=0; j<=empstatusidArray.length; j++)
         {
           if(selected_data.raw.employmentstatusId==empstatusidArray[j])
           {
           s++;
          
           }
         }
        if(s==0)
         {
        empstatusidArray.push(selected_data.raw.employmentstatusId);
        
         }
         else
         {
         
         }
        
        A.one("#<portlet:namespace />employmentStatusId").set("value",empstatusidArray.toString());
		});
	});





var A=new AUI();
var jobcategoryidArray = [];
var jobcategoryAndId={};
AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated',
    'autocomplete-filters','autocomplete-highlighters',function (A) {
	var jobcategoryData;
	var jobCategoryNode= A.one("#<portlet:namespace />jobCategoryId");
	var node2=new A.AutoCompleteList({
		allowBrowserAutocomplete: 'false',
		inputNode: '#<portlet:namespace/>applyToJobCategories',
		render: 'true',
		maxResults: 0,
		resultTextLocator:'jobcategory',
		queryDelimiter : ',',
		resultFilters:['startsWith'],
		source:function(){
			var jobcategoryidValue=A.one("#<portlet:namespace/>jobCategoryId").get('value');
			var jobcategoryinputValue=A.one("#<portlet:namespace />applyToJobCategories").get('value');
			var jobcategoryAjaxRequest=A.io.request('<%=getjobcategories.toString()%>',{
			dataType: 'json',
			method:'POST',
			data:{
			<portlet:namespace />jobCategoryText:jobcategoryidValue,
			<portlet:namespace/>jobCategoryValue:jobcategoryinputValue,
			},
			autoLoad:false,
			sync:false,
			on: {
				success:function(){
				var data=this.get('responseData');
				
				jobcategoryData=data;
				}}
			});
		jobcategoryAjaxRequest.start();
		
		return jobcategoryData;},
		});
		
		node2.on('select',function(e)
		{
		var selected_node = e.itemNode,
        selected_data = e.result;
        //jobcategoryAndId[selected_data.raw.id]=selected_data.raw.jobcategory;
        var jcategoryNode=A.one("<portlet:namespace/>applyToJobCategories");
        var jcategoryValue=A.one("#<portlet:namespace />applyToJobCategories").get('value');
        if(jcategoryValue.length<1)
        {
        jobcategoryidArray.empty();
        A.one("#<portlet:namespace />jobCategoryId").set("value","");
        }
        var s=0;
       for(var j=0; j<=jobcategoryidArray.length; j++)
         {
           if(selected_data.raw.jobCategoryId==jobcategoryidArray[j])
           {
           s++;
          
           }
         }
        if(s==0)
         {
        jobcategoryidArray.push(selected_data.raw.jobCategoryId);
        
         }
         else
         {
         
         }
        
        A.one("#<portlet:namespace />jobCategoryId").set("value",jobcategoryidArray.toString());
		});
	});
	
	var A=new AUI();
var idArray = [];
var titleAndId={};
AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated',
    'autocomplete-filters','autocomplete-highlighters',function (A) {
	
	
	var testData;
	var jobTitleNode= A.one("#<portlet:namespace />jobTitleId");
	var node1=new A.AutoCompleteList({
		allowBrowserAutocomplete: 'false',
		inputNode: '#<portlet:namespace/>applyToJobTitles',
		render: 'true',
		maxResults: 0,
		resultTextLocator:'title',
		queryDelimiter : ',',
		resultFilters:['startsWith'],
		source:function(){
			var idValue=A.one("#<portlet:namespace/>jobTitleId").get('value');
			var inputValue=A.one("#<portlet:namespace />applyToJobTitles").get('value');
			var myAjaxRequest=A.io.request('<%=getJobTitles.toString()%>',{
			dataType: 'json',
			method:'POST',
			data:{
			<portlet:namespace />userEnteredText:inputValue,
			<portlet:namespace/>idOfEnteredValue:idValue,
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
      
        var titleNode=A.one("<portlet:namespace/>applyToJobTitles");
        var titleValue=A.one("#<portlet:namespace />applyToJobTitles").get('value');
        if(titleValue.length<1)
        {
        idArray.empty();
         A.one("#<portlet:namespace />jobTitleId").set("value","");
        }
        var s=0;
        for(var j=0; j<=idArray.length; j++)
         {
           if(selected_data.raw.id==idArray[j])
           {
           s++;
           
           }
         }
        if(s==0)
         {
        idArray.push(selected_data.raw.id);
        
         }
         else
         {
         
         }
        A.one("#<portlet:namespace />jobTitleId").set("value",idArray.toString());
		});
	});
	AUI().ready('event', 'node', function(A){
	 var checkbox_obj2= A.one('input[name=<portlet:namespace/>restrictToJobTitlesCheckbox]')
	  checkbox_obj2.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>restrictToJobTitlesCheckbox]:checked'))
	   {
	  A.one("#selectedJobTitlesDiv").show();
	  }
	  else
	  {
	   A.one("#selectedJobTitlesDiv").hide();
	  }
	  });
	  var checkbox_obj6= A.one('input[name=<portlet:namespace/>restrictToJobCategoriesCheckbox]')
	  checkbox_obj6.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>restrictToJobCategoriesCheckbox]:checked'))
	   {
	  A.one("#selectedJobCategoriesDiv").show();
	  }
	  else
	  {
	   A.one("#selectedJobCategoriesDiv").hide();
	  }
	  });
	  var checkbox_obj3= A.one('input[name=<portlet:namespace/>restrictToEmploymentStatusCheckbox]')
	  checkbox_obj3.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>restrictToEmploymentStatusCheckbox]:checked'))
	   {
	  A.one("#selectedEmploymentStatusDiv").show();
	  }
	  else
	  {
	   A.one("#selectedEmploymentStatusDiv").hide();
	  }
	  });
	  var checkbox_obj4= A.one('input[name=<portlet:namespace/>restrictToGenderCheckbox]')
	  checkbox_obj4.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>restrictToGenderCheckbox]:checked'))
	   {
	  A.one("#selectedGenderDiv").show();
	  }
	  else
	  {
	   A.one("#selectedGenderDiv").hide();
	  }
	  });
	  var checkbox_obj5= A.one('input[name=<portlet:namespace/>restrictToYearsOfServiceCheckbox]')
	  checkbox_obj5.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>restrictToYearsOfServiceCheckbox]:checked'))
	   {
	  A.one("#selectedYearsOfStatusDiv").show();
	  }
	  else
	  {
	   A.one("#selectedYearsOfStatusDiv").hide();
	  }
	  });
	 });
</aui:script>

<%
Map leaveInfo=(Map)request.getSession(false).getAttribute(
		"leaveInfo");
		LeaveType editLeaveType=(LeaveType)leaveInfo.get("editLeaveType");
		LeaveRuleApplicable leaveRuleApplicable=(LeaveRuleApplicable)leaveInfo.get("leaveRuleApplicable");
		System.out.println("leaveInfo Map object in editleave_applicability.jsp= " +leaveInfo);
		System.out.println(" editLeaveType in editleave_applicability.jsp= "+editLeaveType);
		System.out.println("leaveRuleApplicable in editleave_applicability.jsp = "+leaveRuleApplicable);
		System.out.println("leaveRuleApplicableId == "+leaveRuleApplicable.getLeaveRuleApplicableId()+"\n getting jobtitle,jobcategory and employmentstatus list");
		List<JobTitle> jobTitles = JobTitleLocalServiceUtil.getLeaveRuleApplicableJobTitles(leaveRuleApplicable.getLeaveRuleApplicableId());
		System.out.println(jobTitles);
		List<JobCategory> jobCategories = JobCategoryLocalServiceUtil.getLeaveRuleApplicableJobCategories(leaveRuleApplicable.getLeaveRuleApplicableId());
		System.out.println(jobCategories);
		List<EmploymentStatus> employmentStatus = EmploymentStatusLocalServiceUtil.getLeaveRuleApplicableEmploymentStatuses(leaveRuleApplicable.getLeaveRuleApplicableId());
		System.out.println(employmentStatus);	
		%>
<div class="panel">
	<div class="panel-heading">
		<h4>Who Can Apply</h4>
	</div>
	<div class="panel-body">
		<aui:form name="whoCanApplyForLeave" id="whoCanApplyForLeave"
			action="<%=saveWhoCanApply%>" method="post">
			
			<aui:input name="leaveTypeId" value="<%=editLeaveType.getLeaveTypeId() %>" type="hidden"/>
			
			<aui:input name="leaveApplicabilityId" value="<%=leaveRuleApplicable.getLeaveRuleApplicableId() %>" type="hidden"></aui:input>
			
			<aui:input name="restrictToJobTitles" type="checkbox" 
				label="Job Titles" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobTitles() %>"></aui:input>
			<div id="selectedJobTitlesDiv">
			 <%  
			    String jobtitlevalues=null; String jobtitleids = null;
			  for(int i =0;i<jobTitles.size();i++){
				  if(i==0){
					  jobtitlevalues = jobTitles.get(i).getTitle()+",";
					  jobtitleids = jobTitles.get(i).getJobTitleId()+",";
				  }if(i!=0){
			     jobtitlevalues = jobtitlevalues+jobTitles.get(i).getTitle()+",";
			     jobtitleids = jobtitleids+jobTitles.get(i).getJobTitleId()+",";
				  }
			   }
			   System.out.println("jobtitlevalues == " +jobtitlevalues);
			   %>
			<aui:input name="applyToJobTitles" id="applyToJobTitles" value="<%= jobtitlevalues %>" label=""></aui:input>
			<aui:input type="hidden" name="jobTitleId" id="jobTitleId" value="<%= jobtitleids %>" ></aui:input>
			</div>
			<hr>
			<%  
			    String jobcategoryvalues=null; String jobcategoryids = null;
			  for(int i =0;i<jobCategories.size();i++){
				  if(i==0){
					  jobcategoryvalues = jobCategories.get(i).getJobcategory()+",";
					  jobcategoryids = jobCategories.get(i).getJobCategoryId()+",";
				  }if(i!=0){
					  jobcategoryvalues = jobcategoryvalues+jobCategories.get(i).getJobcategory()+",";
					  jobcategoryids = jobcategoryids+jobCategories.get(i).getJobCategoryId()+",";
				  }
			   }
			   System.out.println("jobcategoryvalues == " +jobcategoryvalues);
			   %>
			
			
			<aui:input name="restrictToJobCategories" type="checkbox"
				label="Job Categories" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobCategories() %>"></aui:input>
			<div id="selectedJobCategoriesDiv">
				<aui:input name="applyToJobCategories" id="applyToJobCategories" label="" value="<%= jobcategoryvalues %>"/>
				<aui:input type="hidden" name="jobCategoryId" id="jobCategoryId" value="<%= jobcategoryids %>"/>
			</div>
			<hr>
			<%  
			    String employmentstatusvalues=null; String employmentstatusids = null;
			  for(int i =0;i<employmentStatus.size();i++){
				  if(i==0){
					  employmentstatusvalues = employmentStatus.get(i).getEmploymentstatus()+",";
					  employmentstatusids = employmentStatus.get(i).getEmploymentStatusId()+",";
				  }if(i!=0){
					  employmentstatusvalues = employmentstatusvalues+employmentStatus.get(i).getEmploymentstatus()+",";
					  employmentstatusids = employmentstatusids+employmentStatus.get(i).getEmploymentStatusId()+",";
				  }
			   }
			   System.out.println("employmentstatusvalues == " +employmentstatusvalues);
			   %>
			
			
			<aui:input name="restrictToEmploymentStatus" type="checkbox"
				label="Employment Status" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForEmploymentStatus() %>"></aui:input>
			<div id="selectedEmploymentStatusDiv">
				<aui:input name="applyToEmploymentStatus" label="" value="<%= employmentstatusvalues %>"></aui:input>
				<aui:input type="hidden" name="employmentStatusId" id="employmentStatusId" value="<%= employmentstatusids %>"></aui:input>
			</div>
			<hr>
			<aui:input name="restrictToGender" type="checkbox" label="Gender" 
			checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForGender() %>"></aui:input>
			<div id="selectedGenderDiv">
			<div class="row-fluid">
			<div class="span2">  <aui:input name="applyToFemale" label="Female" type="checkbox" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForFemale() %>"></aui:input></div>
			<div class="span3">  <aui:input name="applyToMale" label="Male" type="checkbox" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForMale() %>"></aui:input></div>
				<div class="span7"></div>
				</div>
			</div>
			<hr>
			<aui:input name="restrictToYearsOfService" type="checkbox"
				label="Years of Service" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForYearsOfService() %>"></aui:input>
			<div id="selectedYearsOfStatusDiv">
				<p>Only employees with joined dates and corresponding years of
					service will be allowed to apply for this leave type.</p>
				<aui:input name="applyToFromYears" label="From" value="<%=leaveRuleApplicable.getFromYears()%>"></aui:input>
				<aui:input name="applyToYears" label="To" value="<%=leaveRuleApplicable.getToYears() %>"></aui:input>
			</div>
			<hr>
			<aui:button type="submit" value="Save"></aui:button>
		</aui:form>
	</div>
</div>
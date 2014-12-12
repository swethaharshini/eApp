<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.rknowsys.eapp.hrm.model.LeaveRuleApplicable"%>
<%@ include file="/html/leavetype/init.jsp" %>
<portlet:actionURL var="saveWhoCanApply" name="saveWhoCanApply"></portlet:actionURL>
<portlet:resourceURL var="getJobTitles" id="getJobTitles" ></portlet:resourceURL>
<portlet:resourceURL var="getjobcategories" id="getJobcategories">
</portlet:resourceURL>
<portlet:resourceURL var="getemploymentstatus" id="getEmploymentStatus" ></portlet:resourceURL>
<aui:script>
AUI().ready('event', 'node', function(A){
   
  A.one("#selectedJobTitlesDiv").hide();
    A.one("#selectedJobCategoriesDiv").hide();
     A.one("#selectedEmploymentStatusDiv").hide();
    A.one("#selectedGenderDiv").hide();
    A.one("#selectedYearsOfStatusDiv").hide();
});

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
		LeaveRuleApplicable leaveRuleApplicable=(LeaveRuleApplicable)request.getSession().getAttribute("leaveRuleApplicable");%>
<div class="panel">
	<div class="panel-heading">
		<h3>Who Can Apply</h3>
	</div>
	<div class="panel-body">
		<aui:form name="whoCanApplyForLeave" id="whoCanApplyForLeave"
			action="<%=saveWhoCanApply%>" method="post">
			<aui:input name="leaveTypeId" value="<%=editLeaveType.getLeaveTypeId() %>" type="hidden"></aui:input>
			<aui:input name="leaveApplicabilityId" value="" type="hidden"></aui:input>
			<aui:input name="restrictToJobTitles" type="checkbox" 
				label="Job Titles" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobTitles() %>"></aui:input>
			<div id="selectedJobTitlesDiv">
				<aui:input name="applyToJobTitles" id="applyToJobTitles" value="" label=""></aui:input>
				<aui:input type="hidden" name="jobTitleId" id="jobTitleId" value="" ></aui:input>
			</div>
			<hr>
			<aui:input name="restrictToJobCategories" type="checkbox"
				label="Job Categories" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForJobCategories() %>"></aui:input>
			<div id="selectedJobCategoriesDiv">
				<aui:input name="applyToJobCategories" id="applyToJobCategories" label=""/>
				<aui:input type="hidden" name="jobCategoryId" id="jobCategoryId" value=""/>
			</div>
			<hr>
			<aui:input name="restrictToEmploymentStatus" type="checkbox"
				label="Employment Status" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForEmploymentStatus() %>"></aui:input>
			<div id="selectedEmploymentStatusDiv">
				<aui:input name="applyToEmploymentStatus" label=""></aui:input>
				<aui:input type="hidden" name="employmentStatusId" id="employmentStatusId" value=""></aui:input>
			</div>
			<hr>
			<aui:input name="restrictToGender" type="checkbox" label="Gender" 
			checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForGender() %>"></aui:input>
			<div id="selectedGenderDiv">
			<div class="row-fluid">
			<div class="span2">  <aui:input name="applyToFemale" label="Female" type="checkbox"></aui:input></div>
			<div class="span3">  <aui:input name="applyToMale" label="Male" type="checkbox"></aui:input></div>
				<div class="span7"></div>
				</div>
			</div>
			<hr>
			<aui:input name="restrictToYearsOfService" type="checkbox"
				label="Years of Service" checked="<%=leaveRuleApplicable==null?false:leaveRuleApplicable.getForYearsOfService() %>"></aui:input>
			<div id="selectedYearsOfStatusDiv">
				<p>Only employees with joined dates and corresponding years of
					service will be allowed to apply for this leave type.</p>
				<aui:input name="applyToFromYears" label="From"></aui:input>
				<aui:input name="applyToYears" label="To"></aui:input>
			</div>
			<hr>
			<aui:button type="submit" value="Save"></aui:button>
		</aui:form>
	</div>
</div>
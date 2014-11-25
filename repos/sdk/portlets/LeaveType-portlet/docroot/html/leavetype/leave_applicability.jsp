<%@ include file="/html/leavetype/init.jsp" %>
<portlet:actionURL var="saveWhoCanApply" name="saveWhoCanApply"></portlet:actionURL>
<portlet:resourceURL var="getJobTitles" id="getJobTitles" ></portlet:resourceURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
var idArray = [];
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
        idArray.push(selected_data.raw.id);
        A.one("#<portlet:namespace />jobTitleId").set("value",idArray.toString());
		});
	});
</aui:script>

<div class="panel">
	<div class="panel-heading">
		<h3>Who Can Apply</h3>
	</div>
	<div class="panel-body">
		<aui:form name="whoCanApplyForLeave" id="whoCanApplyForLeave"
			action="<%=saveWhoCanApply%>" method="post">
			<aui:input name="restrictToJobTitles" type="checkbox"
				label="Job Titles"></aui:input>
			<div id="selectedJobTitlesDiv">
				<aui:input name="applyToJobTitles" id="applyToJobTitles" value="" label=""></aui:input>
				<aui:input name="jobTitleId" id="jobTitleId" value="" ></aui:input>
			</div>
			<hr>
			<aui:input name="restrictToJobCategories" type="checkbox"
				label="Job Categories"></aui:input>
			<div id="selectedJobCategoriesDiv">
				<aui:input name="applyToJobCategories" label=""></aui:input>
			</div>
			<hr>
			<aui:input name="restrictToEmploymentStatus" type="checkbox"
				label="Employment Status"></aui:input>
			<div id="selectedEmploymentStatusDiv">
				<aui:input name="applyToEmploymentStatus" label=""></aui:input>
			</div>
			<hr>
			<aui:input name="restrictToGender" type="checkbox" label="Gender"></aui:input>
			<div id="selectedGenderDiv">
				<aui:input name="applyToFemale" label="Female" type="checkbox"></aui:input>
				<aui:input name="applyToMale" label="Male" type="checkbox"></aui:input>
			</div>
			<hr>
			<aui:input name="restrictToYearsOfService" type="checkbox"
				label="Years of Service"></aui:input>
			<div id="selectedYearsOfStatusDiv">
				<p>Only employees with joined dates and corresponding years of
					service will be allowed to apply for this leave type.</p>
				<aui:input name="applyToFromYears" label="From"></aui:input>
				<aui:input name="applyToToYears" label="To"></aui:input>
			</div>
			<hr>
			<aui:button type="submit" value="Save"></aui:button>
		</aui:form>
	</div>
</div>

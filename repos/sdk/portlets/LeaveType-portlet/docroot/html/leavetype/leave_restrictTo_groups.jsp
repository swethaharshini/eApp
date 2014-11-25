<%@ include file="/html/leavetype/init.jsp"%>
<a href="#" id="cloningGroups">Add Group</a>
<aui:script use="aui-base">
var A=new AUI();
var duplicates=A.one('#cloningGroups');
duplicates.on('click',function(){
var cloneGroupDiv=A.one('#empoyeeGroup');
var divClone=cloneGroupDiv.cloneNode(true);
document.body.appendChild(divClone);
});
</aui:script>
<div class="panel">
	<div class="panel-heading">
		<h3>Employee Groups</h3>
	</div>
	<div class="panel-body">
	<div class="empoyeeGroup" id="empoyeeGroup" >
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
			</div>
	</div>
</div>
<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL var="updateEmpDocuments" name="updateEmpDocuments"></portlet:actionURL>
<aui:script>
var A=new AUI();
A.ready(function(){
window.selectCategory= function(nodeValue)
         {
		var selectedCategoryValue=nodeValue;
		if(selectedCategoryValue=="-1")
		 {
		 alert("Please select a category");
		 }
           };  
     });        
</aui:script>
<aui:script use="aui-form-validator, aui-overlay-context-panel">
var validator1 = new A.FormValidator({
boundingBox: document.<portlet:namespace />add_documents,
rules: {
<portlet:namespace />doc_related_to: {
required: true
}},
fieldStrings: {
<portlet:namespace />doc_related_to: {
required: '<liferay-ui:message key="01_select-doc-category"></liferay-ui:message>'
}
}
});
</aui:script>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#addingDocuments').hide();
  var addButton=A.one('#<portlet:namespace />addNewDocument');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace/>addNewDocument').hide();
   A.one('#<portlet:namespace/>deleteDocument').hide();
   A.one('#addingDocuments').show();
   
   A.all('input[type=text]').set('disabled',false);
   A.all('select').set('disabled',false);
   A.all('input[type=radio]').set('disabled',false);
   });
   var cancelButton=A.one('#<portlet:namespace/>cancelDocumentAdd');
   cancelButton.on('click',function()
   {
   alert("hrllo");
	   A.one('#addingDocuments').hide();
	   A.one('#<portlet:namespace/>addNewDocument').show();
       A.one('#<portlet:namespace/>deleteDocument').show();
   });
  });
</aui:script>
<div id="addingDocuments" class="panel">
	<div class="panel-heading">
		<h3>
			<liferay-ui:message key="01_add-documents"></liferay-ui:message>
		</h3>
	</div>
	<div class="panel-body">
		<aui:form name="add_documents" id="add_documents"
			enctype="multipart/formdata" action="<%=updateEmpDocuments%>">
			<aui:input name="doc_emp" type="hidden"></aui:input>
			<aui:select name="doc_related_to" id="doc_related_to"
				onChange="javascript:selectCategory(this.value)"
				label="Document Related To">
				<aui:option value="">--Select--</aui:option>
				<aui:option value="Personal Details">Personal Details</aui:option>
				<aui:option value="Contact Details">Contact Details</aui:option>
				<aui:option value="Dependents">Dependents</aui:option>
				<aui:option value="Immigration Details">Immigration Details</aui:option>
				<aui:option value="Reporting Details">Reporting Details</aui:option>
				<aui:option value="Qualification">Qualifications</aui:option>
				<aui:option value="Memberships">Memberships</aui:option>
				<aui:option value="Job History">Job History</aui:option>
				<aui:option value="Salary History">Salary History</aui:option>
				<aui:option value="Direct Deposit">Direct Deposit</aui:option>
			</aui:select>
			<aui:input name="emp_files" type="file" label="Select File"
				showRequiredLabel="false">
				<aui:validator name="required"></aui:validator>
			</aui:input>
			<aui:input name="doc_comments" label="Comments"></aui:input>
			<aui:button type="submit" value="Save" cssClass="button btn-primary"></aui:button>
			<aui:button type="reset" value="Cancel" id="cancelDocumentAdd" cssClass="button btn-danger"></aui:button>
		</aui:form>
	</div>
</div>
<div id="addDeleteDocuments" class="panel">
	<div class="panel-heading">
		<h3>Documents</h3>
	</div>
	<div class="panel-body">
		<aui:button-row>
			<aui:button id="addNewDocument" name="addNewDocument" value="Add"
				cssClass="button btn-primary"></aui:button>
			<aui:button id="deleteDocument" name="deleteDocument" value="Delete"
				cssClass="button btn-danger"></aui:button>
		</aui:button-row>
	</div>
</div>
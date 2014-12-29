<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateContactDetails"
	var="updateContactDetails" ></portlet:actionURL>
	<portlet:resourceURL var="deleteEmergencyContact" id="deleteEmergencyContact"></portlet:resourceURL>
	<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/employee/edit_employee.jsp"/>
	</portlet:renderURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#emergencyContactAdd').hide();
  });
   var addButton=A.one('#<portlet:namespace />emgContactAdd');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace/>emgContactAdd').hide();
   A.one('#<portlet:namespace/>emgContactDelete').hide();
   A.one('#emergencyContactAdd').show();
   });
   var cancelButton=A.one('#<portlet:namespace />cancelEmgContacts');
   cancelButton.on('click',
   function()
   {
    A.one('#emergencyContactAdd').hide();
    A.one('#assignedEmergencyContactsAddDelete').show();
     A.one('#<portlet:namespace/>emgContactAdd').show();
   A.one('#<portlet:namespace/>emgContactDelete').show();
   });
</aui:script>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#<portlet:namespace/>emgContactDelete');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
    
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected Emergency contact ?");
		  if(d){
		   var url = '<%=deleteEmergencyContact%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />emgContactIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('deleted successfully');
                   window.location='<%=listview%>';
              },
               failure: function() {
                  
                 }
                }
                 }
                );
		  																		
		  console.log(idArray);
	  
      return true;
  }
  else
    return false;
}             
      }
    );
  }
);
</aui:script>
<%
Map empId = (Map) request.getSession(false).getAttribute(
		"empId");
long employeeId = (Long)empId.get("empId");
String jsp=(String)empId.get("jsp");
long fileEntryId=(Long)empId.get("fileId");
	DynamicQuery emergencyContactsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpEmergencyContact.class,
					PortletClassLoaderUtil.getClassLoader());
	emergencyContactsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpEmergencyContact> emergencyDetails = EmpPersonalDetailsLocalServiceUtil
			.dynamicQuery(emergencyContactsDynamicQuery);
	EmpEmergencyContact empEmergencyContact = null;
%>
<div id="emergencyContactAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Emergency Contact</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmergencyContact" id="addEmergencyContact"
			 method="post" action="<%=updateContactDetails %>">
			 <aui:input name="emgEmpId" value="<%=employeeId %>" type="hidden"></aui:input>
			 <aui:input name="conFileId" value="<%=fileEntryId %>" type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="emg_name" label="01_name" inlineLabel="left" showRequiredLabel="false">
					<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="emg_relationship" label="01_relationship"
						inlineLabel="left" showRequiredLabel="false">
						<aui:validator name="required"></aui:validator>
						</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="emg_hm_telephone" label="01_home-tele"
						inlineLabel="left">
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
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="emg_mobile" label="01_mobile" inlineLabel="left">
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
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="emg_work_telephone" label="01_work-tele"
						inlineLabel="left" >
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
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitEmgDetails"></aui:button>
			<aui:button type="reset" id="cancelEmgContacts" name="cancelEmgContacts"
			value="Cancel" cssClass="button btn-danger"></aui:button>
		</aui:form>
	</div>
</div>
<div id="assignedEmergencyContactsAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Emergency Contacts</h3>
	</div>
	<div class="panel-body">
		<aui:button id="emgContactAdd" name="emgContactAdd" value="Add" 
		cssClass="button btn-primary"></aui:button>
		<aui:button id="emgContactDelete" value="Delete"
			name="emgContactDelete" cssClass="button btn-danger"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for Emergency Contaccts"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpEmergencyContact> emergencyContactDetails = emergencyDetails;
							results = emergencyContactDetails;
							total = emergencyContactDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpEmergencyContact"
				modelVar="id">
				<liferay-ui:search-container-column-text name="01_name" property="name" />
				<liferay-ui:search-container-column-text name="01_relation"
					property="relationship" />
				<liferay-ui:search-container-column-text name="01_home-tele"
					property="homeTelephone" />
				<liferay-ui:search-container-column-text name="01_mobile"
					property="mobile" />
				<liferay-ui:search-container-column-text name="01_work-tele"
					property="workTelephone" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>

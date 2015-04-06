<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateAssignedDependents"
	var="updateAssignedDependents" ></portlet:actionURL>
<portlet:resourceURL var="deleteDependent" id="deleteDependent"></portlet:resourceURL>
	<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/employee/edit_employee.jsp"/>
	</portlet:renderURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#assignedDependentAdd').hide();
  });
   var addButton=A.one('#<portlet:namespace />dependentAdd');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace/>dependentAdd').hide();
   A.one('#<portlet:namespace/>dependentDelete').hide();
   A.one('#assignedDependentAdd').show();
   });
   var cancelButton=A.one('#<portlet:namespace/>cancelDependentDetails');
   cancelButton.on('click',function()
   {
	   A.one('#assignedDependentAdd').hide();
	   A.one('#assignedDependentAddDelete').show();
	   A.one('#<portlet:namespace/>dependentAdd').show();
       A.one('#<portlet:namespace/>dependentDelete').show();
   });
   AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#<portlet:namespace/>dependentDelete');
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
			  var d = confirm("Are you sure you want to delete the selected Dependent record?");
		  if(d){
		   var url = '<%=deleteDependent%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />dependentIds: idArray,  
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
	String dependentName, dependentRelation, dependentDOB;
	DynamicQuery dependentDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpDependent.class,
					PortletClassLoaderUtil.getClassLoader());
	dependentDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpDependent> empDependentDetails = EmpDependentLocalServiceUtil
			.dynamicQuery(dependentDynamicQuery);
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
%>
<div id="assignedDependentAdd" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-dependent"></liferay-ui:message></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addDependent" id="addDependent"
			action="<%=updateAssignedDependents%>" method="post">
			<div class="form-horizontal">
				<aui:input name="empDependentId" value="<%=employeeId %>" type="hidden" />
				<aui:input name="dependentFileId" value="<%=fileEntryId %>" type="hidden" />
				<aui:input name="dependent_name" label="01_name" showRequiredLabel="false"
					 inlineLabel="left">
					 <aui:validator name="required"></aui:validator>
					 </aui:input>
				<aui:input name="dependent_relationship" label="01_relationship"
				inlineLabel="left" showRequiredLabel="false">
				 <aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:input name="dateOfBirth" label="Date of Birth" inlineLabel="left" 
				cssClass="dateEmployee" placeholder="MM/DD/YYYY">
				<!--validation code @vinay -->
					<aui:validator name="custom"
						errorMessage="Date of birth should not be a future date">
				   function(val,fieldNode,ruleValue){
				      var result=false;
				      var dateOfBirth = val;
				      var dateOfBirthSplit=dateOfBirth.split("/");
			          var birthMonth=dateOfBirthSplit[0];
				      var birthDate=dateOfBirthSplit[1];
	                  var birthYear=dateOfBirthSplit[2];
				      var  currentDate= new Date();
				      var currentDateValue=currentDate.getDate();
					  var currentMonth=currentDate.getMonth()+1;
					  var currentYear=currentDate.getFullYear();
					  if(currentYear>birthYear){
					       result=true;
					       return result;
					       }
					       else if(currentYear==birthYear){
					    		if(currentMonth>birthMonth){
					    		   result=true;
					    		   return result;
					    		   }
					    		   else	if(currentMonth==birthMonth){
					    				if(currentDateValue>=birthDate){
					    				       result=true;
					    					   return result;
					    				   }
					    				   else{
					    				      result=false;
					    				      return result;
					    				}
					    		}
					    		else{
					    		  result = false;
					    		  return result;
					    		}
					    	}
					  	    else{
					    	    result= false;
					    	  return result;
					   	}											   
				   }
				 </aui:validator>
				</aui:input>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="save"
							id="submitDependentDetails"></aui:button>
						<aui:button type="reset" value="Cancel" id="cancelDependentDetails"
						cssClass="button btn-danger" name="cancelDependentDetails"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
	<liferay-portlet:renderURL  varImpl="dependentURL">
		<portlet:param name="jsp" value="jsp4"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div id="assignedDependentAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Dependents</h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="dependentAdd" name="dependentAdd" value="Add" 
			cssClass="button btn-primary"></aui:button>
			<aui:button id="dependentDelete" value="Delete" name="dependentDelete"
			cssClass="button btn-danger"></aui:button>
		</div>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpDependent"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>" iteratorURL="<%=dependentURL %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpDependent> dependentDetails = empDependentDetails;
							results =ListUtil.subList(dependentDetails, searchContainer.getStart(),searchContainer.getEnd()) ;
							total = dependentDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpDependent"
				modelVar="id" keyProperty="empDependentId"  rowVar="curRow" >
				<liferay-ui:search-container-column-text name="01_name" property="name" />
				<liferay-ui:search-container-column-text name="01_relation"
					property="relationship" />
					<liferay-ui:search-container-column-text name="Date Of Birth"
					 value='<%=id.getDateOfBirth()!=null?sdf.format(id.getDateOfBirth()):""%>'/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>

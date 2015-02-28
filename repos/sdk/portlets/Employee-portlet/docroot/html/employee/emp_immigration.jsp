<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addImmigrationDetails"
	var="addImmigrationDetails" ></portlet:actionURL>
	<portlet:resourceURL var="deleteImmigrationDetails" id="deleteImmigrationDetails"></portlet:resourceURL>
	<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/employee/edit_employee.jsp"/>
	</portlet:renderURL>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#empImmigrationAdd').hide();
  });
   var addButton=A.one('#<portlet:namespace />immigrationAdd');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace/>immigrationAdd').hide();
   A.one('#<portlet:namespace/>immigrationDelete').hide();
   A.one('#empImmigrationAdd').show();
   });
   var cancelButton=A.one('#<portlet:namespace/>cancelImmigrationDetails');
   cancelButton.on('click',function()
   {
    A.one('#empImmigrationAdd').hide();
    A.one('#empImmigrationAddDelete').show();
    A.one('#<portlet:namespace/>immigrationAdd').show();
   A.one('#<portlet:namespace/>immigrationDelete').show();
   });
   AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#<portlet:namespace/>immigrationDelete');
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
			  var d = confirm("Are you sure you want to delete the selected Immigration Details ?");
		  if(d){
		   var url = '<%=deleteImmigrationDetails%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />immigrationIds: idArray,  
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
	DynamicQuery dependentDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpImmigrationDocument.class,
					PortletClassLoaderUtil.getClassLoader());
	dependentDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpImmigrationDocument> empImmigrationDocument =EmpImmigrationDocumentLocalServiceUtil
			.dynamicQuery(dependentDynamicQuery);
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
%>
<%! public String getIssuedCountry(long id)
{
 if(id!=0)
  {
	 try
	 {
	Nationality nationality=NationalityLocalServiceUtil.getNationality(id);
	return nationality.getName();
	 }catch(PortalException e)
    	 {
	 }catch(SystemException f)
	 {
	     }
	 }
 return "";
}%>
<div id="empImmigrationAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Immigration</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addImmigration" id="addImmigration"
			action="<%=addImmigrationDetails %>" method="post">
			<div class="form-horizontal">
				<aui:input name="empImgId" value="<%=employeeId %>" type="hidden"></aui:input>
				<aui:input name="immiFileId" value="<%=fileEntryId %>" type="hidden"></aui:input>
				<div class="control-group form-inline">
					<label class="ccontrol-label">Document</label>
						<aui:input inlineLabel="right" name="document_type" type="radio"
						value="Passport" label="01_passport"  />
						<aui:input checked="<%=true%>" inlineLabel="right" name="document_type"
						type="radio" value="Visa" label="01_visa"  />
				</div>
				<aui:input name="img_number" label="01_number"
					showRequiredLabel="false" inlineLabel="left">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:input name="img_issued_date" id="img_issued_date"
					label="01_issued-date" cssClass="dateEmployee" inlineLabel="left"  placeholder="MM/DD/YYYY"></aui:input>
				<aui:input name="img_exp_date" id="imgExpDate" label="01_expiry-date"
					inlineLabel="left" cssClass="dateEmployee" placeholder="MM/DD/YYYY">
					<!--validation code @vinay  -->
					<aui:validator name="custom" errorMessage="Expiry date should be greater than Issued date">
				     function(val,fieldNode,ruleValue){
				      var result=false;	
				      var expiryDate =val;
				      var expiryDateSplit = expiryDate.split("/");
    				  var expiryDateVal=expiryDateSplit[1];
					  var expiryMonth=expiryDateSplit[0];
					  var expiryYear=expiryDateSplit[2];
					  var issuedDate= A.one("#<portlet:namespace/>img_issued_date").get('value');
					  var issuedDateSplit=issuedDate.split("/");
					  var issueDate=issuedDateSplit[1];
					  var issueMonth=issuedDateSplit[0];
					  var issueYear=issuedDateSplit[2];
					    if(expiryYear>issueYear){
					        result=true;
					        return result;
					        }
					       else if(expiryYear==issueYear){
					    	
					    		if(expiryMonth>issueMonth){
					    		   result=true;
					    		   return result;
					    		   }
					    		   else	if(expiryMonth==issueMonth){
					    			
					    				if(expiryDateVal>=issueDate){
					    				
					    					   result=true;
					    					   return result;
					    				   }else{
					    				      result=false;
					    				      return result;
					    				   }
					    			}
					    			else{
					    			  result=false;
					    			  return result;
					    			 }
					    	}
					        else{
					    	  resule=false;
					    	  return result;
					    }	  															   
				   }
				</aui:validator>
				</aui:input>
				<aui:input name="eligible_status" label="01_eligible-status"
					inlineLabel="left"></aui:input>
				<aui:select name="issued_by" label="01_issued-by">
				<aui:option value="0">--Select--</aui:option>
					<%
						List l = NationalityLocalServiceUtil.getNationalities(-1, -1);
								Iterator locations = l.iterator();
								while (locations.hasNext()) {
									Nationality locations2 = (Nationality) locations.next();
					%>
					<aui:option value="<%=locations2.getNationalityId()%>"><%=locations2.getName()%></aui:option>
					<%
						}
					%>
				</aui:select>
				<aui:input name="review_date" id="reviewDate" label="01_review-date"
				cssClass="dateEmployee"  placeholder="MM/DD/YYYY"></aui:input>
				<aui:input name="img_comments" type="textarea" label="01_comments"></aui:input>
				<div class="control-group">
				<div class="controls">
					<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitImmigrationDetails"></aui:button>
				<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
				id="cancelImmigrationDetails" name="cancelImmigrationDetails" ></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<liferay-portlet:renderURL  varImpl="emgImmigrationURL">
		<portlet:param name="jsp" value="jsp5"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div id="empImmigrationAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Immigration Records</h3>
	</div>
	<div class="panel-body">
			<div class="control-group">
				<aui:button id="immigrationAdd" name="immigrationAdd" value="Add" cssClass="button btn-primary"></aui:button>
				<aui:button id="immigrationDelete" value="Delete" name="immigrationDelete" cssClass="button btn-danger"></aui:button>
			</div>
			<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpImmigrationDocument"
			deltaConfigurable="true" rowChecker="<%= new RowChecker(renderResponse) %>" iteratorURL="<%=emgImmigrationURL %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpImmigrationDocument> immigrationDetails = empImmigrationDocument;
							results = ListUtil.subList(immigrationDetails,searchContainer.getStart(),searchContainer.getEnd());
							total = immigrationDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpImmigrationDocument"
				modelVar="id" rowVar="curRow" keyProperty="empImmigrationDocumentId">
				<liferay-ui:search-container-column-text name="01_document" property="docType" />
				<liferay-ui:search-container-column-text name="01_number"
					property="docNumber" />
				<liferay-ui:search-container-column-text name="01_issued-by" value="<%= getIssuedCountry(id.getIssuedBy()) %>" />
				<liferay-ui:search-container-column-text name="01_issued-date"
				value='<%=id.getIssuedDate()!=null? sdf.format(id.getIssuedDate()):"" %>'/>
				<liferay-ui:search-container-column-text name="01_expiry-date"
					value='<%=id.getExpiryDate()!=null?sdf.format(id.getExpiryDate()):"" %>' />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>

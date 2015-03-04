<%@page import="com.liferay.portal.PortalException"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addQualifications" var="addWorkExp">
	<portlet:param name="<%=Constants.CMD%>" value="empExperience" />
</portlet:actionURL>
<portlet:actionURL name="addQualifications" var="addEducation">
	<portlet:param name="<%=Constants.CMD%>" value="empEducation" />
</portlet:actionURL>
<portlet:actionURL name="addQualifications" var="addSkills">
	<portlet:param name="<%=Constants.CMD%>" value="empSkills" />
</portlet:actionURL>
<portlet:actionURL name="addQualifications" var="addLanguage">
	<portlet:param name="<%=Constants.CMD%>" value="empLanguage" />
</portlet:actionURL>
<portlet:actionURL name="addQualifications" var="addLicense">
	<portlet:param name="<%=Constants.CMD%>" value="empLicense" />
</portlet:actionURL>
<portlet:resourceURL var="deleteLanguage" id="deleteLanguage"></portlet:resourceURL>
<portlet:resourceURL var="deleteEmpWorkExp" id="deleteEmpWorkExp"></portlet:resourceURL>
<portlet:resourceURL var="deleteLicense" id="deleteLicense"></portlet:resourceURL>
<portlet:resourceURL var="deleteSkill" id="deleteSkill"></portlet:resourceURL>
<portlet:resourceURL var="deleteEducation" id="deleteEducation"></portlet:resourceURL>
<portlet:renderURL var="listview">
 <portlet:param name="mvcPath" value="/html/employee/edit_employee.jsp"/>
</portlet:renderURL>
<%String skillValue,eduValue,licenseValue,lanValue=""; %>
<%!public String getSkillName(long skiId) {
	if(skiId!=0)
	{
		Skill skil = null;
		try {
			skil = SkillLocalServiceUtil.getSkill(skiId);
			return skil.getSkillName();
		} catch (Exception p) {
		}
	}
		return "";	
		}
	public String getEduLevel(long eduId)
	{
		if(eduId!=0)
		{
		Education eduLvl = null;
		try {
			eduLvl = EducationLocalServiceUtil.getEducation(eduId);
			return eduLvl.getEduLevel();
		} catch (Exception p) {
		}
		}
			return "";		
	}
	public String getLicnse(long licId)
	{	
		if(licId!=0)
		{
		License licType = null;
		try {
			licType = LicenseLocalServiceUtil.getLicense(licId);
			return licType.getLicenseName();
		} catch (Exception p) {
		}
		}
		
			return "";
	}
	public String getLnguage(long lanId)
	{	if(lanId!=0)
		{
		Language lan = null;
		try {
			lan = LanguageLocalServiceUtil.getLanguage(lanId);
			return lan.getLanguageName();
		} catch (Exception p) {
		}
		}
		return "";	
	}
	
	%>
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
	DynamicQuery empWrkExpDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpWorkExp.class,
					PortletClassLoaderUtil.getClassLoader());
	empWrkExpDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpWorkExp> empWrkExpDetails = EmpWorkExpLocalServiceUtil
			.dynamicQuery(empWrkExpDynamicQuery);
	DynamicQuery empEducationDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpEducation.class,
					PortletClassLoaderUtil.getClassLoader());
	empEducationDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpEducation> empEducationDetails = EmpEducationLocalServiceUtil
			.dynamicQuery(empEducationDynamicQuery);
	DynamicQuery empSkillDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpSkill.class,
					PortletClassLoaderUtil.getClassLoader());
	empSkillDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpSkill> empSkillDetails = EmpSkillLocalServiceUtil
			.dynamicQuery(empSkillDynamicQuery);
	DynamicQuery empLanguageDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpLanguage.class,
					PortletClassLoaderUtil.getClassLoader());
	empLanguageDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpLanguage> empLanguageDetails = EmpLanguageLocalServiceUtil
			.dynamicQuery(empLanguageDynamicQuery);
	DynamicQuery empLicenseDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpLicense.class,
					PortletClassLoaderUtil.getClassLoader());
	empLicenseDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpLicense> empLicenseDetails = EmpLicenseLocalServiceUtil
			.dynamicQuery(empLicenseDynamicQuery);
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
%>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated,aui-form-validator,liferay-portlet-url">
var A=new AUI();
var deleteButtons;
A.ready(function()
  {
  A.one('#addEmpWorkExp').hide();
  A.one('#addEmployeeEducation').hide();
  A.one('#addEmpSkills').hide();
  A.one('#addEmpLanguage').hide();
  A.one('#addEmpLicense').hide();
  });
   var addExpButton=A.one('#<portlet:namespace />empWorkExpAdd');
   var addEduButton=A.one('#<portlet:namespace />empEducationAdd');
   var addSkillsButton=A.one('#<portlet:namespace />empSkillsAdd');
   var addLanguageButton=A.one('#<portlet:namespace />empLanguageAdd');
   var addLicenseButton=A.one('#<portlet:namespace />empLicenseAdd');
   var cancelExp=A.one('#<portlet:namespace />cancelWorkExp');
   var cancelEdu=A.one('#<portlet:namespace />cancelEducation');
   var cancelSki=A.one('#<portlet:namespace />cancelSkill');
   var cancelLan=A.one('#<portlet:namespace />cancelLanguage');
   var cancelLic=A.one('#<portlet:namespace />cancelLicense');
   addExpButton.on('click',
	   function()
	   {
	    A.one('#<portlet:namespace />empLicenseAdd').hide();
	    A.one('#<portlet:namespace />empLanguageAdd').hide();
	    A.one('#<portlet:namespace />empSkillsAdd').hide();
	    A.one('#<portlet:namespace />empWorkExpAdd').hide();
	    A.one('#<portlet:namespace />empEducationAdd').hide();
	    A.one('#<portlet:namespace />empLicenseDelete').hide();
	    A.one('#<portlet:namespace />empLanguageDelete').hide();
	    A.one('#<portlet:namespace />empSkillsDelete').hide();
	    A.one('#<portlet:namespace />empWorkExpDelete').hide();
	    A.one('#<portlet:namespace />empEducationDelete').hide();
	    A.one('#addEmpWorkExp').show();
	   });
   addEduButton.on('click',
   function()
	   {
	    A.one('#<portlet:namespace />empLicenseAdd').hide();
	    A.one('#<portlet:namespace />empLanguageAdd').hide();
	    A.one('#<portlet:namespace />empSkillsAdd').hide();
	    A.one('#<portlet:namespace />empWorkExpAdd').hide();
	    A.one('#<portlet:namespace />empEducationAdd').hide();
	    A.one('#<portlet:namespace />empLicenseDelete').hide();
	    A.one('#<portlet:namespace />empLanguageDelete').hide();
	    A.one('#<portlet:namespace />empSkillsDelete').hide();
	    A.one('#<portlet:namespace />empWorkExpDelete').hide();
	    A.one('#<portlet:namespace />empEducationDelete').hide();
	    A.one('#addEmployeeEducation').show();
	   });
   addSkillsButton.on('click',
   function()
	   {
	    A.one('#<portlet:namespace />empLicenseAdd').hide();
	    A.one('#<portlet:namespace />empLanguageAdd').hide();
	    A.one('#<portlet:namespace />empSkillsAdd').hide();
	    A.one('#<portlet:namespace />empWorkExpAdd').hide();
	    A.one('#<portlet:namespace />empEducationAdd').hide();
	    A.one('#<portlet:namespace />empLicenseDelete').hide();
	    A.one('#<portlet:namespace />empLanguageDelete').hide();
	    A.one('#<portlet:namespace />empSkillsDelete').hide();
	    A.one('#<portlet:namespace />empWorkExpDelete').hide();
	    A.one('#<portlet:namespace />empEducationDelete').hide();
	    A.one('#addEmpSkills').show();
	   });
   addLanguageButton.on('click',
   function()
	   {
	    A.one('#<portlet:namespace />empLicenseAdd').hide();
	    A.one('#<portlet:namespace />empLanguageAdd').hide();
	    A.one('#<portlet:namespace />empSkillsAdd').hide();
	    A.one('#<portlet:namespace />empWorkExpAdd').hide();
	    A.one('#<portlet:namespace />empEducationAdd').hide();
	    A.one('#<portlet:namespace />empLicenseDelete').hide();
	    A.one('#<portlet:namespace />empLanguageDelete').hide();
	    A.one('#<portlet:namespace />empSkillsDelete').hide();
	    A.one('#<portlet:namespace />empWorkExpDelete').hide();
	    A.one('#<portlet:namespace />empEducationDelete').hide();
	    A.one('#addEmpLanguage').show();
	   });
   addLicenseButton.on('click',
   function()
	   {
	   A.one('#<portlet:namespace />empLicenseAdd').hide();
	   A.one('#<portlet:namespace />empLanguageAdd').hide();
	   A.one('#<portlet:namespace />empSkillsAdd').hide();
	   A.one('#<portlet:namespace />empWorkExpAdd').hide();
	   A.one('#<portlet:namespace />empEducationAdd').hide();
	   A.one('#<portlet:namespace />empLicenseDelete').hide();
	   A.one('#<portlet:namespace />empLanguageDelete').hide();
	   A.one('#<portlet:namespace />empSkillsDelete').hide();
	   A.one('#<portlet:namespace />empWorkExpDelete').hide();
	   A.one('#<portlet:namespace />empEducationDelete').hide();
	   A.one('#addEmpLicense').show();
	   });
   cancelExp.on('click',
   function()
	   {
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
   cancelEdu.on('click',
   function()
	   {
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
   cancelSki.on('click',
   function()
	   { 
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
   cancelLan.on('click',
   function()
	   {
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
   cancelLic.on('click',
   function()
	   {
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
window.deleteFunction=function(documentId)
   {
  	 var url;
     var idArray = [];
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
        });
      if(documentId.match("empWorkExpDelete"))
    	  {
          url='<%=deleteEmpWorkExp %>';
    	  }
      else if(documentId.match("empLanguageDelete"))
    	  {
    	  url='<%=deleteLanguage %>';
    	  }
      else if(documentId.match("empLicenseDelete"))
		  {
		  url='<%=deleteLicense %>';
		  }
      else if(documentId.match("empEducationDelete"))
		  {
		  url='<%=deleteEducation %>';
		  }
      else if(documentId.match("empSkillsDelete"))
		  {
		  url='<%=deleteSkill %>';
		  }
      else
    	  {
    	  alert("not matched");
    	  }
       if(idArray==""){
 			  alert("Please select records!");
 		  }else{
 			  var d = confirm("Are you sure you want to delete the selected Dependent record?");
		     if(d){
		          A.io.request(url,
		          {
		          data: {  
		                <portlet:namespace />deleteIds: idArray,  
		                 },
		          on: {
		               success: function() { 
		                   alert('deleted successfully');
		                   window.location='<%=listview%>';
		              },
		               failure: function() {
		                         }
		              }
		              });
		 		  																		
		 		  console.log(idArray);
		 	  
		          return true;
		        }
		      else
		          return false;
				}             
     };
   var validator1 = new A.FormValidator({
		 boundingBox: document.<portlet:namespace />addEmpLan,
		   rules: {
		         <portlet:namespace />lan_skill:{
		          required: true
		          }},
		   fieldStrings: {
		         <portlet:namespace />lan_skill: {
		         required: 'Please select employee skill'
		          }},
		 });
   var validator1 = new A.FormValidator({
		
	    boundingBox: document.<portlet:namespace />addEmpLan,
	  
	    rules: {
            <portlet:namespace />lan_fluency:{
           required: true
	 	      }},
	   fieldStrings: {
		   <portlet:namespace />lan_fluency: {
	       required: 'Please select employee fluency'
	          }}, 
	          
	 });
   var validator1 = new A.FormValidator({
		
       boundingBox: document.<portlet:namespace />addEmpLan,
	   rules: {
	         <portlet:namespace />emp_language:{
	          required: true
	          }},
	   fieldStrings: {
	         <portlet:namespace />emp_language: {
	         required: 'Please select employee language'
	          }},
     });
</aui:script>
<%-- validation and delete operation code @vinay --%>
<div id="addEmpWorkExp" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-work-experience"/></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addWorkExperience" id="addWorkExperience"
			action="<%=addWorkExp%>" method="post">
			<div class="form-horizontal">
				<aui:input name="empWrkExpId" value="<%=employeeId%>" type="hidden"></aui:input>
				<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:input name="exp_company" label="01_company" inlineLabel="left"
					showRequiredLabel="false">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:input name="exp_jobtitle" label="01_jobtitle" inlineLabel="left"
					showRequiredLabel="false">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:input name="exp_from_date" id="exp_from_date" label="01_from" inlineLabel="left"
					cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
				<aui:input name="exp_to_date" id="exp_to_date" label="01_to" inlineLabel="left"
					cssClass="dateEmployee" placeholder="MM/DD/YYYY">
			    <aui:validator name="custom" errorMessage="To date should be greater than from date">
				 function(val,fieldNode,ruleValue){
				      var result=false;	
				      var toDate =val;
				      var expiryDateSplit = toDate.split("/");
   					  var toDateVal=expiryDateSplit[1];
					  var toMonth=expiryDateSplit[0];
					  var toYear=expiryDateSplit[2];
					  var fromDate= A.one("#<portlet:namespace/>exp_from_date").get('value');
					  var fromDateSplit=fromDate.split("/");
					  var from1Date=fromDateSplit[1];
					  var fromMonth=fromDateSplit[0];
					  var fromYear=fromDateSplit[2];
					  if(Number(toYear)>Number(fromYear)){
					        result=true;
					        return result;
					        }
					       else if(Number(toYear)==Number(fromYear)){
					    		if(Number(toMonth)>Number(fromMonth)){
					    		   result=true;
					    		   return result;
					    		   }
					    		   else	if(Number(toMonth)==Number(fromMonth)){
					    				if(Number(toDateVal)>=Number(from1Date)){
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
					    	  result=false;
					    	  return result;
					    }	  															   
				   }
				</aui:validator>  
				</aui:input>
				<aui:input name="exp_comments" type="textarea" label="01_comments"
					inlineLabel="left"></aui:input>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="save"
							id="submitExpDetails"></aui:button>
						<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
							id="cancelWorkExp" name="cancelWorkExp"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<div id="empWorkExpAddDelete" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_work-experience" /></h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="empWorkExpAdd" name="empWorkExpAdd" value="Add"
				cssClass="button btn-primary"></aui:button>
			<aui:button id="empWorkExpDelete" value="Delete" onClick="javascript:deleteFunction(this.id);"
				name="empWorkExpDelete" cssClass="button btn-danger deleteRecord"></aui:button>
		</div>
	<liferay-portlet:renderURL  varImpl="qualificationURL">
		<portlet:param name="jsp" value="jsp7"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpWorkExp"
			deltaConfigurable="true"
			rowChecker="<%=new RowChecker(renderResponse)%>" iteratorURL="<%=qualificationURL %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpWorkExp> workExpList = empWrkExpDetails;
							results =ListUtil.subList( workExpList, searchContainer.getStart(), searchContainer.getEnd());
							total = workExpList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpWorkExp"
				modelVar="id" keyProperty="empWorkExpId" rowVar="curRow">
				<liferay-ui:search-container-column-text name="01_company" property="company" />
				<liferay-ui:search-container-column-text name="01_jobtitle" property="jobTitle" />
				<liferay-ui:search-container-column-text name="01_from" value='<%=id.getFromDate()!=null?sdf.format(id.getFromDate()):"" %>'/>
				<liferay-ui:search-container-column-text name="01_to" value='<%=id.getToDate()!=null?sdf.format(id.getToDate()):"" %>'/>
				<liferay-ui:search-container-column-text name="01_comment" property="comment"/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="addEmployeeEducation" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-education"/></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpEducation" id="addEmpEducation" action="<%=addEducation%>" method="post">
			<div class="form-horizontal">
				<aui:input name="empEduId" value="<%=employeeId%>" type="hidden"></aui:input>
				<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:select name="edu_level" label="01_level" inlineLabel="left"
					showRequiredLabel="false">
				<aui:option value="0">--Select--</aui:option>
				<%
				List<Education> eduList = EducationLocalServiceUtil.getEducations(-1, -1);
						Iterator eduLevels = eduList.iterator();
						while (eduLevels.hasNext()) {
							Education educationLevel = (Education) eduLevels.next();
				%>
				<aui:option value="<%=educationLevel.getEducationId()%>">
				<%=educationLevel.getEduLevel()%></aui:option>
				<%
				}
				%>
				</aui:select>
				<aui:input name="edu_institute" label="01_institute"
					inlineLabel="left">
				</aui:input>
				<aui:input name="edu_major" label="01_specialization"
					inlineLabel="left"></aui:input>
				<aui:input name="edu_year" label="01_year" inlineLabel="left">
				</aui:input>
				<aui:input name="edu_score" label="01_score" inlineLabel="left"></aui:input>
				<aui:input name="edu_from_date" label="01_from" inlineLabel="left"
					cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
				<aui:input name="edu_to_date" label="01_to" inlineLabel="left"
					cssClass="dateEmployee" placeholder="MM/DD/YYYY">
				<aui:validator name="custom" errorMessage="To date should be greater than from date">
				 function(val,fieldNode,ruleValue){
				      var result=false;	
				      var toDate =val;
				      var expiryDateSplit = toDate.split("/");
   					  var toDateVal=expiryDateSplit[1];
					  var toMonth=expiryDateSplit[0];
					  var toYear=expiryDateSplit[2];
					  var fromDate= A.one("#<portlet:namespace/>edu_from_date").get('value');
					  var fromDateSplit=fromDate.split("/");
					  var from1Date=fromDateSplit[1];
					  var fromMonth=fromDateSplit[0];
					  var fromYear=fromDateSplit[2];
					  if(toYear>fromYear){
					        result=true;
					        return result;
					        }
					       else if(toYear==fromYear){
					    		if(toMonth>fromMonth){
					    		   result=true;
					    		   return result;
					    		   }
					    		   else	if(toMonth==fromMonth){
					    				if(toDateVal>=from1Date){
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
					    	  result=false;
					    	  return result;
					    }	  															   
				   }
				</aui:validator>
					</aui:input>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="save"
							id="submitEduDetails"></aui:button>
						<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
							id="cancelEducation" name="cancelEducation"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
</div>
</div>
<liferay-portlet:renderURL  varImpl="educationURL">
		<portlet:param name="jsp" value="jsp7"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div id="empEducationAddDelete" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_education" /></h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="empEducationAdd" name="empEducationAdd" value="Add" cssClass="button btn-primary"></aui:button>
			<aui:button id="empEducationDelete" value="Delete" name="empEducationDelete"
			 cssClass="button btn-danger deleteRecord" onClick="javascript:deleteFunction(this.id);"></aui:button>
		</div>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpEducation"
			deltaConfigurable="true"
			rowChecker="<%=new RowChecker(renderResponse)%>" iteratorURL="<%=educationURL %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpEducation> educationList = empEducationDetails;
							results = ListUtil.subList(educationList, searchContainer.getStart(), searchContainer.getEnd());
							total = educationList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpEducation"
				modelVar="id" keyProperty="empEducationId" rowVar="curRow">
				<% eduValue=getEduLevel(id.getEducationId())!=null?getEduLevel(id.getEducationId()):""; %>
				<liferay-ui:search-container-column-text name="01_level" 
				value='<%= eduValue %>' />
				<liferay-ui:search-container-column-text name="01_year" property="year"/>
				<liferay-ui:search-container-column-text name="01_score" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="addEmpSkills" class="panel">
	<div class="panel-heading">
		<h3>Add Skill</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpSkill" id="addEmpSkill" action="<%=addSkills%>"
			method="post">
			<div class="form-horizontal">
				<aui:input name="empSkillId" value="<%=employeeId%>" type="hidden"></aui:input>
				<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:select name="emp_skill" label="01_level" inlineLabel="left"
					showRequiredLabel="false">
				<%
				List<Skill> skillList = SkillLocalServiceUtil.getSkills(-1,
								-1);
						Iterator skillList2 = skillList.iterator();
						while (skillList2.hasNext()) {
							Skill skill = (Skill) skillList2.next();
				%>
				<aui:option value="<%=skill.getSkillId()%>"
				><%=skill.getSkillName()%></aui:option>
				<%
				}
				%>
				</aui:select>
				<aui:input name="skill_exp" label="01_years-of-exp"
					inlineLabel="left">
				</aui:input>
				<aui:input type="textarea" name="skill_comments" label="01_comments"
					inlineLabel="left"></aui:input>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="save"
							id="submitEmpSkills"></aui:button>
						<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
							id="cancelSkill" name="cancelSkill" ></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<liferay-portlet:renderURL  varImpl="skillURL">
		<portlet:param name="jsp" value="jsp7"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div id="empSkillsAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Skills</h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
		<aui:button id="empSkillsAdd" name="empSkillsAdd" value="Add"
			cssClass="button btn-primary"></aui:button>
		<aui:button id="empSkillsDelete" value="Delete" name="empSkillsDelete"
			cssClass="button btn-danger deleteRecord" onClick="javascript:deleteFunction(this.id);"></aui:button>
		</div>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpSkill"
			deltaConfigurable="true"
			rowChecker="<%= new RowChecker(renderResponse) %>" iteratorURL="<%=skillURL %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpSkill> skillList = empSkillDetails;
							results = ListUtil.subList(skillList, searchContainer.getStart(), searchContainer.getEnd());
							total = skillList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpSkill" keyProperty="empSkillId"
				modelVar="id" rowVar="curRow">
				<%skillValue=getSkillName(id.getSkillId())!=null?getSkillName(id.getSkillId()):"" ; %>
				<liferay-ui:search-container-column-text name="01_skill" 
				value='<%= skillValue %>'/>
				<liferay-ui:search-container-column-text name="01_years-of-exp" property="years"/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="addEmpLanguage" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-language" /></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpLan" id="addEmpLan" action="<%=addLanguage%>"
			method="post">
			<div class="form-horizontal">
				<aui:input name="empLanId" value="<%=employeeId%>" type="hidden"></aui:input>
				<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:select name="emp_language" label="01_language" inlineLabel="left"
					showRequiredLabel="false">
			    <aui:option value="">--select--</aui:option>
				<%
				List<Language> languageList = LanguageLocalServiceUtil
								.getLanguages(-1, -1);
						Iterator languageList2 = languageList.iterator();
						while (languageList2.hasNext()) {
							Language language = (Language) languageList2.next();
				%>
				<aui:option value="<%=language.getLanguageId()%>"
				><%=language.getLanguageName()%></aui:option>
				<%
				}
				%>
				</aui:select>
				<aui:select name="lan_skill" label="01_skill" inlineLabel="left"
					showRequiredLabel="false">
			    <aui:option value="">--select--</aui:option>
				<aui:option value="writing">Writing</aui:option>
				<aui:option value="reading">Reading</aui:option>
				<aui:option value="speaking">Speaking</aui:option>
				</aui:select>
				<aui:select name="lan_fluency" label="01_fluency-level"
					inlineLabel="left" showRequiredLabel="false">
				<aui:option value="">--select--</aui:option>
				<aui:option value="poor">Poor</aui:option>
				<aui:option value="basic">Basic</aui:option>
				<aui:option value="good">Good</aui:option>
				<aui:option value="mother">Mother Tongue</aui:option>
				</aui:select>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="save"
						id="submitLanguage"></aui:button>
						<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
							id="cancelLanguage" name="cancelLanguage"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<liferay-portlet:renderURL  varImpl="languageURL">
		<portlet:param name="jsp" value="jsp7"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div id="empLanguageAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Language</h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="empLanguageAdd" name="empLanguageAdd" value="Add"
				cssClass="button btn-primary"></aui:button>
			<aui:button id="empLanguageDelete" value="Delete" onClick="javascript:deleteFunction(this.id);"
				name="empLanguageDelete" cssClass="button btn-danger deleteRecord"></aui:button>
		</div>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpLanguage"
			deltaConfigurable="true"
			rowChecker="<%=new RowChecker(renderResponse)%>" iteratorURL="<%=languageURL %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpLanguage> languageList = empLanguageDetails;
							results = ListUtil.subList(languageList, searchContainer.getStart(), searchContainer.getEnd());
							total = languageList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpLanguage"
				modelVar="id" keyProperty="empLanguageId" rowVar="curRow">
				<%lanValue=getLnguage(id.getLanguageId())!=null?getLnguage(id.getLanguageId()):"" ; %>
				<liferay-ui:search-container-column-text  name="01_language" 
				value='<%=lanValue %>'/>
				<liferay-ui:search-container-column-text name="01_skill" property="languageSkill" />
				<liferay-ui:search-container-column-text name="01_fluency-level" property="languageFluency"/>
				<liferay-ui:search-container-column-text name="01_comments" property="comments" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="addEmpLicense" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-license" /></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpLicen" id="addEmpLicen" action="<%=addLicense%>"
			method="post">
			<div class="form-horizontal">
				<aui:input name="empLicId" value="<%=employeeId%>" type="hidden"></aui:input>
				<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:select name="emp_license_type" label="01_license-type"
					inlineLabel="left" showRequiredLabel="false">
				<%
				List<License> licenseList = LicenseLocalServiceUtil
								.getLicenses(-1, -1);
						Iterator licenseList2 = licenseList.iterator();
						while (licenseList2.hasNext()) {
							License license = (License) licenseList2.next();
				%>
				<aui:option value="<%=license.getLicenseId()%>"
				><%=license.getLicenseName()%></aui:option>
				<%
				}
				%>
				</aui:select>
				<aui:input name="emp_license_no" label="01_license-number"
					inlineLabel="left">
				</aui:input>
				<aui:input name="license_issue_date" label="01_license-issue-date"
					inlineLabel="left" cssClass="dateEmployee" placeholder="MM/DD/YYYY"></aui:input>
				<aui:input name="license_exp_date" label="01_license-expiry-date"
					inlineLabel="left" cssClass="dateEmployee" placeholder="MM/DD/YYYY">
				 <aui:validator name="custom" errorMessage="Expiry date should be greater than Issued date">
				     function(val,fieldNode,ruleValue){
				      var result=false;	
				      var expiryDate =val;
				      var expiryDateSplit = expiryDate.split("/");
					  var expiryDateVal=expiryDateSplit[1];
					  var expiryMonth=expiryDateSplit[0];
					  var expiryYear=expiryDateSplit[2];
					  var issuedDate= A.one("#<portlet:namespace/>license_issue_date").get('value');
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
					    	  result=false;
					    	  return result;
					    }	  															   
				   }
				   </aui:validator> 
				</aui:input>
				<div class="control-group">
					<div class="controls">
					<aui:button type="submit" cssClass="button btn-primary" value="save"
						id="submitLicenseDetails"></aui:button>
					<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
						id="cancelLicense" name="cancelLicense"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<liferay-portlet:renderURL  varImpl="licenseURL">
		<portlet:param name="jsp" value="jsp7"/>
		<portlet:param name="empId" value="<%=String.valueOf(employeeId) %>" />
		<portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
		</liferay-portlet:renderURL>
<div id="empLicenseAddDelete" class="panel">
	<div class="panel-heading">
		<h3>License</h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="empLicenseAdd" name="empLicenseAdd" value="Add"
				cssClass="button btn-primary"></aui:button>
			<aui:button id="empLicenseDelete" value="Delete" onClick="javascript:deleteFunction(this.id);"
				name="empLicenseDelete" cssClass="button btn-danger deleteRecord"></aui:button>
		</div>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpLicense"
			deltaConfigurable="true"
			rowChecker="<%= new RowChecker(renderResponse) %>" iteratorURL="<%=licenseURL%>">
			<liferay-ui:search-container-results>
				<%
					List<EmpLicense> licenseList = empLicenseDetails;
							results = ListUtil.subList(licenseList, searchContainer.getStart(), searchContainer.getEnd());
							total = licenseList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpLicense"
				modelVar="id" keyProperty="empLicenseId" rowVar="curRow">
				<%licenseValue=getLicnse(id.getLicenseId())!=null?getLicnse(id.getLicenseId()):""; %>
				<liferay-ui:search-container-column-text name="01_license-type" 
				value='<%=licenseValue  %>'/>
				<liferay-ui:search-container-column-text name="01_issued-date" value='<%=id.getIssuedDate()!=null?sdf.format(id.getIssuedDate()):""%>'/>
				<liferay-ui:search-container-column-text name="01_expiry-date"  value='<%=id.getExpiryDate() !=null?sdf.format(id.getExpiryDate() ):""%>' />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
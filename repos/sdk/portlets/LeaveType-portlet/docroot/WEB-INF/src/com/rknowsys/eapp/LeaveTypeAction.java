package com.rknowsys.eapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;
import com.rknowsys.eapp.hrm.model.JobCategory;
import com.rknowsys.eapp.hrm.model.JobTitle;
import com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy;
import com.rknowsys.eapp.hrm.model.LeaveGeneral;
import com.rknowsys.eapp.hrm.model.LeavePeriod;
import com.rknowsys.eapp.hrm.model.LeaveRuleApplicable;
import com.rknowsys.eapp.hrm.model.LeaveType;
import com.rknowsys.eapp.hrm.model.LeaveTypeEmployeeGroups;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveGeneralLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeavePeriodLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveRestrictionLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveRuleApplicableLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveTypeEmployeeGroupsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveTypeLocalServiceUtil;
import com.rknowsys.eapp.hrm.model.LeaveRestriction;

public class LeaveTypeAction extends MVCPortlet{
	private static Logger log = Logger.getLogger(LeaveTypeAction.class);
	
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		log.info("in serveResource method");
		 PrintWriter out = resourceResponse.getWriter();
		 if(resourceRequest.getResourceID().equals("getEmploymentStatus"))
			{
			 log.info("Entered Method.....getEmploymentStatus");
			 System.out.println("in serve resource of multi auto complete");
			  //This method gets the user entered text from ajax request and sends
			  //JSON response data for auto completing the input field
		       List<EmploymentStatus> employmentstatusList=null;
			   try {
				   employmentstatusList= EmploymentStatusLocalServiceUtil.getEmploymentStatuses(0,EmploymentStatusLocalServiceUtil.getEmploymentStatusesCount());
						} catch (SystemException e) {
							e.printStackTrace();
						}
			   if(employmentstatusList!=null)
			   {
				 String userEnteredText=ParamUtil.getString(resourceRequest, "empstatusText");
				 String userEnteredTextId=ParamUtil.getString(resourceRequest, "empstatusValue");
				 System.out.println("ids of the user entered text is"+userEnteredText+" "+userEnteredTextId);
				 JSONArray usersJSONArray = JSONFactoryUtil.createJSONArray();
				 DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(EmploymentStatus.class,PortletClassLoaderUtil.getClassLoader());
				 Criterion criterion = RestrictionsFactoryUtil.like("employmentstatus", StringPool.PERCENT);
				 userQuery.add(criterion);
				 JSONObject userJSON = null;
				 try {
					 List<EmploymentStatus> empstatusList = EmploymentStatusLocalServiceUtil.dynamicQuery(userQuery);
					 for (EmploymentStatus employmentstatusDetails : empstatusList) {
					 userJSON = JSONFactoryUtil.createJSONObject();
					 userJSON.put("employmentstatus", employmentstatusDetails.getEmploymentstatus());
					 userJSON.put("employmentstatusId", employmentstatusDetails.getEmploymentStatusId());
					 System.out.println(employmentstatusDetails.getEmploymentstatus());
					 System.out.println(employmentstatusDetails.getEmploymentStatusId());
					 usersJSONArray.put(userJSON);
					 }
					 } catch (Exception e) {
				 }
				 out.println(usersJSONArray.toString());
				}
			 
			}
		 
		 
		 
		 
		 
		 if(resourceRequest.getResourceID().equals("getJobcategories"))
			{
			 log.info("Entered Method.....");
			 System.out.println("in serve resource of multi auto complete");
			  //This method gets the user entered text from ajax request and sends
			  //JSON response data for auto completing the input field
		       List<JobCategory> jobCategoryList=null;
			   try {
				   jobCategoryList= JobCategoryLocalServiceUtil.getJobCategories(-1, -1);
						} catch (SystemException e) {
							e.printStackTrace();
						}
			   if(jobCategoryList!=null)
			   {
				 String userEnteredText=ParamUtil.getString(resourceRequest, "jobCategoryText");
				 String userEnteredTextId=ParamUtil.getString(resourceRequest, "jobCategoryValue");
				 System.out.println("ids of the user entered text is"+userEnteredText+" "+userEnteredTextId);
				 JSONArray usersJSONArray = JSONFactoryUtil.createJSONArray();
				 DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(JobCategory.class,PortletClassLoaderUtil.getClassLoader());
				 Criterion criterion = RestrictionsFactoryUtil.like("jobcategory", StringPool.PERCENT);
				 userQuery.add(criterion);
				 JSONObject userJSON = null;
				 try {
					 List<JobCategory> jobcategoryList = JobCategoryLocalServiceUtil.dynamicQuery(userQuery);
					 for (JobCategory jobcategoryDetails : jobcategoryList) {
					 userJSON = JSONFactoryUtil.createJSONObject();
					 userJSON.put("jobcategory", jobcategoryDetails.getJobcategory());
					 userJSON.put("jobCategoryId", jobcategoryDetails.getJobCategoryId());
					 System.out.println(jobcategoryDetails.getJobcategory());
					 System.out.println(jobcategoryDetails.getJobCategoryId());
					 usersJSONArray.put(userJSON);
					 }
					 } catch (Exception e) {
				 }
				 out.println(usersJSONArray.toString());
				}
			 
			}
		 
		 
		if(resourceRequest.getResourceID().equals("deleteLeaveType"))
		{
			//This method deletes the leave type records or record from leave_type table based on the id received 
		    //from the ajax request.
			long[] leaveTypeIds=ParamUtil.getLongValues(resourceRequest, "leaveTypeIds");
			log.info("length of the leave type array is"+leaveTypeIds.length);
			for(int i=0;i<leaveTypeIds.length;i++)
			{
			try {
				LeaveTypeLocalServiceUtil.deleteLeaveType(leaveTypeIds[i]);
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				} catch (NumberFormatException n){
					log.info("All records selected"+n.getMessage());
				}
				
			}
		}
		if (resourceRequest.getResourceID().equals("getJobTitles"))
		{
		  System.out.println("in serve resource of multi auto complete");
		  //This method gets the user entered text from ajax request and sends
		  //JSON response data for auto completing the input field
	       List<JobTitle> jobTitleList=null;
		   try {
				jobTitleList=JobTitleLocalServiceUtil.getJobTitles(-1, -1);
					} catch (SystemException e) {
						e.printStackTrace();
					}
		   if(jobTitleList!=null)
		   {
			 String userEnteredText=ParamUtil.getString(resourceRequest, "userEnteredText");
			 String userEnteredTextId=ParamUtil.getString(resourceRequest, "idOfEnteredValue");
			 System.out.println("ids of the user entered text is"+userEnteredText+" "+userEnteredTextId);
			 JSONArray usersJSONArray = JSONFactoryUtil.createJSONArray();
			 DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(JobTitle.class,PortletClassLoaderUtil.getClassLoader());
			 Criterion criterion = RestrictionsFactoryUtil.like("title",StringPool.PERCENT );
			 userQuery.add(criterion);
			 JSONObject userJSON = null;
			 try {
				 List<JobTitle> userList = JobTitleLocalServiceUtil.dynamicQuery(userQuery);
				 for (JobTitle personalDetails : userList) {
				 userJSON = JSONFactoryUtil.createJSONObject();
				 userJSON.put("title", personalDetails.getTitle());
				 userJSON.put("id", personalDetails.getJobTitleId());
				 System.out.println(personalDetails.getTitle());
				 System.out.println(personalDetails.getJobTitleId());
				 usersJSONArray.put(userJSON);
				 }
				 } catch (Exception e) {
			 }
			 out.println(usersJSONArray.toString());
			}
		 }
		
		
	}
		
	
	public void addOrUpdateLeaveType(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		 Date date = new Date();
		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//This method inserts or updates a record in leave_type table
		
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		long nationalityId=ParamUtil.getLong(actionRequest, "nationalityId");
		boolean isSituational=ParamUtil.getBoolean(actionRequest, "isSituational");
		log.info("IsSituational........."+isSituational);
		String leaveTypeName=ParamUtil.getString(actionRequest,"leaveTypeName" );
		LeaveType leaveType=null;
		if(leaveTypeId!=0)
		{ 
			log.info("updating leave type");
			try {
				leaveType=LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			leaveType.setCompanyId(themeDisplay.getCompanyId());
			leaveType.setGroupId(themeDisplay.getCompanyGroupId());
			leaveType.setUserId(themeDisplay.getUserId());
			
			leaveType.setModifiedDate(date);
			leaveType.setLeaveTypeName(leaveTypeName);
			leaveType.setIsSituational(isSituational);
			leaveType.setNationalityId(nationalityId);
			try {
				LeaveTypeLocalServiceUtil.updateLeaveType(leaveType);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		else
		{
			log.info("inserting a leave type record");
			try {
				leaveType=LeaveTypeLocalServiceUtil.createLeaveType(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			leaveType.setCompanyId(themeDisplay.getCompanyId());
			leaveType.setGroupId(themeDisplay.getCompanyGroupId());
			leaveType.setUserId(themeDisplay.getUserId());
			
			leaveType.setCreateDate(date);
			leaveType.setModifiedDate(date);
			
			
			leaveType.setLeaveTypeName(leaveTypeName);
			leaveType.setIsSituational(isSituational);
			leaveType.setNationalityId(nationalityId);
			try {
				LeaveTypeLocalServiceUtil.addLeaveType(leaveType);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/list_leaveType.jsp");
	}
	public void editLeaveType(ActionRequest actionRequest,ActionResponse actionResponse)
	{   
		//receives the primary key of the selected row and sets the corresponding LeaveType object in session
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		LeaveType leaveType=null;
		try {
			 leaveType=LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		actionRequest.getPortletSession(true).setAttribute("editLeaveType", 
				leaveType,PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/edit_leaveType.jsp");
	}
	/*
	 * This method gets the LeaveType object from search container and inserts or updates 
	 * Leave Information like leave_general,leave_restriction,leaveRuleApplicable,leave_type_applicability,leave_carryForward_policy
	 * This methods updates or inserts the records in the above tables
	 */
	public void editLeaveRule(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException
	{
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		log.info("leave type id is"+leaveTypeId);
		LeaveGeneral leaveGeneral=null;
		LeaveRestriction leaveRestriction=null;
		LeaveType leaveType=null;
		List<LeaveGeneral> leaveGeneralList=null;
			try {
				leaveType=LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
				leaveGeneralList=LeaveGeneralLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
		if(leaveGeneral!=null && leaveGeneralList.size()!=0)
		{
			leaveGeneral=leaveGeneralList.get(0);
		}
		List<LeaveRestriction> leaveRestrictionList=null;
		try {
			leaveRestrictionList=LeaveRestrictionLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
			log.info("leaveRestrictionList =========" +leaveRestrictionList);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		if(leaveRestrictionList!=null && leaveRestrictionList.size()!=0)
		{
			leaveRestriction=leaveRestrictionList.get(0);
		}
		Map leaveInfo=setSessionForLeaveInfo(leaveTypeId);
		
		actionRequest.getPortletSession(true).setAttribute("leaveInfo",leaveInfo,PortletSession.APPLICATION_SCOPE);
		
		log.info(leaveType);
		
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
	}
	/*
	 * This method inserts or updates the records in leave_general table
	 */
	public void saveOrUpdateLeaveGeneral(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		log.info("in saveOrUpdateLeaveGeneral method");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String leaveGeneralId=ParamUtil.getString(actionRequest,"leaveGeneralId");
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		
		try {
			
		if(leaveGeneralId ==null || leaveGeneralId.equals("") || leaveGeneralId=="")
		{
			LeaveGeneral leaveGeneral=LeaveGeneralLocalServiceUtil.createLeaveGeneral(CounterLocalServiceUtil.increment());
			
			insertOrUpdateLeaveGeneralValues(leaveGeneral, actionRequest);
		
				leaveGeneral.setCompanyId(themeDisplay.getCompanyId());
				leaveGeneral.setGroupId(themeDisplay.getCompanyGroupId());
				leaveGeneral.setUserId(themeDisplay.getUserId());
				
				leaveGeneral.setCreateDate(date);
				leaveGeneral.setModifiedDate(date);
				leaveGeneral.setLeaveTypeId(leaveTypeId);
				LeaveGeneralLocalServiceUtil.addLeaveGeneral(leaveGeneral);
		
			
		}
		else
		{
			LeaveGeneral leaveGeneral2 = LeaveGeneralLocalServiceUtil.getLeaveGeneral(Long.parseLong(leaveGeneralId));
			insertOrUpdateLeaveGeneralValues(leaveGeneral2, actionRequest);
			
				leaveGeneral2.setCompanyId(themeDisplay.getCompanyId());
				leaveGeneral2.setGroupId(themeDisplay.getCompanyGroupId());
				leaveGeneral2.setUserId(themeDisplay.getUserId());
				
				leaveGeneral2.setModifiedDate(date);
				leaveGeneral2.setLeaveTypeId(leaveTypeId);
				
				leaveGeneral2 =  LeaveGeneralLocalServiceUtil.updateLeaveGeneral(leaveGeneral2);
		}
    Map<String, Object> leaveInfo=setSessionForLeaveInfo(leaveTypeId);
    leaveInfo.put("jsp", "generalJsp");
		actionRequest.getPortletSession(true).setAttribute("leaveInfo", 
				leaveInfo,PortletSession.APPLICATION_SCOPE);
		
		
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
		
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * Sets who can apply for a particular leave type based on their job title or Employment status 
	 * or Job Category or Gender or years of service.
	 */
	public void saveWhoCanApply(ActionRequest actionRequest,ActionResponse actionResponse) throws NumberFormatException, PortalException, SystemException
	{
		System.out.println("====In saveWhoCanApply=====");
		Date date = new Date();
		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		 
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		log.info("leaveTypeId === " +leaveTypeId);
		String jobTitleIds=ParamUtil.getString(actionRequest, "jobTitleId");
		String jobcategoryIds = ParamUtil.getString(actionRequest, "jobCategoryId");
		String employmentstatusIds = ParamUtil.getString(actionRequest, "employmentStatusId");
		String leaveApplicabilityId = ParamUtil.getString(actionRequest, "leaveApplicabilityId");
		log.info("leaveRuleApplicabilityId in Action class === " +leaveApplicabilityId);
		boolean isJobTitle = ParamUtil.getBoolean(actionRequest, "restrictToJobTitles");
		boolean isJobCategory = ParamUtil.getBoolean(actionRequest, "restrictToJobCategories");
		boolean isEmploymentStatus = ParamUtil.getBoolean(actionRequest, "restrictToEmploymentStatus");
		boolean isGender = ParamUtil.getBoolean(actionRequest, "restrictToGender");
		boolean isMale = ParamUtil.getBoolean(actionRequest, "applyToMale");
		boolean isFemale = ParamUtil.getBoolean(actionRequest, "applyToFemale");
		boolean yearsOfService = ParamUtil.getBoolean(actionRequest, "restrictToYearsOfService");
		String fromDuration = ParamUtil.getString(actionRequest, "applyToFromYears");
		String toDuration = ParamUtil.getString(actionRequest, "applyToYears");
		
		String[] jobTitles=jobTitleIds.split(",");
		String[] jobCategories = jobcategoryIds.split(",");
		String[] employmentstatus = employmentstatusIds.split(",");
		Set<String> jobTitlesNoDuplicates=new HashSet<String>();
		Set<String> jobCategorySet = new HashSet<String>();
		Set<String> employmentstatusSet = new HashSet<String>();
		
		
		for(int i=0;i<jobTitles.length;i++)
		{
			jobTitlesNoDuplicates.add(jobTitles[i]);
			System.out.println("selected job title id is"+jobTitles[i]);
		}
		for(int i = 0;i<jobCategories.length;i++){
			jobCategorySet.add(jobCategories[i]);
		}
		for(int i =0;i<employmentstatus.length;i++){
			employmentstatusSet.add(employmentstatus[i]);
		}
		
	try {
		   if(leaveApplicabilityId==null || leaveApplicabilityId==""){
			LeaveRuleApplicable leaveRuleApplicable=LeaveRuleApplicableLocalServiceUtil.createLeaveRuleApplicable(CounterLocalServiceUtil.increment());
			
			if(jobTitlesNoDuplicates!=null)
			{
				int i=0;
				Object[] jobTitleIdArray=jobTitlesNoDuplicates.toArray();
				while(i<jobTitleIdArray.length)
				{
					try {
						 if(jobTitleIdArray[i]==""){
							 log.info("jobTitleIdArray has empty value");
						 }
						 else{
						LeaveRuleApplicableLocalServiceUtil.addJobTitleLeaveRuleApplicable(Long.valueOf(jobTitleIdArray[i].toString()), leaveRuleApplicable);
					System.out.println("added job title is"+jobTitleIdArray[i]);
					}} catch (SystemException e) {
						e.printStackTrace();
					}
				i++;
				}
			}
			if(jobCategorySet!=null)
			{
				int i=0;
				Object[] jobCategoryIdArray=jobCategorySet.toArray();
				while(i<jobCategoryIdArray.length)
				{
					try {
						 if(jobCategoryIdArray[i]==""){
							 log.info("JobCategoryIdArray has empty value");
						 }
						 else{
						log.info("jobCategoryIdArray length and value == "+jobCategoryIdArray.length+" " +jobCategoryIdArray[i]);
						LeaveRuleApplicableLocalServiceUtil.addJobCategoryLeaveRuleApplicable(Long.valueOf(jobCategoryIdArray[i].toString()), leaveRuleApplicable);
					System.out.println("added job title is"+jobCategoryIdArray[i]);
						 }
						 } catch (SystemException e) {
						e.printStackTrace();
					}
				i++;
				}
			}
			if(employmentstatusSet!=null)
			{
				int i=0;
				Object[] employmentstatusIdArray=employmentstatusSet.toArray();
				while(i<employmentstatusIdArray.length)
				{
					try {
						if(employmentstatusIdArray[i]==""){
							 log.info("employmentstatusIdArray has empty value");
						 }
						 else{
						LeaveRuleApplicableLocalServiceUtil.addEmploymentStatusLeaveRuleApplicable(Long.valueOf(employmentstatusIdArray[i].toString()), leaveRuleApplicable);
					System.out.println("added job title is"+employmentstatusIdArray[i]);
					} }catch (SystemException e) {
						e.printStackTrace();
					}
				i++;
				}
			}
			
			leaveRuleApplicable.setUserId(themeDisplay.getUserId());
			leaveRuleApplicable.setCompanyId(themeDisplay.getCompanyId());
			leaveRuleApplicable.setGroupId(themeDisplay.getCompanyGroupId());
			
			leaveRuleApplicable.setCreateDate(date);
			leaveRuleApplicable.setModifiedDate(date);
			leaveRuleApplicable.setLeaveTypeId(leaveTypeId);
			
			leaveRuleApplicable.setForJobTitles(isJobTitle);
			leaveRuleApplicable.setForJobCategories(isJobCategory);
			leaveRuleApplicable.setForEmploymentStatus(isEmploymentStatus);
			leaveRuleApplicable.setForGender(isGender);
			leaveRuleApplicable.setForMale(isMale);
			leaveRuleApplicable.setForFemale(isFemale);
			leaveRuleApplicable.setForYearsOfService(yearsOfService);
			leaveRuleApplicable.setFromYears(fromDuration);
			leaveRuleApplicable.setToYears(toDuration);
			
			LeaveRuleApplicableLocalServiceUtil.addLeaveRuleApplicable(leaveRuleApplicable);
		   }
		   else{
			   log.info("updating leaveApplicability....");
			   LeaveRuleApplicable leaveRuleApplicable2 = LeaveRuleApplicableLocalServiceUtil.getLeaveRuleApplicable(Long.parseLong(leaveApplicabilityId));
			   leaveRuleApplicable2.setUserId(themeDisplay.getUserId());
				leaveRuleApplicable2.setCompanyId(themeDisplay.getCompanyId());
				leaveRuleApplicable2.setGroupId(themeDisplay.getCompanyGroupId());
				
				leaveRuleApplicable2.setCreateDate(date);
				leaveRuleApplicable2.setModifiedDate(date);
				leaveRuleApplicable2.setLeaveTypeId(leaveTypeId);
				
				leaveRuleApplicable2.setForJobTitles(isJobTitle);
				leaveRuleApplicable2.setForJobCategories(isJobCategory);
				leaveRuleApplicable2.setForEmploymentStatus(isEmploymentStatus);
				leaveRuleApplicable2.setForGender(isGender);
				leaveRuleApplicable2.setForMale(isMale);
				leaveRuleApplicable2.setForFemale(isFemale);
				leaveRuleApplicable2.setForYearsOfService(yearsOfService);
				leaveRuleApplicable2.setFromYears(fromDuration);
				leaveRuleApplicable2.setToYears(toDuration);
			   leaveRuleApplicable2 = LeaveRuleApplicableLocalServiceUtil.updateLeaveRuleApplicable(leaveRuleApplicable2);
			   log.info("Update leaveApplicability.........");
		   }
			} catch (SystemException e) {
				e.printStackTrace();
			}
		System.out.println("successfully added");
		Map<String, Object> leaveInfo=setSessionForLeaveInfo(leaveTypeId);
	    leaveInfo.put("jsp", "leaveruleapplicabilityJsp");
			actionRequest.getPortletSession(true).setAttribute("leaveInfo", 
					leaveInfo,PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
		
	}
	/*
	 * This method inserts or updates the records in leave_general table
	 * If the leave period value received from the jsp is 'default'(0) then it takes the values from leave_period table
	 * else user selected values for Hire Date Base Leave Period(1) or Custom Leave Period(1) will be stored
	 */
	public void insertOrUpdateLeaveGeneralValues(LeaveGeneral leaveGeneral,ActionRequest actionRequest)
	{
		
		int startMonth=ParamUtil.getInteger(actionRequest, "startMonth");
		int startDayOfMonth=ParamUtil.getInteger(actionRequest, "startDayOfMonth");
		String duration=ParamUtil.getString(actionRequest, "duration");
		boolean ifEmployeesCanApply=ParamUtil.getBoolean(actionRequest, "ifEmployeesCanApply");
		boolean ifAdminCanAssign=ParamUtil.getBoolean(actionRequest,"ifAdminCanAssign" );
		boolean ifAdminCanManageEntitlements=ParamUtil.getBoolean(actionRequest, "ifAdminCanManageEntitlements");
		boolean ifLeaveAccruable=ParamUtil.getBoolean(actionRequest, "ifLeaveAccruable");
		boolean ifCarryForwardable=ParamUtil.getBoolean(actionRequest,"ifCarryForwardable");
		int leavePeriodTypeId=ParamUtil.getInteger(actionRequest, "leavePeriodTypeId");
		boolean showProjectBalance=ParamUtil.getBoolean(actionRequest, "showProjectBalance");
		boolean isAttachmentEnabled=ParamUtil.getBoolean(actionRequest, "isAttachmentEnabled");
		boolean isAttachmentMandatory=ParamUtil.getBoolean(actionRequest, "isAttachmentMandatory");
		if(leavePeriodTypeId==0)
		{
			List<LeavePeriod> leavePeriodList=null;
			LeavePeriod leavePeriod=null;
			try {
			    leavePeriodList=LeavePeriodLocalServiceUtil.getLeavePeriods(-1, -1);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			if(leavePeriodList!=null&& leavePeriodList.size()!=0)
			{
				leavePeriod=leavePeriodList.get(0);
			}
			leaveGeneral.setStartMonth(leavePeriod.getStartMonth());
			leaveGeneral.setStartDayOfMonth(leavePeriod.getStartDate());
			leaveGeneral.setLeavePeriodTypeId(Integer.parseInt(Long.valueOf(leavePeriod.getLeavePeriodId()).toString()));
			leaveGeneral.setIfAdminCanAssign(ifAdminCanAssign);
			leaveGeneral.setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
			leaveGeneral.setIfCarryForwardable(ifCarryForwardable);
			leaveGeneral.setIfEmployeesCanApply(ifEmployeesCanApply);
			leaveGeneral.setIfLeaveAccruable(ifLeaveAccruable);
			leaveGeneral.setIsAttachmentMandatory(isAttachmentMandatory);
			leaveGeneral.setEnableAttachment(isAttachmentEnabled);
			leaveGeneral.setShowProjectBalance(showProjectBalance);
		}
		if(leavePeriodTypeId==1)
		{
		leaveGeneral.setLeavePeriodTypeId(1);
		leaveGeneral.setStartMonth(startMonth);
		leaveGeneral.setDuration(duration);
		leaveGeneral.setIfAdminCanAssign(ifAdminCanAssign);
		leaveGeneral.setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
		leaveGeneral.setIfCarryForwardable(ifCarryForwardable);
		leaveGeneral.setIfEmployeesCanApply(ifEmployeesCanApply);
		leaveGeneral.setIfLeaveAccruable(ifLeaveAccruable);
		leaveGeneral.setStartDayOfMonth(startDayOfMonth);
		leaveGeneral.setIsAttachmentMandatory(isAttachmentMandatory);
		leaveGeneral.setEnableAttachment(isAttachmentEnabled);
		leaveGeneral.setShowProjectBalance(showProjectBalance);
		}
		if(leavePeriodTypeId==2)
		{
			leaveGeneral.setLeavePeriodTypeId(2);
			leaveGeneral.setStartMonth(startMonth);
			leaveGeneral.setDuration(duration);
			leaveGeneral.setIfAdminCanAssign(ifAdminCanAssign);
			leaveGeneral.setIfAdminCanManageEntitlements(ifAdminCanManageEntitlements);
			leaveGeneral.setIfCarryForwardable(ifCarryForwardable);
			leaveGeneral.setIfEmployeesCanApply(ifEmployeesCanApply);
			leaveGeneral.setIfLeaveAccruable(ifLeaveAccruable);
			leaveGeneral.setStartDayOfMonth(startDayOfMonth);
			leaveGeneral.setIsAttachmentMandatory(isAttachmentMandatory);
			leaveGeneral.setEnableAttachment(isAttachmentEnabled);
			leaveGeneral.setShowProjectBalance(showProjectBalance);
		}
			}
	/* 
	 * This methods inserts or updates the leave_restriction record for leave_type checking whether leave_restriction 
	 * for the particular leave_type is available or not.
	 * Leave restrictions are assigned for the users based on their roles
	 * The criteria includes whether the leave period can exceed the balance leaves of the user or
	 * can apply for for partial day leave or
	 * minimum service required to apply for leave 
	 * maximum consecutive leaves Employee can apply for
	 * and max small child age to apply
	 * */
	public void addOrUpdateLeaveRestrictions(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		 Date date = new Date();
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Role> roles=null;
		LeaveRestriction leaveRestriction=null;
		List<LeaveRestriction> leaveRestrictionList=null;
		try {
			leaveRestrictionList=LeaveRestrictionLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		if (leaveRestrictionList!=null && leaveRestrictionList.size()!=0) {
			leaveRestriction=leaveRestrictionList.get(0);
		}
		else {
			System.out.println("No LeaveRestriction found with leave type Id"+leaveTypeId);
			try {
				leaveRestriction= LeaveRestrictionLocalServiceUtil.createLeaveRestriction(CounterLocalServiceUtil.increment());
				leaveRestriction.setCreateDate(date);
				} catch (SystemException e1) {
					e1.printStackTrace();
				}
		}
		
		List<Long> assignees=new ArrayList<Long>();
		String tQuestion=null;
		String errorTextIfTermsDeclinedTrimmed = null;
		boolean canExceedBalance=ParamUtil.getBoolean(actionRequest, "cannotExceedBalance");
		boolean canApplyForPartialDay=ParamUtil.getBoolean(actionRequest, "cannotApplyForPartialDay");
		boolean cannotExceedBalance_defaultEss=ParamUtil.getBoolean(actionRequest, "cannotExceedBalance_defaultEss");
		boolean cannotApplyForPartialDay_defaultEss=ParamUtil.getBoolean(actionRequest, "cannotApplyForPartialDay_defaultEss");
		boolean ifAtermsQuestion_defaultEss=ParamUtil.getBoolean(actionRequest, "ifAtermsQuestion_defaultEss");
		boolean isMinServiceApplicable_defaultEss=ParamUtil.getBoolean(actionRequest, "isMinServiceApplicable_defaultEss");
		boolean isMaxConsecDays_defaultEss=ParamUtil.getBoolean(actionRequest, "isMaxConsecDays_defaultEss");
		String termsQuestion=ParamUtil.getString(actionRequest, "termsQuestion");
		if(termsQuestion!=null){
			tQuestion = termsQuestion.trim();
		}
		
		String errorTextIfTermsDeclined=ParamUtil.getString(actionRequest, "errorTextIfTermsDeclined");
		if(errorTextIfTermsDeclined!=null){
			errorTextIfTermsDeclinedTrimmed = errorTextIfTermsDeclined.trim();
		}
		String minimumServicePeriod=ParamUtil.getString(actionRequest, "minimumServicePeriod");
		String maxConsecutiveLeaves=ParamUtil.getString(actionRequest, "maxConsecutiveLeaves");
		String maxSmallChildAgeApplicable=ParamUtil.getString(actionRequest, "maxSmallChildAgeApplicable");
		
		
		leaveRestriction.setCompanyId(themeDisplay.getCompanyId());
		leaveRestriction.setGroupId(themeDisplay.getCompanyGroupId());
		leaveRestriction.setUserId(themeDisplay.getUserId());
		
		leaveRestriction.setModifiedDate(date);
		
		leaveRestriction.setLeaveTypeId(leaveTypeId);
		leaveRestriction.setMinimumServicePeriod(minimumServicePeriod);
		leaveRestriction.setMaxConsecutiveLeaves(maxConsecutiveLeaves);
		leaveRestriction.setMaxSmallChildAgeApplicable(maxSmallChildAgeApplicable);
		leaveRestriction.setCannotExceedBalance(canExceedBalance);
		leaveRestriction.setCannotApplyForPartialDay(canApplyForPartialDay);
		try {
			roles=RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId());
			log.info("roles == " +roles.size()+ " " +roles);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		if(canExceedBalance)
		{
			String canExceedBalanceString = null;
		 if(roles!=null)
			{
			 for(int i=0;i<roles.size();i++)
			 {
				 boolean canAssignTo=ParamUtil.getBoolean(actionRequest, "cannotExceedBalance"+roles.get(i).getName());
				 System.out.println(canAssignTo);
				 if(canAssignTo)
				 {
					
					 canExceedBalanceString = canExceedBalanceString+","+String.valueOf(roles.get(i).getRoleId());
					
				 }
			 }	
			 System.out.println("can exceed balance for roleIds"+canExceedBalanceString);
			 leaveRestriction.setCantExceedBalForRoleIds(canExceedBalanceString);
			 assignees.clear();
			}
		 
		}
		if( canApplyForPartialDay)
		{
			String canApplyForPartialDayString = null;
		 if(roles!=null)
			{
			 for(int i=0;i<roles.size();i++)
			 {
				 boolean canAssignTo=ParamUtil.getBoolean(actionRequest, "cannotApplyForPartialDay"+roles.get(i).getName());
				 if(canAssignTo)
				 {
					
						 canApplyForPartialDayString = canApplyForPartialDayString+","+String.valueOf(roles.get(i).getRoleId());
					
				 }
			 }	
			 System.out.println("cannotApplyForPartialDay for roleIds ==== "+assignees.toString());
			 leaveRestriction.setCantApplyPartialDayForRoleIds(canApplyForPartialDayString);
			 assignees.clear();
			}
		 
		}
		if( tQuestion!=null && tQuestion!=" " && errorTextIfTermsDeclinedTrimmed !=null && errorTextIfTermsDeclinedTrimmed!=" ")
		{
			String questionString = null;
		 if(roles!=null)
			{
			 for(int i=0;i<roles.size();i++)
			 {
				 boolean canAssignTo=ParamUtil.getBoolean(actionRequest, "ifATermsQuestion"+roles.get(i).getName());
				 if(canAssignTo)
				 {
					 
						 questionString = questionString+","+String.valueOf(roles.get(i).getRoleId());
					 
				 }
			 }	
			 System.out.println("ifATermsQuestion for roleIds"+assignees.toString());
			 leaveRestriction.setTermsQsnForRoleIds(questionString);
			 leaveRestriction.setTermsQuestion(tQuestion);
			 leaveRestriction.setErrorTextIfTermsDeclined(errorTextIfTermsDeclinedTrimmed);
			 assignees.clear();
			}
		 
		}
		if( minimumServicePeriod!=null || minimumServicePeriod != " ")
		{
			String minServicePeriodString = null;
		 if(roles!=null)
			{
			 for(int i=0;i<roles.size();i++)
			 {
				 boolean canAssignTo=ParamUtil.getBoolean(actionRequest, "isMinimumServicePeriodApplicable"+roles.get(i).getName());
				 if(canAssignTo)
				 {
					 
						 minServicePeriodString = minServicePeriodString+","+String.valueOf(roles.get(i).getRoleId());
					
				 }
			 }	
			 System.out.println("isMinimumServicePeriodApplicable for roleIds"+assignees.toString());
			 leaveRestriction.setMinServicePeriodForRoleIds(minServicePeriodString);
			 leaveRestriction.setMinimumServicePeriod(minimumServicePeriod);
			 assignees.clear();
			}
		 
		}
		if( maxConsecutiveLeaves!=null || maxConsecutiveLeaves!= " ")
		{
			String maxConsecutiveString = null;
		 if(roles!=null)
			{
			 for(int i=0;i<roles.size();i++)
			 {
				 boolean canAssignTo=ParamUtil.getBoolean(actionRequest, "isMaxConsecutiveLeavesApplicable"+roles.get(i).getName());
				 if(canAssignTo)
				 {
						 maxConsecutiveString = maxConsecutiveString+","+String.valueOf(roles.get(i).getRoleId());
					
				 }
			 }	
			 System.out.println("isMaxConsecutiveLeavesApplicable for roleIds"+assignees.toString());
			 leaveRestriction.setMaxConsecLeavesForRoleIds(maxConsecutiveString);
			 leaveRestriction.setMaxConsecutiveLeaves(maxConsecutiveLeaves);
			 assignees.clear();
			}
		 
		}
		if(maxSmallChildAgeApplicable!=null || maxSmallChildAgeApplicable!=" ")
		{
			String maxSmallChildAgeApplicableString = null;
		 if(roles!=null)
			{
			 for(int i=0;i<roles.size();i++)
			 {
				 boolean canAssignTo=ParamUtil.getBoolean(actionRequest, "isSmallChildCriterionApplicable"+roles.get(i).getName());
				 if(canAssignTo)
				 {
					 	 maxSmallChildAgeApplicableString = maxSmallChildAgeApplicableString+","+String.valueOf(roles.get(i).getRoleId());
					
				 }
			 }	
			 System.out.println("isSmallChildCriterionApplicable for roleIds"+assignees.toString());
			 leaveRestriction.setMaxSmallChildAgeForRoleIds(maxSmallChildAgeApplicableString);
			 leaveRestriction.setMaxSmallChildAgeApplicable(maxSmallChildAgeApplicable);
			 assignees.clear();
			}
		 
		}
		if (leaveRestrictionList!=null && leaveRestrictionList.size()!=0) {
			try {
				LeaveRestrictionLocalServiceUtil.updateLeaveRestriction(leaveRestriction);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		if (leaveRestrictionList==null || leaveRestrictionList.size()==0) {
			try {
				LeaveRestrictionLocalServiceUtil.addLeaveRestriction(leaveRestriction);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} 
        Map leaveInfo=setSessionForLeaveInfo(leaveTypeId);
        leaveInfo.put("jsp", "restrictionsJsp");
		actionRequest.getPortletSession(true).setAttribute("leaveInfo", 
				leaveInfo,PortletSession.APPLICATION_SCOPE);
		log.info(leaveInfo);
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
	}
	
	public void addOrEditLeaveCryFwdRules(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		log.info("inside addOrEditLeaveCryFwdRules....");
		Long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		int specifiedAmount=ParamUtil.getInteger(actionRequest, "specifiedAmount");
		boolean isMaxCarryForwardLimitApplicable=ParamUtil.getBoolean(actionRequest, "includeOverdrawnLeaveWhenCarrying");
		boolean areNegetiveIntValuesAllowed=ParamUtil.getBoolean(actionRequest, "carryForwardNegetiveRules");
		String expiryDurationUOM=ParamUtil.getString(actionRequest, "leaveExpireFrequency");
		String maxCarryForwardLimit=ParamUtil.getString(actionRequest, "maximumAmountToCarryForward");
		int expiryDuration=ParamUtil.getInteger(actionRequest, "expireAfter");
		log.info("form elements are leaveTypeId=="+leaveTypeId+"===max carry forward limit="+maxCarryForwardLimit+
				"isMaxCryFwdLmtApplicable="+isMaxCarryForwardLimitApplicable+" expiry duration= "+expiryDuration+
				"expiryDurationUOM ="+expiryDurationUOM+" neg values allowed ? "+areNegetiveIntValuesAllowed);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LeaveCarryForwardPolicy leaveCarryForwardPolicy=null;
		List<LeaveCarryForwardPolicy> leaveCarryForwardPolicyList=null;
		try {
			leaveCarryForwardPolicyList=LeaveCarryForwardPolicyLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		if (leaveCarryForwardPolicyList!=null && leaveCarryForwardPolicyList.size()!=0) {
			leaveCarryForwardPolicy=leaveCarryForwardPolicyList.get(0);
		}
		else {
			System.out.println("No LeaveCarryFOrwardPolicy found with leave type Id"+leaveTypeId);
			try {
				leaveCarryForwardPolicy= LeaveCarryForwardPolicyLocalServiceUtil.createLeaveCarryForwardPolicy(CounterLocalServiceUtil.increment());
				leaveCarryForwardPolicy.setCreateDate(new Date());
				} catch (SystemException e1) {
					e1.printStackTrace();
				}
		}
		leaveCarryForwardPolicy.setLeaveTypeId(leaveTypeId);
		leaveCarryForwardPolicy.setCreateDate(new Date());
		leaveCarryForwardPolicy.setUserId(themeDisplay.getUserId());
		leaveCarryForwardPolicy.setIsMaxCarryForwardLimitApplicable(isMaxCarryForwardLimitApplicable);
		leaveCarryForwardPolicy.setIsNegetiveValueCarryForwardble(areNegetiveIntValuesAllowed);
		leaveCarryForwardPolicy.setMaxCarryForwardLimit(maxCarryForwardLimit);
		leaveCarryForwardPolicy.setExpiryDuration(expiryDuration);
		leaveCarryForwardPolicy.setExpiryDurationUOM(expiryDurationUOM);
		leaveCarryForwardPolicy.setSpecifiedAmountToCarryForward(specifiedAmount);
		leaveCarryForwardPolicy.setCompanyId(themeDisplay.getCompanyGroupId());
		if (leaveCarryForwardPolicyList!=null && leaveCarryForwardPolicyList.size()!=0) {
			try {
				LeaveCarryForwardPolicyLocalServiceUtil.updateLeaveCarryForwardPolicy(leaveCarryForwardPolicy);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		if (leaveCarryForwardPolicyList==null ||leaveCarryForwardPolicyList.size()==0) {
			try {
				LeaveCarryForwardPolicyLocalServiceUtil.addLeaveCarryForwardPolicy(leaveCarryForwardPolicy);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} 
		Map leaveInfo=null;
		try {
			leaveInfo = setSessionForLeaveInfo(leaveTypeId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        leaveInfo.put("jsp", "carryforwardJsp");
		actionRequest.getPortletSession(true).setAttribute("leaveInfo", 
				leaveInfo,PortletSession.APPLICATION_SCOPE);
		log.info(leaveInfo);
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
		
	}
	
	
	/*
	 * This methods returns a map of key values stored which has to be stored in the session
	 */
	public Map<String, Object> setSessionForLeaveInfo(Long leaveTypeId) throws SystemException
	{
		List<LeaveGeneral> leaveGeneralList=null;
		List<LeaveRestriction> leaveRestrictionList=null;
		List<LeaveRuleApplicable> leaveRuleApplicableList=null;
		List<LeaveCarryForwardPolicy> leaveCarryForwardPolicyList=null;
		LeaveGeneral leaveGeneral=null;
		LeaveRestriction leaveRestriction=null;
		LeaveRuleApplicable leaveRuleApplicable=null;
		LeaveCarryForwardPolicy leaveCarryForwardPolicy=null;
		LeaveType leaveType=null;
		if(leaveTypeId!=0)
		{
			try {
				leaveType=LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			try {
				leaveGeneralList=LeaveGeneralLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if(leaveGeneralList!=null && leaveGeneralList.size()!=0)
			{
				leaveGeneral=leaveGeneralList.get(0);
			}
			try {
				leaveRestrictionList=LeaveRestrictionLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if(leaveRestrictionList!=null && leaveRestrictionList.size()!=0)
			{
				leaveRestriction=leaveRestrictionList.get(0);
			}
			try {
				leaveRuleApplicableList=LeaveRuleApplicableLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if(leaveRuleApplicableList!=null && leaveRuleApplicableList.size()!=0)
			{
				leaveRuleApplicable=leaveRuleApplicableList.get(0);
				
			}
			try {
				leaveCarryForwardPolicyList=LeaveCarryForwardPolicyLocalServiceUtil.findByLeaveTypeId(leaveTypeId);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if(leaveCarryForwardPolicyList!=null && leaveCarryForwardPolicyList.size()!=0)
			{
				leaveCarryForwardPolicy=leaveCarryForwardPolicyList.get(0);
			}
		}
		Map<String,Object> leaveInfo=new HashMap<String,Object>();
		leaveInfo.put("leaveTypeId",leaveTypeId);
		leaveInfo.put("editLeaveType", leaveType);
		leaveInfo.put("editLeaveGeneral", leaveGeneral);
		leaveInfo.put("editLeaveRestriction", leaveRestriction);
		leaveInfo.put("leaveRuleApplicable", leaveRuleApplicable);
		leaveInfo.put("leaveCarryForwardPolicy", leaveCarryForwardPolicy);
		leaveInfo.put("jsp", "generalJsp");
		return leaveInfo;
	}
	public void addOrUpdateLeaveAccrualRules(ActionRequest actionRequest,ActionResponse actionResponse)
	{	
		System.out.println("addOrUpdateLeaveAccrualRules method().......");
		String s = ParamUtil.getString(actionRequest, "accrualFrequency");
		System.out.println("s ==== " +s);
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		Map leaveInfo=null;
		try {
			leaveInfo = setSessionForLeaveInfo(leaveTypeId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		leaveInfo.put("jsp", "accrualrulesJsp");
		actionRequest.getPortletSession(true).setAttribute("leaveInfo",
		leaveInfo,PortletSession.APPLICATION_SCOPE);

		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
		
	}
	public void saveEmployeeGroup(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException{
		
		log.info("inside saveEmployeeGroup...");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		// getting default group intput fields
		String leaveApplicabilityId = ParamUtil.getString(actionRequest, "leaveApplicabilityId");
		String defaultGroupName = ParamUtil.getString(actionRequest, "groupName");
		boolean defaultJobtitleCheckbox = ParamUtil.getBoolean(actionRequest, "grouprestrictToJobTitles");
		boolean defaultJobcategoryCheckbox = ParamUtil.getBoolean(actionRequest, "grouprestrictToJobCategories");
		boolean defaultEmploymentStatusCheckbox = ParamUtil.getBoolean(actionRequest, "grouprestrictToEmploymentStatus");
		boolean defaultGenderCheckbox = ParamUtil.getBoolean(actionRequest, "grouprestrictToGender");
		boolean defaultFemaleCheckbox = ParamUtil.getBoolean(actionRequest, "applyToFemale");
		boolean defaultMaleCheckbox = ParamUtil.getBoolean(actionRequest, "applyToMale");
		boolean defaultYearsofServiceCheckbox = ParamUtil.getBoolean(actionRequest, "grouprestrictToYearsOfService");
		String defaultFromYears = ParamUtil.getString(actionRequest, "applyToFromYears");
		String defaultToYears = ParamUtil.getString(actionRequest, "applyToYears");
		log.info(leaveApplicabilityId);log.info(defaultGroupName);log.info(defaultJobtitleCheckbox);log.info(defaultJobcategoryCheckbox);
		log.info(defaultEmploymentStatusCheckbox);log.info(defaultGenderCheckbox);log.info(defaultYearsofServiceCheckbox);
		log.info(defaultFemaleCheckbox);log.info(defaultMaleCheckbox);log.info(defaultFromYears);log.info(defaultToYears);
		
		LeaveTypeEmployeeGroups leaveTypeEmployeeGroups = LeaveTypeEmployeeGroupsLocalServiceUtil.createLeaveTypeEmployeeGroups(CounterLocalServiceUtil.increment());
		leaveTypeEmployeeGroups.setLeaveTypeId(leaveTypeId);
		leaveTypeEmployeeGroups.setGroupName(defaultGroupName);
		leaveTypeEmployeeGroups.setForJobTitles(defaultJobtitleCheckbox);
		leaveTypeEmployeeGroups.setForJobCategories(defaultJobcategoryCheckbox);
		leaveTypeEmployeeGroups.setForEmploymentStatus(defaultEmploymentStatusCheckbox);
		leaveTypeEmployeeGroups.setForGender(defaultGenderCheckbox);
		leaveTypeEmployeeGroups.setForFemale(defaultFemaleCheckbox);
		leaveTypeEmployeeGroups.setForMale(defaultMaleCheckbox);
		leaveTypeEmployeeGroups.setForYearsOfService(defaultYearsofServiceCheckbox);
		leaveTypeEmployeeGroups.setFromYears(defaultFromYears);
		leaveTypeEmployeeGroups.setToYears(defaultToYears);
		
		leaveTypeEmployeeGroups.setCompanyId(themeDisplay.getCompanyId());
		leaveTypeEmployeeGroups.setGroupId(themeDisplay.getCompanyGroupId());
		leaveTypeEmployeeGroups.setUserId(themeDisplay.getUserId());
		
		leaveTypeEmployeeGroups.setCreateDate(date);
		leaveTypeEmployeeGroups.setModifiedDate(date);
		
		leaveTypeEmployeeGroups = LeaveTypeEmployeeGroupsLocalServiceUtil.addLeaveTypeEmployeeGroups(leaveTypeEmployeeGroups);
		String groupCount = ParamUtil.getString(actionRequest, "groupCount");
		if(groupCount!=null && groupCount!=""){
		long l = Long.parseLong(groupCount);
		log.info("groupCount == " +l);
		for(int i =2;i<l;i++){
			log.info("i ==================" +i);
			String groupName = ParamUtil.getString(actionRequest, "group"+i+"GroupName");
			boolean jobtitleCheckbox = ParamUtil.getBoolean(actionRequest, "group"+i+"jobtitleCheckbox");
			boolean jobcategoryCheckbox = ParamUtil.getBoolean(actionRequest, "group"+i+"JobCategoriesCheckbox");
			boolean employmentStatusCheckbox = ParamUtil.getBoolean(actionRequest, "group"+i+"EmploymentStatusCheckbox");
			boolean genderCheckbox = ParamUtil.getBoolean(actionRequest, "group"+i+"GenderCheckbox");
			boolean female = ParamUtil.getBoolean(actionRequest, "group"+i+"Female");
			boolean male = ParamUtil.getBoolean(actionRequest, "group"+i+"Male");
			boolean yearsofServiceCheckbox = ParamUtil.getBoolean(actionRequest, "group"+i+"YearsOfServiceCheckbox");
			String fromYears = ParamUtil.getString(actionRequest, "group"+i+"FromYears");
			String toYears = ParamUtil.getString(actionRequest, "group"+i+"ToYears");
			log.info(jobtitleCheckbox);log.info(jobcategoryCheckbox);log.info(employmentStatusCheckbox);log.info(genderCheckbox);log.info(yearsofServiceCheckbox);
			log.info(groupName);log.info(female);log.info(male);log.info(fromYears);log.info(toYears);
			LeaveTypeEmployeeGroups employeeGroups = LeaveTypeEmployeeGroupsLocalServiceUtil.createLeaveTypeEmployeeGroups(CounterLocalServiceUtil.increment());
			employeeGroups.setLeaveTypeId(leaveTypeId);
			employeeGroups.setGroupName(groupName);
			employeeGroups.setForJobTitles(jobtitleCheckbox);
			employeeGroups.setForJobCategories(jobcategoryCheckbox);
			employeeGroups.setForEmploymentStatus(employmentStatusCheckbox);
			employeeGroups.setForGender(genderCheckbox);
			employeeGroups.setForFemale(female);
			employeeGroups.setForMale(male);
			employeeGroups.setForYearsOfService(yearsofServiceCheckbox);
			employeeGroups.setFromYears(fromYears);
			employeeGroups.setToYears(toYears);
			
			employeeGroups.setCompanyId(themeDisplay.getCompanyId());
			employeeGroups.setGroupId(themeDisplay.getCompanyGroupId());
			employeeGroups.setUserId(themeDisplay.getUserId());
			
			employeeGroups.setCreateDate(date);
			employeeGroups.setModifiedDate(date);
			employeeGroups = LeaveTypeEmployeeGroupsLocalServiceUtil.addLeaveTypeEmployeeGroups(employeeGroups);
			
		}}
		Map leaveInfo=setSessionForLeaveInfo(leaveTypeId);
        leaveInfo.put("jsp", "restrictgroupsJsp");
		actionRequest.getPortletSession(true).setAttribute("leaveInfo", 
				leaveInfo,PortletSession.APPLICATION_SCOPE);
		
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
		
		
		
	}
	
}


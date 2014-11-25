package com.rknowsys.eapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.JobTitle;
import com.rknowsys.eapp.hrm.model.LeaveGeneral;
import com.rknowsys.eapp.hrm.model.LeavePeriod;
import com.rknowsys.eapp.hrm.model.LeaveRuleApplicable;
import com.rknowsys.eapp.hrm.model.LeaveType;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveGeneralLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeavePeriodLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveRuleApplicableLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LeaveTypeLocalServiceUtil;

public class LeaveTypeAction extends MVCPortlet{
	
	private static Logger log = Logger.getLogger(LeaveTypeAction.class);
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		log.info("in serveResource method");
		 PrintWriter out = resourceResponse.getWriter();
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
			 DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(JobTitle.class,
			 PortletClassLoaderUtil.getClassLoader());
			 Criterion criterion = RestrictionsFactoryUtil.like("title",
			 StringPool.PERCENT );
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
		else
		{
			out.println("no records are available for job titles");
		}
		
	}
	public void addOrUpdateLeaveType(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		//This method inserts or updates a record in leave_type table
		//actionRequest.getPortletSession().removeAttribute("editLeaveType");
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		long nationalityId=ParamUtil.getLong(actionRequest, "nationalityId");
		boolean isSituational=ParamUtil.getBoolean(actionRequest, "isSituational");
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
		//receives the primary key of the selected row and sets the corresponding object in session
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
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/add_edit_leaveType.jsp");
	}
	public void editLeaveRule(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		log.info("leave type id is"+leaveTypeId);
		LeaveGeneral leaveGeneral=null;
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
		if(leaveGeneral!=null||leaveGeneralList.size()!=0)
		{
			leaveGeneral=leaveGeneralList.get(0);
		}
		Map leaveGeneralForLeaveType=new HashMap();
		leaveGeneralForLeaveType.put("leaveTypeId", leaveTypeId);
		leaveGeneralForLeaveType.put("leaveGeneral", leaveGeneral);
		leaveGeneralForLeaveType.put("editLeaveType", leaveType);
		actionRequest.getPortletSession(true).setAttribute("leaveGeneralForLeaveType", 
				leaveGeneralForLeaveType,PortletSession.APPLICATION_SCOPE);
		log.info(leaveType);
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
	}
	public void saveOrUpdateLeaveGeneral(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		log.info("in saveOrUpdateLeaveGeneral method");
		long leaveGeneralId=ParamUtil.getLong(actionRequest,"leaveGeneralId");
		long leaveTypeId=ParamUtil.getLong(actionRequest, "leaveTypeId");
		LeaveType leaveType=null;
		try {
			leaveType=LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		LeaveGeneral leaveGeneral=null;
		try {
			leaveGeneral=LeaveGeneralLocalServiceUtil.getLeaveGeneral(leaveGeneralId);
			} catch (PortalException e) {
				System.out.println("No leave general exists");
			} catch (SystemException e) {
				System.out.println("No leave general exists");
			}
		if(leaveGeneral!=null)
		{
			insertOrUpdateLeaveGeneralValues(leaveGeneral, actionRequest);
			try {
				LeaveGeneralLocalServiceUtil.updateLeaveGeneral(leaveGeneral);
				} catch (SystemException e) {
					e.printStackTrace();
				}
		}
		else
		{
			try {
				leaveGeneral=LeaveGeneralLocalServiceUtil.createLeaveGeneral(CounterLocalServiceUtil.increment());
				} catch (SystemException e) {
					e.printStackTrace();
				}
			insertOrUpdateLeaveGeneralValues(leaveGeneral, actionRequest);
			try {
				LeaveGeneralLocalServiceUtil.addLeaveGeneral(leaveGeneral);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		Map leaveGeneralForLeaveType=new HashMap();
		leaveGeneralForLeaveType.put("leaveTypeId", leaveGeneral.getLeaveGeneralId());
		leaveGeneralForLeaveType.put("leaveGeneral", leaveGeneral);
		leaveGeneralForLeaveType.put("editLeaveType",leaveType );
		actionRequest.getPortletSession(true).setAttribute("leaveGeneralForLeaveType", 
				leaveGeneralForLeaveType,PortletSession.APPLICATION_SCOPE);
		log.info(leaveType);
		actionResponse.setRenderParameter("mvcPath", "/html/leavetype/update_leaveGeneral.jsp");
		
	}
	public void saveWhoCanApply(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		System.out.println("====In saveWhoCanApply=====");
		String jobTitleIds=ParamUtil.getString(actionRequest, "jobTitleId");
		String[] jobTitles=jobTitleIds.split(",");
		Set<String> jobTitlesNoDuplicates=new HashSet<String>();
		for(int i=0;i<jobTitles.length;i++)
		{
			jobTitlesNoDuplicates.add(jobTitles[i]);
			System.out.println("selected job title id is"+jobTitles[i]);
		}
		LeaveRuleApplicable leaveRuleApplicable=null;
		try {
			leaveRuleApplicable=LeaveRuleApplicableLocalServiceUtil.createLeaveRuleApplicable(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				e.printStackTrace();
			}
		if(jobTitlesNoDuplicates!=null)
		{
			int i=0;
			Object[] jobTitleIdArray=jobTitlesNoDuplicates.toArray();
			while(i<jobTitleIdArray.length)
			{
				try {
					LeaveRuleApplicableLocalServiceUtil.addJobTitleLeaveRuleApplicable(Long.valueOf(jobTitleIdArray[i].toString()), leaveRuleApplicable);
				System.out.println("added job title is"+jobTitleIdArray[i]);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			i++;
			}
		}
		try {
			LeaveRuleApplicableLocalServiceUtil.addLeaveRuleApplicable(leaveRuleApplicable);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("successfully added");
	}
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
			if(leavePeriodList!=null)
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
}

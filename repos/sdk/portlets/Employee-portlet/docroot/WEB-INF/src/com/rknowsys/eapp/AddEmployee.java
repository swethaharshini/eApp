package com.rknowsys.eapp;

import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.LayoutUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmpContactDetails;
import com.rknowsys.eapp.hrm.model.EmpJob;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;

/**
 * Portlet implementation class AddEmployee
 */
public class AddEmployee extends MVCPortlet {
 
	
public static final String EMPLOYEE_FIRST_NAME_COL_NAME = "firstName";
public static final String ORDER_TYPE_ASC = "asc";
public static final String EMPLOYEE_MIDDLE_NAME_COL_NAME = "middleName";
public static final String EMPLOYEE_LAST_NAME_COL_NAME = "lastName";
protected static int checkPageRedirect=0;

private static Logger log = Logger.getLogger(AddEmployee.class);
public void addEmployee(ActionRequest actionRequest,ActionResponse actionResponse)
throws IOException,PortletException,SystemException
{ 
	++checkPageRedirect;
	log.info("In addEmployee method");
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
			.getAttribute(WebKeys.THEME_DISPLAY);
	Date date = new Date();
	UploadPortletRequest uploadRequest = PortalUtil
			.getUploadPortletRequest(actionRequest);
	Long location = ParamUtil.getLong(uploadRequest, "location");
	String firstName = ParamUtil.getString(uploadRequest,EMPLOYEE_FIRST_NAME_COL_NAME);
	String middleName = ParamUtil.getString(uploadRequest,EMPLOYEE_MIDDLE_NAME_COL_NAME);
	String lastName = ParamUtil.getString(uploadRequest,EMPLOYEE_LAST_NAME_COL_NAME);
	String empNo = ParamUtil.getString(uploadRequest, "employee_no");
	String username = ParamUtil.getString(uploadRequest, "user_name");
	String password = ParamUtil.getString(uploadRequest, "password");
	File uploadPhoto = uploadRequest.getFile("emp_photograph");
	String fileName=uploadRequest.getFileName("emp_photograph");
	String contentType = MimeTypesUtil.getContentType(uploadPhoto);
	log.info("user name is "+username +"===="+"password is "+password);
	System.out.println("content type is" + contentType);
	String changeLog = ParamUtil.getString(actionRequest, "changeLog");
	System.out.println("changeLog" + changeLog);
	EmpContactDetails empContactDetails = null;
	Employee employee = null;
	EmpPersonalDetails empPersonalDetails = null;
	employee = EmployeeLocalServiceUtil
			.createEmployee(CounterLocalServiceUtil.increment());
	employee.setLocationId(location);
	employee.setUserId(themeDisplay.getUserId());
	employee.setCompanyId(themeDisplay.getCompanyId());
		try {
			employee.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
		} catch (PortalException e2) {
			log.error("Error in obtaining groupId",e2);
		}
	employee.setCreateDate(date);
	employee.setModifiedDate(date);
	EmployeeLocalServiceUtil.addEmployee(employee);
	empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
			.createEmpPersonalDetails(CounterLocalServiceUtil.increment());
	empPersonalDetails.setEmployeeId(employee.getPrimaryKey());
	empPersonalDetails.setFirstName(firstName);
	empPersonalDetails.setMiddleName(middleName);
	empPersonalDetails.setLastName(lastName);
	empPersonalDetails.setEmployeeNo(empNo);
	empPersonalDetails.setUserId(themeDisplay.getUserId());
	empPersonalDetails.setCompanyId(themeDisplay.getCompanyId());
	empPersonalDetails.setCreateDate(date);
	empPersonalDetails.setModifiedDate(date);
	EmpPersonalDetailsLocalServiceUtil
			.addEmpPersonalDetails(empPersonalDetails);
	EmpJob empJob=EmpJobLocalServiceUtil.createEmpJob(CounterLocalServiceUtil.increment());
	empJob.setCreateDate(date);
		try {
			empJob.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
		} catch (PortalException e2) {
			log.error("Error in obtaining groupId",e2);
		}
	empJob.setEmployeeId(employee.getEmployeeId());
	empJob.setLocationId(employee.getLocationId());
	empJob.setUserId(themeDisplay.getUserId());
	empJob.setCompanyId(themeDisplay.getCompanyGroupId());
	empJob.setIsCurrentJob(true);
	EmpJobLocalServiceUtil.addEmpJob(empJob);
	ServiceContext serviceContext = null;
	FileEntry fileEntry = null;
	if(uploadPhoto!=null)
	{
		try {
			serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), actionRequest);
		} catch (PortalException e1) {
			log.error("Error in adding image of the employee",e1);
		}
		try {
			fileEntry = DLAppLocalServiceUtil.addFileEntry(
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					0, fileName+date.getTime(), contentType,
					fileName+date.getTime(), contentType,
					" ", uploadPhoto, serviceContext);
		} catch (PortalException e1) {
			log.error("Error in adding image of the employee",e1);
		}
	}
	/*if (fileEntry.getExpandoBridge().hasAttribute("employeeId")) {
		fileEntry.getExpandoBridge().setAttribute("employeeId",
				String.valueOf(employee.getEmployeeId()));
	   }  else {
		log.info("No expando attribute available with the name employeeId for DLFileEntry table");
			try {
				fileEntry.getExpandoBridge().addAttribute("employeeId");
			} catch (PortalException e) {
				log.error("Error while adding expando attribute to DLFileEntry table",e);
			}
	  }
	fileEntry.getExpandoBridge().setAttribute("employeeId",String.valueOf(employee.getEmployeeId()));
	try {
		DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(),
				fileEntry.getFileEntryId(), fileName,
				contentType, fileName,"",
				changeLog, false, uploadPhoto, serviceContext);
	} catch (PortalException e) {
		log.error("Error in adding image of the employee",e);
	}*/
	if (username != null || password != null) {
		User user = null;
		Role role=null;
		try {
			role=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Hrm user");
		} catch (PortalException e1) {
			log.info("Error in obtaining role object" ,e1);
		}
		try {
			user = UserLocalServiceUtil.addUser(themeDisplay.getUserId(),
					themeDisplay.getCompanyId(), false, password, password,
					true, "", username+"@liferay.com", 0L, "",
					themeDisplay.getLocale(), firstName,
					middleName,  lastName, 0, 0, false, 0, 1,
					1970, "", null, null, null, null, false,
					new ServiceContext());
			  long[] userIds = new long[] {user.getUserId()};
			  Organization organization=null;
		        try {
		        	organization = OrganizationLocalServiceUtil.getOrganization(themeDisplay.getCompanyId(), "R-Knowsys Technologies");
		        	if(organization!=null)
		        	{
					UserLocalServiceUtil.addOrganizationUsers(organization.getOrganizationId(), userIds);
					UserLocalServiceUtil.updateOrganizations(user.getUserId(), new long[]{organization.getOrganizationId()}, serviceContext);
		        	}
					} catch (PortalException e) {
						log.info("Error adding user to the organization",e);
					} catch (SystemException e) {
						log.info("Error adding user to the organization",e);
					}
			if(role!=null)
			{
				UserLocalServiceUtil.addRoleUser(role.getRoleId(), user);
			}
			else
			{
				RoleLocalServiceUtil.addRole(themeDisplay.getUserId(), null, 0, "Hrm user",
						null, null, 0, "", new ServiceContext());
				try {
					role=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Hrm user");
				} catch (PortalException e1) {
					log.info("Error in obtaining role object" ,e1);
				}
				UserLocalServiceUtil.addRoleUser(role.getRoleId(), user);
			}
		}
		
			/*if (user.getExpandoBridge().hasAttribute("employeeId")) {
				user.getExpandoBridge().setAttribute("employeeId",
						String.valueOf(employee.getEmployeeId()));
				UserLocalServiceUtil.updateUser(user);
			} else {
				log.info("No expando attribute available with the name employeeId for User table");
				user.getExpandoBridge().addAttribute("employeeId");
				user.getExpandoBridge().setAttribute("employeeId",
						String.valueOf(employee.getEmployeeId()));
				UserLocalServiceUtil.updateUser(user);
			}
			*/
			catch (PortalException e) {
			log.error("Error in updating employee with user details",e);
			}
		if (user != null) {
			Employee employee2 = null;
			try {
				employee2 = EmployeeLocalServiceUtil.getEmployee(employee
						.getEmployeeId());
			} catch (PortalException e) {
				log.error("Error in updating employee with user details",e);
			}
			employee2.setAssignedUserId(user.getUserId());
			EmployeeLocalServiceUtil.updateEmployee(employee2);
		}
		if (fileEntry != null) {
			Employee employee3 = null;
			try {
				employee3 = EmployeeLocalServiceUtil.getEmployee(employee
						.getEmployeeId());
			} catch (PortalException e) {
				log.error("Error in updating employee with user details",e);
			}
			employee3.setImageId(fileEntry.getFileEntryId());
			EmployeeLocalServiceUtil.updateEmployee(employee3);

		}
	}
	Map<String, Comparable> map = setSessionAttributes(employee.getEmployeeId(),fileEntry!=null?
			fileEntry.getFileEntryId():0,"empEditJsp");
	PortletSession redirectSession=actionRequest.getPortletSession();
	redirectSession.setAttribute("empId", map,PortletSession.APPLICATION_SCOPE);
	long plid=0;
	try {
		plid=PortalUtil.getPlidFromPortletId(themeDisplay.getLayout().getGroupId(),"Employee_WAR_Employeeportlet");
	 } catch (PortalException e) {
		 log.info("Error in obtaining plid",e);
	 }
	PortletURL myaccountURL = PortletURLFactoryUtil.create(uploadRequest, "Employee_WAR_Employeeportlet",plid, PortletRequest.RENDER_PHASE);
		
	myaccountURL.setWindowState(WindowState.MAXIMIZED);
	log.info("URL to redirect to employee page"+myaccountURL);
	actionResponse.sendRedirect(myaccountURL.toString());
}
public Map<String, Comparable> setSessionAttributes(long empId,long imageId,String jsp) 
{
	Map<String, Comparable> sessionAttributes=new HashMap<String, Comparable>();
	sessionAttributes.put("empId", empId);
	sessionAttributes.put("fileId", imageId);
	sessionAttributes.put("jsp", jsp);
	return sessionAttributes;
}
}

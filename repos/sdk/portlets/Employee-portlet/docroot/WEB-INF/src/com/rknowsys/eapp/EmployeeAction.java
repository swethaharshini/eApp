package com.rknowsys.eapp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmpContactDetails;
import com.rknowsys.eapp.hrm.model.EmpDependent;
import com.rknowsys.eapp.hrm.model.EmpDirectDeposit;
import com.rknowsys.eapp.hrm.model.EmpEducation;
import com.rknowsys.eapp.hrm.model.EmpEmergencyContact;
import com.rknowsys.eapp.hrm.model.EmpImmigrationDocument;
import com.rknowsys.eapp.hrm.model.EmpJob;
import com.rknowsys.eapp.hrm.model.EmpLanguage;
import com.rknowsys.eapp.hrm.model.EmpLicense;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.EmpSkill;
import com.rknowsys.eapp.hrm.model.EmpSupervisor;
import com.rknowsys.eapp.hrm.model.EmpWorkExp;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.model.Location;
import com.rknowsys.eapp.hrm.model.PayGradeCurrency;
import com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpDependentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpDirectDepositLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpEducationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpLanguageLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpLicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSkillLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSupervisorLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpWorkExpLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil;

public class EmployeeAction extends MVCPortlet {
	public static final String EMPLOYEE_ID = "employeeId";
	public static final String EMPLOYEE_FIRST_NAME_COL_NAME = "firstName";
	public static final String ORDER_TYPE_ASC = "asc";
	public static final String EMPLOYEE_MIDDLE_NAME_COL_NAME = "middleName";
	public static final String EMPLOYEE_LAST_NAME_COL_NAME = "lastName";
	public static final String EMPLOYEE_GENDER = "gender";
	public static final int EMPLOYEE_GENDER_MALE = 0;
	public static final int EMPLOYEE_GENDER_FEMALE = 1;
	public static final String EMPLOYEE_MARITAL_STATUS_COL_NAME = "maritalStatus";
	public static final String EMPLOYEE_NATIONALITY_COL_NAME = "nationality";
	public static final String EMPLOYEE_DATEOFBIRTH_COL_NAME = "dateOfBirth";
	public static final String EMPLOYEE_OTHERID_COL_NAME = "otherId";
	public static final String EMPLOYEE_LICENSE_NUMBER_COL_NAME = "licenseNumber";
	public static final String EMPLOYEE_LICENSE_EXP_DATE_COL_NAME = "licenseExpiryDate";
	public static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/YYYY");
	private static Logger log = Logger.getLogger(EmployeeAction.class);

	/**
	 * <p>
	 * This method inserts new Employee record and EmpPersonalDetails in
	 * database and creates portal user credentials if user name and password
	 * are not null
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void renderEmployeeDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		long empId = ParamUtil.getLong(actionRequest, "prk");
		Employee emp = null;
		try {
			emp = EmployeeLocalServiceUtil.getEmployee(empId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (emp != null) {
			Map map = new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp1");
			map.put("fileId", emp.getImageId());
			actionRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
		} else {
			System.out.println("This employee is no longer available");
		}
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	public void saveEmpDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("saveEmployeeDetails method");
		addEmployee(actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	/** This method updates EmpPersonalDetails record in Database */
	public void updateEmpPersonalDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		long fileEntryId = ParamUtil.getLong(actionRequest, "fileIdemp");
		Long empId = ParamUtil.getLong(actionRequest, "perEmpId");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String firstName = ParamUtil.getString(actionRequest,
				EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(actionRequest,
				EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(actionRequest,
				EMPLOYEE_LAST_NAME_COL_NAME);
		String empNo = ParamUtil.getString(actionRequest, "employee_no");
		String otherId = ParamUtil.getString(actionRequest, "other_id");
		String driverLicenseNo = ParamUtil.getString(actionRequest,
				"driver_license_no");
		// Date expiryDate=ParamUtil.getDate(actionRequest,
		// "expiry_date",dateFormat);
		String expiryDate = ParamUtil.getString(actionRequest, "expiry_date");
		log.info(expiryDate);
		// log.info(expiryDate);
		String gender = ParamUtil.getString(actionRequest, "gender");
		String maritalStatus = ParamUtil.getString(actionRequest,
				"marital_status");
		long nationality = ParamUtil.getLong(actionRequest, "emp_nationality");
		// Date dateOfB=ParamUtil.getDate(actionRequest, "date_of_birth",
		// dateFormat);
		// log.info(dateOfB);
		String dateOfB = ParamUtil.getString(actionRequest, "date_of_birth");
		long perEmpId = ParamUtil.getLong(actionRequest, "personalDetailsId");
		EmpPersonalDetails empPersonalDetails = null;
		log.info("first name and last anme are" + " " + firstName + " "
				+ lastName + " " + empId);
		try {
			empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
					.getEmpPersonalDetails(perEmpId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		if (empPersonalDetails != null) {
			empPersonalDetails.setFirstName(firstName);
			empPersonalDetails.setMiddleName(middleName);
			empPersonalDetails.setLastName(lastName);
			try {
				empPersonalDetails.setDateOfBirth(dateFormat.parse(dateOfB));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			empPersonalDetails.setEmployeeId(empId);
			empPersonalDetails.setEmployeeNo(empNo);
			try {
				empPersonalDetails.setLicenseExpDate(dateFormat
						.parse(expiryDate));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			empPersonalDetails.setLicenseNo(driverLicenseNo);
			empPersonalDetails.setOtherId(otherId);
			empPersonalDetails.setCompanyId(themeDisplay.getCompanyId());
			empPersonalDetails.setUserId(themeDisplay.getUserId());
			empPersonalDetails.setModifiedDate(date);
			empPersonalDetails.setNationalityId(nationality);
			empPersonalDetails.setMaritalStatus(maritalStatus);
			empPersonalDetails.setGender(gender);
			try {
				EmpPersonalDetailsLocalServiceUtil
						.updateEmpPersonalDetails(empPersonalDetails);
			} catch (SystemException e) {

				e.printStackTrace();
			}
		}
		Map map = new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp1");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		log.info("updateEmpPersonalDetails method");
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	/**
	 * <p>
	 * This method inserts new EmpContactDetails record in database if the id is
	 * not existing, otherwise updates the record based on the record id.
	 * </p>
	 */
	public void addOrUpdateEmpContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			IOException, SystemException {
		log.info("update or add Employee contact details:in updateEmpContactDetails method");
		Long contactDetailsId = ParamUtil
				.getLong(actionRequest, "conDetailsId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "conFileId");
		String addressStreet1 = ParamUtil.getString(actionRequest,
				"address_street1");
		String addressStreet2 = ParamUtil.getString(actionRequest,
				"address_street2");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String zip = ParamUtil.getString(actionRequest, "zip");
		String country = ParamUtil.getString(actionRequest, "country");
		String homeTele = ParamUtil.getString(actionRequest, "home_telephone");
		String workTele = ParamUtil.getString(actionRequest, "work_telephone");
		String mobile = ParamUtil.getString(actionRequest, "mobile");
		String workMail = ParamUtil.getString(actionRequest, "work_email");
		String otherMail = ParamUtil.getString(actionRequest, "other_email");
		Long empId = ParamUtil.getLong(actionRequest, "conEmpId");
		System.out.println(addressStreet1 + addressStreet2 + empId);
		DynamicQuery contactDetailsDynamicQuery = DynamicQueryFactoryUtil
				.forClass(EmpContactDetails.class,
						PortletClassLoaderUtil.getClassLoader());
		contactDetailsDynamicQuery.add(PropertyFactoryUtil
				.forName("employeeId").eq(empId));
		List<EmpContactDetails> l = null;
		try {
			l = EmpContactDetailsLocalServiceUtil
					.dynamicQuery(contactDetailsDynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		EmpContactDetails empContactDetails = null;
		if (l.size() == 0) {
			try {
				empContactDetails = EmpContactDetailsLocalServiceUtil
						.createEmpContactDetails(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			empContactDetails.setAddressStreet1(addressStreet1);
			empContactDetails.setAddressStreet2(addressStreet2);
			empContactDetails.setCity(city);
			empContactDetails.setCountry(country);
			empContactDetails.setHomeTelephone(homeTele);
			empContactDetails.setMobile(mobile);
			empContactDetails.setOtherEmail(otherMail);
			empContactDetails.setState(state);
			empContactDetails.setOtherEmail(otherMail);
			empContactDetails.setPostalCode(zip);
			empContactDetails.setWorkEmail(workMail);
			empContactDetails.setWorkTelephone(workTele);
			empContactDetails.setEmployeeId(empId);
			empContactDetails.setCreateDate(date);
			empContactDetails.setUserId(themeDisplay.getUserId());
			empContactDetails.setCompanyId(themeDisplay.getCompanyId());
			empContactDetails.setGroupId(themeDisplay.getCompanyGroupId());
			try {
				EmpContactDetailsLocalServiceUtil
						.addEmpContactDetails(empContactDetails);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else {
			try {
				empContactDetails = EmpContactDetailsLocalServiceUtil
						.getEmpContactDetails(l.get(0).getEmpContactDetailsId());
			} catch (PortalException e) {

				e.printStackTrace();
			} catch (SystemException e) {

				e.printStackTrace();
			}
			empContactDetails.setAddressStreet1(addressStreet1);
			empContactDetails.setAddressStreet2(addressStreet2);
			empContactDetails.setCity(city);
			empContactDetails.setCountry(country);
			empContactDetails.setHomeTelephone(homeTele);
			empContactDetails.setMobile(mobile);
			empContactDetails.setOtherEmail(otherMail);
			empContactDetails.setState(state);
			empContactDetails.setOtherEmail(otherMail);
			empContactDetails.setPostalCode(zip);
			empContactDetails.setWorkEmail(workMail);
			empContactDetails.setWorkTelephone(workTele);
			empContactDetails.setUserId(themeDisplay.getUserId());
			empContactDetails.setCompanyId(themeDisplay.getCompanyId());
			empContactDetails.setGroupId(themeDisplay.getCompanyGroupId());
			empContactDetails.setModifiedDate(date);
			try {
				EmpContactDetailsLocalServiceUtil
						.updateEmpContactDetails(empContactDetails);
			} catch (SystemException e) {

				e.printStackTrace();
			}
		}
		Map map = new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp2");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	/**
	 * <p>
	 * This method inserts new EmpEmergencyContact record in database if the id
	 * is not existing, otherwise updates the record based on the record id.
	 * </p>
	 */
	public void updateContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		System.out
				.println("updating emegergency contact details:updateContactDetails method");
		long empId = ParamUtil.getLong(actionRequest, "emgEmpId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "conFileId");
		String emergencyName = ParamUtil.getString(actionRequest, "emg_name");
		String relationship = ParamUtil.getString(actionRequest,
				"emg_relationship");
		String homeTele = ParamUtil
				.getString(actionRequest, "emg_hm_telephone");
		String mobile = ParamUtil.getString(actionRequest, "emg_mobile");
		String workTele = ParamUtil.getString(actionRequest,
				"emg_work_telephone");
		System.out.println("emergency name is"
				+ ParamUtil.getString(actionRequest, "emg_name"));
		EmpEmergencyContact empEmergencyContact = null;
		try {
			empEmergencyContact = EmpEmergencyContactLocalServiceUtil
					.createEmpEmergencyContact(CounterLocalServiceUtil
							.increment());
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		empEmergencyContact.setCompanyId(themeDisplay.getCompanyId());
		empEmergencyContact.setGroupId(themeDisplay.getCompanyGroupId());
		empEmergencyContact.setCreateDate(date);
		empEmergencyContact.setEmployeeId(empId);
		empEmergencyContact.setHomeTelephone(homeTele);
		empEmergencyContact.setMobile(mobile);
		empEmergencyContact.setRelationship(relationship);
		empEmergencyContact.setName(emergencyName);
		empEmergencyContact.setWorkTelephone(workTele);
		empEmergencyContact.setModifiedDate(date);
		try {
			EmpEmergencyContactLocalServiceUtil
					.addEmpEmergencyContact(empEmergencyContact);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("empId", empEmergencyContact.getEmployeeId());
		map.put("jsp", "jsp3");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	/**
	 * <p>
	 * This method inserts new EmpDependent record in database if the id is not
	 * existing, otherwise updates the record based on the record id.
	 * </p>
	 */
	public void updateAssignedDependents(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		System.out.println("updating dependents");
		System.out.println("dependent name is"
				+ ParamUtil.getString(actionRequest, "dependent_name"));
		long fileEntryId = ParamUtil.getLong(actionRequest, "dependentFileId");
		String name = ParamUtil.getString(actionRequest, "dependent_name");
		String relation = ParamUtil.getString(actionRequest,
				"dependent_relationship");
		Long empId = ParamUtil.getLong(actionRequest, "empDependentId");
		EmpDependent empDependent = null;
		try {
			empDependent = EmpDependentLocalServiceUtil
					.createEmpDependent(CounterLocalServiceUtil.increment());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empDependent.setEmployeeId(empId);
		empDependent.setCompanyId(themeDisplay.getCompanyId());
		empDependent.setGroupId(themeDisplay.getCompanyGroupId());
		empDependent.setUserId(themeDisplay.getUserId());
		empDependent.setCreateDate(date);
		empDependent.setModifiedDate(date);
		empDependent.setName(name);
		empDependent.setRelationship(relation);
		try {
			EmpDependentLocalServiceUtil.addEmpDependent(empDependent);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("empId", empDependent.getEmployeeId());
		map.put("jsp", "jsp4");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");

	}

	/**
	 * <p>
	 * This method inserts new EmpSupervisor and EmpSubordinate records in
	 * database
	 * </p>
	 */
	public void addReportToEmp(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		long fileEntryId = ParamUtil.getLong(actionRequest, "reportFileId");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		System.out.println("Constants.CMD: " + cmd);
		String reportTo = "", reportingMethod = "";
		Long empId = 0l;

		if (cmd.equals("sup_add")) {
			empId = ParamUtil.getLong(actionRequest, "empSupId");
			reportTo = ParamUtil.getString(actionRequest, "report_sup_name");
			reportingMethod = ParamUtil.getString(actionRequest,
					"reporting_sup_method");
			long supervisorId = ParamUtil
					.getLong(actionRequest, "supervisorId");
			EmpSupervisor empSupervisor = null;
			try {
				empSupervisor = EmpSupervisorLocalServiceUtil
						.createEmpSupervisor(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empSupervisor.setEmployeeId(empId);
			empSupervisor.setReporterEmployeeId(supervisorId);
			empSupervisor.setCreateDate(date);
			empSupervisor.setCompanyId(themeDisplay.getCompanyId());
			empSupervisor.setGroupId(themeDisplay.getCompanyGroupId());
			empSupervisor.setUserId(themeDisplay.getUserId());
			try {
				EmpSupervisorLocalServiceUtil.addEmpSupervisor(empSupervisor);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map map = new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp6");
			map.put("fileId", fileEntryId);
			actionRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage",
					"/html/employee/edit_employee.jsp");
		} else {
			empId = ParamUtil.getLong(actionRequest, "empSubId");
			reportTo = ParamUtil.getString(actionRequest, "report_sub_name");
			reportingMethod = ParamUtil.getString(actionRequest,
					"reporting_sub_method");
			Map map = new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp6");
			map.put("fileId", fileEntryId);
			actionRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage",
					"/html/employee/edit_employee.jsp");

		}
	}

	/**
	 * <p>
	 * This method inserts new EmpSkill,EmpEducation,EmpWorkExperience,
	 * EmpLanguage,EmpLicense records in database for a particular Employee
	 * </p>
	 */
	public void addQualifications(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		long fileEntryId = ParamUtil.getLong(actionRequest, "QualFileId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		Long empId = 0l;
		System.out.println("Constants.CMD: " + cmd);
		if (cmd.equals("empExperience")) {
			log.info("updating employee work experience");
			empId = ParamUtil.getLong(actionRequest, "empWrkExpId");
			String expCompany = ParamUtil.getString(actionRequest,
					"exp_company");
			String jobTitle = ParamUtil
					.getString(actionRequest, "exp_jobtitle");
			Date fromDate = ParamUtil.getDate(actionRequest, "exp_from_date",
					dateFormat);
			Date toDate = ParamUtil.getDate(actionRequest, "exp_to_date",
					dateFormat);
			String comments = ParamUtil
					.getString(actionRequest, "exp_comments");
			EmpWorkExp empWorkExp = null;
			try {
				empWorkExp = EmpWorkExpLocalServiceUtil
						.createEmpWorkExp(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			empWorkExp.setEmployeeId(empId);
			empWorkExp.setComment(comments);
			empWorkExp.setCompany(expCompany);
			empWorkExp.setFromDate(fromDate);
			empWorkExp.setToDate(toDate);
			empWorkExp.setJobTitle(jobTitle);
			empWorkExp.setCreateDate(date);
			empWorkExp.setModifiedDate(date);
			empWorkExp.setUserId(themeDisplay.getUserId());
			empWorkExp.setCompanyId(themeDisplay.getCompanyId());
			empWorkExp.setGroupId(themeDisplay.getCompanyGroupId());
			try {
				EmpWorkExpLocalServiceUtil.addEmpWorkExp(empWorkExp);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (cmd.equals("empEducation")) {
			log.info("updating employee education");
			empId = ParamUtil.getLong(actionRequest, "empEduId");
			long level = ParamUtil.getLong(actionRequest, "edu_level");
			String institute = ParamUtil.getString(actionRequest,
					"edu_institute");
			String splization = ParamUtil.getString(actionRequest, "edu_major");
			String year = ParamUtil.getString(actionRequest, "edu_year");
			String score = ParamUtil.getString(actionRequest, "edu_score");
			Date from = ParamUtil.getDate(actionRequest, "edu_from_date",
					dateFormat);
			Date to = ParamUtil.getDate(actionRequest, "edu_to_date",
					dateFormat);
			EmpEducation education = null;
			try {
				education = EmpEducationLocalServiceUtil
						.createEmpEducation(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			education.setEmployeeId(empId);
			education.setInstitute(institute);
			education.setMajor(splization);
			education.setYear(year);
			education.setStartDate(from);
			education.setEndDate(to);
			education.setEducationId(level);
			education.setCreateDate(date);
			education.setModifiedDate(date);
			education.setCompanyId(themeDisplay.getCompanyId());
			education.setGroupId(themeDisplay.getCompanyGroupId());
			education.setUserId(themeDisplay.getUserId());
			try {
				EmpEducationLocalServiceUtil.addEmpEducation(education);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (cmd.equals("empSkills")) {
			log.info("updating employee skills");
			empId = ParamUtil.getLong(actionRequest, "empSkillId");
			long skill = ParamUtil.getLong(actionRequest, "emp_skill");
			String exp = ParamUtil.getString(actionRequest, "skill_exp");
			String comments = ParamUtil.getString(actionRequest,
					"skill_comments");
			EmpSkill empSkill = null;
			try {
				empSkill = EmpSkillLocalServiceUtil
						.createEmpSkill(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empSkill.setEmployeeId(empId);
			empSkill.setYears(exp);
			empSkill.setComments(comments);
			empSkill.setSkillId(skill);
			empSkill.setCreateDate(date);
			empSkill.setModifiedDate(date);
			empSkill.setCompanyId(themeDisplay.getCompanyId());
			empSkill.setGroupId(themeDisplay.getCompanyGroupId());
			empSkill.setUserId(themeDisplay.getUserId());
			try {
				EmpSkillLocalServiceUtil.addEmpSkill(empSkill);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (cmd.equals("empLanguage")) {
			log.info("updating employee language");
			empId = ParamUtil.getLong(actionRequest, "empLanId");
			Long language = ParamUtil.getLong(actionRequest, "emp_language");
			String skill = ParamUtil.getString(actionRequest, "lan_skill");
			String fluency = ParamUtil.getString(actionRequest, "lan_fluency");
			EmpLanguage empLanguage = null;
			try {
				empLanguage = EmpLanguageLocalServiceUtil
						.createEmpLanguage(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empLanguage.setEmployeeId(empId);
			empLanguage.setLanguageId(language);
			empLanguage.setLanguageSkill(skill);
			empLanguage.setLanguageFluency(fluency);
			empLanguage.setCreateDate(date);
			empLanguage.setModifiedDate(date);
			empLanguage.setCompanyId(themeDisplay.getCompanyId());
			empLanguage.setGroupId(themeDisplay.getCompanyGroupId());
			empLanguage.setUserId(themeDisplay.getUserId());
			try {
				EmpLanguageLocalServiceUtil.addEmpLanguage(empLanguage);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (cmd.equals("empLicense")) {
			log.info("updating employee license");
			empId = ParamUtil.getLong(actionRequest, "empLicId");
			long licenseId = ParamUtil.getLong(actionRequest,
					"emp_license_type");
			String licenseNo = ParamUtil.getString(actionRequest,
					"emp_license_no");
			Date issueDate = ParamUtil.getDate(actionRequest,
					"license_issue_date", dateFormat);
			Date expiryDate = ParamUtil.getDate(actionRequest,
					"license_exp_date", dateFormat);
			EmpLicense empLicense = null;
			try {
				empLicense = EmpLicenseLocalServiceUtil
						.createEmpLicense(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empLicense.setEmployeeId(empId);
			empLicense.setExpiryDate(expiryDate);
			empLicense.setIssuedDate(issueDate);
			empLicense.setLicenseNumber(licenseNo);
			empLicense.setLicenseId(licenseId);
			empLicense.setCreateDate(date);
			empLicense.setModifiedDate(date);
			empLicense.setCompanyId(themeDisplay.getCompanyId());
			empLicense.setGroupId(themeDisplay.getCompanyGroupId());
			empLicense.setUserId(themeDisplay.getUserId());
			try {
				EmpLicenseLocalServiceUtil.addEmpLicense(empLicense);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		Map map = new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp7");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	public void updateEmpSalaryDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		System.out.println("in updateEmpSalaryDetails method");
		long empId = ParamUtil.getLong(actionRequest, "empSalId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "SalFileId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		String payGradeCurrency = ParamUtil.getString(actionRequest,
				"emp_paygrade_currency");
		Map map = new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp10");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	public void updateEmpDirectDeposits(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("in updateEmpDirectDeposits method ");
		long empId = ParamUtil.getLong(actionRequest, "empDirId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		long fileEntryId = ParamUtil.getLong(actionRequest, "directFileId");
		long amount = ParamUtil.getLong(actionRequest, "deposit_amount");
		long acntNumber = ParamUtil.getLong(actionRequest,
				"deposit_acnt_number");
		String finInst = ParamUtil.getString(actionRequest, "fin_institute");
		String acntType = ParamUtil.getString(actionRequest, "acnt_type");
		String brncLocation = ParamUtil.getString(actionRequest,
				"branch_location");
		String routingNo = ParamUtil.getString(actionRequest, "routing_number");
		EmpDirectDeposit empDirectDeposit = null;
		try {
			empDirectDeposit = EmpDirectDepositLocalServiceUtil
					.createEmpDirectDeposit(CounterLocalServiceUtil.increment());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empDirectDeposit.setAccountNumber(acntNumber);
		empDirectDeposit.setAccountType(acntType);
		empDirectDeposit.setAmount(amount);
		empDirectDeposit.setBankName(finInst);
		empDirectDeposit.setBranchLocation(brncLocation);
		empDirectDeposit.setEmployeeId(empId);
		empDirectDeposit.setRoutingNumber(routingNo);
		empDirectDeposit.setCreateDate(date);
		empDirectDeposit.setModifiedDate(date);
		empDirectDeposit.setCompanyId(themeDisplay.getCompanyId());
		empDirectDeposit.setGroupId(themeDisplay.getCompanyGroupId());
		empDirectDeposit.setUserId(themeDisplay.getUserId());
		try {
			EmpDirectDepositLocalServiceUtil
					.addEmpDirectDeposit(empDirectDeposit);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp11");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	public void addImmigrationDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		System.out.println("in addImmigrationDetails method");
		long empId = ParamUtil.getLong(actionRequest, "empImgId");
		String docType = ParamUtil.getString(actionRequest, "document_type");
		String number = ParamUtil.getString(actionRequest, "img_number");
		Date issuedDate = ParamUtil.getDate(actionRequest, "img_issued_date",
				dateFormat);
		String issuedBy = ParamUtil.getString(actionRequest, "issued_by");
		String eligibleStatus = ParamUtil.getString(actionRequest,
				"eligible_status");
		Date reviewDate = ParamUtil.getDate(actionRequest, "review_date",
				dateFormat);
		String comments = ParamUtil.getString(actionRequest, "img_comments");
		Date expiryDate = ParamUtil.getDate(actionRequest, "img_exp_date",
				dateFormat);
		long fileEntryId = ParamUtil.getLong(actionRequest, "immiFileId");
		EmpImmigrationDocument empImmigrationDocument = null;
		try {
			empImmigrationDocument = EmpImmigrationDocumentLocalServiceUtil
					.createEmpImmigrationDocument(CounterLocalServiceUtil
							.increment());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empImmigrationDocument.setEmployeeId(empId);
		empImmigrationDocument.setDocNumber(number);
		empImmigrationDocument.setIssuedBy(issuedBy);
		empImmigrationDocument.setIssuedDate(issuedDate);
		empImmigrationDocument.setExpiryDate(expiryDate);
		empImmigrationDocument.setEligibleStatus(eligibleStatus);
		empImmigrationDocument.setEligibleReviewDate(reviewDate);
		empImmigrationDocument.setComments(comments);
		empImmigrationDocument.setDocType(docType);
		empImmigrationDocument.setCreateDate(date);
		empImmigrationDocument.setModifiedDate(date);
		empImmigrationDocument.setCompanyId(themeDisplay.getCompanyId());
		empImmigrationDocument.setGroupId(themeDisplay.getCompanyGroupId());
		empImmigrationDocument.setUserId(themeDisplay.getUserId());
		try {
			EmpImmigrationDocumentLocalServiceUtil
					.addEmpImmigrationDocument(empImmigrationDocument);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("empId", empImmigrationDocument.getEmployeeId());
		map.put("jsp", "jsp5");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	public void updateMembership(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		System.out.println("in updateMembership method");
		long empId = ParamUtil.getLong(actionRequest, "empMemId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "memFileId");
		Map map = new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp8");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	public void updateEmpJobHistory(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		System.out.println("in updateEmpJobHistory method");
		long empId = ParamUtil.getLong(actionRequest, "empJId");
		Date joinedDate = ParamUtil.getDate(actionRequest, "joined_date",
				dateFormat);
		Date probationDte = ParamUtil.getDate(actionRequest, "probation_date",
				dateFormat);
		Date dateOfPermanency = ParamUtil.getDate(actionRequest,
				"date_permanency", dateFormat);
		long jobTitle = ParamUtil.getLong(actionRequest, "emp_job_title");
		long employmentStatus = ParamUtil.getLong(actionRequest, "emp_status");
		long jobCategory = ParamUtil.getLong(actionRequest, "emp_job_category");
		long subUnit = ParamUtil.getLong(actionRequest, "emp_sub_unit");
		long location = ParamUtil.getLong(actionRequest, "emp_location");
		Date effectiveDate = ParamUtil.getDate(actionRequest, "effective_date",
				dateFormat);
		long workshift = ParamUtil.getLong(actionRequest, "emp_workshift");
		String comments = ParamUtil.getString(actionRequest, "job_comments");
		long fileEntryId = ParamUtil.getLong(actionRequest, "jobFileId");
		EmpJob empJob = null;
		try {
			empJob = EmpJobLocalServiceUtil
					.createEmpJob(CounterLocalServiceUtil.increment());
		} catch (Exception e) {
			System.out.println("cannot add job details");
		}
		empJob.setEmployeeId(empId);
		empJob.setJoinedDate(joinedDate);
		empJob.setEffectiveDate(effectiveDate);
		empJob.setPermanentDate(dateOfPermanency);
		empJob.setEmploymentStatusId(employmentStatus);
		empJob.setJobCategoryId(jobCategory);
		empJob.setJobTitleId(jobTitle);
		empJob.setSubUnitId(subUnit);
		empJob.setLocationId(location);
		empJob.setProbationEndDate(probationDte);
		empJob.setComments(comments);
		empJob.setShiftId(workshift);
		empJob.setCreateDate(date);
		empJob.setModifiedDate(date);
		empJob.setCompanyId(themeDisplay.getCompanyId());
		empJob.setGroupId(themeDisplay.getCompanyGroupId());
		empJob.setUserId(themeDisplay.getUserId());
		try {
			EmpJobLocalServiceUtil.addEmpJob(empJob);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			System.out.println("cannot add job");
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp9");
		map.put("fileId", fileEntryId);
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();

		if (resourceRequest.getResourceID().equals("deleteEmergencyContact")) {
			log.info("deleting Emergency contact records");
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"emgContactIds");
			System.out.println(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						EmpEmergencyContactLocalServiceUtil
								.deleteEmpEmergencyContact(Long
										.parseLong(idsArray[i]));
						log.info("deleted");
					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
				} catch (NumberFormatException e) {
					log.info("selected all records to delete");
				}
			}

		}

		else if (resourceRequest.getResourceID().equals("updateImage9")) {
			System.out.println("upadateImage9");
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(resourceRequest);
			File newImage = uploadRequest.getFile("newImage");
			long fileEntryId2 = ParamUtil.getLong(uploadRequest,
					"imageIdtoUpdate");
			String changeLog = ParamUtil
					.getString(resourceRequest, "changeLog");
			ServiceContext serviceContext = null;
			try {
				try {
					serviceContext = ServiceContextFactory.getInstance(
							DLFileEntry.class.getName(), resourceRequest);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			} catch (PortalException e1) {
				System.out.println(e1.getMessage());
			}
			DLFileEntry updateImage = null;
			try {
				updateImage = DLFileEntryLocalServiceUtil
						.getDLFileEntry(fileEntryId2);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if (updateImage != null) {
				try {
					DLAppLocalServiceUtil.updateFileEntry(
							themeDisplay.getUserId(), fileEntryId2,
							newImage.getName(), "image/jpeg", "", "",
							changeLog, true, newImage, serviceContext);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			PrintWriter out = resourceResponse.getWriter();
			out.println("Image updated successfully");

		}

		else if (resourceRequest.getResourceID().equals("displayImage")) {
			long fileEntryId = ParamUtil.getLong(resourceRequest, "imageId");
			DLFileEntry b = null;
			try {
				b = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			InputStream is = null;
			try {
				is = b.getContentStream();
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}

			if (is != null) {
				byte[] imgData = null;
				imgData = IOUtils.toByteArray(is);
				if (imgData != null) {
					resourceResponse.setContentType("image/jpg");
					OutputStream o = resourceResponse.getPortletOutputStream();
					o.write(imgData);
					o.flush();
					o.close();
				}
			}
		} else if (resourceRequest.getResourceID().equals(
				"supervisorsAutoComplete")) {
			List<EmpPersonalDetails> l = null;
			try {
				l = EmpPersonalDetailsLocalServiceUtil.getEmpPersonalDetailses(
						-1, -1);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String userEnteredText = ParamUtil.getString(resourceRequest,
					"userEnteredText");
			JSONArray usersJSONArray = JSONFactoryUtil.createJSONArray();
			DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(
					EmpPersonalDetails.class,
					PortletClassLoaderUtil.getClassLoader());
			Criterion criterion = RestrictionsFactoryUtil.like("firstName",
					StringPool.PERCENT + userEnteredText + StringPool.PERCENT);
			userQuery.add(criterion);
			JSONObject userJSON = null;
			try {
				List<EmpPersonalDetails> userList = EmpPersonalDetailsLocalServiceUtil
						.dynamicQuery(userQuery);
				for (EmpPersonalDetails personalDetails : userList) {
					userJSON = JSONFactoryUtil.createJSONObject();
					userJSON.put("firstName", personalDetails.getFirstName());
					userJSON.put("id", personalDetails.getEmployeeId());
					System.out.println(personalDetails.getFirstName());
					System.out.println(personalDetails.getEmployeeId());
					usersJSONArray.put(userJSON);
				}
			} catch (Exception e) {
			}
			PrintWriter out = resourceResponse.getWriter();
			out.println(usersJSONArray.toString());
		} else if (resourceRequest.getResourceID().equals("dependencyDropdown")) {
			System.out.println("dependencyDropDowns");
			String currency = ParamUtil.getString(resourceRequest,
					"dropDownValue");
			System.out.println(currency);
			DynamicQuery currencyDynamicQuery = DynamicQueryFactoryUtil
					.forClass(PayGradeCurrency.class,
							PortletClassLoaderUtil.getClassLoader());
			currencyDynamicQuery.add(PropertyFactoryUtil.forName("payGradeId")
					.eq(Long.parseLong(currency)));
			List<PayGradeCurrency> list = null;
			try {
				list = PayGradeCurrencyLocalServiceUtil
						.dynamicQuery(currencyDynamicQuery);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			JSONArray currencyJsonArray = null;
			if (list != null) {
				currencyJsonArray = JSONFactoryUtil.createJSONArray();
				for (int i = 0; i < list.size(); i++) {
					PayGradeCurrency currencyObj = list.get(i);
					currencyJsonArray.put(currencyObj.getCurrency());
				}
			}
			PrintWriter out = resourceResponse.getWriter();
			System.out.println(currencyJsonArray.toString());
			out.write(currencyJsonArray.toString());
		} else {
			System.out.println("resource id not matched");
		}
	}

	public void addEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		Long location = ParamUtil.getLong(uploadRequest, "location");
		String firstName = ParamUtil.getString(uploadRequest,
				EMPLOYEE_FIRST_NAME_COL_NAME);
		System.out.println("location is" + location);
		String middleName = ParamUtil.getString(uploadRequest,
				EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(uploadRequest,
				EMPLOYEE_LAST_NAME_COL_NAME);
		String empNo = ParamUtil.getString(uploadRequest, "employee_no");
		String username = ParamUtil.getString(uploadRequest, "user_name");
		String password = ParamUtil.getString(uploadRequest, "password");
		File uploadPhoto = uploadRequest.getFile("emp_photograph");
		String contentType = MimeTypesUtil.getContentType(uploadPhoto);
		// String contentType = uploadRequest.getContentType("photograph");
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
		ServiceContext serviceContext = null;
		FileEntry fileEntry = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), actionRequest);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fileEntry = DLAppLocalServiceUtil.addFileEntry(
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					0, "img" + empPersonalDetails.getEmployeeId(), contentType,
					"img" + empPersonalDetails.getEmployeeId(), contentType,
					" ", uploadPhoto, serviceContext);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			System.out.println("cannot upload file");
			e1.printStackTrace();
		}
		if (fileEntry.getExpandoBridge().hasAttribute("employeeId")) {
			fileEntry.getExpandoBridge().setAttribute("employeeId",
					String.valueOf(employee.getEmployeeId()));
			/*
			 * try {
			 * DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(),
			 * fileEntry.getFileEntryId(), uploadPhoto.getName(), contentType,
			 * uploadPhoto.getName(),uploadPhoto.getName(), changeLog,
			 * false,uploadPhoto, serviceContext); } catch (PortalException e) {
			 * e.printStackTrace(); }
			 * System.out.println("expando value is=============="
			 * +fileEntry.getExpandoBridge().getAttribute("employeeId")); }
			 */
		} else {
			System.out.println("no expando available");
			try {
				fileEntry.getExpandoBridge().addAttribute("employeeId");
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		fileEntry.getExpandoBridge().setAttribute("employeeId",
				String.valueOf(employee.getEmployeeId()));
		try {
			DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(),
					fileEntry.getFileEntryId(), uploadPhoto.getName(),
					contentType, uploadPhoto.getName(), uploadPhoto.getName(),
					changeLog, false, uploadPhoto, serviceContext);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		System.out.println("expando value is=============="
				+ fileEntry.getExpandoBridge().getAttribute("employeeId"));

		if (username != null || password != null) {
			User user = null;
			try {
				user = UserLocalServiceUtil.addUser(themeDisplay.getUserId(),
						themeDisplay.getCompanyId(), false, password, password,
						true, username + "screenName", username
								+ "@liferay.com", 0L, "",
						themeDisplay.getLocale(), username + firstName,
						middleName, username + lastName, 0, 0, false, 0, 1,
						1970, "Job Title", null, null, null, null, false,
						new ServiceContext());
				if (user.getExpandoBridge().hasAttribute("employeeId")) {
					user.getExpandoBridge().setAttribute("employeeId",
							String.valueOf(employee.getEmployeeId()));
					UserLocalServiceUtil.updateUser(user);
					System.out.println("expando value is=============="
							+ user.getExpandoBridge()
									.getAttribute("employeeId"));
				} else {
					System.out.println("no expando available");
					user.getExpandoBridge().addAttribute("employeeId");
					user.getExpandoBridge().setAttribute("employeeId",
							String.valueOf(employee.getEmployeeId()));
					UserLocalServiceUtil.updateUser(user);
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (user != null) {
				Employee employee2 = null;
				try {
					employee2 = EmployeeLocalServiceUtil.getEmployee(employee
							.getEmployeeId());
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				employee3.setImageId(fileEntry.getFileEntryId());
				EmployeeLocalServiceUtil.updateEmployee(employee3);

			}
		}
		Map map = new HashMap();
		map.put("empId", employee.getEmployeeId());
		map.put("jsp", "jsp0");
		map.put("fileId", fileEntry.getFileEntryId());
		actionRequest.getPortletSession(true).setAttribute("empId", map,
				PortletSession.APPLICATION_SCOPE);

	}

	public void updatePersonalDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		Long empId = ParamUtil.getLong(actionRequest, "perEmpId");
		String firstName = ParamUtil.getString(actionRequest,
				EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(actionRequest,
				EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(actionRequest,
				EMPLOYEE_LAST_NAME_COL_NAME);
		String empNo = ParamUtil.getString(actionRequest, "employee_no");
		String otherId = ParamUtil.getString(actionRequest, "other_id");
		String driverLicenseNo = ParamUtil.getString(actionRequest,
				"driver_license_no");
		Date expiryDate = ParamUtil.getDate(actionRequest, "expiry_date", null);
		String gender = ParamUtil.getString(actionRequest, "gender");
		String maritalStatus = ParamUtil.getString(actionRequest,
				"marital_status");
		String nationality = ParamUtil.getString(actionRequest,
				"emp_nationality");
		Date dateOfB = ParamUtil.getDate(actionRequest, "date_of_birth", null);
		long perEmpId = ParamUtil.getLong(actionRequest, "personalDetailsId");
		long fileEntryId = ParamUtil.getLong(actionRequest, "fileIdemp");
		System.out.println("file entry id is" + fileEntryId);
		EmpPersonalDetails empPersonalDetails = null;
		log.info("first name and last anme are" + " " + firstName + " "
				+ lastName + " " + empId);
		try {
			empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
					.getEmpPersonalDetails(perEmpId);
		} catch (PortalException e) {

			e.printStackTrace();
		} catch (SystemException e) {

			e.printStackTrace();
		}
		if (empPersonalDetails != null) {
			empPersonalDetails.setFirstName(firstName);
			empPersonalDetails.setMiddleName(middleName);
			empPersonalDetails.setLastName(lastName);
			empPersonalDetails.setDateOfBirth(dateOfB);
			empPersonalDetails.setEmployeeNo(empNo);
			empPersonalDetails.setLicenseExpDate(expiryDate);
			empPersonalDetails.setLicenseNo(driverLicenseNo);
			empPersonalDetails.setOtherId(otherId);

			try {
				EmpPersonalDetailsLocalServiceUtil
						.updateEmpPersonalDetails(empPersonalDetails);
			} catch (SystemException e) {

				e.printStackTrace();
			}
			Map map = new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp2");
			map.put("fileId", fileEntryId);
			actionRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
		}
	}

	public void updateEmpDocuments(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException,
			SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		long employeeId = ParamUtil.getLong(uploadRequest, "docEmployeeId");
		System.out.println(employeeId);
		String docCategory = ParamUtil.getString(uploadRequest,
				"doc_related_to");
		File document = uploadRequest.getFile("emp_files");
		long fileEntryId = ParamUtil.getLong(uploadRequest, "QualFileId");
		System.out.println("image id is" + fileEntryId);
		ServiceContext serviceContext = null;
		String changeLog = ParamUtil.getString(uploadRequest, "changeLog");
		String contentType = MimeTypesUtil.getContentType(document);
		FileEntry fileEntry = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), actionRequest);
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		try {
			fileEntry = DLAppLocalServiceUtil.addFileEntry(
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					0, document.getName(), contentType, docCategory, "", " ",
					document, serviceContext);
		} catch (PortalException e1) {
			System.out.println("cannot upload file");
			e1.printStackTrace();
		}
		if (fileEntry != null) {
			if (fileEntry.getExpandoBridge().hasAttribute("employeeId")) {
				fileEntry.getExpandoBridge().setAttribute("employeeId",
						String.valueOf(employeeId));
			}
			/*
			 * try {
			 * DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(),
			 * fileEntry.getFileEntryId(), document.getName(),
			 * contentType,document.getName(),document.getName(), changeLog,
			 * false,document, serviceContext); } catch (PortalException e) {
			 * e.printStackTrace(); }
			 * System.out.println("expando value is=============="
			 * +fileEntry.getExpandoBridge().getAttribute("employeeId")); }
			 */
			else {
				System.out.println("no expando available");
				try {
					fileEntry.getExpandoBridge().addAttribute("employeeId");
				} catch (PortalException e) {
					e.printStackTrace();
				}
				fileEntry.getExpandoBridge().setAttribute("employeeId",
						String.valueOf(employeeId));
			}

			try {
				DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(),
						fileEntry.getFileEntryId(), document.getName(),
						contentType, document.getName(), document.getName(),
						changeLog, false, document, serviceContext);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			System.out.println("expando value is=============="
					+ fileEntry.getExpandoBridge().getAttribute("employeeId"));

			Map map = new HashMap();
			map.put("jsp", "jsp12");
			map.put("empId", employeeId);
			map.put("fileId", fileEntryId);
			actionRequest.getPortletSession(true).setAttribute("empId", map,
					PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage",
					"/html/employee/edit_employee.jsp");
		} else {
			System.out
					.println("====error occured while processing the request");
		}

	}
	public void addContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
	}
}
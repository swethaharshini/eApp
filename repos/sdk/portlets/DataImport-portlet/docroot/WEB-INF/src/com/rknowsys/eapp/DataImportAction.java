package com.rknowsys.eapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmpJob;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.EmpSupervisor;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;
import com.rknowsys.eapp.hrm.model.JobTitle;
import com.rknowsys.eapp.hrm.model.SubUnit;
import com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSupervisorLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SubUnitLocalServiceUtil;

public class DataImportAction extends MVCPortlet {

	/**
	 * This method saves uploaded file into the server folder.And stores the
	 * file data into the database.
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void saveDataImport(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		System.out.println("saveDataImport method()..!!!!!!!!!!");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Properties properties = PortalUtil.getPortalProperties();
		String uploadDirectory = properties.getProperty("liferay.home")
				+ "/data/uploadedFiles";
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		byte[] bytes = null;

		try {
			// ==========Saving the uploaded file in server folder with uploaded
			// date and time as file filename prefix.===========

			Date date = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("mm-dd-yyyy");
			String d = sd.format(date);
			System.out.println("uploaded date = " + d);
			File uploadedFile = uploadRequest.getFile("fileName");

			bytes = FileUtil.getBytes(uploadedFile);

			String fileName = uploadRequest.getFileName("fileName");
			File newFile = null;
			File newDirectory = new File(uploadDirectory);
			if (!newDirectory.exists()) {
				System.out.println("directory does not exist");
				Path directoryPath = Paths.get(uploadDirectory);
				Files.createDirectory(directoryPath.getParent());
			}
			newFile = new File(uploadDirectory + "/" + d
					+ Calendar.getInstance().getTimeInMillis() + fileName);

			// ============Creating the New file in server folder===========

			if (!newFile.exists()) {
				System.out.println("file does not exist");
				Path pathToFile = Paths.get(uploadDirectory + "/" + d
						+ Calendar.getInstance().getTimeInMillis() + fileName);
				Files.createFile(pathToFile);

			}
			// =========Reading the uploaded file content and writing the
			// content to newly created file==============
			FileInputStream fileInputStream = new FileInputStream(uploadedFile);

			fileInputStream.read(bytes);
			FileOutputStream fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(bytes, 0, bytes.length);
			fileOutputStream.close();
			fileInputStream.close();

			String filePath = newFile.getAbsolutePath();
			System.out.println("filePath = " + filePath);

			FileInputStream file1 = new FileInputStream(new File(filePath));

			// Reading Excel file Rows and cells content using apache poi api
			// and saving the data in to the database.

			XSSFWorkbook workbook = new XSSFWorkbook(file1); // Create Workbook
																// instance
																// holding
																// reference to
																// .xlsx file

			XSSFSheet sheet = workbook.getSheetAt(0); // Get first/desired sheet
														// from the workbook

			@SuppressWarnings("rawtypes")
			Iterator rows = sheet.rowIterator(); // Iterate through each rows
													// one by one

			while (rows.hasNext()) {

				XSSFRow row = (XSSFRow) rows.next();
				if (row.getRowNum() != 0) {
					EmpPersonalDetails empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
							.createEmpPersonalDetails(CounterLocalServiceUtil
									.increment());
					Employee employee = EmployeeLocalServiceUtil.createEmployee(CounterLocalServiceUtil.increment());
					JobTitle jobTitle = JobTitleLocalServiceUtil.createJobTitle(CounterLocalServiceUtil.increment());
					SubUnit subUnit = SubUnitLocalServiceUtil.createSubUnit(CounterLocalServiceUtil.increment());
					EmploymentStatus employmentStatus = EmploymentStatusLocalServiceUtil.createEmploymentStatus(CounterLocalServiceUtil.increment());
					EmpJob empJob = EmpJobLocalServiceUtil.createEmpJob(CounterLocalServiceUtil.increment());
					EmpSupervisor empSupervisor = EmpSupervisorLocalServiceUtil.createEmpSupervisor(CounterLocalServiceUtil.increment());
					@SuppressWarnings("rawtypes")
					Iterator cells = row.cellIterator();

					while (cells.hasNext()) {

						XSSFCell cell = (XSSFCell) cells.next();
						if (cell.getColumnIndex() == 0) {
							empPersonalDetails.setFirstName(cell.toString());
						}
						if (cell.getColumnIndex() == 1) {
							empPersonalDetails.setMiddleName(cell.toString());
						}
						if (cell.getColumnIndex() == 2) {
							empPersonalDetails.setLastName(cell.toString());
						}
						if (cell.getColumnIndex() == 3) {
							empPersonalDetails
									.setEmployeeNo(cell.getRawValue());
						}
						if (cell.getColumnIndex() == 4) {
							empPersonalDetails.setLicenseNo(cell.getRawValue());
						}
						if(cell.getColumnIndex() ==5){
							jobTitle.setTitle(cell.toString());
						}
						if(cell.getColumnIndex() ==6){
							employmentStatus.setEmploymentstatus(cell.toString());
						}
						if(cell.getColumnIndex() ==7){
							subUnit.setName(cell.toString());
						}

					}
					employee.setUserId(themeDisplay.getUserId());
					employee.setGroupId(themeDisplay.getCompanyGroupId());
					employee.setCompanyId(themeDisplay.getCompanyId());
					employee.setCreateDate(date);
					employee.setModifiedDate(date);
					employee = EmployeeLocalServiceUtil.addEmployee(employee);
					
					empPersonalDetails.setUserId(themeDisplay.getUserId());
					empPersonalDetails.setGroupId(themeDisplay.getCompanyGroupId());
					empPersonalDetails.setCompanyId(themeDisplay.getCompanyId());
					empPersonalDetails.setCreateDate(date);
					empPersonalDetails.setModifiedDate(date);
					empPersonalDetails.setEmployeeId(employee.getEmployeeId());
					empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
							.addEmpPersonalDetails(empPersonalDetails);
					
					jobTitle.setUserId(themeDisplay.getUserId());
					jobTitle.setGroupId(themeDisplay.getCompanyGroupId());
					jobTitle.setCompanyId(themeDisplay.getCompanyId());
					jobTitle.setCreateDate(date);
					jobTitle.setModifiedDate(date);
					jobTitle = JobTitleLocalServiceUtil.addJobTitle(jobTitle);
					
					subUnit.setUserId(themeDisplay.getUserId());
					subUnit.setGroupId(themeDisplay.getCompanyGroupId());
					subUnit.setCompanyId(themeDisplay.getCompanyId());
					subUnit.setCreateDate(date);
					subUnit.setModifiedDate(date);
					subUnit = SubUnitLocalServiceUtil.addSubUnit(subUnit);
					
					employmentStatus.setUserId(themeDisplay.getUserId());
					employmentStatus.setGroupId(themeDisplay.getCompanyGroupId());
					employmentStatus.setCompanyId(themeDisplay.getCompanyId());
					employmentStatus.setCreateDate(date);
					employmentStatus.setModifiedDate(date);
					employmentStatus = EmploymentStatusLocalServiceUtil.addEmploymentStatus(employmentStatus);
					
					
					empJob.setJobTitleId(employee.getEmployeeId());
					empJob.setEmploymentStatusId(employmentStatus.getEmploymentStatusId());
					empJob.setSubUnitId(subUnit.getSubUnitId());
					empJob.setUserId(themeDisplay.getUserId());
					empJob.setGroupId(themeDisplay.getCompanyGroupId());
					empJob.setCompanyId(themeDisplay.getCompanyId());
					empJob.setCreateDate(date);
					empJob.setModifiedDate(date);
					empJob.setEmployeeId(employee.getEmployeeId());
					empJob = EmpJobLocalServiceUtil.addEmpJob(empJob);
					
					
					
					empSupervisor.setUserId(themeDisplay.getUserId());
					empSupervisor.setGroupId(themeDisplay.getCompanyGroupId());
					empSupervisor.setCompanyId(themeDisplay.getCompanyId());
					empSupervisor.setCreateDate(date);
					empSupervisor.setModifiedDate(date);
					empSupervisor.setEmployeeId(employee.getEmployeeId());
					empSupervisor.setReporterEmployeeId(empPersonalDetails.getEmployeeId());
					empSupervisor = EmpSupervisorLocalServiceUtil.addEmpSupervisor(empSupervisor);
				}

			}
			file1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method downloads the sample file stored in server folder.
	 */
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws PortletException,
			IOException {
		if (resourceRequest.getResourceID().equals("fileDownload")) {
			
			Properties properties = PortalUtil.getPortalProperties();
			String uploadDirectory = properties.getProperty("liferay.home")
					+ "/samplefiles/";

			System.out.println("File downloading Started...");
			resourceResponse.setContentType("text/html");
			PrintWriter out = resourceResponse.getWriter();
			String filename = "importData.csv";
			resourceResponse.setContentType("APPLICATION/OCTET-STREAM");

			resourceResponse.setProperty("Content-Disposition",
					"attachment; filename=\"" + filename + "\"");

			FileInputStream fileInputStream = new FileInputStream(uploadDirectory
					+ filename);

			int i;
			while ((i = fileInputStream.read()) != -1) {

				out.write(i);
			}
			fileInputStream.close();
			out.close();
			System.out.println("End of file Download");
		}

	}
}

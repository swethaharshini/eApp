package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.JobCategory;
import com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil;

/**
 * 
 * @author Laxminarayana 31 october 2014 3:08:55 PM
 * 
 */
public class JobCategoryAction extends MVCPortlet {

	Date date = new Date();

	/**
	 * <p>
	 * This method inserts new jobcategory record in database if the id is not
	 * exits, otherwise updates the record based on the record id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveJobcategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		System.out.println("inside saveJobCategory...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		System.out.println("company Id == " + themeDisplay.getCompanyId());
		System.out.println("userId = " + themeDisplay.getUserId());
		System.out.println("groupId = " + themeDisplay.getCompanyGroupId());
		try {
			JobCategory jobcategory = JobCategoryLocalServiceUtil
					.createJobCategory(CounterLocalServiceUtil.increment());

			System.out.println("Name = "
					+ ParamUtil.getString(actionRequest, "jobcategoryId"));
			System.out.println("country = "
					+ ParamUtil.getString(actionRequest, "jobcategory"));
			String id = ParamUtil.getString(actionRequest, "jobcategoryId");
			System.out.println("id == " + id);
			if (id == "" || id == null) {
				System.out.println("inside if loop...");
				jobcategory.setJobcategory(ParamUtil.getString(actionRequest,
						"jobcategory"));
				jobcategory.setCreateDate(date);
				jobcategory.setModifiedDate(date);
				jobcategory.setCompanyId(themeDisplay.getCompanyId());
				jobcategory.setGroupId(themeDisplay.getCompanyGroupId());
				jobcategory.setUserId(themeDisplay.getUserId());
				jobcategory = JobCategoryLocalServiceUtil
						.addJobCategory(jobcategory);
				System.out.println("end of if block");
			} else {
				System.out.println("else block to update...");

				long jobcategoryid = Long.parseLong(id);

				JobCategory jobcategory1 = JobCategoryLocalServiceUtil
						.getJobCategory(jobcategoryid);

				jobcategory1.setJobCategoryId(ParamUtil.getLong(actionRequest,
						"jobcategoryId"));

				jobcategory1.setJobcategory(ParamUtil.getString(actionRequest,
						"jobcategory"));
				jobcategory1.setModifiedDate(date);
				jobcategory1.setCompanyId(themeDisplay.getCompanyId());
				jobcategory1.setGroupId(themeDisplay.getCompanyGroupId());
				jobcategory1.setUserId(themeDisplay.getUserId());

				jobcategory1 = JobCategoryLocalServiceUtil
						.updateJobCategory(jobcategory1);
				System.out.println("end of else block");

			}
		} catch (SystemException e) {

			e.printStackTrace();
			System.out.println("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			System.out.println("portalexception");
		}
		System.out.println("end of the saveJobcategory method");

	}

	/**
	 * <p>
	 * This method deletes the jobcategory record from database based on
	 * jobcategory record Id
	 * </p>
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			NumberFormatException {
		if (resourceRequest.getResourceID().equals("deleteJobcategory")) {

			System.out.println("inside deleteJobCategory... serveResource");
			JobCategory jobcategory;
			try {
				jobcategory = JobCategoryLocalServiceUtil
						.createJobCategory(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"jobcategoryIds");

			System.out.println("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {
				System.out.println(idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {
				System.out.println(idsArray[i]);
				if (idsArray[i].equals("on")) {
					System.out.println("All records selected...");
				} else {
					try {
						jobcategory = JobCategoryLocalServiceUtil
								.deleteJobCategory(Long.parseLong(idsArray[i]));
						System.out.println("end of try block in delete...");
					} catch (PortalException e) {

						e.printStackTrace();
						System.out.println("portal exception...");
					} catch (SystemException e) {

						e.printStackTrace();
						System.out.println("system exception...");
					}
				}

			}
			System.out.println("end of for loop..");

		}
		System.out.println("end of deleteJobcategory method...");

	}

	/**
	 * <p>
	 * This method gets the single jobcategory record from database based on the
	 * given jobcategory Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single jobcategory record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editJobcategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		System.out.println("inside editJobCategory...");
		String s = ParamUtil.getString(actionRequest, "jobCategoryId");
		System.out.println("id == " + s);
		JobCategory job = JobCategoryLocalServiceUtil.getJobCategory(Long
				.parseLong(s));

		System.out.println(job.getJobCategoryId());
		System.out.println(job.getJobcategory());
		actionRequest.setAttribute("editjobcategory", job);
		actionResponse.setRenderParameter("jspPage",
				"/html/jobcategory/edit.jsp");
	}

}

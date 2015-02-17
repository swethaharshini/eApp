package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
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

	private static Logger log = Logger.getLogger(JobCategoryAction.class);

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
		log.info("Entered into saveJobCategory method in JobCategoryAction");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(actionRequest, "jobcategoryId");
		String inputName = ParamUtil.getString(actionRequest, "jobcategory");
		String jobcategoryName = inputName.trim();
		log.info(id);
		log.info(inputName);

		try {
			if (id == "" || id == null) {
				log.info("if looop");
				if (jobcategoryName == null || jobcategoryName.equals("")) {

					log.info("Empty value in jobCategoryName");

					SessionMessages.add(actionRequest.getPortletSession(),
							"jobcategoryName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/jobcategory/add.jsp");
				} else {

					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(JobCategory.class,
									PortalClassLoaderUtil.getClassLoader());
					dynamicQuery.add(RestrictionsFactoryUtil.eq("jobcategory",
							inputName));
					dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId",
							themeDisplay.getLayout().getGroup().getGroupId()));
					@SuppressWarnings("unchecked")
					List<JobCategory> jobCategories = JobCategoryLocalServiceUtil
							.dynamicQuery(dynamicQuery);
					if (jobCategories.size() > 0) {

						JobCategory category = jobCategories.get(0);
						if (category.getJobcategory().equalsIgnoreCase(
								inputName)) {
							log.info("DuplicateName in JobCategoryName");

							SessionMessages.add(
									actionRequest.getPortletSession(),
									"jobCategoryName-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/jobcategory/add.jsp");

						}

					}

					else {

						JobCategory jobcategory = JobCategoryLocalServiceUtil
								.createJobCategory(CounterLocalServiceUtil
										.increment());

						jobcategory.setJobcategory(ParamUtil.getString(
								actionRequest, "jobcategory"));
						jobcategory.setCreateDate(date);
						jobcategory.setModifiedDate(date);
						jobcategory.setCompanyId(themeDisplay.getCompanyId());
						jobcategory.setGroupId(themeDisplay.getLayout()
								.getGroup().getGroupId());
						jobcategory.setUserId(themeDisplay.getUserId());
						jobcategory = JobCategoryLocalServiceUtil
								.addJobCategory(jobcategory);
						log.info("New jobCategoryName added");
					}
				}
			} else {
				JobCategory job = JobCategoryLocalServiceUtil
						.getJobCategory(Long.parseLong(id));
				log.info("else block to update the jobCategoryName");
				if (jobcategoryName == null || jobcategoryName.equals("")) {
					log.info("empty value in jobcategory name in edit.jsp");

					

					PortletSession portletSession = actionRequest
							.getPortletSession();
					portletSession.setAttribute("editjobcategory", job);
					SessionMessages.add(actionRequest.getPortletSession(),
							"jobcategoryName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/jobcategory/edit.jsp");
				} else {
					
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(JobCategory.class,
									PortalClassLoaderUtil.getClassLoader());
					dynamicQuery.add(RestrictionsFactoryUtil.eq("jobcategory",
							inputName));
					dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId",
							themeDisplay.getLayout().getGroup().getGroupId()));
					@SuppressWarnings("unchecked")
					List<JobCategory> jobCategories = JobCategoryLocalServiceUtil
							.dynamicQuery(dynamicQuery);
					log.info("list size ====== " +jobCategories.size());
					if (jobCategories.size() > 0) {
						log.info("if loop ...greater than one");

						JobCategory category = jobCategories.get(0);
						if (category.getJobcategory().equalsIgnoreCase(
								inputName) && !job.getJobcategory().equalsIgnoreCase(inputName)) {
							log.info("DuplicateName in JobCategoryName");

							SessionMessages.add(
									actionRequest.getPortletSession(),
									"jobCategoryName-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/jobcategory/add.jsp");

						}

					}
					else{

					long jobcategoryid = Long.parseLong(id);

					JobCategory jobcategory1 = JobCategoryLocalServiceUtil
							.getJobCategory(jobcategoryid);

					jobcategory1.setJobCategoryId(ParamUtil.getLong(
							actionRequest, "jobcategoryId"));

					jobcategory1.setJobcategory(ParamUtil.getString(
							actionRequest, "jobcategory"));
					jobcategory1.setModifiedDate(date);
					jobcategory1.setCompanyId(themeDisplay.getCompanyId());
					jobcategory1.setGroupId(themeDisplay.getLayout().getGroup()
							.getGroupId());
					jobcategory1.setUserId(themeDisplay.getUserId());

					jobcategory1 = JobCategoryLocalServiceUtil
							.updateJobCategory(jobcategory1);
					log.info("jobcategoryName updated..");

				}}
			}

		} catch (SystemException e) {
			log.error("SystemException " + e);
		} catch (PortalException e) {

			log.error("PortalException " + e);
		}
		log.info("End of savejobcategory method");

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

			log.info("inside deleteJobCategory... serveResource");
			JobCategory jobcategory;
			try {
				jobcategory = JobCategoryLocalServiceUtil
						.createJobCategory(CounterLocalServiceUtil.increment());
				log.info(jobcategory);
			} catch (SystemException e1) {

				log.error("SystemException " + e1);
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"jobcategoryIds");

			log.info("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info(idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info(idsArray[i]);
				if (idsArray[i].equals("on")) {
					log.info("All records selected...");
				} else {
					try {
						jobcategory = JobCategoryLocalServiceUtil
								.deleteJobCategory(Long.parseLong(idsArray[i]));
						log.info("end of try block in delete...");
					} catch (PortalException e) {

						log.error("PortalException " + e);

					} catch (SystemException e) {

						log.error("SystemException " + e);
					}
				}

			}
			log.info("end of for loop..");

		}
		log.info("end of deleteJobcategory method...");

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
		log.info("inside editJobCategory...");
		String s = ParamUtil.getString(actionRequest, "jobCategoryId");
		System.out.println("id == " + s);
		JobCategory job = JobCategoryLocalServiceUtil.getJobCategory(Long
				.parseLong(s));

		log.info(job.getJobCategoryId());
		log.info(job.getJobcategory());

		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editjobcategory", job);
		actionResponse.setRenderParameter("jspPage",
				"/html/jobcategory/edit.jsp");
	}

}

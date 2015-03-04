package com.rknowsys.eapp;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.JobTitle;
import com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;

/**
 * 
 * @author Laxminarayana 31 october 2014 3:08:55 PM
 * 
 */
public class JobTitleAction extends MVCPortlet {

	private static Logger log = Logger.getLogger(JobTitleAction.class);
	JobTitle jobtitles;
	Date date = new Date();

	/**
	 * <p>
	 * This method inserts new jobtitle record in database if the id is not
	 * exits, otherwise updates the record based on the record id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void saveJobtitle(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		log.info("inside saveJobtitle.....");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {

			String id = ParamUtil.getString(actionRequest, "jobtitleId");
			String title = ParamUtil.getString(actionRequest, "title");
			String jobtitle = title.trim();

			log.info("Name = " + ParamUtil.getString(actionRequest, "title"));
			log.info("country = "
					+ ParamUtil.getString(actionRequest, "description"));

			log.info("id == " + id);
			if (id == "" || id == null) {
				log.info("inside if loop...");

				if (jobtitle == null || jobtitle.equals("")) {
					log.info("empty value in jobtitleName ");

					SessionMessages.add(actionRequest.getPortletSession(),
							"jobtitleName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/jobtitle/add.jsp");

				} else {
					Criterion criterion = null;
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(JobTitle.class,
									PortletClassLoaderUtil.getClassLoader());
					criterion = RestrictionsFactoryUtil.eq("title", title);
					try {
						criterion = RestrictionsFactoryUtil.and(criterion,
								RestrictionsFactoryUtil.eq("groupId",
										themeDisplay.getLayout().getGroup()
												.getGroupId()));
						dynamicQuery.add(criterion);
					} catch (PortalException e1) {
						log.error("PortalException " + e1);
					}
					@SuppressWarnings("unchecked")
					List<JobTitle> jobTitles = JobTitleLocalServiceUtil
							.dynamicQuery(dynamicQuery);
					if (jobTitles.size() > 0) {

						JobTitle jobTitle2 = jobTitles.get(0);
						if (jobTitle2.getTitle().equalsIgnoreCase(title)) {

							log.info("DuplicateName in jobtitleName");

							SessionMessages.add(
									actionRequest.getPortletSession(),
									"jobtitleName-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/jobtitle/add.jsp");

						}

					} else {

						JobTitle jobtitles = JobTitleLocalServiceUtil
								.createJobTitle(CounterLocalServiceUtil
										.increment());
						jobtitles.setTitle(ParamUtil.getString(actionRequest,
								"title"));
						jobtitles.setDescription(ParamUtil.getString(
								actionRequest, "description"));
						jobtitles.setNotes(ParamUtil.getString(actionRequest,
								"notes"));
						jobtitles.setCreateDate(date);
						jobtitles.setModifiedDate(date);
						jobtitles.setCompanyId(themeDisplay.getCompanyId());
						jobtitles.setGroupId(themeDisplay.getLayout()
								.getGroup().getGroupId());
						jobtitles.setUserId(themeDisplay.getUserId());

						jobtitles = JobTitleLocalServiceUtil
								.addJobTitle(jobtitles);
						log.info("jobtitleName added");
					}
				}

			} else {
				log.info("else block to update...");

				if (jobtitle == null || jobtitle.equals("")) {

					log.info("empty value in jobtitleName in edit.jsp");

					JobTitle jobTitle = JobTitleLocalServiceUtil
							.getJobTitle(Long.parseLong(id));
					PortletSession portletSession = actionRequest
							.getPortletSession();
					portletSession.setAttribute("editjobtitle", jobTitle);

					SessionMessages.add(actionRequest.getPortletSession(),
							"jobtitleName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/jobtitle/add.jsp");

				} else {
					JobTitle jobTitle2 = JobTitleLocalServiceUtil.getJobTitle(Long.parseLong(id));
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(JobTitle.class,
									PortalClassLoaderUtil.getClassLoader());
					dynamicQuery.add(RestrictionsFactoryUtil.eq("title",
							title));
					dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId",
							themeDisplay.getLayout().getGroup().getGroupId()));
					@SuppressWarnings("unchecked")
					List<JobTitle> JobTitles = JobCategoryLocalServiceUtil
							.dynamicQuery(dynamicQuery);
					
					if (JobTitles.size() > 0) {
						log.info("if loop ...greater than one");

						JobTitle category = JobTitles.get(0);
						if (category.getTitle().equalsIgnoreCase(
								title) && !jobTitle2.getTitle().equalsIgnoreCase(title)) {
							log.info("DuplicateName in JobTitleName");

							SessionMessages.add(
									actionRequest.getPortletSession(),
									"jobtitleName-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/jobtitle/add.jsp");

						}
						else{
							long jobtitleid = Long.parseLong(id);
							JobTitle jobtitles1 = JobTitleLocalServiceUtil
									.getJobTitle(jobtitleid);

							jobtitles1.setJobTitleId(ParamUtil.getLong(actionRequest,
									"jobtitleId"));
							jobtitles1.setTitle(ParamUtil.getString(actionRequest,
									"title"));
							jobtitles1.setDescription(ParamUtil.getString(
									actionRequest, "description"));
							jobtitles1.setNotes(ParamUtil.getString(actionRequest,
									"notes"));
							jobtitles1.setModifiedDate(date);

							jobtitles1.setCompanyId(themeDisplay.getCompanyId());
							jobtitles1.setGroupId(themeDisplay.getLayout().getGroup()
									.getGroupId());
							jobtitles1.setUserId(themeDisplay.getUserId());

							jobtitles1 = JobTitleLocalServiceUtil
									.updateJobTitle(jobtitles1);
							log.info("jobtitleName updated");
							
							
						}

					}
					else{

					long jobtitleid = Long.parseLong(id);
					JobTitle jobtitles1 = JobTitleLocalServiceUtil
							.getJobTitle(jobtitleid);

					jobtitles1.setJobTitleId(ParamUtil.getLong(actionRequest,
							"jobtitleId"));
					jobtitles1.setTitle(ParamUtil.getString(actionRequest,
							"title"));
					jobtitles1.setDescription(ParamUtil.getString(
							actionRequest, "description"));
					jobtitles1.setNotes(ParamUtil.getString(actionRequest,
							"notes"));
					jobtitles1.setModifiedDate(date);

					jobtitles1.setCompanyId(themeDisplay.getCompanyId());
					jobtitles1.setGroupId(themeDisplay.getLayout().getGroup()
							.getGroupId());
					jobtitles1.setUserId(themeDisplay.getUserId());

					jobtitles1 = JobTitleLocalServiceUtil
							.updateJobTitle(jobtitles1);
					log.info("jobtitleName updated");
					}}

			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			log.error("SystemException " + e);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("PortalException " + e);
		}
		actionResponse.setRenderParameter("mvcPath", "/html/jobtitle/add.jsp");

	}

	/**
	 * <p>
	 * This method deletes the jobtitle record from database based on jobtitle
	 * record Id
	 * </p>
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 * 
	 */
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		if (resourceRequest.getResourceID().equals("deleteJobtitle")) {

			log.info("inside deleteJobtitle...");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"jobtitleIds");
			log.info("s===" + idsArray.length);

			log.info("length = " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info((idsArray[i]));
			}
			log.info("deleting.....");
			for (int i = 0; i <= idsArray.length - 1; i++) {

				if (idsArray[i].equals("on")) {
					log.info("All records selected... in Job Title...");
				} else {

					try {
						JobTitleLocalServiceUtil.deleteJobTitle(Long
								.parseLong(idsArray[i]));
					} catch (NumberFormatException e) {

						log.error("NumberFormatException " + e);
					} catch (PortalException e) {

						log.error("PortalException " + e);
					} catch (SystemException e) {

						log.error("SystemException " + e);
					}
				}
			}
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			PrintWriter writer = resourceResponse.getWriter();

			writer.write(jsonArray.toString());

		}

	}

	/**
	 * <p>
	 * This method gets the single jobtitle record from database based on the
	 * given jobtitle Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void editJobtitle(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {

		log.info("editJobtitle method in JobTitleAction");

		String s = ParamUtil.getString(actionRequest, "id");
		JobTitle jobTitle = JobTitleLocalServiceUtil.getJobTitle(Long
				.parseLong(s));
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editjobtitle", jobTitle);
		actionResponse.setRenderParameter("jspPage", "/html/jobtitle/edit.jsp");
	}

}

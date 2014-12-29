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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.JobTitle;
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

		System.out.println("inside saveJobtitle.....");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		log.info("This is the first log message...!!!");

		try {

			String id = ParamUtil.getString(actionRequest, "jobtitleId");
			String title = ParamUtil.getString(actionRequest, "title");
			String jobtitle = title.trim();

			System.out.println("Name = "
					+ ParamUtil.getString(actionRequest, "title"));
			System.out.println("country = "
					+ ParamUtil.getString(actionRequest, "description"));

			System.out.println("id == " + id);
			if (id == "" || id == null) {
				System.out.println("inside if loop...");

				if (jobtitle == null || jobtitle.equals("")) {

					SessionMessages.add(actionRequest.getPortletSession(),
							"jobtitleName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/jobtitle/add.jsp");

				} else {

					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(JobTitle.class,
									PortalClassLoaderUtil.getClassLoader());
					dynamicQuery
							.add(RestrictionsFactoryUtil.eq("title", title));
					@SuppressWarnings("unchecked")
					List<JobTitle> jobTitles = JobTitleLocalServiceUtil
							.dynamicQuery(dynamicQuery);
					if (jobTitles.size() > 0) {

						JobTitle jobTitle2 = jobTitles.get(0);
						if (jobTitle2.getTitle().equalsIgnoreCase(title)) {

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
						jobtitles.setGroupId(themeDisplay.getCompanyGroupId());
						jobtitles.setUserId(themeDisplay.getUserId());

						jobtitles = JobTitleLocalServiceUtil
								.addJobTitle(jobtitles);
					}
				}

			} else {
				System.out.println("else block to update...");

				if (jobtitle == null || jobtitle.equals("")) {

					JobTitle jobTitle = JobTitleLocalServiceUtil
							.getJobTitle(Long.parseLong(id));
					PortletSession portletSession = actionRequest
							.getPortletSession();
					portletSession.setAttribute("editjobtitle", jobTitle);

					SessionMessages.add(actionRequest.getPortletSession(),
							"jobtitleName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/jobtitle/edit.jsp");

				} else {

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
					jobtitles1.setGroupId(themeDisplay.getCompanyGroupId());
					jobtitles1.setUserId(themeDisplay.getUserId());

					jobtitles1 = JobTitleLocalServiceUtil
							.updateJobTitle(jobtitles1);
				}

			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		if (resourceRequest.getResourceID().equals("deleteJobtitle")) {

			System.out.println("inside deleteJobtitle...");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"jobtitleIds");
			System.out.println("s===" + idsArray.length);

			System.out.println("length = " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {
				System.out.println((idsArray[i]));
			}
			System.out.println("deleting.....");
			for (int i = 0; i <= idsArray.length - 1; i++) {

				if (idsArray[i].equals("on")) {
					System.out
							.println("All records selected... in Job Title...");
				} else {

					try {
						JobTitleLocalServiceUtil.deleteJobTitle(Long
								.parseLong(idsArray[i]));
					} catch (NumberFormatException e) {

						e.printStackTrace();
					} catch (PortalException e) {

						e.printStackTrace();
					} catch (SystemException e) {

						e.printStackTrace();
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

		String s = ParamUtil.getString(actionRequest, "id");
		JobTitle jobTitle = JobTitleLocalServiceUtil.getJobTitle(Long
				.parseLong(s));
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editjobtitle", jobTitle);
		actionResponse.setRenderParameter("jspPage", "/html/jobtitle/edit.jsp");
	}

}

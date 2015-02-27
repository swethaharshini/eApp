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
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.Interview;
import com.rknowsys.eapp.hrm.service.InterviewLocalServiceUtil;

public class InterviewAction extends MVCPortlet {

	Date date = new Date();
	private static Logger log = Logger.getLogger(InterviewAction.class);

	/**
	 * <p>
	 * This method inserts new interview record in database if the id is not
	 * exits, otherwise updates the record based on the record id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveInterview(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("inside saveInterview...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		try {
			log.info("groupId = "
					+ themeDisplay.getLayout().getGroup().getGroupId());
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			log.error("PortalException " + e1);
		}
		try {
			String id = ParamUtil.getString(actionRequest, "interviewId");
			String inputName = ParamUtil.getString(actionRequest, "name");
			String interviewName = inputName.trim();
			log.info("id = " + id);
			log.info("name = " + inputName);

			log.info("id == " + id);
			if (id == "" || id == null) {
				log.info("inside if loop...empty value in interviewName");

				if (interviewName == null || interviewName.equals("")) {

					SessionMessages.add(actionRequest.getPortletSession(),
							"interviewName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/Interview/add.jsp");

				} else {

					Criterion criterion = null;
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(Interview.class,
									PortletClassLoaderUtil.getClassLoader());
					criterion = RestrictionsFactoryUtil.eq("name",
							interviewName);
					try {
						criterion = RestrictionsFactoryUtil.and(criterion,
								RestrictionsFactoryUtil.eq("groupId",
										themeDisplay.getLayout().getGroup()
												.getGroupId()));
						dynamicQuery.add(criterion);
					} catch (PortalException e1) {
						e1.printStackTrace();
					}
					@SuppressWarnings("unchecked")
					List<Interview> interviews = InterviewLocalServiceUtil
							.dynamicQuery(dynamicQuery);
					if (interviews.size() > 0) {

						Interview interview = interviews.get(0);
						if (interview.getName().equalsIgnoreCase(inputName)) {

							log.info("DuplicateName in interviewName");

							SessionMessages.add(
									actionRequest.getPortletSession(),
									"interviewName-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/Interview/add.jsp");

						}

					} else {

						Interview interview = InterviewLocalServiceUtil
								.createInterview(CounterLocalServiceUtil
										.increment());
						interview.setName(ParamUtil.getString(actionRequest,
								"name"));
						interview.setCreateDate(date);
						interview.setModifiedDate(date);
						interview.setCompanyId(themeDisplay.getCompanyId());
						interview.setGroupId(themeDisplay.getLayout()
								.getGroup().getGroupId());
						interview.setUserId(themeDisplay.getUserId());
						log.info("before...");
						interview = InterviewLocalServiceUtil
								.addInterview(interview);
						log.info("end of if block");
					}
				}
			} else {

				log.info("else block to update....");
				if (interviewName == null || interviewName.equals("")) {

					log.info("empty value in interviewName edit.jsp");

					Interview interview = InterviewLocalServiceUtil
							.getInterview(Long.parseLong(id));

					PortletSession portletSession = actionRequest
							.getPortletSession();
					portletSession.setAttribute("editinterview", interview);

					SessionMessages.add(actionRequest.getPortletSession(),
							"interviewName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/Interview/add.jsp");

				} else {
					long interviewid = Long.parseLong(id);

					Interview interview1 = InterviewLocalServiceUtil
							.getInterview(interviewid);
					
					Criterion criterion = null;
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(Interview.class,
									PortletClassLoaderUtil.getClassLoader());
					criterion = RestrictionsFactoryUtil.eq("name",
							interviewName);
					try {
						criterion = RestrictionsFactoryUtil.and(criterion,
								RestrictionsFactoryUtil.eq("groupId",
										themeDisplay.getLayout().getGroup()
												.getGroupId()));
						dynamicQuery.add(criterion);
					} catch (PortalException e1) {
						e1.printStackTrace();
					}
					@SuppressWarnings("unchecked")
					List<Interview> interviews = InterviewLocalServiceUtil
							.dynamicQuery(dynamicQuery);
					if (interviews.size() > 0) {

						Interview interview = interviews.get(0);
						if (interview.getName().equalsIgnoreCase(inputName) && !interview1.getName().equalsIgnoreCase(inputName)) {

							log.info("DuplicateName in interviewName");

							SessionMessages.add(
									actionRequest.getPortletSession(),
									"interviewName-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/Interview/add.jsp");

						}

					}
					
					else{
					

					

					interview1.setInterviewId(ParamUtil.getLong(actionRequest,
							"interviewId"));

					interview1.setName(ParamUtil.getString(actionRequest,
							"name"));
					interview1.setModifiedDate(date);
					interview1.setCompanyId(themeDisplay.getCompanyId());
					interview1.setGroupId(themeDisplay.getLayout().getGroup()
							.getGroupId());
					interview1.setUserId(themeDisplay.getUserId());

					interview1 = InterviewLocalServiceUtil
							.updateInterview(interview1);
					log.info("end of else block");
					}
				}
			}
		} catch (SystemException e) {

			log.error(e);
		} catch (PortalException e) {

			log.error(e);

		}
		log.info("end of the saveInterview method");
		log.info("end of the saveInterview method");

	}

	/**
	 * <p>
	 * This method deletes the interview record from database based on interview
	 * record Id
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
		if (resourceRequest.getResourceID().equals("deleteInterview")) {

			log.info("inside deleteInterview... serveResource");
			Interview interview;
			try {
				interview = InterviewLocalServiceUtil
						.createInterview(CounterLocalServiceUtil.increment());
				log.info(interview);
			} catch (SystemException e1) {

				log.error(e1);
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"interviewIds");

			log.info("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {

				log.info("ids == " + idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info("id == " + idsArray[i]);
				if (idsArray[i].equals("on")) {
					log.info("All records selected...");
				} else {
					try {
						interview = InterviewLocalServiceUtil
								.deleteInterview(Long.parseLong(idsArray[i]));
						log.info("end of try block in delete...");
					} catch (PortalException e) {

						log.error(e);
					} catch (SystemException e) {

						log.error(e);

					}
				}

			}
			log.info("end of for loop..");

		}

		log.info("end of deleteInterview method...");

	}

	/**
	 * <p>
	 * This method gets the single interview record from database based on the
	 * given interview Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single interview record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editInterview(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("inside editInterview...");
		String s = ParamUtil.getString(actionRequest, "id");
		log.info("id == " + s);
		Interview interview = InterviewLocalServiceUtil.getInterview(Long
				.parseLong(s));

		log.info(interview.getInterviewId());
		log.info(interview.getName());
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editinterview", interview);
		actionResponse
				.setRenderParameter("jspPage", "/html/Interview/edit.jsp");
	}

}

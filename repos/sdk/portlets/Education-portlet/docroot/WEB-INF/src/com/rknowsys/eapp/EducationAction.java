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
import com.rknowsys.eapp.hrm.model.Education;
import com.rknowsys.eapp.hrm.service.EducationLocalServiceUtil;

/**
 * Portlet implementation class EducationAction
 */
public class EducationAction extends MVCPortlet {

	private static Logger log = Logger.getLogger(EducationAction.class);

	Date date = new Date();

	public void saveEducation(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("Entered into saveEducation() method in EducationAction");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(actionRequest, "educationId");
		String eduLevel = ParamUtil.getString(actionRequest, "education_level");
		log.info(id);
		log.info(eduLevel);
		String educationName = eduLevel.trim();
		try {
			if (educationName == null || educationName.equals("")) {

				log.info("Empty value in educationName in EducationAction");

				SessionMessages.add(actionRequest.getPortletSession(),
						"educationName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/educationaction/addEducation.jsp");

			} else {
				Criterion criterion = null;
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						Education.class,
						PortletClassLoaderUtil.getClassLoader());
				criterion = RestrictionsFactoryUtil.eq("eduLevel", eduLevel);
				try {
					criterion = RestrictionsFactoryUtil.and(
							criterion,
							RestrictionsFactoryUtil.eq("groupId", themeDisplay
									.getLayout().getGroup().getGroupId()));
				} catch (PortalException e1) {
					// TODO Auto-generated catch block
					log.error("PortalException " + e1);
				}
				dynamicQuery.add(criterion);
				@SuppressWarnings("unchecked")
				List<Education> list = EducationLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (list.size() > 0) {

					Education education = list.get(0);
					if (education.getEduLevel().equalsIgnoreCase(eduLevel)) {
						log.info("Duplicate value in educationName in EducationAction");
						SessionMessages.add(actionRequest.getPortletSession(),
								"educationName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/educationaction/addEducation.jsp");
					}

				} else {
					log.info("Adding New EducationName  EducationAction");
					Education educations = EducationLocalServiceUtil
							.createEducation(CounterLocalServiceUtil
									.increment());
					log.info("id= " + id);

					if (id == "" || id == null) {
						educations.setCreateDate(date);
						educations.setModifiedDate(date);
						educations.setCompanyId(themeDisplay.getCompanyId());
						try {
							educations.setGroupId(themeDisplay.getLayout()
									.getGroup().getGroupId());
						} catch (PortalException e) {
							log.error("PortalException " + e);
						}
						educations.setUserId(themeDisplay.getUserId());
						educations.setEduLevel(eduLevel);
						educations = EducationLocalServiceUtil
								.addEducation(educations);
						log.info("New EducationName Added");
					}
				}
			}
		} catch (SystemException e) {

			log.error("SystemException " + e);
		}

	}

	public void updateEducation(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("Entered into updateEducation() method in EducationAction");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "educationId");
		String eduLevel = ParamUtil.getString(actionRequest, "education_level");
		log.info(id);
		log.info(eduLevel);
		String educationName = eduLevel.trim();
		log.info("id = " + id);
		Education educations;
		try {

			if (educationName == null || educationName.equals("")) {
				log.info("Empty value in updateEducation() method in EducationAction");

				Education education = EducationLocalServiceUtil
						.getEducation(Long.parseLong(id));
				PortletSession portletSession = actionRequest
						.getPortletSession();
				portletSession.setAttribute("editEducation", education);

				SessionMessages.add(actionRequest.getPortletSession(),
						"educationName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/educationaction/editEducation.jsp");

			} else {
				log.info("Entered into else block to update Education updateEducation() EducationAction");

				educations = EducationLocalServiceUtil.getEducation(Long
						.parseLong(id));
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Education.class,PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("eduLevel", eduLevel));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				
				List<Education> list = EducationLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size()>0)
				{
					Education education = list.get(0);
					if(education.getEduLevel().equalsIgnoreCase(eduLevel) && ! educations.getEduLevel().equalsIgnoreCase(eduLevel))
					{
						SessionMessages.add(actionRequest.getPortletSession(),
								"educationName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/educationaction/addEducation.jsp");
						
					}
				}
				else{
				educations.setCreateDate(date);
				educations.setModifiedDate(date);
				educations.setCompanyId(themeDisplay.getCompanyId());
				try {
					educations.setGroupId(themeDisplay.getLayout().getGroup()
							.getGroupId());
				} catch (PortalException e) {
					e.printStackTrace();
				}
				educations.setUserId(themeDisplay.getUserId());
				educations.setEduLevel(eduLevel);
				educations = EducationLocalServiceUtil
						.updateEducation(educations);
				log.info("EducationName updated updateEducation() method in EducationAction...");
				}
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.error("NumberFormatException " + e);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("PortalException " + e);
		}
	}

	/**
	 * <p>
	 * This method deletes the Educations record from database based on
	 * Educations record Id
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
			ResourceResponse resourceResponse) throws IOException {
		if (resourceRequest.getResourceID().equals("deleteEducation")) {

			log.info("Entered into serveResource method for deleting education Record in EducationAction");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"educationIds");

			log.info("selected records idArray length = " + idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						log.info(idsArray[i]);
						EducationLocalServiceUtil.deleteEducation(Long
								.parseLong(idsArray[i]));
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						log.error("PortalException serveResource deleting record in EducationAction"
								+ e);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						log.error("SystemException serveResource deleting record in EducationAction"
								+ e);
					}
				} catch (NumberFormatException e) {
					log.error("NumberFormatException serveResource deleting record in EducationAction"
							+ e);
				}
			}
			log.info("End of Deleting Education records EducationAction");
		}

	}

	public void editEducation(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("Entered into the editEducation method in EducationAction..");
		String educationId = ParamUtil.getString(actionRequest, "educationId");
		Education educations = EducationLocalServiceUtil.getEducation(Long
				.parseLong(educationId));
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editEducation", educations);
		actionResponse.setRenderParameter("jspPage",
				"/html/educationaction/editEducation.jsp");
	}

}

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

	Date date = new Date();

	public void saveEducation(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(actionRequest, "educationId");
		String eduLevel = ParamUtil.getString(actionRequest, "education_level");
		String educationName = eduLevel.trim();
		try {
			if (educationName == null || educationName.equals("")) {

				SessionMessages.add(actionRequest.getPortletSession(),
						"educationName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/educationaction/addEducation.jsp");

			} else {
				Criterion criterion=null;
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						Education.class,
						PortletClassLoaderUtil.getClassLoader());
				criterion=RestrictionsFactoryUtil
						.eq("eduLevel", eduLevel);
				try {
					criterion=RestrictionsFactoryUtil.and(criterion,RestrictionsFactoryUtil
							.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				} catch (PortalException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dynamicQuery.add(criterion);
				@SuppressWarnings("unchecked")
				List<Education> list = EducationLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (list.size() > 0) {

					Education education = list.get(0);
					if (education.getEduLevel().equalsIgnoreCase(eduLevel)) {
						SessionMessages.add(actionRequest.getPortletSession(),
								"educationName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/educationaction/addEducation.jsp");
					}

				} else {

					Education educations = EducationLocalServiceUtil
							.createEducation(CounterLocalServiceUtil
									.increment());

					System.out.println("id == " + id);
					if (id == "" || id == null) {
						educations.setCreateDate(date);
						educations.setModifiedDate(date);
						educations.setCompanyId(themeDisplay.getCompanyId());
						try {
							educations.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
						} catch (PortalException e) {
							e.printStackTrace();
						}
						educations.setUserId(themeDisplay.getUserId());
						educations.setEduLevel(eduLevel);
						educations = EducationLocalServiceUtil
								.addEducation(educations);
					}
				}
			}
		} catch (SystemException e) {

			e.printStackTrace();
		}

	}

	public void updateEducation(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "educationId");
		String eduLevel = ParamUtil.getString(actionRequest, "education_level");
		String educationName = eduLevel.trim();
		System.out.println("id == " + id);
		Education educations;
		try {

			if (educationName == null || educationName.equals("")) {

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

				educations = EducationLocalServiceUtil.getEducation(Long
						.parseLong(id));
				educations.setCreateDate(date);
				educations.setModifiedDate(date);
				educations.setCompanyId(themeDisplay.getCompanyId());
				try {
					educations.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				} catch (PortalException e) {
					e.printStackTrace();
				}
				educations.setUserId(themeDisplay.getUserId());
				educations.setEduLevel(eduLevel);
				educations = EducationLocalServiceUtil
						.updateEducation(educations);
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			System.out.println("deleting thes educations");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"educationIds");
			System.out.println(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						EducationLocalServiceUtil.deleteEducation(Long
								.parseLong(idsArray[i]));
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NumberFormatException e) {
				}
			}

		}

	}

	public void editEducation(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		String educationId = ParamUtil.getString(actionRequest, "educationId");
		Education educations = EducationLocalServiceUtil.getEducation(Long
				.parseLong(educationId));
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editEducation", educations);
		actionResponse.setRenderParameter("jspPage",
				"/html/educationaction/editEducation.jsp");
	}

}

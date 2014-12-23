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
import com.rknowsys.eapp.hrm.model.Language;
import com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil;

/**
 * Portlet implementation class LanguageAction
 */
public class LanguageAction extends MVCPortlet {
	Date date = new Date();

	public void saveLanguage(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String id = ParamUtil.getString(actionRequest, "LanguageId");
			String name = ParamUtil.getString(actionRequest, "language_name");
			String languageName = name.trim();
			if (languageName.equals("") || languageName == null) {

				SessionMessages.add(actionRequest.getPortletSession(),
						"languageName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/language/add.jsp");

			} else {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						Language.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("languageName",
						name));
				@SuppressWarnings("unchecked")
				List<Language> languages = LanguageLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (languages.size() > 0) {

					Language language = languages.get(0);
					if (language.getLanguageName().equalsIgnoreCase(
							languageName)) {

						SessionMessages.add(actionRequest.getPortletSession(),
								"languageName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/language/add.jsp");

					}

				} else {

					Language language = LanguageLocalServiceUtil
							.createLanguage(CounterLocalServiceUtil.increment());

					System.out.println("id == " + id);
					if (id == "" || id == null) {
						language.setLanguageName(ParamUtil.getString(
								actionRequest, "name"));
						language.setCreateDate(date);
						language.setModifiedDate(date);
						language.setCompanyId(themeDisplay.getCompanyId());
						language.setGroupId(themeDisplay.getCompanyGroupId());
						language.setUserId(themeDisplay.getUserId());
						language.setLanguageName(name);
						language = LanguageLocalServiceUtil
								.addLanguage(language);
					}

				}

			}

		} catch (SystemException e) {

			e.printStackTrace();
		}

	}

	public void updateLanguage(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "LanguageId");
		String name = ParamUtil.getString(actionRequest, "language_name");
		String languageName = name.trim();

		System.out.println("id == " + id);
		Language languages;
		try {
			if (languageName.equals("") || languageName == null) {

				SessionMessages.add(actionRequest.getPortletSession(),
						"languageName-empty-error");
				languages = LanguageLocalServiceUtil.getLanguage(Long
						.parseLong(id));

				PortletSession portletSession = actionRequest
						.getPortletSession();
				portletSession.setAttribute("editLanguage", languages);

				actionResponse.setRenderParameter("mvcPath",
						"/html/language/edit.jsp");

			} else {

				languages = LanguageLocalServiceUtil.getLanguage(Long
						.parseLong(id));
				languages.setCreateDate(date);
				languages.setModifiedDate(date);
				languages.setCompanyId(themeDisplay.getCompanyId());
				languages.setGroupId(themeDisplay.getCompanyGroupId());
				languages.setUserId(themeDisplay.getUserId());
				languages.setLanguageName(name);
				languages = LanguageLocalServiceUtil.updateLanguage(languages);

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
	 * This method deletes the languages record from database based on languages
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
			ResourceResponse resourceResponse) throws IOException {
		if (resourceRequest.getResourceID().equals("deleteLanguage")) {
			System.out.println("deleting these languages");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"languageIds");
			System.out.println(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {

					LanguageLocalServiceUtil.deleteLanguage(Long
							.parseLong(idsArray[i]));
					System.out.println("language deleted...." + idsArray[i]);

				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				catch (NumberFormatException e) {
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public void editLanguage(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		Long languageId = ParamUtil.getLong(actionRequest, "languageId");
		Language languages = LanguageLocalServiceUtil.getLanguage(languageId);

		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editLanguage", languages);
		actionResponse.setRenderParameter("jspPage", "/html/language/edit.jsp");
	}

}

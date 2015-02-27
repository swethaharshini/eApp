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
import com.rknowsys.eapp.hrm.model.Language;
import com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil;

/**
 * Portlet implementation class LanguageAction
 */
public class LanguageAction extends MVCPortlet {
	private static Logger log = Logger.getLogger(LanguageAction.class);
	Date date = new Date();

	public void saveLanguage(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("Entered into saveLanguage method in LanguageAction");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String id = ParamUtil.getString(actionRequest, "LanguageId");
			String name = ParamUtil.getString(actionRequest, "language_name");
			log.info(id);log.info(name);
			String languageName = name.trim();
			if (languageName.equals("") || languageName == null) {
				log.info("Empty value in LanguageName ");

				SessionMessages.add(actionRequest.getPortletSession(),
						"languageName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/language/add.jsp");

			} else {
				Criterion criterion=null;
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						Language.class,
						PortletClassLoaderUtil.getClassLoader());
				criterion=RestrictionsFactoryUtil
						.eq("languageName", name);
				try {
					criterion=RestrictionsFactoryUtil.and(criterion,RestrictionsFactoryUtil
							.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				} catch (PortalException e1) {
					// TODO Auto-generated catch block
					log.error("PortalException " +e1);
				}
				dynamicQuery.add(criterion);
				@SuppressWarnings("unchecked")
				List<Language> languages = LanguageLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (languages.size() > 0) {

					Language language = languages.get(0);
					if (language.getLanguageName().equalsIgnoreCase(
							languageName)) {
						log.info("DuplicateName in LanguageName LanguageAction");

						SessionMessages.add(actionRequest.getPortletSession(),
								"languageName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/language/add.jsp");

					}

				} else {
					log.info("Creating Language record");

					Language language = LanguageLocalServiceUtil
							.createLanguage(CounterLocalServiceUtil.increment());

					log.info("id = "+id);
					if (id == "" || id == null) {
						language.setLanguageName(ParamUtil.getString(
								actionRequest, "name"));
						language.setCreateDate(date);
						language.setModifiedDate(date);
						language.setCompanyId(themeDisplay.getCompanyId());
						try {
							language.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
						} catch (PortalException e) {
							e.printStackTrace();
						}
						language.setUserId(themeDisplay.getUserId());
						language.setLanguageName(name);
						language = LanguageLocalServiceUtil
								.addLanguage(language);
						log.info("LanguageName added");
					}

				}

			}

		} catch (SystemException e) {

			log.error("SystemException " +e);
		}

	}

	public void updateLanguage(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("updateLanguage method in LanguageAction");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "languageId");
		String name = ParamUtil.getString(actionRequest, "language_name");
		log.info(id);log.info(name);
		String languageName = name.trim();

		log.info("id == "+id);
		Language languages;
		try {
			if (languageName.equals("") || languageName == null) {
				
				log.info("Empty value entered in LanguageName in edit page");

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
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Language.class,PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("languageName", name));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<Language> list = LanguageLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size()>0){
					Language language = list.get(0);
					if(language.getLanguageName().equalsIgnoreCase(name) && !languages.getLanguageName().equalsIgnoreCase(name))
					{
						SessionMessages.add(actionRequest.getPortletSession(),
								"languageName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/language/add.jsp");
						
					}
				}
				else{
				
				languages.setCreateDate(date);
				languages.setModifiedDate(date);
				languages.setCompanyId(themeDisplay.getCompanyId());
				languages.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				languages.setUserId(themeDisplay.getUserId());
				languages.setLanguageName(name);
				languages = LanguageLocalServiceUtil.updateLanguage(languages);
				}

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.error("NumberFormatException " +e);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("PortalException "+e);
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
			log.info("serverResource method in LanguageAction for deleting records");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"languageIds");
			log.info("selected records to be deleted " +idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {

					LanguageLocalServiceUtil.deleteLanguage(Long
							.parseLong(idsArray[i]));
					log.info("language deleted...." + idsArray[i]);

				} catch (SystemException e) {
					// TODO Auto-generated catch block
					log.error("SystemException "+e);
				}

				catch (NumberFormatException e) {
					log.error("NumberFormatException"+e);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					log.error("PortalException "+e);
				}
			}
			log.info("selected records deleted");

		}

	}

	public void editLanguage(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("editLanguage method in LanguageAction");
		Long languageId = ParamUtil.getLong(actionRequest, "languageId");
		Language languages = LanguageLocalServiceUtil.getLanguage(languageId);

		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editLanguage", languages);
		actionResponse.setRenderParameter("jspPage", "/html/language/edit.jsp");
	}

}

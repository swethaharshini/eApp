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
import com.rknowsys.eapp.hrm.model.License;
import com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil;

/**
 * Portlet implementation class LicensesAction
 */
public class LicensesAction extends MVCPortlet {
	private static Logger log = Logger.getLogger(LicensesAction.class);
	Date date = new Date();

	public void saveLicense(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("saveLicense method");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(actionRequest, "LicenseId");
		String name = ParamUtil.getString(actionRequest, "license_name");
		log.info(id);
		log.info(name);
		String licenseName = name.trim();
		try {
			if (licenseName == null || licenseName.equals("")) {
				log.info("Empty value in licenseName");

				SessionMessages.add(actionRequest.getPortletSession(),
						"licenseName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/license/add.jsp");

			} else {
				Criterion criterion = null;
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						License.class, PortletClassLoaderUtil.getClassLoader());
				criterion = RestrictionsFactoryUtil.eq("licenseName", name);
				criterion = RestrictionsFactoryUtil.and(
						criterion,
						RestrictionsFactoryUtil.eq("groupId", themeDisplay
								.getLayout().getGroup().getGroupId()));
				dynamicQuery.add(criterion);
				@SuppressWarnings("unchecked")
				List<License> licensesList = LicenseLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (licensesList.size() > 0) {
					License license = licensesList.get(0);
					if (license.getLicenseName().equalsIgnoreCase(name)) {
						log.info("DuplicateName in licenseName");
						SessionMessages.add(actionRequest.getPortletSession(),
								"licenseName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/license/add.jsp");
					}

				} else {

					License licenses = LicenseLocalServiceUtil
							.createLicense(CounterLocalServiceUtil.increment());

					System.out.println("id == " + id);
					if (id == "" || id == null) {
						licenses.setLicenseName(ParamUtil.getString(
								actionRequest, "name"));
						licenses.setCreateDate(date);
						licenses.setModifiedDate(date);
						licenses.setCompanyId(themeDisplay.getCompanyId());
						try {
							licenses.setGroupId(themeDisplay.getLayout()
									.getGroup().getGroupId());
						} catch (PortalException e) {
							e.printStackTrace();
						}
						licenses.setUserId(themeDisplay.getUserId());
						licenses.setLicenseName(name);
						licenses = LicenseLocalServiceUtil.addLicense(licenses);
						log.info("New licenseName added");
					}
				}
			}
		} catch (SystemException | PortalException e) {

			e.printStackTrace();
		}

	}

	public void updateLicense(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("updateLicense method");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "licenseId");
		String name = ParamUtil.getString(actionRequest, "license_name");
		log.info(id);
		log.info(name);
		String licenseName = name.trim();
		System.out.println("id == " + id);
		License licenses;
		try {
			if (licenseName == null || licenseName.equals("")) {
				log.info("empty value in licenseName edit.jsp");

				License license = LicenseLocalServiceUtil.getLicense(Long
						.parseLong(id));
				PortletSession portletSession = actionRequest
						.getPortletSession();
				portletSession.setAttribute("editLicense", license);

				SessionMessages.add(actionRequest.getPortletSession(),
						"licenseName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/license/edit.jsp");

			} else {
				licenses = LicenseLocalServiceUtil.getLicense(Long
						.parseLong(id));
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(License.class,PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("licenseName", name));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<License> list = LicenseLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size()>0){
					log.info("list size greater than zero...");
					License licenses2 = list.get(0);
					if(licenses2.getLicenseName().equalsIgnoreCase(name) && !(licenses.getLicenseName().equalsIgnoreCase(name))){
					SessionMessages.add(actionRequest.getPortletSession(),
							"licenseName-duplicate-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/license/add.jsp");
					}
				}
				else{
					log.info("else block to update...");
				licenses.setCreateDate(date);
				licenses.setModifiedDate(date);
				licenses.setCompanyId(themeDisplay.getCompanyId());
				try {
					licenses.setGroupId(themeDisplay.getLayout().getGroup()
							.getGroupId());
				} catch (PortalException e) {
					e.printStackTrace();
				}
				licenses.setUserId(themeDisplay.getUserId());
				licenses.setLicenseName(name);
				licenses = LicenseLocalServiceUtil.updateLicense(licenses);
				log.info("licenseName updated");
				}

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
	}

	/**
	 * <p>
	 * This method deletes the licenses record from database based on licenses
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
		if (resourceRequest.getResourceID().equals("deleteLicense")) {
			log.info("deleting thes licenses");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"licenseIds");
			log.info(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						LicenseLocalServiceUtil.deleteLicense(Long
								.parseLong(idsArray[i]));
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						log.error(e);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						log.error(e);
					}
				} catch (NumberFormatException e) {
					log.error(e);
				}
			}

		}

	}

	public void editLicense(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("editLicense method");
		Long licenseId = ParamUtil.getLong(actionRequest, "licenseId");
		License licenses = LicenseLocalServiceUtil.getLicense(licenseId);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editLicense", licenses);
		actionResponse.setRenderParameter("jspPage", "/html/license/edit.jsp");
	}

}

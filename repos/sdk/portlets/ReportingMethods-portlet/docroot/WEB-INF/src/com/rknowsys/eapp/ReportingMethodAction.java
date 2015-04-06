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
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.ReportingMethods;
import com.rknowsys.eapp.hrm.service.ReportingMethodsLocalServiceUtil;

/**
 * @author Laxminarayana 10th october 2014 6:49:58 PM
 */
public class ReportingMethodAction extends MVCPortlet {
	private static Logger log = Logger.getLogger(ReportingMethodAction.class);
	Date date = new Date();

	/**
	 * <p>
	 * This method inserts new ReportingMethod record into the database table.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void saveReportingMethod(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(actionRequest, "reportingmethodId");
		String name = ParamUtil.getString(actionRequest, "reportingmethodName");
		log.info(id);
		log.info(name);
		String reportingmethodName = name.trim();
		try {

			if (reportingmethodName == null || reportingmethodName.equals("")) {
				log.info("empty value in reportingmethodName");

				SessionMessages.add(actionRequest.getPortletSession(),
						"reportingmethodName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/reportingmethods/add.jsp");

			} else {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						ReportingMethods.class,
						PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq(
						"reportingmethodName", name));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<ReportingMethods> list = ReportingMethodsLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (list.size() > 0) {

					ReportingMethods reportingMethods = list.get(0);
					if (reportingMethods.getReportingmethodName()
							.equalsIgnoreCase(name)) {
						log.info("duplicate value in reportingmethod name");

						SessionMessages.add(actionRequest.getPortletSession(),
								"reportingmethodName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/reportingmethods/add.jsp");
					}

				} else {

					log.info("id == " + id + " Name = " + name);
					if (id == "" || id == null) {
						ReportingMethods reportingMethods = ReportingMethodsLocalServiceUtil
								.createReportingMethods(CounterLocalServiceUtil
										.increment());
						reportingMethods
								.setReportingmethodName(ParamUtil.getString(
										actionRequest, "reportingmethodName"));
						reportingMethods.setCreateDate(date);
						reportingMethods.setModifiedDate(date);
						reportingMethods.setCompanyId(themeDisplay
								.getCompanyId());
						reportingMethods.setGroupId(themeDisplay.getLayout()
								.getGroup().getGroupId());
						reportingMethods.setUserId(themeDisplay.getUserId());
						reportingMethods = ReportingMethodsLocalServiceUtil
								.addReportingMethods(reportingMethods);
						log.info("New reportingmethodName added");
					}
				}
			}
		} catch (SystemException e) {

			log.error(e);
		}

	}

	/**
	 * <p>
	 * This method updates the ReportingMethod record in the database table
	 * based on the given ReportingMethod recordId.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void updateReportingMethod(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("updateReportingMethod in ReportingMethodAction");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "reportingmethodId");
		String name = ParamUtil.getString(actionRequest, "reportingmethodName");
		String reportingmethodName = name.trim();
		log.info("id == " + id);
		ReportingMethods reportingMethods;

		try {
			if (reportingmethodName == null || reportingmethodName.equals("")) {
				log.info("empty value in reportingmethodName in edit.jsp");

				ReportingMethods reportingMethod = ReportingMethodsLocalServiceUtil
						.getReportingMethods(Long.parseLong(id));
				PortletSession portletSession = actionRequest
						.getPortletSession();
				portletSession.setAttribute("editReportingMethod",
						reportingMethod);

				SessionMessages.add(actionRequest.getPortletSession(),
						"reportingmethodName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/reportingmethods/edit.jsp");

			} else {
				reportingMethods = ReportingMethodsLocalServiceUtil
						.getReportingMethods(Long.parseLong(id));
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						ReportingMethods.class,
						PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq(
						"reportingmethodName", name));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<ReportingMethods> list = ReportingMethodsLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (list.size() > 0) {

					ReportingMethods reportingMethods1 = list.get(0);
					if (reportingMethods1.getReportingmethodName()
							.equalsIgnoreCase(name) && !reportingMethods.getReportingmethodName().equalsIgnoreCase(name)) {
						log.info("duplicate value in reportingmethod name");

						SessionMessages.add(actionRequest.getPortletSession(),
								"reportingmethodName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/reportingmethods/add.jsp");
					}

				}
				else{
				
				
				reportingMethods.setCreateDate(date);
				reportingMethods.setModifiedDate(date);
				reportingMethods.setCompanyId(themeDisplay.getCompanyId());
				reportingMethods.setGroupId(themeDisplay.getLayout().getGroup()
						.getGroupId());
				reportingMethods.setUserId(themeDisplay.getUserId());
				reportingMethods.setReportingmethodName(name);
				reportingMethods = ReportingMethodsLocalServiceUtil
						.updateReportingMethods(reportingMethods);
				log.info("reportingmethodName updated");
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
	 * This method deletes the ReportingMethod record from database based on
	 * ReportingMethod record Id
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
		if (resourceRequest.getResourceID().equals("deleteReportingMethod")) {
			log.info("deleting thes ReportingMethods");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"reportingmethodIds");
			log.info(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						ReportingMethodsLocalServiceUtil
								.deleteReportingMethods(Long
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

	/**
	 * <p>
	 * This method gets a single ReportingMethod record from database based on
	 * given ReportingMethod recordId
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
	public void editReportingMethod(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("editReportingMethod in ReportingMethodAction");
		Long reportingmethodId = ParamUtil.getLong(actionRequest,
				"reportingmethodId");
		ReportingMethods reportingMethods = ReportingMethodsLocalServiceUtil
				.getReportingMethods(reportingmethodId);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editReportingMethod", reportingMethods);
		actionResponse.setRenderParameter("jspPage",
				"/html/reportingmethods/edit.jsp");
	}

}

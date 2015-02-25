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
import com.rknowsys.eapp.hrm.model.TerminationReasons;
import com.rknowsys.eapp.hrm.service.TerminationReasonsLocalServiceUtil;

/**
 * @author Laxminarayana 10th october 2014 6:47:56 PM
 */
public class TerminationReasonsAction extends MVCPortlet {
	private static Logger log = Logger
			.getLogger(TerminationReasonsAction.class);
	Date date = new Date();

	/**
	 * <p>
	 * This method inserts new TerminationReason record into the database table
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveTerminationReasons(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("saveTerminationReasons method in TerminationReasonsAction");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			TerminationReasons terminationReasons = TerminationReasonsLocalServiceUtil
					.createTerminationReasons(CounterLocalServiceUtil
							.increment());

			String id = ParamUtil.getString(actionRequest,
					"terminationreasonsId");
			String name = ParamUtil.getString(actionRequest,
					"terminationreasonsName");
			log.info(id);
			log.info(name);
			String terminationReason = name.trim();
			if (terminationReason.equals("") || terminationReason == null) {

				log.info("Empty value in TerminationReason...");
				SessionMessages.add(actionRequest.getPortletSession(),
						"termination-form-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/terminationreasons/add.jsp");
			} else {

				log.info("id == " + id + "Name = " + name);
				if (id == "" || id == null) {

					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(TerminationReasons.class,
									PortalClassLoaderUtil.getClassLoader());

					dynamicQuery.add(RestrictionsFactoryUtil.eq(
							"terminationreasonsName", name));
					try {
						dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId",
								themeDisplay.getLayout().getGroup()
										.getGroupId()));
					} catch (PortalException e1) {
						log.error("PortalException " + e1);
					}
					@SuppressWarnings("unchecked")
					List<TerminationReasons> list = TerminationReasonsLocalServiceUtil
							.dynamicQuery(dynamicQuery);

					if (list.size() > 0) {
						TerminationReasons terminationReasons2 = list.get(0);

						if (terminationReasons2.getTerminationreasonsName()
								.equalsIgnoreCase(name)) {
							log.info("DuplicateName in TerminationReason");

							SessionMessages.add(
									actionRequest.getPortletSession(),
									"termination-form-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/terminationreasons/add.jsp");

						}
					} else {

						terminationReasons.setTerminationreasonsName(ParamUtil
								.getString(actionRequest,
										"terminationreasonsName"));
						terminationReasons.setCreateDate(date);
						terminationReasons.setModifiedDate(date);
						terminationReasons.setCompanyId(themeDisplay
								.getCompanyId());
						try {
							terminationReasons.setGroupId(themeDisplay
									.getLayout().getGroup().getGroupId());
						} catch (PortalException e) {
							log.error("PortalException "+e);
						}
						terminationReasons.setUserId(themeDisplay.getUserId());
						terminationReasons = TerminationReasonsLocalServiceUtil
								.addTerminationReasons(terminationReasons);
						log.info("TerminationReason added");

					}
				}
			}
		} catch (SystemException e) {

			log.error("SystemException " + e);
		}

	}

	/**
	 * <p>
	 * This method updates the TerminationReason record based on
	 * TerminationReason recordId
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void updateTerminationReasons(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("updateTerminationReasons method in TerminationReasons ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "terminationreasonsId");
		String name = ParamUtil.getString(actionRequest,
				"terminationreasonsName");
		log.info("id == " + id);
		TerminationReasons terminationReasons;

		try {
			String terminationReason = name.trim();
			TerminationReasons terminationReasons2 = TerminationReasonsLocalServiceUtil
					.getTerminationReasons(Long.parseLong(id));
			if (terminationReason.equals("") || terminationReason == null) {

				log.info("Empty value in TerminationReason...");
				

				PortletSession portletSession = actionRequest
						.getPortletSession();
				portletSession.setAttribute("editTerminationReasons",
						terminationReasons2);

				SessionMessages.add(actionRequest.getPortletSession(),
						"termination-form-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/terminationreasons/edit.jsp");
			}

			else {
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
						.forClass(TerminationReasons.class,
								PortalClassLoaderUtil.getClassLoader());

				dynamicQuery.add(RestrictionsFactoryUtil.eq(
						"terminationreasonsName", name));
				try {
					dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId",
							themeDisplay.getLayout().getGroup()
									.getGroupId()));
				} catch (PortalException e1) {
					log.error("PortalException " + e1);
				}
				@SuppressWarnings("unchecked")
				List<TerminationReasons> list = TerminationReasonsLocalServiceUtil
						.dynamicQuery(dynamicQuery);

				if (list.size() > 0) {
					TerminationReasons terminationReasons3 = list.get(0);

					if (terminationReasons3.getTerminationreasonsName()
							.equalsIgnoreCase(name) && !terminationReasons2.getTerminationreasonsName().equalsIgnoreCase(name)) {
						log.info("DuplicateName in TerminationReason");

						SessionMessages.add(
								actionRequest.getPortletSession(),
								"termination-form-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/terminationreasons/add.jsp");

					}
				}
				
				else{

				terminationReasons = TerminationReasonsLocalServiceUtil
						.getTerminationReasons(Long.parseLong(id));
				terminationReasons.setCreateDate(date);
				terminationReasons.setModifiedDate(date);
				terminationReasons.setCompanyId(themeDisplay.getCompanyId());
				terminationReasons.setGroupId(themeDisplay.getLayout()
						.getGroup().getGroupId());
				terminationReasons.setUserId(themeDisplay.getUserId());
				terminationReasons.setTerminationreasonsName(name);
				terminationReasons = TerminationReasonsLocalServiceUtil
						.updateTerminationReasons(terminationReasons);
				}

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.error("NumberFormatException "+e);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("PortalException "+e);
		}
	}

	/**
	 * <p>
	 * This method deletes the TerminationReasons record from database based on
	 * TerminationReasons record Id
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
		if (resourceRequest.getResourceID().equals("deleteTerminationReasons")) {
			log.info("deleting thes TerminationReasons");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"terminationreasonsIds");
			log.info(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						TerminationReasonsLocalServiceUtil
								.deleteTerminationReasons(Long
										.parseLong(idsArray[i]));
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						log.error("PortalException " + e);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						log.error("SystemException " + e);
					}
				} catch (NumberFormatException e) {
					log.error("NumberFormatException " + e);
				}
			}

		}

	}

	/**
	 * <p>
	 * This method gets a single TerminationReason Record from database based on
	 * given TerminationReason recordId
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
	public void editTerminationReasons(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("editTerminationReasons method in TerminationReasonsAction");
		Long terminationreasonsId = ParamUtil.getLong(actionRequest,
				"terminationreasonsId");
		TerminationReasons terminationReasons = TerminationReasonsLocalServiceUtil
				.getTerminationReasons(terminationreasonsId);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editTerminationReasons",
				terminationReasons);

		actionResponse.setRenderParameter("jspPage",
				"/html/terminationreasons/edit.jsp");
	}

}

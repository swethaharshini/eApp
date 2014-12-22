package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
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
			String terminationReason = name.trim();
			if (terminationReason.equals("") || terminationReason == null) {

				System.out.println("Empty value in TerminationReason...");
				SessionMessages.add(actionRequest.getPortletSession(),
						"termination-form-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/terminationreasons/add.jsp");
			} else {

				System.out.println("id == " + id + "Name = " + name);
				if (id == "" || id == null) {

					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(TerminationReasons.class,
									PortalClassLoaderUtil.getClassLoader());

					dynamicQuery.add(RestrictionsFactoryUtil.eq(
							"terminationreasonsName", name));
					List<TerminationReasons> list = TerminationReasonsLocalServiceUtil
							.dynamicQuery(dynamicQuery);

					if (list.size() > 0) {
						TerminationReasons terminationReasons2 = list.get(0);

						if (terminationReasons2 != null) {

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
						terminationReasons.setGroupId(themeDisplay
								.getCompanyGroupId());
						terminationReasons.setUserId(themeDisplay.getUserId());
						terminationReasons = TerminationReasonsLocalServiceUtil
								.addTerminationReasons(terminationReasons);

					}
				}
			}
		} catch (SystemException e) {

			e.printStackTrace();
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
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "terminationreasonsId");
		String name = ParamUtil.getString(actionRequest,
				"terminationreasonsName");
		System.out.println("id == " + id);
		TerminationReasons terminationReasons;

		try {
			String terminationReason = name.trim();
			if (terminationReason.equals("") || terminationReason == null) {

				System.out.println("Empty value in TerminationReason...");
				TerminationReasons terminationReasons2 = TerminationReasonsLocalServiceUtil
						.getTerminationReasons(Long.parseLong(id));

				actionRequest.setAttribute("editTerminationReasons",
						terminationReasons2);

				SessionMessages.add(actionRequest.getPortletSession(),
						"termination-form-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/terminationreasons/edit.jsp");
			}

			else {

				terminationReasons = TerminationReasonsLocalServiceUtil
						.getTerminationReasons(Long.parseLong(id));
				terminationReasons.setCreateDate(date);
				terminationReasons.setModifiedDate(date);
				terminationReasons.setCompanyId(themeDisplay.getCompanyId());
				terminationReasons.setGroupId(themeDisplay.getCompanyGroupId());
				terminationReasons.setUserId(themeDisplay.getUserId());
				terminationReasons.setTerminationreasonsName(name);
				terminationReasons = TerminationReasonsLocalServiceUtil
						.updateTerminationReasons(terminationReasons);

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
			System.out.println("deleting thes TerminationReasons");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"terminationreasonsIds");
			System.out.println(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						TerminationReasonsLocalServiceUtil
								.deleteTerminationReasons(Long
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
		Long terminationreasonsId = ParamUtil.getLong(actionRequest,
				"terminationreasonsId");
		TerminationReasons terminationReasons = TerminationReasonsLocalServiceUtil
				.getTerminationReasons(terminationreasonsId);

		actionRequest
				.setAttribute("editTerminationReasons", terminationReasons);
		actionResponse.setRenderParameter("jspPage",
				"/html/terminationreasons/edit.jsp");
	}

}

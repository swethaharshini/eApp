package com.rknowsys.eapp.hrm;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.PayGrade;
import com.rknowsys.eapp.hrm.model.PayGradeCurrency;
import com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil;

/**
 * 
 * @author Laxminarayana 31 october 2014 3:15:55 PM
 * 
 */
public class PayGradeAction extends MVCPortlet {

	Date date = new Date();

	/**
	 * <p>
	 * This method inserts new paygrade record in database if the id is not
	 * exits, otherwise updates the record based on the record id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void savePayGrade(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		System.out.println("inside PayGradeAction payGrade() method....");

		System.out.println("inside savePayGrade...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {

			PayGrade paygrade = PayGradeLocalServiceUtil
					.createPayGrade(CounterLocalServiceUtil.increment());
			String id = ParamUtil.getString(actionRequest, "paygradeId");

			System.out.println("id == " + id);
			if (id == "" || id == null) {
				System.out.println("inside if loop..");

				paygrade.setPayGradeName(ParamUtil.getString(actionRequest,
						"paygradeName"));
				paygrade.setCreateDate(date);
				paygrade.setModifiedDate(date);
				paygrade.setCompanyId(themeDisplay.getCompanyId());
				paygrade.setGroupId(themeDisplay.getCompanyGroupId());
				paygrade.setUserId(themeDisplay.getUserId());

				paygrade = PayGradeLocalServiceUtil.addPayGrade(paygrade);

				PayGrade paygrade3 = PayGradeLocalServiceUtil
						.getPayGrade(paygrade.getPayGradeId());

				// actionRequest.setAttribute("paygrade3", paygrade3);
				PortletSession portletSession = actionRequest
						.getPortletSession();
				portletSession.setAttribute("paygrade3", paygrade3);

				actionResponse.setRenderParameter("jspPage",
						"/html/paygrade/editpaygrade.jsp");

				System.out.println("end of if block...");
			} else {

				System.out.println("else block to update...");

				long paygradeid = Long.parseLong(id);

				PayGrade payGrade2 = PayGradeLocalServiceUtil
						.getPayGrade(paygradeid);
				payGrade2.setPayGradeId(ParamUtil.getLong(actionRequest,
						"paygradeId"));
				payGrade2.setPayGradeName(ParamUtil.getString(actionRequest,
						"paygradeName"));
				payGrade2.setModifiedDate(date);
				payGrade2.setCompanyId(themeDisplay.getCompanyId());
				payGrade2.setGroupId(themeDisplay.getCompanyGroupId());
				payGrade2.setUserId(themeDisplay.getUserId());
				payGrade2 = PayGradeLocalServiceUtil.updatePayGrade(payGrade2);

				System.out.println("end of else block...");

			}
		} catch (SystemException e) {

			e.printStackTrace();
			System.out.println("system exception...");
		} catch (PortalException e) {

			e.printStackTrace();
			System.out.println("portalexception....");
		}
		System.out.println("end of the savePayGrade method");
		System.out.println("end of the method...");

	}

	/**
	 * <p>
	 * This method inserts new paygradecurrency record in database if the id is
	 * not exits, otherwise updates the record based on the record id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void savePayGradeCurrency(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, SystemException,
			PortalException {

		System.out.println("inside savePayGradeCurrency..........");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(actionRequest, "paygradecurrencyId");
		System.out.println("id == " + id);
		if (id == "" || id == null) {
			PayGradeCurrency paygradecurrency = PayGradeCurrencyLocalServiceUtil
					.createPayGradeCurrency(CounterLocalServiceUtil.increment());
			String currency = ParamUtil.getString(actionRequest, "currency");
			long minsal = ParamUtil.getLong(actionRequest, "minSalary");
			long maxsal = ParamUtil.getLong(actionRequest, "maxSalary");
			long paygradeid = ParamUtil.getLong(actionRequest, "paygradeId");
			System.out.println("values == " + currency + " , " + minsal + " ,"
					+ maxsal);
			System.out.println("paygradeId == " + paygradeid);
			paygradecurrency.setCurrency(currency);
			paygradecurrency.setMinSalary(minsal);
			paygradecurrency.setMaxSalary(maxsal);
			paygradecurrency.setCreateDate(date);
			paygradecurrency.setModifiedDate(date);
			paygradecurrency.setCompanyId(themeDisplay.getCompanyId());
			paygradecurrency.setGroupId(themeDisplay.getCompanyGroupId());
			paygradecurrency.setUserId(themeDisplay.getUserId());

			paygradecurrency.setPayGradeId(paygradeid);
			paygradecurrency = PayGradeCurrencyLocalServiceUtil
					.addPayGradeCurrency(paygradecurrency);

			PayGrade paygrade3 = PayGradeLocalServiceUtil
					.getPayGrade(paygradeid);

			PortletSession portletSession = actionRequest.getPortletSession();
			portletSession.setAttribute("paygrade3", paygrade3);

			actionResponse.setRenderParameter("jspPage",
					"/html/paygrade/editpaygrade.jsp");
			System.out.println("end of method savePayGradeCurrency...");
		} else {
			System.out.println("else block to update...");
			long paygradecurrencyid = Long.parseLong(id);

			PayGradeCurrency payGradeCurrency2 = PayGradeCurrencyLocalServiceUtil
					.getPayGradeCurrency(paygradecurrencyid);
			String currency = ParamUtil.getString(actionRequest, "currency");
			long minsal = ParamUtil.getLong(actionRequest, "minSalary");
			long maxsal = ParamUtil.getLong(actionRequest, "maxSalary");
			long paygradeid = ParamUtil.getLong(actionRequest, "paygradeId");
			payGradeCurrency2.setPayGradeCurrencyId(ParamUtil.getLong(
					actionRequest, "paygradecurrencyId"));

			payGradeCurrency2.setCurrency(currency);
			payGradeCurrency2.setMinSalary(minsal);
			payGradeCurrency2.setMaxSalary(maxsal);
			payGradeCurrency2.setModifiedDate(date);
			payGradeCurrency2.setCompanyId(themeDisplay.getCompanyId());
			payGradeCurrency2.setGroupId(themeDisplay.getCompanyGroupId());
			payGradeCurrency2.setUserId(themeDisplay.getUserId());

			payGradeCurrency2.setPayGradeId(paygradeid);

			payGradeCurrency2 = PayGradeCurrencyLocalServiceUtil
					.updatePayGradeCurrency(payGradeCurrency2);

			PayGrade paygrade3 = PayGradeLocalServiceUtil
					.getPayGrade(paygradeid);
			PortletSession portletSession = actionRequest.getPortletSession();
			portletSession.setAttribute("paygrade3", paygrade3);
			actionResponse.setRenderParameter("jspPage",
					"/html/paygrade/editpaygrade.jsp");

			System.out.println("end of else block...");
		}
	}

	/**
	 * 
	 * <p>
	 * This method gets the single paygrade record from database based on the
	 * given paygradeId
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
	public void editPayGrade(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		System.out.println("inside editPayGrade...");
		String s = ParamUtil.getString(actionRequest, "id");

		System.out.println("id == " + s);

		PayGrade paygrade = PayGradeLocalServiceUtil.getPayGrade(Long
				.parseLong(s));

		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editpaygrade", paygrade);
		actionResponse.setRenderParameter("jspPage",
				"/html/paygrade/editpaygradename.jsp");
	}

	/**
	 * <p>
	 * This method gets the single paygradecurrency record from database based
	 * on the given paygradecurrencyId
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
	public void editPayGradeCurrency(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		System.out.println("inside editPayGradeCurrency...");
		String s = ParamUtil.getString(actionRequest, "id");

		System.out.println("id == " + s);

		PayGradeCurrency paygradecurrency = PayGradeCurrencyLocalServiceUtil
				.getPayGradeCurrency(Long.parseLong(s));

		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editpaygradecurrency", paygradecurrency);
		actionResponse.setRenderParameter("jspPage",
				"/html/paygrade/editpaygradecurrency.jsp");
	}

	/**
	 * <p>
	 * This method deletes the paygrade and paygradecurrency records from
	 * database based on given Id
	 * </p>
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			NumberFormatException {
		if (resourceRequest.getResourceID().equals("deletePayGrade")) {

			System.out.println("inside deletePayGrade...serveResource");

			PayGrade paygrade;
			try {

				paygrade = PayGradeLocalServiceUtil
						.createPayGrade(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"paygradeIds");

			System.out.println("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {

				System.out.println("ids == " + idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {

				System.out.println("id == " + idsArray[i]);
				if (idsArray[i].equals("on")) {

					System.out.println("All records selected...");
				} else {
					try {

						paygrade = PayGradeLocalServiceUtil.deletePayGrade(Long
								.parseLong(idsArray[i]));

						System.out.println("end of try block in delete...");

					} catch (PortalException e) {

						e.printStackTrace();
						System.out.println("portal exception...");
					} catch (SystemException e) {

						e.printStackTrace();
						System.out.println("system exception...");

					}
				}

			}
			System.out.println("end of for loop...");

		}
		if (resourceRequest.getResourceID().equals("deletePayGradeCurrency")) {

			System.out.println("inside deletePayGradeCurrency...serveResource");

			PayGradeCurrency paygradecurrency;
			try {

				paygradecurrency = PayGradeCurrencyLocalServiceUtil
						.createPayGradeCurrency(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"paygradecurrencyIds");

			System.out.println("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {

				System.out.println("ids == " + idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {

				System.out.println("id == " + idsArray[i]);
				if (idsArray[i].equals("on")) {

					System.out.println("All records selected...");
				} else {
					try {

						paygradecurrency = PayGradeCurrencyLocalServiceUtil
								.deletePayGradeCurrency(Long
										.parseLong(idsArray[i]));

						System.out.println("end of try block in delete...");

					} catch (PortalException e) {

						e.printStackTrace();
						System.out.println("portal exception...");
					} catch (SystemException e) {

						e.printStackTrace();
						System.out.println("system exception...");

					}
				}

			}
			System.out.println("end of for loop...");

		}

		System.out.println("end of deletePayGrade...");

	}

}

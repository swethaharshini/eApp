package com.rknowsys.eapp.hrm;

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
	private static Logger log = Logger.getLogger(PayGradeAction.class);

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

		log.info("inside PayGradeAction payGrade() method....");

		log.info("inside savePayGrade...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String inputName = ParamUtil.getString(actionRequest,"paygradeName");
		log.info(inputName);
		String paygradeName = inputName.trim();

		try {
			if(paygradeName == null || paygradeName.equals("")){
				
				log.info("Empty value in paygradeName...");
				SessionMessages.add(actionRequest.getPortletSession(),
						"paygradeName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/paygrade/addpaygrade.jsp");
				
			}
			else{

			
			String id = ParamUtil.getString(actionRequest, "paygradeId");
			
			

			log.info("id == " + id);
			if (id == "" || id == null) {
				log.info("inside if loop..");
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PayGrade.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("payGradeName", paygradeName));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<PayGrade> list = PayGradeLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size()>0){
					PayGrade payGrade = list.get(0);
					if(payGrade.getPayGradeName().equals(paygradeName)){
						log.info("Duplicate Name in paygradeName");
						
						SessionMessages.add(actionRequest.getPortletSession(),
								"paygradeName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/paygrade/addpaygrade.jsp");
						
					}
				}
				else{
				
				
				PayGrade paygrade = PayGradeLocalServiceUtil
						.createPayGrade(CounterLocalServiceUtil.increment());
			
				paygrade.setPayGradeName(ParamUtil.getString(actionRequest,
						"paygradeName"));
				paygrade.setCreateDate(date);
				paygrade.setModifiedDate(date);
				paygrade.setCompanyId(themeDisplay.getCompanyId());
				paygrade.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
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

				log.info("end of if block...");
				}
			} else {

				log.info("else block to update...");

				long paygradeid = Long.parseLong(id);

				PayGrade payGrade2 = PayGradeLocalServiceUtil
						.getPayGrade(paygradeid);
				payGrade2.setPayGradeId(ParamUtil.getLong(actionRequest,
						"paygradeId"));
				payGrade2.setPayGradeName(ParamUtil.getString(actionRequest,
						"paygradeName"));
				payGrade2.setModifiedDate(date);
				payGrade2.setCompanyId(themeDisplay.getCompanyId());
				payGrade2.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				payGrade2.setUserId(themeDisplay.getUserId());
				payGrade2 = PayGradeLocalServiceUtil.updatePayGrade(payGrade2);

				log.info("end of else block...");

			}
			}
		} catch (SystemException e) {

			log.error(e);
		} catch (PortalException e) {

			log.error(e);
		}
		log.info("end of the savePayGrade method");
		log.info("end of the method...");

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

		log.info("inside savePayGradeCurrency..........");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		String payGradeCurrency = ParamUtil.getString(actionRequest, "currency");
		log.info(payGradeCurrency);
		String currency = payGradeCurrency.trim();
		
		if(currency == null || currency.equals("")){
			log.info("empty value in paygradecurrency");
			
			SessionMessages.add(actionRequest.getPortletSession(),
					"paygradecurrency-empty-error");
			actionResponse.setRenderParameter("mvcPath",
					"/html/paygrade/editpaygrade.jsp");
			
		}
		else{
		String id = ParamUtil.getString(actionRequest, "paygradecurrencyId");
		Long paygradeid = ParamUtil.getLong(actionRequest, "paygradeId");
		log.info("id == " + id);
		if (id == "" || id == null) {
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PayGradeCurrency.class,PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("currency", payGradeCurrency));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("payGradeId", paygradeid));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
			@SuppressWarnings("unchecked")
			List<PayGradeCurrency> payGradeCurrencies = PayGradeLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(payGradeCurrencies.size()>0){
				
				PayGradeCurrency payGradeCurrency2 = payGradeCurrencies.get(0);
				if(payGradeCurrency2.getCurrency().equals(currency)){
					log.info("duplicate name in paygradecurrency");
					SessionMessages.add(actionRequest.getPortletSession(),
							"paygradecurrency-duplicate-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/paygrade/editpaygrade.jsp");
				}
				
			}
			else{
			
			
			PayGradeCurrency paygradecurrency = PayGradeCurrencyLocalServiceUtil
					.createPayGradeCurrency(CounterLocalServiceUtil.increment());
			
			long minsal = ParamUtil.getLong(actionRequest, "minSalary");
			long maxsal = ParamUtil.getLong(actionRequest, "maxSalary");
			log.info("values == " + currency + " , " + minsal + " ,"
					+ maxsal);
			log.info("paygradeId == " + paygradeid);
			paygradecurrency.setCurrency(currency);
			paygradecurrency.setMinSalary(minsal);
			paygradecurrency.setMaxSalary(maxsal);
			paygradecurrency.setCreateDate(date);
			paygradecurrency.setModifiedDate(date);
			paygradecurrency.setCompanyId(themeDisplay.getCompanyId());
			paygradecurrency.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
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
			log.info("end of method savePayGradeCurrency...");
			}
		}
		 else {
			 log.info("else block to update...");
			long paygradecurrencyid = Long.parseLong(id);

			PayGradeCurrency payGradeCurrency2 = PayGradeCurrencyLocalServiceUtil
					.getPayGradeCurrency(paygradecurrencyid);
			
			long minsal = ParamUtil.getLong(actionRequest, "minSalary");
			long maxsal = ParamUtil.getLong(actionRequest, "maxSalary");
			
			payGradeCurrency2.setPayGradeCurrencyId(ParamUtil.getLong(
					actionRequest, "paygradecurrencyId"));

			payGradeCurrency2.setCurrency(currency);
			payGradeCurrency2.setMinSalary(minsal);
			payGradeCurrency2.setMaxSalary(maxsal);
			payGradeCurrency2.setModifiedDate(date);
			payGradeCurrency2.setCompanyId(themeDisplay.getCompanyId());
			payGradeCurrency2.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
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

			log.info("end of else block...");
		}
		
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
		log.info("inside editPayGrade...");
		String s = ParamUtil.getString(actionRequest, "id");

		log.info("id == " + s);

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
		log.info("inside editPayGradeCurrency...");
		String s = ParamUtil.getString(actionRequest, "id");

		log.info("id == " + s);

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

			log.info("inside deletePayGrade...serveResource");

			PayGrade paygrade;
			try {

				paygrade = PayGradeLocalServiceUtil
						.createPayGrade(CounterLocalServiceUtil.increment());
				log.info(paygrade);
			} catch (SystemException e1) {

				log.error(e1);
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"paygradeIds");

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

						paygrade = PayGradeLocalServiceUtil.deletePayGrade(Long
								.parseLong(idsArray[i]));

						log.info("end of try block in delete...");

					} catch (PortalException e) {
						log.error(e);
					} catch (SystemException e) {
						log.error(e);

					}
				}

			}
			log.info("end of for loop...");

		}
		if (resourceRequest.getResourceID().equals("deletePayGradeCurrency")) {

			log.info("inside deletePayGradeCurrency...serveResource");

			PayGradeCurrency paygradecurrency;
			try {

				paygradecurrency = PayGradeCurrencyLocalServiceUtil
						.createPayGradeCurrency(CounterLocalServiceUtil
								.increment());
				log.info(paygradecurrency);
			} catch (SystemException e1) {

				log.error(e1);
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"paygradecurrencyIds");

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

						paygradecurrency = PayGradeCurrencyLocalServiceUtil
								.deletePayGradeCurrency(Long
										.parseLong(idsArray[i]));

						log.info("end of try block in delete...");

					} catch (PortalException e) {

						log.error(e);
					} catch (SystemException e) {

						log.error(e);

					}
				}

			}
			log.info("end of for loop...");

		}

		log.info("end of deletePayGrade...");

	}

}

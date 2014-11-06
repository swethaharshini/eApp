package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.ContactDetails;
//import com.rknowsys.eapp.hrm.model.ContactDetails;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.service.ContactDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;

public class ContactDetailsAction extends MVCPortlet {

	public static final String CONTACT_DETAILS_COL_NAME = "contactDetailsId";
	public static final String CONTACT_DETAILS_ADDRESS_STREET_1 = "addressStreet1";
	public static final String CONTACT_DETAILS_ADDRESS_STREET_2 = "addressStreet2";
	public static final String CONTACT_DETAILS_CITY = "city";
	public static final String CONTACT_DETAILS_STATE = "state";
	public static final String CONTACT_DETAILS_POSTAL_CODE = "postalCode";
	public static final String CONTACT_DETAILS_COUNTRY = "country";
	public static final String CONTACT_DETAILS_HOME_TELEPHONE = "homeTelephone";
	public static final String CONTACT_DETAILS_MOBILE = "mobile";
	public static final String CONTACT_DETAILS_WORK_TELEPHONE = "workTelephone";
	public static final String CONTACT_DETAILS_WORK_EMAIL = "workEmail";
	public static final String CONTACT_DETAILS_OTHER_EMAIL = "otherEmail";

	private static Logger log = Logger.getLogger(ContactDetailsAction.class);

	/**
	 * <p>
	 * This method inserts new ContactDetails record in database if the id is
	 * not existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("inside saveContactDetails...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());

		Employee employee=(Employee)actionRequest.getPortletSession().getAttribute("employee");
		
		try {
			String id = ParamUtil.getString(actionRequest,
					CONTACT_DETAILS_COL_NAME);
			log.info("id == " + id);

			if (id == null || id.isEmpty()) {

				log.info("inside if loop...");

				ContactDetails contactDetails =employee.getContactDetails(); 
//				ContactDetails contactDetails = ContactDetailsLocalServiceUtil
//						.createContactDetails(CounterLocalServiceUtil
//								.increment());
				contactDetails.setCreateDate(new Date());
				setThemeParams(themeDisplay, contactDetails);
				setContactDetails(actionRequest, contactDetails);
				
				contactDetails = ContactDetailsLocalServiceUtil
						.addContactDetails(contactDetails);
				
				log.info("b4 fwding contactDetailsId == " + id);
				
				ContactDetails ec = ContactDetailsLocalServiceUtil
						.getContactDetails(Long.parseLong(id));

				log.info(ec.getContactDetailsId());
				actionRequest.setAttribute("editContactDetails", ec);
				actionResponse.setRenderParameter("jspPage",
						"/html/contactdetails/edit_contact_details.jsp");

				log.info("end of if block");
			} else {
				log.info("else block to update...");
//				Employee employee=(Employee)actionRequest.getPortletSession().getAttribute("employee");
//				ContactDetails contactDetails =employee.getContactDetails();

				long contactDetailsId = Long.parseLong(id);
				ContactDetails contactDetails1 = ContactDetailsLocalServiceUtil
						.getContactDetails(contactDetailsId);
				contactDetails1.setContactDetailsId(ParamUtil.getLong(
						actionRequest,
						CONTACT_DETAILS_COL_NAME));
				setThemeParams(themeDisplay, contactDetails1);
				setContactDetails(actionRequest, contactDetails1);
				contactDetails1 = ContactDetailsLocalServiceUtil
						.updateContactDetails(contactDetails1);

				log.info("b4 fwding contactDetailsId == " + id);
				ContactDetails ec = ContactDetailsLocalServiceUtil
						.getContactDetails(Long.parseLong(id));

				log.info(ec.getContactDetailsId());
				actionRequest.setAttribute("editContactDetails", ec);
				actionResponse.setRenderParameter("jspPage",
						"/html/contactdetails/edit_contact_details.jsp");
				
				log.info("end of else block");

			}
		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		log.info("end of the saveContactDetails method");

	}

	private void setThemeParams(ThemeDisplay themeDisplay,
			ContactDetails contactDetails) {
		contactDetails.setCompanyId(themeDisplay.getCompanyId());
		contactDetails.setGroupId(themeDisplay.getCompanyGroupId());
		contactDetails.setUserId(themeDisplay.getUserId());
	}

	private void setContactDetails(ActionRequest actionRequest,
			ContactDetails contactDetails) {

		contactDetails.setModifiedDate(new Date());
		contactDetails.setAddressStreet1(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_ADDRESS_STREET_1));
		contactDetails.setAddressStreet2(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_ADDRESS_STREET_2));
		contactDetails.setCity(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_CITY));
		contactDetails.setPostalCode(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_POSTAL_CODE));
		contactDetails.setState(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_STATE));
		contactDetails.setCountry(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_COUNTRY));
		contactDetails.setHomeTelephone(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_HOME_TELEPHONE));
		contactDetails.setWorkTelephone(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_WORK_TELEPHONE));
		contactDetails.setMobile(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_MOBILE));
		contactDetails.setWorkEmail(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_WORK_EMAIL));
		contactDetails.setOtherEmail(ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_OTHER_EMAIL));
	}

	/**
	 * <p>
	 * This method deletes the ContactDetails record from database based on
	 * ContactDetails record Id
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
			ResourceResponse resourceResponse) throws IOException,
			NumberFormatException {
		
/*		
		if (resourceRequest.getResourceID().equals("deleteContactDetails")) {

			log.info("inside deleteContactDetails... serveResource");
			try {
				ContactDetailsLocalServiceUtil
						.createContactDetails(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"contactDetailsIds");

			log.info("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info(idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info(idsArray[i]);
				if (idsArray[i].equals("on")) {
					log.info("All records selected...");
				} else {
					try {
						ContactDetailsLocalServiceUtil
								.deleteContactDetails(Long
										.parseLong(idsArray[i]));
						log.info("end of try block in delete...");
					} catch (PortalException e) {

						e.printStackTrace();
						log.info("portal exception...");
					} catch (SystemException e) {

						e.printStackTrace();
						log.info("system exception...");
					}
				}

			}
			log.info("end of for loop..");

		}
		log.info("end of deleteContactDetails method...");
*/
	}

	
	
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
    throws IOException, PortletException {
    	
    	log.info("in doView method");
		Employee employee=(Employee)renderRequest.getPortletSession().getAttribute("employee");
		try {
			employee=EmployeeLocalServiceUtil.getEmployee(1000);
			ContactDetails contactDetails;

			contactDetails = employee.getContactDetails();
			log.info("contactDetails from service= "+contactDetails);
			//			contactDetails.setAddressStreet1("one atlantic street");

			renderRequest.setAttribute("editContactDetails", contactDetails);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( SystemException e)
		{
			
		}
		//		renderResponse.setRenderParameter("jspPage",
//				"/html/contactdetails/edit_contact_details.jsp");
        super.doView(renderRequest, renderResponse);
    }
	
	
	
	/**
	 * <p>
	 * This method gets the single ContactDetails record from database based on
	 * the given ContactDetails Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single ContactDetails record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {

		log.info("inside editContactDetails...");
		String s = ParamUtil.getString(actionRequest,
				CONTACT_DETAILS_COL_NAME);
		log.info("contactDetailsId == " + s);
		ContactDetails ec = ContactDetailsLocalServiceUtil
				.getContactDetails(Long.parseLong(s));

		log.info(ec.getContactDetailsId());
		actionRequest.setAttribute("editContactDetails", ec);
		actionResponse.setRenderParameter("jspPage",
				"/html/contactdetails/edit_contact_details.jsp");
	}
}

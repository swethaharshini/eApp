package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;

public class EmploymentStatusAction extends MVCPortlet {

	public static final String EMPLOYMENT_STATUS_ID = "employmentstatusId";
	
	private static Logger log = Logger.getLogger(EmploymentStatusAction.class);
	
	/**
	 * <p>
	 * This method inserts new EmploymentStatus record in database if the id is not
	 * existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveEmploymentStatus(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("inside saveEmploymentStatus...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		try {
			EmploymentStatus EmploymentStatus = EmploymentStatusLocalServiceUtil
					.createEmploymentStatus(CounterLocalServiceUtil.increment());

			log.info("employmentstatus = "
					+ ParamUtil.getString(actionRequest, CustomComparatorUtil.EMPLOYMENT_STATUS_COL_NAME));
			String id = ParamUtil.getString(actionRequest, EMPLOYMENT_STATUS_ID);
			log.info("id == " + id);
			Date date = new Date();
			if (id == "" || id == null) {
				log.info("inside if loop...");
				EmploymentStatus.setEmploymentstatus(ParamUtil.getString(actionRequest,
						CustomComparatorUtil.EMPLOYMENT_STATUS_COL_NAME));
				EmploymentStatus.setCreateDate(date);
				EmploymentStatus.setModifiedDate(date);
				EmploymentStatus.setCompanyId(themeDisplay.getCompanyId());
				EmploymentStatus.setGroupId(themeDisplay.getCompanyGroupId());
				EmploymentStatus.setUserId(themeDisplay.getUserId());
				EmploymentStatus = EmploymentStatusLocalServiceUtil
						.addEmploymentStatus(EmploymentStatus);
				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long EmploymentStatusid = Long.parseLong(id);

				EmploymentStatus EmploymentStatus1 = EmploymentStatusLocalServiceUtil
						.getEmploymentStatus(EmploymentStatusid);

				EmploymentStatus1.setId(EmploymentStatusid);

				EmploymentStatus1.setEmploymentstatus(ParamUtil.getString(actionRequest,
						CustomComparatorUtil.EMPLOYMENT_STATUS_COL_NAME));
				EmploymentStatus1.setModifiedDate(date);
				EmploymentStatus1.setCompanyId(themeDisplay.getCompanyId());
				EmploymentStatus1.setGroupId(themeDisplay.getCompanyGroupId());
				EmploymentStatus1.setUserId(themeDisplay.getUserId());

				EmploymentStatus1 = EmploymentStatusLocalServiceUtil
						.updateEmploymentStatus(EmploymentStatus1);
				log.info("end of else block");

			}
		} catch (SystemException e) {
			
			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		log.info("end of the saveEmploymentStatus method");

	}

	/**
	 * <p>
	 * This method deletes the EmploymentStatus record from database based on
	 * EmploymentStatus record Id
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
			ResourceResponse resourceResponse) throws IOException,NumberFormatException
           {
		if (resourceRequest.getResourceID().equals("deleteEmploymentStatus")) {

			log.info("inside deleteEmploymentStatus... serveResource");
			EmploymentStatus EmploymentStatus;
			try {
				EmploymentStatus = EmploymentStatusLocalServiceUtil
						.createEmploymentStatus(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"employmentstatusIds");

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
						EmploymentStatus = EmploymentStatusLocalServiceUtil
								.deleteEmploymentStatus(Long.parseLong(idsArray[i]));
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
		log.info("end of deleteEmploymentStatus method...");

	}

	/**
	 * <p>
	 * This method gets the single EmploymentStatus record from database based on the
	 * given EmploymentStatus Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single EmploymentStatus record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editEmploymentStatus(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("inside editEmploymentStatus...");
		String s = ParamUtil.getString(actionRequest, EMPLOYMENT_STATUS_ID);
		log.info("employmentstatusId == " + s);
		EmploymentStatus es = EmploymentStatusLocalServiceUtil.getEmploymentStatus(Long
				.parseLong(s));

		log.info(es.getId());
		log.info(es.getId());
		actionRequest.setAttribute("editemploymentstatus", es);
		actionResponse.setRenderParameter("jspPage",
				"/html/employmentstatus/editemploymentstatus.jsp");
	}

}

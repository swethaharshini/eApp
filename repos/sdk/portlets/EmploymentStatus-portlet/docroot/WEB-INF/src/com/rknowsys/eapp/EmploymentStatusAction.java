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
import com.liferay.util.servlet.filters.DynamicFilterConfig;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;

public class EmploymentStatusAction extends MVCPortlet {

	public static final String EMPLOYMENT_STATUS_ID = "employmentstatusId";

	private static Logger log = Logger.getLogger(EmploymentStatusAction.class);

	/**
	 * <p>
	 * This method inserts new EmploymentStatus record in database if the id is
	 * not existing, otherwise updates the record based on the record id.
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
		try {
			log.info("groupId = "
					+ themeDisplay.getLayout().getGroup().getGroupId());
		} catch (PortalException e2) {
			log.error(e2);
		}
		try {
			String id = ParamUtil
					.getString(actionRequest, EMPLOYMENT_STATUS_ID);
			String inputName = ParamUtil.getString(actionRequest,
					CustomComparatorUtil.EMPLOYMENT_STATUS_COL_NAME);
			String employmentStatus = inputName.trim();

			log.info("employmentstatus = "
					+ ParamUtil.getString(actionRequest,
							CustomComparatorUtil.EMPLOYMENT_STATUS_COL_NAME));

			log.info("id == " + id);
			Date date = new Date();
			if (id == "" || id == null) {
				log.info("inside if loop...");

				if (employmentStatus == null || employmentStatus.equals("")) {

					log.info("empty value in employmentstatus");

					SessionMessages.add(actionRequest.getPortletSession(),
							"employmentStatus-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/employmentstatus/addemploymentstatus.jsp");

				} else {
					Criterion criterion = null;
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(EmploymentStatus.class,
									PortletClassLoaderUtil.getClassLoader());
					criterion = RestrictionsFactoryUtil.eq("employmentstatus",
							inputName);
					try {
						criterion = RestrictionsFactoryUtil.and(criterion,
								RestrictionsFactoryUtil.eq("groupId",
										themeDisplay.getLayout().getGroup()
												.getGroupId()));
					} catch (PortalException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dynamicQuery.add(criterion);
					List<EmploymentStatus> employmentStatuslist = EmploymentStatusLocalServiceUtil
							.dynamicQuery(dynamicQuery);
					if (employmentStatuslist.size() > 0) {

						EmploymentStatus employmentStatus3 = employmentStatuslist
								.get(0);
						if (employmentStatus3.getEmploymentstatus()
								.equalsIgnoreCase(inputName)) {
							log.info("duplicate value in employmentstatus");

							SessionMessages.add(
									actionRequest.getPortletSession(),
									"employmentStatus-duplicate-error");
							actionResponse
									.setRenderParameter("mvcPath",
											"/html/employmentstatus/addemploymentstatus.jsp");

						}

					} else {
						EmploymentStatus employmentStatus2 = EmploymentStatusLocalServiceUtil
								.createEmploymentStatus(CounterLocalServiceUtil
										.increment());

						employmentStatus2
								.setEmploymentstatus(ParamUtil
										.getString(
												actionRequest,
												CustomComparatorUtil.EMPLOYMENT_STATUS_COL_NAME));
						employmentStatus2.setCreateDate(date);
						employmentStatus2.setModifiedDate(date);
						employmentStatus2.setCompanyId(themeDisplay
								.getCompanyId());
						employmentStatus2.setGroupId(themeDisplay.getLayout()
								.getGroup().getGroupId());
						employmentStatus2.setUserId(themeDisplay.getUserId());
						employmentStatus2 = EmploymentStatusLocalServiceUtil
								.addEmploymentStatus(employmentStatus2);
						log.info("end of if block..employmentstatus added");
					}
				}
			} else {
				log.info("else block to update...");
				if (employmentStatus == null || employmentStatus.equals("")) {

					log.info("empty value in employmentstatus in edit.jsp");

					EmploymentStatus es = EmploymentStatusLocalServiceUtil
							.getEmploymentStatus(Long.parseLong(id));
					PortletSession portletSession = actionRequest
							.getPortletSession();
					portletSession.setAttribute("editemploymentstatus", es);

					SessionMessages.add(actionRequest.getPortletSession(),
							"employmentStatus-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/employmentstatus/addemploymentstatus.jsp");

				} else {

					long EmploymentStatusid = Long.parseLong(id);

					EmploymentStatus employmentStatus1 = EmploymentStatusLocalServiceUtil
							.getEmploymentStatus(EmploymentStatusid);
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EmploymentStatus.class,PortletClassLoaderUtil.getClassLoader());
					dynamicQuery.add(RestrictionsFactoryUtil.eq("employmentstatus", inputName));
					dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
					List<EmploymentStatus> eList = EmploymentStatusLocalServiceUtil.dynamicQuery(dynamicQuery);
					if(eList.size()>0)
					{
						EmploymentStatus employmentStatus2 = eList.get(0);
						if(employmentStatus2.getEmploymentstatus().equalsIgnoreCase(inputName) && !employmentStatus1.getEmploymentstatus().equalsIgnoreCase(inputName))
						{
							
							SessionMessages.add(
									actionRequest.getPortletSession(),
									"employmentStatus-duplicate-error");
							actionResponse
									.setRenderParameter("mvcPath",
											"/html/employmentstatus/addemploymentstatus.jsp");
							
						}
					}
					else{

					employmentStatus1.setEmploymentStatusId(EmploymentStatusid);

					employmentStatus1.setEmploymentstatus(ParamUtil.getString(
							actionRequest,
							CustomComparatorUtil.EMPLOYMENT_STATUS_COL_NAME));
					employmentStatus1.setModifiedDate(date);
					employmentStatus1.setCompanyId(themeDisplay.getCompanyId());
					employmentStatus1.setGroupId(themeDisplay.getLayout()
							.getGroup().getGroupId());
					employmentStatus1.setUserId(themeDisplay.getUserId());

					employmentStatus1 = EmploymentStatusLocalServiceUtil
							.updateEmploymentStatus(employmentStatus1);
					log.info("end of else block");
					}
				}

			}
		} catch (SystemException e) {

			log.error(e);
		} catch (PortalException e) {

			log.error(e);
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
			ResourceResponse resourceResponse) throws IOException,
			NumberFormatException {
		if (resourceRequest.getResourceID().equals("deleteEmploymentStatus")) {

			log.info("inside deleteEmploymentStatus... serveResource");
			EmploymentStatus EmploymentStatus;

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
								.deleteEmploymentStatus(Long
										.parseLong(idsArray[i]));
						log.info("end of try block in delete...");
					} catch (PortalException e) {

						log.error(e);
					} catch (SystemException e) {

						log.error(e);
					}
				}

			}
			log.info("end of for loop..");

		}
		log.info("end of deleteEmploymentStatus method...");

	}

	/**
	 * <p>
	 * This method gets the single EmploymentStatus record from database based
	 * on the given EmploymentStatus Id
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
		String s = ParamUtil.getString(actionRequest, "employmentstatusId");
		log.info("employmentstatusId == " + s);
		EmploymentStatus es = EmploymentStatusLocalServiceUtil
				.getEmploymentStatus(Long.parseLong(s));
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editemploymentstatus", es);
		actionResponse.setRenderParameter("jspPage",
				"/html/employmentstatus/editemploymentstatus.jsp");
	}

}

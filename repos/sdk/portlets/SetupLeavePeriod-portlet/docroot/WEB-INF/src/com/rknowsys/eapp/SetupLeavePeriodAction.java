package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.LeavePeriod;
import com.rknowsys.eapp.hrm.service.LeavePeriodLocalServiceUtil;
import com.rknowsys.eapp.hrm.util.DateUtils;

public class SetupLeavePeriodAction extends MVCPortlet {

	public static final String LEAVE_PERIOD_COL_NAME = "leavePeriodId";
	public static final String LEAVE_PERIOD_START_MONTH = "startMonth";
	public static final String LEAVE_PERIOD_START_DATE = "startDate";
	public static final String LEAVE_PERIOD_END_DATE = "endDate";

	private static Logger log = Logger.getLogger(SetupLeavePeriodAction.class);

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
	public void saveLeavePeriod(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("inside saveLeavePeriod...");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());

		com.rknowsys.eapp.ui.LeavePeriod leavePeriodUI = new com.rknowsys.eapp.ui.LeavePeriod();

		try {
			String id = ParamUtil.getString(actionRequest,
					LEAVE_PERIOD_COL_NAME);
			log.info("id == " + id);
//			log.info("selected month == " + );
			LeavePeriod leavePeriod = null;
			
			if (id == null || id.isEmpty()) {

				log.info("inside if loop...");

				leavePeriod = LeavePeriodLocalServiceUtil
						.createLeavePeriod(CounterLocalServiceUtil.increment());
				leavePeriod.setCreateDate(date);
				leavePeriod.setModifiedDate(date);
				setThemeParams(themeDisplay, leavePeriod);
				setLeavePeriod(actionRequest, leavePeriod);

				leavePeriod = LeavePeriodLocalServiceUtil
						.addLeavePeriod(leavePeriod);

				setLeavePeriodUI(leavePeriodUI, leavePeriod);

				log.info("b4 fwding LeavePeriodId == " + id);

				
				PortletSession portletSession = actionRequest.getPortletSession();
				portletSession.setAttribute("editLeavePeriod", leavePeriodUI);
				actionResponse.setRenderParameter("jspPage",
						"/html/leaveperiod/edit_leave_period.jsp");
				
				SessionMessages.add(actionRequest, "saved");

				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long leavePeriodId = Long.parseLong(id);
				log.info("leavePeriodId = " + leavePeriodId);

				leavePeriod = LeavePeriodLocalServiceUtil
						.getLeavePeriod(leavePeriodId);
				leavePeriod.setModifiedDate(date);
				setThemeParams(themeDisplay, leavePeriod);
				setLeavePeriod(actionRequest, leavePeriod);
				leavePeriod = LeavePeriodLocalServiceUtil
						.updateLeavePeriod(leavePeriod);

				log.info("b4 fwding leavePeriodId == " + id);
				setLeavePeriodUI(leavePeriodUI, leavePeriod);

				log.info(leavePeriodUI.getLeavePeriodId());
				PortletSession portletSession = actionRequest.getPortletSession();
				portletSession.setAttribute("editLeavePeriod", leavePeriodUI);
				actionResponse.setRenderParameter("jspPage",
						"/html/leaveperiod/edit_leave_period.jsp");
				
				SessionMessages.add(actionRequest, "updated");

				log.info("end of else block");

			}
		} catch (SystemException e) {

			log.error(e);
			log.info("system exception");
		} catch (PortalException e) {

			log.error(e);
			log.info("portalexception");
		}
		log.info("end of the saveContactDetails method");

	}

	private void setLeavePeriodUI(
			com.rknowsys.eapp.ui.LeavePeriod leavePeriodUI,
			LeavePeriod leavePeriod) {
		leavePeriodUI.setLeavePeriodId(String.valueOf(leavePeriod
				.getLeavePeriodId()));
		leavePeriodUI.setStartDate(leavePeriod.getStartDate());
		leavePeriodUI.setStartMonth(leavePeriod.getStartMonth());
		leavePeriodUI.setEndDate(leavePeriod.getEndDate());
		String currentPeriod = getCurrentPeriod(leavePeriod.getStartDate(),
				leavePeriod.getStartMonth());
		leavePeriodUI.setCurrentLeavePeriod(currentPeriod);
	}

	private void setLeavePeriod(ActionRequest actionRequest,
			LeavePeriod leavePeriod) {

		leavePeriod.setStartDate(ParamUtil.getInteger(actionRequest,
				LEAVE_PERIOD_START_DATE));
		leavePeriod.setStartMonth(ParamUtil.getInteger(actionRequest,
				LEAVE_PERIOD_START_MONTH));

		log.info("LEAVE_PERIOD_START_MONTH == "
				+ ParamUtil.getInteger(actionRequest, LEAVE_PERIOD_START_MONTH));
		Calendar endDate = Calendar.getInstance();
		endDate.set(Calendar.getInstance().get(Calendar.YEAR),
				ParamUtil.getInteger(actionRequest, LEAVE_PERIOD_START_MONTH),
				ParamUtil.getInteger(actionRequest, LEAVE_PERIOD_START_DATE));
		if (endDate.before(Calendar.getInstance())) {
			endDate.add(Calendar.YEAR, 1);
		}
		
		endDate.add(Calendar.DAY_OF_YEAR, -1);
		int endMonth = endDate.get(Calendar.MONTH);
		log.info("endMonth == "+ endMonth);

		String endMonthName = null;
		switch (endMonth) {
		case 0:
			endMonthName = "January";
			break;
		case 1:
			endMonthName = "February";
			break;
		case 2:
			endMonthName = "March";
			break;
		case 3:
			endMonthName = "April";
			break;
		case 4:
			endMonthName = "May";
			break;
		case 5:
			endMonthName = "June";
			break;
		case 6:
			endMonthName = "July";
			break;
		case 7:
			endMonthName = "August";
			break;
		case 8:
			endMonthName = "September";
			break;
		case 9:
			endMonthName = "October";
			break;
		case 10:
			endMonthName = "November";
			break;
		case 11:
			endMonthName = "December";

		}
		leavePeriod.setEndDate(endMonthName + " " + endDate.get(Calendar.DATE));
	}

	private void setThemeParams(ThemeDisplay themeDisplay,
			LeavePeriod leavePeriod) throws PortalException, SystemException {
		leavePeriod.setCompanyId(themeDisplay.getCompanyId());
		leavePeriod.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
		leavePeriod.setUserId(themeDisplay.getUserId());
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

	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		log.info("in doView method");
		try {
			com.rknowsys.eapp.ui.LeavePeriod leavePeriodUI = new com.rknowsys.eapp.ui.LeavePeriod();
			int count = LeavePeriodLocalServiceUtil.getLeavePeriodsCount();

			// Calendar today = Calendar.getInstance();
			int thisYear = Calendar.getInstance().get(Calendar.YEAR);
			if (count == 0) {
				leavePeriodUI.setStartDate(1);
				leavePeriodUI.setStartMonth(1);
				leavePeriodUI.setEndDate("December 31");
				leavePeriodUI.setCurrentLeavePeriod("01/01/" + thisYear
						+ "  to  " + "31/12/" + thisYear);
			} else {
				List<LeavePeriod> leavePeriods = LeavePeriodLocalServiceUtil
						.getLeavePeriods(0, count);
				
				int startDate = leavePeriods.get(0).getStartDate();
				int startMonth = leavePeriods.get(0).getStartMonth();
				String endDate = leavePeriods.get(0).getEndDate();
				leavePeriodUI.setLeavePeriodId(String.valueOf(leavePeriods.get(0).getLeavePeriodId()));
				leavePeriodUI.setStartDate(startDate);
				leavePeriodUI.setStartMonth(startMonth);
				leavePeriodUI.setEndDate(endDate);

				String currentPeriod = getCurrentPeriod(startDate, startMonth);
				leavePeriodUI.setCurrentLeavePeriod(currentPeriod);
				log.info("leavePeriod from service= " + leavePeriodUI);
			}

			PortletSession portletSession = renderRequest.getPortletSession();
			portletSession.setAttribute("editLeavePeriod", leavePeriodUI);
		} catch (SystemException e) {
			log.error(e);
		}
		super.doView(renderRequest, renderResponse);
	}

	private String getCurrentPeriod(int startDate, int startMonth) {

		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		Calendar today = new GregorianCalendar();
		Calendar leavePeriodStartDate = new GregorianCalendar(thisYear,
				startMonth, startDate);
		if (leavePeriodStartDate.after(today)) {
			leavePeriodStartDate.add(Calendar.YEAR, -1);
		}

		Calendar leavePeriodEndDate = new GregorianCalendar(leavePeriodStartDate.get(Calendar.YEAR)+1,
				startMonth, startDate);
		leavePeriodEndDate.add(Calendar.DAY_OF_YEAR, -1);
//		leavePeriodEndDate.add(Calendar.YEAR, 1);
		String currentPeriodStart = DateUtils.format(leavePeriodStartDate);
		String currentPeriodEnd = DateUtils.format(leavePeriodEndDate);
		String currentPeriod = currentPeriodStart + "  to  " + currentPeriodEnd;
		return currentPeriod;
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
	public void editLeavePeriod(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {

		
	}
}

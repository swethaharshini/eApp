package com.rknowsys.eapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.Nationality;
import com.rknowsys.eapp.hrm.model.WorkWeek;
import com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkWeekLocalServiceUtil;
import com.rknowsys.eapp.hrm.util.IdNamePair;

public class SetupWorkWeekAction extends MVCPortlet {

	private static final String NATIONALITY_ID = "nationalityId";

	public static final String WORK_WEEK_ID = "workWeekId";

	private static Logger log = Logger.getLogger(SetupWorkWeekAction.class);

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
	 * @throws PortalException 
	 */
	public void saveWorkWeek(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		log.info("inside saveWorkWeek...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getLayout().getGroup().getGroupId());

		com.rknowsys.eapp.ui.WorkWeek workWeekUI = new com.rknowsys.eapp.ui.WorkWeek();

		try {
			String id = ParamUtil.getString(actionRequest, WORK_WEEK_ID);
			log.info("id == " + id);
			WorkWeek workWeek = null;

			boolean ifWorkWeekExistsForNationality = true;
			List<WorkWeek> nationWorkWeeks = WorkWeekLocalServiceUtil
					.findByNationality(ParamUtil.getInteger(actionRequest,
							NATIONALITY_ID));
			if (nationWorkWeeks == null || nationWorkWeeks.size() == 0) {
				ifWorkWeekExistsForNationality = false;
				workWeek = WorkWeekLocalServiceUtil
						.createWorkWeek(CounterLocalServiceUtil.increment());
				workWeek.setCreateDate(new Date());
			} else {
				workWeek = nationWorkWeeks.get(0);
			}

			setAuditFields(themeDisplay, workWeek);
			setWorkWeek(actionRequest, workWeek);
			if (!ifWorkWeekExistsForNationality) {
				workWeek = WorkWeekLocalServiceUtil.addWorkWeek(workWeek);
			} else {
				workWeek = WorkWeekLocalServiceUtil.updateWorkWeek(workWeek);
			}

			log.info(workWeek);
			setWorkWeekUI(workWeekUI, workWeek);
			log.info(workWeekUI);
			log.info("b4 fwding WorkWeekId == " + id);

			actionRequest.setAttribute("editWorkWeek", workWeekUI);
			actionResponse.setRenderParameter("jspPage",
					"/html/workweek/edit_work_week.jsp");
		} catch (SystemException e) {

		   log.error(e);
			log.info("system exception");
		}
		log.info("end of the saveWorkWeek method");

	}

	private void setWorkWeekUI(com.rknowsys.eapp.ui.WorkWeek workWeekUI,
			WorkWeek workWeek) throws SystemException {

		workWeekUI.setWorkWeekId(String.valueOf(workWeek.getWorkWeekId()));
		workWeekUI
				.setNationalityId((String.valueOf(workWeek.getNationalityId())));
		List<IdNamePair> nationalities = new ArrayList<IdNamePair>();
		List<Nationality> nations = NationalityLocalServiceUtil
				.getNationalities(-1, -1);
		for (Nationality nationality : nations) {
			nationalities.add(new IdNamePair(String.valueOf(nationality
					.getNationalityId()), nationality.getName()));
		}
		workWeekUI.setNationalities(nationalities);
		workWeekUI.setMondayWorkSchedule(String.valueOf(workWeek
				.getMondayWorkSchedule()));
		workWeekUI.setTuesdayWorkSchedule(String.valueOf(workWeek
				.getTuesdayWorkSchedule()));
		workWeekUI.setWednesdayWorkSchedule(String.valueOf(workWeek
				.getWednesdayWorkSchedule()));
		workWeekUI.setThursdayWorkSchedule(String.valueOf(workWeek
				.getThursdayWorkSchedule()));
		workWeekUI.setFridayWorkSchedule(String.valueOf(workWeek
				.getFridayWorkSchedule()));
		workWeekUI.setSaturdayWorkSchedule(String.valueOf(workWeek
				.getSaturdayWorkSchedule()));
		workWeekUI.setSundayWorkSchedule(String.valueOf(workWeek
				.getSundayWorkSchedule()));
	}

	private void setWorkWeek(ActionRequest actionRequest, WorkWeek workWeek) {

		workWeek.setMondayWorkSchedule(ParamUtil.getInteger(actionRequest,
				"mondayWorkScheduleEdit"));
		workWeek.setTuesdayWorkSchedule(ParamUtil.getInteger(actionRequest,
				"tuesdayWorkScheduleEdit"));
		workWeek.setWednesdayWorkSchedule(ParamUtil.getInteger(actionRequest,
				"wednesdayWorkScheduleEdit"));
		workWeek.setThursdayWorkSchedule(ParamUtil.getInteger(actionRequest,
				"thursdayWorkScheduleEdit"));
		workWeek.setFridayWorkSchedule(ParamUtil.getInteger(actionRequest,
				"fridayWorkScheduleEdit"));
		workWeek.setSaturdayWorkSchedule(ParamUtil.getInteger(actionRequest,
				"saturdayWorkScheduleEdit"));
		workWeek.setSundayWorkSchedule(ParamUtil.getInteger(actionRequest,
				"sundayWorkScheduleEdit"));
		workWeek.setNationalityId(ParamUtil.getInteger(actionRequest,
				NATIONALITY_ID));
	}

	private void setAuditFields(ThemeDisplay themeDisplay, WorkWeek workWeek) throws PortalException, SystemException {
		workWeek.setCompanyId(themeDisplay.getCompanyId());
		workWeek.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
		workWeek.setUserId(themeDisplay.getUserId());
		workWeek.setModifiedDate(new Date());
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
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		/**
		 * Read form data sent by AJAX
		 */

		String nationalityId = ParamUtil.getString(resourceRequest,
				"nationalityId");
		System.out.println("nationalityId = " + nationalityId);
		long natId = 0;
		if ((nationalityId != null) && (!nationalityId.isEmpty())) {
			natId = Long.parseLong(nationalityId);
		}
		WorkWeek ww = null;
		try {
			List<WorkWeek> workweeks = WorkWeekLocalServiceUtil
					.findByNationality(natId);
			if (workweeks != null) {
				ww = workweeks.get(0);
			}
		} catch (SystemException e) {
			log.error(e);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		if (ww != null) {
			jsonObject.put("monday", ww.getMondayWorkSchedule());
			jsonObject.put("tuesday", ww.getTuesdayWorkSchedule());
			jsonObject.put("wednesday", ww.getWednesdayWorkSchedule());
			jsonObject.put("thursday", ww.getThursdayWorkSchedule());
			jsonObject.put("friday", ww.getFridayWorkSchedule());
			jsonObject.put("saturday", ww.getSaturdayWorkSchedule());
			jsonObject.put("sunday", ww.getSundayWorkSchedule());
		}
		writer.print(jsonObject.toString());
		writer.flush();
		writer.close();
		super.serveResource(resourceRequest, resourceResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		log.info("in doView method");
		try {

			if (ParamUtil.getString(renderRequest, NATIONALITY_ID) == null
					|| ParamUtil.getInteger(renderRequest, NATIONALITY_ID) == 0
					|| ParamUtil.getInteger(renderRequest, NATIONALITY_ID) == -1) {

				com.rknowsys.eapp.ui.WorkWeek workWeekUI = new com.rknowsys.eapp.ui.WorkWeek();
				List<IdNamePair> nationalities = new ArrayList<IdNamePair>();
				List<Nationality> nations = NationalityLocalServiceUtil
						.getNationalities(0, 2);

				System.out.println(nations);
				for (Nationality nationality : nations) {
					nationalities.add(new IdNamePair(String.valueOf(nationality
							.getNationalityId()), nationality.getName()));
				}
				System.out.println(nationalities);
				workWeekUI.setNationalities(nationalities);
				// Mon thru Fri are set to Full Day by default
				workWeekUI.setMondayWorkSchedule("0");
				workWeekUI.setTuesdayWorkSchedule("0");
				workWeekUI.setWednesdayWorkSchedule("0");
				workWeekUI.setThursdayWorkSchedule("0");
				workWeekUI.setFridayWorkSchedule("0");
				// sat and sun are set to non-working days by default
				workWeekUI.setSaturdayWorkSchedule("2");
				workWeekUI.setSundayWorkSchedule("2");
				renderRequest.setAttribute("editWorkWeek", workWeekUI);
			}

		} catch (SystemException e) {
			log.error(e);
		}
		super.doView(renderRequest, renderResponse);
	}

}

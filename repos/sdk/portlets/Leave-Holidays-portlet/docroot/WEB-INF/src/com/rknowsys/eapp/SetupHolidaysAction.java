package com.rknowsys.eapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.Holiday;
import com.rknowsys.eapp.hrm.model.Location;
import com.rknowsys.eapp.hrm.model.Nationality;
import com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil;
import com.rknowsys.eapp.hrm.util.DateUtils;
import com.rknowsys.eapp.hrm.util.IdNamePair;

public class SetupHolidaysAction extends MVCPortlet {

	private static final String HOLIDAY_ID = "holidayId";
	private static Logger log = Logger.getLogger(SetupHolidaysAction.class);

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
	public void saveHoliday(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {

		log.info("inside saveHoliday...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		log.info("nationalityId = " + ParamUtil.getLong(actionRequest, "nationalityId"));
		String[] locationIds = ParamUtil.getParameterValues(actionRequest, "location");
		log.info("locationIds" + locationIds);
		long[] locationsList = new long[locationIds.length];     
		for (int i = 0; i < locationIds.length; i++) {     
			locationsList[i] = Long.parseLong(locationIds[i]);     
		}  
		
		ParamUtil.print(actionRequest);

		com.rknowsys.eapp.ui.Holiday holidayUI = new com.rknowsys.eapp.ui.Holiday();

		try {
			String id = ParamUtil.getString(actionRequest, HOLIDAY_ID);
			log.info("id == " + id);
			Holiday holiday = null;

			if (id == null || id.isEmpty()) {

				log.info("inside if loop...");

				holiday = HolidayLocalServiceUtil.createHoliday(CounterLocalServiceUtil.increment());
				holiday.setCreateDate(new Date());
				setAuditFields(themeDisplay, holiday);
				setHoliday(actionRequest, holiday);

				holiday = HolidayLocalServiceUtil.addHoliday(holiday);
                log.info("holiday id is"+ holiday.getHolidayId());
                try
                {
				LocationLocalServiceUtil.addHolidayLocations(holiday.getHolidayId(), locationsList);
                }
                catch(Exception e)
                {
                	log.info("cannot update locations");
                }
				holidayUI.setHolidayId(String.valueOf(holiday.getHolidayId()));
				initializeHolidayUI(holidayUI);

				log.info("b4 fwding HolidayId == " + holidayUI.getHolidayId());

				List<Holiday> holidayList = HolidayLocalServiceUtil.getHolidaies(0,
						HolidayLocalServiceUtil.getHolidaiesCount());
				List<com.rknowsys.eapp.ui.Holiday> holidayListUI = new ArrayList<com.rknowsys.eapp.ui.Holiday>();
				log.info("holiday count =" + HolidayLocalServiceUtil.getHolidaiesCount());
				log.info("size of list=" + holidayList.size());
				log.info(holidayList);
				setHolidayListUI(holidayList, holidayListUI);
				log.info(holidayUI);

				actionRequest.getPortletSession().setAttribute("holidayList", holidayListUI, PortletSession.APPLICATION_SCOPE);
				actionRequest.getPortletSession().setAttribute("holidaySearch", holidayUI, PortletSession.APPLICATION_SCOPE);
				actionResponse.setRenderParameter("jspPage", "/html/holiday/list_holidays.jsp");

				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long holidayId = Long.parseLong(id);
				log.info("leavePeriodId = " + holidayId);

				holiday = HolidayLocalServiceUtil.getHoliday(holidayId);
				setAuditFields(themeDisplay, holiday);
				setHoliday(actionRequest, holiday);
				holiday = HolidayLocalServiceUtil.updateHoliday(holiday);
				
				LocationLocalServiceUtil.setHolidayLocations(holidayId, locationsList);

				initializeHolidayUI(holidayUI);
				log.info("b4 fwding HolidayId == " + holidayUI.getHolidayId());

				List<Holiday> holidayList = HolidayLocalServiceUtil.getHolidaies(0,
						HolidayLocalServiceUtil.getHolidaiesCount());
				List<com.rknowsys.eapp.ui.Holiday> holidayListUI = new ArrayList<com.rknowsys.eapp.ui.Holiday>();
				log.info("holiday count =" + HolidayLocalServiceUtil.getHolidaiesCount());
				log.info("size of list=" + holidayList.size());
				log.info(holidayList);
				setHolidayListUI(holidayList, holidayListUI);
				log.info(holidayUI);

				//actionRequest.setAttribute("holidayList", holidayListUI);
				actionRequest.getPortletSession().setAttribute("holidayList", holidayListUI, PortletSession.APPLICATION_SCOPE);
				actionRequest.getPortletSession().setAttribute("holidaySearch", holidayUI, PortletSession.APPLICATION_SCOPE);
				actionResponse.setRenderParameter("jspPage", "/html/holiday/list_holidays.jsp");
				

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

	public void searchHolidays(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {

		log.info("inside searchHolidays...");
		
		String holidateFromDate = ParamUtil.getString(actionRequest, "holidayFromDate");
		String holidayToDate = ParamUtil.getString(actionRequest, "holidayToDate");
		String natId = ParamUtil.getString(actionRequest, "nationalityId");
		String locationsDivContent = ParamUtil.getString(actionRequest, "locationsDivContent");
//		int startIndex = (Integer) actionRequest.getAttribute("startIndex");
//		int endIndex = (Integer) actionRequest.getAttribute("endIndex");
		log.info("locationsDivContent = " + locationsDivContent);
//		log.info("startIndex = " + startIndex);
//		log.info("endIndex = " + endIndex);
		String[] locationIds = ParamUtil.getParameterValues(actionRequest, "location");

		log.info("before results....parameters.." + holidateFromDate + ", " + holidayToDate + ", "
				+ Arrays.toString(locationIds));

		com.rknowsys.eapp.ui.Holiday holidayUI = new com.rknowsys.eapp.ui.Holiday();
		holidayUI.setLocationsDivContent(locationsDivContent);
		List<com.rknowsys.eapp.ui.Holiday> holidayListUI = new ArrayList<com.rknowsys.eapp.ui.Holiday>();
		try {
			if ((holidateFromDate == null || holidateFromDate.isEmpty())
					&& (holidayToDate == null || holidayToDate.isEmpty()) && ((natId == null) || (natId.isEmpty()))
					&& ((locationIds == null) || (locationIds.length == 0))) {
                //				initializeHolidayUI(holidayUI)
			} else {
				holidayUI.setSearchFromDate(holidateFromDate);
				holidayUI.setSearchToDate(holidayToDate);
				holidayUI.setNationalityId(natId);

				initializeHolidayUIWithSearchInputs(holidayUI, locationIds);
			}

			// get paramteres from request
			// fromdate
			// todate
			// nationality
			// checked locations
			List<Long> locList = new ArrayList<Long>();
			for (String loc : holidayUI.getCheckedLocationsAsStringArray()) {
				if ((loc != null) && !(loc.isEmpty())) {
					Long longId = Long.parseLong(loc);
					locList.add(longId);
				}
			}
			log.info("checkedLocaList = " + locList.toString());
			long natIdlong = ((holidayUI.getNationalityId() != null) && !(holidayUI.getNationalityId().isEmpty())) ? Long
					.valueOf(holidayUI.getNationalityId()) : -1;

			List<Holiday> holidayList = HolidayLocalServiceUtil.getSearchHolidays(
					DateUtils.parse(holidayUI.getSearchFromDate()), DateUtils.parse(holidayUI.getSearchToDate()),
					natIdlong, locList);
			log.info("holiday count =" + HolidayLocalServiceUtil.getHolidaiesCount());
			log.info("size of list=" + holidayList.size());
			log.info(holidayList);
			setHolidayListUI(holidayList, holidayListUI);
			log.info(holidayUI);

			//actionRequest.setAttribute("holidaySearch", holidayUI);
			actionRequest.getPortletSession().setAttribute("holidaySearch", holidayUI, PortletSession.APPLICATION_SCOPE);
			//actionRequest.setAttribute("holidayList", holidayListUI);
			actionRequest.getPortletSession().setAttribute("holidayList", holidayListUI, PortletSession.APPLICATION_SCOPE);
		} catch (SystemException e){
			e.printStackTrace();
		}catch (PortalException e) {
				e.printStackTrace();
			}
		actionResponse.setRenderParameter("jspPage", "/html/holiday/list_holidays.jsp");
		//PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		log.info("end of the searchHolidays method");

	}

	private void initializeHolidayUI(com.rknowsys.eapp.ui.Holiday holidayUI) throws SystemException {

		Calendar newYearDay = Calendar.getInstance();
		newYearDay.set(newYearDay.get(Calendar.YEAR), 0, 1);

		Calendar yearEndDay = Calendar.getInstance();
		yearEndDay.set(yearEndDay.get(Calendar.YEAR), 11, 31);
		holidayUI.setIsAnnual("false");
		holidayUI.setIsFullDay("true");
		holidayUI.setSearchFromDate(DateUtils.format(newYearDay));
		holidayUI.setSearchToDate((DateUtils.format(yearEndDay)));
		List<IdNamePair> orgCountriesList = setHolidayUIOrgCountries(holidayUI);
		log.info("orgCountriesList = " + orgCountriesList.size());
		 List<Location> orgLocations =
		 LocationLocalServiceUtil.getLocations(0,
		 LocationLocalServiceUtil.getLocationsCount());
		List<IdNamePair> orgLocationsList = new ArrayList<IdNamePair>();
		 if (orgLocations != null && orgLocations.size() > 0) {
		 for (Location orgLocation : orgLocations) {
		 if (orgLocation.getCountry().equalsIgnoreCase(
		 NationalityLocalServiceUtil
		 .getNationalities(0,
		 NationalityLocalServiceUtil.getNationalitiesCount()).get(0)
		 .getName())) {
		 orgLocationsList.add(new
		 IdNamePair(String.valueOf(orgLocation.getLocationId()), orgLocation
		 .getName()));
		 }
		 }
		 }
		holidayUI.setOrgLocations(orgLocationsList);

	}

	private void setHoliday(ActionRequest actionRequest, Holiday holiday) throws SystemException {

		holiday.setHolidayDate(DateUtils.parse(ParamUtil.getString(actionRequest, "holidayDate")));
		holiday.setHolidayName(ParamUtil.getString(actionRequest, "holidayName"));
		String isAnnual = ParamUtil.getString(actionRequest, "isAnnual");

		if (isAnnual == null || isAnnual.equals("false")) {
			log.info("in if of annual");
			holiday.setIsAnnual(false);
		} else {
			log.info("in else of annual");
			holiday.setIsAnnual(true);
		}

		String isFullDay = ParamUtil.getString(actionRequest, "isFullDay");
		/* code changed by swetha */
	
		if (isFullDay.equals("true")) {
			log.info("in if of fullday");
			holiday.setIsFullDay(true);
		} else {
			log.info("in else of fullday");
			holiday.setIsFullDay(false);
		}
		log.info(ParamUtil.getLong(actionRequest, "nationalityId"));
		holiday.setNationalityId(ParamUtil.getLong(actionRequest, "nationalityId"));

		String[] locationIdsStr = ParamUtil.getParameterValues(actionRequest, "location");
		log.info(Arrays.toString(locationIdsStr));
		long[] locationIds = new long[locationIdsStr.length];
		int i = 0;
		for (String locationId : locationIdsStr) {
			locationIds[i] = Long.parseLong(locationId);
			i++;
		}
		//LocationLocalServiceUtil.setHolidayLocations(ParamUtil.getInteger(actionRequest, HOLIDAY_ID), locationIds);
	
		/* code changed by swetha */
	}

	private void setAuditFields(ThemeDisplay themeDisplay, Holiday leavePeriod) {
		leavePeriod.setModifiedDate(new Date());
		leavePeriod.setCompanyId(themeDisplay.getCompanyId());
		leavePeriod.setGroupId(themeDisplay.getCompanyGroupId());
		leavePeriod.setUserId(themeDisplay.getUserId());
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {


		log.info("in doView method");

		com.rknowsys.eapp.ui.Holiday holidayUI = new com.rknowsys.eapp.ui.Holiday();
		List<com.rknowsys.eapp.ui.Holiday> holidayListUI = new ArrayList<com.rknowsys.eapp.ui.Holiday>();
		try {
			refreshUI(holidayUI, holidayListUI);

			//renderRequest.setAttribute("holidaySearch", holidayUI);
			renderRequest.getPortletSession().setAttribute("holidaySearch", holidayUI, PortletSession.APPLICATION_SCOPE);
			renderRequest.getPortletSession().setAttribute("holidayList", holidayListUI, PortletSession.APPLICATION_SCOPE);
			//renderRequest.setAttribute("holidayList", holidayListUI);
		} catch (SystemException e){
			e.printStackTrace();
		}catch (PortalException e) {
				e.printStackTrace();
			}

		super.doView(renderRequest, renderResponse);
	}

	private void refreshUI(com.rknowsys.eapp.ui.Holiday holidayUI, List<com.rknowsys.eapp.ui.Holiday> holidayListUI)
			throws SystemException, PortalException {
		initializeHolidayUI(holidayUI);

		List<Holiday> holidayList = HolidayLocalServiceUtil.getHolidaies(0, HolidayLocalServiceUtil.getHolidaiesCount());
		log.info("holiday count =" + HolidayLocalServiceUtil.getHolidaiesCount());
		log.info("size of list=" + holidayList.size());
		log.info(holidayList);
		setHolidayListUI(holidayList, holidayListUI);
		log.info(holidayUI);
	}

	private void initializeHolidayUIWithSearchInputs(com.rknowsys.eapp.ui.Holiday holidayUI, String[] locationIds)
			throws SystemException, NumberFormatException, PortalException {

		List<IdNamePair> orgCountriesList = setHolidayUIOrgCountries(holidayUI);
		log.info("orgCountriesList = " + orgCountriesList.size());
		List<Location> orgLocations = LocationLocalServiceUtil.getLocations(0,
				LocationLocalServiceUtil.getLocationsCount());
		List<IdNamePair> orgLocationsList = new ArrayList<IdNamePair>();
		if (orgLocations != null && orgLocations.size() > 0) {
			for (Location orgLocation : orgLocations) {
				if (orgLocation.getCountry().equalsIgnoreCase(
						NationalityLocalServiceUtil
								.getNationalities(0, NationalityLocalServiceUtil.getNationalitiesCount()).get(0)
								.getName())) {
					orgLocationsList.add(new IdNamePair(String.valueOf(orgLocation.getLocationId()), orgLocation
							.getName()));
				}
			}
		}
		holidayUI.setOrgLocations(orgLocationsList);

		//
		List<IdNamePair> chkdLocationsList = new ArrayList<IdNamePair>();
		if (locationIds != null && locationIds.length > 0) {
			for (String location : locationIds) {
				Location locationObj = null;
				if ((location != null) && !(location.isEmpty())) {
					locationObj = LocationLocalServiceUtil.getLocation(Long.parseLong(location));
				}
				if (locationObj != null) {
					chkdLocationsList.add(new IdNamePair(location, locationObj.getName()));
				}
			}
		}
		holidayUI.setCheckedLocations(chkdLocationsList);
		holidayUI.setCheckedLocationsAsStringArray(locationIds);

	}

	private List<IdNamePair> setHolidayUIOrgCountries(com.rknowsys.eapp.ui.Holiday holidayUI) throws SystemException {
		List<Nationality> orgCountries = NationalityLocalServiceUtil.getNationalities(0,
				NationalityLocalServiceUtil.getNationalitiesCount());
		System.out.println("list from db = " + orgCountries);
		List<IdNamePair> orgCountriesList = new ArrayList<IdNamePair>();

		if (orgCountries != null && orgCountries.size() > 0) {
			for (Nationality orgCountry : orgCountries) {
				orgCountriesList
						.add(new IdNamePair(String.valueOf(orgCountry.getNationalityId()), orgCountry.getName()));
			}
		}
		holidayUI.setOrgCountries(orgCountriesList);
		return orgCountriesList;
	}

	private void setHolidayListUI(List<Holiday> holidayList, List<com.rknowsys.eapp.ui.Holiday> holidayListUI)
			throws PortalException, SystemException {
        holidayListUI.clear();
		for (Holiday holiday : holidayList) {
			com.rknowsys.eapp.ui.Holiday holidayUI = new com.rknowsys.eapp.ui.Holiday();
			setHolidayUI(holiday, holidayUI);
			holidayListUI.add(holidayUI);
		}
	}

	private void setHolidayUI(Holiday holiday, com.rknowsys.eapp.ui.Holiday holidayUI) throws PortalException,
			SystemException {

		holidayUI.setHolidayDate(DateUtils.format(holiday.getHolidayDate()));
		holidayUI.setHolidayId(String.valueOf(holiday.getHolidayId()));
		holidayUI.setHolidayName(holiday.getHolidayName());
		String isAnnual = "false";
		if (holiday.getIsAnnual()) {
			isAnnual = "true";
		}
		holidayUI.setIsAnnual(isAnnual);

		String isFullDay = "false";
		if (holiday.getIsFullDay()) {
			isFullDay = "true";
		}
		holidayUI.setIsFullDay(isFullDay);
		holidayUI.setNationalityId(String.valueOf(holiday.getNationalityId()));
		log.info("nation id==" + holiday.getNationalityId());
		if (holiday.getNationalityId() != -1)
		    holidayUI.setNationalityName(NationalityLocalServiceUtil.getNationality(holiday.getNationalityId()).getName());

		List<IdNamePair> orgCountriesList = setHolidayUIOrgCountries(holidayUI);

		List<Location> orgLocations =
				LocationLocalServiceUtil.findByNationality(holiday.getNationalityId());
		log.info("orgLocations = " + orgLocations);


		List<IdNamePair> orgLocationsList = new ArrayList<IdNamePair>();
		if (orgLocations != null && orgLocations.size() > 0) {
			for (Location orgLocation : orgLocations) {				
					orgLocationsList.add(new
							IdNamePair(String.valueOf(orgLocation.getLocationId()), orgLocation
									.getName()));
			}
		}
		holidayUI.setOrgLocations(orgLocationsList);
		log.info("getOrgLocations = " + orgLocationsList);

	}
	
	private void setHolidayUIWithLocations(Holiday holiday, com.rknowsys.eapp.ui.Holiday holidayUI) throws PortalException,
	SystemException {
        setHolidayUI(holiday, holidayUI);
		
        //Set locations from DB
		List<IdNamePair> chkdLocationsList = new ArrayList<IdNamePair>();
		List<String> locationIds = new ArrayList<String>();
		log.info("before getHolidayLOcations = holidayId = " + holiday.getHolidayId());
		List<Location> locations=null;
		try
		{
		 locations = LocationLocalServiceUtil.getHolidayLocations(holiday.getHolidayId());
		}
		catch(Exception e)
		{
			log.info("cannot get mapped locations to the holidays");
		}
		if (locations != null) {
			for (Location location : locations) {
				if (location != null) {
					chkdLocationsList.add(new IdNamePair(String.valueOf(location), location.getName()));
					locationIds.add(Long.toString(location.getLocationId()));
				}
			}
		}
		log.info("chkdLocationsList = " + chkdLocationsList);
		log.info("setCheckedLocationsAsStringArray = " + locationIds.toArray(new String[locationIds.size()]));
		holidayUI.setCheckedLocations(chkdLocationsList);
		holidayUI.setCheckedLocationsAsStringArray(locationIds.toArray(new String[locationIds.size()]));

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
	public void addEditHoliday(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException, SystemException {

		log.info("inside addEditHoliday...");
		String s = ParamUtil.getString(actionRequest, "holidayId");
		log.info(s);
		com.rknowsys.eapp.ui.Holiday holidayUI = new com.rknowsys.eapp.ui.Holiday();

		if (s == null || s.isEmpty()) {
			initializeHolidayUI(holidayUI);
		} else {
			Holiday holiday = HolidayLocalServiceUtil.getHoliday(Long.parseLong(s));
			setHolidayUIWithLocations(holiday, holidayUI);
			// initializeHolidayUI(holidayUI);

		}
		log.info("holidayId == " + s);
		// holidayUI.setHolidayDate("04/04/2014");
		log.info(holidayUI.getHolidayName());
		//actionRequest.setAttribute("editHoliday", holidayUI);
		actionRequest.getPortletSession().setAttribute("editHoliday", holidayUI, PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage", "/html/holiday/add_edit_holiday.jsp");
	}

	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		log.info("In serveResource!!!");
		
		String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
				"holidayIds");
		
		if ((idsArray == null) || (idsArray.length == 0)){

			/**
			 * Read form data sent by AJAX
			 */
			log.info("In if serveResource!!!");
			String nationalityId = ParamUtil.getString(resourceRequest, "nationalityId");
			log.info("nationalityId = " + nationalityId);
			long natId = 0;
			if ((nationalityId != null) && (!nationalityId.isEmpty())) {
				natId = Long.parseLong(nationalityId);
			}
			List<Location> allLocations = null;
			try {
				allLocations = LocationLocalServiceUtil.findByNationality(natId);
				log.info("alllocations = " + allLocations);
			} catch (SystemException e) {
				e.printStackTrace();
			}

			JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
			for (Location location : allLocations) {
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("id", location.getLocationId());
				json.put("name", location.getName());
				jsonArr.put(json);
				log.info(json);
			}

			// Send Data Back
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("allLocations", jsonArr.toString());

			PrintWriter writer = resourceResponse.getWriter();
			resourceResponse.setContentType("text/html");
			writer.write(jsonObject.toString());
			writer.flush();
			writer.close();
			super.serveResource(resourceRequest, resourceResponse);
		}
		else{
			log.info("inside else... serveResource");
			try {
				HolidayLocalServiceUtil
				.createHoliday(CounterLocalServiceUtil
						.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}


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
						long holidayId = Long
								.parseLong(idsArray[i]);

						LocationLocalServiceUtil.deleteHolidayLocations(holidayId, LocationLocalServiceUtil.getHolidayLocations(holidayId));
						HolidayLocalServiceUtil.deleteHoliday(holidayId);
						
						List<com.rknowsys.eapp.ui.Holiday> holidayList = (List<com.rknowsys.eapp.ui.Holiday>)resourceRequest.getPortletSession().getAttribute("holidayList", PortletSession.APPLICATION_SCOPE);
						com.rknowsys.eapp.ui.Holiday holidayUI = (com.rknowsys.eapp.ui.Holiday)resourceRequest.getPortletSession().getAttribute("holidaySearch", PortletSession.APPLICATION_SCOPE);

						refreshUI(holidayUI, holidayList);

						resourceRequest.getPortletSession().setAttribute("holidaySearch", holidayUI, PortletSession.APPLICATION_SCOPE);
						resourceRequest.getPortletSession().setAttribute("holidayList", holidayList, PortletSession.APPLICATION_SCOPE);
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

			log.info("end of deleteHoliday method...");
		}
	}
}
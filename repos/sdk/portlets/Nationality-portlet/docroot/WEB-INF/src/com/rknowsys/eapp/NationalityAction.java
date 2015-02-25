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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.Nationality;
import com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil;


public class NationalityAction extends MVCPortlet {

	

	Date date = new Date();
	private static Log log = LogFactoryUtil.getLog(NationalityAction.class);

	/**
	 * <p>
	 * This method inserts new nationality record in database if the id is not
	 * exits, otherwise updates the record based on the record id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 * @throws PortalException 
	 */
	public void saveNationality(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		log.info("inside saveNationality...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getLayout().getGroup().getGroupId());
		String id = ParamUtil.getString(actionRequest, "nationalityId");
		String name = ParamUtil.getString(actionRequest, "nationalityName");
		String nationalityName = name.trim();
		try {
			
			
			if (id == "" || id == null) {
				log.info("inside if loop...");
				
				if(nationalityName == null || nationalityName.equals("")){
					log.info("empty value in nationalityName");
					
					SessionMessages.add(actionRequest.getPortletSession(),
							"nationalityName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/nationality/addnationality.jsp");
					
				}
				else{
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Nationality.class,PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("name", name));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<Nationality> list = NationalityLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size()>0){
					
					Nationality nationality = list.get(0);
					if(nationality.getName().equalsIgnoreCase(name)){
						log.info("Duplicate value value in nationalityName");
						
						SessionMessages.add(actionRequest.getPortletSession(),
								"nationalityName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/nationality/addnationality.jsp");
						
						
					}
					
				}
				else{
				
				Nationality nationality = NationalityLocalServiceUtil.createNationality(CounterLocalServiceUtil.increment());
				nationality.setName(ParamUtil.getString(actionRequest,
						"nationalityName"));
				nationality.setCreateDate(date);
				nationality.setModifiedDate(date);
				nationality.setCompanyId(themeDisplay.getCompanyId());
				nationality.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				nationality.setUserId(themeDisplay.getUserId());
				
				nationality = NationalityLocalServiceUtil.addNationality(nationality);
				log.info("end of if block");
			}}} else {
				
				log.info("else block to update....");
				if(nationalityName==null || nationalityName.equals("")){
					
					Nationality nationality = NationalityLocalServiceUtil.getNationality(Long.parseLong(id));
					PortletSession portletSession = actionRequest.getPortletSession();
					portletSession.setAttribute("editnationality", nationality);
					
					SessionMessages.add(actionRequest.getPortletSession(),
							"nationalityName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/nationality/editnationality.jsp");
					
				}
				else{

				long nationalityid = Long.parseLong(id);
				Nationality nationality2 = NationalityLocalServiceUtil.getNationality(nationalityid);
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Nationality.class,PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("name", name));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<Nationality> list = NationalityLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size()>0){
					Nationality nationality = list.get(0);
					if(nationality.getName().equalsIgnoreCase(name) && !nationality2.getName().equalsIgnoreCase(name))
					{
						SessionMessages.add(actionRequest.getPortletSession(),
								"nationalityName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/nationality/addnationality.jsp");
					}
				}
				else{

				nationality2.setNationalityId(ParamUtil.getLong(actionRequest,
						"nationalityId"));

				nationality2.setName(ParamUtil.getString(actionRequest,
						"nationalityName"));
				nationality2.setModifiedDate(date);
				nationality2.setCompanyId(themeDisplay.getCompanyId());
				nationality2.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				nationality2.setUserId(themeDisplay.getUserId());

							
				nationality2 = NationalityLocalServiceUtil.updateNationality(nationality2);
				log.info("end of else block");
				}

			}}
		} catch (SystemException e) {
			
			log.error(e);
		} catch (PortalException e) {

			log.error(e);
		}
		
		log.info("end of the saveNationality  method");

	}

	/**
	 * <p>
	 * This method deletes the nationality record from database based on
	 * nationality record Id
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
		if (resourceRequest.getResourceID().equals("deleteNationality")) {

			log.info("inside deleteNationality... serveResource");
			Nationality nationality;
			try {
				nationality = NationalityLocalServiceUtil.createNationality(CounterLocalServiceUtil.increment());
			 log.info(nationality);
			} catch (SystemException e1) {

				log.error(e1);
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"nationalityIds");
		
			log.info("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {
				
				log.info("ids == " +idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info("id == " +idsArray[i]);
				if (idsArray[i].equals("on")) {
					log.info("All records selected...");
				} else {
					try {
						nationality = NationalityLocalServiceUtil.deleteNationality(Long.parseLong(idsArray[i]));
							
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
		
		log.info("end of deleteNationality method...");

	}

	/**
	 * <p>
	 * This method gets the single nationality record from database based on the
	 * given nationality Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single nationality record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editNationality(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("inside editnationality...");
		String s = ParamUtil.getString(actionRequest, "id");
		log.info("id == " + s);
		
		Nationality nationality = NationalityLocalServiceUtil.getNationality(Long.parseLong(s));
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editnationality", nationality);
		
		actionResponse.setRenderParameter("jspPage",
				"/html/nationality/editnationality.jsp");
	}

}




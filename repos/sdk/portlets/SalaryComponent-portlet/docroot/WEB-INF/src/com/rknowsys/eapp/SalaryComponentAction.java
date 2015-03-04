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
import com.rknowsys.eapp.hrm.model.SalaryComponent;
import com.rknowsys.eapp.hrm.service.SalaryComponentLocalServiceUtil;


public class SalaryComponentAction extends MVCPortlet {
	private static Logger log = Logger.getLogger(SalaryComponentAction.class);
	
	Date date = new Date();
	
	public void saveSalaryComponent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		log.info("inside method....");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		boolean totalPayable = ParamUtil.getBoolean(actionRequest, "totalPayable");// getString(actionRequest, "totalPayable");
		String componentname = ParamUtil.getString(actionRequest, "componentName");
		String salarycomponentName = componentname.trim();
		String type = ParamUtil.getString(actionRequest, "type");
		boolean costToCompany = ParamUtil.getBoolean(actionRequest, "costToCompany");
		String[] valuetype = ParamUtil.getParameterValues(actionRequest, "valueType");
		
		log.info("===");
		log.info(componentname);
		log.info(type);
		log.info("tp:" +totalPayable);
		log.info("cc" +costToCompany);
		log.info(valuetype[0]);
		log.info(valuetype[1]);
		
		String id = ParamUtil.getString(actionRequest, "salarycomponentId");
		
		if (id == "" || id == null) {
			
			if(salarycomponentName==null || salarycomponentName.equals("")){
				
				SessionMessages.add(actionRequest.getPortletSession(),
						"salarycomponentName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/salarycomponent/addsalarycomponent.jsp");
				
			}
			else{
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SalaryComponent.class, PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("componentName", componentname));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<SalaryComponent> list = SalaryComponentLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size()>0){
					
					SalaryComponent salaryComponent = list.get(0);
					if(salaryComponent.getComponentName().equalsIgnoreCase(componentname)){
						
						SessionMessages.add(actionRequest.getPortletSession(),
								"salarycomponentName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/salarycomponent/addsalarycomponent.jsp");
						
					}
					
					
				}
				else{
			
		SalaryComponent salarycomponent = SalaryComponentLocalServiceUtil.createSalaryComponent(CounterLocalServiceUtil.increment());
		
		salarycomponent.setCompanyId(themeDisplay.getCompanyId());
		salarycomponent.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
		salarycomponent.setUserId(themeDisplay.getUserId());
		salarycomponent.setCreateDate(date);
		salarycomponent.setModifiedDate(date);
		salarycomponent.setType(type);
		salarycomponent.setComponentName(componentname);
		
		if(totalPayable==true){
			log.info("true inside if tp");
			salarycomponent.setTotalPayable("Yes");
		}
		else{
			log.info("false inside else tp");
			salarycomponent.setTotalPayable("No");
		}
		if(costToCompany==true){
			
			log.info("true inside if cc");
			salarycomponent.setCostToCompany("Yes");
		}
		else{
			log.info("false inside else cc");
			salarycomponent.setCostToCompany("No");
		}
		
		if(valuetype[0].equals("true") && valuetype[1].equals("true"))
		{
			salarycomponent.setValueType("Amount,Percentage");
		}
		if(valuetype[0].equals("false") || valuetype[1].equals("false"))
		{
		if(valuetype[0].equals("true")){
			salarycomponent.setValueType("Amount");
		}
		if(valuetype[1].equals("true")){
			salarycomponent.setValueType("Percentage");
		}
		}
		if(valuetype[0].equals("false") && valuetype[1].equals("false"))
		{
			salarycomponent.setValueType("");
		}
		
		salarycomponent = SalaryComponentLocalServiceUtil.addSalaryComponent(salarycomponent);
		log.info("end of method...");
	}}}
		else{
			log.info("else block to update...");
			if(salarycomponentName==null || salarycomponentName.equals("")){
				
				SalaryComponent salarycomponent = SalaryComponentLocalServiceUtil.getSalaryComponent(Long.parseLong(id));
				
				PortletSession portletSession = actionRequest.getPortletSession();
				portletSession.setAttribute("editsalarycomponent", salarycomponent);
				
				SessionMessages.add(actionRequest.getPortletSession(),
						"salarycomponentName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/salarycomponent/editsalarycomponent.jsp");
				
			}
			else{
			
			long salarycomponentid = Long.parseLong(id);

			SalaryComponent salaryComponent1 = SalaryComponentLocalServiceUtil.getSalaryComponent(salarycomponentid);
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SalaryComponent.class, PortletClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("componentName", componentname));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
			@SuppressWarnings("unchecked")
			List<SalaryComponent> list = SalaryComponentLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(list.size()>0){
				
				SalaryComponent salaryComponent = list.get(0);
				if(salaryComponent.getComponentName().equalsIgnoreCase(componentname) && !salaryComponent1.getComponentName().equalsIgnoreCase(componentname)){
					
					SessionMessages.add(actionRequest.getPortletSession(),
							"salarycomponentName-duplicate-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/salarycomponent/list.jsp");
					
				}
				else{
					salaryComponent1.setSalaryComponentId(salarycomponentid);
					
					salaryComponent1.setCompanyId(themeDisplay.getCompanyId());
					salaryComponent1.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
					salaryComponent1.setUserId(themeDisplay.getUserId());
					salaryComponent1.setCreateDate(date);
					salaryComponent1.setModifiedDate(date);
					salaryComponent1.setType(type);
					salaryComponent1.setComponentName(componentname);
					
					if(totalPayable==true){
						log.info("true inside if tp");
						salaryComponent1.setTotalPayable("Yes");
					}
					else{
						log.info("false inside else tp");
						salaryComponent1.setTotalPayable("No");
					}
					if(costToCompany==true){
						
						log.info("true inside if cc");
						salaryComponent1.setCostToCompany("Yes");
					}
					else{
						log.info("false inside else cc");
						salaryComponent1.setCostToCompany("No");
					}
					
					if(valuetype[0].equals("true") && valuetype[1].equals("true"))
					{
						salaryComponent1.setValueType("Amount,Percentage");
					}
					if(valuetype[0].equals("false") || valuetype[1].equals("false"))
					{
					if(valuetype[0].equals("true")){
						salaryComponent1.setValueType("Amount");
					}
					if(valuetype[1].equals("true")){
						salaryComponent1.setValueType("Percentage");
					}
					}
					if(valuetype[0].equals("false") && valuetype[1].equals("false"))
					{
						salaryComponent1.setValueType("");
					}
					salaryComponent1 = SalaryComponentLocalServiceUtil.updateSalaryComponent(salaryComponent1);
					log.info("end of else block...");
					
				}
				
				
			}
			else{
			
			
			salaryComponent1.setSalaryComponentId(salarycomponentid);
			
			salaryComponent1.setCompanyId(themeDisplay.getCompanyId());
			salaryComponent1.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			salaryComponent1.setUserId(themeDisplay.getUserId());
			salaryComponent1.setCreateDate(date);
			salaryComponent1.setModifiedDate(date);
			salaryComponent1.setType(type);
			salaryComponent1.setComponentName(componentname);
			
			if(totalPayable==true){
				log.info("true inside if tp");
				salaryComponent1.setTotalPayable("Yes");
			}
			else{
				log.info("false inside else tp");
				salaryComponent1.setTotalPayable("No");
			}
			if(costToCompany==true){
				
				log.info("true inside if cc");
				salaryComponent1.setCostToCompany("Yes");
			}
			else{
				log.info("false inside else cc");
				salaryComponent1.setCostToCompany("No");
			}
			
			if(valuetype[0].equals("true") && valuetype[1].equals("true"))
			{
				salaryComponent1.setValueType("Amount,Percentage");
			}
			if(valuetype[0].equals("false") || valuetype[1].equals("false"))
			{
			if(valuetype[0].equals("true")){
				salaryComponent1.setValueType("Amount");
			}
			if(valuetype[1].equals("true")){
				salaryComponent1.setValueType("Percentage");
			}
			}
			if(valuetype[0].equals("false") && valuetype[1].equals("false"))
			{
				salaryComponent1.setValueType("");
			}
			salaryComponent1 = SalaryComponentLocalServiceUtil.updateSalaryComponent(salaryComponent1);
			log.info("end of else block...");
			}
			
		}}
	}
	public void editSalaryComponent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("inside edit...");
		String s = ParamUtil.getString(actionRequest, "id");
		log.info("id == " +s);
		SalaryComponent salarycomponent = SalaryComponentLocalServiceUtil.getSalaryComponent(Long.parseLong(s));
		
		log.info("##########");
		log.info(salarycomponent.getValueType());
		log.info(salarycomponent.getType());
		//log.info(salarycomponent.getOnlyCTC());
		log.info("&&&&&&&&&&&");
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editsalarycomponent", salarycomponent);
	
		actionResponse.setRenderParameter("jspPage",
				"/html/salarycomponent/editsalarycomponent.jsp");
	}
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,NumberFormatException
           {
		if (resourceRequest.getResourceID().equals("deleteSalaryComponent")) {

		
			log.info("inside deleteSalaryComponent... serveResource");
			SalaryComponent salarycomponent;
			
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"salarycomponentIds");
		
			
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
						salarycomponent = SalaryComponentLocalServiceUtil.deleteSalaryComponent(Long.parseLong(idsArray[i]));
						log.info("end of try block in delete..." +salarycomponent);
						
					} catch (PortalException e) {

						log.error(e);
						log.info("portal exception");
					} catch (SystemException e) {

						log.error(e);
						log.info("System exception");
						
					}
				}
				
			}
			log.info("end of for loop...");
			
		}
		log.info("end of deleteJobcategory method...");
		

	}

}

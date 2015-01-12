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
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.SalaryComponent;
import com.rknowsys.eapp.hrm.service.SalaryComponentLocalServiceUtil;


public class SalaryComponentAction extends MVCPortlet {
	
	Date date = new Date();
	
	public void saveSalaryComponent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		System.out.println("inside method....");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		boolean totalPayable = ParamUtil.getBoolean(actionRequest, "totalPayable");// getString(actionRequest, "totalPayable");
		String componentname = ParamUtil.getString(actionRequest, "componentName");
		String salarycomponentName = componentname.trim();
		String type = ParamUtil.getString(actionRequest, "type");
		boolean costToCompany = ParamUtil.getBoolean(actionRequest, "costToCompany");
		String[] valuetype = ParamUtil.getParameterValues(actionRequest, "valueType");
		
		System.out.println("===");
		System.out.println(componentname);
		System.out.println(type);
		System.out.println("tp:" +totalPayable);
		System.out.println("cc" +costToCompany);
		System.out.println(valuetype[0]);
		System.out.println(valuetype[1]);
		
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
		salarycomponent.setGroupId(themeDisplay.getCompanyGroupId());
		salarycomponent.setUserId(themeDisplay.getUserId());
		salarycomponent.setCreateDate(date);
		salarycomponent.setModifiedDate(date);
		salarycomponent.setType(type);
		salarycomponent.setComponentName(componentname);
		
		if(totalPayable==true){
			System.out.println("true inside if tp");
			salarycomponent.setTotalPayable("Yes");
		}
		else{
			System.out.println("false inside else tp");
			salarycomponent.setTotalPayable("No");
		}
		if(costToCompany==true){
			
			System.out.println("true inside if cc");
			salarycomponent.setCostToCompany("Yes");
		}
		else{
			System.out.println("false inside else cc");
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
		System.out.println("end of method...");
	}}}
		else{
			System.out.println("else block to update...");
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
			
			salaryComponent1.setSalaryComponentId(salarycomponentid);
			
			salaryComponent1.setCompanyId(themeDisplay.getCompanyId());
			salaryComponent1.setGroupId(themeDisplay.getCompanyGroupId());
			salaryComponent1.setUserId(themeDisplay.getUserId());
			salaryComponent1.setCreateDate(date);
			salaryComponent1.setModifiedDate(date);
			salaryComponent1.setType(type);
			salaryComponent1.setComponentName(componentname);
			
			if(totalPayable==true){
				System.out.println("true inside if tp");
				salaryComponent1.setTotalPayable("Yes");
			}
			else{
				System.out.println("false inside else tp");
				salaryComponent1.setTotalPayable("No");
			}
			if(costToCompany==true){
				
				System.out.println("true inside if cc");
				salaryComponent1.setCostToCompany("Yes");
			}
			else{
				System.out.println("false inside else cc");
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
			System.out.println("end of else block...");
			
		}}
	}
	public void editSalaryComponent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		System.out.println("inside edit...");
		String s = ParamUtil.getString(actionRequest, "id");
		System.out.println("id == " +s);
		SalaryComponent salarycomponent = SalaryComponentLocalServiceUtil.getSalaryComponent(Long.parseLong(s));
		
		System.out.println("##########");
		System.out.println(salarycomponent.getValueType());
		System.out.println(salarycomponent.getType());
		//System.out.println(salarycomponent.getOnlyCTC());
		System.out.println("&&&&&&&&&&&");
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editsalarycomponent", salarycomponent);
	
		actionResponse.setRenderParameter("jspPage",
				"/html/salarycomponent/editsalarycomponent.jsp");
	}
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,NumberFormatException
           {
		if (resourceRequest.getResourceID().equals("deleteSalaryComponent")) {

		
			System.out.println("inside deleteSalaryComponent... serveResource");
			SalaryComponent salarycomponent;
			
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"salarycomponentIds");
		
			
			System.out.println("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {
				
				
				System.out.println("ids == " +idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {
				
				System.out.println("id == " +idsArray[i]);
				if (idsArray[i].equals("on")) {
					System.out.println("All records selected...");
				} else {
					try {
						salarycomponent = SalaryComponentLocalServiceUtil.deleteSalaryComponent(Long.parseLong(idsArray[i]));
						System.out.println("end of try block in delete...");
						
					} catch (PortalException e) {

						e.printStackTrace();
						System.out.println("portal exception");
					} catch (SystemException e) {

						e.printStackTrace();
						System.out.println("System exception");
						
					}
				}
				
			}
			System.out.println("end of for loop...");
			
		}
		System.out.println("end of deleteJobcategory method...");
		

	}

}

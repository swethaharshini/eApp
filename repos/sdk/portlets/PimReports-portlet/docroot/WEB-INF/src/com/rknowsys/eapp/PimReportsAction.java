package com.rknowsys.eapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.PimCriteriaSelection;
import com.rknowsys.eapp.hrm.model.PimDisplayFields;
import com.rknowsys.eapp.hrm.model.PimReports;
import com.rknowsys.eapp.hrm.service.PimCriteriaSelectionLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PimDisplayFieldsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PimReportsLocalServiceUtil;

public class PimReportsAction extends MVCPortlet {
	
	
	
	private static Logger log = Logger.getLogger(PimReportsAction.class);
	
	
	public void savePimReport(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, NumberFormatException, PortalException
	{
		Date date = new Date();
	log.info("saveReport method().....");
	ThemeDisplay themeDisplay =(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	
	String reportid = ParamUtil.getString(actionRequest, "reportId");
	String reportName = ParamUtil.getString(actionRequest, "reportName");
	String include = ParamUtil.getString(actionRequest, "includeEmployees");
	String selectedCriteriaIds = ParamUtil.getString(actionRequest, "selectedCriteriaFields");
	String selectedDisplayFields = ParamUtil.getString(actionRequest, "selectedDisplayFields");
	
	log.info("selected CriteriaIds = "+selectedCriteriaIds);
	log.info("selected DisplayFieldsIds = "+selectedDisplayFields);
	log.info("include = " +include);
	if(reportid =="" || reportid==null){
		log.info("if block.....");
	PimReports pimReports = PimReportsLocalServiceUtil.createPimReports(CounterLocalServiceUtil.increment());

	pimReports.setCompanyId(themeDisplay.getCompanyId());
	pimReports.setGroupId(themeDisplay.getCompanyGroupId());
	pimReports.setUserId(themeDisplay.getUserId());
	pimReports.setCreateDate(date);
	pimReports.setModifiedDate(date);
	
	pimReports.setReportName(reportName);
	pimReports.setInclude(include);
	pimReports.setCriteriaSelectionIds(selectedCriteriaIds);
	pimReports.setDisplayFieldsIds(selectedDisplayFields);
	
	String[] selectedCriteriaArray = selectedCriteriaIds.split(",");
	
	int l = selectedCriteriaArray.length;
	
	String[] selectedtableNamesArray = new String[l];
	String[] selectedcolumnNamesArray = new String[l];
	for(int i =0;i<=selectedCriteriaArray.length-1;i++)
	{
		PimCriteriaSelection pimCriteriaSelection = PimCriteriaSelectionLocalServiceUtil.getPimCriteriaSelection(Long.parseLong(selectedCriteriaArray[i]));
		selectedtableNamesArray[i] = pimCriteriaSelection.getTableName();
		selectedcolumnNamesArray[i] = pimCriteriaSelection.getColumnName();
		
	}
	StringBuffer selectFields = new StringBuffer();
	for(int i =0;i<=selectedtableNamesArray.length-1;i++){
		
		selectFields.append(selectedtableNamesArray[i]+"."+selectedcolumnNamesArray[i]);
		if(i<selectedtableNamesArray.length-1)
		{
			selectFields.append(",");
		}
		
	}
	String selecttablecolumns = selectFields.toString();
	pimReports.setSelectTableColumns(selecttablecolumns);
	String[] selectedDisplayFieldsArray = selectedDisplayFields.split(",");
	
	int m = selectedDisplayFieldsArray.length;
	
	String[] displayTablesNamesArray = new String[m];
	String[] displayColumnNamesArray = new String[m];
	
	for(int i = 0;i<=selectedDisplayFieldsArray.length-1;i++){
		
		PimDisplayFields pimDisplayFields = PimDisplayFieldsLocalServiceUtil.getPimDisplayFields(Long.parseLong(selectedDisplayFieldsArray[i]));
		
		displayTablesNamesArray[i] = pimDisplayFields.getTableName();
		displayColumnNamesArray[i] = pimDisplayFields.getColumnName();
	}
	
	
	StringBuffer displayFields = new StringBuffer();
	
	for(int i = 0;i<=displayTablesNamesArray.length-1;i++)
	{
		displayFields.append(displayTablesNamesArray[i]+"."+displayColumnNamesArray[i]);
		if(i<displayTablesNamesArray.length-1)
		{
			displayFields.append(",");
		}
	}
	String displaytablecolumns = displayFields.toString();
	pimReports.setDisplayTableColumns(displaytablecolumns);
	pimReports = PimReportsLocalServiceUtil.addPimReports(pimReports);
	 log.info("PimReport added successfully.....");
	}
	else{
		
		log.info("else block to update.......");
		
	   long id = Long.parseLong(reportid);
	   PimReports pimReports2 = PimReportsLocalServiceUtil.getPimReports(id);

		pimReports2.setCompanyId(themeDisplay.getCompanyId());
		pimReports2.setGroupId(themeDisplay.getCompanyGroupId());
		pimReports2.setUserId(themeDisplay.getUserId());
		pimReports2.setModifiedDate(date);
		
		pimReports2.setReportName(ParamUtil.getString(actionRequest, "reportName"));
		pimReports2.setInclude(ParamUtil.getString(actionRequest, "includeEmployees"));
		pimReports2.setCriteriaSelectionIds(ParamUtil.getString(actionRequest, "selectedCriteriaFields"));
		pimReports2.setDisplayFieldsIds(ParamUtil.getString(actionRequest, "selectedDisplayFields"));
		
		String[] selectedCriteriaArray = selectedCriteriaIds.split(",");
		
		int l = selectedCriteriaArray.length;
		
		String[] selectedtableNamesArray = new String[l];
		String[] selectedcolumnNamesArray = new String[l];
		for(int i =0;i<=selectedCriteriaArray.length-1;i++)
		{
			PimCriteriaSelection pimCriteriaSelection = PimCriteriaSelectionLocalServiceUtil.getPimCriteriaSelection(Long.parseLong(selectedCriteriaArray[i]));
			selectedtableNamesArray[i] = pimCriteriaSelection.getTableName();
			selectedcolumnNamesArray[i] = pimCriteriaSelection.getColumnName();
			
		}
		StringBuffer selectFields = new StringBuffer();
		for(int i =0;i<=selectedtableNamesArray.length-1;i++){
			
			selectFields.append(selectedtableNamesArray[i]+"."+selectedcolumnNamesArray[i]);
			if(i<selectedtableNamesArray.length-1)
			{
				selectFields.append(",");
			}
			
		}
		String selecttablecolumns = selectFields.toString();
		pimReports2.setSelectTableColumns(selecttablecolumns);
		String[] selectedDisplayFieldsArray = selectedDisplayFields.split(",");
		
		int m = selectedDisplayFieldsArray.length;
		
		String[] displayTablesNamesArray = new String[m];
		String[] displayColumnNamesArray = new String[m];
		
		for(int i = 0;i<=selectedDisplayFieldsArray.length-1;i++){
			
			PimDisplayFields pimDisplayFields = PimDisplayFieldsLocalServiceUtil.getPimDisplayFields(Long.parseLong(selectedDisplayFieldsArray[i]));
			
			displayTablesNamesArray[i] = pimDisplayFields.getTableName();
			displayColumnNamesArray[i] = pimDisplayFields.getColumnName();
		}
		
		
		StringBuffer displayFields = new StringBuffer();
		
		for(int i = 0;i<=displayTablesNamesArray.length-1;i++)
		{
			displayFields.append(displayTablesNamesArray[i]+"."+displayColumnNamesArray[i]);
			if(i<displayTablesNamesArray.length-1)
			{
				displayFields.append(",");
			}
		}
		String displaytablecolumns = displayFields.toString();
		pimReports2.setDisplayTableColumns(displaytablecolumns);
		pimReports2 = PimReportsLocalServiceUtil.updatePimReports(pimReports2);
		log.info("PimReport Updated Successfully....");
		
	}
   
	
	
	}
	
	
	public void editPimReports(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException, SystemException, IOException {
		
		
		log.info("editPimReports() method...........");
		
		String reportId = ParamUtil.getString(actionRequest, "pimReportsId");
		log.info("id == " +reportId);
		PimReports pimReports = PimReportsLocalServiceUtil.getPimReports(Long.parseLong(reportId));
		log.info(pimReports);
		String[] selectedcriteriaids = pimReports.getCriteriaSelectionIds().split(",");
		log.info("Before for loop().............,,,,,,,,,");
		for(int i = 0;i<=selectedcriteriaids.length-1;i++)
		{			
			log.info(selectedcriteriaids[i]);
			PimCriteriaSelection pimCriteriaSelection = PimCriteriaSelectionLocalServiceUtil.getPimCriteriaSelection(Long.parseLong(selectedcriteriaids[i]));
			log.info(pimCriteriaSelection);
		}
		log.info("end............");
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("pimreportRecord", pimReports);
		actionResponse.setRenderParameter("mvcPath", "/html/pimreports/editreport.jsp");
		
	}
public void runPimReports(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException, SystemException, IOException {
		
		
		log.info("editPimReports() method...........");
		
		String reportId = ParamUtil.getString(actionRequest, "pimReportsId");
		log.info("id == " +reportId);
		PimReports pimReports = PimReportsLocalServiceUtil.getPimReports(Long.parseLong(reportId));
		log.info(pimReports);
		
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("pimreportRecord", pimReports);
		actionResponse.setRenderParameter("mvcPath", "/html/pimreports/runreport.jsp");
		
	}
	
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)
		       throws IOException,PortletException
		       {
		
		if (resourceRequest.getResourceID().equals("dependencyDropdown"))
		{
			log.info("dependencyDropDowns.....");
			String groupid=ParamUtil.getString(resourceRequest,"dropDownValue");
			log.info(groupid);
			DynamicQuery currencyDynamicQuery = DynamicQueryFactoryUtil
					.forClass(PimDisplayFields.class,
							PortletClassLoaderUtil.getClassLoader());
			currencyDynamicQuery.add(PropertyFactoryUtil
					.forName("displayGroupId").eq(Long.parseLong(groupid)));
			List<PimDisplayFields> list = null;
			try {
				list =  PimDisplayFieldsLocalServiceUtil.dynamicQuery(currencyDynamicQuery);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			 JSONArray displayFieldsNameJsonArray=null;// JSONArray displayFieldsIdsJsonArray = null;
			if(list!=null)
			{
				displayFieldsNameJsonArray=JSONFactoryUtil.createJSONArray();
				//displayFieldsIdsJsonArray=JSONFactoryUtil.createJSONArray();
				 for(int i=0;i<list.size();i++)
				 {
					 PimDisplayFields currencyObj=list.get(i);
					 displayFieldsNameJsonArray.put(currencyObj.getDisplayFieldName()+","+currencyObj.getDisplayFieldId()+","+currencyObj.getTableName()+","+currencyObj.getColumnName());
					// displayFieldsIdsJsonArray.put(currencyObj.getDisplayFieldId());
				 
				 }
			}
			 PrintWriter out=resourceResponse.getWriter();
			 log.info(displayFieldsNameJsonArray.toString());
			// System.out.println(displayFieldsIdsJsonArray.toString());
			 out.write(displayFieldsNameJsonArray.toString());
			
		}
		if (resourceRequest.getResourceID().equals("deleteReport")) {
			log.info("deleting the Reports");

			PimReports pimReports;
			try {
				pimReports = PimReportsLocalServiceUtil.createPimReports(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"reportIds");
		
			for (int i = 0; i <= idsArray.length - 1; i++) {
				
				log.info("ids == " +idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {
				if (idsArray[i].equals("on")) {
					log.info("All records selected...");
				} else {
					try {
						pimReports = PimReportsLocalServiceUtil.deletePimReports(Long.parseLong(idsArray[i]));
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
     }

}

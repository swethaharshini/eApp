package com.rknowsys.eapp;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.rknowsys.eapp.hrm.model.EmpJob;
import com.rknowsys.eapp.hrm.model.Workshift;
import com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkshiftLocalServiceUtil;

public class WorkshiftAction extends MVCPortlet {

	public static final String WORKSHIFT_ID = "shiftId";

	private static Logger log = Logger.getLogger(WorkshiftAction.class);
	

	/**
	 * <p>
	 * This method inserts new Workshift record in database if the id is not
	 * existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveWorkshift(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		
		
		log.info("inside saveWorkshift...");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
		String workshiftName = ParamUtil.getString(actionRequest, "workshiftName");
		String shiftName = workshiftName.trim();
		
		try {
			
			log.info("workshift = "
					+ ParamUtil.getString(actionRequest,
							CustomComparatorUtil.WORKSHIFT_COL_NAME));
			String id = ParamUtil.getString(actionRequest, WORKSHIFT_ID);
			log.info("id == " + id);
            String[] availableEmpsIds = ParamUtil.getParameterValues(actionRequest,"selectfrom");	
            String[] assignedEmpsIds = ParamUtil.getParameterValues(actionRequest,"selectto");					
            log.info("availableEmpsIds ====" +availableEmpsIds.length);
            log.info("assignedEmpsIds ====" +assignedEmpsIds.length);
            
            
			Date date = new Date();
			if (id == null|| id.isEmpty() ) {
											
				log.info("inside if loop...");
				
				if(shiftName == null || shiftName.equals("")){
	            	log.info("empty value in workshiftName ");

					SessionMessages.add(actionRequest.getPortletSession(),
							"workshiftName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/workshift/addworkshift.jsp");
	            }
				else{
					
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Workshift.class,PortletClassLoaderUtil.getClassLoader());
					dynamicQuery.add(RestrictionsFactoryUtil.eq("workshiftName", workshiftName));
					dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
					List<Workshift> workshifts = WorkshiftLocalServiceUtil.dynamicQuery(dynamicQuery);
					if(workshifts.size()>0){
						Workshift workshift = workshifts.get(0);
						if(workshift.getWorkshiftName().equalsIgnoreCase(workshiftName)){
							
							SessionMessages.add(actionRequest.getPortletSession(),
									"workshiftName-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/workshift/addworkshift.jsp");
							
						}
					}
					else
					{

				Workshift workshift = WorkshiftLocalServiceUtil
						.createWorkshift(CounterLocalServiceUtil.increment());
				
				setWorkShift(actionRequest, themeDisplay, formater, workshift,
						date);
				workshift = WorkshiftLocalServiceUtil.addWorkshift(workshift);
				
				
				if (assignedEmpsIds != null && assignedEmpsIds.length>0){
					log.info("assignedEmpsIds.length == " + assignedEmpsIds.length);
					for (String empId: assignedEmpsIds) {
						log.info(empId);
						if (empId != null && !empId.isEmpty()) {
							long eid = Long.parseLong(empId);
							EmpJob empJob = EmpJobLocalServiceUtil.getEmpJobByEmpId(eid);
							EmpJob empJob2 = EmpJobLocalServiceUtil.getEmpJob(empJob.getEmpJobId());
							empJob2.setShiftId(workshift.getShiftId());
							empJob2 = EmpJobLocalServiceUtil.updateEmpJob(empJob2);
							
							log.info("====END IF LOOP=====");
						}
						}
					}
				}

				log.info("end of if block");
				}} else {
				log.info("else block to update...");

				long shiftid = Long.parseLong(id);

				Workshift workshift = WorkshiftLocalServiceUtil
						.getWorkshift(shiftid);
				if(shiftName == null || shiftName.equals("")){
					
					PortletSession portletSession = actionRequest
							.getPortletSession();
					portletSession.setAttribute("editworkshift", workshift);

					SessionMessages.add(actionRequest.getPortletSession(),
							"workshiftName-empty-error");
					actionResponse.setRenderParameter("mvcPath",
							"/html/workshift/editworkshift.jsp");
				}
				else{
					
					
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Workshift.class,PortletClassLoaderUtil.getClassLoader());
					dynamicQuery.add(RestrictionsFactoryUtil.eq("workshiftName", workshiftName));
					dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
					List<Workshift> workshifts = WorkshiftLocalServiceUtil.dynamicQuery(dynamicQuery);
					if(workshifts.size()>0){
						Workshift workshift1 = workshifts.get(0);
						if(workshift1.getWorkshiftName().equalsIgnoreCase(workshiftName) && !workshift.getWorkshiftName().equalsIgnoreCase(workshiftName)){
							
							SessionMessages.add(actionRequest.getPortletSession(),
									"workshiftName-duplicate-error");
							actionResponse.setRenderParameter("mvcPath",
									"/html/workshift/addworkshift.jsp");
							
						}
						else{
							setWorkShift(actionRequest, themeDisplay, formater, workshift,
									date);
							
							workshift = WorkshiftLocalServiceUtil
									.updateWorkshift(workshift);
							
							if (assignedEmpsIds != null && assignedEmpsIds.length>0){
								log.info("assignedEmpsIds.length == " + assignedEmpsIds.length);
								for (String empId: assignedEmpsIds) {
									log.info(empId);
									if (empId != null && !empId.isEmpty()) {
										long eid = Long.parseLong(empId);
										EmpJob empJob = EmpJobLocalServiceUtil.getEmpJobByEmpId(eid);
										EmpJob empJob2 = EmpJobLocalServiceUtil.getEmpJob(empJob.getEmpJobId());
										empJob2.setShiftId(workshift.getShiftId());
										empJob2 = EmpJobLocalServiceUtil.updateEmpJob(empJob2);
									}
								}
							}
							if (availableEmpsIds != null && availableEmpsIds.length>0){
								for (String empId: availableEmpsIds) {
									EmpJob empJob = EmpJobLocalServiceUtil.getEmpJobByEmpId(Long.parseLong(empId));
									empJob.setShiftId(0);
									empJob = EmpJobLocalServiceUtil.updateEmpJob(empJob);
								}
								
							}
							
						}
					}						
					else{

				setWorkShift(actionRequest, themeDisplay, formater, workshift,
						date);
				
				workshift = WorkshiftLocalServiceUtil
						.updateWorkshift(workshift);
				
				if (assignedEmpsIds != null && assignedEmpsIds.length>0){
					log.info("assignedEmpsIds.length == " + assignedEmpsIds.length);
					for (String empId: assignedEmpsIds) {
						log.info(empId);
						if (empId != null && !empId.isEmpty()) {
							long eid = Long.parseLong(empId);
							EmpJob empJob = EmpJobLocalServiceUtil.getEmpJobByEmpId(eid);
							EmpJob empJob2 = EmpJobLocalServiceUtil.getEmpJob(empJob.getEmpJobId());
							empJob2.setShiftId(workshift.getShiftId());
							empJob2 = EmpJobLocalServiceUtil.updateEmpJob(empJob2);
						}
					}
				}
				if (availableEmpsIds != null && availableEmpsIds.length>0){
					for (String empId: availableEmpsIds) {
						EmpJob empJob = EmpJobLocalServiceUtil.getEmpJobByEmpId(Long.parseLong(empId));
						empJob.setShiftId(0);
						empJob = EmpJobLocalServiceUtil.updateEmpJob(empJob);
					}
					
				}
				}}
				log.info("end of else block");

			}
			

		} catch (SystemException e) {

			log.error(e);
			log.info("system exception");
		} catch (PortalException e) {

			log.error(e);
			log.info("portalexception");
		}


		log.info("end of the saveWorkshift method");
	}

	private void setWorkShift(ActionRequest actionRequest,
			ThemeDisplay themeDisplay, SimpleDateFormat formater,
			Workshift workshift, Date date) throws PortalException, SystemException {
		workshift.setWorkshiftName(ParamUtil.getString(actionRequest,
				CustomComparatorUtil.WORKSHIFT_COL_NAME));
		
		log.info("From work hrs === " +ParamUtil.getDate(actionRequest,"fromWorkHours", formater));
		log.info("From work hrs string === " +ParamUtil.getString(actionRequest,"fromWorkHours"));
		log.info("From work hrs === " +ParamUtil.getDate(actionRequest,"toWorkHours", formater));
		log.info("From work hrs string === " +ParamUtil.getString(actionRequest,"fromWorkHours"));

		workshift.setFromWorkHours(ParamUtil.getDate(actionRequest,
				"fromWorkHours", formater));
		
		workshift.setToWorkHours(ParamUtil.getDate(actionRequest,
				"toWorkHours", formater));
		

		workshift.setCreateDate(date);
		workshift.setModifiedDate(date);
		workshift.setCompanyId(themeDisplay.getCompanyId());
		workshift.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
		workshift.setUserId(themeDisplay.getUserId());
	}

	/**
	 * <p>
	 * This method deletes the Workshift record from database based on Workshift
	 * record Id
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
		if (resourceRequest.getResourceID().equals("deleteWorkshift")) {
			
			Workshift workshift;
			

			log.info("inside deleteWorkshift... serveResource");
			
			ParamUtil.print(resourceRequest);
			String[] selectedIds = ParamUtil.getParameterValues(resourceRequest,
					"workshiftIds");

			log.info("selectedIds== " + selectedIds.length);
			for (int i = 0; i <= selectedIds.length - 1; i++) {
				log.info(selectedIds[i]);

			}
			for (int i = 0; i <= selectedIds.length - 1; i++) {
				log.info(selectedIds[i]);
				if (selectedIds[i].equals("on")) {
					log.info("All records selected...");
				} else {
					long id =Long.parseLong(selectedIds[i]);
					List<EmpJob> empJoblist;
					EmpJob empJob;
					log.info("before getting list...");
					empJoblist = EmpJobLocalServiceUtil.findEmpJobListByShiftId(id);
					log.info("list size===" +empJoblist.size());
					for(int j =0;j<empJoblist.size();j++){
						log.info("for loop started..");
						empJob = empJoblist.get(j);
						log.info("empJob ==" +empJob);
						empJob.setShiftId(Long.parseLong("0"));
						try {
							empJob = EmpJobLocalServiceUtil.updateEmpJob(empJob);
						} catch (SystemException e) {
							// TODO Auto-generated catch block
							log.error(e);
						}
					}
					try {
						log.info("try block....");
						log.info("shiftId in try block...."+id);
						
						workshift = WorkshiftLocalServiceUtil.deleteWorkshift(id);
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						log.error(e);
					}
					catch (SystemException e) {
						// TODO Auto-generated catch block
						log.error(e);
					}
					
					
				}

			}
			log.info("end of for loop..");

		}
		log.info("end of deleteWorkshift method...");

	}

	/**
	 * <p>
	 * This method gets the single Workshift record from database based on the
	 * given Workshift Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single Workshift record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editWorkshift(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("inside editWorkshift...");
		String s = ParamUtil.getString(actionRequest, WORKSHIFT_ID);
		log.info("shiftId == " + s);
		Workshift ws = WorkshiftLocalServiceUtil
				.getWorkshift(Long.parseLong(s));
		

		log.info(ws.getShiftId());
		log.info(ws.getWorkshiftName());
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editworkshift", ws);
		
		actionResponse.setRenderParameter("jspPage",
				"/html/workshift/editworkshift.jsp");
	}

}

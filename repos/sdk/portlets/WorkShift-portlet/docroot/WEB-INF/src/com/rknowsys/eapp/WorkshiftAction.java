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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
							
							System.out.println("====END IF LOOP=====");
						}
					}
				}

				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long shiftid = Long.parseLong(id);

				Workshift workshift = WorkshiftLocalServiceUtil
						.getWorkshift(shiftid);

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
				
				log.info("end of else block");

			}
			

		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}


		log.info("end of the saveWorkshift method");
	}

	private void setWorkShift(ActionRequest actionRequest,
			ThemeDisplay themeDisplay, SimpleDateFormat formater,
			Workshift workshift, Date date) {
		workshift.setWorkshiftName(ParamUtil.getString(actionRequest,
				CustomComparatorUtil.WORKSHIFT_COL_NAME));

		workshift.setFromWorkHours(ParamUtil.getDate(actionRequest,
				"fromWorkHours", formater));
		log.info("fromWorkHours  as str = "
				+ ParamUtil.getString(actionRequest, "fromWorkHours"));
		log.info("toWorkHours as str = "
				+ ParamUtil.getString(actionRequest, "toWorkHours"));
		workshift.setToWorkHours(ParamUtil.getDate(actionRequest,
				"toWorkHours", formater));
		log.info("toWorkHours = "
				+ ParamUtil.getDate(actionRequest, "toWorkHours",
						formater));

		workshift.setCreateDate(date);
		workshift.setModifiedDate(date);
		workshift.setCompanyId(themeDisplay.getCompanyId());
		workshift.setGroupId(themeDisplay.getCompanyGroupId());
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
					System.out.println("before getting list...");
					empJoblist = EmpJobLocalServiceUtil.findEmpJobListByShiftId(id);
					System.out.println("list size===" +empJoblist.size());
					for(int j =0;j<empJoblist.size();j++){
						System.out.println("for loop started..");
						empJob = empJoblist.get(j);
						System.out.println("empJob ==" +empJob);
						empJob.setShiftId(Long.parseLong("0"));
						try {
							empJob = EmpJobLocalServiceUtil.updateEmpJob(empJob);
						} catch (SystemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						System.out.println("try block....");
						System.out.println("shiftId in try block...."+id);
						
						workshift = WorkshiftLocalServiceUtil.deleteWorkshift(id);
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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

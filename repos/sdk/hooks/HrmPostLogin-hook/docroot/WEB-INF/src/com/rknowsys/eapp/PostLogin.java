package com.rknowsys.eapp;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;

public class PostLogin extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {
		System.out.println("In hrm post login-hook");
		com.liferay.portal.model.User user = null;
		Layout layout=null;
		boolean roleMatched=false;
		try {
			user = PortalUtil.getUser(request);
			System.out.println("logged in user info "+user);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		if(user!=null)
		{
			DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Employee.class,PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("assignedUserId").eq(user.getUserId()));
			List<Employee> emp=null;
			Employee employee=null;
			try {
				emp=EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			if(emp!=null && emp.size()>0)
			{
				employee=emp.get(0);
			}
			List<Role> roles=null;
			try {
				roles=user.getRoles();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			Iterator<Role> userRoles=roles.iterator();
			while(userRoles.hasNext())
			{
				Role role=userRoles.next();
				if(role.getName().equalsIgnoreCase("Hrm user"))
				{
					System.out.println("role matched");
					roleMatched=true;
				}
			}
					long plid=0;
					long groupId=0;
					if(employee!=null)
					{
						groupId=employee.getGroupId();
						try {
						plid=PortalUtil.getPlidFromPortletId(groupId,"Employee_WAR_Employeeportlet");
						System.out.println("plid is "+plid);
							} catch (PortalException e) {
								e.printStackTrace();
							} catch (SystemException e) {
								e.printStackTrace();
							}
					}
					else
					{
						LastPath publiclastPath = new LastPath(StringPool.BLANK, "/web/guest"+"/add-employee");
						plid=PortalUtil.getPlidFromFriendlyURL(user.getCompanyId(), publiclastPath.getPath());
					}
					
					try {
						layout=LayoutLocalServiceUtil.getLayout(plid);
						System.out.println("layout object is "+layout);
							} catch (PortalException e) {
								e.printStackTrace();
							} catch (SystemException e) {
								e.printStackTrace();
							}
					if(layout!=null)
					{
						if(roleMatched==true)
						 {
							layout.setName("My Info");
							try {
								LayoutLocalServiceUtil.updateLayout(layout);
								System.out.println("Layout name updated successfully");
							 } catch (SystemException e) {
								e.printStackTrace();
						     }
					    }
						else
						{
							layout.setName("Employee List");
							try {
								LayoutLocalServiceUtil.updateLayout(layout);
								System.out.println("Layout name updated successfully");
							} catch (SystemException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

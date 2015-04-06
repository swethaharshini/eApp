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
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.Membership;
import com.rknowsys.eapp.hrm.service.MembershipLocalServiceUtil;

/**
 * Portlet implementation class MembershipAction
 */
public class MembershipAction extends MVCPortlet {

	private static Logger log = Logger.getLogger(MembershipAction.class);
	Date date = new Date();

	public void saveMembership(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		log.info("saveMembership method");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(actionRequest, "MembershipId");
		String name = ParamUtil.getString(actionRequest, "membership_name");
		log.info(id);
		log.info(name);
		String membershipName = name.trim();
		try {

			if (membershipName == null || membershipName.equals("")) {
				log.info("empty value in membershipName");

				SessionMessages.add(actionRequest.getPortletSession(),
						"membershipName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/membership/add.jsp");

			} else {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						Membership.class,
						PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("membershipName",
						name));
				@SuppressWarnings("unchecked")
				List<Membership> memberships = MembershipLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (memberships.size() > 0) {

					Membership membership = memberships.get(0);
					if (membership.getMembershipName().equals(name)) {
						log.info("DuplicateName in membershipName");

						SessionMessages.add(actionRequest.getPortletSession(),
								"membershipName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/membership/add.jsp");

					}

				} else {

					Membership membership = MembershipLocalServiceUtil
							.createMembership(CounterLocalServiceUtil
									.increment());

					System.out.println("id == " + id);
					if (id == "" || id == null) {

						membership.setCreateDate(date);
						membership.setModifiedDate(date);
						membership.setCompanyId(themeDisplay.getCompanyId());
						membership.setGroupId(themeDisplay.getLayout()
								.getGroup().getGroupId());
						membership.setUserId(themeDisplay.getUserId());
						membership.setMembershipName(name);
						membership = MembershipLocalServiceUtil
								.addMembership(membership);
						log.info("membershipName added");
					}
				}
			}
		} catch (SystemException e) {

			log.error(e);
		}

	}

	public void updateMembership(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("updateMembership method");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "membershipId");
		String name = ParamUtil.getString(actionRequest, "membership_name");
		log.info(id);
		log.info(name);
		String membershipName = name.trim();
		System.out.println("id == " + id);
		Membership membership;
		try {
			if (membershipName == null || membershipName.equals("")) {
				log.info("empty value in membershipName in edit.jsp");

				Membership editmembership = MembershipLocalServiceUtil
						.getMembership(Long.parseLong(id));
				PortletSession portletSession = actionRequest
						.getPortletSession();
				portletSession.setAttribute("editMembership", editmembership);

				SessionMessages.add(actionRequest.getPortletSession(),
						"membershipName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/membership/edit.jsp");

			} else {

				membership = MembershipLocalServiceUtil.getMembership(Long
						.parseLong(id));
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Membership.class,PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("membershipName", name));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", themeDisplay.getLayout().getGroup().getGroupId()));
				@SuppressWarnings("unchecked")
				List<Membership> list = MembershipLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(list.size()>0){
					Membership membership2 = list.get(0);
					if(membership2.getMembershipName().equalsIgnoreCase(name) && ! membership.getMembershipName().equalsIgnoreCase(name)){
						
						SessionMessages.add(actionRequest.getPortletSession(),
								"membershipName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/membership/add.jsp");
						
					}
				}
				else{
				
				membership.setCreateDate(date);
				membership.setModifiedDate(date);
				membership.setCompanyId(themeDisplay.getCompanyId());
				membership.setGroupId(themeDisplay.getLayout().getGroup()
						.getGroupId());
				membership.setUserId(themeDisplay.getUserId());
				membership.setMembershipName(name);
				membership = MembershipLocalServiceUtil
						.updateMembership(membership);
				log.info("membershipName updated successfully");
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
	}

	/**
	 * <p>
	 * This method deletes the Memberships record from database based on
	 * Memberships record Id
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
			ResourceResponse resourceResponse) throws IOException {
		if (resourceRequest.getResourceID().equals("deleteMembership")) {
			log.info("deleting thes membership");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"membershipIds");
			log.info(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						MembershipLocalServiceUtil.deleteMembership(Long
								.parseLong(idsArray[i]));
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						log.error(e);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						log.error(e);
					}
				} catch (NumberFormatException e) {
					log.error(e);
				}
			}

		}

	}

	public void editMembership(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("editMembership method");
		Long membershipId = ParamUtil.getLong(actionRequest, "membershipId");
		Membership membership = MembershipLocalServiceUtil
				.getMembership(membershipId);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editMembership", membership);
		actionResponse.setRenderParameter("jspPage",
				"/html/membership/edit.jsp");
	}

}

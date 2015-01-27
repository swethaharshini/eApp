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
import com.liferay.portal.kernel.dao.orm.Criterion;
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
import com.rknowsys.eapp.hrm.model.Education;
import com.rknowsys.eapp.hrm.model.Skill;
import com.rknowsys.eapp.hrm.service.EducationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil;

/**
 * Portlet implementation class SkillsAction
 */
public class SkillsAction extends MVCPortlet {
	Date date = new Date();

	public void saveSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String id = ParamUtil.getString(actionRequest, "SkillId");
			String name = ParamUtil.getString(actionRequest, "skill_name");
			String description = ParamUtil.getString(actionRequest,
					"skill_description");
			System.out.println("id == " + id +" "+name);
			if (name == "" || name == null) {
				SessionMessages.add(actionRequest.getPortletSession(),
						"skillName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/skill/add.jsp");
			} else {
				Criterion criterion = null;
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						Skill.class, PortletClassLoaderUtil.getClassLoader());
				criterion = RestrictionsFactoryUtil.eq("skillName", name);
				try {
					criterion = RestrictionsFactoryUtil.and(
							criterion,
							RestrictionsFactoryUtil.eq("groupId", themeDisplay
									.getLayout().getGroup().getGroupId()));
				} catch (PortalException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dynamicQuery.add(criterion);
				@SuppressWarnings("unchecked")
				List<Skill> list = SkillLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (list.size() > 0) {

					Skill skill = list.get(0);
					if (skill.getSkillName().equalsIgnoreCase(name)) {
						SessionMessages.add(actionRequest.getPortletSession(),
								"skillName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/skill/add.jsp");
					}

				} else {
					Skill skills = SkillLocalServiceUtil
							.createSkill(CounterLocalServiceUtil.increment());
					if (id == "" || id == null) {
						skills.setSkillName(name);
						skills.setCreateDate(date);
						skills.setModifiedDate(date);
						skills.setCompanyId(themeDisplay.getCompanyId());
						try {
							skills.setGroupId(themeDisplay.getLayout()
									.getGroup().getGroupId());
						} catch (PortalException e) {
							e.printStackTrace();
						}
						skills.setUserId(themeDisplay.getUserId());
						skills.setDescription(description);
						skills = SkillLocalServiceUtil.addSkill(skills);
					}
				}
			}
		} catch (SystemException e) {

			e.printStackTrace();
		}
	}

	public void updateSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "skillId");
		String name = ParamUtil.getString(actionRequest, "skill_name");
		String description = ParamUtil.getString(actionRequest,
				"skill_description");
		System.out.println("id == " + id);
		if (name == "" || name == null) {
			Skill skill = null;
			try {
				skill = SkillLocalServiceUtil
						.getSkill(Long.parseLong(id));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
			}
			PortletSession portletSession = actionRequest
					.getPortletSession();
			portletSession.setAttribute("editSkill", skill);
			SessionMessages.add(actionRequest.getPortletSession(),
					"skillName-empty-error");
			actionResponse.setRenderParameter("mvcPath",
					"/html/skill/add.jsp");
		}
		else
		{
		Skill skills;
		try {
			skills = SkillLocalServiceUtil.getSkill(Long.parseLong(id));
			skills.setCreateDate(date);
			skills.setModifiedDate(date);
			skills.setCompanyId(themeDisplay.getCompanyId());
			skills.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
			skills.setUserId(themeDisplay.getUserId());
			skills.setSkillName(name);
			skills.setDescription(description);
			skills = SkillLocalServiceUtil.updateSkill(skills);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	/**
	 * <p>
	 * This method deletes the Skills record from database based on Skills
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
			ResourceResponse resourceResponse) throws IOException {
		if (resourceRequest.getResourceID().equals("deleteSkill")) {
			System.out.println("deleting thes skills");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"skillIds");
			System.out.println(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						SkillLocalServiceUtil.deleteSkill(Long
								.parseLong(idsArray[i]));
					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
				} catch (NumberFormatException e) {
				}
			}

		}

	}

	public void editSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		String skillId = ParamUtil.getString(actionRequest, "skillId");
		Skill skills = SkillLocalServiceUtil.getSkill(Long.parseLong(skillId));
		PortletSession portletSession = actionRequest
				.getPortletSession();
		portletSession.setAttribute("editSkill", skills);
		actionResponse.setRenderParameter("jspPage", "/html/skill/edit.jsp");
	}

}
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
import com.rknowsys.eapp.hrm.model.Skill;
import com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil;

/**
 * Portlet implementation class SkillsAction
 */
public class SkillsAction extends MVCPortlet {
	private static Logger log = Logger.getLogger(SkillsAction.class);
	Date date = new Date();

	public void saveSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("saveSkill method");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String id = ParamUtil.getString(actionRequest, "SkillId");
			String name = ParamUtil.getString(actionRequest, "skill_name");
			String skillName = name.trim();
			String description = ParamUtil.getString(actionRequest,
					"skill_description");
			log.info(id);
			log.info(name);
			if (skillName == "" || skillName == null) {
				log.info("empty value in skillName");
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
					log.error(e1);
				}
				dynamicQuery.add(criterion);
				@SuppressWarnings("unchecked")
				List<Skill> list = SkillLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (list.size() > 0) {
					
					log.info("list size greater than zero...");

					Skill skill = list.get(0);
					if (skill.getSkillName().equalsIgnoreCase(name)) {
						log.info("Duplicate value in skillName");
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
							log.error(e);
						}
						skills.setUserId(themeDisplay.getUserId());
						skills.setDescription(description);
						skills = SkillLocalServiceUtil.addSkill(skills);
						log.info("skillName added");
					}
				}
			}
		} catch (SystemException e) {

			log.error(e);
		}
	}

	public void updateSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("updateSkill method");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "skillId");
		String name = ParamUtil.getString(actionRequest, "skill_name");
		String skillName = name.trim();
		String description = ParamUtil.getString(actionRequest,
				"skill_description");
		log.info(id);
		log.info(name);
		if (skillName == "" || skillName == null) {
			log.info("empty value in skilName edit.jsp");
			Skill skill = null;
			try {
				skill = SkillLocalServiceUtil.getSkill(Long.parseLong(id));
			} catch (NumberFormatException e) {
				log.error(e);
			} catch (PortalException e) {
				log.error(e);
			}
			PortletSession portletSession = actionRequest.getPortletSession();
			portletSession.setAttribute("editSkill", skill);
			SessionMessages.add(actionRequest.getPortletSession(),
					"skillName-empty-error");
			actionResponse.setRenderParameter("mvcPath", "/html/skill/add.jsp");
		} else {
			Skill skills;
			Skill skillObj;
			
			
			try {
				skills = SkillLocalServiceUtil.getSkill(Long.parseLong(id));
				
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
					log.error(e1);
				}
				dynamicQuery.add(criterion);
				@SuppressWarnings("unchecked")
				List<Skill> list = SkillLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				log.info("list size === "+list.size());
			    if(list.size()>0){
				skillObj = list.get(0);
					if (skillObj.getSkillName().equalsIgnoreCase(name) && !skills.getSkillName().equalsIgnoreCase(name)) {
						log.info("Duplicate value in skillName");
						SessionMessages.add(actionRequest.getPortletSession(),
								"skillName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/skill/add.jsp");
					}
			    }
				else{	
				log.info("else block before updating....");
			
				skills.setCreateDate(date);
				skills.setModifiedDate(date);
				skills.setCompanyId(themeDisplay.getCompanyId());
				skills.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
				skills.setUserId(themeDisplay.getUserId());
				skills.setSkillName(name);
				skills.setDescription(description);
				skills = SkillLocalServiceUtil.updateSkill(skills);
				log.info("skillName updated successfully");
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				log.error(e);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				log.error(e);
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
			log.info("deleting these skills");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"skillIds");
			log.info(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						SkillLocalServiceUtil.deleteSkill(Long
								.parseLong(idsArray[i]));
					} catch (PortalException e) {
						log.error(e);
					} catch (SystemException e) {
						log.error(e);
					}
				} catch (NumberFormatException e) {
					log.error(e);
				}
			}

		}

	}

	public void editSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("editSkill method");
		String skillId = ParamUtil.getString(actionRequest, "skillId");
		Skill skills = SkillLocalServiceUtil.getSkill(Long.parseLong(skillId));
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editSkill", skills);
		actionResponse.setRenderParameter("jspPage", "/html/skill/edit.jsp");
	}

}
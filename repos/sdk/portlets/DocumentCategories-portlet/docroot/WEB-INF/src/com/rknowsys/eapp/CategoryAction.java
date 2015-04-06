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
import com.rknowsys.eapp.hrm.model.DocumentCategories;
import com.rknowsys.eapp.hrm.service.DocumentCategoriesLocalServiceUtil;

public class CategoryAction extends MVCPortlet {
	private static Logger log = Logger.getLogger(CategoryAction.class);
	Date date = new Date();

	public void saveCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		System.out.println("entered.....");
		log.info("Entered into saveCategory method in CategoryAction");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String id = ParamUtil
					.getString(actionRequest, "documentcategoryId");
			String name = ParamUtil.getString(actionRequest, "category_name");
			String categoryname = name.trim();
			if (categoryname == "" || categoryname == null) {
				SessionMessages.add(actionRequest.getPortletSession(),
						"categoryName-empty-error");
				actionResponse.setRenderParameter("mvcPath",
						"/html/category/addcategory.jsp");
			}

			else {
				Criterion criterion = null;
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						DocumentCategories.class,
						PortletClassLoaderUtil.getClassLoader());
				criterion = RestrictionsFactoryUtil
						.eq("documentCategory", name);
				try {
					criterion = RestrictionsFactoryUtil.and(
							criterion,
							RestrictionsFactoryUtil.eq("groupId", themeDisplay
									.getLayout().getGroup().getGroupId()));
				} catch (PortalException e1) {
					// TODO Auto-generated catch block
					log.error("PortalException " + e1);
				}
				dynamicQuery.add(criterion);
				@SuppressWarnings("unchecked")
				List<DocumentCategories> categories = DocumentCategoriesLocalServiceUtil
						.dynamicQuery(dynamicQuery);
				if (categories.size() > 0) {

					DocumentCategories category = categories.get(0);
					if (category.getDocumentCategory().equalsIgnoreCase(name)) {
						log.info("DuplicateName in Categories");

						SessionMessages.add(actionRequest.getPortletSession(),
								"categoryName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/category/addcategory.jsp");

					}

				}

				else {

					DocumentCategories category = DocumentCategoriesLocalServiceUtil
							.createDocumentCategories(CounterLocalServiceUtil
									.increment());
					if (id == "" || id == null) {
						category.setDocumentCategory(name);
						category.setCreateDate(date);
						category.setModifiedDate(date);
						category.setUserId(themeDisplay.getUserId());
						category.setCompanyId(themeDisplay.getCompanyId());
						category.setGroupId(themeDisplay.getLayout().getGroup()
								.getGroupId());
						category = DocumentCategoriesLocalServiceUtil
								.addDocumentCategories(category);
						SessionMessages.add(actionRequest.getPortletSession(),
								"categoryName-add-msg");

					}
				}
			}
		} catch (PortalException e) {

		}

	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {

		System.out.println("entered into serveResource");
		if (resourceRequest.getResourceID().equals("deleteCategory")) {
			log.info("serverResource method in CategoryAction for deleting records");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"categoryIds");
			log.info("selected records to be deleted " + idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {
				try {

					DocumentCategoriesLocalServiceUtil
							.deleteDocumentCategories(Long
									.parseLong(idsArray[i]));

					log.info("category deleted...." + idsArray[i]);

				} catch (SystemException e) {
					// TODO Auto-generated catch block
					log.error("SystemException " + e);
				}

				catch (NumberFormatException e) {
					log.error("NumberFormatException" + e);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					log.error("PortalException " + e);
				}
			}
			log.info("selected records deleted");

		}
		SessionMessages.add(resourceRequest.getPortletSession(),
				"categoryName-delete-msg");

	}

	public void editCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("editCategory method in CategoryAction");
		Long documentcategoryId = ParamUtil.getLong(actionRequest,
				"documentcategoryId");
		DocumentCategories categories = DocumentCategoriesLocalServiceUtil
				.getDocumentCategories(documentcategoryId);

		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("editCategory", categories);
		actionResponse.setRenderParameter("jspPage", "/html/category/edit.jsp");
	}

	public void updateCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(actionRequest, "documentcategoryId");
		String name = ParamUtil.getString(actionRequest, "category_name");
		String categoryname = name.trim();
		DocumentCategories categories;
		try {
			if (categoryname == "" || categoryname == null) {
				SessionMessages.add(actionRequest.getPortletSession(),
						"categoryName-empty-error");
				categories = DocumentCategoriesLocalServiceUtil
						.getDocumentCategories(Long.parseLong(id));

				PortletSession portletSession = actionRequest
						.getPortletSession();
				portletSession.setAttribute("editCategory", categories);
				actionResponse.setRenderParameter("jspPage",
						"/html/category/edit.jsp");
			} else {
				categories = DocumentCategoriesLocalServiceUtil
						.getDocumentCategories(Long.parseLong(id));

				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
						DocumentCategories.class,
						PortletClassLoaderUtil.getClassLoader());
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId",
						themeDisplay.getLayout().getGroup().getGroupId()));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("documentCategory",
						name));
				@SuppressWarnings("unchecked")
				List<DocumentCategories> list = DocumentCategoriesLocalServiceUtil
						.dynamicQuery(dynamicQuery);

				if (list.size() > 0) {
					DocumentCategories categories2 = list.get(0);
					if (categories2.getDocumentCategory()
							.equalsIgnoreCase(name)
							&& !categories.getDocumentCategory()
									.equalsIgnoreCase(name)) {
						SessionMessages.add(actionRequest.getPortletSession(),
								"categoryName-duplicate-error");
						actionResponse.setRenderParameter("mvcPath",
								"/html/category/addcategory.jsp");
					} else {
						categories.setDocumentCategory(name);
						categories.setCreateDate(date);
						categories.setModifiedDate(date);
						categories.setUserId(themeDisplay.getUserId());
						categories.setCompanyId(themeDisplay.getCompanyId());
						categories.setGroupId(themeDisplay.getLayout()
								.getGroup().getGroupId());
						categories = DocumentCategoriesLocalServiceUtil
								.updateDocumentCategories(categories);
					}
				}
				else{

				categories.setDocumentCategory(name);
				categories.setCreateDate(date);
				categories.setModifiedDate(date);
				categories.setUserId(themeDisplay.getUserId());
				categories.setCompanyId(themeDisplay.getCompanyId());
				categories.setGroupId(themeDisplay.getLayout().getGroup()
						.getGroupId());
				categories = DocumentCategoriesLocalServiceUtil
						.updateDocumentCategories(categories);
				SessionMessages.add(actionRequest.getPortletSession(),
						"categoryName-updated-msg");
				}

			}
		} catch (NumberFormatException ne) {

		}

		
	}

}
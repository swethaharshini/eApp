<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="com.rknowsys.eapp.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.JobCategory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<portlet:defineObjects />
<theme:defineObjects/>

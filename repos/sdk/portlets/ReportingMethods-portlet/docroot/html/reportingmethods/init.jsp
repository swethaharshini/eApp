<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="java.util.Collections"%>
<%@page import="com.rknowsys.eapp.CustomComparatorUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rknowsys.eapp.hrm.model.Language" %>
<%@ page import="com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<theme:defineObjects/>
<portlet:defineObjects />
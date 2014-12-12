<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<!-- utility and model classes imported from portal -->

<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>

<!-- imported classes from java library -->
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Map"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Calendar"%>

<!-- utility and model classes from services portlet -->
<%@page import="com.rknowsys.eapp.hrm.model.LeaveType"%>
<%@page import="com.rknowsys.eapp.hrm.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Nationality" %>
<%@page import="com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil" %>
<%@page import="com.rknowsys.eapp.hrm.model.LeaveGeneral"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.rknowsys.eapp.hrm.model.LeaveRestriction"%>
<portlet:defineObjects/>
<theme:defineObjects/>
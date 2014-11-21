<%@page import="java.util.Iterator"%>
<%@page import="com.rknowsys.eapp.hrm.service.SubUnitLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.SubUnit"%>
<%@page import="com.rknowsys.eapp.hrm.model.JobTitle"%>
<%@page import="java.util.List"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmploymentStatus"%>
<%@page import="com.rknowsys.eapp.hrm.model.Nationality"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmpDetailsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpDetails"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpPersonalDetails"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<theme:defineObjects/>
<portlet:defineObjects/>
<liferay-portlet:renderURL varImpl="employeeSearchURL">
<portlet:param name="mvcPath" value="/html/employee/employeelist.jsp" />
</liferay-portlet:renderURL>
<portlet:renderURL var="addNewEmployee">
<portlet:param name="mvcPath" value="/html/employee/add_employee.jsp"/></portlet:renderURL>
<html>
<head>
<title>employeelist</title>
<style type="text/css">
.aui input[type="text"],.aui select{
border-radius: 4px;
}
.aui label {
color: #555;
font-size: 14px;
font-weight: 200;
font-family: sans-serif;
font: small-caption;
}
</style>
</head>
<body>
<aui:form action="<%=employeeSearchURL %>" method="get" name="proposalForm">
<div class="row-fluid">
		<div class="span3">
			<aui:input name="firstName" label="01_emp-name" inlineLabel="left"></aui:input>
			
		</div>
		<div class="span3">
			<aui:input name="employeeNo" label="01_id"></aui:input>
		</div>
		<div class="span6">
			<div class="span8">
				<%-- <aui:input name="" label="Employment Status"></aui:input> --%>
	  
	   <aui:select name="employmentstatus" label="01_emp-status">
	     <aui:option value="" selected="true">--select--</aui:option>
                        <%
                        List<EmploymentStatus> empstatuslist = EmploymentStatusLocalServiceUtil.getEmploymentStatuses(-1, -1);
                                    Iterator empstatus = empstatuslist.iterator();
                                    while (empstatus.hasNext()) {
                                        EmploymentStatus empstatus2 = (EmploymentStatus) empstatus.next();
                        %>
                        <aui:option value="<%=empstatus2.getEmploymentstatus()%>"><%=empstatus2.getEmploymentstatus()%></aui:option>
                        <%
                            }
                        %>
                    </aui:select>
				
				
			</div>
			<div class="span4">
				
			</div>
		</div>
		 <div class="row-fluid">
			<div class="span3">
				<aui:input name="supervisorname" label="01_sup-name"
					  id="supervisorname"/>
			</div>
			<div class="span3">
				
				 <aui:select name="jobtitle001" label="01_jobtitle">
				 <aui:option value="" selected="true">--select--</aui:option>
                        <%
                        List<JobTitle> jobtitlelist = JobTitleLocalServiceUtil.getJobTitles(-1,-1);
                                    Iterator jobtitle = jobtitlelist.iterator();
                                    while (jobtitle.hasNext()) {
                                        JobTitle jobtitle2 = (JobTitle) jobtitle.next();
                        %>
                        <aui:option value="<%=jobtitle2.getTitle()%>"><%=jobtitle2.getTitle()%></aui:option>
                        <%
                            }
                        %>
                    </aui:select>
				
				
			</div>
			<div class="span6">
				
			 <aui:select name="subunit" label="01_sub-unit">
			 <aui:option value="" selected="true">--select--</aui:option>
                        <%
                        List<SubUnit> subunitlist =  SubUnitLocalServiceUtil.getSubUnits(-1, -1);
                                    Iterator subunit = subunitlist.iterator();
                                    while (subunit.hasNext()) {
                                        SubUnit subunit2 = (SubUnit) subunit.next();
                        %>
                        <aui:option value="<%=subunit2.getName()%>"><%=subunit2.getName()%></aui:option>
                        <%
                            }
                        %>
                    </aui:select>	
				
			</div>
		</div>
	</div>
	<aui:button-row>

		<aui:button type="submit" id="toggleColor" value="search"
			cssClass="btn btn-success" />
		<aui:button type="reset" id=""
			value="reset" cssClass="btn btn-danger">
		</aui:button>
	</aui:button-row>
	<div class="row-fluid">
	<div class="span3">
	<aui:button cssClass="button btn-success" name="addNewEmp" id="addNewEmp" value="add"
	onClick="<%=addNewEmployee %>"></aui:button>
	</div>
	<div class="span3"></div>
	<div class="span6"></div>
</div>
	
<liferay-portlet:renderURLParams varImpl="employeeSearchURL" />
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="mvcPath" value="/html/emplist/employeelist.jsp" />
	</liferay-portlet:renderURL>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<EmpDetails> searchContainer;
%>

<liferay-ui:search-container delta="5" displayTerms="<%= new DisplayTerms(renderRequest) %>" emptyResultsMessage="no-records-available-for-employee"  deltaConfigurable="true"  iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
		<%
		DisplayTerms displayTerms =searchContainer.getDisplayTerms();
		String empname = ParamUtil.getString(renderRequest, "firstName");
		String empid = ParamUtil.getString(renderRequest, "employeeNo");
		String empstatus = ParamUtil.getString(renderRequest, "employmentstatus");
		String supervisorname = ParamUtil.getString(renderRequest, "supervisorname");
		String jobtitle = ParamUtil.getString(renderRequest, "jobtitle");
		String subunit = ParamUtil.getString(renderRequest, "subunit");
		System.out.println("before results....parameters.." +empname+ ", "+empid+", "+empstatus+", "+supervisorname+", "+jobtitle+", " +subunit);
	   
		searchContainer.setResults(EmpDetailsLocalServiceUtil.findEmpDetails(empname, empid, empstatus, supervisorname, jobtitle, subunit, searchContainer.getStart(), searchContainer.getEnd()));
	     total = results.size(); 
	  	pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row  className="EmpDetails" modelVar="EmpDetails"  rowVar="curRow" escapedModel="<%= true %>">
	    <liferay-ui:search-container-column-text orderable="true" name="01_id"
	     property="employeeNo" />
	    <liferay-ui:search-container-column-text orderable="true" name="01_firstName"
	    property="firstName"/>
	    <liferay-ui:search-container-column-text orderable="true" name="01_lastName"
	    property="lastName"/>
	    <liferay-ui:search-container-column-text orderable="true" name="01_jobtitle"
	     property="title"/>
	    <liferay-ui:search-container-column-text orderable="true" name="01_sub-unit" />
	    <liferay-ui:search-container-column-text orderable="true" name="01_sup-name"/>
	    <liferay-ui:search-container-column-text orderable="true" name="01_emp-status" 
	    property="employmentstatus"/>
	    <liferay-ui:search-container-column-jsp name="edit"
		path="/html/employee/editClick.jsp" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</aui:form>
</body>
</html>
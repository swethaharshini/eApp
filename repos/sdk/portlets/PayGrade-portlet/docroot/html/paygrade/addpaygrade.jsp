<%@page import="com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.PayGrade"%>
<%@ include file="/html/paygrade/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayGrade</title>
<portlet:actionURL var="savepaygrade" name="savePayGrade">
</portlet:actionURL>
<portlet:renderURL var="paygradelist">
	<portlet:param name="mvcPath" value="/html/paygrade/paygradelist.jsp" />
</portlet:renderURL>
<style type="text/css">
em {
	color: red;
}

</style>

</head>
<body>
<div class="form-horizontal">
<aui:form name="myForm" action="<%=savepaygrade.toString()%>">
		<aui:input name="paygradeId" type="hidden" id="paygradeId" />
		<div class="control-group">
			<label><b>Name<em>*</em></b></label>
		
		<div class="controls">		
		 <input name="<portlet:namespace/>paygradeName" id="paygrade" type="text" required = "required">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
		<aui:button type="submit" value="Submit" />
		<aui:button  type="reset" value="Cancel" href="<%=paygradelist.toString()%>" id ="cancel"/>
		</div></div>	
	</aui:form>
	</div>
</body><br/><br/>


</html>
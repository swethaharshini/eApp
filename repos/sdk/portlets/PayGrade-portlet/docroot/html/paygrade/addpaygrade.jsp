<%@ include file="/html/paygrade/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayGrade</title>
<portlet:actionURL var="savepaygrade" name="savePayGrade">
</portlet:actionURL>
<portlet:renderURL var="paygradelist">
	<portlet:param name="mvcPath" value="/html/paygrade/paygradelist.jsp" />
</portlet:renderURL>
<aui:script>

AUI().ready('event', 'node','transition',function(A){
A.one('#paygradeName').focus();
 
  setTimeout(function(){
    A.one('#addpaygradeNameMessage').transition('fadeOut');
    A.one('#addpaygradeNameMessage').hide();
},2000)
 });
</aui:script>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"paygradeName-empty-error")){%>
<p id="addpaygradeNameMessage" class="alert alert-error" ><liferay-ui:message key="Please Enter PayGradeName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"paygradeName-duplicate-error")){
%>
<p id="addpaygradeNameMessage" class="alert alert-error" ><liferay-ui:message key="PayGradeName already Exits"/></p>
<%} 
%>
<div class="clearfix">
	<div class="panel">
		<div class="panel-heading">
			<h4>Add</h4>
		</div>
		<div class="panel-body">
			<aui:form name="myForm" action="<%=savepaygrade.toString()%>">
				<div class="form-horizontal clearfix">
					<aui:input name="paygradeId" type="hidden" id="paygradeId" />
					<div class="control-group">
					<label class="control-label"><b>Name<em>*</em></b></label>
					<div class="controls">
				 	<input name="<portlet:namespace/>paygradeName" id="paygradeName" type="text"/>
				 	</div>
				 	</div>
					<div class="controls">
						<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
						<a class="btn btn-danger" href="<%=paygradelist.toString()%>" id ="cancel"><i class="icon-remove"></i> Cancel</a>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>

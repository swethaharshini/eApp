<%@page import="com.rknowsys.eapp.hrm.service.LeaveCarryForwardPolicyLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.LeaveCarryForwardPolicy"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@ include file="/html/leavetype/init.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carry Forward Rules</title>
<portlet:actionURL var="saveLeaveCarryForwardPolicy" name="saveLeaveCarryForwardPolicy">
</portlet:actionURL>

<aui:script>
AUI().ready('event', 'node', function(A){
  //alert("In ready! ");
  A.one('#maxCarryForwardLimitDiv').show();
  //alert("On ready done!");
 });

AUI().use(
  'aui-node',
  function(Y) {
    var node = Y.one('#<portlet:namespace/>isMaxCarryForwardLimitApplicable');
    //alert("node = " + node);
    node.on(
      'change',
      function() {
          //alert('in on click');
          var selectedValue = Y.one('#<portlet:namespace/>isMaxCarryForwardLimitApplicable').get('value');
          //alert("selectedValue = " + selectedValue);
      if (selectedValue == 'true'){
          //alert('in if');
          Y.one('#maxCarryForwardLimitDiv').show();
      }else{
          //alert('if else!');
          Y.one('#maxCarryForwardLimitDiv').hide();
      }
                     
      }
    );
  }
);

</aui:script>

</head>

<body>

 <jsp:useBean id="editLeaveCarryForwardPolicy" type="com.rknowsys.eapp.ui.LeaveCarryForwardPolicy" scope="request" />
 
 <div id="editLeaveCarryForwardPolicyForm">
 <aui:form name="myForm" action="<%=saveLeaveCarryForwardPolicy.toString()%>">
		<aui:input name="leaveCarryForwardPolicyId" type="hidden" value="<%=editLeaveCarryForwardPolicy.getLeaveCarryForwardPolicyId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Expiry After</label>
				
			</div>
			<div class="span5">
				<aui:input name="expiryDuration" type="text" label="" value="<%=editLeaveCarryForwardPolicy.getExpiryDuration() %>"/>
			</div>
			<div class="span3">		
		  		<aui:select type="select" name="expiryDurationUOM" label="" >
		    		<aui:option value="-1">--Select--</aui:option>
		          <%    
		           List<IdNamePair> idNameList = editLeaveCarryForwardPolicy.getExpiryDurationUOMs(); 
		    		String storedId=editLeaveCarryForwardPolicy.getExpiryDurationUOM();
		           for (IdNamePair idName:idNameList) { %>
		             <aui:option selected="<%=idName.getId().equals(storedId)%>"
		                        value="<%=idName.getId() %>">
		                 <%=idName.getName()%>
		             </aui:option>
		             <% } %>
		
		   		</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Maximum number of leave to carry forward</label>
			</div>
			<div class="span5">
		  		<aui:select type="select" name="isMaxCarryForwardLimitApplicable" label="" >
		    		<aui:option name="isMaxCarryForwardLimitApplicable" value="true"  selected="<%=\"true\".equals(editLeaveCarryForwardPolicy.getIsMaxCarryForwardLimitApplicable())%>" >Specify the maximum number</aui:option>
		    		<aui:option name="isMaxCarryForwardLimitApplicable" value="false"  selected="<%=\"false\".equals(editLeaveCarryForwardPolicy.getIsMaxCarryForwardLimitApplicable())%>" >All remaining days</aui:option>
		   		</aui:select>
			</div>
			<div id="maxCarryForwardLimitDiv">
				<div class="span3">		
			  		<aui:input name="maxCarryForwardLimit" type="text" label="" value="<%=editLeaveCarryForwardPolicy.getMaxCarryForwardLimit() %>"/>
				</div>
			</div>
		</div>

		<div class="span12">
			<aui:button type="submit" id="save" value="Save" />
		</div>

</aui:form>
</div>

 </body>

</html>
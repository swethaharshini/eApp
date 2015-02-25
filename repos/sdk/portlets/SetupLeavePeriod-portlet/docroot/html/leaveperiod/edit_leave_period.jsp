<%@page import="com.rknowsys.eapp.hrm.service.LeavePeriodLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.LeavePeriod"%>
<%@page import="com.rknowsys.eapp.hrm.model.Employee"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Calendar"%>

<%@ include file="/html/leaveperiod/init.jsp"%>
<title>Leave Period</title>
<portlet:actionURL var="saveLeavePeriod" name="saveLeavePeriod">
</portlet:actionURL>

 
<portlet:renderURL var="initialView">
	
 </portlet:renderURL>
 <liferay-ui:success key="saved" message="Saved Successfully" />
  <liferay-ui:success key="updated" message="Updated Successfully" />
<% 
  LeavePeriod editLeavePeriod = (LeavePeriod)portletSession.getAttribute("editLeavePeriod");

%>
<aui:script>
AUI().ready('event', 'node',function(A){
  
  
   var year = <%=Calendar.YEAR%>;
  
   var m = <%=editLeavePeriod.getStartMonth()%>;
  
   var date = <%=editLeavePeriod.getStartDate()%>;
  
   var days=/8|3|5|10/.test(m)?30:m==1?(!(year%4)&&year%100)||!(year%400)?29:28:31;
   
   var d=A.one('#<portlet:namespace/>startDate');
   
   for(var start=1;start<=days;start++)
   {
    if(start == date){
    
     d.append("<option value='" + start + "' selected='selected'>" +  start  + "</option>");
    
    }else{ 
    d.append("<option value='" + start + "'>" +  start  + "</option>");
   }
   }
    

});



AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editLeavePeriodReadOnly').hide();
         A.one('#editLeavePeriodForm').show();
                     
      }
    );
  }
);


var A=new AUI();
function getDaysInMonth(month, year) {
   var days=/8|3|5|10/.test(month)?30:month==1?(!(year%4)&&year%100)||!(year%400)?29:28:31;
   var targetElementDays=A.one('#<portlet:namespace/>startDate');
   targetElementDays.empty();
   for(var start=1;start<=days;start++)
   {
    targetElementDays.append("<option value='" + start + "'>" +  start  + "</option>");
   }
   
}


</aui:script>



 
<div id="editLeavePeriodForm" class="form-horizontal clearfix">
 	<aui:form name="myForm" action="<%=saveLeavePeriod.toString()%>">
 	<aui:input name="leavePeriodId" type="hidden" value="<%=editLeavePeriod.getLeavePeriodId() %>"/>
 	
 				<aui:select type="select" name="startMonth" label="Start Month" onChange='<%="getDaysInMonth(this.value,\'"+Calendar.YEAR+"\');"%>'>
		<aui:option value="-1">--Select--</aui:option>
		<% 			
		   List<IdNamePair> idNameList = editLeavePeriod.getMonths();
			String storedId=String.valueOf(editLeavePeriod.getStartMonth());

		   for (IdNamePair idName:idNameList) { %>
			<aui:option selected="<%=idName.getId().equals(storedId)%>"
			value="<%=idName.getId() %>">
			<%=idName.getName()%>
			</aui:option>
		<% } %>
		</aui:select>
				<aui:select name="startDate" id="startDate" type="text"
					label="Start Date" value="" >
					
				</aui:select>
 
			<aui:input name="endDate" type="text" label="End Date" disabled="true" value="<%=editLeavePeriod.getEndDate() %>"/>
			<aui:input name="currentLeavePeriod" type="text" label="Current Leave Period" disabled="true" value="<%=editLeavePeriod.getCurrentLeavePeriod()%>"/>	
		<div class="control-group">
			<div class="controls">
			<aui:button type="submit" id="save" value="Submit" />
			</div>
		</div>
	</aui:form>
</div>
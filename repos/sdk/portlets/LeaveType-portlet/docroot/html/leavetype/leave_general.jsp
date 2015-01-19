<%@ include file="/html/leavetype/init.jsp" %>
<portlet:actionURL var="saveLeaveGeneral" name="saveOrUpdateLeaveGeneral">
</portlet:actionURL>
<portlet:renderURL var="initialView">
</portlet:renderURL>
<portlet:resourceURL var="resourceURL" id="resourceURL"/>

 <%  Map leaveTypeAndGeneral=(Map)request.getSession(false).getAttribute(
			"leaveInfo");
 LeaveGeneral editLeaveGeneral=(LeaveGeneral)leaveTypeAndGeneral.get("editLeaveGeneral");
 System.out.println("edit leave rule is "+editLeaveGeneral);
    int startMonth,startDayOfMonth=0;String duration="";
    boolean ifEmployeesCanApply,ifAdminCanAssign,ifAdminCanManageEntitlements,ifLeaveAccruable,
    ifCarryForwardable,showProjectBalance,enableAttachment,isAttachmentMandatory=false;int leavePeriodTypeID=0;
    long leaveGeneralId=0l;long leaveTypeId=(Long)leaveTypeAndGeneral.get("leaveTypeId");
    if(editLeaveGeneral!=null)
    {	
    	leavePeriodTypeID=editLeaveGeneral.getLeavePeriodTypeId();
    	startMonth=editLeaveGeneral.getStartMonth();
    	startDayOfMonth=editLeaveGeneral.getStartDayOfMonth();
    	duration=editLeaveGeneral.getDuration();
    	ifEmployeesCanApply=editLeaveGeneral.getIfEmployeesCanApply();
    	ifAdminCanAssign=editLeaveGeneral.getIfAdminCanAssign();
    	ifCarryForwardable=editLeaveGeneral.getIfCarryForwardable();
    	ifLeaveAccruable=editLeaveGeneral.getIfLeaveAccruable();
    	ifAdminCanManageEntitlements=editLeaveGeneral.getIfAdminCanManageEntitlements();
    	showProjectBalance=editLeaveGeneral.getShowProjectBalance();
    	enableAttachment=editLeaveGeneral.getEnableAttachment();
    	isAttachmentMandatory=editLeaveGeneral.getIsAttachmentMandatory();
    }
    else
    {   leavePeriodTypeID=0;
    	startMonth=0;
    	ifEmployeesCanApply=false;ifAdminCanAssign=false;ifAdminCanManageEntitlements=false;ifLeaveAccruable=false;
        ifCarryForwardable=false;showProjectBalance=false;enableAttachment=false;isAttachmentMandatory=false;
    	
    }
    %>


<aui:script use="">
AUI().ready('event', 'node', function(A){
var selectedValue ="<%=leavePeriodTypeID %>";
   // alert("selectedValue = " + selectedValue);
    switch (selectedValue) { 
                        
          case '0': //Statements executed when the result of expression matches value1 [break;]
                       //alert("case 0"); 
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').hide();
                       A.one('#customLeavePeriodDiv').hide();
                       break;
                     
          case '1': //Statements executed the result of expression matches value2 [break;]
                       //alert("case 1");
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').show();
                       A.one('#customLeavePeriodDiv').hide();
		  			   break;                  
		           
          case '2': //Statements executed when the result of expression matches valueN [break;]
                       //alert("case 2");
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').hide();
                       A.one('#customLeavePeriodDiv').show();
                       break;
                       
          default: //Statements executed when none of the values match the value of the expression [break;] }					    
	                    //alert("case default");
	                    A.one('#defaultDiv').show();
                        A.one('#durationDiv').hide();
                        A.one('#customLeavePeriodDiv').hide();
                        break;
                       
	}
  //alert("On ready done!");
 });

AUI().use(
  'aui-node',
  function(A) {
    var node =A.one('#<portlet:namespace/>leavePeriodTypeId');
    node.on(
      'change',
      function() {
         //alert("In on change!");
                         var selectedValue = A.one('#<portlet:namespace/>leavePeriodTypeId').get('value');
    //alert("selectedValue = " + selectedValue);
    switch (selectedValue) { 
                        
          case '0': //Statements executed when the result of expression matches value1 [break;]
                       //alert("case 0"); 
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').hide();
                       A.one('#customLeavePeriodDiv').hide();
                       break;
                     
          case '1': //Statements executed the result of expression matches value2 [break;]
                       //alert("case 1");
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').show();
                       A.one('#customLeavePeriodDiv').hide();
		  			   break;                  
		           
          case '2': //Statements executed when the result of expression matches valueN [break;]
                       //alert("case 2");
                       A.one('#defaultDiv').show();
                       A.one('#durationDiv').hide();
                       A.one('#customLeavePeriodDiv').show();
                       break;
                       
          default: //Statements executed when none of the values match the value of the expression [break;] }					    
	                    //alert("case default");
	                    A.one('#defaultDiv').show();
                        A.one('#durationDiv').hide();
                        A.one('#customLeavePeriodDiv').hide();
                        break;
                       
	}
                     
      }
    );
  }
);
var A=new AUI();
function getDaysInMonth(month, year) {
   var days=/8|3|5|10/.test(month)?30:month==1?(!(year%4)&&year%100)||!(year%400)?29:28:31;
   var targetElementDays=A.one('#<portlet:namespace/>startDayOfMonth');
   targetElementDays.empty();
   for(var start=1;start<=days;start++)
   {
    targetElementDays.append("<option value='" + start + "'>" +  start  + "</option>");
   }
   return /8|3|5|10/.test(month)?30:month==1?(!(year%4)&&year%100)||!(year%400)?29:28:31;
}


</aui:script>
<div class="form-horizontal">
	<aui:form name="myForm" action="<%=saveLeaveGeneral.toString()%>">
	<div class="panel">
		<div class="panel-heading">
			<h3>General</h3>
		</div>
		<div class="panel-body">		
			<% if(editLeaveGeneral==null){%>
			<aui:input name="leaveGeneralId" type="hidden"
				value="" />
			<% }else{%>
			<aui:input name="leaveGeneralId" type="hidden"
				value="<%=editLeaveGeneral.getLeaveGeneralId() %>" />
			<% }%>	
			<aui:input name="leaveTypeId" type="hidden" value="<%=leaveTypeId %>"></aui:input>
			<aui:select type="select" name="leavePeriodTypeId"
				label="Leave Period">
			<aui:option value="0">Default
			</aui:option>
			<aui:option selected="<%=leavePeriodTypeID==1 %>" value="1">Hire Date Base Leave Period</aui:option>
			<aui:option selected="<%=leavePeriodTypeID==2 %>" value="2">Custom Leave Period</aui:option>
			</aui:select>
			<div id="customLeavePeriodDiv">
				<aui:select type="select" name="startMonth" label="Start Month"
				onChange='<%="getDaysInMonth(this.value,\'"+Calendar.YEAR+"\');"%>'>
				<aui:option value="-1" selected="true" >--Select--</aui:option>
				<%String[] monthArray=DateFormatSymbols.getInstance().getMonths();
				for(int i=0;i<monthArray.length;i++)
				{
					%>
				<aui:option selected="<%=i==startMonth %>" value="<%=i %>"><%=monthArray[i] %></aui:option>
				<%
				}
				%>
				</aui:select>
				<aui:select name="startDayOfMonth" id="startDayOfMonth" type="text"
					label="Start Day Of Month" value="" >
				<aui:option selected="true" value='<%=startDayOfMonth %>'></aui:option>
				</aui:select>
			</div>
			<div id="durationDiv">
				<aui:select type="select" name="duration" label="Duration">
				<aui:option value="-1" selected='<%=duration!="" %>'>--Select--</aui:option>
				<aui:option selected='<%="1 Year".equalsIgnoreCase(duration)%>'
				value="1 Year">
				1 Year
				</aui:option>
				<aui:option selected='<%="2 Year".equalsIgnoreCase(duration)%>'
				value="2 Year">
				2 Year
				</aui:option>
				<aui:option selected='<%="3 Year".equalsIgnoreCase(duration)%>'
				value="3 Year">
				3 Year
				</aui:option>
				<aui:option selected='<%="4 Year".equalsIgnoreCase(duration)%>'
				value="4 Year">
				4 Year
				</aui:option>
				<aui:option selected='<%="5 Year".equalsIgnoreCase(duration)%>'
				value="5 Year">
				5 Year
				</aui:option>
				</aui:select>
			</div>
			<div id="defaultDiv">
				<aui:input name="ifEmployeesCanApply" type="checkbox"
				label="Employees can apply for this leave type"
				checked="<%=ifEmployeesCanApply%>" />
				<aui:input name="ifAdminCanAssign" type="checkbox"
					label="Admin or supervisor can assign leave to employees"
					checked="<%=ifAdminCanAssign%>" />
				<aui:input name="ifAdminCanManageEntitlements" type="checkbox"
					label="Admin can add and adjust leave entitlements"
					checked="<%=ifAdminCanManageEntitlements%>" />
				
				<aui:input name="ifLeaveAccruable" type="checkbox"
					label="Enable leave accrue" checked="<%=ifLeaveAccruable%>" />
				<aui:input name="ifCarryForwardable" type="checkbox"
					label="Enable leave carried forward"
					checked="<%=ifCarryForwardable%>" />
				<aui:input name="showProjectBalance" type="checkbox"
					label="Show projected balance when applying/assigning"
					checked="<%=showProjectBalance%>" />
				<aui:input name="isAttachmentEnabled" type="checkbox"
					label="Enable attachment"
					checked="<%=enableAttachment%>" />
				<aui:input name="isAttachmentMandatory" type="checkbox"
					label="Attachment is mandatory"
					checked="<%=isAttachmentMandatory%>" />
			</div>
			<div class="control-group">
				<div class="controls">
					<aui:button type="submit" id="save" value="save" />
				</div>
			</div>
		</div>
	</div>
	</aui:form>
</div>
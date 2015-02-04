<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="/html/workweek/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<portlet:actionURL var="saveWorkWeek" name="saveWorkWeek">
</portlet:actionURL>

<portlet:renderURL var="initialView">
	<%-- 	<portlet:param name="mvcPath" value="/html/workweek/edit_workweek.jsp" /> --%>
 </portlet:renderURL>
<portlet:resourceURL var="resourceURL" id="resourceURL"/>
<jsp:useBean id="editWorkWeek" class="com.rknowsys.eapp.ui.WorkWeek" scope="request" />
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editWorkWeekReadOnly').hide();
         A.one('#editWorkWeekFormDiv').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editWorkWeekFormDiv').hide();
 });
 

 function callServeResource(){
    AUI().use('aui-io-request', function(A){
        A.io.request('<%=resourceURL.toString()%>', {
               method: 'post',
               dataType: 'json',
               form: {
                   id: '<portlet:namespace />editWorkWeekForm'
               },
               on: {
                    success: function() {
						A.one('#<portlet:namespace />mondayWorkScheduleEdit > option[value="' + this.get('responseData').monday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />tuesdayWorkScheduleEdit > option[value="' + this.get('responseData').tuesday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />wednesdayWorkScheduleEdit > option[value="' + this.get('responseData').wednesday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />thursdayWorkScheduleEdit > option[value="' + this.get('responseData').thursday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />fridayWorkScheduleEdit > option[value="' + this.get('responseData').friday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />saturdayWorkScheduleEdit > option[value="' + this.get('responseData').saturday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />sundayWorkScheduleEdit > option[value="' + this.get('responseData').sunday + '"]').set('selected', 'selected');
					}
				}
			});
		});
    }

</aui:script>
 
 <div id="editWorkWeekReadOnly" class="form-horizontal">
		<aui:input name="workWeekId" type="hidden" value="<%=editWorkWeek.getWorkWeekId() %>"/>

		
		     <aui:select type="select" label="Country" name="nationalityId" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getNationalities(); 
				String storedId=editWorkWeek.getNationalityId();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId()%>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>

		     <aui:select type="select" label="Monday" name="mondayWorkSchedule" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getMondayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>


		     <aui:select type="select"  label="Tuesday" name="tuesdayWorkSchedule" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getTuesdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>


		     <aui:select type="select" label="Wednesday" name="wednesdayWorkSchedule" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getWednesdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>

		     <aui:select type="select" label="Thursday" name="thursdayWorkSchedule"  disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getThursdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>

		     <aui:select type="select" label="Friday" name="fridayWorkSchedule" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules();
				String storedId=editWorkWeek.getFridayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>

		     <aui:select type="select" label="Saturday" name="saturdayWorkSchedule" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getSaturdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>

		     <aui:select type="select" label="Sunday" name="sundayWorkSchedule" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getSundayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			<div class="control-group">
				<div class="controls">
					<aui:button type="button" id="edit" value="Edit" />
				</div>
			</div>
</div>
<div id="editWorkWeekFormDiv"  class="form-horizontal">
  <aui:form name="editWorkWeekForm" action="<%=saveWorkWeek.toString()%>">
		<aui:input name="workWeekId" type="hidden" value="<%=editWorkWeek.getWorkWeekId() %>"/>
		     <aui:select type="select" label="Country" name="nationalityId" onchange="callServeResource()">
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getNationalities(); 
				String storedId=editWorkWeek.getNationalityId();
	         	for (IdNamePair idName:idNameList) { %>
	         	<% System.out.println("idName.getId() = " + idName.getId()); %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
	
		     <aui:select type="select" label="Monday" name="mondayWorkScheduleEdit">
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getMondayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>


		     <aui:select type="select" label="Tuesday" name="tuesdayWorkScheduleEdit">
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getTuesdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>

		     <aui:select type="select" label="Wednesday" name="wednesdayWorkScheduleEdit">
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getWednesdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>

		     <aui:select type="select" label="Thursday" name="thursdayWorkScheduleEdit">
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getThursdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>


		     <aui:select type="select" label="Friday" name="fridayWorkScheduleEdit" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules();
				String storedId=editWorkWeek.getFridayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>

		     <aui:select type="select" label="Saturday" name="saturdayWorkScheduleEdit">
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getSaturdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>


		     <aui:select type="select" label="Sunday" name="sundayWorkScheduleEdit">
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getSundayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			<div class="control-group">
				<div class="controls">
					<aui:button type="submit" id="save" value="Submit" />
				</div>
			</div>

	</aui:form>
</div>

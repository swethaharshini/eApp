<%@page import="com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.Holiday"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@ include file="/html/holiday/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Holiday</title>
<portlet:actionURL var="saveHoliday" name="saveHoliday">
</portlet:actionURL>

<%-- 
<portlet:resourceURL var="deleteHoliday" id="deleteHoliday"/>
 --%>
 <portlet:resourceURL var="resourceURL" id="resourceURL"/>
<portlet:renderURL var="initialView">
	<%-- 	<portlet:param name="mvcPath" value="/html/holiday/add_edit_holiday.jsp" /> --%>
 </portlet:renderURL>


 <style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
</style>
<jsp:useBean id="editHoliday" type="com.rknowsys.eapp.ui.Holiday" scope="request" />

<aui:script>
AUI().ready('event', 'node', function(A){
//alert("ready!");
  <%
	if ((editHoliday != null)
				&& (editHoliday.getCheckedLocationsAsJSArray() != null)) {
%>
	<%="var checkedLocations = "
							+ editHoliday.getCheckedLocationsAsJSArray()
							+ ";"%>
  //alert("checkedLocations[] = " + checkedLocations);
  for (var i = 0; i < checkedLocations.length; i++) {
    //alert(checkedLocations[i]);
    A.all('input[type=checkbox]').each(function(object) {
      //alert("in fnc val = " + object.get("value"));
      if (object.get("value") == checkedLocations[i]){
      //alert("true");
      object.attr('checked', true);
      }
        });
}
  
  <%
 	}
 %>
  
  //A.one('#<portlet:namespace />location').checked = true;
 });


AUI().use(
  'aui-datepicker',
  function(Y) {
 //alert("in call datepicker!")
    new Y.DatePicker(
      {
        trigger: '#<portlet:namespace />holidayDate',
        mask: '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
            console.log(event.newSelection);
          }
        }
      }
    );
  }
);

 function callServeResource(){
    AUI().use('aui-io-request', function(A){
        A.io.request('<%=resourceURL.toString()%>', {
               method: 'post',
               dataType: 'json',
               form: {
                   id: '<portlet:namespace />myForm'
               },
               on: {
                    success: function() {
						var response = this.get('responseData').allLocations;
			            var arr = A.JSON.parse(this.get('responseData').allLocations);
			            i =0;
			            content = '';
						arr.forEach(function() {
			                content = content + '<input id=\'<portlet:namespace/>location\' name=\'<portlet:namespace/>location\' type=\'checkbox\' value=\''+ arr[i].id+ '\' > ' + arr[i].name + '</input><br/>';
			                i = i + 1;
						});
						//alert(content);
						//A.one('#<portlet:namespace/>locationsDivContent').val(content);
					A.one('#locationsDiv').html(content);
					}
				}
			});
		});
    }

</aui:script>
</head>

<body>
 <div>&nbsp;</div>
 <div id="editHolidayForm">
 <aui:form name="myForm" action="<%=saveHoliday.toString()%>">
		<aui:input name="holidayId" type="hidden" value="<%=editHoliday.getHolidayId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Name</label>
			</div>
			<div class="span3">
		 		<aui:input name="holidayName" type="text" label="" value="<%=editHoliday.getHolidayName() %>">
		 			<aui:validator name="required"></aui:validator>
		 		</aui:input>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Date</label>
			</div>
			<div class="span3">	
		 		<aui:input name="holidayDate" type="text" label="" value="<%=editHoliday.getHolidayDate() %>">
		 			<aui:validator name="required"></aui:validator>
		 		</aui:input>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Repeats Annually</label>
			</div>
			<div class="span3">
				 <aui:input name="isAnnual" type="checkbox" label="" checked="<%=\"Yes\".equalsIgnoreCase(editHoliday.getIsAnnual()) %>" />
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Full Day/Half Day</label>
			</div>
			<div class="span3">		
		  		<aui:select name="isFullDay" label="" >
		    		<aui:option value="true"  selected="<%=\"Full Day\".equals(editHoliday.getIsFullDay())%>" >Full Day</aui:option>
		    		<aui:option value="false"  selected="<%=\"Half Day\".equals(editHoliday.getIsFullDay())%>" >Half Day</aui:option>
		   		</aui:select>

			</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Country</label>
			</div>
			<div class="span3">		
		  		<aui:select name="nationalityId" label="" onchange="callServeResource()">
		    		<aui:option value="-1">--Select--</aui:option>
		          <% 
		          System.out.println("editHoliday = " + editHoliday);
		           List<IdNamePair> idNameList = editHoliday.getOrgCountries(); 
		    		String storedId=editHoliday.getNationalityId();
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
				<label>Locations</label>
		</div>
		<div class="span3" id="locationsDiv">
		<div class="span8">
		<p>
		<% 
		           List<IdNamePair> idNameList = editHoliday.getOrgLocations(); 
		           for (IdNamePair idName:idNameList) { %>
		             <input id="<portlet:namespace/>location" name="<portlet:namespace/>location" type="checkbox" value="<%=idName.getId() %>"><%=idName.getName()%></input>
		             <br/>
		             <% } %>
		</div></div>
</div>
		<div class="span12">
			<aui:button type="submit" id="save" value="save" />
		</div>

</aui:form>
</div>

 </body>

</html>
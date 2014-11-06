<%@page import="com.rknowsys.eapp.hrm.service.persistence.HolidayFinderUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.rknowsys.eapp.hrm.service.HolidayLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.SetupHolidaysAction"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ include file="/html/holiday/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Holiday List</title>
<portlet:defineObjects/>
<liferay-portlet:renderURL varImpl="holidaysSearchURL">
<portlet:param name="mvcPath" value="/html/holiday/list_holidays.jsp" />
</liferay-portlet:renderURL>
<portlet:actionURL var="addEditHoliday" name="addEditHoliday">
</portlet:actionURL>
<portlet:actionURL var="searchHolidays" name="searchHolidays">
</portlet:actionURL>
<portlet:resourceURL var="deleteHoliday" id="deleteHolidays" />
<portlet:resourceURL var="resourceURL" id="resourceURL"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/holiday/list_holidays.jsp" />
</portlet:renderURL>

<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
</style>
<%-- <jsp:useBean id="holidaySearch" type="com.rknowsys.eapp.ui.Holiday" scope="application" /> --%>
    <% com.rknowsys.eapp.ui.Holiday holidaySearch =  (Holiday)portletSession.getAttribute("holidaySearch", javax.portlet.PortletSession.APPLICATION_SCOPE);
    %>

<aui:script>

AUI().ready('event', 'node', function(A){
  <%
	if ((holidaySearch != null)
				&& (holidaySearch.getCheckedLocationsAsJSArray() != null)) {
%>
	<%="var checkedLocations = "
							+ holidaySearch.getCheckedLocationsAsJSArray()
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
  'aui-node',
  function(A) {
    var node = A.one('#search');
    node.on(
      'click',
      function() {
         A.one('#<portlet:namespace/>locationsDivContent').val(A.one('#locationsDiv').html());
                     
      }
    );
  }
);

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delete');
    node.on(
      'click',
      function() {
     var locIdArray = [];
      A.all('input[type=checkbox]:checked').each(function(object) {
      locIdArray.push(object.get("value"));
        });
       if(locIdArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected Holidays?");
		  if(d){
		   var url = '<%=deleteHoliday%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />holidayIds: locIdArray,  
                 },
          on: {
               success: function() { 
                   alert('Deleted records successfully.');
                   window.location='<%=listview%>';
              },
               failure: function() {
                  
                 }
                }
                 }
                );
		  																		
		  console.log(locIdArray);
	  
      return true;
  }
  else
    return false;
}
      }
    );
  }
);

AUI().use(
  'aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: '#<portlet:namespace />holidayFromDate',
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

AUI().use(
  'aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: '#<portlet:namespace />holidayToDate',
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

<aui:form action="<%=searchHolidays.toString() %>" method="post" name="myForm">

		<div class="span12">
			<div class="span4">
				<label>From Date</label>
			</div>
			<div class="span8">	
				<aui:input name="holidayFromDate" label="" value="<%=holidaySearch.getSearchFromDate() %>"></aui:input>
			</div>
		</div>

		<div class="span12">
			<div class="span4">
				<label>To Date</label>
			</div>
			<div class="span8">	
				<aui:input name="holidayToDate" label="" value="<%=holidaySearch.getSearchToDate() %>"></aui:input>
			</div>
		</div>


		<div class="span12">
			<div class="span4">
				<label>Country *</label>
			</div>
			<div class="span8">	
			     <aui:select type="select" name="nationalityId" label="" onchange="callServeResource()">
					<aui:option value="-1" selected="true">--Select--</aui:option>
		        <%    
		           List<IdNamePair> idNameList = holidaySearch.getOrgCountries(); 
		    		String storedId=holidaySearch.getNationalityId();
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
			<div class="span4">
				<label>Locations *</label>
			</div>
			<div class="span8" id="locationsDiv">	
			<%=(holidaySearch.getLocationsDivContent() == null) ? "" : holidaySearch.getLocationsDivContent() %>
<%-- 	 			<aui:input name="locationId1" type="checkbox" label="" checked="false" />
	 			<aui:input name="locationId2" type="checkbox" label="" checked="true" /> --%>
	 			
			</div>
			<aui:input name="locationsDivContent" type="hidden"></aui:input>
		</div>

	<div>

	<aui:button-row>
			<aui:button type="submit" id="search" value="Search" />
	</aui:button-row>
</div>
</aui:form>

	<div id="adddelete" class="span12">
		<a href="<%=addEditHoliday.toString() %>" id="add">Add</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" id="delete">Delete</a>

	</div><div>&nbsp;</div>


<%
ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//PortletURL iteratorURL = PortletURLFactoryUtil.create(renderRequest, "Leave-Holidays", themeDisplay.getPlid(), renderRequest.RENDER_PHASE);
	//String iteratorURL = PortalUtil.getLayoutURL(themeDisplay.getLayout(),themeDisplay);//renderResponse.createRenderURL();
    
	//iteratorURL.setParameter("mvcPath", "/html/holiday/list_holidays.jsp");
	RowChecker rowChecker = new RowChecker(renderResponse);
	
	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
	String sortByCol = ParamUtil.getString(request, "orderByCol"); 
	String sortByType = ParamUtil.getString(request, "orderByType"); 
	//System.out.println("sortByCol == " +sortByCol);
	//System.out.println("sortByType == " +sortByType);
	if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
		//System.out.println("if block...");
	 
	portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
	portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
	 
	} else { 
	 
		sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
	}
	
	//System.out.println("after....");
	//System.out.println("sortByCol == " +sortByCol);
	//System.out.println("sortByType == " +sortByType);
	
%>
<%-- <jsp:useBean id="holidayList" type="java.util.List<Holiday>" scope="request" /> --%>
<liferay-portlet:renderURLParams varImpl="holidaysSearchURL" />
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="mvcPath" value="/html/holiday/list_holidays.jsp" />
	</liferay-portlet:renderURL>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Holiday> searchContainer;
%>

<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records available for Holidays."
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	
	<liferay-ui:search-container-results>

		<%
	   List<com.rknowsys.eapp.ui.Holiday> holidayList =  (List<com.rknowsys.eapp.ui.Holiday>) portletSession.getAttribute("holidayList", javax.portlet.PortletSession.APPLICATION_SCOPE);
       System.out.println("HolidayList retrieved from session = " + holidayList );
					if (holidayList != null) {
						results = holidayList.subList(
								searchContainer.getStart(),
								(searchContainer.getEnd() > holidayList.size()) ? holidayList.size() : searchContainer.getEnd());
						total = holidayList.size();
					}

					System.out.println("results == " + results);

					System.out.println("total == " + total);
					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", total);
					
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="Holiday"
		keyProperty="holidayId" modelVar="holidayOne" rowVar="curRow"
		escapedModel="<%= true %>">

		<liferay-ui:search-container-column-text orderable="<%=false %>"
			name="Name" property="holidayName" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Date"  property="holidayDate" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Full Day/Half Day"  property="isFullDay" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Repeats Annually"  property="isAnnual" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Country"  property="nationalityName" />

		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/holiday/edit.jsp" />	

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>


</body>
</html>
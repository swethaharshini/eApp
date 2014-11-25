<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmpJobLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpJob"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpPersonalDetails"%>
<%@ include file="/html/workshift/init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Work Shifts</title>

<portlet:actionURL var="saveworkshift" name="saveWorkshift"/>
<portlet:resourceURL var="deleteworkshift" id="deleteWorkshift" />
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/workshift/addworkshift.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}

.table-last-header {
	width: 15%;
}
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

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delete');
    node.on(
      'click',
      function() {
     
     var idArray = [];
      A.all('input[type=checkbox]:checked').each(function(object) {
      idArray.push(object.get("value"));
    
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected workshift ?");
		  if(d){
		   var url = '<%=deleteworkshift%>';
          A.io.request(url,
         {																																																			
          data: {  
                <portlet:namespace />workshiftIds: idArray,   
                 },
          on: {
               success: function() { 
                   alert('Deleted successfully.');
                   window.location='<%=listview%>';
              },
               failure: function() {
                  
                 }
                }
                 }
                );
		  																		
		  console.log(idArray);
	  
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
  'aui-node',
  function(A) {
    
    var add = A.one('#btn-add');
 add.on(
      'click',
      function() {
      AUI().ready('aui-node',function(A) {
       var nodeObject = A.all('#select-to');
        A.all('#select-from option:selected').each(function() {
        A.one('#select-to').append('<option selected="selected" value="'+this.val()+'">'+this.text()+'</option>');
        this.remove();
       
		});
      });
      }
    );
  }
);

AUI().use(
  'aui-node',
  function(A) {
    
    var add = A.one('#btn-remove');
 add.on(
      'click',
      function() {
      AUI().ready('aui-node',function(A) {
       var nodeObject = A.all('#select-from');
        A.all('#select-to option:selected').each(function() {
        A.one('#select-from').append('<option value="'+this.val()+'">'+this.text()+'</option>');
        this.remove();
       
		});
      });
      }
    );
  }
);

</aui:script>
<aui:script>
YUI().use(
  'aui-timepicker',
  function(Y) {
    new Y.TimePicker(
      {
        trigger: '#fromWorkHours',
        popover: {
          zIndex: 2
        },
        mask:'%H:%M',
        on: {
          selectionChange: function(event) {
            document.<portlet:namespace />workshiftForm.<portlet:namespace />duration.value = event.newSelection;
          }
        }
      }
    );
    new Y.TimePicker(
      {
        trigger: '#toWorkHours',
        mask:'%H:%M',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
            document.<portlet:namespace />workshiftForm.<portlet:namespace />duration.value = event.newSelection;
          }
        }
      }
    );
  }
);

</aui:script>
</head>

<body>
	 
<div id="addworkshiftForm" >
	<aui:form 	 name = "workshiftForm" action="<%=saveworkshift %>">
	
	<div class="row-fluid">
		<aui:input name="shiftId" type="hidden" id="shiftId" />
		<aui:input name="workshiftName" showRequiredLabel="false"
				type="text" label="Shift Name">
				<aui:validator name="required" />
			</aui:input>
	</div>
	<div class="row-fluid">
	 <div class="span4">
			<label>From</label>
			<input name="<portlet:namespace />fromWorkHours"
				id="fromWorkHours" type="text" required="required"
				placeholder="hh:mm" value="00:00"  />
			</div>
			<div class="span4">
				<label>To</label>
			<input name="<portlet:namespace />toWorkHours" id="toWorkHours"
				type="text" required="required" placeholder="hh:mm" value="00:00"
				/>
		</div><div class="span4"></div>
		
</div>
  <div class="row-fluid">

				<table>
					<tr>
						<td><b> Available Employees<br /></b>
 <%
 
 		List<EmpPersonalDetails> emplist = EmpPersonalDetailsLocalServiceUtil.getEmployeeDetailsByShiftId(Long.parseLong("0"));
 		System.out.println("List == "+emplist.size());
 %> <select name="<portlet:namespace />selectfrom" id="select-from" multiple="multiple">
								<%
									for (int i = 0; i < emplist.size(); i++) {
								%>

								<Option value="<%=emplist.get(i).getEmployeeId()%>"><%=emplist.get(i).getFirstName()+" "+emplist.get(i).getLastName()%></Option>
								<%
									}
								%>
						</select></td>
						<td align="center" height="183px" width="175px"><div id="btn-add"><a href="#">Add</a></div>
							<br />
						<div id="btn-remove"><a href="#">Remove</a></div></td>
						<td><b>Assigned Employees<br /></b> <select 
							name="<portlet:namespace />selectto" id="select-to"
							multiple="multiple">


						</select></td>
					</tr>

				</table>
						
			</div>
				
			   <aui:button type="submit" name="submit" value="Submit" id="submit"></aui:button>
			   <aui:button type="reset" value="reset"></aui:button>
			   <input type="button" class="btn" value="Delete" id="delete">
			
		
	</aui:form>
	</div>
	<div>
		<label style="color: white">.</label>
	</div>
	
	
</body>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath",
			"/html/workshift/addworkshift.jsp");
	RowChecker rowChecker = new RowChecker(renderResponse);

	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil
			.getPortalPreferences(request);
	String sortByCol = ParamUtil.getString(request, "orderByCol");
	String sortByType = ParamUtil.getString(request, "orderByType");
	System.out.println("sortByCol == " + sortByCol);
	System.out.println("sortByType == " + sortByType);
	if (Validator.isNotNull(sortByCol)
			&& Validator.isNotNull(sortByType)) {
		System.out.println("if block...");

		portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol);
		portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol);

	} else {

		sortByType = portalPrefs.getValue("NAME_SPACE",
				"sort-by-type ", "asc");
	}

	System.out.println("after....");
	System.out.println("sortByCol == " + sortByCol);
	System.out.println("sortByType == " + sortByType);
%>
<%!com.liferay.portal.kernel.dao.search.SearchContainer<Workshift> searchContainer;%>
<div>
	<liferay-ui:search-container orderByCol="<%=sortByCol%>"
		orderByType="<%=sortByType%>" rowChecker="<%= new RowChecker(renderResponse) %>"
		delta="5"
		emptyResultsMessage="No records is available for Work Shifts."
		deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>

			<%
				List<Workshift> workshiftList = WorkshiftLocalServiceUtil
								.getWorkshifts(searchContainer.getStart(),
										searchContainer.getEnd());
						System.out.println("list size == "
								+ workshiftList.size());
						OrderByComparator orderByComparator = CustomComparatorUtil
								.getWorkshiftOrderByComparator(sortByCol,
										sortByType);

						Collections.sort(workshiftList, orderByComparator);

						results = workshiftList;

						System.out.println("results == " + results);

						total = WorkshiftLocalServiceUtil
								.getWorkshiftsCount();
						System.out.println("total == " + total);
						pageContext.setAttribute("results", results);
						pageContext.setAttribute("total", total);
				System.out.println("searchContainer.getStart() =" + searchContainer.getStart());
					System.out.println(	"searchContainer.getEnd() = " + searchContainer.getEnd());
			%>

		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="Workshift"
			keyProperty="shiftId" modelVar="workshift" rowVar="curRow"
			escapedModel="<%=true%>">
			<% WorkshiftBean workshiftExt = new WorkshiftBean(workshift); %>
			<liferay-ui:search-container-column-text orderable="<%=true%>"
				name="Shift Name" property="workshiftName"
				orderableProperty="workshiftName" />
			<liferay-ui:search-container-column-text orderable="<%=false%>"
				name="From" value="<%= workshiftExt.getFormattedFromWorkHoursStr()%>" />
			<liferay-ui:search-container-column-text orderable="<%=false%>"
				name="To" value="<%=workshiftExt.getFormattedToWorkHoursStr()%>"  />
			<liferay-ui:search-container-column-text orderable="<%=false%>"
				name="Duration" value="<%=workshiftExt.getFormattedDurationStr()%>" />
			<liferay-ui:search-container-column-jsp name="Edit"
				path="/html/workshift/edit.jsp" />

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</div>

</html>
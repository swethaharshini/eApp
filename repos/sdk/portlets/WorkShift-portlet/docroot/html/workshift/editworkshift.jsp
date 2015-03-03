<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpPersonalDetails"%>
<%@page import="com.rknowsys.eapp.hrm.model.Workshift"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/workshift/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<portlet:actionURL var="saveworkshift" name="saveWorkshift">
</portlet:actionURL>
<portlet:resourceURL var="deleteworkshift" id="deleteWorkshift" />
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/workshift/editworkshift.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
#<portlet:namespace/>fromWorkHours,#<portlet:namespace/>toWorkHours{
  width: 59px;
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
     A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
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
        A.one('#select-from').append('<option selected="selected" value="'+this.val()+'">'+this.text()+'</option>');
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
        trigger: '#<portlet:namespace/>fromWorkHours',
        popover: {
          zIndex: 1
        },
        mask:'%H:%M',
        on: {
          selectionChange: function(event) {
           // document.<portlet:namespace />addworkshiftForm_1.<portlet:namespace />duration.value = event.newSelection;
          }
        }
      }
    );
    new Y.TimePicker(
      {
        trigger: '#<portlet:namespace/>toWorkHours',
        mask:'%H:%M',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
           // document.<portlet:namespace />addworkshiftForm_1.<portlet:namespace />duration.value = event.newSelection;
          }
        }
      }
    );
  }
);
AUI().ready('event', 'node','transition',function(A){
setTimeout(function(){
A.one('#addworkshiftMessage').transition('fadeOut');
A.one('#addworkshiftMessage').hide();
},2000)
});
</aui:script>
<% Logger log=Logger.getLogger(this.getClass().getName());%>
<%
Workshift editworkshift = (Workshift) portletSession.getAttribute("editworkshift");

%>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"workshiftName-empty-error")){%>
<p id="addworkshiftMessage" class="alert alert-error"><liferay-ui:message key="Please Enter WorkshiftName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"workshiftName-duplicate-error")){
%>
<p id="addworkshiftMessage" class="alert alert-error"><liferay-ui:message key="WorkshiftName already Exits"/></p>
<%} 
%>
	<div id="editWorkshiftForm">
		<aui:form name="workshiftForm" action="<%=saveworkshift.toString()%>">
		<div class="row-fluid">
			<aui:input name="shiftId" type="hidden" id="shiftId"
				value="<%=editworkshift.getShiftId()%>" />
					<% WorkshiftBean workshiftExt = new WorkshiftBean(editworkshift); %>
					<aui:input name="workshiftName" id="workshiftName" label="Shift Name"
					    type="text" value="<%=editworkshift.getWorkshiftName() %>"/>
		</div>
			<div class="row-fluid">
				<div class="span4">
						<label>From</label>
						<aui:input name="fromWorkHours" id="fromWorkHours" label=""
							type="text" value="<%=workshiftExt.getFormattedFromWorkHoursStr() %>">
						</aui:input>
				</div>
					<div class="span4">
	                    <label>To</label>
						<aui:input name="toWorkHours" id="toWorkHours" label=""
							type="text" value="<%=workshiftExt.getFormattedToWorkHoursStr() %>">
							
							<aui:validator name="custom" errorMessage="To time should be greater than from From time">
							function(val,fieldNode,ruleValue)
							{
								var result=false;
								var from=A.one("#<portlet:namespace/>fromWorkHours").get('value'); 
		                        var d=new Date();
		                        var str=from;
		                        var res=str.split(":");
		                        var value1=res[0];
		                        var value2=res[1];
		                        var str2=val;
		                        var res1=str2.split(":");
		                        var value3=res1[0];
		                        var value4=res1[1];
		                        var result1=res[0]+res[1];
		                        var result2=res1[0]+res1[1];
		                        
		                        if(result1 < result2 ){
		                        	result=true;
		                        }else{
		                        	result= false;
								}
							return result;
							}
							</aui:validator>
						</aui:input>			
					</div>
				<div class="span4"></div>
		</div>	
		
	<div class="row-fluid">
 
  <table><tr><td><b>

Available Employees<br/></b>

<%
List<EmpPersonalDetails> emplist = EmpPersonalDetailsLocalServiceUtil.getEmployeeDetailsByShiftId(Long.parseLong("0"));
	log.info("List == "+emplist.size());
 %>

 <select name="<portlet:namespace />selectfrom" id="select-from"multiple="multiple" >
    <%for(int i=0;i<emplist.size();i++){
    %>
     
    <Option selected="selected" value="<%=emplist.get(i).getEmployeeId()%>"><%=emplist.get(i).getFirstName()+" "+emplist.get(i).getLastName()%></Option>
    <%}%>
    </select>



</td><td align="center" height="183px" width="175px"><div id="btn-add"><a href="#">Add</a></div><br/><div id="btn-remove"><a href="#">Remove</a></div></td>
  <td><b>Assigned Employees<br/></b>
  	<%
List<EmpPersonalDetails> elist = EmpPersonalDetailsLocalServiceUtil.getEmployeeDetailsByShiftId(editworkshift.getShiftId());
	log.info("List == "+emplist.size());
 %>
<select name="<portlet:namespace/>selectto" id="select-to" multiple="multiple" >
     <%for(int i=0;i<elist.size();i++){
    %>
     
    <Option selected="selected" value="<%=elist.get(i).getEmployeeId()%>"><%=elist.get(i).getFirstName()+" "+elist.get(i).getLastName()%></Option>
    <%}%>

</select> 

   
    </td></tr>
      
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

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/workshift/editworkshift.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	log.info("if block...");
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}
log.info("after....");
log.info("sortByCol == " +sortByCol);
log.info("sortByType == " +sortByType);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Workshift> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>" delta="5" emptyResultsMessage="No records is available for Workshift."   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
		long groupId =  themeDisplay.getLayout().getGroup().getGroupId();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Workshift.class,PortletClassLoaderUtil.getClassLoader());

		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		  
			List<Workshift> workshiftList = WorkshiftLocalServiceUtil.dynamicQuery(dynamicQuery);
					log.info("list size == "
							+ workshiftList.size());
					OrderByComparator orderByComparator = CustomComparatorUtil
							.getWorkshiftOrderByComparator(sortByCol,
									sortByType);

					Collections.sort(workshiftList, orderByComparator);
					if(workshiftList.size()>5){
						results = ListUtil.subList(workshiftList, searchContainer.getStart(),searchContainer.getEnd());
					}else{
					results = workshiftList;
					}
					log.info("results == " + results);

					total = workshiftList.size();
					log.info("total == " + total);
					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", total);
               
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
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
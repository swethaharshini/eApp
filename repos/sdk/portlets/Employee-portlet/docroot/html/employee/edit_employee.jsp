<%@ include file="/html/employee/init.jsp"%>
<%

Map empId = (Map) request.getSession(false).getAttribute(
		"empId");
long employeeId = (Long)empId.get("empId");
String jsp=(String)empId.get("jsp");
long fileEntryId=(Long)empId.get("fileId");
	DynamicQuery personalDetailsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpPersonalDetails.class,
					PortletClassLoaderUtil.getClassLoader());
	personalDetailsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpPersonalDetails> l = EmpPersonalDetailsLocalServiceUtil
			.dynamicQuery(personalDetailsDynamicQuery);
	EmpPersonalDetails empPersonalDetails=null;
	if(l.size()!=0)
	{
	empPersonalDetails = l.get(0);
	}
%>
<portlet:resourceURL var="displayImage" id="displayImage">
<portlet:param name="imageId" value="<%=String.valueOf(fileEntryId) %>"></portlet:param>
</portlet:resourceURL>
<portlet:renderURL var="updateImage" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/employee/updateImage.jsp" />
	<portlet:param name="imageId2" value="<%=String.valueOf(fileEntryId) %>"/>
	</portlet:renderURL>
	<portlet:renderURL var="refresh">
	<portlet:param name="mvcPath" value="/html/employee/edit_employee.jsp"/>
	</portlet:renderURL>
<aui:script>
function updateImage()
{
  AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',
             'aui-dialog-iframe-deprecated',
    function(A) {
	var popUpWindow=Liferay.Util.Window.getWindow(
	{
		dialog: {
			destroyOnHide:true,
			centered: true,
			constrain2view: true,
			modal: true,
			resizable: false,
			height:300,
			width: 700
		   }
		}).plug(A.Plugin.DialogIframe,
		   {
				autoLoad: true,
				iframeCssClass: 'dialog-iframe',
				uri:'<%=updateImage.toString()%>',
			}).render();
        	popUpWindow.titleNode.html("Select an Image to Update");
			popUpWindow.show().after('destroy', function(event) {
                window.location='<%=refresh%>';
                
        });
			popUpWindow.io.start();
     });       
}    
 </aui:script>

<aui:script>
YUI().use(
  'aui-tabview',
  function(Y) {
    var tabView=new Y.TabView(
      {
        srcNode: '#employeeDetails',
        stacked:true
      }
    ).render();
    tabView.after ('tab:selectedChange', function (e) {
    A.all('#<portlet:namespace/>empContactDetailsEdit input[type=text]').set('disabled',true);
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=select]').set('disabled',true);
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=radio]').set('disabled',true);
    A.all('#<portlet:namespace/>empPersonalDetailsSave input[type=text]').set('disabled',true);
	A.all('#<portlet:namespace/>empPersonalDetailsSave select').set('disabled',true);
	A.all('#<portlet:namespace/>empPersonalDetailsSave input[type=radio]').set('disabled',true);
	A.one('#<portlet:namespace />editContactDetails').show();
	A.one('#<portlet:namespace />saveContactDetails').hide();
	A.one('#<portlet:namespace />editPersonalDetails').show();
	A.one('#<portlet:namespace />savePersonalDetails').hide();
    });
  }
);
</aui:script>
<aui:script use="aui-base,aui-date-picker,aui-node,aui-tabview">
var A=new AUI();
AUI().use(
  'aui-datepicker',
  function(A) {
    new A.DatePicker(
      {
        trigger: '.dateEmployee',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
            console.log(event.newSelection)
          }
        }
      }
    );
  }
);
</aui:script>
<div id="employeeDetails">
<ul class="span3 side-nav" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body">
				<img alt="upload an Image" src="<%=displayImage%>"> <a
					href="#" onclick="updateImage()">Change Photo</a>
			</div>
		</div>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp0") || jsp.equals("jsp1") || jsp.equals("empEditJsp")%>'>
				<li class="active"><a href="#tab-1"><i class="icon-user"></i>
						<liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-1"><i class="icon-user"></i> <liferay-ui:message
							key="01_emp-personal-details"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp2")%>'>
				<li class="active"><a href="#tab-2"><i
						class="icon-envelope"></i> <liferay-ui:message
							key="01_emp-contact-details"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-2"><i class="icon-envelope"></i> <liferay-ui:message
							key="01_emp-contact-details"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp3")%>'>
				<li class="active"><a href="#tab-3"><i
						class="icon-phone-sign"></i> <liferay-ui:message
							key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-3"><i class="icon-phone-sign"></i> <liferay-ui:message
							key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp4")%>'>
				<li class="active"><a href="#tab-4"><i class="icon-male"></i>
						<liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-4"><i class="icon-male"></i> <liferay-ui:message
							key="01_emp-dependents"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp5")%>'>
				<li class="active"><a href="#tab-5"><i
						class="icon-fb-radio"></i> <liferay-ui:message
							key="01_emp-immigration"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-5"><i class="icon-fb-radio"></i> <liferay-ui:message
							key="01_emp-immigration"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp6")%>'>
				<li class="active"><a href="#tab-6"><i class="icon-table"></i>
						<liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-6"><i class="icon-table"></i> <liferay-ui:message
							key="01_emp-report-to"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp7")%>'>
				<li class="active"><a href="#tab-7"><i
						class="icon-stethoscope"></i> <liferay-ui:message
							key="01_emp-qualifications"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-7"><i class="icon-stethoscope"></i> <liferay-ui:message
							key="01_emp-qualifications"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp8")%>'>
				<li class="active"><a href="#tab-8"><i class="icon-group"></i>
						<liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-8"><i class="icon-group"></i> <liferay-ui:message
							key="01_emp-membership"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp9")%>'>
				<li class="active"><a href="#tab-9"><i
						class="icon-briefcase"></i> <liferay-ui:message
							key="01_emp-job-history"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-9"><i class="icon-briefcase"></i> <liferay-ui:message
							key="01_emp-job-history"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp10")%>'>
				<li class="active"><a href="#tab-10"><i class="icon-money"></i>
						<liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-10"><i class="icon-money"></i> <liferay-ui:message
							key="01_emp-salary-history"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp11")%>'>
				<li class="active"><a href="#tab-11"><i class="icon-dollar"></i>
						<liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-11"><i class="icon-dollar"></i> <liferay-ui:message
							key="01_emp-direct-deposits"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='<%=jsp.equals("jsp12")%>'>
				<li class="active"><a href="#tab-12"><i class="icon-file"></i>
						<liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#tab-12"><i class="icon-file"></i> <liferay-ui:message
							key="01_add-documents"></liferay-ui:message></a></li>
			</c:otherwise>
		</c:choose>
		</ul>
	<div class="tab-content">
		<div id="tab-1" class="tab-pane">
			<jsp:include page="/html/employee/emp_personalDetails.jsp" />
		</div>
		<div id="tab-2" class="tab-pane">
			<jsp:include page="/html/employee/emp_contactDetails.jsp" />
		</div>
		<div id="tab-3" class="tab-pane">
			<jsp:include page="/html/employee/emp_emergencyContacts.jsp" />
		</div>
		<div id="tab-4" class="tab-pane">
			<jsp:include page="/html/employee/emp_dependents.jsp" />
		</div>
		<div id="tab-5" class="tab-pane">
			<jsp:include page="/html/employee/emp_immigration.jsp" />
		</div>
		<div id="tab-6" class="tab-pane">
			<jsp:include page="/html/employee/emp_reportTo.jsp" />
		</div>
		<div id="tab-7" class="tab-pane">
			<jsp:include page="/html/employee/emp_qualifications.jsp" />
		</div>
		<div id="tab-8" class="tab-pane">
			<jsp:include page="/html/employee/emp_memberships.jsp" />
		</div>
		<div id="tab-9" class="tab-pane">
			<jsp:include page="/html/employee/emp_jobHistory.jsp" />
		</div>
		<div id="tab-10" class="tab-pane">
			<jsp:include page="/html/employee/emp_salaryHistory.jsp" />
		</div>
		<div id="tab-11" class="tab-pane">
			<jsp:include page="/html/employee/emp_directDeposits.jsp" />
		</div>
		<div id="tab-12" class="tab-pane">
			<jsp:include page="/html/employee/emp_documents.jsp" />
		</div>
	</div>
</div>

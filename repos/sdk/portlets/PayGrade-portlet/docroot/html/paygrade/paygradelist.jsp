<%@ include file="/html/paygrade/init.jsp"%>
<%@page import="com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.PayGrade"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>paygradelist</title>
<portlet:resourceURL var="deletepaygrade" id="deletePayGrade"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/paygrade/paygradelist.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addpaygrade">
	<portlet:param name="mvcPath" value="/html/paygrade/addpaygrade.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
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
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
    
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected records ?");
		  if(d){
		   var url = '<%=deletepaygrade%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />paygradeIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('deleted successfully');
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
function addPayGrade(){
 window.location='<%=addpaygrade%>';
}

</aui:script>


</head>
<body>
<div class="row-fluid">
	<div id="interviewadddelete" class="span12">
		<div class="pull-left">
		<button  onclick="addPayGrade()" class="btn btn-success" type="button"><i class="icon-plus"></i> Add </button>
		<button id="delete" class="btn btn-danger" type="button"><i class="icon-trash"></i> Delete </button> 
		</div>
	</div>
	</div>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();

iteratorURL.setParameter("mvcPath", "/html/paygrade/paygradelist.jsp");
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<PayGrade> searchContainer;
%>

 <liferay-ui:search-container delta="5" emptyResultsMessage="No records is available for PayGrade" rowChecker="<%= new RowChecker(renderResponse) %>"  deltaConfigurable="true"  iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
		<%
		 
		 results =  PayGradeLocalServiceUtil.getPayGrades(searchContainer.getStart(), searchContainer.getEnd());
		System.out.println("results == " +results.size());
		total = PayGradeLocalServiceUtil.getPayGradesCount();
		pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
				
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="PayGrade" keyProperty="payGradeId" modelVar="PayGrade"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text  name="PayGrade Name" property="payGradeName"/>
	     
	     
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/paygrade/edit.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</body>
</html>
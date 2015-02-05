<%@ include file="/html/paygrade/init.jsp"%>
<%@page import="com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.PayGrade"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<portlet:resourceURL var="deletepaygrade" id="deletePayGrade"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/paygrade/paygradelist.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addpaygrade">
	<portlet:param name="mvcPath" value="/html/paygrade/addpaygrade.jsp" />
</portlet:renderURL>

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

	<div id="interviewadddelete" class="control-group text-right">
		<a onclick="addPayGrade()" class="btn btn-success"><i class="icon-plus"></i> Add</a>
		<a id="delete" class="btn btn-danger"><i class="icon-trash"></i> Delete</a> 
	</div>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();

iteratorURL.setParameter("mvcPath", "/html/paygrade/paygradelist.jsp");
long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
.forClass(PayGrade.class,
		PortletClassLoaderUtil.getClassLoader());
dynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
List<PayGrade> paygrades = PayGradeLocalServiceUtil
.dynamicQuery(dynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<PayGrade> searchContainer;
%>

 <liferay-ui:search-container delta="5" emptyResultsMessage="No records is available for PayGrade" rowChecker="<%= new RowChecker(renderResponse) %>"  deltaConfigurable="true"  iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
		<%
		 
		 results =  ListUtil.subList(paygrades, searchContainer.getStart(), searchContainer.getEnd());
		total = paygrades!=null && paygrades.size()!=0?paygrades.size():0;
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

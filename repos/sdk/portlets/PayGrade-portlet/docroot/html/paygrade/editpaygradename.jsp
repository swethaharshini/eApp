<%@page import="com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.rknowsys.eapp.hrm.model.PayGradeCurrency"%>
<%@page import="com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.PayGrade"%>
<%@ include file="/html/paygrade/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayGrade</title>
<portlet:actionURL var="savepaygrade" name="savePayGrade">
</portlet:actionURL>
<portlet:resourceURL var="deletepaygrade" id="deletePayGrade"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/paygrade/editpaygradename.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addCurrency">
	<portlet:param name="mvcPath" value="/html/paygrade/editpaygrade.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="deletepaygradecurreny" id="deletePayGradeCurrency"/>
<portlet:renderURL var="paygradelist">
	<portlet:param name="mvcPath" value="/html/paygrade/paygradelist.jsp" />
</portlet:renderURL>
<style type="text/css">
em {
	color: red;
}

</style>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#currencydelete');
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
		   var url = '<%=deletepaygradecurreny%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />paygradecurrencyIds: idArray,  
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

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancel');
    node.on(
      'click',
      function() {
        A.one("#paygradeId").set("value","");
         A.one("#paygrade").set("value","");
      	
          
      }
    );																																
  }
);


</aui:script>

</head>
<body>
<%

PayGrade editpaygrade =(PayGrade) portletSession.getAttribute("editpaygrade");
portletSession.setAttribute("paygrade3", editpaygrade);

%>

<aui:form name="myForm" action="<%=savepaygrade.toString()%>">
		<aui:input name="paygradeId" type="hidden" id="paygradeId" value="<%=editpaygrade.getPayGradeId()%>" />
		<div class="span12">
			<div class="span2">
				<label>Name<em>*</em> </label>
		</div>
		<div class="span3">		
		 <input name="<portlet:namespace/>paygradeName" id="paygrade" type="text" required = "required" value="<%=editpaygrade.getPayGradeName()%>">
			</div>
		</div>
		<br/><br/><br/>
		<aui:button type="submit" value="Submit" />
		<aui:button  type="reset" value="Cancel" href="<%=paygradelist.toString()%>" id ="cancel"/>
		<button id="currencydelete" class="btn btn-danger" type="button"><i class="icon-trash"></i> Delete </button>
		<aui:button  type="button" value="AddCurrency" href="<%=addCurrency.toString()%>" id ="cancel"/>
	</aui:form>


</body><br/>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();

iteratorURL.setParameter("mvcPath", "/html/paygrade/editpaygradename.jsp");
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<PayGradeCurrency> searchContainer;
%>

 <liferay-ui:search-container delta="5" emptyResultsMessage="No Currency is available for PayGrade" rowChecker="<%= new RowChecker(renderResponse) %>"  deltaConfigurable="true"  iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
		<%
		long id = editpaygrade.getPayGradeId();
		DynamicQuery paygradecurrencyQuery = DynamicQueryFactoryUtil.forClass(PayGradeCurrency.class, PortletClassLoaderUtil.getClassLoader());
		paygradecurrencyQuery.add(PropertyFactoryUtil.forName("payGradeId").eq(id));
		List<PayGradeCurrency> paygradecurrencyList = PayGradeCurrencyLocalServiceUtil.dynamicQuery(paygradecurrencyQuery);
		 results =  paygradecurrencyList;
		System.out.println("results == " +results.size());
		total = results.size();
		pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
				
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="PayGradeCurrency" keyProperty="payGradeCurrencyId" modelVar="PayGradeCurrency"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text  name="PayGradeCurrency Name" property="currency"/>
	     <liferay-ui:search-container-column-text  name="Min Salary" property="minSalary"/>
	     <liferay-ui:search-container-column-text  name="Max Salary" property="maxSalary"/>
	  	<liferay-ui:search-container-column-jsp name="Edit"  path="/html/paygrade/editcurrency.jsp"/>	 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>


</html>
<%@page import="org.apache.log4j.Logger"%>
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
AUI().ready('event', 'node', function(A){
   A.one('#paygradeName').focus();
});

</aui:script>

<% Logger log=Logger.getLogger(this.getClass().getName());%>
<%

PayGrade editpaygrade =(PayGrade) portletSession.getAttribute("editpaygrade");
portletSession.setAttribute("paygrade3", editpaygrade);

%>
<div class="panel">
	<div class="panel-heading">
		<h4>Edit PayGrade Name</h4>
	</div>
	<div class="panel-body">
		<div class="form-horizontal">
		<aui:form name="myForm" action="<%=savepaygrade.toString()%>">
			<aui:input name="paygradeId" type="hidden" id="paygradeId" value="<%=editpaygrade.getPayGradeId()%>" />
			<div class="control-group">
				<label class="control-label">Name<em>*</em> </label>
				<div class="controls">
				 <input name="<portlet:namespace/>paygradeName" id="paygradeName" type="text"  value="<%=editpaygrade.getPayGradeName()%>">
				</div>
			</div>
			<div class="controls">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
				<a class="btn btn-danger" href="<%=paygradelist.toString()%>" id ="cancel"><i class="icon-remove"></i> Cancel</a>
			</div>
		</aui:form>
		</div>
	</div>
</div>
<div class="control-group text-right">
	<a class="btn btn-primary" id="cancel" href="<%=addCurrency.toString()%>"><i class="icon-plus"></i> Add</a>
	<a href="#" class="btn btn-danger" id="currencydelete"><i class="icon-trash"></i> Delete</a>
</div>


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
		DynamicQuery paygradecurrencyquery = DynamicQueryFactoryUtil.forClass(PayGradeCurrency.class, PortletClassLoaderUtil.getClassLoader());
		paygradecurrencyquery.add(PropertyFactoryUtil.forName("payGradeId").eq(id));
		paygradecurrencyquery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getLayout().getGroup().getGroupId()));
		List<PayGradeCurrency> currencyList= PayGradeCurrencyLocalServiceUtil.dynamicQuery(paygradecurrencyquery);
		results = ListUtil.subList(currencyList, searchContainer.getStart(), searchContainer.getEnd());
		log.info("results == " +results.size());
		total = currencyList!=null && currencyList.size()!=0?currencyList.size():0;
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

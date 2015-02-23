<%@page import="org.apache.log4j.Logger"%>
<%@ include file="/html/paygrade/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit PayGrade</title>
<portlet:actionURL var="savepaygradecurrency" name="savePayGradeCurrency">
</portlet:actionURL>
<portlet:renderURL var="paygrade">
	<portlet:param name="mvcPath" value="/html/paygrade/paygradelist.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="deletepaygradecurreny" id="deletePayGradeCurrency"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/paygrade/editpaygrade.jsp" />
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

</aui:script>

<% Logger log=Logger.getLogger(this.getClass().getName());%>
<%

PayGrade paygrade3 =(PayGrade) portletSession.getAttribute("paygrade3");
Long paygradeid = paygrade3.getPayGradeId();
log.info("id ======= " +paygradeid);
PayGradeCurrency editpaygradecurrency = (PayGradeCurrency)portletSession.getAttribute("editpaygradecurrency");
%>
<div class="panel">
	<div class="panel-heading">
		<h4>PayGrade</h4>
	</div>
	<div class="panel-body">
		<aui:form name="paygradeForm">
			<div class="form-horizontal">
				<aui:input name="paygradeId" type="hidden" id="paygradeId"  value="<%=paygrade3.getPayGradeId()%>"/>
				<div class="control-group">
					<label class="control-label">Name<em>*</em> </label>
					<div class="controls">
					<input name="<portlet:namespace/>paygradeName" id="paygrade" type="text" readonly="readonly" value="<%=paygrade3.getPayGradeName()%>">
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<div class="panel">
<div class="panel-heading">
   <h4>Edit Currency</h4>
 </div>
 <div class="panel-body">
   <div id="currencyform">
		<aui:form name="myForm" action="<%=savepaygradecurrency.toString()%>">
			<div class="form-horizontal">
		<aui:input name="paygradeId" type="hidden" id="paygradeId"  value="<%=paygrade3.getPayGradeId()%>"/>
		<aui:input name="paygradecurrencyId" type="hidden" id="paygradecurrencyId"  value="<%=editpaygradecurrency.getPayGradeCurrencyId()%>"/>
		    
		      <label class="control-label">Currency:<em>*</em> </label>
		     
		      <aui:input name="currency" label="" id="myAutoComplete"  type="text" value="<%=editpaygradecurrency.getCurrency()%>"/>
		
		
		 <aui:input name="minSalary" label="Minimum Salary" id="minSalary" type="text" value="<%=editpaygradecurrency.getMinSalary()%>">
		 <aui:validator name="digits"></aui:validator>
		 </aui:input>

	
		 <aui:input name="maxSalary" label="Maximum Salary" id="maxSalary" type="text" value="<%=editpaygradecurrency.getMaxSalary()%>">
		   <aui:validator name="digits"></aui:validator>
				 	   <aui:validator name="custom" errorMessage="Maximum salary should be greater than minimum salary">
				 	     function(val,fieldNode,ruleValue){
				 	      
				 	       var result=false;
				 	       var min= A.one("#<portlet:namespace/>minSalary").get('value');
				 	       var max=val;
				 	       if(Number(max) <= Number(min)){
				 	         
				 	         result=false;
				 	       }else{
				 	         result=true;
				 	    
				 	       }
				 	       return result;
				 	     }
				 	   </aui:validator>
		 
		 
		 </aui:input>
		
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
				<a class="btn btn-danger" href="<%=paygrade.toString()%>" id ="currencycancel"><i class="icon-remove"></i> Cancel</a>
			</div>
		</div>
		</div>
		</aui:form>
	</div>
	<div class="control-group text-right">
		<button id="currencydelete" class="btn btn-danger" type="button"><i class="icon-trash"></i> Delete </button>
	</div>
	<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/paygrade/editpaygrade.jsp");
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<PayGradeCurrency> searchContainer;
%>

 <liferay-ui:search-container delta="5" emptyResultsMessage="No records is available for PayGradeCurrency" rowChecker="<%= new RowChecker(renderResponse) %>"  deltaConfigurable="true"  iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
		<%
		
		DynamicQuery paygradecurrencyquery = DynamicQueryFactoryUtil.forClass(PayGradeCurrency.class, PortletClassLoaderUtil.getClassLoader());
		paygradecurrencyquery.add(PropertyFactoryUtil.forName("payGradeId").eq(paygradeid));
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
	     <liferay-ui:search-container-column-text  name="Currency" property="currency"/>
	     <liferay-ui:search-container-column-text  name="Min Salary" property="minSalary"/>
	     <liferay-ui:search-container-column-text  name="Max Salary" property="maxSalary"/>
	     
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/paygrade/editcurrency.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
	
	
	
	
 </div>
</div>
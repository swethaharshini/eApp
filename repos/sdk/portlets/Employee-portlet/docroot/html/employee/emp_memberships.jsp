<%@page import="com.rknowsys.eapp.hrm.service.EmpMembershipLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpMembership"%>
<%@ include file="/html/employee/init.jsp"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<portlet:actionURL name="addMembership" var="addMembershipURL">
</portlet:actionURL>
<portlet:renderURL var ="listView">
 <portlet:param name="mvcPath" value="/html/employee/edit_employee.jsp"/>
</portlet:renderURL>
<portlet:resourceURL var ="deleteMembership" id="deleteMembership"></portlet:resourceURL>
<%@page import="java.text.SimpleDateFormat" %>
<portlet:actionURL var="updateEmpMembershipURL" name="updateEmpMembership">
</portlet:actionURL>

<aui:script use="aui-base,aui-node,aui-io-request-deprecated,aui-datepicker">
var A=new AUI();
A.ready(function()
  {
  A.one('#addEmpMembership').hide();
  });
   var addButton=A.one('#<portlet:namespace />empMembershipAdd');
   addButton.on('click',
   function()
   {
   A.one('#<portlet:namespace />empMembershipAdd').hide();
   A.one('#<portlet:namespace />empMembershipDelete').hide();
   A.one('#addEmpMembership').show();
   });
   var cancelButton=A.one('#<portlet:namespace />cancelMembership');
   cancelButton.on('click',function()
   {
	   A.one('#addEmpMembership').hide();
	   A.one('#<portlet:namespace />empMembershipAdd').show();
       A.one('#<portlet:namespace />empMembershipDelete').show();
   });
   
  
	   new A.DatePicker(
			   {
				   trigger:'#<portlet:namespace/>subcommdate',
				   mask:'%Y/%m/%d',
				   popover:{
					   zIndex:1
				   },
				   on:{
					   selectChange:function(event){
						   console.log(event.newSelection)
					   }
				   }
			   }     	   
	   );
	   new A.DatePicker(
			   {
				   trigger:'#<portlet:namespace/>subcommdate1',
				   mask:'%Y/%m/%d',
				   popover:{
					   zIndex:1
				   },
				   on:{
					   selectChange:function(event){
						   console.log(event.newSelection)
					   }
				   }
			   }     	   
	   );
	   new A.DatePicker(
			   {
				   trigger:'#<portlet:namespace/>subrendate',
				   mask:'%Y/%m/%d',
				   popover:{
					   zIndex:1
				   },
				   on:{
					   selectionChange:function(event){
						   console.log(event.newSelection)
					   }
				   }
			   });
  
	   new A.DatePicker(
			   {
				   trigger:'#<portlet:namespace/>subrendate1',
				   mask:'%Y/%m/%d',
				   popover:{
					   zIndex:1
				   },
				   on:{
					   selectionChange:function(event){
						   console.log(event.newSelection)
					   }
				   }
			   });
  
	  
  
  
			   
	   var node = A.one('#<portlet:namespace/>empMembershipDelete');
	     node.on(
	       'click',
	       function() {
	    	   
	      var idArray = [];
	      var id = A.all('input[name=<portlet:namespace/>rowIds]');
	      var length= id.size();
	      
	      if(length==0){
	     	 alert("No records to delete");
	      }
	      else{
	       A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
	       idArray.push(object.get("value"));
	     
	         });
	        if(idArray==""){
	 			  alert("Please select records!");
	 		  }else{
	 			  var d = confirm("Are you sure you want to delete the selected Membership records?");
	 		  if(d){
	 			
	 		   var url = '<%=deleteMembership%>';
	           A.io.request(url,
	          {
	           data: {  
	                 <portlet:namespace />membershipIds: idArray,  
	                  },
	           on: {
	                success: function() { 
	                    alert('deleted successfully');
	                    window.location='<%=listView%>';
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
	      
	       }
	     );
   
	    var node3 = A.one('#<portlet:namespace/>cancelMembershipbtn');
	    node3.on('click',function(){
	    	 window.location='<%= listView%>';
	    });
   </aui:script>
   
   
 
<%
	
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	long empMembershipId = ParamUtil.getLong(request,"empMembershipId");
	  
	  if(empMembershipId>0){
		  long empId1 = ParamUtil.getLong(request,"empId");
		  long fileId = ParamUtil.getLong(request,"fileId");
		  EmpMembership membership1 = null;
		  membership1 = EmpMembershipLocalServiceUtil.getEmpMembership(empMembershipId);
%>

       <div class="panel">
   <div class="panel-heading">
     <h4>Edit Memberships</h4>
   </div>
   <div class="panel-body">
      <aui:form name="myForm" id="myForm" action="<%=updateEmpMembershipURL%>" method="post">
        <div class="form-horizontal">
          <aui:input name="empMemId" value="<%=membership1.getEmpMembershipId()%>" type="hidden"></aui:input>
          <aui:input name="empId" value="<%=empId1%>" type="hidden"></aui:input>
		   <aui:input name="memFileId" value="<%=fileId%>" type="hidden"></aui:input>
          <aui:select name="emp_membership" label="01_membership" required="true" showRequiredLabel="false" inLineLabel="left">
            <aui:option  value="">--select--</aui:option>
            <%
              List<Membership> membershipList = MembershipLocalServiceUtil.getMemberships(-1,-1);
              Iterator iterator = membershipList.iterator();
              while(iterator.hasNext()){
            	  Membership membership = (Membership)iterator.next();
            %>
           <aui:option selected='<%=membership.getMembershipId()==membership1.getMembershipId()%>' value='<%=membership.getMembershipId() %>'><%=membership.getMembershipName() %></aui:option>
           <%} %>
          </aui:select>
          <aui:select name="subpaidby" label="01_subscription-paid-by">
                <aui:option value='<%=membership1.getSubscriptionPaidBy() %>'><%=membership1.getSubscriptionPaidBy() %></aui:option>
                <aui:option value="">--select--</aui:option>
				<aui:option value="Individual">Individual</aui:option>
				<aui:option value="Company">Company</aui:option>
		  </aui:select>
				<aui:input name="subamnt" label="01_subscription-amount" value="<%=membership1.getSubscriptionAmt() %>">
				  <aui:validator name="digits"/>
				</aui:input>
				<aui:select name="currency" label="01_currency">
				<aui:option value="">--select--</aui:option>
				  <%
				    List<PayGradeCurrency> currencyList = PayGradeCurrencyLocalServiceUtil.getPayGradeCurrencies(-1,-1);
				    Iterator itr = currencyList.iterator();
				    while(itr.hasNext()){
				    	PayGradeCurrency currency = (PayGradeCurrency)itr.next();
				    	
				   
				  %>
				  <aui:option selected='<%=currency.getCurrency().equalsIgnoreCase(membership1.getCurrency())%>' value="<%=currency.getCurrency() %>"><%=currency.getCurrency()%></aui:option>
				  <% } %>
				</aui:select>
				<aui:input name="subcommdate1" id="subcommdate1" label="01_sub-comm-date" placeholder="yyyy/mm/dd" value="<%=sdf.format(membership1.getCommenceDate())%>"></aui:input>
				<aui:input name="subrendate1" id="subrendate1" label="01_sub-renewal-date" placeholder="yyyy/mm/dd" value="<%=sdf.format(membership1.getRenewalDate())%>">
				  <aui:validator name="custom" errorMessage="Renewal date should be after commence date">
				     function(val,fieldNode,ruleValue){
				      var result=false;	
				      var renewalDate =val;
				      var renewalDateSplit = renewalDate.split("/");
    				  var renewalDateVal=renewalDateSplit[2];
					  var renewalMonth=renewalDateSplit[1];
					  var renewalYear=renewalDateSplit[0];
					  var commenceDate= A.one("#<portlet:namespace/>subcommdate").get('value');
					  var commenceDateSplit=commenceDate.split("/");
					  var commenceDate=commenceDateSplit[2];
					  var commenceMonth=commenceDateSplit[1];
					  var commenceYear=commenceDateSplit[0];
					    if(renewalYear>commenceYear){
					        result=true;
					        return result;
					        }
					       else if(renewalYear==commenceYear){
					    	
					    		if(renewalMonth>commenceMonth){
					    		   result=true;
					    		   return result;
					    		   }
					    		   else	if(renewalMonth==commenceMonth){
					    			
					    				if(renewalDateVal>=commenceDate){
					    					   result=true;
					    					   return result;
					    				   }else{
					    				      result=false;
					    				      return result;
					    				   }
					    			}
					    			else{
					    			  result=false;
					    			  return result;
					    			 }
					    	}
					        else{
					    	  result=false;
					    	  return result;
					    }	  															   
				   }
				</aui:validator>
				
				</aui:input>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="Save"
							id="submitMembershipDetails"></aui:button>
						<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
							id="cancelMembershipbtn" name="cancelMembershipbtn"></aui:button>
					</div>
				</div>
        </div>
      </aui:form>
   </div>

</div>
<%
	  }else{
		  Map empId = (Map) request.getSession(false).getAttribute("empId");
			long employeeId = (Long) empId.get("empId");
			String jsp = (String) empId.get("jsp");
			long fileEntryId=(Long)empId.get("fileId");
			DynamicQuery membershipDynamicQuery = 
					DynamicQueryFactoryUtil.forClass(EmpMembership.class,PortletClassLoaderUtil.getClassLoader());
			membershipDynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
			List<EmpMembership> empMembershipDetails = EmpMembershipLocalServiceUtil.dynamicQuery(membershipDynamicQuery);
			
%>
<div id="addEmpMembership" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_add-membership"/></h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmployeeMembership" id="addEmployeeMembership"
			action="<%=addMembershipURL%>" method="post">
			<div class="form-horizontal">
				<aui:input name="empMemId" value="<%=employeeId%>" type="hidden"></aui:input>
				<aui:input name="memFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
				<aui:select name="emp_membership" label="01_membership"
					inlineLabel="left" showRequiredLabel="false" required="true">
					<aui:option select="true" value="">--Select--</aui:option>
				<%
				List<Membership> membershipList = MembershipLocalServiceUtil
								.getMemberships(-1, -1);
						Iterator membershipList2 = membershipList.iterator();
						while (membershipList2.hasNext()) {
							Membership membership = (Membership) membershipList2
									.next();
				%>
				<aui:option  value="<%=membership.getMembershipId()%>"><%=membership.getMembershipName()%></aui:option>
				<%
				}
				%>
				</aui:select>
				<aui:select name="subpaidby" label="01_subscription-paid-by">
				<aui:option value="Individual">Individual</aui:option>
				<aui:option value="Company">Company</aui:option>
				</aui:select>
				<aui:input name="subamnt" label="01_subscription-amount">
				  <aui:validator name="digits"/>
				</aui:input>
				<aui:select name="currency" label="01_currency">
				   <aui:option value="">--select--</aui:option>
				  <%
				    List<PayGradeCurrency> currencyList = PayGradeCurrencyLocalServiceUtil.getPayGradeCurrencies(-1,-1);
				    Iterator itr = currencyList.iterator();
				    while(itr.hasNext()){
				    	PayGradeCurrency currency = (PayGradeCurrency)itr.next();
				    	
				   
				  %>
				  <aui:option value="<%=currency.getCurrency() %>" ><%=currency.getCurrency() %></aui:option>
				  <%} %>
				</aui:select>
				<aui:input name="subcommdate" id="subcommdate" label="01_sub-comm-date" placeholder="yyyy/mm/dd"></aui:input>
				<aui:input name="subrendate" id="subrendate" label="01_sub-renewal-date" placeholder="yyyy/mm/dd">
				   <aui:validator name="custom" errorMessage="Renewal date should be after commence date">
				     function(val,fieldNode,ruleValue){
				      var result=false;	
				      var renewalDate =val;
				      var renewalDateSplit = renewalDate.split("/");
    				  var renewalDateVal=renewalDateSplit[2];
					  var renewalMonth=renewalDateSplit[1];
					  var renewalYear=renewalDateSplit[0];
					  var commenceDate= A.one("#<portlet:namespace/>subcommdate").get('value');
					  var commenceDateSplit=commenceDate.split("/");
					  var commenceDate=commenceDateSplit[2];
					  var commenceMonth=commenceDateSplit[1];
					  var commenceYear=commenceDateSplit[0];
					    if(renewalYear>commenceYear){
					        result=true;
					        return result;
					        }
					       else if(renewalYear==commenceYear){
					    	
					    		if(renewalMonth>commenceMonth){
					    		   result=true;
					    		   return result;
					    		   }
					    		   else	if(renewalMonth==commenceMonth){
					    			
					    				if(renewalDateVal>=commenceDate){
					    				
					    					   result=true;
					    					   return result;
					    				   }else{
					    				      result=false;
					    				      return result;
					    				   }
					    			}
					    			else{
					    			  result=false;
					    			  return result;
					    			 }
					    	}
					        else{
					    	  result=false;
					    	  return result;
					    }	  															   
				   }
				</aui:validator>
				
				</aui:input>
				<div class="control-group">
					<div class="controls">
						<aui:button type="submit" cssClass="button btn-primary" value="Save"
							id="submitMembershipDetails"></aui:button>
						<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
							id="cancelMembership" name="cancelMembership"></aui:button>
					</div>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<div id="empMembershipAddDelete" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_membership"/></h3>
	</div>
	<div class="panel-body">
		<div class="control-group">
			<aui:button id="empMembershipAdd" name="empMembershipAdd" value="Add" cssClass="button btn-primary"></aui:button>
			<aui:button id="empMembershipDelete" value="Delete" name="empMembershipDelete" cssClass="button btn-danger"></aui:button>
		</div>
	</div>

  <liferay-portlet:renderURL varImpl ="empMemURL">
   <portlet:param name="jsp" value="jsp8"/>
   <portlet:param name="empId" value="<%=String.valueOf(employeeId)%>"/>
   <portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>
  </liferay-portlet:renderURL>
 
  <liferay-ui:search-container   deltaConfigurable="true" delta ="5"
                               rowChecker ="<%=new RowChecker(renderResponse) %>" iteratorURL="<%=empMemURL%>" emptyResultsMessage ="No records are available for Memberships">
                              
   <liferay-ui:search-container-results>
         <%
            List<EmpMembership> membershipDetails = empMembershipDetails;
            results = ListUtil.subList(membershipDetails,searchContainer.getStart(),searchContainer.getEnd());
            pageContext.setAttribute("results", results);
            pageContext.setAttribute("total",total);
         %>
   </liferay-ui:search-container-results>                           
   <liferay-ui:search-container-row className="EmpMembership" keyProperty="empMembershipId" modelVar="empMemId"
                     rowVar="curRow" >
      <liferay-portlet:renderURL varImpl="empEditURL">
         <portlet:param name="empMembershipId" value="<%=String.valueOf(empMemId.getEmpMembershipId()) %>"/>
         <portlet:param name="jsp" value="jsp8"/>
         <portlet:param name="empId" value="<%=String.valueOf(employeeId)%>"/>
         <portlet:param name="fileId" value="<%=String.valueOf(fileEntryId) %>"/>  
      </liferay-portlet:renderURL>
        <%
				List<Membership> membershipList = MembershipLocalServiceUtil
								.getMemberships(-1, -1);
						Iterator membershipList2 = membershipList.iterator();
						while (membershipList2.hasNext()) {
							Membership membership = (Membership) membershipList2
									.next();
							if(empMemId.getMembershipId()==membership.getMembershipId()){
		%>            
        
        <liferay-ui:search-container-column-text name="Membership" value="<%=membership.getMembershipName()%>"  href="<%=empEditURL%>"/>
        <%
							}
						}
        %>
        <liferay-ui:search-container-column-text name="Subscription Paid By" property="subscriptionPaidBy"/>
        <liferay-ui:search-container-column-text name="Subscription Amount" property="subscriptionAmt"/>
        <liferay-ui:search-container-column-text name="Currency" property="currency"/>
        <liferay-ui:search-container-column-text name="Subscription Commence Date" value='<%= empMemId.getCommenceDate()!=null?sdf.format(empMemId.getCommenceDate()):"" %>'/>
        <liferay-ui:search-container-column-text name="Subscription Renewal Date" value='<%=empMemId.getRenewalDate()!=null?sdf.format(empMemId.getRenewalDate()):"" %>'/>
        
   </liferay-ui:search-container-row>
   <liferay-ui:search-iterator/>
  </liferay-ui:search-container>
 
</div>
<%
}
%>
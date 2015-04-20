<!--code @vinay-->

<%@ include file="/html/documents/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<portlet:actionURL name="saveDocuments" var="editsaveDocumentsURL">
  <portlet:param name="saveid" value="save"></portlet:param>
</portlet:actionURL>
<portlet:actionURL name="saveDocuments" var="editpublishDocumentsURL">
  <portlet:param name="saveid" value="publish"></portlet:param>
</portlet:actionURL>
<aui:script>

 function publishForm(){
  
	 document.getElementById('<portlet:namespace/>myForm').action='<%=editpublishDocumentsURL.toString()%>';
	 
 }


 AUI().use('aui-datepicker',function(A){
	new A.DatePicker(
			{
	        trigger: '#<portlet:namespace/>published_date',
	        mask:'%Y/%m/%d',
	        popover:{
	        	zIndex: 1
	        },
	        on:{
	        	selectionChange: function(event){
	        		console.log(event.newSelection)
	        	}
	        }
		}
	);
 })
 
 function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString("default content") %>"; }
 
 function saveForm(){
	 document.getElementById('<portlet:namespace/>myForm').action='<%= editsaveDocumentsURL.toString()%>';
	 
 }
  AUI().ready('event', 'node','transition',function(A){
setTimeout(function(){
A.one('#publishdocumentMessage').transition('fadeOut');
A.one('#publishdocumentMessage').hide();
},2000)

});

</aui:script>
 <% 
if(SessionMessages.contains(renderRequest.getPortletSession(),"documents-publish-error")){%>
<p id="publishdocumentMessage" class="alert alert-error"><liferay-ui:message key="Please Select atleast one checkbox to Publish"/></p>
<%}%>
<div class="panel">
				<div class="panel-heading">
					<h4>Add Documents</h4>
				</div>
				<div class="panel-body">
<aui:form id="myForm" name="myForm">
 <aui:input name="documentId" type="hidden" id="documentId"></aui:input>
<div class="row-fluid">
<div class="span2"><label>Topic:</label> </div>
<div class ="span3">
 <aui:input name="topic_name" type="text" label=""  showRequiredLabel="false">
  <aui:validator name="required"/>
 </aui:input>
 </div>
 <div class="span7"></div>
  </div>

 <div class="row-fluid">
<div class="span2"><label>Category:</label> </div>
<div class="span3">
  <aui:select  name="category_name" label="" required="true" showRequiredLabel="false">
   
       <aui:option value="" selected="true">Select</aui:option>  
      <%
      List<DocumentCategories> documents= DocumentCategoriesLocalServiceUtil.getDocumentCategorieses(-1,-1);
      Iterator itr= documents.iterator();  
      while(itr.hasNext()){
    	  DocumentCategories document= (DocumentCategories) itr.next();
    %>
        <aui:option value="<%=document.getDocumentCategory() %>"><%=document.getDocumentCategory() %></aui:option>
    <%
      }
    %>
       
  </aui:select>
  </div>
  <div class="span7"></div>
  </div>
  <div class="row-fluid">
<div class="span2"><label>Description:</label> </div>
<div class ="span8">
<aui:field-wrapper label="">
    <liferay-ui:input-editor name="descriptionEditor" toolbarSet="liferay-article" initMethod="initEditor" width="200" />
   
</aui:field-wrapper>
 </div>
 <div class="span4"></div>
 </div>
 <div class="row-fluid">
<div class="span2"><label>Published Date:</label> </div>
<div class ="span3">
  <aui:input name="published_date" placeholder="yyyy/mm/dd" label="" showRequiredLabel="false">
   <aui:validator name="required"/>
  </aui:input>
</div>
<div class = "span7"></div>
</div>
 <div class="row-fluid">
<div class="span2"><label>Published To:</label> </div>
<div class ="span3">
<aui:input  type="checkbox" name="admin" label="Admin">

</aui:input>
</div>
<div class="span3">
<aui:input type="checkbox" name="supervisor" label="Supervisor"/>
</div>
<div class="span4">
<aui:input type="checkbox" name="allemps" label="All Employees"/>
</div>
</div>
 <div class="row-fluid">
 <div class="span2"></div>
 <div class="span3">
<aui:input  type="checkbox" name="one" label="" hidden="true"/>
 </div>
 <div class="span3"></div>
 <div class="span4"></div>
 </div>
 <br/>
  <aui:button id="saveid"  type="submit" value="save" onClick="saveForm()"/>
  <aui:button id="publishid" type="submit" value="publish" onClick="publishForm()"/>
  </aui:form>
  </div>


</div>


<!--code @vinay-->

<%@page import="com.rknowsys.eapp.hrm.service.DocumentsAttachmentsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.rknowsys.eapp.hrm.model.DocumentsAttachments"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/html/documents/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<theme:defineObjects/>
<portlet:actionURL name="updateDocuments" var="updatesaveDocumentsURL">
  <portlet:param name="saveid" value="save"></portlet:param>
</portlet:actionURL>
<portlet:actionURL name="updateDocuments" var="updatepublishDocumentsURL">
  <portlet:param name="saveid" value="publish"></portlet:param>
</portlet:actionURL>
<portlet:actionURL name="documentAttachments" var="documentattachments">
</portlet:actionURL>
<portlet:resourceURL var="deleteAttachment" id="deleteAttachment"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/documents/editdocuments.jsp" />
</portlet:renderURL>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#deleteattachment');
    node.on(
      'click',
      function() {
     var idArray = [];
     var totalrecords = A.one('#_Documents_WAR_Documentsportlet_documentsAttachmentsesSearchContainerPrimaryKeys').get('value');
       A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
     });
       if(totalrecords==""){
			  alert("No records to delete");
		  }
		 else if(idArray=="" && totalrecords!=""){
		  
		   alert("Please select records!")
		 
		 }
		 else{
			  var d = confirm("Are you sure you want to delete the selected record ?");
		  if(d){
		   var url = '<%=deleteAttachment%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />attachmentIds: idArray,  
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

 function saveForm(){
	 document.getElementById('<portlet:namespace/>myForm').action='<%= updatesaveDocumentsURL.toString()%>';
	
 }
 
 function publishForm(){
	 document.getElementById('<portlet:namespace/>myForm').action='<%=updatepublishDocumentsURL.toString()%>';
	 
 }
 AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#addattachment');
    node.on(
      'click',
      function() {
         A.one('#attachmentAddDelete').hide();
         A.one('#addAttachmentForm').show();
         
                     
      }
    );
  }
);
  AUI().ready('event', 'node',function(A){
 A.one('#addAttachmentForm').hide();
});
 AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#<portlet:namespace/>cancelattachment');
    node.on(
      'click',
      function() {
         A.one('#addAttachmentForm').hide();
         A.one('#attachmentAddDelete').show();
        
                     
      }
    );
  }
);
</aui:script>
 <%!public String humanReadableByteCount(double bytes, boolean si) {
		int unit = si ? 1000 : 1024;
		if (bytes < unit)
			return bytes + " B";
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1)
				+ (si ? "" : "i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}%>
 <% 
Documents editDocument = (Documents)portletSession.getAttribute("editDocument");
DocumentsAttachments attachments = (DocumentsAttachments)portletSession.getAttribute("editAttachment");
String attachmentFormType = (String)portletSession.getAttribute("editattachmentform");
String formtype = "editattachmentform";
System.out.println("attachmentFormType === "+attachmentFormType);
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
 
%>
<portlet:actionURL name="redirectToAdd" var="redirectToAdd">
 <portlet:param name="documentId" value="<%= String.valueOf(editDocument.getDocumentId()) %>"></portlet:param>
</portlet:actionURL> 
 
<div class="panel">
				<div class="panel-heading">
					<h4>Edit Documents</h4>
				</div>
				<div class="panel-body">
<aui:form id="myForm" name="myForm">
 <aui:input name="documentId" type="hidden" id="documentId" value="<%=editDocument.getDocumentId() %>"></aui:input>
<div class="row-fluid">
<div class="span2"><label>Topic:</label> </div>
<div class ="span3">
 <aui:input name="topic_name" type="text" label=""  value="<%=editDocument.getTopic() %>" showRequiredLabel="false">
  <aui:validator name="required"/>
 </aui:input>
 </div>
 <div class="span7"></div>
  </div>

 <div class="row-fluid">
<div class="span2"><label>Category:</label> </div>
<div class="span3">

<aui:select name="category_name" label="" required="true" showRequiredLabel="false">
						<%
							if (editDocument.getCategory().equals("")) {
						%>
						<aui:option selected="true" value="0">--Select--</aui:option>
						<%
							} else {
						%>
						<aui:option value="0">--Select--</aui:option>
						<aui:option selected="true" value="<%=editDocument.getCategory()%>"><%=editDocument.getCategory()%></aui:option>
						<%
							}
						List<DocumentCategories> documents= DocumentCategoriesLocalServiceUtil.getDocumentCategorieses(-1,-1);
					      Iterator itr= documents.iterator();  
					      while(itr.hasNext()){
					    	  DocumentCategories document= (DocumentCategories) itr.next();
						%>
						<%
							if (!editDocument.getCategory().equalsIgnoreCase(document.getDocumentCategory())) {
						%>
						<aui:option value="<%=document.getDocumentCategory()%>"><%=document.getDocumentCategory()%></aui:option>
						<%
							}
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
    <liferay-ui:input-editor name="descriptionEditor"  toolbarSet="liferay" initMethod="initEditor" width="200">
    </liferay-ui:input-editor>
<script type="text/javascript">
        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(editDocument.getDescription()) %>"; }
    </script>
    
</aui:field-wrapper>
 </div>
 <div class="span4"></div>
 </div>
 <div class="row-fluid">
<div class="span2"><label>Published Date:</label> </div>
<div class ="span3">
  <aui:input name="published_date" placeholder="yyyy/mm/dd" label="" value="<%=sdf.format(editDocument.getPublishDate()) %>" showRequiredLabel="false">
   <aui:validator name="required"/>
  </aui:input>
</div>
<div class = "span7"></div>
</div>
 <div class="row-fluid">
<div class="span2"><label>Published To:</label> </div>
<div class ="span3">
<aui:input type="checkbox" name="admin" label="Admin" value="<%=editDocument.getAdmin() %>" />
</div>
<div class="span3">
<aui:input type="checkbox" name="supervisor" label="Supervisor" value="<%=editDocument.getSupervisor() %>" />
</div>
<div class="span4">
<aui:input type="checkbox" name="allemps" label="All Employees" value="<%=editDocument.getAllEmployees() %>" />
</div>
</div>
 
 <br/>
<%
      boolean b = editDocument.getStatus();
      if(b){
%>
 <aui:button type="submit" value="save" onClick="publishForm()"/>
 <aui:button type="submit" value="publish" onClick="publishForm()"/>
<%
      }
      else {
%>
 <aui:button type="submit" value="save" onClick="saveForm()"/>
 <aui:button type="submit" value="publish" onClick="publishForm()"/>
 <%} %>


</aui:form>
</div></div>
<br/><br/>

<div class="panel">
				<div class="panel-heading">
					<h4>Attachments</h4>
				</div>
				<div class="panel-body">
				<div class="row-fluid">
		  <aui:form action="<%=documentattachments%>" enctype="multipart/form-data">
		        <%
		        if(formtype.equalsIgnoreCase(attachmentFormType)){
		        	
    %> 		
          <div class="row-fluid">
         
           <aui:input name="documentId" type="hidden"  value='<%=editDocument.getDocumentId() %>'></aui:input>
				<aui:input name="documentAttachmentId" type="hidden" value="<%=attachments.getDocumentAttachmentId()%>"></aui:input>
				<label>Replace the file <b><%=attachments.getFileName()%></b> with New file.</label>
				<br/>
				<aui:input name="documentAttachment" type="file" showRequiredLabel="false" label="Select File" inlineLabel="left">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:input name="description" type="textarea" label="Description" value="<%=attachments.getDescription()%>" inlineLabel="left"></aui:input>
            <aui:button type="submit" value="Upload" cssClass="button btn-primary"></aui:button>
			<aui:button type="reset" value="Cancel" id="cancelattachment" name="cancelattachment" onClick="<%=redirectToAdd%>" cssClass="button btn-danger"></aui:button>
	      </div>
			 <%
		        }
		        else{
       
    %>		<div class="row-fluid">	
		<div id="attachmentAddDelete" class="span12 text-right">
				<div class="control-group">
			<aui:button type="button" value="Add" id="addattachment" name="" class="btn btn-primary"></aui:button>
			<aui:button type="button" value="Delete" id="deleteattachment" name="" class="btn btn-danger"></aui:button>
			</div>
			</div>	
				<div id="addAttachmentForm">
				
				<aui:input name="documentId" type="hidden"  value='<%=editDocument.getDocumentId() %>'></aui:input>
				<aui:input name="documentAttachment" type="file" showRequiredLabel="false" label="Select File" inlineLabel="left">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				
				<aui:input name="description" type="textarea" label="Description" inlineLabel="left"></aui:input>

				<aui:button type="submit" value="Upload" cssClass="button btn-primary"></aui:button>
			<aui:button type="reset" value="Cancel" id="cancelattachment" name="cancelattachment"
				cssClass="button btn-danger"></aui:button>
				
				</div>
			</div>	
				 <%
		        }
       
    %>
    </aui:form>
    </div>
	<br/>
	
	
	
	<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/documents/editdocuments.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

 

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<DocumentsAttachments> searchContainer;
%>
<div>
<liferay-ui:search-container 
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	displayTerms="<%= new DisplayTerms(renderRequest) %>"
	emptyResultsMessage="No Attachments are available for Documents"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

    <%
    long groupId=themeDisplay.getLayout().getGroup().getGroupId();
    long documentId = editDocument.getDocumentId();
    DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DocumentsAttachments.class);
    dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId ));
    dynamicQuery.add(RestrictionsFactoryUtil.eq("documentId", documentId));
    List<DocumentsAttachments> list= DocumentsAttachmentsLocalServiceUtil.dynamicQuery(dynamicQuery);
  
        
            if(list.size()>5){
	    results=ListUtil.subList(list, searchContainer.getStart(), searchContainer.getEnd());
            }
            else{
             results = list;	
            }
		total = list.size(); 
		
	  	pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
    
	%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="DocumentsAttachments"
		keyProperty="documentAttachmentId" modelVar="DocumentsAttachments" rowVar="curRow"
		escapedModel="<%= true %>">
		
		<liferay-ui:search-container-column-text name="File Name" property="fileName"/>
	    <liferay-ui:search-container-column-text name="Description" property="description"/>
		<liferay-ui:search-container-column-text name="Size" value='<%=humanReadableByteCount(DocumentsAttachments.getFileSize(), true) %>'/>
	    <liferay-ui:search-container-column-text name="Type" property="fileType"/>
	    <liferay-ui:search-container-column-text name="Date Added" property="createDate"/>
	    <liferay-ui:search-container-column-jsp name="Edit"	path="/html/documents/editClickAttachment.jsp" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

			</div>
	
	</div></div>

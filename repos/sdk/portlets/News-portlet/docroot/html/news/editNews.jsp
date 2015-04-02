<%@page import="com.rknowsys.eapp.hrm.service.NewsAttachmentsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.NewsAttachments"%>
<%@page import="com.rknowsys.eapp.hrm.model.News"%>
<%@page import="com.rknowsys.eapp.hrm.service.DocumentsAttachmentsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.rknowsys.eapp.hrm.model.DocumentsAttachments"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/html/news/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<theme:defineObjects/>
<portlet:actionURL name="updateNews" var="updatesaveNewsURL">
  <portlet:param name="saveid" value="save"></portlet:param>
</portlet:actionURL>
<portlet:actionURL name="updateNews" var="updatepublishNewsURL">
  <portlet:param name="saveid" value="publish"></portlet:param>
</portlet:actionURL>
<portlet:actionURL name="saveNewsAttachments" var="newsattachments">
</portlet:actionURL>
<portlet:resourceURL var="deleteAttachment" id="deleteAttachment"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/news/editNews.jsp" />
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
     var totalrecords = A.one('#_News_WAR_Newsportlet_newsAttachmentsesSearchContainerPrimaryKeys').get('value');
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
			  var d = confirm("Are you sure you want to delete the selected records ?");
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
	 document.getElementById('<portlet:namespace/>myForm').action='<%= updatesaveNewsURL.toString()%>';
	
 }
 
 function publishForm(){
	 document.getElementById('<portlet:namespace/>myForm').action='<%=updatepublishNewsURL.toString()%>';
	 
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

News editNews = (News)portletSession.getAttribute("editNews");
NewsAttachments newsAttachments = (NewsAttachments)portletSession.getAttribute("editNewsAttachment");
String attachmentFormType = (String)portletSession.getAttribute("editnewsattachmentform");
String formtype = "editnewsattachmentform";
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
 
%>
<portlet:actionURL name="redirectToAdd" var="redirectToAdd">
 <portlet:param name="newsId" value="<%= String.valueOf(editNews.getNewsId()) %>"></portlet:param>
</portlet:actionURL> 
 
<div class="panel">
				<div class="panel-heading">
					<h4>Edit News</h4>
				</div>
				<div class="panel-body">
<aui:form id="myForm" name="myForm">
 <aui:input name="newsId" type="hidden" id="newsId" value="<%=editNews.getNewsId() %>"></aui:input>
<div class="row-fluid">
<div class="span2"><label>Topic:</label> </div>
<div class ="span3">
 <aui:input name="topic_name" type="text" label=""  value="<%=editNews.getTopic() %>" showRequiredLabel="false">
  <aui:validator name="required"/>
 </aui:input>
 </div>
 <div class="span7"></div>
  </div>

 <div class="row-fluid">
<div class="span2"></div>
<div class="span3">

  </div>
  <div class="span7"></div>
  </div>
  <div class="row-fluid">
<div class="span2"><label>Description:</label> </div>
<div class ="span8">
<aui:field-wrapper label="">
    <liferay-ui:input-editor name="descriptionEditor"  toolbarSet="liferay-article" initMethod="initEditor" width="200">
    </liferay-ui:input-editor>
<script type="text/javascript">
        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(editNews.getDescription()) %>"; }
    </script>
    
</aui:field-wrapper>
 </div>
 <div class="span4"></div>
 </div>
 <div class="row-fluid">
<div class="span2"><label>Published Date:</label> </div>
<div class ="span3">
  <aui:input name="published_date" placeholder="yyyy/mm/dd" label="" value="<%=sdf.format(editNews.getPublishDate()) %>" showRequiredLabel="false">
   <aui:validator name="required"/>
  </aui:input>
</div>
<div class = "span7"></div>
</div>
 <div class="row-fluid">
<div class="span2"><label>Published To:</label> </div>
<div class ="span3">
<aui:input type="checkbox" name="admin" label="Admin" value="<%=editNews.getAdmin() %>" />
</div>
<div class="span3">
<aui:input type="checkbox" name="supervisor" label="Supervisor" value="<%=editNews.getSupervisor() %>" />
</div>
<div class="span4">
<aui:input type="checkbox" name="allemps" label="All Employees" value="<%=editNews.getAllEmployees() %>" />
</div>
</div>
 
 <br/>
<%
      boolean b = editNews.getStatus();
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
		  <aui:form action="<%=newsattachments%>" enctype="multipart/form-data">
		        <%
		        if(formtype.equalsIgnoreCase(attachmentFormType)){
		        	
    %> 		
          <div class="row-fluid">
         
           <aui:input name="newsId" type="hidden"  value='<%=editNews.getNewsId() %>'></aui:input>
				<aui:input name="newsAttachmentId" type="hidden" value="<%=newsAttachments.getNewsAttachmentId()%>"></aui:input>
				<label>Replace the file <b><%=newsAttachments.getFileName()%></b> with New file.</label>
				<br/>
				<aui:input name="newsAttachment" type="file" showRequiredLabel="false" label="Select File" inlineLabel="left">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				<aui:input name="newsDescription" type="textarea" label="Description" value="<%=newsAttachments.getDescription()%>" inlineLabel="left"></aui:input>
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
				
				<aui:input name="newsId" type="hidden"  value='<%=editNews.getNewsId() %>'></aui:input>
				<aui:input name="newsAttachment" type="file" showRequiredLabel="false" label="Select File" inlineLabel="left">
				<aui:validator name="required"></aui:validator>
				</aui:input>
				
				<aui:input name="newsDescription" type="textarea" label="Description" inlineLabel="left"></aui:input>

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
iteratorURL.setParameter("mvcPath", "/html/news/editNews.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

 

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<NewsAttachments> searchContainer;
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
    long newsId = editNews.getNewsId();
    DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(NewsAttachments.class);
    dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId ));
    dynamicQuery.add(RestrictionsFactoryUtil.eq("newsId", newsId));
    List<NewsAttachments> list= NewsAttachmentsLocalServiceUtil.dynamicQuery(dynamicQuery);
  
        
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
	<liferay-ui:search-container-row className="NewsAttachments"
		keyProperty="newsAttachmentId" modelVar="NewsAttachments" rowVar="curRow"
		escapedModel="<%= true %>">
		
		<liferay-ui:search-container-column-text name="File Name" property="fileName"/>
	    <liferay-ui:search-container-column-text name="Description" property="description"/>
		<liferay-ui:search-container-column-text name="Size" value='<%=humanReadableByteCount(NewsAttachments.getFileSize(), true) %>'/>
	    <liferay-ui:search-container-column-text name="Type" property="fileType"/>
	    <liferay-ui:search-container-column-text name="Date Added" property="createDate"/>
	    <liferay-ui:search-container-column-jsp name="Edit"	path="/html/news/editClickAttachment.jsp" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

			</div>
	
	</div></div>

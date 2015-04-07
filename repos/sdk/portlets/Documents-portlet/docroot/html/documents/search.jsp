<%@ include file="/html/documents/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<theme:defineObjects/>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<portlet:renderURL var="addURL">
 <portlet:param name="jspPage" value="/html/documents/adddocuments.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/documents/search.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editURL">
 <portlet:param name="jspPage" value="/html/documents/editdocuments.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="deleteDocuments" id="deleteDocument"></portlet:resourceURL>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#deletedocuments');
    node.on(
      'click',
      function() {
     var idArray = [];
      var totalrecords = A.one('#_Documents_WAR_Documentsportlet_documentsesSearchContainerPrimaryKeys').get('value');
    A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
   
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected documents ?");
		  if(d){
		   var url = '<%=deleteDocuments%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />documentIds: idArray,  
                 },
          on: {
               success: function() { 
                   
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
<div class="panel">
				<div class="panel-heading">
					<h4>Documents</h4>
				</div>
				<div class="panel-body">
<aui:form name="myForm" action="<%=listview %>" >
 <div class="row-fluid">
			<div class="span4">
				<aui:input name="topic" label="Topic"></aui:input>

			</div>
			<div class="span4">
				<aui:select name="status" label="Status">
     <aui:option value="" selected="true">--select--</aui:option>
     <aui:option value="0">Saved</aui:option>
     
     <aui:option value="1">Published</aui:option>
   </aui:select>
			</div>
			<div class="span4">
					<aui:select name="Category" label="Category">
     <aui:option value="" selected="true">--select--</aui:option>
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
		</div>
   <aui:button type="submit" value="Search"></aui:button>
</aui:form>
</div></div>
<div class="panel">
				<div class="panel-body">
<div class="row-fluid">
    <aui:button type="button" cssClass="btn btn-success" value="Add" onClick="<%=addURL.toString()%>" ></aui:button>
    <aui:button id="deletedocuments" cssClass="btn btn-danger" type="button" value="Delete" ></aui:button>
    
</div>
<br/>

 <%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/documents/search.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

 

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Documents> searchContainer;
%>
<div>
<liferay-ui:search-container 
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	displayTerms="<%= new DisplayTerms(renderRequest) %>"
	emptyResultsMessage="No records are available for Documents"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

    <%
    long layoutGroupId=themeDisplay.getLayout().getGroup().getGroupId();
	DisplayTerms displayTerms =searchContainer.getDisplayTerms();
    
		String topicname=ParamUtil.getString(renderRequest,"topic");
		
        String Category=ParamUtil.getString(renderRequest,"Category");
        String status=ParamUtil.getString(renderRequest,"status");
      
        List<Documents> documentDetailsList = new ArrayList<Documents>();
       
        try{
        	documentDetailsList= DocumentsLocalServiceUtil.findDocumentsDetails(topicname, Category, status, -1, -1);
        
        		
		List<Documents> documentsList=new ArrayList();
		Iterator<Documents> i=documentDetailsList.iterator();
		while(i.hasNext())
		{
		
			Documents document=i.next();
			documentsList.add(document);
		}
	    results=ListUtil.subList(documentsList, searchContainer.getStart(), searchContainer.getEnd());
		total = documentsList.size(); 
		
	  	pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
      }catch(Exception e){
    	  e.printStackTrace();
      }
	%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Documents"
		keyProperty="documentId" modelVar="documentObject" rowVar="curRow"
		escapedModel="<%= true %>">
		
		<liferay-ui:search-container-column-text 
			name="Category" property="category"/>
	    <liferay-ui:search-container-column-text
	        name="Topic" property="topic"/>
		<liferay-ui:search-container-column-text 
			name="PublishedTo" value='<%=documentObject.getAdmin()==true && documentObject.getAllEmployees()==true && documentObject.getSupervisor()==true ?
					"Admin,Supervisor,All Employees":documentObject.getAdmin()==true && documentObject.getAllEmployees()==true?"Admin,All Employees":
					documentObject.getAdmin()==true && documentObject.getSupervisor()==true?"Admin,Supervisor":documentObject.getSupervisor()==true &&
					documentObject.getAllEmployees()==true ? "Supervisor,All Employees":documentObject.getAdmin()==true?"Admin":documentObject.getSupervisor()
					==true?"Supervisor":documentObject.getAllEmployees()==true?"All Employees":"-" %>'/>
	    <liferay-ui:search-container-column-text 
			name="Status" value='<%=documentObject.getStatus()==true ?"published":"saved"%>'/>
	 <liferay-ui:search-container-column-jsp name="Edit"
			path="/html/documents/editClick.jsp" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

</div></div></div>
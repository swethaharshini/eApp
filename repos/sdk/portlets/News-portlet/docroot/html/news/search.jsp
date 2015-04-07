<%@page import="com.rknowsys.eapp.hrm.service.NewsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.News"%>
<%@ include file="/html/news/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<theme:defineObjects/>
<portlet:renderURL var="addURL">
 <portlet:param name="jspPage" value="/html/news/addNews.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/news/search.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editURL">
 <portlet:param name="jspPage" value="/html/news/editNews.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="deleteNews" id="deleteNews"></portlet:resourceURL>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#deletenews');
    node.on(
      'click',
      function() {
     var idArray = [];
      var totalrecords = A.one('#_News_WAR_Newsportlet_newsesSearchContainerPrimaryKeys').get('value');
    A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
   
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected records ?");
		  if(d){
		   var url = '<%=deleteNews%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />newsIds: idArray,  
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
					<h4>News</h4>
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
					
			</div>
		</div>
   <aui:button type="submit" value="Search"></aui:button>
</aui:form>
</div></div>
<div class="panel">
				<div class="panel-body">
<div class="row-fluid">
    <aui:button type="button" cssClass="btn btn-success" value="Add" onClick="<%=addURL.toString()%>" ></aui:button>
    <aui:button id="deletenews" cssClass="btn btn-danger" type="button" value="Delete" ></aui:button>
    
</div>
<br/>

 <%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/news/search.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

 

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<News> searchContainer;
%>
<div>
<liferay-ui:search-container 
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	displayTerms="<%= new DisplayTerms(renderRequest) %>"
	emptyResultsMessage="No records are available for News"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
	
	<%
		long groupId=themeDisplay.getLayout().getGroup().getGroupId();
		System.out.println("groupId in jsp == "+groupId);
		DisplayTerms displayTerms =searchContainer.getDisplayTerms();
		String topicname=ParamUtil.getString(renderRequest,"topic");
	    String status=ParamUtil.getString(renderRequest,"status");
	    System.out.println("topicName == " +topicname);
	    System.out.println("status == " +status);
	    List<News> newslist = new ArrayList<News>();
	    try{
		newslist = NewsLocalServiceUtil.findNewsDetails(topicname, status, groupId, -1, -1);
	    
	    }
	    catch(Exception e){
	    	System.out.println(e);
	    }
	    System.out.println("list size === "+newslist.size());
	    results=ListUtil.subList(newslist, searchContainer.getStart(), searchContainer.getEnd());
		total = newslist.size(); 
	  	pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="News"
		keyProperty="newsId" modelVar="news" rowVar="curRow"
		escapedModel="<%= true %>">
		
	    <liferay-ui:search-container-column-text
	        name="Topic" property="topic"/>
		<liferay-ui:search-container-column-text 
			name="PublishedTo" value='<%=news.getAdmin()==true && news.getAllEmployees()==true && news.getSupervisor()==true ?
					"Admin,Supervisor,All Employees":news.getAdmin()==true && news.getAllEmployees()==true?"Admin,All Employees":
					news.getAdmin()==true && news.getSupervisor()==true?"Admin,Supervisor":news.getSupervisor()==true &&
					news.getAllEmployees()==true ? "Supervisor,All Employees":news.getAdmin()==true?"Admin":news.getSupervisor()
					==true?"Supervisor":news.getAllEmployees()==true?"All Employees":"-" %>'/>
	    <liferay-ui:search-container-column-text 
			name="Status" value='<%=news.getStatus()==true ?"published":"saved"%>'/>
	 <liferay-ui:search-container-column-jsp name="Edit"
			path="/html/news/editClick.jsp" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

</div></div></div>
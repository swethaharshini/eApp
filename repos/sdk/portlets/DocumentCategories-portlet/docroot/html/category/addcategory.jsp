<%@page import="com.rknowsys.eapp.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@ include file="/html/category/init.jsp"%>


<portlet:actionURL var="saveCategories" name="saveCategory">
</portlet:actionURL>
<portlet:resourceURL var="deleteCategories" id="deleteCategory"></portlet:resourceURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/category/addcategory.jsp" />
</portlet:renderURL>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#categorydelete');
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
			  var d = confirm("Are you sure you want to delete the selected categories ?");
		  if(d){
		   var url = '<%=deleteCategories%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />categoryIds: idArray,  
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
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#categoryadd');
    node.on(
      'click',
      function() {
         A.one('#categoryAddDelete').hide();
         A.one('#addCategoryForm').show();
         A.one('#categoryName').focus();
                     
      }
    );
  }
);

 AUI().ready('event', 'node','transition',function(A){
  A.one('#addCategoryForm').hide();
  setTimeout(function(){
    A.one('#addCategoryMessage').transition('fadeOut');
     A.one('#addCategoryMessage').hide();
},2000)
 });


AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#categorycancel');
    node.on(
      'click',
      function() {
         A.one('#categoryAddDelete').show();
         A.one('#addCategoryForm').hide();
                     
      }
    );
  }
);

</aui:script>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"categoryName-empty-error")){%>
<p id="addCategoryMessage" class="alert alert-error"><liferay-ui:message key="Please Enter CategoryName"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"categoryName-duplicate-error")){
%>
<p id="addCategoryMessage" class="alert alert-error"><liferay-ui:message key="CategoryName already Exits"/></p>
<%} 
if(SessionMessages.contains(renderRequest.getPortletSession(),"categoryName-add-msg")){
%>
<p id="addCategoryMessage" class="alert alert-success"><liferay-ui:message key="CategoryName added successfully"/></p>
<%} 
if(SessionMessages.contains(renderRequest.getPortletSession(),"categoryName-updated-msg")){
%>
<p id="addCategoryMessage" class="alert alert-success"><liferay-ui:message key="CategoryName updated successfully"/></p>
<%} 
%>

 <div class="row-fluid">
		<div id="categoryAddDelete" class="span12 text-right">
			<div class="control-group">
				<a href="#" class="btn btn-primary" id="categoryadd"><i class="icon-plus"></i> Add</a>
				<a href="#" class="btn btn-danger" id="categorydelete"><i class="icon-trash"></i> Delete</a>
			</div>
		</div>
		<div  id="addCategoryForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Add</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=saveCategories.toString()%>" >
						<aui:input name="documentcategoryId" type="hidden" id="documentcategoryId" />
						<div class="form-inline">
							<label>Category Name: </label>
							<input name="<portlet:namespace/>category_name" id="categoryName" type="text">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="categorycancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>

	
	
	
<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/category/addcategory.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType");
System.out.println("sortByCol == " +sortByCol);
System.out.println("sortByType == "+sortByType);

if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	
 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
 
	
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}

long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery categoryDynamicQuery = DynamicQueryFactoryUtil.forClass(DocumentCategories.class,PortletClassLoaderUtil.getClassLoader());
categoryDynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
List<DocumentCategories> categoryDetails = DocumentCategoriesLocalServiceUtil.dynamicQuery(categoryDynamicQuery);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<DocumentCategories> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for Categories"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<% 
		
            List<DocumentCategories> categoryList = ListUtil.subList(categoryDetails, searchContainer.getStart(), searchContainer.getEnd());;
		 
		OrderByComparator orderByComparator =  CustomComparatorUtil.getDocumentCategoryOrderByComparator(sortByCol, sortByType);
		   
        Collections.sort(categoryList,orderByComparator);
		    
		  if(categoryDetails.size()>5){
			  results = categoryList;
		  }else{
		        results = categoryDetails;
		  }
		      
               total = categoryDetails.size();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="DocumentCategories"
		keyProperty="documentcategoryId" modelVar="documentcategoryId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="Document Category" property="documentCategory"
			orderableProperty="documentCategory" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/category/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>
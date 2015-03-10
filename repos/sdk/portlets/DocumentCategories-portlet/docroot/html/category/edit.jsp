<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.rknowsys.eapp.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@ include file="/html/category/init.jsp" %>
<portlet:actionURL var="updateCategories" name="updateCategory">
</portlet:actionURL>
<portlet:resourceURL var="deleteCategories" id="deleteCategory"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/category/addcategory.jsp" />
</portlet:renderURL>
<aui:script>

 AUI().ready('event', 'node','transition',function(A){
  A.one('#categoryName').focus();
  setTimeout(function(){
    A.one('#editCategoryMessage').transition('fadeOut');
},2000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#categorycancel');
    node.on(
      'click',
      function() {
      	 window.location='<%=listview%>';
          
      }
    );																																
  }
);

</aui:script>



</head>
<body>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"categoryName-empty-error")){%>
<p id="editCategoryMessage" class="alert alert-error"><liferay-ui:message key="Please Enter CategoryName"/></p>
<%}
%>
<% 
DocumentCategories editCategory = (DocumentCategories)portletSession.getAttribute("editCategory");
%>
   
   <div class="row-fluid">
		<div  id="editCategoryForm">
			<div class="panel">
				<div class="panel-heading">
					<h4>Edit</h4>
				</div>
				<div class="panel-body">
					<aui:form name="myForm" action="<%=updateCategories.toString()%>" >
						<aui:input name="documentcategoryId" type="hidden" id="documentcategoryId" value="<%=editCategory.getDocumentcategoryId()%>"/>
						<div class="form-inline">
							<label>Category Name: </label>
							<input name="<portlet:namespace/>category_name" id="categoryName" type="text" value="<%=editCategory.getDocumentCategory()%>">
							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
							<button  type="reset" id ="categorycancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</body>
<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/category/addcategory.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 

if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	
 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
 
	
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}

long groupId=themeDisplay.getLayout().getGroup().getGroupId();
DynamicQuery categoryDynamicQuery = DynamicQueryFactoryUtil
.forClass(DocumentCategories.class,
		PortletClassLoaderUtil.getClassLoader());
categoryDynamicQuery.add(PropertyFactoryUtil.forName("groupId")
.eq(groupId));
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
</html>
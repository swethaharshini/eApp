<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Nationality"%>
<%@ include file="/html/nationality/init.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<portlet:actionURL var="savenationality" name="saveNationality">
</portlet:actionURL>
<portlet:resourceURL var="deletenationality" id="deleteNationality"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/nationality/addnationality.jsp" />
</portlet:renderURL>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#nationalitydelete');
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
		   var url = '<%=deletenationality%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />nationalityIds: idArray,  
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
    var node = A.one('#nationalityadd');
    node.on(
      'click',
      function() {
         A.one('#nationalityadddelete').hide();
         A.one('#addNationalityForm').show();
         A.one('#nationalityName').focus();
                     
      }
    );
  }
);

AUI().ready('event', 'node','transition',function(A){
  A.one('#addNationalityForm').hide();
  setTimeout(function(){
    A.one('#addNationalityMessage').transition('fadeOut');
    A.one('#addNationalityMessage').hide();
},2000)
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#nationalitycancel');
    node.on(
      'click',
      function() {
         A.one('#nationalityadddelete').show();
         A.one('#addNationalityForm').hide();
                     
      }
    );
  }
);

</aui:script>

<% if(SessionMessages.contains(renderRequest.getPortletSession(),"nationalityName-empty-error")){%>
<p id="addNationalityMessage" class="alert alert-error"><liferay-ui:message key="Please Enter Nationality Name"/></p>
<%} 
 if(SessionMessages.contains(renderRequest.getPortletSession(),"nationalityName-duplicate-error")){
%>
<p id="addNationalityMessage" class="alert alert-error"><liferay-ui:message key="Nationality Name already Exits"/></p>
<%} 
%>

		<div id="nationalityadddelete" class="control-group text-right">
			<a href="#" class="btn btn-primary" id="nationalityadd"><i class="icon-plus"></i> Add</a>
			<a href="#" class="btn btn-danger" id="nationalitydelete"><i class="icon-trash"></i> Delete</a>
		</div>
		<div  id="addNationalityForm" class="panel">
			<div class="panel-heading">
				<h4>Add</h4>
			</div>
			<div class="panel-body">
				<aui:form name="myForm" action="<%=savenationality.toString()%>" >
					<aui:input name="nationalityId" type="hidden" id="nationalityId" />
					<div class="form-inline">
						<label>Nationality: </label>
						<input name="<portlet:namespace/>nationalityName" id="nationalityName" type="text">
						<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> Submit</button>
						<button  type="reset" id ="nationalitycancel" class="btn btn-danger"><i class="icon-remove"></i> Cancel</button>
					</div>
				</aui:form>
			</div>
		</div>
	


<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/nationality/addnationality.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
System.out.println("sortByCol == " +sortByCol);
System.out.println("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	System.out.println("if block...");
 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
 
	
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}

System.out.println("after....");
System.out.println("sortByCol == " +sortByCol);
System.out.println("sortByType == " +sortByType);

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Nationality> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records is available for Nationality"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
	<%
	       long groupId = themeDisplay.getLayout().getGroup().getGroupId();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Nationality.class,PortletClassLoaderUtil.getClassLoader());

			dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
  
			List<Nationality> nationalityList =  NationalityLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			List<Nationality> pageList = ListUtil.subList(nationalityList, searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getNationalityOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(pageList,orderByComparator);
  			if(nationalityList.size()>5)
  			{
  				results = ListUtil.subList(nationalityList, searchContainer.getStart(), searchContainer.getEnd());
  			}
  			else{
  				
  				 results = nationalityList;
  				
  			}
              
               total = nationalityList.size();
               
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Nationality"
		keyProperty="nationalityId" modelVar="Nationality" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="Nationality" property="name"
			orderableProperty="interview" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/nationality/edit.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>

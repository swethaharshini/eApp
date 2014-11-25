
<%@ include file="/html/license/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

License license= (License)rslt.getObject();

String prk=String.valueOf(license.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editLicenses" name="editLicense">
<portlet:param name="licenseId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editLicenses.toString()%>'"><i class="icon-edit"></i></a> 
</liferay-ui:icon-menu>

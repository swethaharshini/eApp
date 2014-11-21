<%@ include file="/html/employee/init.jsp"%>
<%
	String newImageId = renderRequest.getParameter("imageId2");
%>
<portlet:resourceURL var="updatingImage" id="updateImage9">
	<portlet:param name="imageIdtoUpdate" value="<%=newImageId%>" />
</portlet:resourceURL>
<aui:form action="<%=updatingImage%>" name="updateEmpImage"
	id="updateEmpImage" encType="multipart/form-data">
	<div class="row-fluid">
		<div class="span4">
			<aui:input name="newImage" type="file" label="Select Image"></aui:input>
		</div>
		<div class="span4"></div>
		<div class="span4"></div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<aui:button type="submit" value="Update"></aui:button>
		</div>
		<div class="span4"></div>
		<div class="span4"></div>
	</div>
</aui:form>
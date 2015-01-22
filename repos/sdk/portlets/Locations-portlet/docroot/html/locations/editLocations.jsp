<%@ include file="/html/locations/init.jsp" %>
<portlet:renderURL var="home">
<portlet:param name="mvcPath" value="/html/locations/view.jsp"/>
</portlet:renderURL>
<div class="clearfix">
	<div class="panel">
		<div class="panel-heading">
			<h4>Edit Location <a href="<%=home %>" class="btn btn-mini btn-danger"><i class="icon-arrow-left"></i> Back</a></h4>
		</div>
		<div class="panel-body form-horizontal">
			<jsp:useBean id="edit" type="com.rknowsys.eapp.hrm.model.Location" scope="request" />
			<portlet:actionURL name="updateLocation" var="editLocation"></portlet:actionURL>
			<aui:form name="eLocation" method="post" action="<%=editLocation%>">
					<aui:input name="id" value="<%=edit.getLocationId()%>" type="hidden" />
					<aui:input name="name" value="<%=edit.getName()%>" 
					inlineLabel="left" />
					<aui:input name="country" value="<%=edit.getCountry()%>"
					inlineLabel="left" />
					<aui:input name="state" value="<%=edit.getState()%>" 
					inlineLabel="left" />
					<aui:input name="city" value="<%=edit.getCity() %>"
					inlineLabel="left" />
					<aui:input name="address" value="<%=edit.getAddress() %>"
					inlineLabel="left" />
					<aui:input name="zip" value="<%=edit.getPostalcode() %>"
					inlineLabel="left" />
					<aui:input name="phone" value="<%=edit.getPhone() %>" 
					inlineLabel="left" />
					<div class="controls">
						<button type="submit" class="btn btn-success"><i class="icon-save"></i> Save</button>
					</div>
			</aui:form>
		</div>
	</div>
</div>
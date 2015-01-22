<%@include file="/html/locations/init.jsp" %>
<portlet:renderURL var="home">
<portlet:param name="mvcPath" value="/html/locations/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="addLocations" var="addLocation"></portlet:actionURL>
<div class="clearfix">
	<div class="panel">
		<div class="panel-heading">
			<h4>Add <a href="<%=home %>" class="pull-right btn btn-mini btn-danger"><i class="icon-arrow-left"></i> Back</a></h4>
		</div>
		<div class="panel-body">
			<div class="form-horizontal">
				<aui:form action="<%=addLocation %>" method="post" >
					<aui:input name="name" id="name" showRequiredLabel="false" >
					<aui:validator name="required" /> 
					</aui:input>
					<aui:select name="country">
						<aui:option label="Afganisthan" value="Afganisthan"></aui:option>
						<aui:option label="China" value="China"></aui:option>
						<aui:option label="India" value="India"></aui:option>
					</aui:select>
					<aui:input name="state" />
					<aui:input name="city" />
					<aui:input name="address" />
					<aui:input name="zip" />
					<aui:input name="phone" >
					<aui:validator name="digits" />
					</aui:input>
					<aui:input name="fax" />
					<aui:input name="notes" />
					<div class="controls">
						<button type="submit" class="btn btn-success"><i class="icon-save"></i> Save</button>
						<button type="reset" class="btn btn-danger"><i class="icon-refresh"></i> Reset</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
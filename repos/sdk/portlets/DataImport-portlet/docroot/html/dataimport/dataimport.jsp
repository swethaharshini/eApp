<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/html/dataimport/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<portlet:actionURL var="dataimportURL" name="saveDataImport">
</portlet:actionURL>
<portlet:resourceURL var="downloadFile" id="fileDownload">
</portlet:resourceURL>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DataImport</title>
<style type="text/css">
var uploadSize=true;
                
          function setUploadSize(fileInput)
          {    
              var size=0;
              for(var num1=0;num1<fileInput.files.length;num1++)
              {
                    var file=fileInput.files[num1];
                       if(file.size>5242880)
                  {
                      document.getElementById('<portlet:namespace/>copyUpload').focus();
                     uploadSize=false;
                    }else{
                         uploadSize=true;
                    }
                    size+=file.size;
              }
         }    
</style>
</head>
<body>
<aui:form id = "copyUpload" action="<%=dataimportURL %>" method="post" enctype="multipart/form-data">
<div class="form-horizontal">
<aui:input name="fileName" type="file" label="Select File" inlineLabel="left">
<aui:validator name="required" errorMessage="Please upload file"/>
<aui:validator name="acceptFiles" errorMessage="Please upload only .xlsx files">'xlsx'</aui:validator>
</aui:input>
<div class="control-group">
	<div class="controls">
		<aui:button type="submit" value="Upload"></aui:button>
	</div>
</div>
</div>
</aui:form>
<div class="ins-panel clearfix">
	<p><b>Instructions:</b></p>
	<ul>
		<li>* Column order should not be changed</li>
		<li>* First Name and Last Name are compulsory</li>
		<li>* All date fields should be in YYYY-MM-DD format</li>
		<li>* If gender is specified, value should be either Male or Female</li>
		<li>* Each import file should be configured for 100 records or less</li>
		<li>* Multiple import files may be required</li>
		<li>* Sample CSV file:<a href="<%=downloadFile %>">Download</a></li>
	</ul>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/html/dataimport/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<portlet:actionURL var="dataimportURL" name="saveDataImport">
</portlet:actionURL>
<portlet:resourceURL var="downloadFile" id="fileDownload">
</portlet:resourceURL>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<aui:form id = "copyUpload" action="<%=dataimportURL %>" method="post" enctype="multipart/form-data">
<div class="row-fluid">
<aui:input name="fileName" type="file" label="Select File" inlineLabel="left"><aui:validator name="required" errorMessage="Please upload file"/>
<aui:validator name="acceptFiles" errorMessage="Please upload only .xlsx files">'xlsx'</aui:validator>
</aui:input>
</div>
<div class="row-fluid">
	* Column order should not be changed<br/><br/>
	* First Name and Last Name are compulsory<br/><br/>
	* All date fields should be in YYYY-MM-DD format<br/><br/>
	* If gender is specified, value should be either Male or Female<br/><br/>
	* Each import file should be configured for 100 records or less<br/><br/>
	* Multiple import files may be required<br/><br/>
	* Sample CSV file:<a href="<%=downloadFile %>">Download</a><br/><br/>

</div>
<br/><br/>
<aui:button type="submit" value="Upload"></aui:button>
</aui:form>
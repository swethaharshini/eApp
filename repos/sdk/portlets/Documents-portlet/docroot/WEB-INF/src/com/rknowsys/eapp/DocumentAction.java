//code @vinay
package com.rknowsys.eapp;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.Documents;
import com.rknowsys.eapp.hrm.model.DocumentsAttachments;
import com.rknowsys.eapp.hrm.service.DocumentsAttachmentsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.DocumentsLocalServiceUtil;

public class DocumentAction extends MVCPortlet {
	
	private static Logger log = Logger.getLogger(DocumentAction.class);
	
	public void toEditDocuments(ActionRequest actionRequest,ActionResponse actionResponse) 
			throws IOException,SystemException, PortalException, ParseException{
		Date date1=new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
   				.getAttribute(WebKeys.THEME_DISPLAY);
	 
		String saveid=actionRequest.getParameter("saveid");
		System.out.println(saveid);
		
		long documentId=CounterLocalServiceUtil.increment();
		 System.out.println("entered....");
		 
		 UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
		String topicname=ParamUtil.getString(uploadRequest,"topic_name");
		String categoryname=ParamUtil.getString(uploadRequest,"category_name");
	    String publisheddate=ParamUtil.getString(uploadRequest,"published_date");
	    String description=ParamUtil.getString(uploadRequest,"descriptionEditor");
	    
		
		 boolean admin=ParamUtil.getBoolean(uploadRequest,"admin");
		 boolean supervisor = ParamUtil.getBoolean(uploadRequest,"supervisor");
		 boolean allemps=ParamUtil.getBoolean(uploadRequest,"allemps");
		
		 @SuppressWarnings("deprecation")
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date publishDate = sdf.parse(publisheddate);
		
	
		
		
		
		Documents document=DocumentsLocalServiceUtil.createDocuments(documentId);
		document.setTopic(topicname);
		document.setCategory(categoryname);
		document.setPublishDate(publishDate);
		document.setDescription(description);
		
		document.setCreateDate(date1);
		document.setModifiedDate(date1);
		document.setCompanyId(themeDisplay.getCompanyId());
		document.setUserId(themeDisplay.getUserId());
		if(saveid.equals("save")){
			
			document.setStatus(false);
		}
		else if(saveid.equals("publish")){
			document.setStatus(true);
		}
		else{
			
		}
	    document.setAdmin(admin);
	    document.setSupervisor(supervisor);
	    document.setAllEmployees(allemps);
	   
	    document.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
		document = DocumentsLocalServiceUtil.addDocuments(document);
		System.out.println("saved successfully");
		
		PortletSession portletSession = actionRequest.getPortletSession();
   		portletSession.setAttribute("editDocument", document);
	    
	    actionResponse.setRenderParameter("mvcPath","/html/documents/editdocuments.jsp");
	   
		
	}
	public void updateDocuments(ActionRequest actionRequest,ActionResponse actionResponse) 
			throws PortalException,SystemException,IOException, ParseException{
		System.out.println("inside updateDocuments method...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
   				.getAttribute(WebKeys.THEME_DISPLAY);
		String saveid=actionRequest.getParameter("saveid");
		System.out.println(saveid);
		Date date=new Date();
		long documentId=ParamUtil.getLong(actionRequest,"documentId");
		String topicname=ParamUtil.getString(actionRequest,"topic_name");
		String categoryname=ParamUtil.getString(actionRequest,"category_name");
	    String publisheddate=ParamUtil.getString(actionRequest,"published_date");
	    String description=ParamUtil.getString(actionRequest,"descriptionEditor");
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date publishDate = sdf.parse(publisheddate);
		
		
      
		
		 boolean admin=ParamUtil.getBoolean(actionRequest,"admin");
		 boolean supervisor = ParamUtil.getBoolean(actionRequest,"supervisor");
		 boolean allemps=ParamUtil.getBoolean(actionRequest,"allemps");
		
		Documents document=DocumentsLocalServiceUtil.getDocuments(documentId);
		document.setTopic(topicname);
		document.setCategory(categoryname);
		document.setPublishDate(publishDate);
		document.setDescription(description);
		
	    document.setAdmin(admin);
	    document.setSupervisor(supervisor);
	    document.setAllEmployees(allemps);
	    document.setCreateDate(date);
	    document.setModifiedDate(date);
	    document.setCompanyId(themeDisplay.getCompanyId());
	    document.setUserId(themeDisplay.getUserId());
	    document.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
        if(saveid.equals("save")){
			
			document.setStatus(false);
		}
		else if(saveid.equals("publish")){
			document.setStatus(true);
		}
		else{
			
		}
		document = DocumentsLocalServiceUtil.updateDocuments(document);
		
		actionResponse.setRenderParameter("mvcPath","/html/documents/search.jsp");
		System.out.println("updated successfully");
	}
	
	public void serveResource(ResourceRequest resourceRequest,
   			ResourceResponse resourceResponse) throws IOException {
    	   
    	   System.out.println("entered into serveResource");
   		if (resourceRequest.getResourceID().equals("deleteDocument")) {
   			

   			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
   					"documentIds");
   			

   			for (int i = 0; i <= idsArray.length - 1; i++) {
   				try {

   					DocumentsLocalServiceUtil.deleteDocuments(Long.parseLong(idsArray[i]));
   					
   				

   				} catch (SystemException e) {
   					e.printStackTrace();
   				}

   				catch (NumberFormatException e) {
   					e.printStackTrace();
   				} catch (PortalException e) {
   				    e.printStackTrace();
   				}
   			}
   		
         
   		}
   		if (resourceRequest.getResourceID().equals("deleteAttachment")) {

			log.info("Entered into serveResource method for deleting attachment Record in DocumentAction");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"attachmentIds");

			log.info("selected records idArray length = " + idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						DocumentsAttachmentsLocalServiceUtil.deleteDocumentsAttachments(Long.parseLong(idsArray[i]));
						
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						log.error("PortalException serveResource deleting record in DocumentAction"
								+ e);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						log.error("SystemException serveResource deleting record in DocumentAction"
								+ e);
					}
				} catch (NumberFormatException e) {
					log.error("NumberFormatException serveResource deleting record in DocumentAction"
							+ e);
				}
			}
			log.info("End of Deleting Attachment records DocumentAction");
		}
   		
        
   	}
	 public void editDocument(ActionRequest actionRequest,
	   			ActionResponse actionResponse) throws IOException,
	   			PortletException, NumberFormatException, PortalException,
	   			SystemException {
	   		System.out.println("inside editDocument() method......");
	   		Long documentId = ParamUtil.getLong(actionRequest, "documentId");
	   		Documents documents=DocumentsLocalServiceUtil.getDocuments(documentId);
	   		System.out.println("11..");
	   		PortletSession portletSession = actionRequest.getPortletSession();
	   		portletSession.setAttribute("editDocument", documents);
	   		System.out.println("222...");
	   		
	   		actionResponse.setRenderParameter("mvcPath", "/html/documents/editdocuments.jsp");
	   		
	   	}
	 public void editAttachment(ActionRequest actionRequest,
	   			ActionResponse actionResponse) throws IOException,
	   			PortletException, NumberFormatException, PortalException,
	   			SystemException {
	   		System.out.println("inside editAttachment() method......");
	   		Long attachmentId = ParamUtil.getLong(actionRequest, "attachmentId");
	   		DocumentsAttachments attachment = DocumentsAttachmentsLocalServiceUtil.getDocumentsAttachments(attachmentId);
	   		//Documents documents=DocumentsLocalServiceUtil.getDocuments(documentId);
	   		
	   		PortletSession portletSession = actionRequest.getPortletSession();
	   		portletSession.setAttribute("editAttachment", attachment);
	   		portletSession.setAttribute("editattachmentform", "editattachmentform");
	   		
	   		
	   		actionResponse.setRenderParameter("mvcPath", "/html/documents/editdocuments.jsp");
	   		
	   	}
	 public void documentAttachments(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException{
			
			System.out.println("documentAttachments..............");
			Date date = new Date();
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			String fileName=uploadRequest.getFileName("documentAttachment");
			File document = uploadRequest.getFile("documentAttachment");
			
			String description = ParamUtil.getString(uploadRequest, "description");
			long documentId = ParamUtil.getLong(uploadRequest, "documentId");
			
			String documentAttachmentId = ParamUtil.getString(uploadRequest, "documentAttachmentId");
			
			ServiceContext serviceContext = null;
			
			String contentType = MimeTypesUtil.getContentType(document);
			FileEntry fileEntry = null;
			DocumentsAttachments documentsAttachments = null;
			
				try {
					serviceContext = ServiceContextFactory.getInstance(
							DLFileEntry.class.getName(), actionRequest);
				} catch (PortalException e1) {
					System.out.println("Error in saving employee documents" +e1);
				}
				try {
					fileEntry = DLAppLocalServiceUtil.addFileEntry(
							themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							0, fileName+date.getTime(), contentType, fileName+date.getTime(), description, " ",
							document, serviceContext);
				} catch (PortalException e1) {
					System.out.println("Error in saving employee documents"+e1);
				}
				if(fileEntry!=null)
				{
					String fileExt=fileEntry.getExtension();
					String regex="[0-9]";
					Pattern pattern=Pattern.compile(regex);
					Matcher matcher=pattern.matcher(fileExt);
					if(matcher.find())
					{
						fileExt=fileExt.substring(0	, matcher.start());
					}
					
					if(documentAttachmentId ==null || documentAttachmentId==""){
						
						documentsAttachments=DocumentsAttachmentsLocalServiceUtil.createDocumentsAttachments(CounterLocalServiceUtil.increment());
						documentsAttachments.setAttachmentTypeId(fileEntry.getFileEntryId());
						documentsAttachments.setUuid(fileEntry.getUuid());
						documentsAttachments.setCreateDate(fileEntry.getCreateDate());
						documentsAttachments.setModifiedDate(fileEntry.getModifiedDate());
						
						documentsAttachments.setCompanyId(themeDisplay.getCompanyId());
						documentsAttachments.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
						documentsAttachments.setUserId(themeDisplay.getUserId());
						documentsAttachments.setDocumentId(documentId);
						
						documentsAttachments.setFileName(fileName);
						documentsAttachments.setFileSize(fileEntry.getSize());
						documentsAttachments.setFileType(fileExt);
						
						documentsAttachments.setDescription(description);
						
						DocumentsAttachmentsLocalServiceUtil.addDocumentsAttachments(documentsAttachments);
						
					}
					else{
						
						documentsAttachments=DocumentsAttachmentsLocalServiceUtil.getDocumentsAttachments(Long.parseLong(documentAttachmentId));
						documentsAttachments.setAttachmentTypeId(fileEntry.getFileEntryId());
						documentsAttachments.setUuid(fileEntry.getUuid());
						documentsAttachments.setCreateDate(fileEntry.getCreateDate());
						documentsAttachments.setModifiedDate(fileEntry.getModifiedDate());
						
						documentsAttachments.setCompanyId(themeDisplay.getCompanyId());
						documentsAttachments.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
						documentsAttachments.setUserId(themeDisplay.getUserId());
						documentsAttachments.setDocumentId(documentId);
						
						documentsAttachments.setFileName(fileName);
						documentsAttachments.setFileSize(fileEntry.getSize());
						documentsAttachments.setFileType(fileExt);
						
						documentsAttachments.setDescription(description);
						
						DocumentsAttachmentsLocalServiceUtil.updateDocumentsAttachments(documentsAttachments);
						
						
					}
					Documents documentObject = DocumentsLocalServiceUtil.getDocuments(documentId);
					PortletSession portletSession = actionRequest.getPortletSession();
			   		portletSession.setAttribute("editDocument", documentObject);
			        portletSession.setAttribute("editattachmentform", "updated");
				    
				    actionResponse.setRenderParameter("mvcPath","/html/documents/editdocuments.jsp");
			
			
			System.out.println("description === " +description);
			System.out.println("fileName == "+fileName);
			System.out.println("document == "+document);
			
			System.out.println(themeDisplay);
			
		}
		
		
	}
	 
	 public void redirectToAdd(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException{
		 
		 long documentId = ParamUtil.getLong(actionRequest, "documentId");
		 
		 Documents documentObject = DocumentsLocalServiceUtil.getDocuments(documentId);
		 
		 PortletSession portletSession = actionRequest.getPortletSession();
	   		portletSession.setAttribute("editDocument", documentObject);
	        portletSession.setAttribute("editattachmentform", "redirectToAdd");
		    
		    actionResponse.setRenderParameter("mvcPath","/html/documents/editdocuments.jsp");
		 
		 
	 }
	 
	
	 
	 
	
}
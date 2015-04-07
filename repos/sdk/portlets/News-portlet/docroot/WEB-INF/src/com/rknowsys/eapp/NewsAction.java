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
import com.rknowsys.eapp.hrm.model.News;
import com.rknowsys.eapp.hrm.model.NewsAttachments;
import com.rknowsys.eapp.hrm.service.NewsAttachmentsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NewsLocalServiceUtil;

public class NewsAction extends MVCPortlet {
	
	
private static Logger log = Logger.getLogger(NewsAction.class);
	
	public void saveNews(ActionRequest actionRequest,ActionResponse actionResponse) 
			throws IOException,SystemException, PortalException, ParseException{
		Date date1=new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
   				.getAttribute(WebKeys.THEME_DISPLAY);
	 
		String saveid=actionRequest.getParameter("saveid");
		System.out.println(saveid);
		
		
		 System.out.println("entered....");
		 
		 UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
		String topicname=ParamUtil.getString(uploadRequest,"topic_name");
	    String publisheddate=ParamUtil.getString(uploadRequest,"published_date");
	    String description=ParamUtil.getString(uploadRequest,"descriptionEditor");
	    
		
		 boolean admin=ParamUtil.getBoolean(uploadRequest,"admin");
		 boolean supervisor = ParamUtil.getBoolean(uploadRequest,"supervisor");
		 boolean allemps=ParamUtil.getBoolean(uploadRequest,"allemps");
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date publishDate = sdf.parse(publisheddate);
		
	
		
		
		
		News news=NewsLocalServiceUtil.createNews(CounterLocalServiceUtil.increment());
		news.setTopic(topicname);
		news.setPublishDate(publishDate);
		news.setDescription(description);
		
		news.setCreateDate(date1);
		news.setModifiedDate(date1);
		news.setCompanyId(themeDisplay.getCompanyId());
		news.setUserId(themeDisplay.getUserId());
		if(saveid.equals("save")){
			
			news.setStatus(false);
		}
		else if(saveid.equals("publish")){
			news.setStatus(true);
		}
		else{
			
		}
	    news.setAdmin(admin);
	    news.setSupervisor(supervisor);
	    news.setAllEmployees(allemps);
	   
	    news.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
		news = NewsLocalServiceUtil.addNews(news);
		System.out.println("saved successfully");
		
		PortletSession portletSession = actionRequest.getPortletSession();
   		portletSession.setAttribute("editNews", news);
	    
	    actionResponse.setRenderParameter("mvcPath","/html/news/editNews.jsp");
	   
		
	}
	public void updateNews(ActionRequest actionRequest,ActionResponse actionResponse) 
			throws PortalException,SystemException,IOException, ParseException{
		System.out.println("inside updateNews method...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
   				.getAttribute(WebKeys.THEME_DISPLAY);
		String saveid=actionRequest.getParameter("saveid");
		System.out.println(saveid);
		Date date=new Date();
		long newsId=ParamUtil.getLong(actionRequest,"newsId");
		String topicname=ParamUtil.getString(actionRequest,"topic_name");
	    String publisheddate=ParamUtil.getString(actionRequest,"published_date");
	    String description=ParamUtil.getString(actionRequest,"descriptionEditor");
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date publishDate = sdf.parse(publisheddate);
		
		
      
		
		 boolean admin=ParamUtil.getBoolean(actionRequest,"admin");
		 boolean supervisor = ParamUtil.getBoolean(actionRequest,"supervisor");
		 boolean allemps=ParamUtil.getBoolean(actionRequest,"allemps");
		
		News news = NewsLocalServiceUtil.getNews(newsId);
		news.setTopic(topicname);
		news.setPublishDate(publishDate);
		news.setDescription(description);
		
	    news.setAdmin(admin);
	    news.setSupervisor(supervisor);
	    news.setAllEmployees(allemps);
	    news.setCreateDate(date);
	    news.setModifiedDate(date);
	    news.setCompanyId(themeDisplay.getCompanyId());
	    news.setUserId(themeDisplay.getUserId());
	    news.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
        if(saveid.equals("save")){
			
			news.setStatus(false);
		}
		else if(saveid.equals("publish")){
			news.setStatus(true);
		}
		else{
			
		}
		news = NewsLocalServiceUtil.updateNews(news);
		
		actionResponse.setRenderParameter("mvcPath","/html/news/search.jsp");
		System.out.println("updated successfully");
	}
	
	public void serveResource(ResourceRequest resourceRequest,
   			ResourceResponse resourceResponse) throws IOException {
    	   
    	   System.out.println("entered into serveResource");
   		if (resourceRequest.getResourceID().equals("deleteNews")) {
   			

   			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
   					"newsIds");
   			

   			for (int i = 0; i <= idsArray.length - 1; i++) {
   				try {

   					NewsLocalServiceUtil.deleteNews(Long.parseLong(idsArray[i]));
   					
   				

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

			log.info("Entered into serveResource method for deleting attachment Record in NewsAction");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"attachmentIds");

			log.info("selected records idArray length = " + idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						NewsAttachmentsLocalServiceUtil.deleteNewsAttachments(Long.parseLong(idsArray[i]));

						
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						log.error("PortalException serveResource deleting record in NewsAction"
								+ e);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						log.error("SystemException serveResource deleting record in NewsAction"
								+ e);
					}
				} catch (NumberFormatException e) {
					log.error("NumberFormatException serveResource deleting record in NewsAction"
							+ e);
				}
			}
			log.info("End of Deleting Attachment records NewsAction");
		}
   		
        
   	}
	 public void editNews(ActionRequest actionRequest,
	   			ActionResponse actionResponse) throws IOException,
	   			PortletException, NumberFormatException, PortalException,
	   			SystemException {
	   		System.out.println("inside editNews() method......");
	   		Long newsId = ParamUtil.getLong(actionRequest, "newsId");
	   		News news = NewsLocalServiceUtil.getNews(newsId);
	   		PortletSession portletSession = actionRequest.getPortletSession();
	   		portletSession.setAttribute("editNews", news);
	   	    actionResponse.setRenderParameter("mvcPath", "/html/news/editNews.jsp");
	   		
	   	}
	 public void editAttachment(ActionRequest actionRequest,
	   			ActionResponse actionResponse) throws IOException,
	   			PortletException, NumberFormatException, PortalException,
	   			SystemException {
	   		System.out.println("inside editAttachment() method......");
	   		Long newsAttachmentId = ParamUtil.getLong(actionRequest, "newsattachmentId");
	   		NewsAttachments attachments = NewsAttachmentsLocalServiceUtil.getNewsAttachments(newsAttachmentId);
	   			
	   		PortletSession portletSession = actionRequest.getPortletSession();
	   		portletSession.setAttribute("editNewsAttachment", attachments);
	   		portletSession.setAttribute("editnewsattachmentform", "editnewsattachmentform");
	   		
	   		
	   		actionResponse.setRenderParameter("mvcPath", "/html/news/editNews.jsp");
	   		
	   	}
	 public void saveNewsAttachments(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException{
			
			System.out.println("saveNewsAttachments..............");
			Date date = new Date();
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			String fileName=uploadRequest.getFileName("newsAttachment");
			File news = uploadRequest.getFile("newsAttachment");
			
			String description = ParamUtil.getString(uploadRequest, "newsDescription");
			long newsId = ParamUtil.getLong(uploadRequest, "newsId");
			
			String newsAttachmentId = ParamUtil.getString(uploadRequest, "newsAttachmentId");
			
			ServiceContext serviceContext = null;
			
			String contentType = MimeTypesUtil.getContentType(news);
			FileEntry fileEntry = null;
			NewsAttachments newsAttachments = null;
			
				try {
					serviceContext = ServiceContextFactory.getInstance(
							DLFileEntry.class.getName(), actionRequest);
				} catch (PortalException e1) {
					System.out.println("Error in saving News" +e1);
				}
				try {
					fileEntry = DLAppLocalServiceUtil.addFileEntry(
							themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							0, fileName+date.getTime(), contentType, fileName+date.getTime(), description, " ",
							news, serviceContext);
				} catch (PortalException e1) {
					System.out.println("Error in saving News"+e1);
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
					
					if(newsAttachmentId ==null || newsAttachmentId==""){
						
						newsAttachments= NewsAttachmentsLocalServiceUtil.createNewsAttachments(CounterLocalServiceUtil.increment());
						newsAttachments.setAttachmentTypeId(fileEntry.getFileEntryId());
						newsAttachments.setUuid(fileEntry.getUuid());
						newsAttachments.setCreateDate(fileEntry.getCreateDate());
						newsAttachments.setModifiedDate(fileEntry.getModifiedDate());
						
						newsAttachments.setCompanyId(themeDisplay.getCompanyId());
						newsAttachments.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
						newsAttachments.setUserId(themeDisplay.getUserId());
						newsAttachments.setNewsId(newsId);
						
						newsAttachments.setFileName(fileName);
						newsAttachments.setFileSize(fileEntry.getSize());
						newsAttachments.setFileType(fileExt);
						
						newsAttachments.setDescription(description);
						
						NewsAttachmentsLocalServiceUtil.addNewsAttachments(newsAttachments);
						
					}
					else{
						
						newsAttachments=NewsAttachmentsLocalServiceUtil.getNewsAttachments(Long.parseLong(newsAttachmentId));
						newsAttachments.setAttachmentTypeId(fileEntry.getFileEntryId());
						newsAttachments.setUuid(fileEntry.getUuid());
						newsAttachments.setCreateDate(fileEntry.getCreateDate());
						newsAttachments.setModifiedDate(fileEntry.getModifiedDate());
						
						newsAttachments.setCompanyId(themeDisplay.getCompanyId());
						newsAttachments.setGroupId(themeDisplay.getLayout().getGroup().getGroupId());
						newsAttachments.setUserId(themeDisplay.getUserId());
						newsAttachments.setNewsId(newsId);
						
						newsAttachments.setFileName(fileName);
						newsAttachments.setFileSize(fileEntry.getSize());
						newsAttachments.setFileType(fileExt);
						
						newsAttachments.setDescription(description);
						
						NewsAttachmentsLocalServiceUtil.updateNewsAttachments(newsAttachments);
						
						
					}
					News newsObject = NewsLocalServiceUtil.getNews(newsId);
					PortletSession portletSession = actionRequest.getPortletSession();
			   		portletSession.setAttribute("editNews", newsObject);
			        portletSession.setAttribute("editnewsattachmentform", "updated");
				    
				    actionResponse.setRenderParameter("mvcPath","/html/news/editNews.jsp");
			
			
			System.out.println("description === " +description);
			System.out.println("fileName == "+fileName);
			System.out.println("document == "+news);
			
			System.out.println(themeDisplay);
			
		}
		
		
	}
	 
	 public void redirectToAdd(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException{
		 
		 long newsId = ParamUtil.getLong(actionRequest, "newsId");
		 
		 News newsObject = NewsLocalServiceUtil.getNews(newsId);
		 PortletSession portletSession = actionRequest.getPortletSession();
	   		portletSession.setAttribute("editNews", newsObject);
	        portletSession.setAttribute("editnewsattachmentform", "addAttachment");
		    
		    actionResponse.setRenderParameter("mvcPath","/html/news/editNews.jsp");
		 
		 
	 }

}

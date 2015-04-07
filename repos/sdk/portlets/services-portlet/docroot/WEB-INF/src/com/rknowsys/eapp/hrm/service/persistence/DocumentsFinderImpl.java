package com.rknowsys.eapp.hrm.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.rknowsys.eapp.hrm.model.Documents;
import com.rknowsys.eapp.hrm.model.impl.DocumentsImpl;

public class DocumentsFinderImpl extends BasePersistenceImpl<Documents> implements DocumentsFinder{
    
	
	
	public List<Documents> findDocumentDetails(String topic,String Category,String status,int begin, int end) {

		System.out.println("Inside findDocumentDetails.....");
		System.out.println("==" +topic+ " == "+Category+"== "+status);
		
		Session session = null;
		try {
			System.out.println("in try block....");
			session = openSession();

			StringBuffer sb = new StringBuffer("SELECT * FROM documents WHERE ");
			if(topic!=""&& topic!=null){
				
				sb.append("topic LIKE '%"+topic+"%' and ");
			}
			 if(Category!=""&& Category!=null){
				sb.append("Category LIKE '%"+Category+"%' and ");
			}
			if(status!=""&& status!=null){
				
				sb.append("status = '"+status+"' and ");
			}
		
			sb.append("documentId>=1");
		
			
			String sql = sb.toString();
			System.out.println(sb.toString());
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("Documents", DocumentsImpl.class);
			System.out.println("dialect === "+getDialect());
			return (List<Documents>) QueryUtil.list(q, getDialect(), begin, end);
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return null;
	}

	
}

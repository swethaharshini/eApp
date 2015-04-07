package com.rknowsys.eapp.hrm.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.rknowsys.eapp.hrm.model.News;
import com.rknowsys.eapp.hrm.model.impl.NewsImpl;


public class NewsFinderImpl extends BasePersistenceImpl<News> implements NewsFinder {
	
	public List<News> findNewsDetails(String topic,String status,long groupId,int begin, int end) {

				
		Session session = null;
		try {
			System.out.println("in try block....");
			session = openSession();

			StringBuffer sb = new StringBuffer("SELECT * FROM news WHERE ");
			if(topic!=""&& topic!=null){
				
				sb.append("topic LIKE '%"+topic+"%' and ");
			}
			if(status!=""&& status!=null){
				
				sb.append("status = '"+status+"' and ");
			}
			if(groupId!=0){
				
				sb.append("groupId = '"+groupId+"' and ");
			}
		
			sb.append("newsId>=1");
		
			
			String sql = sb.toString();
			System.out.println(sb.toString());
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("News", NewsImpl.class);
			System.out.println("dialect === "+getDialect());
			return (List<News>) QueryUtil.list(q, getDialect(), begin, end);
			
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

package com.rknowsys.eapp.hrm.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.rknowsys.eapp.hrm.model.BulkUpdate;
import com.rknowsys.eapp.hrm.model.impl.BulkUpdateImpl;

public class BulkUpdateFinderImpl extends BasePersistenceImpl<BulkUpdate> implements BulkUpdateFinder {
	
	@SuppressWarnings("unchecked")
	public List<BulkUpdate> findBulkUpdate(String empname,String empstatus,String supervisorname,String jobtitle,String subunit,String location,String workshift,String include, int begin,int end){
		
System.out.println("Inside findBulkUpdate.....");
		
		System.out.println("params == "+empname+", "+empstatus+", "+supervisorname+", "+jobtitle+", "+subunit+", "+location+", "+workshift);
         String s = include;
		System.out.println("status == "+s);
		
		Session session = null;
		try {
			
			System.out.println("Inside try block params == "+empname+", "+empstatus+", "+supervisorname+", "+jobtitle+", "+subunit);
		   
			long status = Long.parseLong(s);
			
			session = openSession();

			StringBuffer sb = new StringBuffer("SELECT * FROM bulkupdate WHERE ");
			if(empname!=""&& empname!=null){
				sb.append("employeeName LIKE '%"+empname+"%' and ");
			}
			
			if(empstatus!="" && empstatus!=null){
				sb.append("employmentStatus LIKE '%"+empstatus+"%' and ");
			}
			if(supervisorname!="" && supervisorname!=null){
				sb.append("supervisor LIKE '%"+supervisorname+"%' and ");
			}
			if(jobtitle!="" && jobtitle!=null){
				sb.append("jobTitle LIKE '%"+jobtitle+"%' and ");
			}
			if(subunit!="" && subunit!=null){
				sb.append("subunit LIKE '%"+subunit+"%' and ");
			}
			if(location!="" && location!=null){
				sb.append("location LIKE '%"+location+"%' and ");
			}
			if(workshift!="" && workshift!=null){
				sb.append("workshift LIKE '%"+workshift+"%' and ");
			}
			if(status!=2 && (status==0 || status==1)){
				sb.append("empStatus = '"+status+"' and ");
			}
			if(status==2)
			{
				sb.append("empStatus >=0 and ");
			}
			
			sb.append("employeeId >=0");
			
			String sql = sb.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("BulkUpdate", BulkUpdateImpl.class);

			System.out.println("begin = " + begin);
			System.out.println("end = " + end);
			System.out.println("query object == " +q);
			System.out.println("dialect == " +getDialect().toString());
			System.out.println("before size== ");
			System.out.println("list size == " +QueryUtil.list(q, getDialect(), begin,
					end).size());
			return (List<BulkUpdate>) QueryUtil.list(q, getDialect(), begin,
					end);
			
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

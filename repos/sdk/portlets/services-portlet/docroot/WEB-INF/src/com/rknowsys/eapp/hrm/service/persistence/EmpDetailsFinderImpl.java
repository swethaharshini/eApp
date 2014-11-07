package com.rknowsys.eapp.hrm.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.model.impl.EmpDetailsImpl;
import com.rknowsys.eapp.hrm.model.EmpDetails;

/**
 * 
 * @author Laxminarayana 10 october 2014 12:57:05 PM
 * 
 */
public class EmpDetailsFinderImpl extends BasePersistenceImpl<EmpDetails>
		implements EmpDetailsFinder {
	
	/**
	 *  This method returns all the employee list from the view table 'empdetails' based on the given search parameters.
	 *  @return
	 */
	
	public List<EmpDetails> findEmpDetails(String empname,String empid,String empstatus,String supervisorname,String jobtitle,String subunit,int begin, int end) {

		System.out.println("Inside findEmpDetails.....");
		
		System.out.println("params == "+empname+", "+empid+", "+empstatus+", "+supervisorname+", "+jobtitle+", "+subunit);

		Session session = null;
		try {
			System.out.println("Inside try block params == "+empname+", "+empid+", "+empstatus+", "+supervisorname+", "+jobtitle+", "+subunit);
		
			session = openSession();

			StringBuffer sb = new StringBuffer("SELECT * FROM empdetails WHERE ");
			if(empname!=""&& empname!=null){
				sb.append("CONCAT(firstName,lastName) LIKE '%"+empname+"%' and ");
			}
			if(empid!="" && empid!=null){
				sb.append("employeeNo LIKE '%"+empid+"%' and ");
			}
			if(empstatus!="" && empstatus!=null){
				sb.append("employmentstatus LIKE '%"+empstatus+"%' and ");
			}
			if(supervisorname!="" && supervisorname!=null){
				sb.append("supervisor LIKE '%"+supervisorname+"%' and ");
			}
			if(jobtitle!="" && jobtitle!=null){
				sb.append("title LIKE '%"+jobtitle+"%' and ");
			}
			if(subunit!="" && subunit!=null){
				sb.append("name LIKE '%"+subunit+"%' and ");
			}
			
			sb.append("empdetailsId >=1");
			
			String sql = sb.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("EmpDetails", EmpDetailsImpl.class);

			System.out.println("begin = " + begin);
			System.out.println("end = " + end);
			System.out.println("query object == " +q);
			System.out.println("dialect == " +getDialect().toString());
			System.out.println("before size== ");
			System.out.println("list size == " +QueryUtil.list(q, getDialect(), begin,
					end).size());
			return (List<EmpDetails>) QueryUtil.list(q, getDialect(), begin,
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
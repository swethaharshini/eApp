package com.rknowsys.eapp.hrm.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.impl.EmpPersonalDetailsImpl;

public class EmpPersonalDetailsFinderImpl extends BasePersistenceImpl<EmpPersonalDetails> implements EmpPersonalDetailsFinder {
	
	
	@SuppressWarnings("unchecked")
	/**
	 *
	 * <p>This method gets EmpPersonaldetails list based on the given workshifId
	 * @param shiftId
	 * @return the EmpPersonalDetails list
	 * @throws SystemException if a system exception occurred
	 * @author Laxminarayana 27 october 2014,7:42:43 PM
	 */
	public List<EmpPersonalDetails> getEmployeesByShiftId(long shiftId){
		
System.out.println("inside getEmployeesByShiftId shiftId == "+shiftId);
		
		Session session = null;
		try{
			session = openSession();
		
			String sql = "SELECT * FROM emp_personal_details ep JOIN emp_job ej WHERE ep.employeeId=ej.employeeId AND ej.shiftId="+shiftId;
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("EmpPersonalDetails", EmpPersonalDetailsImpl.class);
			System.out.println("before list...");
			System.out.println("dialect == " +getDialect());
			List<EmpPersonalDetails> empPersonalDetailslist = (List<EmpPersonalDetails>) QueryUtil.list(q, getDialect(), -1, -1);
			
			return empPersonalDetailslist;
		}
		catch (Exception e) {
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

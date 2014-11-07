package com.rknowsys.eapp.hrm.service.persistence;

import java.util.List;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.rknowsys.eapp.hrm.model.EmpDetails;
import com.rknowsys.eapp.hrm.model.impl.EmpDetailsImpl;

/**
 * 
 * @author Laxminarayana 10 october 2014 12:57:05 PM
 * 
 */
public class EmpDetailsFinderImpl extends BasePersistenceImpl<EmpDetails>
		implements EmpDetailsFinder {
	
	/**
	 *  This method returns all the employee list from the view table 'empdetails'.
	 *  @return
	 */
	public List<EmpDetails> findByEmpDetails(int begin, int end) {

		System.out.println("Inside EmpdetailsFinderImpl.....");

		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT * FROM empdetails";
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("EmpDetails", EmpDetailsImpl.class);

			System.out.println("begin" + begin);
			System.out.println("end" + end);
			System.out.println(q);
			System.out.println(getDialect().toString());
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

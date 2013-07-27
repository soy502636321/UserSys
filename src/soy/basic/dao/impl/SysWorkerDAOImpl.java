package soy.basic.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.SysWorkerDAO;
import soy.basic.database.entity.SysWorker;
import soy.basic.vo.SysWorkerVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;


public class SysWorkerDAOImpl extends HibernateDaoSupport implements
		SysWorkerDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysWorkerDAOImpl.class);
	// property constants
	public static final String NAME = "name";
	public static final String GENDER = "gender";
	public static final String ID_CARD = "idCard";
	public static final String ADDRESS = "address";
	public static final String PASSPORT = "passport";
	public static final String RECORD = "record";
	public static final String REMARK = "remark";

	public void save(Object object) {
		log.debug("增加一条人员记录");
		try {
			getHibernateTemplate().save(object);
			log.debug("增加人员记录成功");
		} catch (RuntimeException re) {
			log.error("增加人员记录失败", re);
			throw re;
		}
	}

	public void delete(Object object) {
		log.debug("删除一条人员记录");
		try {
			getHibernateTemplate().delete(object);
			log.debug("删除人员记录成功");
		} catch (RuntimeException re) {
			log.error("删除人员记录失败", re);
			throw re;
		}
	}

	public SysWorker findById(Object id) {
		log.debug("根据Id返回人员记录。 id: " + id);
		try {
			SysWorker instance = (SysWorker) getHibernateTemplate().get(
					"soy.basic.database.entity.SysWorker", (Integer) id);
			return instance;
		} catch (RuntimeException re) {
			log.error("根据Id返回人员记录失败", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("根据指定的属性返回人员记录。 property: " + propertyName + ", value: "
				+ value);
		try {
			String queryString = "from SysWorker as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("根据指定的属性返回人员记录失败", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("返回所有的人员记录");
		try {
			String queryString = "from SysWorker";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("返回所有的人员记录失败", re);
			throw re;
		}
	}

	@Override
	public SimplePaginatedList find(final SimplePaginatedList paginatedList,
			final SysWorkerVO workerVO) {
		log.debug("");
		try {
			SimplePaginatedList list = getHibernateTemplate().execute(
					new HibernateCallback<SimplePaginatedList>() {

						@Override
						public SimplePaginatedList doInHibernate(Session session)
								throws HibernateException, SQLException {
							String hql = "from SysWorker as s";
							if (workerVO != null) {
								hql += " where s.id like '%'";
								if (!StringUtil.isNull(workerVO.getId())) {
									if (SystemUtil.isNumber(workerVO.getId())) {
										hql += " and s.id = " + workerVO.getId();
									} else {
										hql += " and s.id = 0";
									}
								} 
								if (!StringUtil.isNull(workerVO.getName())) {
									hql += " and s.name like '%" + workerVO.getName() + "%'";
								}
								if (!SystemUtil.isEmpty(workerVO.getGenderId())) {
									hql += " and s.gender = " + workerVO.getGenderId().intValue();
								}
							}
							log.debug("hql >>> " + hql);
							Query query = session.createQuery(hql);
							query.setFirstResult(paginatedList.getStartNumber())
									.setMaxResults(paginatedList.getObjectsPerPage());
							paginatedList.setList(query.list());
							Query countQuery = session.createQuery("select count(*) " + hql);
							int count = ((Number)countQuery.list().iterator().next()).intValue();
							paginatedList.setFullListSize(count);
							return paginatedList;
						}

					});
			log.debug("");
			return list;
		} catch (DataAccessException e) {
			log.debug("", e);
			throw e;
		}
	}
}
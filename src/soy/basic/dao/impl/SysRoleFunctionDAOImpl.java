package soy.basic.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.SysRoleFunctionDAO;
import soy.basic.database.entity.SysRoleFunction;
import soy.basic.database.entity.SysRoleFunctionId;


public class SysRoleFunctionDAOImpl extends HibernateDaoSupport implements SysRoleFunctionDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysRoleFunctionDAOImpl.class);

	// property constants

	public void save(Object object) {
		log.debug("saving SysRoleFunction instance");
		try {
			getHibernateTemplate().save(object);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object object) {
		log.debug("deleting SysRoleFunction instance");
		try {
			getHibernateTemplate().delete(object);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysRoleFunction findById(Object id) {
		log.debug("getting SysRoleFunction instance with id: " + id);
		try {
			SysRoleFunction instance = (SysRoleFunction) getHibernateTemplate().get(
					"soy.basic.database.entity.SysRoleFunction", (SysRoleFunctionId)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SysRoleFunction instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SysRoleFunction as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all SysRoleFunction instances");
		try {
			String queryString = "from SysRoleFunction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List findByRoleCode(String code) {
		log.debug("");
		try {
			String hql = "from SysRoleFunction obj where obj.id.sysRole.id = ?";
			return getHibernateTemplate().find(hql, Integer.valueOf(code));
		} catch (RuntimeException re) {
			log.error("", re);
			throw re;
		}
	}
}
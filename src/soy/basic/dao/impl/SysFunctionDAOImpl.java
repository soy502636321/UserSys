package soy.basic.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.SysFunctionDAO;
import soy.basic.database.entity.SysFunction;


public class SysFunctionDAOImpl extends HibernateDaoSupport implements SysFunctionDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysFunctionDAOImpl.class);
	// property constants
	public static final String FUNCTION_NAME = "functionName";
	public static final String FUNCTION_URL = "functionUrl";
	public static final String FUNCTION_TYPE = "functionType";
	public static final String REMARK = "remark";

	public void save(Object object) {
		log.debug("增加一个功能");
		try {
			getHibernateTemplate().save(object);
			log.debug("增加功能成功");
		} catch (RuntimeException re) {
			log.error("增加功能失败", re);
			throw re;
		}
	}

	public void delete(Object object) {
		log.debug("删除一个功能记录");
		try {
			getHibernateTemplate().delete(object);
			log.debug("删除功能成功");
		} catch (RuntimeException re) {
			log.error("删除功能失败", re);
			throw re;
		}
	}

	public SysFunction findById(Object id) {
		log.debug("根据Id返回系统功能 id: " + id);
		try {
			SysFunction instance = (SysFunction) getHibernateTemplate().get(
					"soy.basic.database.entity.SysFunction", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("返回功能失败", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("根据指定的属性返回系统功能。 property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysFunction as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("返回功能失败", re);
			throw re;
		}
	}


	public List findAll() {
		log.debug("返回所有的系统功能");
		try {
			String queryString = "from SysFunction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("返回所有的系统功能失败", re);
			throw re;
		}
	}

	@Override
	public List findByName(String value) {
		return findByProperty(FUNCTION_NAME, value);
	}
}
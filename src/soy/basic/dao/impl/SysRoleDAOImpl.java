package soy.basic.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import soy.basic.dao.SysRoleDAO;
import soy.basic.database.entity.SysRole;


public class SysRoleDAOImpl extends HibernateDaoSupport implements SysRoleDAO {
	private static final Logger log = LoggerFactory.getLogger(SysRoleDAOImpl.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String REMARK = "remark";

	public void save(Object object) {
		log.debug("增加一个角色");
		try {
			getHibernateTemplate().save(object);
			log.debug("增加角色成功");
		} catch (RuntimeException re) {
			log.error("增加角色失败", re);
			throw re;
		}
	}

	public void delete(Object object) {
		log.debug("删除一个角色");
		try {
			getHibernateTemplate().delete(object);
			log.debug("删除角色成功");
		} catch (RuntimeException re) {
			log.error("删除角色失败", re);
			throw re;
		}
	}

	public SysRole findById(Object id) {
		log.debug("根据Id查询角色。 id: " + id);
		try {
			SysRole instance = (SysRole) getHibernateTemplate().get(
					"soy.basic.database.entity.SysRole", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("返回角色失败", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("根据指定的属性返回角色。 property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("返回角色失败", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("返回所有的角色");
		try {
			String queryString = "from SysRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("返回所有的角色失败", re);
			throw re;
		}
	}

	@Override
	public List findByName(String name) {
		return findByProperty(ROLE_NAME, name);
	}
}
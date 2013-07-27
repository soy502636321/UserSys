package soy.basic.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

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

import soy.basic.dao.SysUserDAO;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.SysUserVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;


public class SysUserDAOImpl extends HibernateDaoSupport implements SysUserDAO {
	private static final Logger log = LoggerFactory.getLogger(SysUserDAOImpl.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String GENDER = "gender";
	public static final String PHONE_TH1 = "phoneTh1";
	public static final String PHONE_TH2 = "phoneTh2";
	public static final String EMAIL_TH1 = "emailTh1";
	public static final String EMAIL_TH2 = "emailTh2";
	public static final String USER_STATE = "userState";
	public static final String REMARK = "remark";

	public void save(Object object) {
		log.debug("增加一个用户");
		try {
			getHibernateTemplate().save(object);
			log.debug("增加用户成功");
		} catch (RuntimeException re) {
			log.error("增加用户失败", re);
			throw re;
		}
	}

	public void delete(Object object) {
		log.debug("开始删除用户");
		try {
			getHibernateTemplate().delete(object);
			log.debug("删除用户成功");
		} catch (RuntimeException re) {
			log.error("删除用户失败", re);
			throw re;
		}
	}

	public SysUser findById(Object id) {
		log.debug("根据Id返回用户 id: " + id);
		try {
			SysUser instance = (SysUser) getHibernateTemplate().get(
					"soy.basic.database.entity.SysUser", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("根据Id返回用户失败", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("根据指定的属性返回用户。 property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("根据属性返回用户失败", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("返回所有的用户");
		try {
			String queryString = "from SysUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("返回所有的用户失败", re);
			throw re;
		}
	}

	@Override
	public List findByUsername(String username) {
		return findByProperty(USERNAME, username);
	}

	@Override
	public SimplePaginatedList find(final SimplePaginatedList paginatedList, final SysUserVO sysUserVO) {
		log.debug("");
		try {
			SimplePaginatedList list = getHibernateTemplate().execute(new HibernateCallback<SimplePaginatedList>() {

				@Override
				public SimplePaginatedList doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql = "from SysUser as s where s.id like '%'";
					
					if (sysUserVO != null) {
						if (!StringUtil.isNull(sysUserVO.getId())) {
							if (SystemUtil.isNumber(sysUserVO.getId())) {
								hql += " and s.id = " + sysUserVO.getId();
							} else {
								hql += " and s.id = 0";
							}
						}
						
						if (!StringUtil.isNull(sysUserVO.getUsername())) {
							hql += " and s.username like '%" + sysUserVO.getUsername() + "%'";
						}
						
						if (!StringUtil.isNull(sysUserVO.getName())) {
							hql += " and s.name like '%" + sysUserVO.getName() + "%'";
						}
						
						if (!StringUtil.isNull(sysUserVO.getGenderId()) && SystemUtil.isNumber(sysUserVO.getGenderId())) {
							hql += " and s.gender = " + sysUserVO.getGenderId();
						}
					}
					
					Query query = session.createQuery(hql);
					query.setFirstResult(paginatedList.getStartNumber()).setMaxResults(paginatedList.getObjectsPerPage());
					paginatedList.setList(query.list());
					Query countQuery = session.createQuery("select count(*) " + hql);
					int count = ((Number) countQuery.list().iterator().next()).intValue();
					paginatedList.setFullListSize(count);
					return paginatedList;
				}
				
			});
			log.debug("");
			return list;
		} catch (DataAccessException e) {
			log.error("", e);
			throw e;
		}
	}

}
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

import soy.basic.dao.BaseOrganDAO;
import soy.basic.database.entity.BaseOrgan;
import soy.basic.vo.BaseOrganVO;
import soy.common.displaytag.SimplePaginatedList;


public class BaseOrganDAOImpl extends HibernateDaoSupport implements BaseOrganDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseOrganDAOImpl.class);
	// property constants
	public static final String ORGAN_NAME = "organName";
	public static final String ORGAN_ADDRESS = "organAddress";
	public static final String RAMARK = "ramark";

	public void save(Object object) {
		log.debug("增加一个公司机构");
		try {
			getHibernateTemplate().save(object);
			log.debug("增加公司机构成功");
		} catch (RuntimeException re) {
			log.error("增加公司机构失败", re);
			throw re;
		}
	}

	public void delete(Object object) {
		log.debug("删除一个的公司机构记录");
		try {
			getHibernateTemplate().delete(object);
			log.debug("删除公司机构记录成功");
		} catch (RuntimeException re) {
			log.error("删除公司机构记录失败", re);
			throw re;
		}
	}

	public BaseOrgan findById(Object id) {
		log.debug("根据Id返回公司机构。 id: " + id);
		try {
			BaseOrgan instance = (BaseOrgan) getHibernateTemplate().get(
					"soy.basic.database.entity.BaseOrgan", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("返回公司机构失败", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("根据指定的属性返回公司机构。 property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BaseOrgan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("根据属性返回公司机构失败", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("返回所有的公司机构");
		try {
			String queryString = "from BaseOrgan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("返回所有的公司机构失败", re);
			throw re;
		}
	}

	@Override
	public SimplePaginatedList find(final SimplePaginatedList paginatedList,
			final BaseOrganVO organVO) {
		log.debug("");
		try {
			SimplePaginatedList list = getHibernateTemplate().execute(new HibernateCallback<SimplePaginatedList>() {

				@Override
				public SimplePaginatedList doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql = "from BaseOrgan";
					Query query = session.createQuery(hql);
					query.setFirstResult(paginatedList.getStartNumber()).setMaxResults(paginatedList.getObjectsPerPage());
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
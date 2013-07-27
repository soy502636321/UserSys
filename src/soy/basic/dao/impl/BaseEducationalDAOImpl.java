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

import soy.basic.dao.BaseEducationalDAO;
import soy.basic.database.entity.BaseEducational;
import soy.basic.vo.BaseEducationalVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;


public class BaseEducationalDAOImpl extends HibernateDaoSupport implements BaseEducationalDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseEducationalDAOImpl.class);
	// property constants
	public static final String EDUCATIONAL_NAME = "educationalName";
	public static final String RAMARK = "ramark";

	public void save(Object object) {
		log.debug("增加一个学历类型");
		try {
			getHibernateTemplate().save(object);
			log.debug("增加学历类型成功");
		} catch (RuntimeException re) {
			log.error("增加学历类型失败", re);
			throw re;
		}
	}

	public void delete(Object object) {
		log.debug("删除一个学历类型");
		try {
			getHibernateTemplate().delete(object);
			log.debug("删除学历类型成功");
		} catch (RuntimeException re) {
			log.error("删除学历类型失败", re);
			throw re;
		}
	}

	public BaseEducational findById(Object id) {
		log.debug("根据Id返回学历类型。id = : " + id);
		try {
			BaseEducational instance = (BaseEducational) getHibernateTemplate().get(
					"soy.basic.database.entity.BaseEducational", (Integer)id);
			return instance;
		} catch (RuntimeException re) {
			log.error("返回学习类型失败", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("根据指定的的属性返回学历类型。 property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BaseEducational as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("返回学历类型成功", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("返回所有的学历类型");
		try {
			String queryString = "from BaseEducational";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("返回所有的学历类型失败", re);
			throw re;
		}
	}

	@Override
	public SimplePaginatedList find(final SimplePaginatedList paginatedList,
			final BaseEducationalVO baseEducationalVO) {
		log.debug("");
		try {
			SimplePaginatedList list = getHibernateTemplate().execute(new HibernateCallback<SimplePaginatedList>() {

				@Override
				public SimplePaginatedList doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql = "from BaseEducational as b where b.id like '%'";
					
					if (baseEducationalVO != null) {
						if (!StringUtil.isNull(baseEducationalVO.getId())) {
							if (SystemUtil.isNumber(baseEducationalVO.getId())) {
								hql += " and b.id = " + baseEducationalVO.getId();
							} else {
								hql += " and b.id = 0";
							}
						}
						if (!StringUtil.isNull(baseEducationalVO.getEducationalName())) {
							hql += " and b.educationalName like '%" + baseEducationalVO.getEducationalName() + "%'";
						}
						if (!StringUtil.isNull(baseEducationalVO.getRamark())) {
							hql += " and b.ramark like '%" + baseEducationalVO.getRamark() + "%'";
						}
					}
					log.debug("hql >>>>>> " + hql);
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
		} catch(DataAccessException e) {
			log.error("", e);
			throw e;
		}
	}
}
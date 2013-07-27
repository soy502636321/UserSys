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

import soy.basic.dao.BaseAccountDAO;
import soy.basic.database.entity.BaseAccount;
import soy.basic.vo.BaseAccountVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.StringUtil;
import soy.util.SystemUtil;

public class BaseAccountDAOImpl extends HibernateDaoSupport implements
		BaseAccountDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BaseAccountDAOImpl.class);
	// property constants
	public static final String ACCOUNT_NAME = "accountName";
	public static final String REMARK = "remark";

	public void save(Object object) {
		log.debug("开始增加一个户口类型");
		try {
			getHibernateTemplate().save(object);
			log.debug("增加户口记录类型成功");
		} catch (RuntimeException re) {
			log.error("增加户口记录类型失败", re);
			throw re;
		}
	}

	public void delete(Object object) {
		log.debug("开始删除一个户口类型");
		try {
			getHibernateTemplate().delete(object);
			log.debug("删除户口类型成功");
		} catch (RuntimeException re) {
			log.error("删除户口类型失败", re);
			re.printStackTrace(System.out);
			throw re;
		}
	}

	public BaseAccount findById(Object id) {
		log.debug("根据户口类型的Id返回实例。id = " + id);
		try {
			BaseAccount instance = (BaseAccount) getHibernateTemplate().get(
					"soy.basic.database.entity.BaseAccount", (Integer) id);
			return instance;
		} catch (RuntimeException re) {
			log.error("返回户口类型失败", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("根据指定的属性返回户口类型。peroperty: " + propertyName + ", value: "
				+ value);
		try {
			String queryString = "from BaseAccount as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("根据指定的属性返回户口类型失败", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("返回所有的户口类型");
		try {
			String queryString = "from BaseAccount";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("返回所有的户口类型失败", re);
			throw re;
		}
	}

	@Override
	public SimplePaginatedList find(final SimplePaginatedList paginatedList,
			final BaseAccountVO baseAccountVO) {
		log.debug("");
		try {
			SimplePaginatedList list = getHibernateTemplate().execute(
					new HibernateCallback<SimplePaginatedList>() {

						@Override
						public SimplePaginatedList doInHibernate(Session session)
								throws HibernateException, SQLException {
							String hql = "from BaseAccount as b where b.id like '%'";
							if (baseAccountVO != null) {
								if (!StringUtil.isNull(baseAccountVO.getId())) {
									if (SystemUtil.isNumber(baseAccountVO.getId())) {
										hql += " and b.id = " + baseAccountVO.getId();
									} else {
										hql += " and b.id = 0";
									}
								}
								if (!StringUtil.isNull(baseAccountVO.getAccountName())) {
									hql += " and b.accountName like '%" + baseAccountVO.getAccountName() + "%'";
								}
								if (!StringUtil.isNull(baseAccountVO.getRemark())) {
									hql += " and b.remark like '%" + baseAccountVO.getRemark() + "%'";
								}
							}
							
							Query query = session.createQuery(hql);
							query.setFirstResult(paginatedList.getStartNumber()).setMaxResults(paginatedList.getObjectsPerPage());
							paginatedList.setList(query.list());
							Query countQuery = session.createQuery("select count(*) " + hql);
							int count = ((Number)countQuery.list().iterator().next()).intValue();
							paginatedList.setFullListSize(count);
							log.debug("");
							return paginatedList;
						}

					});
			return list;
		} catch (DataAccessException e) {
			log.error("", e);
			throw e;
		}
	}
}
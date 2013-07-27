package soy.basic.dao;

import soy.basic.vo.BaseOrganVO;
import soy.common.displaytag.SimplePaginatedList;


public interface BaseOrganDAO extends BaseDAO {
	public SimplePaginatedList find(SimplePaginatedList paginatedList, BaseOrganVO organVO);
}

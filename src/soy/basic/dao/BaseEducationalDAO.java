package soy.basic.dao;

import soy.basic.vo.BaseEducationalVO;
import soy.common.displaytag.SimplePaginatedList;

public interface BaseEducationalDAO extends BaseDAO {
	public SimplePaginatedList find(SimplePaginatedList paginatedList, BaseEducationalVO baseEducationalVO);
}

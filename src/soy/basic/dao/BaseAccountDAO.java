package soy.basic.dao;

import soy.basic.database.entity.BaseAccount;
import soy.basic.vo.BaseAccountVO;
import soy.common.displaytag.SimplePaginatedList;

public interface BaseAccountDAO extends BaseDAO {
	public SimplePaginatedList find(SimplePaginatedList paginatedList, BaseAccountVO baseAccountVO );
}

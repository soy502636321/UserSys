package soy.web.service;

import java.util.Map;

import soy.basic.database.entity.BaseAccount;
import soy.basic.vo.BaseAccountVO;
import soy.common.displaytag.SimplePaginatedList;

public interface BaseAccountService {
	public Map<Integer, String> getMap();
	public SimplePaginatedList find(SimplePaginatedList paginatedList, BaseAccountVO baseAccountVO);
	public int delete(Integer[] ids);
}

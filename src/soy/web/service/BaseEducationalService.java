package soy.web.service;

import java.util.Map;

import soy.basic.vo.BaseEducationalVO;
import soy.common.displaytag.SimplePaginatedList;

public interface BaseEducationalService {
	public Map<Integer, String> getMap();
	public SimplePaginatedList find(SimplePaginatedList paginatedList, BaseEducationalVO baseEducationalVO);
	public int delete(Integer[] ids);
}

package soy.web.service;

import java.util.Map;

import soy.basic.vo.BaseOrganVO;
import soy.common.displaytag.SimplePaginatedList;


public interface BaseOrganService {
	public Map<Integer, String> getMap();
	public SimplePaginatedList find(SimplePaginatedList paginatedList, BaseOrganVO organVO);
}

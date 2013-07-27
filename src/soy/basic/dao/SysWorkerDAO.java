package soy.basic.dao;

import soy.basic.vo.SysWorkerVO;
import soy.common.displaytag.SimplePaginatedList;


public interface SysWorkerDAO extends BaseDAO {
	public SimplePaginatedList find(SimplePaginatedList paginatedList, SysWorkerVO workerVO);
}

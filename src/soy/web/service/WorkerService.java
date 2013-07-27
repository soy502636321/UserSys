package soy.web.service;

import soy.basic.vo.SysUserVO;
import soy.basic.vo.SysWorkerVO;
import soy.common.displaytag.SimplePaginatedList;


public interface WorkerService {
	public SimplePaginatedList find(SimplePaginatedList paginatedList, SysWorkerVO workerVO);
	public int delete(Integer[] ids);
	public SysWorkerVO save(SysWorkerVO sysWorkerVO, SysUserVO sysUserVO);
	public SysWorkerVO findById(Integer id);
}

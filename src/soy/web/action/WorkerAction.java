package soy.web.action;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysWorker;
import soy.basic.vo.SysWorkerVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.DateUtil;
import soy.util.ForwardUtil;
import soy.util.SystemUtil;
import soy.web.service.WorkerService;


public class WorkerAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(WorkerAction.class);
	private String page;
	private SimplePaginatedList paginatedList;
	private WorkerService workerService;
	private SysWorkerVO sysWorkerVO;
	private boolean isEdit;
	private Integer[] cbId;

	public String query() {

		SimplePaginatedList paginatedList = new SimplePaginatedList(getPage());
		paginatedList = getWorkerService()
				.find(paginatedList, getSysWorkerVO());
		setPaginatedList(paginatedList);
		this.addActionMessage("查询数据成功,时间：" + DateUtil.getTime(new Date()));
		setButtons(getLoginUser().getButtons("/worker/workerAction!query"));
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String update() {
		log.debug("");
		setEdit(true);
		if (!SystemUtil.isNull(getCbId())) {
			SysWorkerVO sysWorkerVO = getWorkerService().findById(getCbId()[0]);
			if (sysWorkerVO != null) {
				setSysWorkerVO(sysWorkerVO);
			} else {
				this.addActionError("没有该外派人员!");
			}
		} else {
			this.addActionError("还未选择外派人员!");
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	public String edit() {
		log.debug("edit is ok");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String add() {
		setEdit(false);
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String save() {
		SysWorkerVO sysWorkerVO = getWorkerService().save(getSysWorkerVO(), getLoginUser());
		if (sysWorkerVO != null) {
			this.addActionMessage("成功增加外派人员!");
		} else {
			this.addActionError("增加外派人员失败!");
		}
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String back() {
		return query();
	}

	public String delete() {
		int size = getWorkerService().delete(getCbId());
		this.addActionMessage("成功删除" + size + "个外派人员!");
		return query();
	}

	public WorkerService getWorkerService() {
		return workerService;
	}

	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public SysWorkerVO getSysWorkerVO() {
		return sysWorkerVO;
	}

	public void setSysWorkerVO(SysWorkerVO sysWorkerVO) {
		this.sysWorkerVO = sysWorkerVO;
	}

	public SimplePaginatedList getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(SimplePaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public Integer[] getCbId() {
		return cbId;
	}

	public void setCbId(Integer[] cbId) {
		this.cbId = cbId;
	}

}

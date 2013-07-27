package soy.web.action;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseAccount;
import soy.basic.vo.BaseAccountVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.DateUtil;
import soy.util.ForwardUtil;
import soy.web.service.BaseAccountService;

public class BaseAccountAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseAccountAction.class);
	private String page;
	private BaseAccountVO baseAccountVO;
	private SimplePaginatedList paginatedList;
	private boolean isEdit;
	private Integer[] cbId;

	private BaseAccountService baseAccountService;

	public String query() {
		log.debug("");
		SimplePaginatedList paginatedList = new SimplePaginatedList(getPage());
		paginatedList = getBaseAccountService().find(paginatedList, getBaseAccountVO());
		setPaginatedList(paginatedList);
		this.addActionMessage("查询数据成功,时间：" + DateUtil.getTime(new Date()));
		setButtons(getLoginUser().getButtons("/system/baseAccountAction!query"));
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("add is ok");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String update() {
		log.debug("update is ok");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String delete() {
		log.debug("delete is ok");
		System.out.println("是否是这个删除");
		int size = getBaseAccountService().delete(getCbId());
		this.addActionMessage("成功删除" + size + "户口结构!");
		return query();
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public BaseAccountVO getBaseAccountVO() {
		return baseAccountVO;
	}

	public void setBaseAccountVO(BaseAccountVO baseAccountVO) {
		this.baseAccountVO = baseAccountVO;
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

	public BaseAccountService getBaseAccountService() {
		return baseAccountService;
	}

	public void setBaseAccountService(BaseAccountService baseAccountService) {
		this.baseAccountService = baseAccountService;
	}

	public SimplePaginatedList getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(SimplePaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}

}

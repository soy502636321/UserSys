package soy.web.action;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysFunction;
import soy.basic.vo.BaseOrganVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.DateUtil;
import soy.util.ForwardUtil;
import soy.web.service.BaseOrganService;


public class BaseOrganAction extends BaseAction {
	private final static Logger log = LoggerFactory
			.getLogger(BaseOrganAction.class);
	private String page;
	private BaseOrganService baseOrganService;
	private BaseOrganVO baseOrganVO;
	private SimplePaginatedList paginatedList;

	public String query() {
		log.debug("query is ok");
		SimplePaginatedList paginatedList = new SimplePaginatedList(getPage());
		paginatedList = getBaseOrganService().find(paginatedList,
				getBaseOrganVO());
		setPaginatedList(paginatedList);
		this.addActionMessage("查询数据成功,时间：" + DateUtil.getTime(new Date()));
		setButtons(getLoginUser().getButtons("/baseOrgan/baseOrganAction!query"));
		
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("add is ok");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String delete() {
		log.debug("delete is ok");
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String update() {
		log.debug("update is ok");
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public BaseOrganService getBaseOrganService() {
		return baseOrganService;
	}

	public void setBaseOrganService(BaseOrganService baseOrganService) {
		this.baseOrganService = baseOrganService;
	}

	public BaseOrganVO getBaseOrganVO() {
		return baseOrganVO;
	}

	public void setBaseOrganVO(BaseOrganVO baseOrganVO) {
		this.baseOrganVO = baseOrganVO;
	}

	public SimplePaginatedList getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(SimplePaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}

}

package soy.web.action;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.vo.SysUserVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.DateUtil;
import soy.util.ForwardUtil;
import soy.web.service.UserService;


public class SysUserAction extends BaseAction {
	private final static Logger log = LoggerFactory
			.getLogger(SysUserAction.class);
	private String page;
	private SimplePaginatedList paginatedList;
	private UserService userService;
	private SysUserVO sysUserVO;

	public String query() {
		log.debug("query is ok");
		SimplePaginatedList paginatedList = getUserService().find(new SimplePaginatedList(getPage()), getSysUserVO());
		setPaginatedList(paginatedList);
		this.addActionMessage("查询数据成功,时间：" + DateUtil.getTime(new Date()));
		setButtons(getLoginUser().getButtons("/system/sysUserAction!query"));
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("add is ok");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String update() {
		log.debug("update is ok");
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String delete() {
		log.debug("delete is ok");
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public SimplePaginatedList getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(SimplePaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public SysUserVO getSysUserVO() {
		return sysUserVO;
	}

	public void setSysUserVO(SysUserVO sysUserVO) {
		this.sysUserVO = sysUserVO;
	}

}

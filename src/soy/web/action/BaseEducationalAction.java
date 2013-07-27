package soy.web.action;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.BaseAccount;
import soy.basic.database.entity.BaseEducational;
import soy.basic.vo.BaseEducationalVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.DateUtil;
import soy.util.ForwardUtil;
import soy.web.service.BaseEducationalService;

public class BaseEducationalAction extends BaseAction {
	private static final Logger log = LoggerFactory
			.getLogger(BaseEducationalAction.class);
	private String page;
	private BaseEducationalVO baseEducationalVO;
	private boolean isEdit;
	private Integer[] cbId;
	private BaseEducationalService baseEducationalService;
	private SimplePaginatedList paginatedList;

	public String query() {
		log.debug("");
		SimplePaginatedList paginatedList = new SimplePaginatedList(getPage());
		paginatedList = getBaseEducationalService().find(paginatedList,
				getBaseEducationalVO());
		setPaginatedList(paginatedList);
		this.addActionMessage("查询数据成功,时间：" + DateUtil.getTime(new Date()));
		this.setButtons(getLoginUser().getButtons("/system/baseEducationalAction!query"));
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	public String add() {
		log.debug("add is ok ");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String delete() {
		log.debug("");
		int size = getBaseEducationalService().delete(getCbId());
		this.addActionMessage("成功删除" + size + "学历!");
		return query();
	}

	public String update() {
		log.debug("update is ok");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public BaseEducationalVO getBaseEducationalVO() {
		return baseEducationalVO;
	}

	public void setBaseEducationalVO(BaseEducationalVO baseEducationalVO) {
		this.baseEducationalVO = baseEducationalVO;
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

	public BaseEducationalService getBaseEducationalService() {
		return baseEducationalService;
	}

	public void setBaseEducationalService(
			BaseEducationalService baseEducationalService) {
		this.baseEducationalService = baseEducationalService;
	}

	public SimplePaginatedList getPaginatedList() {
		return paginatedList;
	}

	public void setPaginatedList(SimplePaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}

}

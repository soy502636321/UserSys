package soy.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import soy.basic.dao.BaseAccountDAO;
import soy.basic.dao.BaseEducationalDAO;
import soy.basic.dao.BaseOrganDAO;
import soy.basic.database.entity.BaseAccount;
import soy.basic.database.entity.BaseEducational;
import soy.basic.database.entity.BaseOrgan;
import soy.basic.vo.SysUserVO;
import soy.util.GlobalUtil;
import soy.web.service.BaseAccountService;
import soy.web.service.BaseEducationalService;
import soy.web.service.BaseOrganService;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private Map<String, Object> session;
	private HttpServletRequest request;
	private List buttons;
	private Map baseOrgans;
	private Map baseAccounts;
	private Map baseEducationals;
	private BaseOrganService baseOrganService;
	private BaseAccountService baseAccountService;
	private BaseEducationalService baseEducationalService;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public SysUserVO getLoginUser() {
		return (SysUserVO) getSession().get(GlobalUtil.LOGINUSER);
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public boolean isNull(String obj) {
		if (obj == null || obj.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public List getButtons() {
		return buttons;
	}

	public void setButtons(List buttons) {
		this.buttons = buttons;
	}

	public boolean isNotNull(String obj) {
		return !isNull(obj);
	}

	public Map getBaseOrgans() {
		this.baseOrgans = this.getBaseOrganService().getMap();
		return baseOrgans;
	}

	public void setBaseOrgans(Map baseOrgans) {
		this.baseOrgans = baseOrgans;
	}

	public Map getBaseAccounts() {
		this.baseAccounts = this.getBaseAccountService().getMap();
		return baseAccounts;
	}

	public void setBaseAccounts(Map baseAccounts) {
		this.baseAccounts = baseAccounts;
	}

	public Map getBaseEducationals() {
		this.baseEducationals = getBaseEducationalService().getMap();
		System.out.println(baseEducationals.size());
		return baseEducationals;
	}

	public void setBaseEducationals(Map baseEducationals) {
		this.baseEducationals = baseEducationals;
	}

	public BaseOrganService getBaseOrganService() {
		return baseOrganService;
	}

	public void setBaseOrganService(BaseOrganService baseOrganService) {
		this.baseOrganService = baseOrganService;
	}

	public BaseAccountService getBaseAccountService() {
		return baseAccountService;
	}

	public void setBaseAccountService(BaseAccountService baseAccountService) {
		this.baseAccountService = baseAccountService;
	}

	public BaseEducationalService getBaseEducationalService() {
		return baseEducationalService;
	}

	public void setBaseEducationalService(
			BaseEducationalService baseEducationalService) {
		this.baseEducationalService = baseEducationalService;
	}

}

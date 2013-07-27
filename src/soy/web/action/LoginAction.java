package soy.web.action;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysUser;
import soy.basic.vo.SysUserVO;
import soy.util.ForwardUtil;
import soy.util.GlobalUtil;
import soy.util.PasswordControl;
import soy.web.service.SystemService;
import soy.web.service.UserService;


public class LoginAction extends BaseAction {

	private static final Logger log = LoggerFactory
			.getLogger(LoginAction.class);

	private UserService userService;
	private SystemService systemService;
	private SysUserVO sysUserVO;

	// 检查登录的用户名跟密码
	public String login() throws Exception {
		log.debug("login");

		// 清除session
		this.getSession().remove(GlobalUtil.LOGINUSER);

		// 返回登录用户的VO
		SysUserVO user = userService.login(getSysUserVO());
		
		if (user == null) {
			addActionError("用户名不存在！");
			return ForwardUtil.FORWARD_FAIL;
		}
		System.out.println(PasswordControl.EncryptePassword(getSysUserVO().getPassword()));
		if (!PasswordControl.EncryptePassword(getSysUserVO().getPassword()).equals(
				user.getPassword())) {
			addActionError("密码不准确！");
			return ForwardUtil.FORWARD_FAIL;
		}

		if (isNull(user.getUserState())
				|| !user.getUserState().equals(GlobalUtil.isNormal)) {
			addActionError("该用户状态被禁用或未启用！");
			return ForwardUtil.FORWARD_FAIL;
		}

		// 返回登录用户的功能
		if (user.isAdmin()) {
			log.debug("登录的用户是管理员，最高级别的权限");

			user.setFunctionList(userService.findSysFunctionAll());
		} else {
			log.debug("登录的用户是操作人");
			List list = new ArrayList();
			list.addAll(getSystemService().findFunctionByRoleCode(user.getSysRoleId()));
			user.setFunctionList(list);
		}

		// 设置用户的功能菜单
		this.getSession().put(GlobalUtil.MENUSTRING, getMenuStr(user));

		this.getSession().put(GlobalUtil.LOGINUSER, user);
		
		System.out.println(user.getButtons("/worker/workerAction!query"));

		return ForwardUtil.FORWARD_SUCCESS;
	}

	// 退出系统
	public String loginOut() throws Exception {
		// remove user session
		this.getSession().remove(GlobalUtil.LOGINUSER);
		return ForwardUtil.FORWARD_LOGIN_PAGE;
	}

	// 返回功能菜单树
	public String getMenuStr(SysUserVO userVO) {
		String contextPath = this.getRequest().getContextPath();
		String nodes = "";
		for (SysFunction function : userVO.getMenuFunctionList()) {
			String functionID = String.valueOf(function.getId());
			String parentID = "0";
			String functionName = function.getFunctionName();
			if (function.getSysFunction() != null) {
				parentID = String.valueOf(function.getSysFunction().getId());
			}
			String url = function.getFunctionUrl();
			String nodeUrl = "";
			if (url != null && !url.equals("")) {
				nodeUrl = ",url:\"" + contextPath + url + "\", target:\"I1\"";
			}
			nodes += "{ id:" + Double.valueOf(functionID) + ", pId:"
					+ Double.valueOf(parentID) + ", name:\"" + functionName
					+ "\"" + nodeUrl + "},";
		}

		if (nodes.length() > 0)
			nodes = "[ " + nodes.substring(0, nodes.length() - 1) + " ]";
		System.out.println(nodes);
		return nodes;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SysUserVO getSysUserVO() {
		return sysUserVO;
	}

	public void setSysUserVO(SysUserVO sysUserVO) {
		this.sysUserVO = sysUserVO;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

}

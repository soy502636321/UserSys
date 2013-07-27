package soy.basic.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.database.entity.SysFunction;
import soy.basic.database.entity.SysRole;
import soy.basic.database.entity.SysUser;
import soy.util.GlobalUtil;
import soy.util.PropsParser;
import soy.util.StringUtil;
import soy.util.SystemUtil;

public class SysUserVO {
	private static final Logger log = LoggerFactory.getLogger(SysUserVO.class);

	// admin
	public static final String SYSTEMADMIN = "SYSTEM_ADMIN";

	// 用户信息
	private SysUser sysUser;

	private String id;
	private SysRole sysRole;
	private String sysRoleId;
	private String sysRoleName;

	private String username;
	private String password;
	private String name;
	private String gender;
	private String genderId;
	private String phoneTh1;
	private String phoneTh2;
	private String emailTh1;
	private String emailTh2;
	private String userState;
	private String remark;
	private Set sysWorkers = new HashSet(0);

	// 功能
	private List<SysFunction> functionList;

	// menu Function List
	private List<SysFunction> menuFunctionList;

	// not menu Function List
	private List<SysFunction> otherFunctionList;

	public SysUserVO() {
	}

	public SysUserVO(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	/**
	 * 检查等用户是否是管理员
	 */
	public boolean isAdmin() {
		try {
			Properties props = PropsParser.getProperties();
			if (getSysUser().getUsername().equals(
					props.getProperty(SYSTEMADMIN))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List getButtons(String functionUrl) {
		List<SysFunction> list = getFunctionList();
		List buttons = new ArrayList();
		if (!SystemUtil.isNull(list) && !StringUtil.isNull(functionUrl)) {
			for (SysFunction sysFunction : list) {
				SysFunction parent = sysFunction.getSysFunction();
				if (parent != null
						&& functionUrl.equals(parent.getFunctionUrl())) {
					buttons.add(sysFunction);
				}
			}
		}
		return buttons;
	}

	public void setFunctionList(List<SysFunction> functionList) {
		this.functionList = functionList;

		// init menuFunctionList
		menuFunctionList = new ArrayList<SysFunction>();
		otherFunctionList = new ArrayList<SysFunction>();
		for (SysFunction function : functionList) {
			if (GlobalUtil.isMenu.equals(function.getFunctionType())) {
				menuFunctionList.add(function);
			} else {
				otherFunctionList.add(function);
			}

		}
	}

	public List<SysFunction> getFunctionList() {
		return functionList;
	}

	public List<SysFunction> getMenuFunctionList() {
		return menuFunctionList;
	}

	public List<SysFunction> getOtherFunctionList() {
		return otherFunctionList;
	}

	public void setMenuFunctionList(List<SysFunction> menuFunctionList) {
		this.menuFunctionList = menuFunctionList;
	}

	public void setOtherFunctionList(List<SysFunction> otherFunctionList) {
		this.otherFunctionList = otherFunctionList;
	}

	public String getId() {
		if (getSysUser() != null && this.id == null) {
			this.id = String.valueOf(getSysUser().getId());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SysRole getSysRole() {
		return getSysUser().getSysRole();
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getSysRoleId() {
		if (getSysUser() != null && this.sysRoleId == null) {
			this.sysRoleId = String.valueOf(getSysUser().getSysRole().getId());
		}
		return sysRoleId;
	}

	public void setSysRoleId(String sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	public String getSysRoleName() {
		if (getSysUser() != null && this.sysRoleName == null) {
			this.sysRoleName = getSysUser().getSysRole().getRoleName();
		}
		return sysRoleName;
	}

	public void setSysRoleName(String sysRoleName) {
		this.sysRoleName = sysRoleName;
	}

	public String getUsername() {
		if (getSysUser() != null && this.username == null) {
			this.username = getSysUser().getUsername();
		}
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		if (getSysUser() != null && this.password == null) {
			this.password = getSysUser().getPassword();
		}
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		if (getSysUser() != null && this.name == null) {
			this.name = getSysUser().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		if (getSysUser() != null && this.gender == null) {
			if (getSysUser().getGender() == null
					|| getSysUser().getGender().intValue() == 0) {
				this.gender = "女";
			} else {
				this.gender = "男";
			}
		}
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneTh1() {
		if (getSysUser() != null && this.phoneTh1 == null) {
			this.phoneTh1 = getSysUser().getPhoneTh1();
		}
		return phoneTh1;
	}

	public void setPhoneTh1(String phoneTh1) {
		this.phoneTh1 = phoneTh1;
	}

	public String getPhoneTh2() {
		return phoneTh2;
	}

	public void setPhoneTh2(String phoneTh2) {
		this.phoneTh2 = phoneTh2;
	}

	public String getEmailTh1() {
		if (getSysUser() != null && this.emailTh1 == null) {
			this.emailTh1 = getSysUser().getEmailTh1();
		}
		return emailTh1;
	}

	public void setEmailTh1(String emailTh1) {
		this.emailTh1 = emailTh1;
	}

	public String getEmailTh2() {
		return emailTh2;
	}

	public void setEmailTh2(String emailTh2) {
		this.emailTh2 = emailTh2;
	}

	public String getUserState() {
		if (getSysUser() != null && this.userState == null) {
			if (getSysUser().getUserState().intValue() == 0) {
				this.userState = "禁用";
			} else if (getSysUser().getUserState().intValue() == 1) {
				this.userState = "正常";
			} else {
				this.userState = "未知";
			}
		}
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getRemark() {
		if (getSysUser() != null && this.remark == null) {
			this.remark = getSysUser().getRemark();
		}
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSysWorkers() {
		return sysWorkers;
	}

	public void setSysWorkers(Set sysWorkers) {
		this.sysWorkers = sysWorkers;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

}

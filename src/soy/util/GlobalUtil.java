package soy.util;

import java.util.Properties;

public class GlobalUtil {
	
	public static final Integer NORMAL = 0;
	
	public static final Integer ABNORMAL = 1;
	
	// 登录用户
	public static final String LOGINUSER = "loginUser";
	
	// 超级用户
	public static final String SYSTEMADMIN = "SYSTEM_ADMIN";
	
	//按钮功能查看
	public static final String SYSTEMBUTTONS = "buttons";
	
	// is menu
	public static final String isMenu = "01";
	
	public static final String isBtn = "02";
	
	public static final String isNormal = "正常";
	
	
	// menu string
	public static final String MENUSTRING = "menuStr";
	
	
	// message
	public static final String saveSuccess = "保存成功";
	
	
	// check is system admin
	public static boolean isSystemAdmin(String userId){
		try {
			Properties props = PropsParser.getProperties();
			if(userId.equals(props.getProperty(SYSTEMADMIN))){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断用户名,密码是否对应超级管理员
	 */
	public static boolean isSuperUser(String userName) {
		if (ForwardUtil.superUser.equals(userName)) {
			return true;
		} else {
			return false;
		}
	}
	
	// get pageSize
	public static int getPageSize(){
		return PropsParser.getPageSize();
	}

}

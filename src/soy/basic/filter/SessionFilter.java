package soy.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soy.util.GlobalUtil;


public class SessionFilter implements Filter {

	public void destroy() {
		System.out.println("This is Filter's Destroy!!!");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		System.out.println("========================>>>>user:"
				+ req.getSession().getAttribute(GlobalUtil.LOGINUSER));
		if (!req.isRequestedSessionIdValid()) {
			System.out.println("页面过期");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (null != req.getSession()
				&& null != req.getSession().getAttribute(GlobalUtil.LOGINUSER)) {
			System.out.println("account在session中");
			System.out.println("一共反问了几次？");
			chain.doFilter(request, response);
		} else {
			System.out.println("非法访问被过滤");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}

		// /**
		// * 判断系统管理后台登录用户会话是否过期
		// * 如果过期,则重定向到登录界面，否则继续执行
		// */
		// if(req.getSession().getAttribute(GlobalUtil.LOGINUSER) == null){
		// System.out.println("用户尚未登录 request.getSession().getAttribute('USER_ID') == null");
		// res.sendRedirect(req.getContextPath() + "/login.jsp");
		// }
		// chain.doFilter(request, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("This is Filter's Initialization!!!");
	}

}

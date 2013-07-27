<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/displaytag-12.tld" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-tags.tld" prefix="s"%>
<%@ taglib uri="/WEB-INF/button.tld" prefix="hq" %>
<jsp:directive.page import="soy.util.GlobalUtil"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>mainMenu</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/js/displayTag.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/js/commonCheck.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/js/public.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></SCRIPT>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui-1.9.2.custom.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/zTreeStyle.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/displayTag.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.9.2.custom.min.css" />	
  </head>
  
  <%
	int pageSize = GlobalUtil.getPageSize();
  %>
  

</html>

<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="soy.basic.vo.SysUserVO"%>
<%@page import="soy.util.GlobalUtil"%>
<%@page import="soy.basic.database.entity.SysFunction"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'left.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE2 {
	color: #43860c;
	font-size: 12px;
}

a:link {
	font-size: 12px;
	text-decoration: none;
	color: #43860c;
}

a:visited {
	font-size: 12px;
	text-decoration: none;
	color: #43860c;
}

a:hover {
	font-size: 12px;
	text-decoration: none;
	color: #FF0000;
}
-->
</style>



		<SCRIPT type="text/javascript">
<!--
	var setting = {
		data : {
			simpleData : {
				enable : true
			}
		}
	};

	var zNodes =
<%=(String) session.getAttribute(GlobalUtil.MENUSTRING)%>
	;

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
//-->
</SCRIPT>


	</head>

	<body>
		<table width="177" height="100%" border="0" cellpadding="0" 
			cellspacing="0">
			<tr>
				<td valign="top" style="padding: 0px;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						style="table-layout: fixed">
						<tr>
							<td>
								<div>
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

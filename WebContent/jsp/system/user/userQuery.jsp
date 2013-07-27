<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	
	<body>
		<s:form action="sysUserAction" namespace="/system">
			<br>
			<table>
				<tr>
					<td>
						用户编号
					</td>
					<td>
						<s:textfield name="sysUserVO.id"></s:textfield>
					</td>
					<td>
						用户名
					</td>
					<td>
						<s:textfield name="sysUserVO.username"></s:textfield>
					</td>
					<td>
						名字
					</td>
					<td>
						<s:textfield name="sysUserVO.name"></s:textfield>
					</td>
					<td>
						性别
					</td>
					<td>
						<select name="sysUserVO.genderId">
							<option></option>
							<option value="1">男</option>
							<option value="0">女</option>
						</select>
					</td>
					<td>
						权限级别
					</td>
					<td>
						<select name="sysUserVO.sysRoleId">
						</select>
					</td>
					<td>
						电话
					</td>
					<td>
						<s:textfield name="sysUserVO.phoneTh1"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						邮箱地址
					</td>
					<td>
						<s:textfield name="sysUserVO.emailTh1"></s:textfield>
					</td>
					<td>
						用户状态
					</td>
					<td>
						<select name="sysUserVO.userState">
						</select>
					</td>
					<td>
						备注
					</td>
					<td>
						<s:textfield name="sysUserVO.remark"></s:textfield>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" action="sysUserAction!query"></s:submit>
						&nbsp;&nbsp;&nbsp;
						<s:reset value="重  置"></s:reset>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						${ actionMessages[0] }${actionErrors[0]}
					</td>
				</tr>
			</table>
			<br>
			<table style="width: 100%">
				<tr>
					<td></td>
				</tr>
				<tr>
					<td>
						<display:table name="paginatedList" class="simple"
							requestURI="sysUserAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="用户编号"></display:column>
							<display:column property="username" title="用户名"></display:column>
							<display:column property="name" title="名字"></display:column>
							<display:column property="gender" title="性别"></display:column>
							<display:column property="sysRoleName" title="权限级别"></display:column>
							<display:column property="phoneTh1" title="电话"></display:column>
							<display:column property="emailTh1" title="邮箱地址"></display:column>
							<display:column property="userState" title="用户状态"></display:column>
							<display:column property="remark" title="备注"></display:column>
						</display:table>
					</td>
				</tr>
			</table>
			<table width="100%">
				<tr>
					<td class="tdCenter">
						<s:iterator value="buttons" var="sysFunction" status="status">
							<input type="submit" value="<s:property value="functionName"/>"
								name="action:<s:property value="functionUrl"/>" onclick="return edit(this);" />
						</s:iterator>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
	<script type="text/javascript">
	function edit(o) {
		var value = $(o).val();
		switch(value) {
			case '删除':
				if(moreSelect()) {
					return true;
				}
				return false;
			case '修改':
				if (singleSelect()) {
					return true;
				} 
				return false;
		}
		return false;
	}
	
	$(function() {
		$('.calendar').each(
				function() {
					$(this).attr("id", ++$.datepicker.uuid).removeClass(
							"hasDatepicker").datepicker({
						numberOfMonths : 1,
						showButtonPanel : false,
						changeYear : true,
						changeMonth : true,
						dateFormat : 'yy年mm月dd日'
					});
				});
	});
	</script>
</html>
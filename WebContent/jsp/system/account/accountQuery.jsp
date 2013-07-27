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
		<s:form action="baseAccountAction" namespace="/system">
			<br>
			<table>
				<tr>
					<td>
						户口结构编号
					</td>
					<td>
						<s:textfield name="baseAccountVO.id"></s:textfield>
					</td>
					<td>
						户口结构名称
					</td>
					<td>
						<s:textfield name="baseAccountVO.accountName"></s:textfield>
					</td>
					<td>
						备注
					</td>
					<td>
						<s:textfield name="baseAccountVO.remark"></s:textfield>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" action="baseAccountAction!query"></s:submit>
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
							requestURI="baseAccountAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="户口结构编号"></display:column>
							<display:column property="accountName" title="户口结构名称"></display:column>
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
		<hq:button functionId="34343">
			<hq:script function="xxxx" action="xxxx" functionName="xxxxx"></hq:script>
		</hq:button>
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
	});
	</script>
</html>
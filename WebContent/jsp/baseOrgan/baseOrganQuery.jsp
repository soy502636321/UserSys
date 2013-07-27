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
		<s:form action="baseOrganAction" namespace="/baseOrgan">
			<br>
			<table>
				<tr>
					<td>
						单位编号
					</td>
					<td>
						<s:textfield name="orderVO.sysUserName"></s:textfield>
					</td>
					<td>
						单位名称
					</td>
					<td>
						<s:textfield name="orderVO.id"></s:textfield>
					</td>
					<td>
						联系人
					</td>
					<td>
						<select>
							<option selected="selected"></option>
							<option value="1">
								男
							</option>
							<option value="0">
								女
							</option>
						</select>
					</td>
					<td>
						电话
					</td>
					<td>
						<s:textfield cssClass="calendar"></s:textfield>
					</td>
					<td>
						手机
					</td>
					<td>
						<s:textfield name="orderVO.id"></s:textfield>
					</td>
					<td>
						地址
					</td>
					<td>
						<s:textfield name="orderVO.id"></s:textfield>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" action="baseOrganAction!query"></s:submit>
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
							requestURI="baseOrganAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="单位编号"></display:column>
							<display:column property="organName" title="单位名称"></display:column>
							<display:column property="organContact" title="联系人"></display:column>
							<display:column property="phoneTh1" title="电话"></display:column>
							<display:column property="mobilePhoneTh1" title="手机"></display:column>
							<display:column property="organAddress" title="地址"></display:column>
							<display:column property="ramark" title="备注"></display:column>
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
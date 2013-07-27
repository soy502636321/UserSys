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
		<s:form action="workerAction" namespace="//worker">
			<br>
			<table>
				<tr>
					<td>
						序号
					</td>
					<td>
						<s:textfield name="sysWorkerVO.id"></s:textfield>
					</td>
					<td>
						姓名
					</td>
					<td>
						<s:textfield name="sysWorkerVO.name"></s:textfield>
					</td>
					<td>
						性别
					</td>
					<td>
						<select name="sysWorkerVO.gender">
							<option></option>
							<s:if test="sysWorkerVO.isMan">
								<option value="1" selected="selected">
									男
								</option>
							</s:if>
							<s:else>
								<option value="1">
									男
								</option>
							</s:else>
							<s:if test="sysWorkerVO.isWoman">
								<option value="0" selected="selected">
									女
								</option>
							</s:if>
							<s:else>
								<option value="0">
									女
								</option>
							</s:else>
						</select>
					</td>
					<td>
						出生日期
					</td>
					<td>
						<s:textfield name="sysWorkerVO.birthdayStr" cssClass="calendar"></s:textfield>
					</td>
					<td>
						身份证号码
					</td>
					<td>
						<s:textfield name="sysWorkerVO.idCard"></s:textfield>
					</td>
					<td>
						所属公司
					</td>
					<td>
						<s:select list="baseOrgans" listKey="key" listValue="value">
						</s:select>
					</td>
				</tr>
				<tr>
					<td>
						护照号码
					</td>
					<td>
						<s:textfield name="sysWorkerVO.passport"></s:textfield>
					</td>
					<td>
						户口结构
					</td>
					<td>
						<s:select list="baseAccounts" name="sysWorkerVO.baseAccountId"
							listKey="key" listValue="value"></s:select>
					</td>
					<td>
						学历
					</td>
					<td>
						<s:select list="baseEducationals"
							name="sysWorkerVO.baseEducationalId" listKey="key"
							listValue="value"></s:select>
					</td>
					<td>
						出国日期
					</td>
					<td>
						<s:textfield name="sysWorkerVO.outDateStr" cssClass="calendar" />
					</td>
					<td>
						回国日期
					</td>
					<td>
						<s:textfield name="sysWorkerVO.inDateStr" cssClass="calendar"></s:textfield>
					</td>
					<td>
						投保日期
					</td>
					<td>
						<s:textfield name="sysWorkerVO.insureDateStr" cssClass="calendar"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
						备案
					</td>
					<td>
						<select name="sysWorkerVO.record">
							<option selected="selected"></option>
							<option value="1">
								是
							</option>
							<option value="0">
								否
							</option>
						</select>
					</td>
					<td>
						备注
					</td>
					<td>
						<s:textarea name="sysWorkerVO.remark"></s:textarea>
					</td>
					<td>
						详细地址
					</td>
					<td>
						<s:textarea name="sysWorkerVO.address"></s:textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<s:submit value="查  询" action="workerAction!query"></s:submit>
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
							requestURI="workerAction!query">
							<display:column property="id"
								decorator="soy.common.displaytag.CheckBoxDecorator"
								style="width:3%;"
								title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
							</display:column>
							<display:column property="id" title="序号"></display:column>
							<display:column property="name" title="姓名"></display:column>
							<display:column property="gender" title="性别"></display:column>
							<display:column property="baseOrganName" title="现派遣公司"></display:column>
							<display:column property="birthdayStr" title="出生日期"></display:column>
							<display:column property="idCard" title="身份证号码"></display:column>
							<display:column property="address" title="详细住址"></display:column>
							<display:column property="passport" title="护照号码"></display:column>
							<display:column property="baseAccountName" title="户口结构"></display:column>
							<display:column property="baseEducationalName" title="学历"></display:column>
							<display:column property="outDateStr" title="出国日期"></display:column>
							<display:column property="inDateStr" title="回国日期"></display:column>
							<display:column property="insureDateStr" title="投保日期"></display:column>
							<display:column property="record" title="备案"></display:column>
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
								name="action:<s:property value="functionUrl"/>"
								onclick="return edit(this);" />
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
			case '删  除':
				if(moreSelect()) {
					return true;
				}
				return false;
			case '修  改':
				if(singleSelect()) {
					return true;
				}
				return false;
		}
		return true;
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
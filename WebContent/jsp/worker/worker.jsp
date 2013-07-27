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
	<s:form namespace="/worker" method="post">
		<s:hidden name="sysWorkerVO.id"></s:hidden>
		<table>
			<tr>
				<td>
					<span id="actionMessages" style="font: #003344;">${ actionMessages[0] }</span>
					<span>${actionErrors[0]}</span>
				</td>
			</tr>
		</table>
		<br>
		<table align="center" class="borderTable">
			<tr>
				<td>姓名:</td>
				<td><s:textfield name="sysWorkerVO.name"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><select name="sysWorkerVO.gender">
						<option></option>
						<option value="1">男</option>
						<option value="0">女</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>现派遣公司:</td>
				<td><s:select list="baseOrgans" name="sysWorkerVO.baseOrganId"
						listKey="key" listValue="value"></s:select>
				</td>
			</tr>

			<tr>
				<td>出生日期:</td>
				<td><s:textfield cssClass="calendar"
						name="sysWorkerVO.birthdayStr"></s:textfield></td>
			</tr>

			<tr>
				<td>身份证号码:</td>
				<td><s:textfield name="sysWorkerVO.idCard"></s:textfield>
				</td>
			</tr>

			<tr>
				<td>护照号码:</td>
				<td><s:textfield name="sysWorkerVO.passport"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>户口结构:</td>
				<td><s:select list="baseAccounts"
						name="sysWorkerVO.baseAccountId" listKey="key" listValue="value"></s:select>
				</td>
			</tr>
			<tr>
				<td>学历:</td>
				<td><s:select list="baseEducationals"
						name="sysWorkerVO.baseEducationalId" listKey="key"
						listValue="value"></s:select>
				</td>
			</tr>
			<tr>
				<td>出国日期:</td>
				<td><s:textfield cssClass="calendar"
						name="sysWorkerVO.outDateStr"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>回国日期:</td>
				<td><s:textfield cssClass="calendar"
						name="sysWorkerVO.inDateStr"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>投保日期:</td>
				<td><s:textfield cssClass="calendar"
						name="sysWorkerVO.insureDateStr"></s:textfield></td>
			</tr>
			<tr>
				<td>备案:</td>
				<td><select name="sysWorkerVO.record">
						<option></option>
						<option value="1">是</option>
						<option value="0">否</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>详细地址:</td>
				<td><s:textarea name="sysWorkerVO.address"></s:textarea>
				</td>
			</tr>
			<tr>
				<td>备注:</td>
				<td><s:textarea name="sysWorkerVO.remark"></s:textarea>
				</td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<td class="tdCenter"><s:submit value="保  存"
						action="workerAction!save" onclick="return save(this);"></s:submit>&nbsp;&nbsp;
					<s:submit value="返  回" action="workerAction!back"></s:submit></td>
			</tr>
		</table>
	</s:form>
</body>
<script type="text/javascript">
	function save(o) {
		var datePatt = /[\d]{4}年[\d]{2}月[\d]{2}日/g;
		var name = $('input[name="sysWorkerVO.name"]').val();
		if (!name || name.length <= 0) {
			alert('姓名不能为空!');
			$('input[name="sysWorkerVO.name"]').focus();
			return false;
		}
		var gender = $('select[name="sysWorkerVO.gender"]').val();
		if (!gender || gender.length <= 0) {
			alert('请选择性别!');
			$('select[name="sysWorkerVO.gender"]').focus();
			return false;
		}
		var baseOrganId = $('select[name="sysWorkerVO.baseOrganId"]').val();
		if (!baseOrganId || baseOrganId.length <= 0 || baseOrganId == '0') {
			alert('请选择派遣公司');
			$('select[name="sysWorkerVO.baseOrganId"]').focus();
			return false;
		}
		var birthdayStr = $('input[name="sysWorkerVO.birthdayStr"]').val();
		if (!birthdayStr || birthdayStr.length <= 0) {
			alert('请选择出生日期');
			$('input[name="sysWorkerVO.birthdayStr"]').focus();
			return false;
		} else {
			if (birthdayStr.length != 11
					|| !new RegExp(datePatt).test(birthdayStr)) {
				alert('出生日期格式不对，请检查是否符合[0000年00月00日]!');
				$('input[name="sysWorkerVO.birthdayStr"]').focus();
				return false;
			}
		}
		var idCard = $('input[name="sysWorkerVO.idCard"]').val();
		if (!idCard || idCard.length <= 0) {
			alert('身份证号码不能为空!');
			$('input[name="sysWorkerVO.idCard"]').focus();
			return false;
		} else {
			if (idCard.length != 15 && idCard.length != 18) {
				alert('身份证号码长度不对，只能为18位或者15位!');
				$('input[name="sysWorkerVO.idCard"]').focus();
				return false;
			}
		}
		var passport = $('input[name="sysWorkerVO.passport"]').val();
		if (!passport || passport.length <= 0) {
			alert('护照号码不能为空!');
			$('input[name="sysWorkerVO.passport"]').focus();
			return false;
		}
		var baseAccountId = $('select[name="sysWorkerVO.baseAccountId"]').val();
		if (!baseAccountId || baseAccountId.length <= 0 || baseAccountId == '0') {
			alert('请选择户口结构!');
			$('select[name="sysWorkerVO.baseAccountId"]').focus();
			return false;
		}
		var baseEducationalId = $(
				'select[name="sysWorkerVO.baseEducationalId"]').val();
		if (!baseEducationalId || baseEducationalId.length <= 0
				|| baseEducationalId == '0') {
			alert('请选择学历!');
			$('select[name="sysWorkerVO.baseEducationalId"]').focus();
			return false;
		}
		var outDateStr = $('input[name="sysWorkerVO.outDateStr"]').val();
		if (!outDateStr || outDateStr.length <= 0) {
			alert('请选择出国日期!');
			$('input[name="sysWorkerVO.outDateStr"]').focus();
			return false;
		} else {
			if (outDateStr.length != 11
					|| !new RegExp(datePatt).test(outDateStr)) {
				alert('出国日期格式不对，请检查是否符合[0000年00月00日]!');
				$('input[name="sysWorkerVO.outDateStr"]').focus();
				return false;
			}
		}
		var inDateStr = $('input[name="sysWorkerVO.inDateStr"]').val();
		if (!inDateStr || inDateStr.length <= 0) {
			alert('请选择回国日期!');
			$('input[name="sysWorkerVO.inDateStr"]').focus();
			return false;
		} else {
			if (inDateStr.length != 11 || !new RegExp(datePatt).test(inDateStr)) {
				alert('回国日期格式不对，请检查是否符合[0000年00月00日]!');
				$('input[name="sysWorkerVO.inDateStr"]').focus();
				return false;
			}
		}
		var insureDateStr = $('input[name="sysWorkerVO.insureDateStr"]').val();
		if (!insureDateStr || insureDateStr.length <= 0) {
			alert('请选择投保日期!');
			$('input[name="sysWorkerVO.insureDateStr"]').focus();
			return false;
		} else {
			if (insureDateStr.length != 11
					|| !new RegExp(datePatt).test(insureDateStr)) {
				alert('投保日期格式不对，请检查是否符合[0000年00月00日]!');
				$('input[name="sysWorkerVO.insureDateStr"]').focus();
				return false;
			}
		}
		var record = $('select[name="sysWorkerVO.record"]').val();
		if (!record || record.length <= 0) {
			alert('请选择是否备案!');
			$('input[name="sysWorkerVO.record"]').focus();
			return false;
		}
		return true;
	}

	$(function() {
		var messages = $('#actionMessages').text();
		if (messages && messages.length > 0) {
			$('input[value="保  存"]')
		}
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

	})
</script>
</html>
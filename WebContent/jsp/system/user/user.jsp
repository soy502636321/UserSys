<jsp:directive.include file="/include/mainMenu.jsp"/>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>

<body>
    <s:form namespace="/system">
    	<br>
    	<table align="center" class="borderTable">
	    	<tr>
	     		<td>用户编号:</td>
   				<td>
   					<s:if test="isEdit">
	        			<s:property value="userId"></s:property>
   					</s:if>
   					<s:else>
	        			<s:textfield name="userId"></s:textfield>
   					</s:else>
   				</td>
		    </tr>
	    	<tr>
	     		<td>用户名称:</td>
	        	<td><s:textfield name="userName"></s:textfield></td>
	        </tr>
	    	<tr>
	     		<td>部门:</td>
	        	<td><s:select list="sectionList" listKey="sectionCode" listValue="sectionName" name="sectionCode"></s:select></td>
	        </tr>
	        
	    	<tr>
	     		<td>备注:</td>
	        	<td><s:textfield name="remark"></s:textfield></td>
	        </tr>
    	</table>
    	<br>
   		<table >
   			<tr>
   				<td class="tdCenter">
   					<s:submit value="保  存" action="userAction!save" ></s:submit>&nbsp;&nbsp;
   					<s:submit value="返  回" action="userAction!back" ></s:submit>
   				</td>
   			</tr>
   		</table>
	</s:form>
</body>
</html>
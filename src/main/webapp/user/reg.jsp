<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		$('#user_reg_regDialog_form').form({
			url : '${pageContext.request.contextPath}/userAction!addUser.action',
			success : function(data) {
			var obj = $.parseJSON(data);
			if(obj.success){
				console.info(obj);
				$('#user_reg_regDialog').dialog('close');
			}
			$.messager.show({
				title:'提示',
				msg:obj.msg
			});
		 }
		});
		$('#user_reg_regDialog_form input').bind('keyup', function(event) {//按回车提交表单
			if (event.keyCode == '13') {
				$('#user_reg_regDialog_form').submit();
			}
		});
	});
</script>
<div id="user_reg_regDialog" style="width:260px" class="easyui-dialog"
	data-options="title : '注册',
			modal : true,
			closed:true,
			buttons : [ {
				text : '保存',
				iconCls:'icon-edit',				
				handler:function(){	
				$('#user_reg_regDialog_form').submit();
				}
			}]">
	<form id="user_reg_regDialog_form" name="user_reg_regDialog_form" method="post">
		<table>
			<tr>
				<td>账号</td>
				<td><input name="name" type="text" class="easyui-validatebox"
					data-options="required:true,missingMessage:'缺少必填'" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input id="pwd" name="pwd" type="password"
					class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>密码重复</td>
				<td><input name="repwd" type="password"
					class="easyui-validatebox" required="required"
					validType="eqPwd['#pwd']" /></td>
			</tr>
		</table>
	</form>
</div>
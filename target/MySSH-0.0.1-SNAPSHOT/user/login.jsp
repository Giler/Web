<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		$('#user_login_loginDialog_form').form(
						{
							url : '${pageContext.request.contextPath}/userAction!login.action',
							success : function(data) {
								var obj = $.parseJSON(data);
								if (obj.success) {
									console.info(obj);
									$('#user_login_loginDialog').dialog('close');
								}
								$.messager.show({
									title : '提示',
									msg : obj.msg
								});
							}
						});
		$('#user_login_loginDialog_form input').bind('keyup', function(event) {//按回车提交表单
			if (event.keyCode == '13') {
				$('#user_login_loginDialog_form').submit();
			}
		});
	});
</script>
<div id="user_login_loginDialog" class="easyui-dialog"
	data-options="title:'登录',modal:true,closable:false,buttons:[{
				text:'登录',
				iconCls:'icon-edit',
				handle:function(){
				$('#user_login_loginDialog_form').submit();
				}
			},{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#user_reg_regDialog input').val('');
					$('#user_reg_regDialog').dialog('open');
				}
			}]">
	<form id="user_login_loginDialog_form"
		name="user_login_loginDialog_form" method="post">
		<table>
			<tr>
				<td>账号</td>
				<td><input name="name" type="text" class="easyui-validatebox"
					data-options="required:true,missingMessage:'账号必填'" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="pwd" type="password" class="easyui-validatebox"
					data-options="required:true,missingMessage:'密码必填'" /></td>
			</tr>
		</table>
	</form>
</div>
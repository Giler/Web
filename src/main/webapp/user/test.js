//注册按钮，初始化为关闭

	//form表单的初始化函数
	$(function() {
		$('#index_regDialog_form').form({
			url : '${pageContext.request.contextPath}/userAction!addUser.action',
			success : function(data) {
				var obj = $.parseJSON(data);
				if(obj.success){
					console.info(obj);
					$('#index_regDialog').dialog('close');
				}
				$.messager.show({
					title:'提示',
					msg:obj.msg
				});
			},
		});
	});   
	//AJAX提交表单
	 function submitAjax() {
		if($('#index_regDialog_form').form('validate')){
			alert("进入ajax");
			$.ajax({
						url : '${pageContext.request.contextPath}/userAction!addUser.action',
						data:$('#index_regDialog_form').serialize(),
						success : function(data,textStatus,jqXHR){
							var obj = $.parseJSON(data);
							if(obj.success){
								console.info(obj);
								$('#index_regDialog').dialog('close');
							}
							$.messager.show({
								title:'提示',
								msg:obj.msg
							});
						}
					});
		}else{
			$.messager.show({
				title:'提示',
				msg:'注册失败',
			});
		}
		
		
	}; 
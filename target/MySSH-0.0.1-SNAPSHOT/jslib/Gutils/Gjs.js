$.extend($.fn.validatebox.defaults.rules, {
	eqPwd : {
		validator : function(value,param) {
			return value == $(param[0]).val();
		},
		message : '两次密码不一致'
	}
});

$.extend($.fn.validatebox.defaults.rules, {
    equals: {
        validator: function(value,param){
            return value == $(param[0]).val();
        },
        message: 'Field do not match.'
    }
});
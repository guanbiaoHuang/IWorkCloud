$(document).ready(function(){                
     $("#iconImg").click(function(){
        $("#icons").click();
     });
     $("#icons").change(function(){
        var file = this.files[0];
        var fr = new FileReader();
        fr.readAsDataURL(file);
        fr.onload = function(){    		
             $('#iconImg').attr('src',fr.result);
        }
                                 

     });
     msg();

     
});

function msg(){
	
	if(($("#msg").text().trim())!=""){
		layer.msg($("#msg").text().trim());
	}
	
}

function check(){
	var $phone = $("#registPhone").val();
	var $password = $("#password").val();
	var $passwordSec = $("#passwordSec").val();
	var $verifyCode = $("#verifyCode").val();
	var $icon = $("#icons").val();
	if(!(/^1[3456789]\d{9}$/.test($phone))){
		layer.msg("手机号非法");	
		return false;
	}	
	if($icon.length==0){
		layer.msg("请点击头像选择头像");
		return false;
	}
	if(!(/^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)\S{8,16}$/.test($password))){
		layer.msg("密码必须由字母开头的8-16位字母加数字组成");
		return false;
	}
	if(!($password==$passwordSec)){
		layer.msg("两次密码不一致");
		return false;
	}
	if(!(/\d{6}$/.test($verifyCode))){
		layer.msg("验证码为6位数字");
		return false;
	}
	return true;
	
}





function getCodeClick(){
		
   var btn = $("#getCode");
   var count = 60;
   var resend = setInterval(function(){
	   count--;
	   if (count > 0){
	       btn.text(count+"秒后可重新获取");
	    }else {
	       clearInterval(resend);
	       btn.text("获取验证码").removeAttr('disabled style');
	    }}, 1000);
   btn.attr('disabled',true).css('cursor','not-allowed');
	
}

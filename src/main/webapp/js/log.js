function bind(link1,link2){
    layer.prompt({title: '请输入输入工号绑定', formType: 1},function(val, index){
        $.post(
            link1,
            {"staffID":val},
            function (result) {
                if(result=="success"){
                    layer.msg("绑定成功，即将跳转");
                    setTimeout(function (){$(location).attr('href', link2)},3000);
                }else {
                    layer.msg(result);
                }

            }
        )
        layer.close(index);
    });
}


function hh() {
    layer.msg("登陆");
}
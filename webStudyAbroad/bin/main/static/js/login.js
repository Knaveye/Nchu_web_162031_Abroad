
$(".login-sub").click(function () {
   // var a = $("input[name='killOrder']:checked").val();

    var radionum = $('input:radio:checked').val();
    var account = $(".login-account").val()
    var password = $(".login-password").val()

   /* $(".login-account").blur(function(){
        if($(".login-account").val().length==0){
            $("#account-span").html("账号不能为空");

        }
    });
    $(".login-password").blur(function(){
        if($(".login-account").val().length==0){
            $("#password-span").html("密码不能为空");
        }
    });*/

if(account.length==0){
    alert("账户不能为空哦，输入账号试试！")

}else if(password.length==0){
    alert("密码不能为空哦，输入密码试试！")
}else {
    $.ajax({
        //请求方式
        type: 'get',
        contentType: "json",
        //发送请求的地址
        url: '/login/verify',
        //服务器返回的数据类型
        dataType: 'json',
        //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
        data: {
            radionum: radionum,
            account: account,
            password: password,
        },
        success: function (data) {

            if (data.result== 'true') {
           //  window.location.href = "/index";
           //      window.location.href = "/abroadexamination";
              //  window.location.href = "/abroadapplication";

                if(data.number == "user"){

                    window.location.href = "/index";
                }else if(data.number == "schoolmanage"){

                    window.location.href = "/manageNews";

                }else if(data.number == "webManage"){

                    window.location.href = "/userInfo";
                }
            } else {
                alert("账号密码不匹配请重新输入")
            }
        },
        error: function (data) {
            alert('BB')

        }

    });
}
})



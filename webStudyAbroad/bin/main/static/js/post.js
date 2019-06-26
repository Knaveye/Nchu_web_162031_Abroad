$('.btn-sendpost').click(function () {
    var ptitle = $('.post-title').val()
    var pcontext = $('.post-context').text()
if(ptitle.length==0){
    alert("帖子标题不能为空！")
}else if(pcontext.length==0){
    alert("帖子内容不能为空！")
}else {
    $.ajax({
        //请求方式
        type: 'get',
        contentType: "json",
        //发送请求的地址
        url: '/addPost',
        //服务器返回的数据类型
        dataType: 'json',
        //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
        data: {
            ptitle: ptitle,
            pcontext: pcontext,
        },
        success: function (data) {
            if (data) {
                window.location.href = "/post/index";

            } else {
                alert('1')
            }
        },
        error: function (data) {
            alert('BB')

        }

    });
}
})

$('#sendpost').click(function () {
    alert("管理员与学校管理员不可以发布帖子，只能回复帖子哦！！")
})
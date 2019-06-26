$('.btn-sendcontent').click(function () {
    var replaynews = $('.replay-text').text()
    var postid = $('.hidden-id').val()

    if(replaynews.length==0){
        alert("回复内容不能为空")
    }else {
        $.ajax({
            //请求方式
            type: 'get',
            contentType: "json",
            //发送请求的地址
            url: '/post/sendreplay',
            //服务器返回的数据类型
            dataType: 'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data: {
                replaynews: replaynews,
                postid: postid,
            },
            success: function (data) {
                if (data) {
                    window.location.href = "/post/cotent/" + postid;

                } else {
                    alert('111')
                }
            },
            error: function (data) {
                alert("没有登录不能回复帖子！")
                window.location.href = '/nologin';
            }

        });
    }
})
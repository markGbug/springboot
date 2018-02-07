layui.define(['element', 'layer', 'form'], function (exports) {
    var form = layui.form;
    var $ = layui.jquery;

    //检测键盘按下
    $('body').keydown(function (e) {
        if (e.keyCode == 13) {  //Enter键
            if ($('#layer-login').length <= 0) {
                login();
            } else {
                $('button[lay-filter=login]').click();
            }
        }
    });

    $('.enter').on('click', login);
    //自定义验证
    form.verify({
        password: [/^[\S]{6,12}$/, '密码必须6到12位'],
        loginId: function (value) {
            if (value.length <= 0 || value.length > 10) {
                return "账号必须1到10位"
            }
            var reg = /^[a-zA-Z0-9]*$/;
            if (!reg.test(value)) {
                return "账号只能为英文或数字";
            }
        },
        result_response: function (value) {
            if (value.length < 1) {
                return '请点击人机识别验证';
            }
        },
    });
    //监听登陆提交
    form.on('submit(login)', function (data) {
        var index = layer.load(1);
        //模拟登陆
        console.log(data);
        layer.close(index);
        $.ajax({
            type: 'post',
            url: '/backer/login',
            dataType: 'json',
            data: {
                loginId : data.field.loginId,
                password : data.field.password
            },
            success: function (res) {
                if (res.ifSuccess) {
                    layer.msg('登陆成功，正在跳转......', {icon: 6});
                    layer.closeAll('page');
                    setTimeout(function () {
                        location.href = "/backer/main";
                    }, 1000);
                } else {
                    console.log(res);
                    layer.msg(res.message, {icon: 5});
                }
            },
            error: function () {
                layer.close(index);
                layer.msg("系统异常", {icon: 2});
            }
        });
        return false;
    });

    function login() {
        var loginHtml = '';
        loginHtml += '<form class="layui-form">';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">账号</label>';
        loginHtml += '<div class="layui-input-inline pm-login-input">';
        loginHtml += '<input type="text" name="loginId" lay-verify="loginId" placeholder="请输入账号" value="lyblogscn" autocomplete="off" class="layui-input">';
        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">密码</label>';
        loginHtml += '<div class="layui-input-inline pm-login-input">';
        loginHtml += '<input type="password" name="password" lay-verify="password" placeholder="请输入密码" value="111111" autocomplete="off" class="layui-input">';
        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">人机验证</label>';
        loginHtml += '<div class="layui-input-block">';
        loginHtml += '<div class="l-captcha" data-site-key="028566f4479860b2fddc699c3e374f84" data-callback="getResponse">';
        loginHtml += '</div>';
        loginHtml += '<input type="hidden" id="result_response" lay-verify="result_response">';

        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item" style="margin-top:25px;margin-bottom:0;">';
        loginHtml += '<div class="layui-input-block">';
        loginHtml += ' <button class="layui-btn" style="width:230px;" lay-submit="" lay-filter="login">立即登录</button>';
        loginHtml += ' </div>';
        loginHtml += ' </div>';
        loginHtml += '</form>';
        loginHtml += '<script src="//captcha.luosimao.com/static/dist/api.js"></script>';
        loginHtml += '<script type="text/javascript">' +
            '    function getResponse(data) {\n' +
            '        var $ = layui.jquery;\n' +
            '        $("#result_response").val(data);\n' +
            '    }</script>';

        layer.open({
            id: 'layer-login',
            type: 1,
            title: false,
            shade: 0.4,
            shadeClose: true,
            area: ['480px', '270px'],
            closeBtn: 0,
            anim: 1,
            skin: 'pm-layer-login',
            content: loginHtml
        });
        layui.form.render('checkbox');
    }
});


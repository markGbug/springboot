layui.define(['jquery', 'layer'], function (exports) {
    var $ = layui.jquery;
    var layer = layui.layer;
    var baseAjax = {
        //封装Ajax Get请求
        getAjax: function (url, func, param) {
            $.ajax({
                url: url,
                data: param,
                type: "get",
                success: function (res) {
                    if (res.code != 0 || !res.ifSuccess) {
                        layer.msg(res.message);
                    }
                    else {
                        return typeof func === 'function' && func(res);
                    }
                }
            })
        },
        //封装Ajax Post请求
        postAjax: function (url, func, param) {
            $.ajax({
                url: url,
                data: param,
                type: "post",
                dataType: "json",
                success: function (res) {
                    if (res.code != 0 || !res.ifSuccess) {
                        layer.msg(res.message);
                    }
                    else {
                        return typeof func === 'function' && func(res);
                    }
                }
            })
        },

        //构建下拉框
        createHtml: function (data, id, entity) {
            var html = '';
            if (data != null) {
                for (var i = 0; i < data.length; i++) {
                    html += '<option data-id="' + data[i].id + '" value=' + data[i][entity];
                    if (id == data[i].id) {
                        html += ' selected';
                    }
                    html += '>' + data[i][entity] + '</option>'
                }
            }
            return html;
        },
        //删除请求
        delAlertInformation: function (message, url) {
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                this.getAjax(url, null, null);
                this.location = location;
            }, function () {

            });
        }
    };
    exports('baseAjax', baseAjax);
});
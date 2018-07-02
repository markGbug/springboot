layui.define(['laypage', 'layer', 'form', 'pages', 'baseAjax'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        laypage = layui.laypage;
    var laypageId = 'pageNav';

    $(function () {
        var pageNo = $('#pageNo').val();
        var pageSize = $('#pageSize').val();
        var total = $('#total').val();
        laypage.render({
            elem: laypageId,
            count: total,
            limit: pageSize,
            layout: ['prev', 'page', 'next', 'skip'],
            group: 3,
            curr: 1,
            jump: function (obj, first) {
                var currentIndex = obj.curr;
            }
        });
        layui.pages(laypageId, pageNo);

        //valid
        form.verify({});


        //add
        $('#add').on('click', function () {
            var htm = '';
            htm += '<form class="layui-form" action="">' +
                '    <div class="layui-form-item">' +
                '        <label class="layui-form-label">父级菜单</label>' +
                '        <div class="layui-form-select">' +
                '           <select name="parentId">' +
                '                <option value="">我不是父菜单</option>' +
                '           </select>' +
                '        </div>' +
                '    </div>' +
                '    <div class="layui-form-item">' +
                '        <label class="layui-form-label">权限设置</label>' +
                '        <div class="layui-input-block">' +
                '           <select name="parentId">' +
                '                <option value="">操作员</option>' +
                '                <option value="2">管理员</option>' +
                '                <option value="3">超级管理员</option>' +
                '           </select>' +
                '        </div>' +
                '    </div>' +
                '    <div class="layui-form-item">' +
                '        <label class="layui-form-label">菜单名称</label>' +
                '        <div class="layui-input-inline pm-login-input">' +
                '            <input type="password" name="password" lay-verify="passWord" placeholder="请输入名称" class="layui-input">' +
                '        </div>' +
                '    </div>' +
                '    <div class="layui-form-item">' +
                '        <label class="layui-form-label">跳转链接</label>' +
                '        <div class="layui-input-inline pm-login-input">' +
                '            <input type="password" name="password" lay-verify="passWord" placeholder="请输入链接" class="layui-input">' +
                '        </div>' +
                '    </div>' +
                '</form>';
            layer.open({
                type: 1,
                title: '新增菜单',
                content: htm,
                anim: 1,
                btn: ['来一个', '不了'],
                btnAlign: 'c',
                closeBtn: 2,

            })
        })
    });
//form.render('checkbox');  //重新渲染CheckBox，编辑和添加的时候
    exports("menu", {});
});
//@ sourceURL=article-index.js

layui.use(['laypage', 'layer', 'form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form();

    initilArticle(1, 8);

    //监听置顶CheckBox
    form.on('checkbox(top)', function (data) {
        $.ajax({
            type: 'post',
            url: '/api/admin/MakeTopOrNot',
            data: { "": data.value },
            success: function (res) {
                if (!res.Success) {
                    if (data.elem.checked) {
                        data.elem.checked = false;
                    }
                    else {
                        data.elem.checked = true;
                    }
                }
                form.render();  //重新渲染
                layer.msg(res.Message);
            },
            error: function (e) {
                layer.msg(e.responseText);
            }
        });
    });

    //监听推荐CheckBox
    form.on('checkbox(recommend)', function (data) {
        $.ajax({
            type: 'post',
            url: '/api/admin/MakeRecommendOrNot',
            data: { "": data.value },
            success: function (res) {
                if (!res.Success) {
                    if (data.elem.checked) {
                        data.elem.checked = false;
                    }
                    else {
                        data.elem.checked = true;
                    }
                }
                form.render();  //重新渲染
                layer.msg(res.Message);
            },
            error: function (e) {
                layer.msg(e.responseText);
            }
        });
    });

    //搜索
    form.on('submit(formSearch)', function (data) {
        layer.msg('文章太少，此功能赞不提供');
        return false;
    });

    //添加文章
    $('#addArticle').click(function () {
        var index = layer.load(1);
        $.ajax({
            type: 'post',
            url: '/admin/article/add',
            success: function (data) {
                layer.close(index);
                $('#articleContent').html(data);
                $('#articleBoxTitle').text("添加文章");
                $('#articleConsole').attr('style', 'display:none');
                $('#articleBack').bind('click', function () {
                    initilArticle(1, 4);
                });
                layui.form().render();
            },
            error: function (e) {
                layer.close(index);
                layer.msg(e.responseText);
            }
        });
    });

    form.render();
});

//页数据初始化
//currentIndex：当前也下标
//pageSize：页容量（每页显示的条数）
function initilArticle(currentIndex, pageSize) {
    var index = layer.load(1);
    var $ = layui.jquery;
    var form = layui.form();
    var laypage = layui.laypage;
    var laypageId = 'articlePageNav';

    $.ajax({
        type: 'post',
        url: '/api/admin/GetArticlesByPage',
        contentType: 'application/json',
        data: JSON.stringify({ "currentIndex": currentIndex, "pageSize": pageSize }),
        datatype: 'json',
        success: function (res) {
            layer.close(index);
            if (res.Success) {
                var data = res.Data;
                var html = '';
                html += '<table style="" class="layui-table" lay-even>';
                html += '<colgroup><col width="180"><col><col width="150"><col width="180"><col width="90"><col width="90"><col width="50"><col width="50"></colgroup>';
                html += '<thead><tr><th>发表时间</th><th>标题</th><th>作者</th><th>类别</th><th colspan="2">选项</th><th colspan="2">操作</th></tr></thead>';
                html += '<tbody>';
                //遍历文章集合
                for (var i = 0; i < data.length; i++) {
                    var item = data[i];
                    html += "<tr>";
                    html += "<td>" + new Date(item.ReleaseTime.replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')).Format("yyyy-MM-dd hh:mm:ss") + "</td>";
                    html += "<td>" + item.ArticleTitle + "</td>";
                    html += "<td>" + item.ArticleAuthor + "</td>";
                    html += "<td>" + item.Category.CategoryName + "</td>";
                    html += '<td><form class="layui-form" action=""><div class="layui-form-item" style="margin:0;"><input type="checkbox" name="top" title="置顶" value="' + item.ArticleId + '" lay-filter="top" ' + (item.OrderBy > 0 ? 'checked' : '') + ' /></div></form></td>';
                    html += '<td><form class="layui-form" action=""><div class="layui-form-item" style="margin:0;"><input type="checkbox" name="top" title="推荐" value="' + item.ArticleId + '" lay-filter="recommend" ' + (item.IsRecommend ? 'checked' : '') + ' /></div></form></td>';
                    html += '<td><button class="layui-btn layui-btn-small layui-btn-normal" onclick="editArticle(\'' + item.ArticleId + '\')"><i class="layui-icon">&#xe642;</i></button></td>';
                    html += '<td><button class="layui-btn layui-btn-small layui-btn-danger" onclick="deleteArticle(\'' + item.ArticleId + '\')"><i class="layui-icon">&#xe640;</i></button></td>';
                    html += "</tr>";
                }
                html += '</tbody>';
                html += '</table>';
                html += '<div id="' + laypageId + '"></div>';

                $('#articleContent').html(html);

                form.render('checkbox');  //重新渲染CheckBox，编辑和添加的时候
                $('#articleConsole,#articleList').attr('style', 'display:block'); //显示FiledBox
                $('#articleBoxTitle').text("文章列表");    //FileBox标题改为文章列表

                pages = res.SubCode;

                laypage({
                    cont: laypageId,
                    pages: pages,
                    groups: 8,
                    skip: true,
                    curr: currentIndex,
                    jump: function (obj, first) {
                        var currentIndex = obj.curr;
                        if (!first) {
                            initilArticle(currentIndex, pageSize);
                        }
                    }
                });
                //该模块是我定义的拓展laypage，增加设置页容量功能
                //laypageId:laypage对象的id同laypage({})里面的cont属性
                //pagesize当前页容量，用于显示当前页容量
                //callback用于设置pagesize确定按钮点击时的回掉函数，返回新的页容量
                layui.pagesize(laypageId, pageSize).callback(function (newPageSize) {
                    //这里不能传当前页，因为改变页容量后，当前页很可能没有数据
                    initilArticle(1, newPageSize);
                });
            } else {
                layer.msg(res.Message);
            }
        },
        error: function (e) {
            layer.close(index);
            layer.msg(e.responseText);
        }
    });
}

//编辑文章
function editArticle(articleId) {
    var $ = layui.jquery;
    var index = layer.load(1);
    $.ajax({
        type: 'post',
        url: '/admin/article/Modify',
        data: 'articleId=' + articleId,
        success: function (data) {
            layer.close(index);
            $('#articleBoxTitle').text("修改文章");
            $('#articleContent').html(data);
            $('#articleConsole').attr('style', 'display:none');
            $('#articleBack').bind('click', function () {
                initilArticle(1, 8);
            });
            layui.form().render();
        },
        error: function (e) {
            layer.close(index);
            layer.msg(e.responseText);
        }
    });
}

//删除文章（作废）
function deleteArticle(articleId) {
    layer.confirm('确定删除？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        var $ = layui.jquery;
        var index = layer.load(1);
        $.ajax({
            type: 'post',
            url: '/api/admin/AbolishArticle',
            data: { "": articleId },
            success: function (res) {
                layer.close(index);
                layer.msg(res.Message);
                if (res.Success) {
                    setTimeout(function () {
                        initilArticle(1, 8);
                    }, 500);
                }
            },
            error: function (e) {
                layer.close(index);
                layer.msg(e.responseText);
            }
        });
    }, function () {

    });
}

<!doctype html>

<html>
<head>
    <meta charset="utf-8"/>
    <title>菜单管理</title>
    <!-- layui.css -->
    <link href="/static/plugins/layui/css/layui.css" rel="stylesheet"/>
    <style>
        .layui-btn-small {
            padding: 0 15px;
        }

        .layui-form-checkbox {
            margin: 0;
        }

        tr td:not(:nth-child(0)),
        tr th:not(:nth-child(0)) {
            text-align: center;
        }

        #dataConsole {
            text-align: center;
        }

        /*分页页容量样式*/
        /*可选*/
        .layui-laypage {
            display: block;
        }

        /*可选*/
        .layui-laypage > * {
            float: left;
        }

        /*可选*/
        .layui-laypage .laypage-extend-pagesize {
            float: right;
        }

        /*可选*/
        .layui-laypage:after {
            content: ".";
            display: block;
            height: 0;
            clear: both;
            visibility: hidden;
        }

        /*必须*/
        .layui-laypage .laypage-extend-pagesize {
            height: 30px;
            line-height: 30px;
            margin: 0px;
            border: none;
            font-weight: 400;
        }

        /*分页页容量样式END*/
    </style>
</head>
<body>
<fieldset id="dataConsole" class="layui-elem-field layui-field-title">
    <legend>搜索台</legend>
    <div class="layui-field-box">
        <div id="articleIndexTop">
            <form class="layui-form layui-form-pane" action="/backer/menu/list">
                <div class="layui-form-item" style="margin:0;margin-top:15px;">
                    <div class="layui-inline">
                        <label class="layui-form-label">关键词</label>
                        <div class="layui-input-inline">
                            <input type="text" value="${param.menuName!''}" name="menuName" autocomplete="off"
                                   class="layui-input">
                        </div>
                        <div class="layui-input-inline" style="width:auto">
                            <button class="layui-btn" lay-submit lay-filter="formSearch">搜索</button>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline" style="width:auto">
                            <a id="add" class="layui-btn layui-btn-normal">新建菜单</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</fieldset>
<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">菜单列表</legend>
    <div class="layui-field-box">
        <div id="dataContent" class="">
            <!--内容区域 ajax获取-->
            <table class="layui-table" lay-even="">
                <colgroup>
                    <col>
                    <col>
                    <col>
                    <col>
                    <col>
                    <col>
                    <col>
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>菜单</th>
                    <th>连接</th>
                    <th>操作员</th>
                    <th>类别</th>
                    <th>选项</th>
                    <th colspan="3">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list data as item>
                <tr>
                    <td>${item_index+1}</td>
                    <td>${item.menuName!''}</td>
                    <td>${item.menuUrl!''}</td>
                    <td>${item.operator!''}</td>
                    <td><#if item.level == 1>一级节点<#else >二级节点</#if></td>
                    <td>
                        <form class="layui-form" action="">
                            <div class="layui-form-item" style="margin:0;">
                                <input type="checkbox" name="top" title="置顶" lay-filter="top" checked>
                            </div>
                        </form>
                    </td>
                    <td>
                        <button id="edit" data-id="${item.id}" data-url="${item.menuUrl}"
                                class="layui-btn layui-btn-small layui-btn-normal"><i class="layui-icon">&#xe642;</i>
                        </button>
                    </td>
                    <td>
                        <button class="layui-btn layui-btn-small layui-btn-warm"><i class="layui-icon">&#xe60a;</i>
                        </button>
                    </td>
                    <td>
                        <button class="layui-btn layui-btn-small layui-btn-danger"><i class="layui-icon">&#xe640;</i>
                        </button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <div id="pageNav">
                <input type="hidden" id="total" value="${total}">
                <input type="hidden" id="pageNo" value="${pageNo}">
                <input type="hidden" id="pageSize" value="${pageSize}">
            </div>
        </div>
    </div>
</fieldset>

<!-- layui.js -->
<script src="/static/plugins/layui/layui.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '/static/js/'
    }).extend({
        page: 'page',
        baseAjax: 'baseAjax',
    }).use('menu');
</script>
</body>
</html>
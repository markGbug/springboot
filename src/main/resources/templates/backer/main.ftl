<!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <title>SBWW MANAGER</title>
    <link rel="shortcut icon" href="/static/img/Logo_40.png" type="image/x-icon">
    <!-- layui.css -->
    <link href="/static/plugins/layui/css/layui.css" rel="stylesheet" />
    <!-- font-awesome.css -->
    <link href="/static/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!-- animate.css -->
    <link href="/static/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式 -->
    <link href="/static/css/main.css" rel="stylesheet" />
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <!--顶部-->
    <div class="layui-header">
        <div class="ht-console">
            <div class="ht-user">
                <img src="../images/Logo_40.png" />
                <a class="ht-user-name">markgbug</a>
            </div>
        </div>
        <span class="sys-title">SBWW MANAGER</span>
        <ul class="ht-nav">
            <li class="ht-nav-item">
                <a target="_blank" href="javascript:;">前台入口</a>
            </li>
            <li class="ht-nav-item">
                <a href="javascript:;" id="individuation"><i class="fa fa-tasks fa-fw" style="padding-right:5px;"></i>个性化</a>
            </li>
            <li class="ht-nav-item">
                <a href="/backer/loglout"><i class="fa fa-power-off fa-fw"></i>注销</a>
            </li>
        </ul>
    </div>
    <!--侧边导航-->
    <div class="layui-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="leftnav">
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;"><i class="fa fa-home"></i>首页</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-info-circle"></i>其他</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="/backer/menu" data-id="10086110">菜单管理</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!--收起导航-->
    <div class="layui-side-hide layui-bg-cyan">
        <i class="fa fa-long-arrow-left fa-fw"></i>收起导航
    </div>
    <!--主体内容-->
    <div class="layui-body">
        <div style="margin:0;position:absolute;top:4px;bottom:0px;width:100%;" class="layui-tab layui-tab-brief" lay-filter="tab" lay-allowclose="true">
            <ul class="layui-tab-title">
                <li lay-id="0" class="layui-this">首页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <p style="padding: 10px 15px; margin-bottom: 20px; margin-top: 10px; border:1px solid #ddd;display:inline-block;">
                        上次登陆
                        <span style="padding-left:1em;">IP：192.168.1.101</span>
                        <span style="padding-left:1em;">地点：四川成都</span>
                        <span style="padding-left:1em;">时间：2017-3-26 14：12</span>
                    </p>
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend>统计信息</legend>
                        <div class="layui-field-box">
                            <div style="display: inline-block; width: 100%;">
                                <div class="ht-box layui-bg-orange">
                                    <p>123</p>
                                    <p>文章总数</p>
                                </div>
                                <div class="ht-box layui-bg-cyan">
                                    <p>321</p>
                                    <p>资源总数</p>
                                </div>
                                <div class="ht-box layui-bg-black">
                                    <p>231</p>
                                    <p>笔记总数</p>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
    <!--底部信息-->
    <div class="layui-footer">
        <p style="line-height:44px;text-align:center;">SBWW MANAGER - Design By markGbug</p>
    </div>
    <!--快捷菜单-->
    <div class="short-menu" style="display:none">
        <fieldset class="layui-elem-field layui-field-title">
            <legend style="color:#fff;padding-top:10px;padding-bottom:10px;">快捷菜单</legend>
            <div class="layui-field-box">
                <div style="width:832px;margin:0 auto;">
                    <div class="windows-tile windows-two">
                        <i class="fa fa-hourglass-half"></i>
                        <span data-url="datalist.html" data-id="9">菜单管理</span>
                    </div>
                    <div style="clear:both;"></div>
                </div>
            </div>
        </fieldset>

    </div>
    <!--个性化设置-->
    <div class="individuation animated flipOutY layui-hide">
        <ul>
            <li><i class="fa fa-cog" style="padding-right:5px"></i>个性化</li>
        </ul>
        <div class="explain">
            <small>从这里进行系统设置和主题预览</small>
        </div>
        <div class="setting-title">设置</div>
        <div class="setting-item layui-form">
            <span>侧边导航</span>
            <input type="checkbox" lay-skin="switch" lay-filter="sidenav" lay-text="ON|OFF" checked>
        </div>
        <div class="setting-item layui-form">
            <span>管家提醒</span>
            <input type="checkbox" lay-skin="switch" lay-filter="steward" lay-text="ON|OFF" checked>
        </div>
        <div class="setting-title">主题</div>
        <div class="setting-item skin skin-default" data-skin="skin-default">
            <span>低调优雅</span>
        </div>
        <div class="setting-item skin skin-deepblue" data-skin="skin-deepblue">
            <span>蓝色梦幻</span>
        </div>
        <div class="setting-item skin skin-pink" data-skin="skin-pink">
            <span>姹紫嫣红</span>
        </div>
        <div class="setting-item skin skin-green" data-skin="skin-green">
            <span>一碧千里</span>
        </div>
    </div>
</div>
<!-- layui.js -->
<script src="/static/plugins/jquery/jquery-3.2.1.min.js"></script>
<script src="/static/plugins/layui/layui.js"></script>
<script type="text/javascript" src="/static/js/main.js"></script>
</body>
</html>
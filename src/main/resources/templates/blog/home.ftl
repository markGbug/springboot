<#include "/widgets/blog/head.ftl">
<!-- 本页样式表 -->
<link href="/static/css/home.css" rel="stylesheet"/>
<script src="/static/js/home.js"></script>
<#include "/widgets/blog/menu.ftl">
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <!-- canvas -->
        <canvas id="canvas-banner" style="background: #009688;"></canvas>
        <!--为了及时效果需要立即设置canvas宽高，否则就在home.js中设置-->
        <script type="text/javascript">
            var canvas = document.getElementById('canvas-banner');
            canvas.width = window.document.body.clientWidth - 10;//减去滚动条的宽度
            if (screen.width >= 992) {
                canvas.height = window.innerHeight * 2 / 3;
            } else {
                canvas.height = window.innerHeight * 4 / 7;
            }
        </script>
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
            <div class="blog-main">
                <!-- 网站公告提示 -->
                <div class="home-tips shadow">
                    <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
                    <div class="home-tips-container">

                        <span style="color: #009688">偷偷告诉大家，本博客的后台管理也正在制作，为大家准备了游客专用账号！</span>
                        <span style="color: red">网站新增留言回复啦！使用QQ登陆即可回复，人人都可以回复！</span>
                        <span style="color: red">各位女装大佬，Github求颗星!&nbsp;&nbsp;<a
                                href="https://github.com/markGbug/springboot" target="_blank"
                                style="color:#01AAED">点我前往</a></span>
                        <span style="color: #009688">SBWW &nbsp;—— &nbsp;一个JAVA程序狗的个人博客，采用Layui为前端框架，持续添砖加瓦ing </span>
                    </div>
                </div>
                <!--左边文章列表-->
                <div class="blog-main-left">
                    <div class="article shadow">
                        <div class="article-left">
                            <img src="../images/cover/201703181909057125.jpg" alt="Logback配置详解"/>
                        </div>
                        <div class="article-right">
                            <div class="article-title">
                                <a href="detail.ftl">Logback配置详解</a>
                            </div>
                            <div class="article-abstract">
                                简单地说，Logback 是一个 Java 领域的日志框架。它被认为是 Log4J 的继承人。
                                Logback 主要由三个模块组成：
                                logback-core
                                logback-classic
                                logback-access
                                logback-core 是其它模块的基础设施，其它模块基于它构建，显然，logback-core 提供了一些关键的通用机制。logback-classic 的地位和作用等同于
                                Log4J，它也被认为是 Log4J 的一个改进版，并且它实现了简单日志门面 SLF4J；而 logback-access 主要作为一个与 Servlet
                                容器交互的模块，比如说 tomcat 或者 jetty，提供一些与 HTTP 访问相关的功能。
                            </div>
                        </div>
                        <div class="clear"></div>
                        <div class="article-footer">
                            <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;2018-01-23</span>
                            <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;MarkGbug</span>
                            <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">LogBack</a></span>
                            <span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;0</span>
                            <span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>
                        </div>
                    </div>
                </div>
                <!--右边小栏目-->
                <div class="blog-main-right">
                    <div class="blogerinfo shadow">
                        <div class="blogerinfo-figure">
                        <#--<img src="../images/Absolutely.jpg" alt="Absolutely" />-->
                        </div>
                        <p class="blogerinfo-nickname">MarkGbug</p>
                        <p class="blogerinfo-introduce">一枚90后程序员，JAVA后端狗</p>
                        <p class="blogerinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;浙江 - 杭州</p>
                        <hr/>
                        <div class="blogerinfo-contact">
                            <a target="_blank" title="QQ"
                               href="http://sighttp.qq.com/authd?IDKEY=45fae9d37f0ed043650a7827db13a77f35f37689be297eab"><i
                                    class="fa fa-qq fa-2x"></i></a>
                            <a target="_blank" title="Mail"
                               href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=seeblack@foxmail.com"><i
                                    class="fa fa-envelope fa-2x"></i></a>
                            <a target="_blank" title="Sina" href="https://weibo.com/u/3038865485"><i
                                    class="fa fa-weibo fa-2x"></i></a>
                            <a target="_blank" title="GitHub" href="https://github.com/markGbug"><i
                                    class="fa fa-git fa-2x"></i></a>
                        </div>
                    </div>
                    <div></div><!--占位-->
                    <div class="blog-module shadow">
                        <div class="blog-module-title">收藏文章</div>
                        <ul class="fa-ul blog-module-ul">
                        </ul>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">推荐文章</div>
                        <ul class="blogroll">
                            <li><a target="_blank" href="http://www.github.com/" title="github">github</a></li>
                            <li><a target="_blank" href="http://www.spring.io/" title="lanyu">Spring</a></li>
                            <li><a target="_blank" href="https://www.zybuluo.com/mdeditor" title="MarkDown">MarkDown</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <!-- 底部 -->
    <footer class="blog-footer">
        <p><span>Copyright</span><span>&copy;</span><span>2017</span><a href="http://www.lyblogs.cn">SBWW</a>
            <spa> MarkGbug</spa>
            </span></p>
    </footer>
    <!--侧边导航-->
    <ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
        <li class="layui-nav-item layui-this">
            <a href="/blog"><i class="fa fa-home fa-fw"></i>&nbsp;网站首页</a>
        </li>
        <li class="layui-nav-item">
            <a href="/blog/article"><i class="fa fa-file-text fa-fw"></i>&nbsp;文章专栏</a>
        </li>
        <li class="layui-nav-item">
            <a href="/blog/resource"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
        </li>
        <li class="layui-nav-item">
            <a href="/blog/timeline"><i class="fa fa-road fa-fw"></i>&nbsp;点点滴滴</a>
        </li>
        <li class="layui-nav-item">
            <a href="/blog/about"><i class="fa fa-info fa-fw"></i>&nbsp;关于本站</a>
        </li>
    </ul>
<#include "/widgets/blog/foot.ftl">
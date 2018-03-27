
layui.define('jquery', function (exports) {
    var $ = layui.jquery;
    function pages(id, pageNo) {
        $('#' + id + ' .layui-laypage').append('<span class="laypage-extend-pagesize">&#x6bcf;&#x9875; <input id="valid" type="number" min="1" max="'+pageNo+'" onblur="this.value = '+pageNo+'<=this.value?'+pageNo+':this.value;" onkeyup="this.value = this.value.replace(/\D/, \'\');" value="1" class="layui-laypage-skip" > &#x6761; <button type="button" class="layui-laypage-btn">&#x786e;&#x5b9a;</button></span>');
        $('#' + id + ' .laypage-extend-pagesize input[class=layui-laypage-skip]').val(pageNo);
        var pages = {
            btn: $('#' + id + ' .laypage-extend-pagesize .layui-laypage-btn'),
            callback: function (callback) {
                this.ok = callback;
            },
            ok: null
        };
        $(pages.btn).on('click', function () {
            pages.ok(pages.btn.siblings('input[class=layui-laypage-skip]').val());
        });
        return pages;
    }
    exports('pages', pages);
});
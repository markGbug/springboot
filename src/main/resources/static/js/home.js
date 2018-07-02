layui.use('jquery', function () {
    var $ = layui.jquery;
    $(function () {
        //播放公告
        playAnnouncement(3000);
    });

    function playAnnouncement(interval) {
        var index = 0;
        var $announcement = $('.home-tips-container>span');
        //自动轮换
        setInterval(function () {
            index++;    //下标更新
            if (index >= $announcement.length) {
                index = 0;
            }
            $announcement.eq(index).stop(true, true).fadeIn().siblings('span').fadeOut();  //下标对应的图片显示，同辈元素隐藏
        }, interval);
    }

    //画canvas
    DrawCanvas();
});

function DrawCanvas() {
    var $ = layui.jquery;
    var canvas = document.getElementById('canvas-banner');
    canvas.width = window.document.body.clientWidth;    //需要重新设置canvas宽度，因为dom加载完毕后有可能没有滚动条
    var ctx = canvas.getContext('2d');

    ctx.strokeStyle = (new Color()).style;

    var dotCount = 20; //圆点数量
    var dotRadius = 70; //产生连线的范围
    var dotDistance = 70;   //产生连线的最小距离
    var screenWidth = screen.width;
    if (screenWidth >= 768 && screenWidth < 992) {
        dotCount = 170;
        dotRadius = 80;
        dotDistance = 60;
    } else if (screenWidth >= 992 && screenWidth < 1200) {
        dotCount = 180;
        dotRadius = 90;
        dotDistance = 70;
    } else if (screenWidth >= 1200 && screenWidth < 1700) {
        dotCount = 190;
        dotRadius = 100;
        dotDistance = 80;
    } else if (screenWidth >= 1700) {
        dotCount = 250;
        dotRadius = 100;
        dotDistance = 80;
    }
    //默认鼠标位置 canvas 中间
    var mousePosition = {
        x: 50 * canvas.width / 100,
        y: 50 * canvas.height / 100
    };
    //小圆点
    var dots = {
        count: dotCount,
        distance: dotDistance,
        d_radius: dotRadius,
        array: []
    };

    function Color() {
        this.style = 'rgb(255,240,245)';
    }

    function Dot() {
        this.x = Math.random() * canvas.width;
        this.y = Math.random() * canvas.height;

        this.vx = -.5 + Math.random();
        this.vy = -.5 + Math.random();

        this.radius = Math.random() * 2;

        this.color = new Color();
    }

    Dot.prototype = {
        draw: function () {
            ctx.beginPath();
            ctx.fillStyle = "#fff";
            ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2, false);
            ctx.fill();
        }
    };

    function createDots() {
        for (i = 0; i < dots.count; i++) {
            dots.array.push(new Dot());
        }
    }

    function moveDots() {
        for (i = 0; i < dots.count; i++) {

            var dot = dots.array[i];

            if (dot.y < 0 || dot.y > canvas.height) {
                dot.vx = dot.vx;
                dot.vy = -dot.vy;
            }
            else if (dot.x < 0 || dot.x > canvas.width) {
                dot.vx = -dot.vx;
                dot.vy = dot.vy;
            }
            dot.x += dot.vx;
            dot.y += dot.vy;
        }
    }

    function connectDots1() {
        var pointx = mousePosition.x;
        for (i = 0; i < dots.count; i++) {
            for (j = 0; j < dots.count; j++) {
                i_dot = dots.array[i];
                j_dot = dots.array[j];

                if ((i_dot.x - j_dot.x) < dots.distance && (i_dot.y - j_dot.y) < dots.distance && (i_dot.x - j_dot.x) > -dots.distance && (i_dot.y - j_dot.y) > -dots.distance) {
                    if ((i_dot.x - pointx) < dots.d_radius && (i_dot.y - mousePosition.y) < dots.d_radius && (i_dot.x - pointx) > -dots.d_radius && (i_dot.y - mousePosition.y) > -dots.d_radius) {
                        ctx.beginPath();
                        ctx.strokeStyle = new Color().style;
                        ctx.moveTo(i_dot.x, i_dot.y);
                        ctx.lineTo(j_dot.x, j_dot.y);
                        ctx.stroke();
                        ctx.closePath();
                    }
                }
            }
        }
    }

    function drawDots() {
        for (i = 0; i < dots.count; i++) {
            var dot = dots.array[i];
            dot.draw();
        }
    }

    function animateDots() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        moveDots();
        connectDots1()
        drawDots();

        requestAnimationFrame(animateDots);
    }

    //鼠标在canvas上移动
    $('canvas').on('mousemove', function (e) {
        mousePosition.x = e.pageX;
        mousePosition.y = e.pageY;
    });

    //鼠标移出canvas
    $('canvas').on('mouseleave', function (e) {
        mousePosition.x = canvas.width / 2;
        mousePosition.y = canvas.height / 2;
    });

    createDots();

    requestAnimationFrame(animateDots);
}

//监听窗口大小改变
window.addEventListener("resize", resizeCanvas, false);

//窗口大小改变时改变canvas宽度
function resizeCanvas() {
    var canvas = document.getElementById('canvas-banner');
    canvas.width = window.document.body.clientWidth;
    canvas.height = window.innerHeight * 2 / 3;
}
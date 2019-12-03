layui.use(['laytpl', 'layer','laydate'], function () {
    var laytpl = layui.laytpl,
        $ = layui.jquery,
        layer = layui.layer,
        laydate = layui.laydate;

    //页面数据初始化
    var data_init = {
        plugins_init: function () {
            App.initHelpers(['slick']);
            //日期时间范围
            laydate.render({
                elem: '#time1'
                , type: 'datetime'
                , range: true
            });
            laydate.render({
                elem: '#time2'
                , type: 'datetime'
                , range: true
            });
        },

        search_plane:function () {
            var data = $('#fight').val();
            $.ajax({
                type: 'get',
                dataType: 'text',
                data: JSON.parse(data),
                url: '/search',
                success: function (res) {
                    //渲染模板数据
                    var getTpl = search_plane.innerHTML
                        , view = document.getElementById('search_show');
                    laytpl(getTpl).render(JSON.parse(res).data, function (html) {
                        view.innerHTML = html;
                    });
                }
            });
        },
        get_news:function(){
            $.get('/news',function (res) {
                //渲染模板数据
                var getTpl = news_show.innerHTML
                    , view = document.getElementById('btabs-static-justified-settings');
                laytpl(getTpl).render(JSON.parse(res).data, function (html) {
                    view.innerHTML = html;
                });
            })
        },
        //获取ip地址
        get_ip :function () {
            //获取ip地址
            $.ajax({
                url: 'http://api.map.baidu.com/location/ip?ak=ia6HfFL660Bvh43exmH9LrI6',
                type: 'POST',
                dataType: 'jsonp',
                success: function (data) {
                    console.log(data.content.address_detail.ip);
                    $("input[data-role='user_ip']").val(data.content.address_detail.ip);
                }
            });
        }
    };

    //点击详情展示
    var des = {
        clock_show: function () {
            $('#search_show').on('click', '.block', function () {
                //捕获页
                layer.open({
                    type: 1,
                    shade: false,
                    title: false, //不显示标题
                    area: ['550px', '270px'], //宽高
                    content: $(this).find('.clock_des').html() //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                });
            })
        },
        message_send: function () {
            $('#search_show').on('click', '.code_send', function () {
                console.log("====");
                var type = $(this).parent('form').find("input[type='radio']").val();
                console.log(type);
            });
        },
        clock_add: function () {
            $('#search_show').on('click', '.clock_add', function () {
                var data = $(this).parent('form').serializeArray();
                console.log(data);
                return false;
                //jquery.validate验证验证码账号是否输入错误

            });
        }
    };

    //搜索交换
    var change = {
        china_change: function () {
            $('#china_change').on('click', function () {
                var china_start = $("#china_start").val();
                $("#china_start").val($('#china_end').val());
                $("#china_end").val(china_start);
            });
        },
        abroad_change: function () {
            $('#abroad_change').on('click', function () {
                var abroad_start = $("#abroad_start").val();
                $("#abroad_start").val($('#abroad_end').val());
                $("#abroad_end").val(abroad_start);
            });
        }
    };

    var init = function(){
      data_init.plugins_init();
      data_init.search_plane();
      data_init.get_ip();
      data_init.get_news();
      des.clock_show();
      des.message_send();
      des.clock_add();
      change.china_change();
      change.abroad_change();
    };

    $(function () {
       init();
    });
});
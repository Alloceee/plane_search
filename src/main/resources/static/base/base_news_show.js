layui.use('table', function () {
    var table = layui.table;

    var dataInit = {
        //表格数据
        table: function () {
            table.render({
                elem: '#test'
                , url: '/admin/news/all'
                , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
                , defaultToolbar: ['filter', 'exports', 'print']
                , title: '航班动态信息表'
                , cols: [
                    [
                        {type: 'checkbox', fixed: 'left'}
                        , {field: 'id', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true}
                        , {field: 'title', title: '标题', edit: 'text', event: 'setTitle'}
                        , {field: 'content', title: '内容', width: 300, event: 'setContent'}
                        , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
                    ]
                ]
                , page: true
            });
        },
        //头工具栏事件
        toolbar: function () {
            //头工具栏事件
            table.on('toolbar(test)', function (obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                switch (obj.event) {
                    case 'delAll':
                        $.ajax({
                            data: {
                                news: JSON.stringify(data)
                            },
                            dataType: 'json',
                            type: 'post',
                            url: '/admin/news/del',
                            success: function () {
                                layer.msg("删除成功");
                                checkStatus.del();
                            }
                        });
                        break;
                }
            });
        },
        //监听行工具事件
        row: function () {
            //监听行工具事件
            table.on('tool(test)', function (obj) {
                var data = obj.data;
                //console.log(obj)
                if (obj.event === 'del') {
                    layer.confirm('真的删除行么', function (index) {
                        $.ajax({
                            data: {
                                news: data
                            },
                            dataType: 'json',
                            type: 'post',
                            url: '/admin/news/del',
                            success: function () {
                                layer.msg("删除成功");
                                obj.del();
                            }
                        });
                        obj.del();
                        layer.close(index);
                    });
                } else if (obj.event === 'modify') {
                    layer.msg('请直接在表格中修改');
                } else if (obj.event === 'setTitle') {
                    layer.prompt({
                        formType: 2
                        , title: '修改 ID 为 [' + data.id + '] 的标题'
                        , value: data.title
                    }, function (value, index) {
                        layer.close(index);
                        //这里一般是发送修改的Ajax请求
                        $.ajax({
                            data: {
                                id: data.id,
                                title: value
                            },
                            url: "/admin/news/update",
                            dataType: 'json',
                            type: 'post',
                            success: function (res) {
                                if (res > 0) {
                                    layer.msg("修改失败", {icon: 2});
                                } else {
                                    layer.msg("修改成功", {icon: 1});
                                    //同步更新表格和缓存对应的值
                                    obj.update({
                                        title: value
                                    });
                                }
                            }
                        });
                    });
                } else if (obj.event === 'setContent') {
                    layer.prompt({
                        formType: 2
                        , title: '修改 ID 为 [' + data.id + '] 的内容'
                        , value: data.content
                    }, function (value, index) {
                        layer.close(index);
                        //这里一般是发送修改的Ajax请求
                        $.ajax({
                            data: {
                                id: data.id,
                                content: value
                            },
                            url: "/admin/news/update",
                            dataType: 'json',
                            type: 'post',
                            success: function (res) {
                                if (res > 0) {
                                    layer.msg("修改失败", {icon: 2});
                                } else {
                                    layer.msg("修改成功", {icon: 1});
                                    //同步更新表格和缓存对应的值
                                    obj.update({
                                        content: value
                                    });
                                }
                            }
                        });
                    });
                }
            });
        }
    };

    //搜索功能
    var search = function () {
        var $ = layui.$, active = {
            reload: function () {
                var demoReload = $('#demoReload');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        key: demoReload.val()
                    }
                }, 'data');
            }
        };
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    };


    var init = function () {
        dataInit.table();
        dataInit.row();
        dataInit.toolbar();
    };

    $(function () {
        init();
        search();
    })
});
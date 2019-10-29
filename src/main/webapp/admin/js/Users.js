//加载显示类型
$(function(){  //加载事件
    //使用datagrid绑异服务器数据展示
    $('#dg').datagrid({
        title:"用户信息",
        url:'getUserByPage',
        toolbar:"#tb",  //绑定工具栏
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        columns:[[
            {field:'opt',checkbox:"true",title:'编号',width:100},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'用户名',width:100},
            {field:'telephone',title:'电话',width:100},
            {field:'dd',title:'操作',width:100,
                formatter: function(value,row,index){
                    //同步
                    return "<a href=''>删除</a> | <a href=''>修改</a>";
                }
            },
        ]]
    });
});

//搜索
function search(){

    //$("#dg").datagrid("load",查询条件格式:{"名称":值,"名称":值..});
    var name=$("#sname").val();
    var telephone=$("#stelephone").val();
    $("#dg").datagrid("load",{"name":name,"telephone":telephone});
}
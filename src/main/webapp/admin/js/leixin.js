$(function () {
    //显示数据
    $('#dg').datagrid({
        title:"类型信息",
        url:'getTypeBypage',
        toolbar:"#tb",//绑定工具栏
        pagination:true,
        pageList:[5,10,15,20],
        columns:[[
            {field:'opt',checkbox:"true",title:'编号',width:100},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'类型名称',width:100},
            {field:'dd',title:'操作',width:100,
                formatter: function(value,row,index){
                    return "<a href=''>修改</a> | <a href='javascript:deleteType("+row.id+")'>删除</a>"
                }
            },
        ]]
    });
})

//点击添加按钮调用的函数
function add(){
    //alert("打开添加窗口");
    $("#AddTypelog").dialog("setTitle","添加类型");
    $("#AddTypelog").dialog("open"); //打开  close 关闭
}

//关闭添加窗口
function CloseTypelog(){
    $("#AddTypelog").dialog("close"); //打开  close 关闭
}

//保存区域
function SaveTypelog(){
    //2.使用easyui的表单提示插件
    $('#addForm').form('submit',{   //提交按钮
        url:"addType",
        success:function(data){ //获得是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            if(data.result==1){
                $("#dg").datagrid('reload'); //刷新
                $("#AddTypelog").dialog("close");//关闭窗口
            }else{
                alert("添加失败!!!");
            }
        }
    });
}




//点击修改按钮调用的函数
function goupdate(){
    //alert("打开添加窗口");
    /*判断用户是否选择行
    * 获取datagrid行*/
    var SelectRows =$("#dg").datagrid('getSelections');
    if(SelectRows.length==1){
        //获取当前选择行的编号-->查询当前记录-->还原表单
        //1.获取当前的编号
        //2.发送异步请求获取服务器数据
        $.post("selectTypeid",{"id":SelectRows[0].id},function (data) {
            //还原加载表单数据
            $("#upForm").form('load',data);
        },"json");

        //获取航对象的数据加载到表单中显示
        /* $("upForm").form('load',SelectRows[0]);*/

        $("#upTypelog").dialog("setTitle","修改类型");
        $("#upTypelog").dialog("open"); //打开  close 关闭
    }else {
        //消息框
        $.messager.alert('提示信息','请选择一条信息!','error');
    }
}

//关闭添加窗口
function upCloseTypelog(){
    $("#upTypelog").dialog("close"); //打开  close 关闭
}

//修改区域
function updateType(){
    //2.使用easyui的表单提示插件
    $('#upForm').form('submit',{   //提交按钮
        url:"updateType",
        success:function(data){ //获得是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            if(data.result==1){
                $("#dg").datagrid('reload'); //刷新
                $("#upTypelog").dialog("close");//关闭窗口
            }else{
                $.messager.alert('提示信息','修改失败!','error');
            }
        }
    });
}


/*删除区域*/
function deleteType(id){
    //确认提示框
    $.messager.confirm('删除类型', '真的想删除吗?', function(r){
        if (r){
            //删除
            $.post("deleteType",{"id":id},function(data){
                if(data.result==1){
                    $("#dg").datagrid('reload'); //刷新
                }else{
                    $.messager.alert('提示信息','删除失败!','error');
                }
            },"json");
        }
    });
}

/*批量删除区域*/
function Typepiliangshanchu() {
    /*获取选择的行*/
    var SelectRows =$("#dg").datagrid('getSelections');
    if(SelectRows.length==0){
        $.messager.alert('提示信息','你还没有选择删除项!','error');
    }else {
        //确认提示框
        $.messager.confirm('删除类型', '真的想删除吗?', function(r){
            if (r){
                //拼接字符串
                var ids="";
                for (var i=0;i<SelectRows.length;i++){
                    ids=ids+SelectRows[i].id+",";
                }
                ids=ids.substring(0,ids.length-1);
                //删除
                $.post("Typepiliangshanchu",{"ids":ids},function(data){
                    if(data.result>=1){
                        $("#dg").datagrid('reload'); //刷新
                    }else{
                        $.messager.alert('提示信息','删除失败!','error');
                    }
                },"json");
            }
        });
    }
}
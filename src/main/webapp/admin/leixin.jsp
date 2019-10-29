<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/17
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/leixin.js"></script>
</head>
<body>
<table id="dg"></table>
<%--工具栏--%>
<div id="tb">
    <a href="javascript:add()" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a> <a
        href="javascript:goupdate()" class="easyui-linkbutton"
        iconCls="icon-edit" plain="true">修改</a> <a
        href="javascript:Typepiliangshanchu()" class="easyui-linkbutton"
        iconCls="icon-remove" plain="true">批量删除</a>
</div>
<!--制作添加区域的对话框-->
<div id="AddTypelog" class="easyui-dialog" buttons="#AddTypeButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form action="" id="addForm" name="add" method="post">
        类型名称:<input type="text" name="name" id="name"><br/>

    </form>
</div>

<!--对话框的按钮-->
<div id="AddTypeButtons">
    <a href="javascript:SaveTypelog()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:CloseTypelog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>




<!--制作修改区域的对话框-->
<div id="upTypelog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form action=""id="upForm" method="post">
        类型名称:<input type="text" name="name" id="name2"><br/>
        类型编号:<input type="text" name="id" id="" readonly>
    </form>
</div>


<!--对话框的按钮-->
<div id="upDialogButtons">
    <a href="javascript:updateType()" class="easyui-linkbutton" iconCls="icon-ok">更新</a>
    <a href="javascript:upCloseTypelog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>

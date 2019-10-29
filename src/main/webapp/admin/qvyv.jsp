<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/14
  Time: 15:18
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
    <script language="JavaScript" src="js/qvyv.js"></script>

</head>
<body>
<table id="dg"></table>
<%--工具栏--%>
<div id="tb">
    <a href="javascript:add()" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a> <a
        href="javascript:goupdate()" class="easyui-linkbutton"
        iconCls="icon-edit" plain="true">修改</a> <a
        href="javascript:DeleteMoreDistrict()" class="easyui-linkbutton"
        iconCls="icon-remove" plain="true">批量删除</a>
</div>
<!--制作添加区域的对话框-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form action="" id="addForm" name="add" method="post">
        区域名称:<input type="text" name="name" id="name"><br/>

    </form>
</div>

<!--对话框的按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>




<!--制作修改区域的对话框-->
<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form action=""id="upForm" method="post">
        区域名称:<input type="text" name="name" id="name2"><br/>
        区域编号:<input type="text" name="id" id="" readonly>
    </form>
</div>


<!--对话框的按钮-->
<div id="upDialogButtons">
    <a href="javascript:updateDistrict()" class="easyui-linkbutton" iconCls="icon-ok">更新</a>
    <a href="javascript:upCloseDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>

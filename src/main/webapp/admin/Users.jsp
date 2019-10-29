<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/17
  Time: 19:02
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
    <script language="JavaScript" src="js/Users.js"></script>
</head>
<body>
<table id="dg"></table>
<%--工具栏--%>
<div id="tb">
    用户名: <input id="sname" type="text" name="name">
    电话: <input id="stelephone" type="text" name="telephone">

    <a href="javascript:search()" class="easyui-linkbutton"
       iconCls="icon-search" plain="true">搜索</a>
</div>
</body>
</html>

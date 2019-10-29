<%@ page pageEncoding="utf-8" language="java" contentType="text/html;utf-8" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
  <LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
  <link rel="stylesheet" type="text/css" href="../admin/easyUI/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="../admin/easyUI/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="../admin/easyUI/css/demo.css">
  <script src="../admin/js/jquery-1.8.3.js"></script>
  <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
  <script src="../admin/js/jquery.easyui.min.js"></script>
  <script language="JavaScript">

    $(function () {//jquery加载事件
        //1.异步加载所有房屋类型
        $.post("selType",null,function (data){
            for (var i=0;i<data.length;i++){
                /*创建Dom节点*/
                var option=$("<option value="+data[i].id+">"+data[i].name+"</option>")
                //添加节点
                $("#type_id").append(option);
            }
            //设置下拉框
            $("#type_id").val((${house.typeId}))

        },"json");

        //2.异步加载所有区域
        $.post("getAllDistrict",null,function (data){
            for (var i=0;i<data.length;i++){
                /*创建Dom节点*/
                var option=$("<option value="+data[i].id+">"+data[i].name+"</option>")
                //添加节点
                $("#district_id").append(option);
            }

            //设置区域选中项
            $("#district_id").val((${house.did}))

            luoxin()

        },"json");

        //3.加载街道
        $("#district_id").change(function () {//触发区域的改变事件
            var id=$(this).val();//获取district_id的值并赋值给id
            //发送异步请求获取街道
            //清空选项
            $("#street_id>option:gt(0)").remove();

            //加载数据
          luoxin()

        })

        function luoxin() {
            $.post("allIDStreet",{"id": $("#district_id").val()},function (data){
                for (var i=0;i<data.length;i++){
                    /*创建Dom节点*/
                    var option=$("<option value="+data[i].id+">"+data[i].name+"</option>")
                    //添加节点
                    $("#street_id").append(option);
                }

                //设置街道选中项
                $("#street_id").val((${house.streetId}))
            },"json");
        }
    })
  </script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post enctype="multipart/form-data" name=sss
action=updateHouse>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD>
      <input type="hidden" name="id" value="${house.id}">
      <INPUT id=add_action_title class=text type=text name=title value="${house.title}"></TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text id="type_id" name=typeId><OPTION selected>---请选择---</OPTION></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text name=floorage value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>

    <TD>
      <INPUT class=text type=date name=houseDate value="<f:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></f:formatDate>"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text id="district_id" name=districtid><OPTION selected>---请选择---</OPTION></SELECT>
        街：<SELECT class=text id="street_id" name=streetId><OPTION selected>---请选择---</OPTION></SELECT>
    </TD>
  </TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD></TR>

  <TR>
    <TD class=field>图片：</TD>
    <TD>
      <input type="hidden" name="oldpic" value="${house.path}">
      <img src="http://localhost:80/${house.path}" width="100" height="100">
      <input type="file" name=pfile ></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT value=立即发布 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>

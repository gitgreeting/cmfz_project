<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/treegrid-dnd.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-dnd.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.etree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/script/common.js"></script>
    <script type="text/javascript">
        $(function(){
            /*  $.post("/cmfz_project/Menu/findAllMenu",function(menu) {
                  $.each(menu,function (index,me) {
                      console.log("----------------"+me.title+"---"+me.iconCls);
                      var content = "";
                      $.each(me.menus,function (idx,child) {
                          console.log(child.title+"---"+child.iconCls);
                          content +="<a href='javascript:;' onclick=\"addTabs('"+child.iconCls+"','"+child.title+"','"+child.href+"')\" class='easyui-linkbutton' data-options=\"iconCls:'"+child.iconCls+"'\" style='width:100%'>&nbsp;"+child.title+"</a><br/>";
                      });
                      $("#aa").accordion("add",{
                          title:me.title,
                          iconCls:me.iconCls,
                          content:content
                      });
                  });
              });*/
          $.ajax({
              url:"/cmfz_project/Menu/findAllMenu",
              type:"POST",
              dataType:"json",
              success:function(menu){
                  $.each(menu,function (index,me) {
                      console.log("----------------"+me.title+"---"+me.iconCls);
                      var content = "";
                      $.each(me.menus,function (idx,child) {
                          console.log(child.title+"---"+child.iconCls);
                          content +="<a href='javascript:;' onclick=\"addTabs('"+child.iconCls+"','"+child.title+"','"+child.href+"')\" class='easyui-linkbutton' data-options=\"iconCls:'"+child.iconCls+"'\" style='width:100%'>&nbsp;"+child.title+"</a><br/>";
                      });
                      $("#aa").accordion("add",{
                          title:me.title,
                          iconCls:me.iconCls,
                          content:content
                      });
                  });
              },
              error:function () {
                  location.href="/cmfz_project/login.jsp";
              }
          })
        });
        function addTabs(iconCls,title,href){
            if(!$("#tt").tabs("exists",title)){
                $("#tt").tabs("add",{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    href:"${pageContext.request.contextPath}"+href,
                });
            }
            $("#tt").tabs("select",title);
        }
       function updatePwd(){

            $("#updatePwdPage").dialog({
                title:"修改密码",
                iconCls:"icon-edit",
                width:400,
                height:270,
                href:"${pageContext.request.contextPath}/back/Admin/updatePwd.jsp?admin_id="+$("#uId").text(),
                buttons:[{
                    iconCls:"icon-save",
                    text:"修改",
                    handler:function(){
                        var admin_id = $("#admin_id").val();
                        var name = $("#name").val();
                        $("#update").form("submit",{
                            url:"${pageContext.request.contextPath}/Admin/updatePwd",
                            success:function (data) {
                                var result  = $.parseJSON(data);
                                if(result.updateSuc==true) {
                                    $.messager.show({title: "提示：", msg: "密码修改成功...."});
                                }else{
                                    $.messager.show({title: "提示：", msg: "密码修改失败...."});
                                }
                                $("#updatePwdPage").dialog('close');
                            }
                      })
                    }
                },{
                    iconCls:"icon-cancel",
                    text:"取消",
                    handler:function(){
                        $("#updatePwdPage").dialog('close');
                    }
                }]
            });
        }
        function loginOut(){
            $.post("${pageContext.request.contextPath}/Admin/loginOut",function(){

            });
        }
    </script>
    <style type="text/css">
        #ab{ font-family:"微软雅黑";}
        #img{margin: 10px;float:left}
        #rightbox{float:left}
        #ab input{
            width:160px;
            height:20px;
            border-radius:4px ;
            border:none;
        }
        #bottombox {clear: left}
        #bottombox textarea{width:460px;height:180px;font-size:15px;font-family:"微软雅黑";border: none}
        #bottombox #pdate{font-size: 13px;}
        #bottombox #c1{font-size:18px;}
    </style>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div><span id="uId">${sessionScope.admin.admin_id}</span>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.name} &nbsp;<a href="" class="easyui-linkbutton" onclick="updatePwd()" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="" class="easyui-linkbutton" onclick="loginOut()" data-options="iconCls:'icon-01'">退出系统</a></div>
        <div id="updatePwdPage" style="padding: 5px;font-size: 16px"></div>
    </div>
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true" >
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:false,closable:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood'"  style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>

</body> 
</html>
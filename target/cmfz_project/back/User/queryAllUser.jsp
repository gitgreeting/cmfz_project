<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>
<script type="text/javascript">
    $(function(){
        $('#showUsersTable').datagrid({
            url: '${pageContext.request.contextPath}/User/findAllUsers',
            title:"用户信息",
            iconCls:"icon-ok",
            fit:true,
            pagination:true,
            pageSize:2,
            pageList:[2,8,15,24,35],
            columns:[[
                {field:'id',title:'id',width:180,align:'center',hidden:true},
                {field:'nickName',title:'法名',width:120,align:'left'},
                {field:'userName',title:'姓名',width:120,align:'left'},
                {field:'headPic',title:'头像',width:80,align:'left'},
                {field:'phoneNum',title:'电话',width:180,align:'left'},
                {field:'password',title:'密码',width:160,align:'left'},
                {field:'province',title:'省份',width:100,align:'left'},
                {field:'city',title:'城市',width:60,align:'left'},
                {field:'gender',title:'性别',width:60,align:'left'},
                {field:'date',title:'注册时间',width:120,align:'left'},
                {field:'options',title:'操作',width:120,
                    formatter:function(value,rows,index){
                       return "<a href='javascript:;'class='delUser'onclick=\"deleteUser('"+rows.id+"')\" class='easyui-linkbutton'>删除</a>&nbsp;&nbsp;<a href='javascript:;'class='updUser' onclick=\"updateUser('"+rows.id+"')\" class='easyui-linkbutton'>修改</a>";
                    }
                }
            ]],
            toolbar:[{
                text:"添加",
                iconCls:"icon-add",
                handler:addUserFun
            }],
            onLoadSuccess:function(){
                $(".delUser").linkbutton({iconCls:'icon-remove',plain:true});
                $(".updUser").linkbutton({iconCls:'icon-edit',plain:true});
            },
        });
    })
    function addUserFun(){
        $("#addUser").dialog({
            width:470,
            height:360,
            title:"添加用户信息",
            iconCls:"icon-add",
            href:"${pageContext.request.contextPath}/back/User/AddUser.jsp",
            buttons:[{
                text:"添加",
                iconCls:"icon-save",
                handler:function () {
                    $("#addUserForm").form('submit',{
                        url:"${pageContext.request.contextPath}/User/insertUserBack",
                        success:function (data) {
                            var result = $.parseJSON(data);
                            if(result.insertUserBack){
                                $.messager.show({title: "提示：", msg: "用户信息添加成功...."});
                            }else{
                                $.messager.show({title: "提示：", msg:"用户信息添加失败...."});
                            }
                            $("#addUser").dialog('close');
                            $("#showUsersTable").datagrid('reload');
                        }
                    });
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function(){
                    $("#addUser").dialog('close');
                }
            }]
        });
    }
    function updateUser(id){
        $("#updUser").dialog({
            width:470,
            height:300,
            title:"修改用户信息",
            iconCls:"icon-edit",
            href:"${pageContext.request.contextPath}/back/User/updateUser.jsp?uid="+id,
            buttons:[{
                text:"修改",
                iconCls:"icon-save",
                handler:function () {
                    $("#updateUserForm").form('submit',{
                        url:"${pageContext.request.contextPath}/User/updateUser",
                        success:function (data) {
                            var result = $.parseJSON(data);
                            if(result.updateUser){
                                $.messager.show({title: "提示：", msg: "用户信息修改成功...."});
                            }else{
                                $.messager.show({title: "提示：", msg: "用户信息修改失败...."});
                            }
                            $("#updUser").dialog('close');
                            $("#showUsersTable").datagrid('reload');
                        }
                    })
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function(){
                    $("#updUser").dialog('close');
                }
            }]
        })
    }
    function deleteUser(delid){
        $.messager.confirm('确认','您确认想要删除当前记录吗？',function(r){
            if (r){
                $.post("${pageContext.request.contextPath}/User/deleteUser","deleteId="+delid,function (data) {
                    if(data.deleteUser){
                        $.messager.show({title: "提示：", msg: "用户信息删除成功...."});
                    }else{
                        $.messager.show({title: "提示：", msg:"用户信息删除成功...."});
                    }
                    $("#showUsersTable").datagrid('reload');
                });
            }
        });
    }
</script>

<table id="showUsersTable">
</table>
<div id="addUser"></div>
<div id="updUser"></div>
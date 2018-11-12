<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function(){
        $("#GuruTable").datagrid({
            title:"上师信息展示",
            striped:true,
            height:380,
            url:"${pageContext.request.contextPath}/Guru/finAllGuru",
            columns:[[
                {field:'id',title:'id',width:300,align:'center',hidden:true},
                {field:'checkbox',title:'checkbox',width:80,checkbox:true},
                {field:'name',title:'姓名',width:200,align:'center'},
                {field:'headPic',title:'头像',width:180,align:'center'},
                {field:'gender',title:'性别',width:200,align:'center'},
                {field:'options',title:'options',width:200,align:'center',
                    formatter:function(value,rows,index){
                        return "<a href='javascript:;'class='delGuru'onclick=\"deleteGuru('"+rows.id+"')\" class='easyui-linkbutton'>删除</a>&nbsp;&nbsp;<a href='javascript:;'class='updGuru' onclick=\"updateGuru('"+rows.id+"')\" class='easyui-linkbutton'>修改</a>";
                    }
                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.headPic + '" style="height:100px;"></td>' +
                    '<td style="border:0">' +
                    '<p>姓名: ' + rowData.name + '</p>' +
                    '<p>头像: ' + rowData.headPic + '</p>' +
                    '<p>性别: ' + rowData.gender + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar:[{
                iconCls:"icon-add",
                text:"添加",
                handler:addGuru
            },{
                iconCls:"icon-remove",
                text:"批量删除",
                handler:removeGurus
            }],
            onLoadSuccess:function(){
                $(".delGuru").linkbutton({iconCls:'icon-remove',plain:true});
                $(".updGuru").linkbutton({iconCls:'icon-edit',plain:true});
            },
        })
    });
    function removeGurus(){
        var selects =  $("#GuruTable").datagrid("getSelections");
        if(selects.length<=0){
            $.messager.show({title: "提示：", msg: "未选中行!!!"});
        }else{
            var ids = [];
            for(var i=0;i<selects.length;i++){
                ids.push(selects[i].id);
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/Guru/removeGurus",
                Type:"POST",
                traditional:true,
                data:{ids:ids},
                success:function(){
                    $("#GuruTable").datagrid('reload');
                }
            });
        }
    }

    function addGuru(){
        $("#addGuru").dialog({
            width:470,
            height:300,
            title:"添加上师信息",
            iconCls:"icon-add",
            href:"${pageContext.request.contextPath}/back/Guru/AddGuru.jsp",
            buttons:[{
                text:"添加",
                iconCls:"icon-save",
                handler:function () {
                    $("#addGuruForm").form('submit',{
                        url:"${pageContext.request.contextPath}/Guru/insertGuru",
                        success:function (data) {
                            var result = $.parseJSON(data);
                            if(result.insertGuru){
                                $.messager.show({title: "提示：", msg: "上师信息添加成功...."});
                            }else{
                                $.messager.show({title: "提示：", msg: "上师信息添加失败...."});
                            }
                            $("#addGuru").dialog('close');
                            $("#GuruTable").datagrid('reload');
                        }
                    })
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function(){
                    $("#addGuru").dialog('close');
                }
            }]
        })
    }
    function updateGuru(id){
        $("#updateGuru").dialog({
            width:470,
            height:300,
            title:"修改上师信息",
            iconCls:"icon-edit",
            href:"${pageContext.request.contextPath}/back/Guru/updateGuru.jsp?id="+id,
            buttons:[{
                text:"修改",
                iconCls:"icon-save",
                handler:function () {
                    $("#updateGuruForm").form('submit',{
                        url:"${pageContext.request.contextPath}/Guru/updateGuru",
                        success:function (data) {
                            var result = $.parseJSON(data);
                            if(result.updateGuru){
                                $.messager.show({title: "提示：", msg: "上师信息修改成功...."});
                            }else{
                                $.messager.show({title: "提示：", msg: "上师信息修改失败...."});
                            }
                            $("#updateGuru").dialog('close');
                            $("#GuruTable").datagrid('reload');
                        }
                    })
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function(){
                    $("#updateGuru").dialog('close');
                }
            }]
        })
    }
    function deleteGuru(id){
        $.messager.confirm('确认','您确认想要删除当前记录吗？',function(r){
            if (r){
                $.post("${pageContext.request.contextPath}/Guru/deleteGuru","id="+id,function (data) {
                    if(data.deleteGuru){
                        $.messager.show({title: "提示：", msg: "上师信息删除成功...."});
                    }else{
                        $.messager.show({title: "提示：", msg: "上师信息删除失败...."});
                    }
                    $("#GuruTable").datagrid('reload');
                });
            }
        });
    }
</script>

<table id="GuruTable">

</table>
<div id="addGuru"></div>
<div id="updateGuru"></div>
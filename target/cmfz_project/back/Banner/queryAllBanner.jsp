<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function(){
        $("#bannerTable").datagrid({
            title:"轮播图展示",
            striped:true,
            height:360,
            url:"${pageContext.request.contextPath}/Banner/finAllBanner",
            columns:[[
                {field:"id",title:"id",width:300,align:"center",hidden:true},
                {field:"checkbox",title:"checkbox",width:80,checkbox:true},
                {field:"title",title:"标题",width:200,align:"center"},
                {field:"status",title:"状态",width:180,align:"center"},
                {field:"imgPath",title:"图片",width:300,align:"center"},
                {field:"createDate",title:"创建时间",width:200,align:"center",sortable:true},
                {field:"options",title:"options",width:200,align:"center",
                    formatter:function(value,rows,index){
                        return "<a href='#'class='delBanner'onclick=\"deleteBanner('"+rows.id+"')\">删除</a>&nbsp;&nbsp;<a href='#'class='updBanner' onclick=\"updateBanner('"+rows.id+"')\">修改</a>";
                    }
                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:100px;"></td>' +
                    '<td style="border:0">' +
                    '<p>标题: ' + rowData.title + '</p>' +
                    '<p>创建日期: ' + rowData.createDate + '</p>' +
                    '<p>状态: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar:[{
                iconCls:"icon-add",
                text:"添加",
                handler:addBanner
            },{
                iconCls:"icon-remove",
                text:"批量删除",
                handler:removeBanners
            }],
            onLoadSuccess:function(){
                $(".delBanner").linkbutton({iconCls:'icon-remove',plain:true});
                $(".updBanner").linkbutton({iconCls:'icon-edit',plain:true});
            },
        })
    });
    function removeBanners(){
        var selects =  $("#table").datagrid("getSelections");
        if(selects.length<=0){
            $.messager.show({title: "提示：", msg: "未选中行!!!"});
        }else{
            var ids = [];
            for(var i=0;i<selects.length;i++){
                ids.push(selects[i].id);
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/Banner/removeBanners",
                Type:"POST",
                traditional:true,
                data:{ids:ids},
                success:function(){
                    $("#bannerTable").datagrid('reload');
                }
            });
        }
    }

    function addBanner(){
        $("#addBanner").dialog({
            width:470,
            height:300,
            title:"添加轮播图",
            iconCls:"icon-add",
            href:"${pageContext.request.contextPath}/back/Banner/AddBanner.jsp",
            buttons:[{
                text:"添加",
                iconCls:"icon-save",
                handler:function () {
                    alert($("#biaoti").val()+"----------"+$("#zhuangtai").val()+"------------"+$("#tupian").val());
                    $("#addBannerForm").form('submit',{
                        url:"${pageContext.request.contextPath}/Banner/insertBanner",
                        success:function (data) {
                            var result = $.parseJSON(data);
                            if(result.insertBanner){
                                $.messager.show({title: "提示：", msg: "轮播图添加成功...."});
                            }else{
                                $.messager.show({title: "提示：", msg: "轮播图添加失败...."});
                            }
                            $("#addBanner").dialog('close');
                            $("#bannerTable").datagrid('reload');
                        }
                    });
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function(){
                    $("#addBanner").dialog('close');
                }
            }]
        });
    }

    function updateBanner(id){
         $("#updateBanner").dialog({
             width:470,
             height:300,
             title:"修改轮播图",
             iconCls:"icon-edit",
             href:"${pageContext.request.contextPath}/back/Banner/updateBanner.jsp?id="+id,
             buttons:[{
                 text:"修改",
                 iconCls:"icon-save",
                 handler:function () {
                     $("#updateBannerForm").form("submit",{
                         url:"${pageContext.request.contextPath}/Banner/updateBanner",
                         success:function (data) {
                             var result = $.parseJSON(data);
                             if(result.updateBanner){
                                 $.messager.show({title: "提示：", msg: "轮播图修改成功...."});
                             }else{
                                 $.messager.show({title: "提示：", msg: "轮播图修改失败...."});
                             }
                             $("#updateBanner").dialog("close");
                             $("#bannerTable").datagrid("reload");
                         }
                     });
                 }
             },{
                 text:"取消",
                 iconCls:"icon-cancel",
                 handler:function(){
                     $("#updateBanner").dialog("close");
                 }
             }]
         });
    }
    function deleteBanner(id){
            $.messager.confirm('确认','您确认想要删除当前记录吗？',function(r){
                if (r){
                    $.post("${pageContext.request.contextPath}/Banner/deleteBanner","id="+id,function (data) {
                        if(data.deleteBanner){
                            $.messager.show({title: "提示：", msg: "轮播图删除成功...."});
                        }else{
                            $.messager.show({title: "提示：", msg: "轮播图删除失败...."});
                        }
                        $("#bannerTable").datagrid('reload');
                    });
                }
            });
    }
</script>

<table id="bannerTable">

</table>
<div id="addBanner"></div>
<div id="updateBanner"></div>
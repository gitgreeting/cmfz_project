<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function(){
        $("#ArticleTable").datagrid({

            title:"上师文章展示",
            striped:true,
            fit:true,
            pagination:true,
            pageSize:10,
            pageList:[2,8,10,15,20],
            url:"${pageContext.request.contextPath}/Guru/finAllArticle",
            columns:[[
                {field:'id',title:'id',width:300,align:'center',hidden:true},
                {field:'title',title:'标题',width:80,checkbox:true},
                {field:'imgPath',title:'图片',width:200,align:'center'},
                {field:'content',title:'内容',width:180,align:'center'},
                {field:'publishDate',title:'发布日期',width:200,align:'center'},
                {field:'guru_id',title:'所属上师',width:200,align:'center'},
                {field:'options',title:'options',width:200,align:'center',
                    formatter:function(value,rows,index){
                        return "<a href='javascript:;'class='delArticle'onclick=\"deleteArticle('"+rows.id+"')\" class='easyui-linkbutton'>删除</a>";
                    }
                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/back/Guru/article_image/' + rowData.imgPath + '" style="height:100px;"></td>' +
                    '<td style="border:0">' +
                    '<p>姓名: ' + rowData.title + '</p>' +
                    '<p>头像: ' + rowData.imgPath + '</p>' +
                    '<p>内容: ' + rowData.content + '</p>' +
                    '<p>发布日期: ' + rowData.publishDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess:function(){
                $(".delArticle").linkbutton({iconCls:'icon-remove',plain:true});
            },
        })
    });
    function deleteArticle(id){
        $.messager.confirm('确认','您确认想要删除当前记录吗？',function(r){
            if (r){
                $.post("${pageContext.request.contextPath}/Guru/deleteArticle","artID="+id,function (data) {
                    if(data.deleteArticle){
                        $.messager.show({title: "提示：", msg: "上师文章删除成功...."});
                    }else{
                        $.messager.show({title: "提示：", msg: "上师文章删除失败...."});
                    }
                    $("#ArticleTable").datagrid('reload');
                });
            }
        });
    }
</script>

<table id="ArticleTable">

</table>
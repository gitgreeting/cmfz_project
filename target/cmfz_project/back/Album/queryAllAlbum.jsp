<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>
<script type="text/javascript">
    $(function(){
        $('#AlbumTable').treegrid({
            url:'${pageContext.request.contextPath}/Album/showPagesAlbum',
            idField:'id',
            treeField:'title',
            iconCls:'icon-ok',
            rownumbers: true,                 //设置为true，则显示带有行号的列
            method: 'post',                   //请求远程数据方法的类型
            pagination:true,
            fit:true,
            pageSize:30,
            pageList:[2,4,6,20,30],
            columns:[[
                {field:'id',title:'id',width:100,align:'center'},
                {field:'title',title:'名称',width:300,align:'left'},
                {field:'downPath',title:'下载路径',width:300,align:'left'},
                {field:'duration',title:'时长',width:280,align:'left'}
            ]],

            toolbar:[{
                iconCls:"icon-ok",
                text:"专辑详情",
                handler:albumDetail
            },{
                iconCls:"icon-add",
                text:"添加专辑",
                handler:addAlbum
            },{
                iconCls:"icon-add",
                text:"添加章节",
                handler:addChapters
            },{
                iconCls:"icon-ok",
                text:"下载音频",
                handler:downChapter
            }]
        });
    });
    function downChapter(){
        var row =  $("#AlbumTable").treegrid("getSelected");
        var s = row.sign;
        if(s==1){
        var name = row.downPath;
          location.href="${pageContext.request.contextPath}/Chapter/downloadChapter?chapterFile="+name;
        }
        if(s==2){
            $.messager.show({title:"提示：",msg:"请选择章节下载..."});
        }
    }
    function albumDetail(){
       var row =  $("#AlbumTable").treegrid("getSelected");
       if(row==null){
           $.messager.show({title:"提示：",msg:"请选择专辑..."});
       }else{
           var id = row.id;      /*获取专辑id*/
           var sc = row.sign;    /*获取标示,判断是专辑还是音频*/
           if(sc==2){ /*2 专辑*/
               $("#albumDetail").dialog({
                   title:"专辑详情",
                   iconCls:"icon-ok",
                   width:500,
                   height:400,
                   href:"${pageContext.request.contextPath}/back/Album/albumDetails.jsp?id="+id,

               })
           }
           if(sc==1){  /*1 音频*/
               $.messager.show({title:"提示：",msg:"请选择专辑..."});
           }


       }
}
    function addAlbum() {

        $("#addAlbum").dialog({
            title:"添加专辑",
            iconCls:"icon-ok",
            width:500,
            height:400,
            href:"${pageContext.request.contextPath}/back/Album/AddAlbum.jsp",
            buttons:[{
                text:"添加",
                iconCls:"icon-save",
                handler:function () {
                    $("#addAlbumForm").form("submit",{
                        url:"${pageContext.request.contextPath}/Album/insertAlbum",
                        success:function (data) {
                            var res = $.parseJSON(data);
                            if(res.insertAlbum){
                                $.messager.show({title:"提示：",msg:"√ 专辑添加成功..."});
                            }else{
                                $.messager.show({title:"提示：",msg:"× 专辑添加失败..."});
                            }
                            $("#addAlbum").dialog("close");
                            $('#AlbumTable').treegrid("reload");
                        }
                    })
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function () {
                    $("#addAlbum").dialog("close");
                }
            }]
        });
    }
    function addChapters(){
        var row =  $("#AlbumTable").treegrid("getSelected");
        var id = row.id;      /*获取专辑id*/
        var sc = row.sign;    /*获取标示,判断是专辑还是音频*/
        if(sc==2){ /*2 专辑*/
         $("#addChapter").dialog({
            width:500,
            height:300,
            title:"添加章节",
            iconCls:"icon-ok",
            href:"${pageContext.request.contextPath}/back/Chapter/AddChapter.jsp",
            buttons:[{
                text:"添加",
                iconCls:"icon-save",
                handler:function () {
                    $("#addChapterForm").form('submit',{
                        url:"${pageContext.request.contextPath}/Chapter/uploadChapter?id="+id,
                        success:function () {
                            $("#addChapter").dialog("close");
                            $('#AlbumTable').treegrid("reload");
                        }
                    })
                }
            }]
        })
        }
        if(sc==1){  /*1 音频*/
            $.messager.show({title:"提示：",msg:"请选择专辑..."});
        }
    }
</script>

<table id="AlbumTable">
</table>
<div id="albumDetail"></div>
<div id="addAlbum"></div>
<div id="addChapter"></div>
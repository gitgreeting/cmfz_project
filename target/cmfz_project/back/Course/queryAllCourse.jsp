<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>

<script type="text/javascript">
    $(function(){
        $("#courseTable").datagrid({
            title:"课程信息展示",
            striped:true,
            height:360,
            url:"${pageContext.request.contextPath}/Course/findAllCourse",
            columns:[[
                {field:"id",title:"id",width:300,align:"center",hidden:true},
                {field:"title",title:"标题",align:"center",width:300},
                {field:"marking",title:"简介",width:260,align:"center"},
                {field:"createDate",title:"创建时间",width:280,align:"center"},
                {field:"options",title:"options",width:260,align:"center",
                    formatter:function(value,rows,index){
                        return "<a href='#'class='delCourse'onclick=\"deleteCourse('"+rows.id+"')\">删除</a>";
                    }
                },
            ]],
            toolbar:[{
                iconCls:"icon-add",
                text:"添加",
                handler:addCourse
            }],
            onLoadSuccess:function(){
                $(".delCourse").linkbutton({iconCls:'icon-remove',plain:true});
            },
        })
    });
    function addCourse(){
        $("#addCourse").dialog({
            width:470,
            height:200,
            title:"添加课程信息",
            iconCls:"icon-add",
            href:"${pageContext.request.contextPath}/back/Course/AddCourse.jsp",
            buttons:[{
                text:"添加",
                iconCls:"icon-save",
                handler:function () {
                    $("#addCourseForm").form('submit',{
                        url:"${pageContext.request.contextPath}/Course/insertCourse",
                        success:function (data) {
                            var result = $.parseJSON(data);
                            if(result.insertCourse){
                                $.messager.show({title: "提示：", msg: "课程信息添加成功...."});
                            }else{
                                $.messager.show({title: "提示：", msg: "课程信息添加失败...."});
                            }
                            $("#addCourse").dialog('close');
                            $("#courseTable").datagrid('reload');
                        }
                    });
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function(){
                    $("#addCourse").dialog('close');
                }
            }]
        });
    }
    function deleteCourse(id){
        $.messager.confirm('确认','您确认想要删除当前记录吗？',function(r){
            if (r){
                $.post("${pageContext.request.contextPath}/Course/deleteCourse","courseId="+id,function (data) {
                    if(data.deleteCourse){
                        $.messager.show({title: "提示：", msg: "课程删除成功...."});
                    }else{
                        $.messager.show({title: "提示：", msg: "课程删除失败...."});
                    }
                    $("#courseTable").datagrid('reload');
                });
            }
        });
    }
</script>
<table id="courseTable">
</table>
<div id="addCourse"></div>

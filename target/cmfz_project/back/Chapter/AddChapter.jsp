<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>


<div style="text-align: center">
    <form id="addChapterForm" method="post" class="easyui-form" enctype="multipart/form-data" >

        <div style="margin-top:40px">
            标题：<input class="easyui-textbox"  name="title"  data-options="required:true"/>
        </div>
        <div style="margin-top:15px">
            时长：<input class="easyui-textbox"  name="duration"  data-options="required:true"/>
        </div>
        <div style="margin-top:15px">
            图片: <input class="easyui-filebox" name="addFile"/>
        </div>
    </form>
</div>

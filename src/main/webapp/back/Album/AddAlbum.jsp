<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>


<div style="text-align: center">
    <form id="addAlbumForm" method="post" class="easyui-form" enctype="multipart/form-data" >

        <div style="margin-top:40px">
            标题：<input class="easyui-textbox" name="title"  data-options="required:true"/>
        </div>
        <div style="margin-top:8px">
            集数：<input class="easyui-textbox"  name="count" />
        </div>
        <div style="margin-top:8px">
            图片: <input class="easyui-filebox"  value=""  name="fileAlbum"/>
        </div>
        <div style="margin-top:8px">
            评分: <input class="easyui-textbox"  value="" name="score"/>
        </div>
        <div style="margin-top:8px">
            作者: <input class="easyui-textbox"  value=""name="author"/>
        </div>
        <div style="margin-top:8px">
            播音: <input class="easyui-textbox"  value=""  name="broadCast"/>
        </div>
        <div style="margin-top:8px">
            简介: <input class="easyui-textbox"  value=""  name="brief"/>
        </div>
    </form>
</div>

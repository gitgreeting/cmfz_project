<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>


<div style="text-align: center">
    <form id="addBannerForm" method="post" class="easyui-form" enctype="multipart/form-data" >

        <div style="margin-top:40px">
            标题：<input class="easyui-textbox" id="biaoti" name="title"  data-options="required:true"/>
        </div>
        <div style="margin-top:15px">
            状态：<input class="easyui-textbox" id="zhuangtai" name="status"  data-options="required:true"/>
        </div>
        <div style="margin-top:15px">
            图片: <input class="easyui-filebox"  value="" id="tupian" name="file" />
        </div>
    </form>
</div>

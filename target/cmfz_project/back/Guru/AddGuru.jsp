<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>


<div style="text-align: center">
    <form id="addGuruForm" method="post" class="easyui-form" enctype="multipart/form-data">

        <div style="margin-top:40px">
            姓名：<input class="easyui-textbox" name="name"  data-options="required:true"/>
        </div>
        <div style="margin-top:15px">
            头像：<input class="easyui-filebox"  name="guruFile"  data-options="required:true"/>
        </div>
        <div style="margin-top:15px">
            性别: <select style="width:120px" name="gender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                  </select>
        </div>
    </form>
</div>

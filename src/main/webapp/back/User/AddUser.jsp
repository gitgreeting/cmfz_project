<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>
<div style="text-align: center">
    <form id="addUserForm" method="post" class="easyui-form" enctype="multipart/form-data" >

        <div style="margin-top:30px">
            电话：<input class="easyui-textbox"  name="phoneNum"  data-options="required:true"/>
        </div>
        <div style="margin-top:8px">
            法名：<input class="easyui-textbox" name="nickName"  data-options="required:true"/>
        </div>
        <div style="margin-top:8px">
            姓名：<input class="easyui-textbox"  name="userName"  data-options="required:true"/>
        </div>
        <div style="margin-top:8px">
            密码：<input class="easyui-textbox"  name="password"  data-options="required:true"/>
        </div>
        <div style="margin-top:8px">
            省份：<input class="easyui-textbox"  name="province"  data-options="required:true"/>
        </div>
        <div style="margin-top:8px">
            城市：<input class="easyui-textbox"  name="city"  data-options="required:true"/>
        </div>
        <div style="margin-top:8px">
            图片: <input class="easyui-filebox" name="userfile" />
        </div>
        <div style="margin-top:8px">性别：<select name="gender" style="width:170px">
                                                   <option value="男">男</option>
                                                   <option value="女">女</option>
                                             </select>
        </div>
    </form>
</div>
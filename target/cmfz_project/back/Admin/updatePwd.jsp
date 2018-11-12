<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        $("#update").form('load',"${pageContext.request.contextPath}/Admin/queryOne?admin_id="+${param.admin_id});
    })
</script>
<div style="text-align: center">
    <form id="update" method="post" class="easyui-form">

        <div style="margin-top:55px">
            原密码：<input class="easyui-textbox" name="oldPwd" id="oldPwd" data-options="required:true"/>
        </div>
        <div style="margin-top:25px">
            新密码：<input class="easyui-passwordbox"  name="newPwd" id="newPwd" data-options="required:true"/>
        </div>
        <div style="display: none">
            id: <input type="text" class="easyui-textbox" name="admin_id" id="admin_id" value=""/>
        </div>
        <div style="display: none">
            name: <input type="text" class="easyui-textbox" name="name" id="name" value=""/>
        </div>

        <div style="display: none">
            pwd: <input type="text" class="easyui-textbox" name="password" id="password" value=""/>
        </div>
    </form>
</div>

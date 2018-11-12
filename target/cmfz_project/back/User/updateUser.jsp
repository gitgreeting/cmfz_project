<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        $("#updateUserForm").form('load',"${pageContext.request.contextPath}/User/queryOneUser?userId=${param.uid}");
    })
</script>

<div style="text-align: center">
    <form id="updateUserForm" method="post" class="easyui-form" enctype="multipart/form-data">
        <div style="margin-top:30px">
            法名：<input class="easyui-textbox" name="nickName" />
        </div>
        <div style="margin-top:10px">
            姓名：<input class="easyui-textbox"  name="userName"  />
        </div>
        <div style="margin-top:10px">
            头像: <input class="easyui-filebox" name="userfile"/>
        </div>
        <div style="margin-top:10px">
            省份：<input class="easyui-textbox" name="province" />
        </div>
        <div style="margin-top:10px">
            城市：<input class="easyui-textbox" name="city" />
        </div>
    </form>
</div>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        $("#updateGuruForm").form('load',"${pageContext.request.contextPath}/Guru/queryOneGuru?id=${param.id}");
    })
</script>

<div style="text-align: center">
    <form id="updateGuruForm" method="post" class="easyui-form" enctype="multipart/form-data">
        <div style="margin-top:40px">
            姓名：<input class="easyui-textbox" name="name"/>
        </div>
        <div style="margin-top:15px">
            头像：<input class="easyui-filebox"  name="guruFileUpd"/>
        </div>
        <div style="margin-top:15px">
            性别: <select style="width:120px" name="gender">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
        </div>
        <div style="margin-top:10px">
            id：<input class="easyui-textbox" name="id"/>
        </div>
    </form>
</div>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function(){
        $("#updateBannerForm").form("load","${pageContext.request.contextPath}/Banner/queryOneBanner?id=${param.id}");
    });
</script>

<div style="text-align: center">
    <form id="updateBannerForm" method="post" class="easyui-form" enctype="multipart/form-data">
        <div style="margin-top:40px">
            标题：<input class="easyui-textbox" name="title" />
        </div>
        <div style="margin-top:15px">
            状态：<input class="easyui-textbox"  name="status"  />
        </div>
        <div style="margin-top:15px">
            图片: <input class="easyui-filebox" name="file"/>
        </div>
        <div style="margin-top:2px">
            id：<input class="easyui-textbox" value="${param.id}" name="id"/>
        </div>
    </form>
</div>
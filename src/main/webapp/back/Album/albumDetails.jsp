<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>
<script type="text/javascript">
    $(function () {
        $("#details").form('load',"${pageContext.request.contextPath}/Album/albumDetails?id="+${param.id});
        var va = $("#coverImg").val();
      /*  $("#img").attr("src","${pageContext.request.contextPath}/back/Album/album_image/"+va+"");*/
    })
</script>

    <div id="ab" style="padding: 10px;">
    <form method="post" id="details" class="easyui-form">
        <div id="topbox">
            <img src="${pageContext.request.contextPath}/back/Album/album_image/A-1.jpg" style="height: 130px" id="img"/>
            <div id="rightbox" >
             <p style="display: none;"><input type="hidden" name="coverImg" id="coverImg"/></p>
                <input type="text" name="title" style="margin-top: 15px"/><br>
                评分： <input type="text" name="score"/><br>
                作者： <input type="text" name="author"/><br>
                播音： <input type="text" name="broadCast"/><br>
                集数： <input type="text" name="count"/>
            </div>
        </div>
        <div id="bottombox">
            <span id="c1">内容简介：</span><textarea name="brief"></textarea>
            <p id="pdate">发布日期：<input type="text" name="publish_date" /></p>
        </div>
    </form>
</div>


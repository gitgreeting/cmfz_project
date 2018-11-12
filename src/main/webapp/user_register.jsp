<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {

        });
    </script>
    <style type="text/css">

</style>
</head>
<body>

<div style="text-align: center;border:1px solid lightblue;width:500px;height:380px;margin: 100px auto">
    <h2 style="text-align: center">用户注册页面</h2>
    <form id="registerUserForm" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/User/insertUser">

        <div style="margin-top:30px">
            电话：<input type="text"  name="phoneNum"  />
        </div>
        <div style="margin-top:8px">
            法名：<input type="text"  name="nickName" />
        </div>
        <div style="margin-top:8px">
            姓名：<input type="text"  name="userName" />
        </div>
        <div style="margin-top:8px">
            密码：<input type="text"   name="password"  />
        </div>
        <div style="margin-top:8px">
            省份：<input type="text"   name="province" />
        </div>
        <div style="margin-top:8px">
            城市：<input type="text"   name="city"  />
        </div>
        <div style="margin-top:8px">
            图片: <input type="file"  name="userfile" />
        </div>
        <div style="margin-top:8px">性别：<select name="gender" style="width:170px;height:25px;">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
        </div><br/>
        <span style="margin-left: 200px"><input type="submit" id="submitUser"   value="注册"/> &nbsp;&nbsp;<input type="button"value="取消"/></span>
    </form>
</div>
</body>
</html>

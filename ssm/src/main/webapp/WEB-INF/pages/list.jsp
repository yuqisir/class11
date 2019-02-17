<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/user/findAll" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" name="user.username"  value="" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control"  name="user.address" value="" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control"  name="user.email" value="" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.sex}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/path/pathName/add">添加联系人</a></td>
        </tr>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="${pageContext.request.contextPath}/user/findAll?pageNum=${pages.pageNum-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="">1</a></li>
            <li>
                <a href="${pageContext.request.contextPath}/user/findAll?pageNum=${pages.pageNum+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px;margin-left: 5px;">
                    共  ${pages.counts} 条记录，共 ${pages.pages}页
                </span>

        </ul>
    </nav>
</div>
</body>
</html>

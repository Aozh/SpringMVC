<%--
  Created by IntelliJ IDEA.
  User: zhaoli8
  Date: 2016/8/22
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>确定权限</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h3>用户权限管理</h3>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 权限管理</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <script>
        function getCheckbox(){alert(cbox);
//            var hbox = document.mysub("cbox");
//            var value;
//            for (i=0; i<hbox.length; i++){
//                hbox[i].value=hbox[i].checked;
//                if (hbox[i].checked){
//                    if (!value){
//                        value = hbox[i].value;
//                    } else {
//                        value += "," + hbox[i].value;
//                    }
//                }
//            }

           // alert(value == undefined ? '' : value);
        }
    </script>
    <script>function displayResult(){alert("职位")} </script>
</head>
<body>
<div class="container">
    <h1>用户权限管理</h1>
    <hr/>

    <%--<h3>所有用户 <a href="/admin/users/add" type="button" class="btn btn-primary btn-sm">添加</a></h3>--%>

    <!-- 如果用户列表为空 -->
    <button type="button" onclick="displayResult()">显示value值</button>
    <!-- 如果用户列表非空 -->
    <c:if test="${!empty permissionList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>pin</th>
                <th>增加</th>
                <th>显示</th>
                <th>删除</th>
            </tr>

            <c:forEach items="${permissionList}" var="user">
                <tr>
                    <form action="/admin/users/addPermission1" method="post">
                    <td>${user.pin}</td>
                    <%--<td>${user.add}</td>--%>
                    <%--<td>${user.show} </td>--%>
                    <%--<td>${user.delete}</td>--%>
                    <td> <label><input type="checkbox" id="cbox1" name="cbox" value=${user.add} <c:if test="${fn:contains(user.add,1)}">checked="checked"</c:if> > 访问权限</label><br></td>
                    <td> <label><input type="checkbox" id="cbox2" name="cbox" value=${user.show} <c:if test="${fn:contains(user.show,1)}">checked="checked"</c:if> > 修改权限</label><br></td>
                    <td> <label><input type="checkbox" id="cbox3" name="cbox" value=${user.delete}  <c:if test="${fn:contains(user.delete,1)}">checked="checked"</c:if>> 删除权限</label><br></td>

                      String[] x=request.getParameterValues(cbox);
                    <td>

                            <input type="submit" value="保存" onclick="getCheckbox()">
                       <%--onclick="javascript:mysub()"--%>
                        </form>
                                                    </td>
                </tr>

            </c:forEach>
            <%--<%--%>
                <%--request.setCharacterEncoding("GB2312");--%>

                <%--String Tech[]=request.getParameterValues("cbox");--%>
                <%--System.out.println("good");--%>
            <%--%>--%>
            <%--<%--%>

                <%--int i;--%>
                <%--for(i=0;i<Tech.length;i++)--%>
                <%--{--%>
                    <%--System.out.println(Tech[i]);--%>
                <%--}--%>
            <%--%>--%>
        </table>
    </c:if>
</div>


</body>
</html>



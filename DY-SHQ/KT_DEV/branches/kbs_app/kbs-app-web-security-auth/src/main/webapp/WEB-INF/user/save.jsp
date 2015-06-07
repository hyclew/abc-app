<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <script src="${pageContext.servletContext.contextPath}/static/jquery/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function($) {
            $("#passRadio :radio").change(function(e){
               if($(this).val()=='true'){
                   $("#passDiv").html('<input type="hidden" id="password" name="password" value="'+$("#passwordCopy").val()+'"/>');
               }else{
                   $("#passDiv").html('密码:<input type="text" name="password"/>');
               }
            });
        });
    </script>
</head>
<body>
<form action="save" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <c:if test="${action=='update'}"><div>用户ID:${user.id}<input type="hidden" value="${user.id}" name="id"></div></c:if>
    <div>用户名:<input type="text" value="${user.username}" name="username"/></div>
    <c:if test="${action=='add'}"><div>密码:<input type="text" name="password"/></div></c:if>
    <c:if test="${action=='update'}">
    <div id="passRadio">是否修改密码:<input type="radio" name="passNonUpdate" value="true" checked="checked"/>否<input type="radio" name="passNonUpdate" value="false"/>是</div>
        <input type="hidden" id="passwordCopy" name="passwordCopy" value="${user.password}"/>
        <div id="passDiv"><input type="hidden" id="password" name="password" value="${user.password}"/></div>
    </c:if>
    <div>帐号是否过期:<select name="accountNonExpired">
        <option value="true" <c:if test="${user.accountNonExpired}">selected="selected"</c:if>>否</option>
        <option value="false" <c:if test="${!user.accountNonExpired}">selected="selected"</c:if>>是</option>
    </select></div>
    <div>帐号是否锁定:<select name="accountNonLocked">
        <option value="true" <c:if test="${user.accountNonLocked}">selected="selected"</c:if>>否</option>
        <option value="false" <c:if test="${!user.accountNonLocked}">selected="selected"</c:if>>是</option>
    </select></div>
    <div>凭证是否过期:<select name="credentialsNonExpired">
        <option value="true" <c:if test="${user.credentialsNonExpired}">selected="selected"</c:if>>否</option>
        <option value="false" <c:if test="${!user.credentialsNonExpired}">selected="selected"</c:if>>是</option>
    </select></div>
    <div>是否启用:<select name="enabled">
        <option value="true" <c:if test="${user.enabled}">selected="selected"</c:if>>是</option>
        <option value="false" <c:if test="${!user.enabled}">selected="selected"</c:if>>否</option>
    </select></div>
    <div><input type="submit" value="保存"/></div>
</form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <script src="${pageContext.servletContext.contextPath}/static/jquery/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<span style="color:#008080"><sec:authorize access="isRememberMe()">欢迎你通过记住我登录到首页!</sec:authorize>
    <sec:authorize access="isFullyAuthenticated()">${pageContext.request.remoteUser},欢迎你通过用户名/密码到首页!</sec:authorize></span>
<c:url value="/user/list" var="userListUrl"/><a href="${userListUrl}">我要转到用户列表</a>
<c:url value="/logout" var="logoutUrl"/>
<form style="display: inline" action="${logoutUrl}" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type="submit" value="退出"/></form>


<div><sec:authorize access="hasAuthority('USER_QUERY')">你有USER_QUERY权限</sec:authorize></div>


当前有${numOfUsers}个用户在线...
</body>
</html>

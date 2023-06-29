<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> WELCOME </h1>
<c:url var="countURI" value="/hr/count"/>
<a href= "${countURI}" >사원의 수 조회</a>
<c:url var="getInfoURI" value="/hr/list"/>
<a href= "${getInfoURI}" >사원 정보 조회</a>
<c:url var="insertURI" value="/hr/insert"/>
<a href= "${insertURI}" >사원 정보 입력</a>
<c:url var="updateURI" value="/hr/update"/>
<a href= "${updateURI}" >사원 정보 수정</a>
<c:url var="deleteURI" value="/hr/delete"/>
<a href= "${deleteURI}" >사원 정보 삭제</a>


</body>
</html>
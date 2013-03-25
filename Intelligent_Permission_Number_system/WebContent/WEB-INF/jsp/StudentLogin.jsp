<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>INTELLIGENT PERMISSION NUMBER MANAGEMENT SYSTEM</title>

<link href="styles/check_cs6.css" rel="stylesheet" type="text/css">
<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 169px;
	height: 115px;
	z-index: 1;
	left: 809px;
	top: 269px;
}
#apDiv2 {
	position: absolute;
	width: 168px;
	height: 150px;
	z-index: 2;
	left: 298px;
	top: 269px;
}
#apDiv3 {
	position: absolute;
	width: 744px;
	height: 219px;
	z-index: 1;
	left: 58px;
	top: 153px;
}
</style>
</head>

<body>
<form:form action="StudentLogin.html" commandName="loginForm">
<div id="container">
  <div id="header">
    
    <h1>SJSU</h1>
    <p>Intelligent Permission Number Management System</p>
    <ul>
      <li><a href="index1.html">Back</a></li>
    </ul>
  </div>
  <div id="main">
    <div id="apDiv3">
      <table width="743">
        <tr>
          <td width="321" height="72"></td>
          <td width="171">&nbsp;</td>
          <td width="235">&nbsp;</td>
        </tr>
        <tr>
         <td><FONT color="red"><form:errors path="userName" /></FONT></td>
         </tr>
         <tr>
          <td height="33">&nbsp;</td>
          <td align="right"><em><strong>Username:</strong></em></td>
          <td align="left">
            <form:input path="userName" />
          </td>
        </tr>
        <tr>
          <td height="34">&nbsp;</td>
          <td align="right"><strong><em>Password</em></strong></td>
          <td align="left">
            <form:password path="password" />
          </td>
        </tr>
        <tr>
         <td><FONT color="red"><form:errors path="password" /></FONT></td>
         </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
        <td><FONT color="red"><form:errors path="notValid" /></FONT></td>
        </tr>
        <tr>
          <td height="37">&nbsp;</td>
          <td></td>
          <td><input type="submit" value="" class="imgclass"></td>
        </tr>
      </table>
    </div>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
  </div>
  <div id="left_column"></div>
 </div>
 </form:form>
</body>
</html>
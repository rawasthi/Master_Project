<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INTELLIGENT PERMISSION NUMBER MANAGEMENT SYSTEM</title>

<link href="styles/check_cs6.css" rel="stylesheet" type="text/css">
<script language = javascript>
var counttblSample=1;
		var counttblDocumentationLocal=1;
		var counttblDocumentationExternal=1;
		var counttblOpenSrc=1;
		var counttblOpenSrcMod=1;
		var counttblOpenSrcAttributions=1;
		var countemail=0;

function addRowToTabletblSample()
		{
			++counttblSample;
			var tbl = document.getElementById('tblSample');
			var lastRow = tbl.rows.length;
			var iteration = lastRow-1;
			var row = tbl.insertRow(lastRow);
			
			var cellRight = row.insertCell(0);
			var cell5 = row.insertCell(1);
 //This is where the SOLUTION is!!
 var element4 = document.createElement("select");
 var option1 = document.createElement("option");
 option1.value="1";
 option1.innerHTML="sample1";
 element4.appendChild(option1);
 var option2 = document.createElement("option");
 option2.value="2";
 option2.innerHTML="sample2";   			
 element4.appendChild(option2);
 element4.align="center";
  cell5.appendChild(element4);
			
			var cell = row.insertCell(2);
			var e2 = document.createElement('input');
			e2.setAttribute('type', 'text');
			e2.setAttribute('id', 'AddCode' + iteration);
			cell.appendChild(e2);

			
			
		}
		
		function removeRowFromTabletblSample()
		{
			var tbl = document.getElementById('tblSample');
			var lastRow = tbl.rows.length;
			--counttblSample;
			if (lastRow > 3) tbl.deleteRow(lastRow - 1);
		}
</script>
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
</style>
</head>

<body>
<div id="container">
<div id="header">

<h1>SJSU</h1>
<p>Intelligent Permission Number Management System</p>
<ul>
      <li><a href="StudentLogin.html">Logout</a></li>
</ul>
</div>
<div id="main">
<p>&nbsp;</p>
<table id="tblSample" width="1047" height="170" border="0">
  <tr>
    <td align="right" width="587" height="72"><strong> Upload Transcript</strong></td>
    <td>
      <input type="file">
    </td>
    <td width="273">
   
    </td>
  </tr>
  <tr>
    <td align="right" height="67"><strong>email</strong></td>
    <td>
      <label for="email"></label>
      <input type="text" name="email" id="email">
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="right" height="26"><strong>Choose Course&nbsp;</strong></td>
    <td align="left">
      <label for="Course"></label>
      <select name="Course" id="Course">
      	<option>Course1</option>
        <option>Course2</option>
      </select>&nbsp;Permission Number:
    </td>
    <td>
      <input type="text" name="AddCode" id="AddCode"><input type="button" value="+" onclick="addRowToTabletblSample();" /> <input type="button" value="-" onclick="removeRowFromTabletblSample();" /> </td>
  </tr>
  </table>
  <table>
  <tr>
    <td width="585" height="84" align="right">
      <input type="button" name="Request" id="Request" value="Request">
    </td>
    <td width="175" align="center">
      <input type="button" name="Register" id="Register" value="Register">
    </td>
    <td width="275">
      <input type="button" name="Reset" id="Reset" value="Reset">
   </td>
  </tr>
</table>
<p>&nbsp;</p>
</div>
<div id="left_column"></div>
</div>

</body>
</html>

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

<script language="javascript">
function showSelection() {
	var value = document.getElementById("selection");
	value.style.display = "block"; 
}

function showTable(tableid) {
	var value = tableid;
	var enrolled = document.getElementById("table1");
	var waiting = document.getElementById("table2");
	var pending = document.getElementById("table3");
	
	if(tableid == "enrolled")
	{
		enrolled.style.display = "block";
		waiting.style.display = "none";	
		pending.style.display = "none";
	}else if(tableid == "waiting")
	{
		waiting.style.display = "block";
		enrolled.style.display = "none";
		pending.style.display = "none";	
	}else if(tableid == "pending")
	{
		pending.style.display = "block";
		waiting.style.display = "none";
		enrolled.style.display = "none";
	}
} 
</script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script type="text/javascript">
    function doAjax() {
        var methodUrl = "/Intelligent_Permission_Number_system/time.html";
        $.ajax({
            type: "GET" ,
            url:methodUrl ,
            data: ({name : "me"}),
            success: function(data) {
              $('#time').html(data);
            }
          });
    }
</script>
  
</head>

<body>

<div id="container">
<div id="header">

<h1>SJSU</h1>
<p>Intelligent Permission Number Management System</p>
<ul>
      <li><a href="ProfessorLogin.html">Logout</a></li>
      <li><a href="ProfessorLogin.html">Back</a></li>
</ul>
</div>

<div id="main">
  <table width="523" border="0" align="center">
	<tr>
    <td width="174" align="right">Please select course</td>
    <td width="135" align="center">
      <label for="course"></label>
      <select name="course" id="course">
      </select>
    </td>
    <td width="277" align="left">
      <input type="button" name="Go" id="Go" value="Go" onClick="javascript:showSelection();">
    </td>
    </tr> 
    </table>
    <div id="selection" style="display: none">
    <table align="center"> 
    <tr>
      <td width="230"></td>
      <td width="97">&nbsp;</td>
      <td width="115">&nbsp;</td>
      <td width="140">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>
        <input type="radio" name="radio" id="enrolled" value="enrolled" onclick="javascript:showTable('enrolled');">
        <label for="enrolled">Enrolled</label>
    </td>
      <td>
        <input type="radio" name="radio" id="waiting" value="waiting" onclick="javascript:showTable('waiting');">
        <label for="waiting">Waiting</label>
      </td>
      <td>
        <input type="radio" name="radio" id="pending" value="pending" onclick="javascript:showTable('pending');">
        <label for="pending">Pending</label>
     </td>
    </tr>
    
  </table>
    </div>
</div>

<div id="table1" style="display: none">
<p align="center"> <strong>Enrolled list of students</strong></p>
<table width="600" border="1" align="center">
  <tr>
    <th width="174" bgcolor="#CCCCCC">Serial Number</th>
    <th width="410" bgcolor="#CCCCCC"> Name</th>
    <th width="410" bgcolor="#CCCCCC">SJSU ID</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Rohit Awasthi</td>
    <td>996923456</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Ankur Aggarwal</td>
    <td>359742849</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Vishal Sharma</td>
    <td>133295353</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Abhinav Patil</td>
    <td>121324359</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Abhinav Patil</td>
    <td>121324359</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Abhinav Patil</td>
    <td>121324359</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Abhinav Patil</td>
    <td>121324359</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Abhinav Patil</td>
    <td>121324359</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Abhinav Patil</td>
    <td>121324359</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Abhinav Patil</td>
    <td>121324359</td>
  </tr>
</table>
<p>&nbsp;</p>
</div>

<div id="table2" style="display: none">
<p align="center"><strong>Waiting list of students</strong></p>
<table width="600" border="1" align="center">
  <tr>
    <th bgcolor="#CCCCCC">Select</th>
    <th bgcolor="#CCCCCC">Name</th>
    <th bgcolor="#CCCCCC">Priority</th>
    <th bgcolor="#CCCCCC">SJSU ID</th>
    <th bgcolor="#CCCCCC">email</th>
  </tr>
  <tr>
    <td><input type="checkbox" name="cb1" id="cb1"></td>
    <td>Neemit Gandhi</td>
    <td>1</td>
    <td>448375948</td>
    <td>it@gmail.com</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="cb2" id="cb2"></td>
    <td>Nilay Shah</td>
    <td>2</td>
    <td>520705725</td>
    <td>th@gmail.com</td>
  </tr>
  <tr>
  <td><input type="checkbox" name="cb3" id="cb3"></td>
    <td>Amit Sant</td>
    <td>3</td>
    <td>023935020</td>
    <td>fn@gmail.com</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="cb4" id="cb4"></td>
    <td>Harshil Shah</td>
    <td>4</td>
    <td>253203955</td>
    <td>de@gmail.com</td>
  </tr>
</table>
<p>&nbsp;</p>
</div>

<div id="table3" style="display: none">
<p align="center"><strong>Pending list of students</strong></p>
<table width="600" border="1" align="center">
  <tr>
    <th bgcolor="#CCCCCC">Serial Number</th>
    <th bgcolor="#CCCCCC">Name</th>
    <th bgcolor="#CCCCCC">SJSU ID</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Ramman Anna</td>
    <td>998347583</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Prasanna Ramanujan</td>
    <td>299148749</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Arvindh Akshan</td>
    <td>984792384</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Sachin Samual</td>
    <td>234892384</td>
  </tr>
</table>
<p>&nbsp;</p>
</div>
</div>
<button id="demo" onclick="doAjax()" title="Button">Get the time!</button>
<div id="time"></div>
<div id="left_column1"></div>

</body>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.emc.miniproject.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Insert title here</title>
</head>
<body>

<form action="toto" method="get">
  Nom de la Table: 
  <select name="table">
  <option value="student">student</option>
  <option value="teacher">teacher</option>
  </select>
  
<br>
  <input type="submit" value="soumettre">
</form>



<%
	List<Student> students = (List<Student>) request.getAttribute("studentList");
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teacherList");
	String [] cols = (String []) request.getAttribute("columnTab");
	
	String titre = "";
	if (students != null) titre="Etudiants";
	else if	(teachers != null) titre = "Professeurs";
%>

<h1><%=titre %></h1>

<table>

    <tr>
    <%	
	if (cols !=null)
	for(int i=0;i<cols.length;i++)
	{
	%>
	
    <th><%=cols[i] %></th>
    
    <%
	}
	%>
    </tr>

	<%	
	if (students !=null) {
	for(Student student : students)
	{
	%>
		
		<tr>
			<td><span><%= student.getStu_id() %></span></td>
			<td><span><%= student.getStu_name() %></span></td>
			<td><span><%= student.getStu_cell() %></span></td>
		</tr>
		
		
		
	<%
	}
	} else if (teachers !=null){
	 
		for(Teacher teacher : teachers)
	{
	%>
		
		<tr>
			<td><span><%= teacher.getTea_id() %></span></td>
			<td><span><%= teacher.getTea_name() %></span></td>
			<td><span><%= teacher.getTea_salary() %></span></td>
			
		</tr>
		
		
		
	<%
	}
	} 
	%>


</table>


</body>
</html>
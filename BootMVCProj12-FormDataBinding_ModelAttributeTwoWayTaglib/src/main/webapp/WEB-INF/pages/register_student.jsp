<!-- Desgn form using html tags -->
<!-- IMPORT TAGLIB LIBRARY -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 style="color: red; text-align: center;">Register student</h2>

<form:form modelAttribute="stud" method="post">
	<!-- here we are saying that bind this class with (modelAttribute="stud") and show from using its initial values -->
	Student Number :- <form:input path="sno" />
	<br>
	Student Name :-  <form:input path="sname" />
	<br>
	<!-- Path attr is used from data dinding with our model class -->
	Student Address :-  <form:input path="sadd" />
	<br>
	Student Avg :-  <form:input path="avg" />
	<br>
	<input type="submit" value="Register ">
</form:form>
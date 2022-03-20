<!-- Desgn form using html tags -->

<h2 style="color: red;text-align: center;">Register student</h2>
<form  style="color: red;text-align: center;"  method="post">    <!-- since open form path and action path is same then no need of taking of action attr in form(thats why i am not giving action attr here but it is working bcz of match url pattern   -->
	<label>Student Number :- </label> <input type="number" name="sno"><br>
	<label>Student Name :- </label> <input type="text" name="sname"><br>
	<label>Student Address :- </label> <input type="text" name="sadd"><br>
	<label>Student Avg :- </label> <input type="number" name="avg"><br>
  <input type="submit" value="Register ">
</form>
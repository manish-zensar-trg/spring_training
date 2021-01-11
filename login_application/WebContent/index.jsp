<html>
<body>
<% String message = (String) request.getAttribute("message");
	if(message != null){
%>
<h3 style="color:red"><%=message %></h3>
<% } %>
<h2>Enter your Login Credentials</h2>
<form action="login" method="post">
<table>
	<tr>
		<td> User Id: </td>
		<td> <input type="text" name="userId" /> </td>
	</tr>
	<tr>
		<td> Password: </td>
		<td> <input type="password" name="password" /> </td>
	</tr>
	<tr>
		<td> &nbsp; </td>
		<td> <input type="submit" value="Login" /> </td>
	</tr>
</table>
</form>
</body>
</html>

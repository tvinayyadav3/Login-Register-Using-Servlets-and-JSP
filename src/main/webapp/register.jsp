
<body>
<form name="f2" action="/SimpleLoginProject/RegisterServlet" method="post" onSubmit="return validate2()">
		Name <input type="text" name="name"><br>
		Nsername <input type="text" name="username"><br>
		Password <input type="password" name="password"><br>
		Repassword<input type="password" name="repassword"><br>
		<input type ="submit" value="Register"><br>
	
	</form>
	New User <a href="register.jsp">Register</a>
	<script type="text/javascript">
		function validate2()
		{
			let x1=document.f2.name.value;
			let x2=document.f2.use rname.value;
			let x3=document.f2.password.value;
			let x4=document.f2.repassword.value;
			if(x1==null || x1=="")
				{
					alert("name cannot be empty");
					return false;
				}
			if(x2==null || x2=="")
			{
				alert("username cannot be empty");
				return false;
			}
			if(x3==null || x3=="")
			{
				alert("username cannot be empty");
				return false;
			}
			if(x3!=x4)
				{
					alert("password and retype password should be same");
					return false;
				}
			return true;
		}
	</script>
</body>

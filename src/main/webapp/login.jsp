<!doctype html>
<%@page import="java.util.Date"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
h1 {
	color: #051367;
	background-color: #DFF6FF;
	height: 60px;
	padding-left: 40px;
}

body {
	background-color: #D6E5FA;
}
</style>

<title>Login</title>
</head>
<body>
	<div>
		<h1>Login</h1>
	</div>
	<div class="container" style="margin-top: 30px;">
		<div class="row">
			<div class="col-md-6">
				<form id="form" action = "<%= request.getContextPath()%>/login" method = "post" class="filledForm" autocomplete="on">

					<div class="mb-2 row">
						<div class="col-md-3">
							<font size="+2"> <label for="Name1" class="form-label">UserName:</label>
							</font>
						</div>
						<div class="col-md-5">
							<input type="text" name = "username" class="form-control" id="Name1"
								autocomplete="on" required>

						</div>
					</div>
					<div class="mb-2 row">
						<div class="col-md-3">
							<font size="+2"> <label for="Name1" class="form-label">Password:</label>
							</font>
						</div>
						<div class="col-md-5">
							<input name = "password" type="password" class="form-control" id="Name1"
								autocomplete="on" required>

						</div>
						<div class="col-md-4" id="name">
							<span id="username" style="color: red;"></span>
						</div>
					</div>
					<div class = "mb-2 row">
						<a href = "none" style = "padding-left:320px;">Forgot Password</a>
					</div>
					<div class="mb-2 row">
						<div class="col-md-4">
							<button type="submit" id="submit" class="btn btn-primary submit"
								style="width: 90%;">Login</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
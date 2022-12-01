<%@page import="com.login.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%--Importing all the dependent classes--%>
<%@page import="com.main.Product"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body style="background-color: #D6E5FA">
	<div>
		<h1 style="display: inline; margin-left: 400px; padding-top: 10px">Product
			Management Tool</h1>
		<h6 style="display: inline; margin-left: 170px"><%="Hi  " + session.getAttribute("username")%></h6>
		<form action="login.jsp" style="width: 0%; display: inline">
			<button type="submit" id="submit" class="btn btn-primary submit"
				style="width: 6%; margin-left: 15px">Logout</button>
		</form>
	</div>
	<div>
		<div class="container col-md-8 col-md-offset-3"
			style="overflow: auto; padding-top: 20px; margin-left: 10px">
			<form action="<%=request.getContextPath()%>/main">
				<div class="mb-2 row">
					<div class="col-md-3">
						<font size="+2"> <label for="Name1" class="form-label">Title:</label>
						</font>
					</div>
					<div class="col-md-5">
						<input type="text" name="title" class="form-control" id="title"
							autocomplete="on" required>

					</div>
				</div>
				<div class="mb-2 row">
					<div class="col-md-3">
						<font size="+2"> <label for="Name1" class="form-label">Quantity:</label>
						</font>
					</div>
					<div class="col-md-5">
						<input type="text" name="quantity" class="form-control"
							id="quatity" autocomplete="on" required>

					</div>
				</div>
				<div class="mb-2 row">
					<div class="col-md-3">
						<font size="+2"> <label for="Name1" class="form-label">Size:</label>
						</font>
					</div>
					<div class="col-md-5">
						<input type="text" name="size" class="form-control" id="size"
							autocomplete="on" required>

					</div>
				</div>
				<div class="mb-2 row">
					<div class="col-md-3">
						<font size="+2"> <label for="Name1" class="form-label">Image:</label>
						</font>
					</div>
					<div class="col-md-5">
						<input type="url" name="image" class="form-control" id="image"
							autocomplete="on" required>

					</div>
				</div>
				<div class="mb-2 row">
					<div class="col-md-4">
						<button type="submit" id="submit" class="btn btn-primary submit"
							style="width: 90%;">Upload</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div>


		<%
		ArrayList<Product> productList = (ArrayList) session.getAttribute("products");
		%>
		<table style="width: 100%; border: 1px solid black">
			<tr>
				<th>Title</th>
				<th>Quantity</th>
				<th>Size</th>
				<th>Image</th>
				<th>Actions</th>
			</tr>
			<%
			// Iterating through subjectList

			if (session.getAttribute("products") != null) // Null check for the object
			{
				Iterator<Product> iterator = productList.iterator(); // Iterator interface

				while (iterator.hasNext()) // iterate through all the data until the last record
				{
					Product productDetails = iterator.next(); //assign individual employee record to the employee class object
			%>
			<tr>
				<td><%=productDetails.getTitle()%></td>
				<td><%=productDetails.getQuantity()%></td>
				<td><%=productDetails.getSize()%></td>
				<td><img src="<%=productDetails.getImage()%>"
					style="width: 75px; height: 75px"></img></td>
				<td>
					<form style = "width:0%; diplay:inline" action="<%=request.getContextPath()%>/delete">
					<button type="submit" name="delbutton" value = "<%=productDetails.getId()%>">Delete</button>
					</form>
					<form style = "width:0%; diplay:inline">
					<button type="submit">Update</button>
					</form>
			</tr>
			<%
			}
			}
			%>

		</table>
	</div>
</body>
</html>
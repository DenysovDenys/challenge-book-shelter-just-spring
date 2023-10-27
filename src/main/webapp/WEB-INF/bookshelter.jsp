<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>

<html>
<head>
</head>

<style>
	.button {
		background-color: #2cffb8;
		border: none;
		color: black;
		padding: 8px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		cursor: pointer;
		border-radius: 8px;
	}
</style>

<body>
	<div>
		<span style="text-align: center;" onclick="sortTable()">Book Shelter</span>
	</div>
	<br>
	<div>
		<span style="color:red;">${message!}</span>
	</div>
	<div>
		<form action="/" method="post">
			<input type="text" name="bookName" maxlength="10" placeholder="Enter book name"/>
			<input type="date" name="dateOfBook" placeholder="Enter date"/>
			<button class="button" type="submit">Add new book</button>
		</form>
	</div>
	<div>List of books</div>
	<table id="tableOfBooks">
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}. </td>
				<td>${book.bookname}</td>
				<td>&nbsp; ${book.dateofbook}</td>
			</tr>
		</c:forEach>
	</table>

	<script>
		function sortTable() {
			let table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("tableOfBooks");
			switching = true;
			while (switching) {
				switching = false;
				rows = table.rows;
				for (i = 1; i < (rows.length - 1); i++) {
					shouldSwitch = false;
					x = rows[i].getElementsByTagName("TD")[0];
					y = rows[i + 1].getElementsByTagName("TD")[0];
					if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
						shouldSwitch = true;
						break;
					}
				}
				if (shouldSwitch) {
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;
				}
			}
		}
	</script>

</body>
</html>
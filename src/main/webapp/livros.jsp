<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livros</title>
</head>
<body>

	<form action="<c:url value='/checkout'/>" method="post">
		<ul>
			<c:forEach items="${livros}" var="livro">
				<li><input type="radio" name="livro" value="${livro.id}">${livro.nome}
					- ${livro.preco}</li>
			</c:forEach>
		</ul>
		<button type="submit">Comprar</button>
	</form>

</body>
</html>
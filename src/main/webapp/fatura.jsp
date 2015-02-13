<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livros - fatura</title>
</head>
<body>
  
  <form action="<c:url value='/finalizar'/>" method="post">
    <h3>Produtos Selecionados</h3>
    <ul>
      <c:forEach items="${fatura.livros}" var="livro">
        <li>
          ${livro.nome} - ${livro.preco}    
        </li>
      </c:forEach>
    </ul>
    
    <h3>Valor Total da Fatura</h3>
    <label>${fatura.valorTotal}</label>
    <hr/>
    <button type="submit">Finalizar Compra</button>
  </form>
  
</body>
</html>
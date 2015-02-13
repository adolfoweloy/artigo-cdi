package br.com.javamagazine.produtos.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javamagazine.produtos.model.Livro;

/**
 * Servlet implementation which retrieves available books to be sold at books
 * store.
 * 
 * @author aeloy
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    List<Livro> livros = new ArrayList<>();

    livros.add(new Livro("Building Microservices", new BigDecimal("96.00")));
    livros.add(new Livro("Java EE Patterns", new BigDecimal("50.00")));
    livros.add(new Livro("OCM Java EE 6", new BigDecimal("158.27")));

    request.setAttribute("livros", livros);

    request.getRequestDispatcher("/books.jsp").forward(request, response);
  }

}

package br.com.javamagazine.produtos.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javamagazine.produtos.model.RepositorioDeLivros;

/**
 * Servlet implementation which retrieves available books to be sold at books
 * store.
 * 
 * @author aeloy
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  private RepositorioDeLivros repositorio = new RepositorioDeLivros();

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setAttribute("livros", repositorio.todosLivros());
    request.getRequestDispatcher("/livros.jsp").forward(request, response);
    
  }

}

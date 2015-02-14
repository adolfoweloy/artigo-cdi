package br.com.javamagazine.produtos.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javamagazine.produtos.model.CalculadoraDeImpostosPadrao;
import br.com.javamagazine.produtos.model.Fatura;
import br.com.javamagazine.produtos.model.Pedido;
import br.com.javamagazine.produtos.model.RepositorioDeLivros;
import br.com.javamagazine.region.ServerWebServiceClient;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private RepositorioDeLivros repositorio = new RepositorioDeLivros();
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    String[] ids = request.getParameterValues("livro");
    CalculadoraDeImpostosPadrao calculadora = new CalculadoraDeImpostosPadrao(new ServerWebServiceClient());
    Pedido pedido = new Pedido();
    
    for (String idLivroSelecionado : ids) {
      
      try {
        pedido.adicionar(repositorio.getLivro(idLivroSelecionado));
      } catch (Exception e) {
        System.out.println("Enviado um livro que não existe no banco de dados");
      }
      
    }

    Fatura fatura = pedido.gerarFatura(calculadora);
    
    request.setAttribute("fatura", fatura);
    request.getRequestDispatcher("/fatura.jsp").forward(request, response);
  }

}

package br.com.javamagazine.artigo;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javamagazine.pagamento.PagamentoBrasil;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PagamentoBrasil pagamento;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BigDecimal taxaImposto = pagamento.calcularTaxaImposto(BigDecimal.TEN);
		
		PrintWriter writer = response.getWriter();
		writer.print(taxaImposto.toPlainString());
	}
	
}

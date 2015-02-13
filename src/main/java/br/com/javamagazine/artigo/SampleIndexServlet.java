package br.com.javamagazine.artigo;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javamagazine.pagamento.Pagamento;

@WebServlet("/sampleIndex")
public class SampleIndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

//	Esta injecao lanca Ambiguous Dependency ao startar o Tomcat pois o WELD encontra mais de um candidato para Injecao
//	@Inject
//	private Pagamento pagamento;

//	Teriamos que avisar ao CDI em tempo de compilacao que queremos um tipo de pagamento especifico,
//	mas eh exatamente o que gostariamos de evitar
//	@Inject
//	private PagamentoBrasil pagamento;

	@Inject @Any
	private Pagamento pagamento;

	public SampleIndexServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BigDecimal taxaImposto = pagamento.calcularTaxaImposto(BigDecimal.TEN);

		PrintWriter writer = response.getWriter();
		writer.print(taxaImposto.toPlainString());
	}

}

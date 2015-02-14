package br.com.javamagazine.produtos.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeLivros {

  private static final List<Livro> livros = new ArrayList<>();
  
  static {

    livros.add(new Livro(1, "Building Microservices", new BigDecimal("96.00")));
    livros.add(new Livro(2, "Java EE Patterns", new BigDecimal("50.00")));
    livros.add(new Livro(3, "OCM Java EE 6", new BigDecimal("158.27")));

  }
    
  public List<Livro> todosLivros() {
    return livros;
  }
  
  public Livro getLivro(String id) throws Exception {
    
    for (Livro livro : todosLivros()) {
      if (livro.getId() == Integer.parseInt(id)) {
        return livro;
      }
    }
    
    throw new Exception("Livro nao encontrado");
  }
}

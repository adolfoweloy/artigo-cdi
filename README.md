# artigo-cdi
Código fonte criado para escrita do artigo sobre CDI Extensions.
Essa aplicação web fictícia, tem como requisito apresentar um cenário de um sistema que se comporta de maneira
diferente para cada região. Para isso, o sistema utiliza um conjunto de classes que simula o comportamento de um serviço
da Amazon que permite identificar qual região está sendo atendida pela instância da aplicação.

De acordo com cada região, uma classe que realiza o cálculo dos impostos identifica qual a taxa de imposto a ser cobrado
no valor total do pedido.

## branch: simples
Essa branch, possui o código fonte que trata as diferenças entre regiões da maneira mais simples utilizando apenas
estruturas básicas de controle (if, else)

```java
if (bucketLocation.equals(Region.SA_SaoPaulo)) {
    percentual = new BigDecimal("0.15");
} else if(bucketLocation.equals(Region.US_West)) {
    percentual = new BigDecimal("0.04");
}
```

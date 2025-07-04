package br.com.example.ferreira.function;

import br.com.example.ferreira.estoqueProduto.TiposProdutos;

public class ProdutosReceber {
    static TiposProdutos produto = new TiposProdutos();

    public static void receberDados(String nome, String descricao, double valor, int quantidade, String codigo, String validade) {
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setValor(valor);
        produto.setQuantidade(quantidade);
        produto.setCodigo(codigo);
        produto.setValidade(validade);
    }

    public TiposProdutos getProduto() {
        return produto;
    }
}

package br.com.example.ferreira.function;

import br.com.example.ferreira.estoqueProduto.TiposProdutos;

import java.util.List;
import java.util.Optional;

public class ProdutoPesquisa {

    public static Optional<TiposProdutos> pesquisarProduto(String nome, List<TiposProdutos> produtos) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}

package br.com.example.ferreira.function;

import br.com.example.ferreira.estoqueProduto.TiposProdutos;

import java.util.Iterator;
import java.util.List;

public class ProdutoExcluir {
    public static boolean excluirProduto(String nomeProduto, List<TiposProdutos> produtos) {
        Iterator<TiposProdutos> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            TiposProdutos produto = iterator.next();
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

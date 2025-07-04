package br.com.example.ferreira;

import br.com.example.ferreira.estoqueProduto.TiposProdutos;
import br.com.example.ferreira.function.ProdutoPesquisa;
import br.com.example.ferreira.function.ProdutosReceber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;
import java.io.FileWriter;
import java.util.*;

import static br.com.example.ferreira.function.ProdutoExcluir.excluirProduto;
import static br.com.example.ferreira.function.ProdutosReceber.receberDados;

@SpringBootApplication
public class ProjetoEstoqueApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoEstoqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TiposProdutos produto1;
        var produtosReceber = new ProdutosReceber();
        List<TiposProdutos> produtos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("produtos.json");

        if (file.exists()) {
            try {
                produtos = mapper.readValue(file, new com.fasterxml.jackson.core.type.TypeReference<List<TiposProdutos>>() {
                });
            } catch (Exception e) {
                System.out.println("Erro ao ler JSON: " + e.getMessage());
            }
        }

        while (true) {
            System.out.println("============================================");
            System.out.println(" ------ Escolha uma opção [1]-[5] -------");
            System.out.println(" ------ [1] - Adicione um produtos");
            System.out.println(" ------ [2] - Pesquise algum produto");
            System.out.println(" ------ [3] - Remova um produto");
            System.out.println(" ------ [4] - Lista de produtos");
            System.out.println(" ------ [5] - Finalize a seção");
            System.out.println("============================================");
            int opcao1 = sc.nextInt();
            sc.nextLine();
            if (opcao1 == 5) {
                break;
            }

            switch (opcao1) {
                case 1:
                    while (true) {
                        System.out.println(" ------ Você deseja adicionar um produto? ------");
                        System.out.println(" ------ Digite [1] para adicionar um produto ------");
                        System.out.println(" ------ Digite [2] para finalizar a seção ------");
                        int opcao2 = sc.nextInt();
                        sc.nextLine();
                        if (opcao2 == 2) {
                            break;
                        }
                        switch (opcao2) {
                            case 1:
                                System.out.println(" ====== ADICIONAR UM PRODUTO ====== ");
                                System.out.println(" ------ Digite o nome do produto ------");
                                String produtoNome = sc.nextLine();
                                while (produtoNome.trim().isEmpty()) {
                                    System.out.println(" ====== O PRODUTO DEVE TER UM NOME ======");
                                    System.out.println(" ------ Digite o nome do produto ------");
                                    produtoNome = sc.nextLine();
                                }
                                System.out.println(" ------ Digite a descrição do produto ------");
                                String produtoDescricao = sc.nextLine();
                                while (produtoDescricao.trim().isEmpty()) {
                                    System.out.println(" ====== O PRODUTO DEVE TER UMA DESCRIÇÃO ====== ");
                                    System.out.println(" ------ Digite a descrição do produto ------");
                                    produtoDescricao = sc.nextLine();
                                }
                                System.out.println(" ------ Digite o valor da produto(use virgula para cadastrar o produto) ------");
                                double produtoValor = 0;
                                try {
                                    produtoValor = sc.nextDouble();
                                } catch (InputMismatchException e) {
                                    System.out.println(" ------ O PRODUTO FOI CADASTRADO DE MANEIRA INCORRETA ------");
                                }
                                while (produtoValor == 0 || produtoValor < 0) {
                                    System.out.println(" ====== O PRODUTO DEVE TER UM VALOR ======");
                                    System.out.println(" ------ Digite o valor da produto(use virgula para cadastrar o produto) ------");
                                    produtoValor = sc.nextDouble();
                                }
                                System.out.println(" ------ Digite o quantidade de produtos que estão sendo cadastrados ------");
                                sc.nextLine();
                                int produtoQuantidade = sc.nextInt();
                                while (produtoQuantidade == 0) {
                                    System.out.println(" ====== O PRODUTO DEVE TER UMA QUANTIDADE ====== ");
                                    System.out.println(" ------ Digite o quantidade de produtos que estão sendo cadastrados ------");
                                    produtoQuantidade = sc.nextInt();
                                }
                                System.out.println(" ------ Digite o codigo do produto ------");
                                sc.nextLine();
                                String produtoCodigo = sc.nextLine();
                                while (produtoCodigo.trim().isEmpty()) {
                                    System.out.println(" ====== O PRODUTO DEVE TER UM CÓDIGO ====== ");
                                    System.out.println(" ------ Digite o codigo do produto ------");
                                    produtoCodigo = sc.nextLine();
                                }
                                boolean codigoExiste;
                                do {
                                    codigoExiste = false;

                                    for (TiposProdutos produto : produtos) {
                                        if (produto.getCodigo().equalsIgnoreCase(produtoCodigo)) {
                                            codigoExiste = true;
                                            System.out.println(" ------ Código já existente! ------ ");
                                            break;
                                        }
                                    }

                                    if (codigoExiste) {
                                        System.out.println(" ------ Digite o código do produto ------");
                                        produtoCodigo = sc.nextLine();
                                    }

                                } while (codigoExiste);

                                System.out.println(" ------ O produto não precisa necessáriamente ter uma validade ------ ");
                                System.out.println(" ------ Digite a validade do produto(dd/mm/aa) ------");
                                String produtoValidade = sc.nextLine();
                                if (produtoValidade.trim().isEmpty()) produtoValidade = "PRODUTO SEM VALIDADE";
                                receberDados(produtoNome, produtoDescricao, produtoValor, produtoQuantidade, produtoCodigo, produtoValidade);
                                produto1 = produtosReceber.getProduto();
                                produtos.add(produto1);
                                break;

                        }

                    }
                    break;
                case 2:
                    System.out.println(" ------ DIGITE O NOME DO PRODUTO QUE VOCÊ DESEJA PESQUISAR ------ ");
                    String produtoNome2 = sc.nextLine();
                    ProdutoPesquisa.pesquisarProduto(produtoNome2, produtos)
                            .ifPresentOrElse(
                                    p -> System.out.println(p),
                                    () -> System.out.println(" ------ PRODUTO NÃO ENCONTRADO ------ ")
                            );
                    break;

                case 3:
                    System.out.println(" ------ DIGITE O PRODUTO QUE VOCÊ DESEJA EXCLUIR ------ ");
                    var nomeExcluir = sc.nextLine();
                    var saiDoWhile = false;
                    while (saiDoWhile == false) {
                        if (nomeExcluir != null) {
                            System.out.println(" ------ VOCÊ TEM CERTEZA QUE DESEJA EXCLUIR O PRODUTO " + nomeExcluir + "? ------ ");
                            var escolha = sc.nextLine();
                            if (escolha.equalsIgnoreCase("sim")) {
                                excluirProduto(nomeExcluir, produtos);
                                System.out.println(" ------ PRODUTO " + nomeExcluir + " FOI EXCLUIDO COM SUCESSO! ------ ");
                            } else if (escolha.equalsIgnoreCase("nao")) {
                                System.out.println(" ------ OPERAÇÃO DE EXCLUIR PRODUTO CANCELADA COM SUCESSO! ------ ");
                                break;
                            }
                            saiDoWhile = true;
                        } else {
                            System.out.println(" ------ DIGITE O NOME DE UM PRODUTO! ------ ");
                            saiDoWhile = false;
                        }
                        break;
                    }
                    break;
                case 4:
                    System.out.println(" ------ LISTA DE PRODUTOS CADASTRADOS ------");
                    System.out.println("============================================");
                    for (TiposProdutos p : produtos) System.out.println(p);
                    System.out.println("============================================");
                    break;
            }
        }

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new FileWriter("produtos.json"), produtos);
        System.out.println(" ------ PROGRAMA FINALIZADO COM SUCESSO ------ ");
        sc.close();
    }
}

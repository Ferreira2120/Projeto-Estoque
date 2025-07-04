package br.com.example.ferreira.estoqueProduto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TiposProdutos {
    @JsonAlias("nome")
    private String nome;
    @JsonAlias("descricao")
    private String descricao;
    @JsonAlias("valor")
    protected double valor;
    @JsonAlias("quantidade")
    private int quantidade;
    @JsonAlias("codigo")
    private String codigo;
    @JsonAlias("validade")
    private String validade;
    private boolean validar;

    @Override
    public String toString() {
        return "\nNome do Produto: " + getNome() + ". " + "\nDescrição: " + getDescricao() + ". " + "\nValor: " + getValor() + ". " + "\nQuantidade: " + getQuantidade() + ". " + "\nCodigo: " + getCodigo() + ". " + "\nValidade: " + getValidade() + ". " + "\nSituação: " + validar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        if (valor == 0) {
            valor = 0;
        }
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public final String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValidade() {
        if (validade == null) {
            validade = "VALIDADE INDEFINIDA";
        }
        return validade;
    }

    public void setValidade(String validade) {
        if (validade == null) {
            this.validade = " ------ VALIDADE INDEFINIDA ------ ";
        }
        this.validade = validade;
    }



    public double calcularPreco(double valorDoTrans, double valorDoProduto){
        this.valor = valorDoProduto + valorDoTrans;
        return valor;
    }

    public int compraProduto(int retirar) {
        quantidade -= retirar;
        return retirar;
    }
}

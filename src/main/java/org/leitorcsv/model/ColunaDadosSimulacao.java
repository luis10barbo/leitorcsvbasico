package org.leitorcsv.model;

import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;

public class ColunaDadosSimulacao {
    public ColunaDadosSimulacao(String ativo, String abertura, String fechamento, String tempoOperacao, Integer qntCompra, Integer qntVenda, Float precoCompra, Float precoVenda, Float precoMercado, Float medio, Float resIntervalo, Float resIntervaloPorcentagem, Float resOperacaoPorcentagem, Integer total, Integer TET, String nomePapel, Float taxa, String tempo) {
        this.ativo = ativo;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.tempoOperacao = tempoOperacao;
        this.qntCompra = qntCompra;
        this.qntVenda = qntVenda;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.precoMercado = precoMercado;
        this.medio = medio;
        this.resIntervalo = resIntervalo;
        this.resIntervaloPorcentagem = resIntervaloPorcentagem;
        this.resOperacaoPorcentagem = resOperacaoPorcentagem;
        this.total = total;
        this.TET = TET;
        this.nomePapel = nomePapel;
        this.taxa = taxa;
        this.tempo = tempo;
    }

    public String ativo;
    public String abertura;
    public String fechamento;
    public String tempoOperacao;
    public Integer qntCompra;
    public Integer qntVenda;
    public Float precoCompra;
    public Float precoVenda;
    public Float precoMercado;
    public Float medio;
    public Float resIntervalo;
    public Float resIntervaloPorcentagem;
    public Float resOperacaoPorcentagem;
    public Integer total;
    public Integer TET;
    public String nomePapel;
    public Float taxa;
    public String tempo;


    @Override
    public String toString() {
        return "ColunaDadosSimulacao{" +
                "ativo='" + ativo + '\'' +
                ", abertura='" + abertura + '\'' +
                ", fechamento='" + fechamento + '\'' +
                ", tempoOperacao='" + tempoOperacao + '\'' +
                ", qntCompra=" + qntCompra +
                ", qntVenda=" + qntVenda +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                ", precoMercado=" + precoMercado +
                ", medio=" + medio +
                ", resIntervalo=" + resIntervalo +
                ", resIntervaloPorcentagem=" + resIntervaloPorcentagem +
                ", resOperacaoPorcentagem=" + resOperacaoPorcentagem +
                ", total=" + total +
                ", TET=" + TET +
                ", nomePapel='" + nomePapel + '\'' +
                ", taxa=" + taxa +
                ", tempo='" + tempo + '\'' +
                '}';
    }

    public void inserirEmBancoDeDados(Connection bd) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Insercao de dados em banco de dados nao implementado");
    }
}

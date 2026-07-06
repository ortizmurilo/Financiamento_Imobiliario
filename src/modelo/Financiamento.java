package modelo;

import java.io.Serializable;

//1. Criamos a classe financiamento:
public abstract class Financiamento implements Serializable {
    private double valorImovel;//aqui temos os atributos
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    //aqui nos criamos um construtor para iniciar os atributos da classe.
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;


    }

    public double getValorImovel(){
        return valorImovel;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    //Aqui criamos os métodos de cálcuo para o pagamento mensal, e o pagamento total.
    public abstract double pagamentoMensal();

    public double getPagamentoMensal(){
        return pagamentoMensal();
    }

    public double totalPagamento(){
        return (pagamentoMensal() *(prazoFinanciamento * 12));
    }

    public double getTotalPagamento(){
        return totalPagamento();
    }

    public String dadosFinanciamento() {
        String retorno = "";
        retorno += "Valor do imóvel: R$ " + this.valorImovel + "\n";
        retorno += "Prazo: " + getPrazoFinanciamento() + " anos\n";
        retorno += "Taxa: " + getTaxaJurosAnual() + "%\n";
        retorno += "Pagamento total: R$ " + this.getTotalPagamento() + "\n";
        return retorno;
    }

    @Override
    public String toString() {
        return dadosFinanciamento();
    }
}

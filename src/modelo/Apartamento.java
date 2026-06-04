package modelo;

public class Apartamento extends Financiamento {
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double totalPagamento()
    {
        return (getValorImovel()) * (1 + (getTaxaJurosAnual() /100 * getPrazoFinanciamento()));

    }

    public double pagamentoMensal(){
        return (totalPagamento()) / (getPrazoFinanciamento() * 12);
    }

    public void DadosFinanciamento() {
        System.out.println("Tipo de financiamento : APARTAMENTO");
        super.DadosFinanciamento();
    }
}

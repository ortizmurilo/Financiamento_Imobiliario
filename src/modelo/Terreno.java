package modelo;

public class Terreno extends Financiamento {
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public double pagamentoMensal() {
        return super.pagamentoMensal() * 1.02;
    }

    public void DadosFinanciamento() {
        System.out.println("Tipo de financiamento: TERRENO");
        super.DadosFinanciamento();
    }
}

package modelo;

public class Casa extends Financiamento {
    private int valorSeguro = 240;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public int getValorSeguro() {
        return valorSeguro;
    }

    public void DadosFinanciamento() {
        System.out.println("Tipo de financiamento : CASA");
        super.DadosFinanciamento();
        System.out.println("Valor do pagamento mensal com o seguro incluído: " + (pagamentoMensal() + getValorSeguro()));
    }
}

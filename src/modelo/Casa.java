package modelo;

import util.AcrescimoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private int valorSeguro = 240;
    private double valorAcrescimo = 80;
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public int getValorSeguro() {
        return valorSeguro;
    }

    public double getAreaConstruida(){
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }


    private void validarAcrescimoJuros(double valorJuros, double valorAcrescimo) throws AcrescimoMaiorDoQueJurosException {
        if (valorAcrescimo > valorJuros / 2) {
            throw new AcrescimoMaiorDoQueJurosException(
                    "O acréscimo de R$ " + valorAcrescimo + " é maior que a metade dos juros de R$ "
                            + valorJuros + "ajustando valor de acréscimo para o máximo permitido"
            );
        }
    }

    @Override
    public double pagamentoMensal() {
        double parcela     = getValorImovel() / (getPrazoFinanciamento() * 12);
        double jurosMensal = parcela * (getTaxaJurosAnual() / 100 / 12);
        return parcela + jurosMensal;
    }

    public double getJurosMensal() {
        double parcela = getValorImovel() / (getPrazoFinanciamento() * 12);
        return parcela * (getTaxaJurosAnual() / 100 / 12);
    }

    public double totalPagamento(){
        return (pagamentoMensal() + getValorSeguro()) * (getPrazoFinanciamento() * 12);
    }

    @Override

    public String dadosFinanciamento() {
        try {
            validarAcrescimoJuros(getJurosMensal(), valorAcrescimo);
        } catch (AcrescimoMaiorDoQueJurosException e) {
            double maximo = getJurosMensal() / 2;
            System.out.println("Aviso: " + e.getMessage());
            valorAcrescimo = maximo;
        }
        String retorno = "";
        retorno += "Tipo de financiamento : CASA\n";
        retorno += super.dadosFinanciamento();
        retorno += String.format("Valor do pagamento mensal com o seguro incluído: R$ %.2f\n", (pagamentoMensal() + getValorSeguro()));
        retorno += String.format("Valor total do pagamento com o seguro incluído:  R$ %.2f\n", totalPagamento());
        retorno += "Área Construída em Metros Quadrados: " + getAreaConstruida() + "\n";
        retorno += "Tamanho do terreno em Metros Quadrados: " + getTamanhoTerreno() + "\n";

        return retorno;
    }
}

package modelo;

public class Apartamento extends Financiamento {
    private int numeroVagasGaragem;
    private int numeroAndar;


    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public double totalPagamento()
    {
        return (getValorImovel()) * (1 + (getTaxaJurosAnual() /100 * getPrazoFinanciamento()));

    }

    public double pagamentoMensal(){
        return (totalPagamento()) / (getPrazoFinanciamento() * 12);
    }

    public String dadosFinanciamento() {
        String retorno = "";
        retorno += "Tipo de financiamento : APARTAMENTO\n";
        retorno += super.dadosFinanciamento();
        retorno +="Números de vagas na garagem: " + getNumeroVagasGaragem() + "\n";
        retorno += "Número do andar: " + getNumeroAndar() + "\n";
        return retorno;
    }
}

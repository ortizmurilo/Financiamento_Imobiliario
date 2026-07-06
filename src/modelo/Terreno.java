package modelo;

public class Terreno extends Financiamento {
    private int tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public int getTipoZona(){
        return tipoZona;
    }


    public double pagamentoMensal() {
        double pagamentoBase = (getValorImovel() / (getPrazoFinanciamento() * 12))
                * (1 + getTaxaJurosAnual() /100 /12);

        return pagamentoBase * 1.02;
    }

    public String dadosFinanciamento() {
        String retorno = "";
        retorno += "Tipo de financiamento : TERRENO\n";
        retorno += super.dadosFinanciamento();

        String zona;

        if (getTipoZona() == 1) {
            zona = "Residencial";
        } else {
            zona = "Comercial";
        }
        retorno += "Tipo de zona: " + zona + "\n";

        return retorno;
    }
}

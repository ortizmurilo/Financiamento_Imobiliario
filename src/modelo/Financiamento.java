package modelo;

//1. Criamos a classe financiamento:
public class Financiamento {
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
    public double pagamentoMensal()
    {
        return (valorImovel/ (prazoFinanciamento * 12)) * (1+ taxaJurosAnual/12);

    }

    public double getPagamentMensal(){
        return pagamentoMensal();
    }

    public double totalPagamento() {
        return (pagamentoMensal() * prazoFinanciamento * 12);
    }

    public double getTotalPagamento(){
        return totalPagamento();
    }

    public boolean getDadosFinanciamento(){
        System.out.println("Valor do imóvel: R$ " + getValorImovel());
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento() + " anos");
        System.out.println("Taxa de juros anual: " + getTaxaJurosAnual() + "%");
        System.out.println("Pagamento mensal: R$ " + getPagamentMensal());
        System.out.println("Valor total do financiamento: R$ " + getTotalPagamento());
        return false;
    }
}

package main;
import java.util.ArrayList;

import modelo.Financiamento;
import util.InterfaceUsuario;


//3. Aqui esta nossa classe principal, onde criaremos um objeto a partir da classe InterfaceUsuario.
//Pedimos os metodos um a um da classe InterfaceUsuario, logo apos criamos o objeto e atrelamos a ele, o pagamento mensal, e o pagamento total.
public class Main {
    public static void main(String[] args){
    InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

    ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();

    int quantidade = interfaceUsuario.pedirQuantidadeFinanciamentos();

    for (int i = 1; i <= quantidade; i++){
        System.out.println("\n===== FINANCIAMENTO " + i + " =====");
        double valor = interfaceUsuario.pedirValor();
        int prazo = interfaceUsuario.pedirPrazo();
        double taxa = interfaceUsuario.pedirTaxa();

        Financiamento financiamento = new Financiamento(valor, prazo, taxa);
        listaFinanciamentos.add(financiamento);
    }
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        System.out.println("\n===== DADOS DOS FINANCIAMENTOS =====");

        for (Financiamento f : listaFinanciamentos) {

            f.DadosFinanciamento();

            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.getTotalPagamento();

            System.out.println("-----------------------------------");
        }

        System.out.println("\n===== TOTAIS =====");
        System.out.println("Total de todos os imóveis: R$ " + totalImoveis);
        System.out.println("Total de todos os financiamentos: R$ " + totalFinanciamentos);
        interfaceUsuario.fecharScanner();
    }

}
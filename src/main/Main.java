package main;
import java.util.ArrayList;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;


//3. Aqui esta nossa classe principal, onde criaremos um objeto a partir da classe InterfaceUsuario.
//Pedimos os metodos um a um da classe InterfaceUsuario, logo apos criamos o objeto e atrelamos a ele, o pagamento mensal, e o pagamento total.
public class Main {
    public static void main(String[] args){
    InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

    ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();

    int quantidade = interfaceUsuario.pedirQuantidadeFinanciamentos();
    //Aqui irei deixar o loop for funcionando apenas para fim de funcionamento de código.
    //Mas basta o professor digitar 1, para pedir os dados para so um financiamento como o solicitado.
    for (int i = 1; i <= quantidade; i++){
        System.out.println("\n===== FINANCIAMENTO " + i + " =====");

        int tipo = interfaceUsuario.pedirTipoFinanciamento();
        double valor = interfaceUsuario.pedirValor();
        int prazo = interfaceUsuario.pedirPrazo();
        double taxa = interfaceUsuario.pedirTaxa();
        if (tipo == 1 ) {
            System.out.println("==== CASA ====");
            Financiamento financiamento = new Casa(valor, prazo, taxa);
            listaFinanciamentos.add(financiamento);
        } else if (tipo == 2 ) {
            System.out.println(("====APARTAMENTO===="));
            Financiamento financiamento = new Apartamento(valor,prazo, taxa);
            listaFinanciamentos.add(financiamento);
        }
        else if(tipo == 3) {
            System.out.println("====TERRENO====");
            Financiamento financiamento = new Terreno(valor,prazo, taxa);
            listaFinanciamentos.add(financiamento);
        }

    }

        listaFinanciamentos.add(new Casa(300000, 20, 5.0));
        listaFinanciamentos.add(new Apartamento(500000, 15, 4.5));
        listaFinanciamentos.add(new Apartamento(400000, 10, 4.0));
        listaFinanciamentos.add(new Terreno(150000, 10, 6.0));

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
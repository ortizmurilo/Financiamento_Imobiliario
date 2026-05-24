package main;

import modelo.Financiamento;
import util.InterfaceUsuario;


//3. Aqui esta nossa classe principal, onde criaremos um objeto a partir da classe InterfaceUsuario.
//Pedimos os metodos um a um da classe InterfaceUsuario, logo apos criamos o objeto e atrelamos a ele, o pagamento mensal, e o pagamento total.
public class Main {
    public static void main(String[] args){
    InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

    double valor = interfaceUsuario.pedirValor();
    int prazo = interfaceUsuario.pedirPrazo();
    double taxa = interfaceUsuario.pedirTaxa();

    Financiamento f = new Financiamento(valor, prazo, taxa);

    System.out.println(f.getDadosFinanciamento());
    }
}
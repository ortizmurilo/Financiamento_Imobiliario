package util;

import java.util.Scanner;

//2. Criamos nossa segunda classe, onde sera pedido as informacoes necessarias para o usuario
public class InterfaceUsuario{
    public Scanner scanner = new Scanner(System.in);

    public double pedirValor() {
        double valorImovel;

        do {
            System.out.println("Digite o valor do imóvel:");
            valorImovel = scanner.nextDouble();

            if (valorImovel <= 0) {
                System.out.println("Valor inválido! Digite um valor maior que zero.");
            }
        } while (valorImovel <= 0);

        System.out.println("Valor aceito: " + valorImovel);
        return valorImovel;
    }

    public int pedirPrazo() {
        int prazoFinanciamento;

        do {
            System.out.println("Digite o prazo do financiamento (em anos):");
            prazoFinanciamento = scanner.nextInt();

            if (prazoFinanciamento <= 0) {
                System.out.println("Prazo inválido! Digite um valor maior que zero.");
            }
        } while (prazoFinanciamento <= 0);

        System.out.println("Prazo aceito: " + prazoFinanciamento);
        return prazoFinanciamento;
    }

    public double pedirTaxa() {
        double taxaJurosAnual;

        do {
            System.out.println("Digite a taxa de juros anual (%):");
            taxaJurosAnual = scanner.nextDouble();

            if (taxaJurosAnual <= 0) {
                System.out.println("Taxa inválida! Digite um valor maior que zero.");
            }
        } while (taxaJurosAnual <= 0);

        System.out.println("Taxa aceita: " + taxaJurosAnual);
        return taxaJurosAnual;
    }

    public int pedirQuantidadeFinanciamentos() {
        int quantidade;

        do {
            System.out.println("Quantos financiamentos deseja cadastrar?");
            quantidade = scanner.nextInt();

            if (quantidade <= 0) {
                System.out.println("Digite um valor maior que zero.");
            }

        } while (quantidade <= 0);

        return quantidade;
    }

    public void fecharScanner() {
        scanner.close();}
}
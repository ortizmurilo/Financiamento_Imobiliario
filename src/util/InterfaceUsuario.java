package util;

import java.util.InputMismatchException;
import java.util.Scanner;

//2. Criamos nossa segunda classe, onde sera pedido as informacoes necessarias para o usuario
public class InterfaceUsuario{
    public Scanner scanner = new Scanner(System.in);

    public double pedirValor() {
        double valorImovel = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Digite o valor do imóvel:");
                valorImovel = scanner.nextDouble();

                if (valorImovel <= 0) {
                    throw new IllegalArgumentException("Digite um valor maior que zero.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Use apenas números.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("Valor aceito: " + valorImovel);
        return valorImovel;
    }

    public int pedirPrazo() {
        int prazoFinanciamento = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Digite o prazo do financiamento (em anos):");
                prazoFinanciamento = scanner.nextInt();

                if (prazoFinanciamento <= 0) {
                    throw new IllegalArgumentException("Digite um valor maior que zero.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Use apenas números inteiros.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("Prazo aceito: " + prazoFinanciamento);
        return prazoFinanciamento;
    }

    public double pedirTaxa() {
        double taxaJurosAnual = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Digite a taxa de juros anual (%):");
                taxaJurosAnual = scanner.nextDouble();

                if (taxaJurosAnual <= 0) {
                    throw new IllegalArgumentException("Digite um valor maior que zero.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Use apenas números.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("Taxa aceita: " + taxaJurosAnual + "\n");
        return taxaJurosAnual;
    }

    public int pedirQuantidadeFinanciamentos() {
        int quantidade = 0;
        boolean entradaValida = false;

        while(!entradaValida){
            try{
            System.out.println("Quantos financiamentos deseja cadastrar?");
            quantidade = scanner.nextInt();

            if (quantidade <= 0) {
                throw new IllegalArgumentException("Digite um número maior que 0.");
            }
            entradaValida = true;

            }catch (InputMismatchException e){
                System.out.println("Entrada inválida, digite apenas números inteiros.");
                scanner.nextLine();
            }catch (IllegalArgumentException e){
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }

        return quantidade;
    }

    public int pedirTipoFinanciamento() {
        int tipo = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Tipo de financiamento:");
                System.out.println("(1) Casa");
                System.out.println("(2) Apartamento");
                System.out.println("(3) Terreno");

                tipo = scanner.nextInt();

                if (tipo < 1 || tipo > 3) {
                    throw new IllegalArgumentException("Digite 1, 2 ou 3.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Use apenas números inteiros.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida. " + e.getMessage());
                scanner.nextLine();
            }
        }

        return tipo;
    }

    public int pedirTipoZona() {
        int tipoZona = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("\nTipo de Zona:");
                System.out.println("(1) Residencial");
                System.out.println("(2) Comercial");

                tipoZona = scanner.nextInt();

                if (tipoZona < 1 || tipoZona > 2) {
                    throw new IllegalArgumentException("Digite apenas 1 ou 2.");
                }

                entradaValida = true; // só chega aqui se não lançou exceção

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Use apenas números inteiros.");
                scanner.nextLine(); // obrigatório — limpa o lixo do buffer

            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida. " + e.getMessage());
                scanner.nextLine();
            }
        }

        return tipoZona;
    }

    public double pedirAreaConstruida(){
        double areaConstruida = 0.0;
        boolean entradaValida = false;

        while(!entradaValida){
            try{
            System.out.println("Digite o tamanho da área construída em Metros quadrados: ");
            areaConstruida = scanner.nextDouble();

            if(areaConstruida <= 0){
                throw new IllegalArgumentException("A área construída deve ser maior que 0");
            }

            entradaValida = true;

            }catch (InputMismatchException e){
                System.out.println("Entrada inválida. Use apenas números.");
                scanner.nextLine();
            }catch (IllegalArgumentException e){
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }

        return areaConstruida;
    }

    public double pedirTamanhoTerreno() {
        double tamanhoTerreno = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Digite o tamanho do terreno em Metros Quadrados: ");
                tamanhoTerreno = scanner.nextDouble();

                if (tamanhoTerreno <= 0) {
                    throw new IllegalArgumentException("O tamanho deve ser maior que zero.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Use apenas números.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }

        return tamanhoTerreno;
    }

    public int pedirNumeroVagasGaragem() {
        int numeroVagasGaragem = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Digite a quantidade de vagas na garagem: ");
                numeroVagasGaragem = scanner.nextInt();

                if (numeroVagasGaragem < 0) {//aqui eu utilizei apenas menor que zero, pois pode haver imóveis sem vagas, diferentemente de andar, tamanho, etc...
                    throw new IllegalArgumentException("O número de vagas não pode ser negativo.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Use apenas números inteiros.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }

        return numeroVagasGaragem;
    }

    public int pedirNumeroAndar() {
        int numeroAndar = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("Digite o número do andar: ");
                numeroAndar = scanner.nextInt();

                if (numeroAndar <= 0) {
                    throw new IllegalArgumentException("O andar deve ser maior que 0.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Use apenas números inteiros.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }

        return numeroAndar;
    }

    public void fecharScanner() {
        scanner.close();}
}
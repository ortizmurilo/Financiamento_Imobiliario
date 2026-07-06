package main;
import java.util.ArrayList;
import java.io.*;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;


//3. Aqui esta nossa classe principal, onde criaremos um objeto a partir da classe InterfaceUsuario.
//Pedimos os metodos um a um da classe InterfaceUsuario, logo apos criamos o objeto e atrelamos a ele, o pagamento mensal, e o pagamento total.
public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();

        int quantidade = interfaceUsuario.pedirQuantidadeFinanciamentos();
        //Aqui irei deixar o loop for funcionando apenas para fim de funcionamento de código.
        //Mas basta o professor digitar 1, para pedir os dados para so um financiamento como o solicitado.
        for (int i = 1; i <= quantidade; i++) {
            System.out.println("\n===== FINANCIAMENTO " + i + " =====");

            int tipo = interfaceUsuario.pedirTipoFinanciamento();
            double valor = interfaceUsuario.pedirValor();
            int prazo = interfaceUsuario.pedirPrazo();
            double taxa = interfaceUsuario.pedirTaxa();

            if (tipo == 1) {
                double areaConstruida = interfaceUsuario.pedirAreaConstruida();
                double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
                Financiamento financiamento = new Casa(valor, prazo, taxa, areaConstruida, tamanhoTerreno);
                listaFinanciamentos.add(financiamento);
            } else if (tipo == 2) {
                int numeroVagasGaragem = interfaceUsuario.pedirNumeroVagasGaragem();
                int numeroAndar = interfaceUsuario.pedirNumeroAndar();
                Financiamento financiamento = new Apartamento(valor, prazo, taxa, numeroVagasGaragem, numeroAndar);
                listaFinanciamentos.add(financiamento);
            } else if (tipo == 3) {
                int tipoZona = interfaceUsuario.pedirTipoZona();
                Financiamento financiamento = new Terreno(valor, prazo, taxa, tipoZona);
                listaFinanciamentos.add(financiamento);
            }


        }
        escreveFinanciamentos("financiamentos.txt", listaFinanciamentos);
        serializarFinanciamentos("financiamentos.ser", listaFinanciamentos);


        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        System.out.println("\n===== DADOS DOS FINANCIAMENTOS ADICIONADOS =====");

        for (Financiamento f : listaFinanciamentos) {

            System.out.println(f.dadosFinanciamento());

            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.getTotalPagamento();

            System.out.println("-----------------------------------");
        }


        System.out.println("\n===== TOTAIS DOS IMÓVEIS ADICIONADOS =====");
        System.out.println("Total de todos os imóveis: R$ " + totalImoveis);
        System.out.println("Total de todos os financiamentos: R$ " + totalFinanciamentos + "\n");
        interfaceUsuario.fecharScanner();
        System.out.println("Histórico de financiamentos: \n");
        leFinanciamentos();

        System.out.println("\n===== FINANCIAMENTOS LIDOS DO ARQUIVO SERIALIZADO =====");
        ArrayList<Financiamento> listaDesserializada = desserializarFinanciamentos("financiamentos.ser");
        for (Financiamento f : listaDesserializada) {
            System.out.println(f.dadosFinanciamento());
            System.out.println("-----------------------------------");
        }
    }


        public static void escreveFinanciamentos (String filename, ArrayList < Financiamento > listaFinanciamentos){
            FileWriter escritor = null;

            try {
                escritor = new FileWriter(filename);//ao adicionar virgula, podemos usar um parametro para sobrescrever ou escrever após o conteúdo//);

                for (Financiamento f : listaFinanciamentos) {
                    escritor.write(f.toString());
                    escritor.write("-------------------------------------- \n");
                }

                escritor.close();
            } catch (FileNotFoundException e) {
                System.out.println("O arquivo não foi encontrado");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void leFinanciamentos () {
            FileReader leitorArquivos = null;
            try {
                leitorArquivos = new FileReader("financiamentos.txt");
                int caractereLido;
                while ((caractereLido = leitorArquivos.read()) != -1) {
                    System.out.print((char) caractereLido);
                }


                leitorArquivos.close();

            } catch (FileNotFoundException e) {
                System.out.println("O arquivo não foi encontrado");
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        public static void serializarFinanciamentos (String filename, ArrayList < Financiamento > listaFinanciamentos){
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(listaFinanciamentos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public static ArrayList<Financiamento> desserializarFinanciamentos (String filename){
            ArrayList<Financiamento> lista = new ArrayList<>();
            try (ObjectInputStream inp = new ObjectInputStream(new FileInputStream(filename))) {
                lista = (ArrayList<Financiamento>) inp.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return lista;
        }
    }


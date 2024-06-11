import java.util.Scanner;
import java.util.Comparator;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner leitura = new Scanner(System.in);

        ConsultaConversor consulta = new ConsultaConversor();

       int opcao;

       double valorParaConversao;


        do{

            mostrarMenu();

            String moeda_escolhida = "";
            String moeda_base = "";
           opcao = leitura.nextInt();

           switch (opcao) {
               case 1:
                   moeda_base = "USD";
                   moeda_escolhida = "ARS";
                   break;
               case 2:
                   moeda_base = "ARS";
                   moeda_escolhida = "USD";
                   break;
               case 3:
                   moeda_base = "USD";
                   moeda_escolhida = "BRL";
                   break;
               case 4:
                   moeda_base = "BRL";
                   moeda_escolhida = "USD";
                   break;
               case 5:
                   moeda_base = "USD";
                   moeda_escolhida = "COP";
                   break;
               case 6:
                   moeda_base = "COP";
                   moeda_escolhida = "USD";
                   break;
               case 7:
                   System.out.println("Saindo do programa...");
                   break;
               default:
                   System.out.println("Opção inválida. Tente novamente.");
           }


            if (opcao > 0 && opcao < 7 ) {

                System.out.printf("Digite o valor desejado: \n");

                valorParaConversao = leitura.nextFloat();

                var json =  consulta.buscarDados(moeda_escolhida);

                FiltrarMoedas filtro = new FiltrarMoedas();
                var taxaDeConversao = filtro.buscarTaxaParaConversaoPelaMoeda(json.getConversion_rates(), moeda_base);

                Conversor conversor = new Conversor();
                var valorfinal = conversor.calcularValorConversao(taxaDeConversao, valorParaConversao);

                System.out.println("Valor de " + valorParaConversao + " [" + moeda_escolhida + "]" +
                        " corresponde ao valor final >>>>>>>>> " +  valorfinal + " [" + moeda_base + "]\n");
            }


       } while(opcao != 7);

        leitura.close();

    }

    private static void mostrarMenu(){
        System.out.printf(
                "********************************************************** \n" +
                        "Seja bem-vindo/a ao Conversor de Moedas\n\n" +
                        " 1) Dólar =>> Peso argentino\n" +
                        " 2) Peso argentino =>> Dólar\n" +
                        " 3) Dólar =>> Real brasileiro\n" +
                        " 4) Real brasileiro =>> Dólar\n" +
                        " 5) Dólar =>> Peso colombiano\n" +
                        " 6) Peso colombiano =>> Dólar\n" +
                        " 7) Sair\n" +
                        "Escolha uma opção válida: \n" +
                        "********************************************************** \n");

    }
}
import com.aluracursos.desafio.calculos.CalculosDeMoneda;
import com.aluracursos.desafio.modelos.Menus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class ConexionApiDesafio {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/7717239faa6e89c2859e88dd/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        String json =response.body();


        Dictionary listadoValorDolar = new Hashtable();//creación del diccionario
        listadoValorDolar.put("USD","1");//DOLAR POSICION 0
        listadoValorDolar.put("ARS","864.7500");//PESO ARGENTINO IGUAL A DOLAR
        listadoValorDolar.put("BRL","5.1470");//PESO BRALSILERO IGUAL A DOLAR
        listadoValorDolar.put("COP","5.1470");//PESO COLOMBIANO

        CalculosDeMoneda calculosDeMoneda = new CalculosDeMoneda();
        calculosDeMoneda.setListaValorDolar(listadoValorDolar);

        String menuPrincipal = """
                *********************************************
                Sea bienvenido/a al Conversor de Moneda =]
                             
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                *********************************************
                """;
        Menus menu = new Menus();
        menu.setMenuPrincipal(menuPrincipal);
        Scanner scanner = new Scanner(System.in);
        int opc =0;
        double valorAConvertir=0;



        do{
            do{
                System.out.println(menu.getMenuPrincipal());
                opc=scanner.nextInt();

            }while (opc<1 || opc>7);
            switch (opc){
                case 1:
                    System.out.println("Dólar =>> Peso argentino");
                    System.out.println("Ingrese el Cantidad en dolares a convertir en pesos argentinos");

                    valorAConvertir=scanner.nextDouble();
                    calculosDeMoneda.dolarAPesoArgentino(valorAConvertir,listadoValorDolar);
                    System.out.println("El valor en pesos Argentinos es "+calculosDeMoneda.getResultadoConvertido());

                    break;
                case 2:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;

            }


        }while (opc!=7);



    }

    }



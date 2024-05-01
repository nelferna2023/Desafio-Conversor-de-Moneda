import com.aluracursos.desafio.calculos.CalculosDeMoneda;
import com.aluracursos.desafio.modelos.ClaseJson1;
import com.aluracursos.desafio.modelos.Menus;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
        //System.out.println(json);

        Gson gson = new Gson();
        ClaseJson1 claseJson=gson.fromJson(json, ClaseJson1.class);

        /* PRUEBA DE VALORES
        System.out.println("ENCONTRADO EN EL JSON  "  +claseJson.getDocumentation());
        System.out.println("ENCONTRADO EN EL JSON2  "  +claseJson.getResult());
        System.out.println("ENCONTRADO EN EL JSON4  "  +claseJson.getConversion_Rates().getUSD());
        System.out.println("ENCONTRADO EN EL JSON5  "  +claseJson.getConversion_Rates().getARS());
        System.out.println("ENCONTRADO EN EL JSON6  "  +claseJson.getConversion_Rates().getCOP());
        System.out.println("ENCONTRADO EN EL JSON7  "  +claseJson.getConversion_Rates().getBRL());

         */

        CalculosDeMoneda calculosDeMoneda = new CalculosDeMoneda();
        calculosDeMoneda.setValorARS(claseJson.getConversion_Rates().getARS());//Seteamos el valor de 1 dolar en peso argentinos
        calculosDeMoneda.setValorBRL(claseJson.getConversion_Rates().getBRL());
        calculosDeMoneda.setValorCOP(claseJson.getConversion_Rates().getCOP());
        calculosDeMoneda.setValorUSD(claseJson.getConversion_Rates().getUSD());




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
                    System.out.println("Dólar =>> Peso Argentinos");
                    System.out.println("Ingrese la Cantidad en Dolares a convertir en Pesos Argentinos");
                    valorAConvertir = scanner.nextDouble();//leer el valor a convertir
                    if (valorAConvertir==1){
                        System.out.println(String.format("El valor de %.1f [USD]  Dolar en pesos Argentino es %.2f [ARS] "
                                , valorAConvertir, calculosDeMoneda.metodoConversionDollarAARS(valorAConvertir)));
                    }else {
                        System.out.println(String.format("El valor de %.2f [USD]  Dolares en pesos Argentino es %.2f [ARS] "
                                , valorAConvertir, calculosDeMoneda.metodoConversionDollarAARS(valorAConvertir)));
                    }
                    // enviamos el valor al método, y ahi nos retorna el valor convertido
                    break;
                case 2:
                    System.out.println(" Peso Argentino =>> Dólar ");
                    System.out.println("Ingrese la Cantidad de pesos Argentinos a convertir en Dolares  ");
                    valorAConvertir = scanner.nextDouble();//leer el valor a convertir
                    if(valorAConvertir==1) {
                        System.out.println(String.format("El valor de %.1f [ARS] Peso Argentino en dolares es %.2f [USD] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionARSADollar(valorAConvertir)));
                    }else{
                        System.out.println(String.format("El valor de %.1f [ARS] Pesos Argentinos en dolares es %.2f [USD] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionARSADollar(valorAConvertir)));
                    }

                    break;
                case 3:
                    System.out.println(" Dólar =>> Real brasileño ");
                    System.out.println("Ingrese la Cantidad en Dolares a convertir en Reales brasileños ");
                    valorAConvertir = scanner.nextDouble();//leer el valor a convertir
                    if(valorAConvertir==1){
                        System.out.println(String.format("El valor de %.1f [USD] Dolar en Reales Brasileños es %.2f [BRL] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionDollarABRL(valorAConvertir)));
                    }else{
                        System.out.println(String.format("El valor de %.1f [USD]  Dolares en Reales Brasileños es %.2f [BRL] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionDollarABRL(valorAConvertir)));
                    }
                    break;
                case 4:
                    System.out.println(" Real brasileño =>> Dólar ");
                    System.out.println("Ingrese la Cantidad Reales brasileños a convertir en dolares ");
                    valorAConvertir = scanner.nextDouble();//leer el valor a convertir
                    if(valorAConvertir==1){
                        System.out.println(String.format("El valor de %.1f [BRS] Real Brasileño en dolares es %.2f [USD] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionBRLADollar(valorAConvertir)));
                    }else{
                        System.out.println(String.format("El valor de %.1f [BRS] Reales Brasileños en dolares es %.2f [USD] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionBRLADollar(valorAConvertir)));
                    }
                    break;
                case 5:
                    System.out.println(" Dólar =>> Peso colombiano ");
                    System.out.println("Ingrese la Cantidad en Dolares a convertir en Pesos Colombianos ");
                    valorAConvertir = scanner.nextDouble();//leer el valor a convertir
                    if(valorAConvertir==1){
                        System.out.println(String.format("El valor de %.1f [USD] Dolar en Pesos Colombianos es %.2f [COP] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionDollarACOP(valorAConvertir)));
                    }else{
                        System.out.println(String.format("El valor de %.1f [USD] Dolares en Pesos Colombianos es %.2f [COP] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionDollarACOP(valorAConvertir)));
                    }
                    break;
                case 6:
                    System.out.println(" Peso Colombiano =>> Dólar ");
                    System.out.println("Ingrese la Cantidad en Pesos colombianos a convertir en Dolares ");
                    valorAConvertir = scanner.nextDouble();//leer el valor a convertir
                    if (valorAConvertir==1){
                        System.out.println(String.format("El valor de %.2f [COP] Peso Colombiano en dolares es %.2f [USD] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionCOPADollar(valorAConvertir)));
                    }else{
                        System.out.println(String.format("El valor de %.2f [COP] Pesos Colombianos en dolares es %.2f [USD] "
                                ,valorAConvertir,calculosDeMoneda.metodoConversionCOPADollar(valorAConvertir)));
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;

            }


        }while (opc!=7);



    }

    }


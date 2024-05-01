package com.aluracursos.desafio.pruebas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class ConexionApi {
    public static void main(String[] args) throws IOException, InterruptedException {//FORMATO DE CÓDIGO SIEMPRE PARA CONEXIONES API, SOLO DEBE CAMBIARSE LA DIRECCION
        // DE URL QUE OBVIAMENTE DEBE ESTAR CON LA CLAVE DE LA PAGINA DEPENDIDENO DE LA PAGINA
        Scanner scanner = new Scanner(System.in);//Ahora podemos jugar con lo que se puede variar en la pagina, en este caso el nombre de la pelicula "https://www.omdbapi.com/?t=MATRIX&apikey=a48a4ba8"
        System.out.println("Por favor ingrese el nombre de una pelicula");
        String busqueda =scanner.nextLine();
        String direccion = "https://www.omdbapi.com/?t="+busqueda+"&apikey=a48a4ba8";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


    }
}

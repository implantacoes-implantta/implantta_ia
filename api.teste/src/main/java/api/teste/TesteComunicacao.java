/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.teste;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class TesteComunicacao {
    
public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            String json = """
                {
                    "cliente": "Empresa Teste LTDA",
                    "tipoProcesso": "CONVERSÃO",
                    "descricao": "Migração do Mastermaq"
                }
                """;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/teste/analisar"))
                    .header("Content-Type", "application/json")
                    .timeout(Duration.ofSeconds(30))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            System.out.println("Enviando requisição para a API...");
            System.out.println("JSON enviado:");
            System.out.println(json);
            System.out.println("-----------------------------------");

            HttpResponse<String> response = client.send(request, 
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("Status HTTP: " + response.statusCode());
            System.out.println("Resposta da API:");
            System.out.println(response.body());

        } catch (Exception e) {
            System.err.println("Erro na comunicação: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
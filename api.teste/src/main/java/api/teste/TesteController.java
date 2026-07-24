package api.teste;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teste")
public class TesteController {

    @PostMapping("/analisar")
    public String analisarPreparacao(@RequestBody String dados) {
        
        System.out.println("=== Requisição recebida do Java Desktop ===");
        System.out.println(dados);
        System.out.println("===========================================");

        // Resposta simples para teste
        return "{\"status\": \"sucesso\", \"mensagem\": \"Dados recebidos com sucesso!\"}";
    }
}
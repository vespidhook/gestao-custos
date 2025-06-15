package br.dev.brunoalves.gestao_custos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.dev.brunoalves.gestao_custos.custom_messages.ErrorMessage;
import br.dev.brunoalves.gestao_custos.entity.Despesa;
import br.dev.brunoalves.gestao_custos.useCases.BuscarDespesaUseCase;
import br.dev.brunoalves.gestao_custos.useCases.CadastroDespesaUseCase;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

    /**
     * Cadastro de despesa
     * Criar tabela no banco de dados
     * Criar entidade
     */

    @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    @Autowired BuscarDespesaUseCase buscarDespesaUseCase;
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Despesa despesa) {

        try {
            var result = cadastroDespesaUseCase.execute(despesa);
            return ResponseEntity.ok(result);   
        } catch (IllegalArgumentException e) {
            var errorMessage = new ErrorMessage(e.getMessage(), "VALIDATION_ERROR");
            return ResponseEntity.status(400).body(errorMessage);
        }
    }

    // /gestao/find/brunoalves@outlook.com?data=2025-01-01
    @GetMapping("/find/{email}")
    public List<Despesa> findByEmailAndDate(@PathVariable String email, @RequestParam(required = false) LocalDate data) {
        return buscarDespesaUseCase.excute(email, data);
    }

}

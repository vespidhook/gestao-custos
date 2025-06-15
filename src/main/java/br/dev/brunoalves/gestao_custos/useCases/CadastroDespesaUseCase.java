package br.dev.brunoalves.gestao_custos.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.brunoalves.gestao_custos.entity.Despesa;
import br.dev.brunoalves.gestao_custos.repository.DespesaRepository;

@Service
public class CadastroDespesaUseCase {
    // SOLID
    // Single Responsibility Principle (SRP): Esta classe tem a responsabilidade única de cadastrar uma despesa.

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa execute(Despesa despesa) {

        if(despesa.getDescricao() == null || despesa.getValor() == null || despesa.getCategoria() == null || despesa.getEmail() == null || despesa.getData() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }

        despesa = despesaRepository.save(despesa);
        return despesa;
    }   
}

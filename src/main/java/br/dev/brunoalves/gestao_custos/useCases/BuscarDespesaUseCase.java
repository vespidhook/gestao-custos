package br.dev.brunoalves.gestao_custos.useCases;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.brunoalves.gestao_custos.entity.Despesa;
import br.dev.brunoalves.gestao_custos.repository.DespesaRepository;
    
@Service
public class BuscarDespesaUseCase {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> excute(String email, LocalDate data) {        

        List<Despesa> despesas;
        if(data != null) {
            despesas = despesaRepository.findByEmailAndData(email, data);
        } else {
            despesas = despesaRepository.findByEmail(email);
        }
        return despesas;
    }
    
}

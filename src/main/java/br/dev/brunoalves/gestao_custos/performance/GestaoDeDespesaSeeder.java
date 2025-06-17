package br.dev.brunoalves.gestao_custos.performance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.dev.brunoalves.gestao_custos.entity.Despesa;
import br.dev.brunoalves.gestao_custos.repository.DespesaRepository;

// @Component
public class GestaoDeDespesaSeeder implements CommandLineRunner {

    @Autowired
    DespesaRepository despesaRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Despesa> despesas = new ArrayList<>();
        System.out.println("Iniciando a inserção de despesas seed...");

        for (int i =0; i <= 150000; i++) {
            Despesa despesa = new Despesa();
            despesa.setDescricao("Gasto nº: " + i);
            despesa.setValor(BigDecimal.valueOf(10 + (i % 50)));
            despesa.setData(LocalDate.now().minusDays((i % 30)));
            despesa.setCategoria("Categoria " + (i % 5));
            despesa.setEmail("usuario" + (i % 100) + "@exemplo.com");

            despesas.add(despesa);
        }
        despesaRepository.saveAll(despesas);
        System.out.println("Inserção de despesas seed concluída. Total de despesas inseridas: " + despesas.size());
    }

}

package br.com.italo.biblioteca.recurso.configuracao;

import br.com.italo.biblioteca.servico.configuracao.BdTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class BdTestRecurso {

    @Autowired
    private BdTestService bdTestService;

    @Bean
    public void inserirDados(){
        bdTestService.popularDados();
    }
}

package br.org.helpet.listaadocao.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initData(AnimaisRepository repository) {
        return args ->{
            //Inserção de dados iniciais no banco
            Animais animal1 = new Animais("cachorro", "macho", "raça não definida");
            Animais animal2 = new Animais("gato", "fêmea", "siamês");

            log.info("Inserindo: " + repository.save(animal1));
            log.info("Inserindo: " + repository.save(animal2));
    };
}

    @Bean
    CommandLineRunner initData(LarTempRepository repository) {
        return args ->{
            //Inserção de dados iniciais no banco
            LarTemp larTemp1 = new LarTemp("Maurício", "123.123.123-50", "12 997895642");
            LarTemp larTemp2 = new LarTemp("Joana", "111.222.333-44", "(11) 98877-6655");

            log.info("Inserindo: " + repository.save(larTemp1));
            log.info("Inserindo: " + repository.save(larTemp2));
    };
}
}
